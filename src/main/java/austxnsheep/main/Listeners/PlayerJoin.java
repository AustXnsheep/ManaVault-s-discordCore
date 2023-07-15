package austxnsheep.main.Listeners;

import austxnsheep.main.Core;
import austxnsheep.main.DiscordMessageBuilder;
import austxnsheep.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Core, Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().getName();
        DiscordMessageBuilder dmb = new DiscordMessageBuilder("1116988576127787124", e.getPlayer());
        dmb.setMessage("Welcome " + e.getPlayer().getName() + " to the server");
        dmb.setMessagedetails("JOIN_EVENT");
        dmb.sendMessage();
        sendToDiscordWithPlayer(Main.jda, e.getPlayer().getName(), "JOIN_EVENT", "1116988576127787124", "Welcome " + e.getPlayer().getName() + " to the server");
    }
}
