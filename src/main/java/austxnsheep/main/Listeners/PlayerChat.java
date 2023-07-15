package austxnsheep.main.Listeners;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChat implements Core, Listener {
    @EventHandler
    public void onPlayerMessage(PlayerChatEvent e) {
        String msg = e.getMessage();
        sendToDiscordWithPlayer(Main.jda, e.getPlayer().getName(), "PLAYER_CHAT", "1116988576127787124", msg);
    }
}
