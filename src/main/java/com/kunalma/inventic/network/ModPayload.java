package com.kunalma.inventic.network;

import com.kunalma.inventic.Inventic;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record ModPayload() implements CustomPacketPayload {

    public static final Type<ModPayload> TYPE =
            new Type<>(
                    ResourceLocation.fromNamespaceAndPath(Inventic.MODID, "open_crafting")
            );

    public static final StreamCodec<ByteBuf, ModPayload> STREAM_CODEC = StreamCodec.unit(new ModPayload());

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
