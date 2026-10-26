package com.kunalma.inventic;

import com.kunalma.inventic.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.BiFunction;

@Mod(Inventic.MODID)
public class Inventic {

    public static final String MODID = "inventic";

    public Inventic(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static boolean isCraftingTable(Item item) {
        return Config.craftingTableItems.contains(item);
    }

    public static void openCraftingTable(Player player) {
        if (!player.getInventory().contains(
                stack -> isCraftingTable(stack.getItem())
        )) {
            return;
        }

        player.openMenu(new MenuProvider() {
            @Override
            public @NotNull Component getDisplayName() {
                return Component.translatable("container.crafting");
            }

            @Override
            public @NotNull AbstractContainerMenu createMenu(
                    int syncId,
                    @NotNull Inventory playerInv,
                    @NotNull Player player
            ) {
                return new CraftingMenu(
                        syncId,
                        playerInv,
                        new ContainerLevelAccess() {
                            public <T> @NotNull Optional<T> evaluate(
                                    @NotNull BiFunction<Level, BlockPos, T> func
                            ) {
                                return Optional.of(
                                        func.apply(
                                                player.level(),
                                                player.blockPosition()
                                        )
                                );
                            }
                        }
                ) {
                    public boolean stillValid(@NotNull Player player) {
                        return !Config.requireInInv ||
                                playerInv.contains(
                                        stack -> isCraftingTable(stack.getItem())
                                ) ||
                                this.getCarried().is(
                                        holder -> isCraftingTable(holder.value())
                                );
                    }
                };
            }
        });
    }
}
