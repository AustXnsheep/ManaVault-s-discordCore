package austxnsheep.main.Listeners;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChat implements Listener {
    @EventHandler
    public void onPlayerMessage(PlayerChatEvent e) {
        Core core = new Core();
        String msg = e.getMessage();
        //core.sendToDiscordWithPlayer(Main.jda, message on top, bottom message, channel id, Long message);
        core.sendToDiscordWithPlayer(Main.jda, e.getPlayer().getName(), "PLAYER_CHAT", "1116988576127787124", msg);
    }
}
