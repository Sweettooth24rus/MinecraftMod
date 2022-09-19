package com.kkoz.kkozmod;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber
public class Notification {



    @SubscribeEvent
    public static void onEvent(EntityJoinWorldEvent event) {
        boolean sent = false;
        if ((event.getEntity() instanceof Player)) {
            Connection connection = new Connection();
            connection.connect();
        }
    }

    public static void sendMessage(String message) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendMessage(new TextComponent(message), UUID.randomUUID());
    }
}