package com.kunalma.inventic.network;

import com.kunalma.inventic.Inventic;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@EventBusSubscriber(modid = Inventic.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Network {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final var registrar = event.registrar("1");

        registrar.playToServer(ModPayload.TYPE, ModPayload.STREAM_CODEC, (payload, context) -> {
            Player player = context.player();

            if (player.level().isClientSide()) {
                return;
            }

            context.enqueueWork(() -> Inventic.openCraftingTable(player));
        });
    }
}
