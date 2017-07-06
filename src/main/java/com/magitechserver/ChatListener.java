package com.magitechserver;

import br.net.fabiozumbi12.UltimateChat.API.SendChannelMessageEvent;
import com.magitechserver.util.Config;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;

/**
 * Created by Frani on 05/07/2017.
 */
public class ChatListener extends DiscordHandler {

    @Listener
    public void onMessage(SendChannelMessageEvent e) {

        if (e.getChannel().getName().equalsIgnoreCase("global")) {
            if (e.getSender() instanceof Player) {
                String content = e.getMessage();
                String sender = e.getSender().getName();
                String message = "**" + sender + "**: " + content;
                sendMessageToChannel(Config.DISCORD_MAIN_CHANNEL, message);
            }
        }

        if (Config.DISCORD_STAFF_CHANNEL != null && e.getChannel().getName().equalsIgnoreCase("staff")) {
            if (e.getSender() instanceof Player) {
                String content = e.getMessage();
                String sender = e.getSender().getName();
                String message = "**" + sender + "**: " + content;
                sendMessageToChannel(Config.DISCORD_STAFF_CHANNEL, message);
            }
        }
    }
}
