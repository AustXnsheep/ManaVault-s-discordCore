package austxnsheep.main.Listeners;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        e.getPlayer().getName();
        Core core = new Core();
        core.sendToDiscordWithPlayer(Main.jda, e.getPlayer().getName(), "QUIT_EVENT", "1116988576127787124", "Goodbye " + e.getPlayer().getName());
    }
}
