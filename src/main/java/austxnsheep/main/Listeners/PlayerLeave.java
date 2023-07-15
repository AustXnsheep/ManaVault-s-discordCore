package austxnsheep.main.Listeners;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Core, Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        e.getPlayer().getName();
        sendToDiscordWithPlayer(Main.jda, e.getPlayer().getName(), "QUIT_EVENT", "1116988576127787124", "Goodbye " + e.getPlayer().getName());
    }
}
