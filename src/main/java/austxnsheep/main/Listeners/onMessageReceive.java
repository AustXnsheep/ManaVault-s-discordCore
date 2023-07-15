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
import org.bukkit.entity.Player;

import java.util.Objects;

public class onMessageReceive extends ListenerAdapter implements Core {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getChannel().getId().equals("1116988575737720841")) {
            if (!event.getAuthor().isBot()) {
                if (Objects.requireNonNull(event.getMember()).hasPermission(Permission.ADMINISTRATOR)) {
                    executeConsoleCommand(event.getMessage().getContentRaw());
                }
            }
        }
        if (event.getChannel().getId().equals("1116988576127787124")) {
            if (!event.getAuthor().isBot()) {
                String msg = ChatColor.AQUA + "DISCORD " + ChatColor.GOLD + Objects.requireNonNull(event.getAuthor()).getName() + ChatColor.WHITE + " " + event.getMessage().getContentRaw();
                Bukkit.broadcastMessage(msg);
            }
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!ServerInfo")) {
            ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner();
            double averageping = scheduledTaskRunner.getAveragePing();
            int amountofplayers = Bukkit.getOnlinePlayers().size();
            double tps = Bukkit.getServer().getTPS()[0];
            float uptimeinhours = scheduledTaskRunner.getUptime();
            Main.jda.getPresence().setStatus(OnlineStatus.ONLINE);
            String serverinfo = "ManaVault.minehut.gg\nPlayers: " + amountofplayers + "\nTPS: " + tps + "\nAverage Ping: " + averageping + "\nUptime: " + uptimeinhours;
            sendToDiscordWithoutPlayer(Main.jda, "ManaVault\nManaVault.minehut.gg", "SERVER_INFO", event.getChannel().getId(), serverinfo);
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!PlayerList")) {
            StringBuilder msg = new StringBuilder();
            for (Player player : Bukkit.getOnlinePlayers()) {
                msg.append(player.getName()).append(" ");
            }
            sendToDiscordWithoutPlayer(Main.jda, "ManaVault\nManaVault.minehut.gg", "SERVER_INFO", event.getChannel().getId(), msg.toString());
        }
    }
}
