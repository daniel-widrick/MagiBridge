package com.magitechserver.magibridge.listeners;

import com.magitechserver.magibridge.DiscordHandler;
import com.magitechserver.magibridge.MagiBridge;
import com.magitechserver.magibridge.NucleusHandler;
import com.magitechserver.magibridge.util.FormatType;
import com.magitechserver.magibridge.util.GroupUtil;
import com.magitechserver.magibridge.util.ReplacerUtil;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.advancement.AdvancementEvent;
import org.spongepowered.api.event.filter.cause.Root;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frani on 14/07/2017.
 */
public class AdvancementListener {

    @Listener
    public void onAdvancement(AdvancementEvent event, @Root Player p) {
        if (!p.hasPermission("magibridge.chat")) return;
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("%player%", p.getName());
        placeholders.put("%nick%", NucleusHandler.getNick(p));
        placeholders.put("%advancement%", event.getAdvancement().getName());
        placeholders.put("%prefix%", p.getOption("prefix").orElse(""));
        placeholders.put("%topgroup%", GroupUtil.getHighestGroup(p));

        DiscordHandler.sendMessageToChannel(MagiBridge.getConfig().CHANNELS.MAIN_CHANNEL,
                ReplacerUtil.replaceEach(FormatType.ADVANCEMENT_MESSAGE.get(), placeholders));
    }
}
