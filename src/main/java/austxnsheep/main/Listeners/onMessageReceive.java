package austxnsheep.main.Listeners;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import austxnsheep.main.ScheduledTaskRunner;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Objects;

public class onMessageReceive extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Core core = new Core();
        if (event.getChannel().getId().equals("1116988575737720841")) {
            if (!event.getAuthor().isBot()) {
                if (Objects.requireNonNull(event.getMember()).hasPermission(Permission.ADMINISTRATOR)) {
                    core.executeConsoleCommand(event.getMessage().getContentRaw());
                }
            }
        }
        if (event.getChannel().getId().equals("1116988576127787124")) {
            if (!event.getAuthor().isBot()) {
                String msg = ChatColor.AQUA + "DISCORD " + ChatColor.WHITE + "<" + Objects.requireNonNull(event.getAuthor()).getName() + "> " + event.getMessage().getContentRaw();
                Bukkit.broadcastMessage(msg);
            }
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!ServerInfo")) {
            ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner();
            double averageping = scheduledTaskRunner.getAveragePing();
            int amountofplayers = Bukkit.getOnlinePlayers().size();
            double tps = Bukkit.getServer().getTPS()[0];
            float uptimeinhours = scheduledTaskRunner.getUptime();
            //sendToDiscordWithoutPlayer(Main.jda, top message, bottom message, channel id, long message)
            Main.jda.getPresence().setStatus(OnlineStatus.ONLINE);
            String serverinfo = "ManaVault.minehut.gg\nPlayers: " + amountofplayers + "\nTPS: " + tps + "\nAverage Ping: " + averageping + "\nUptime: " + uptimeinhours;
            //core.sendToDiscordWithPlayer(Main.jda, message on top, bottom message, channel id, Long message);
            core.sendToDiscordWithoutPlayer(Main.jda, "ManaVault\nManaVault.minehut.gg", "SERVER_INFO", "1116988576127787124", serverinfo);
        }
    }
}
