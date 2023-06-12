package austxnsheep.main.Listeners;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().getName();
        Core core = new Core();
        core.sendToDiscordWithPlayer(Main.jda, e.getPlayer().getName(), "JOIN_EVENT", "1116988576127787124", "Welcome " + e.getPlayer().getName() + " to the server");
    }
}
