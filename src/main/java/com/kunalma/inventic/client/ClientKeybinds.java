package com.kunalma.inventic.client;

import com.kunalma.inventic.Inventic;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = Inventic.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientKeybinds {

    public static final KeyMapping OPEN_CRAFTING_TABLE =
            new KeyMapping(
                    "key.inventic.open_crafting",
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_Z,
                    "key.categories.inventic"
            );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(OPEN_CRAFTING_TABLE);
    }
}
