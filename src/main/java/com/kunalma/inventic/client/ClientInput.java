package com.kunalma.inventic.client;

import com.kunalma.inventic.Inventic;
import com.kunalma.inventic.network.ModPayload;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = Inventic.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
public class ClientInput {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        while (com.kunalma.inventic.client.ClientKeybinds.OPEN_CRAFTING_TABLE.consumeClick()) {

            Minecraft minecraft = Minecraft.getInstance();

            if (minecraft.player == null) {
                continue;
            }

            if (!minecraft.player.getInventory().contains(stack -> Inventic.isCraftingTable(stack.getItem()))) {
                continue;
            }

            PacketDistributor.sendToServer(new ModPayload());
        }
    }
}
