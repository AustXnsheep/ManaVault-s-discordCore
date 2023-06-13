package austxnsheep.main;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Timer;
import java.util.TimerTask;

public class ScheduledTaskRunner {
    public Timer timer;
    public Core core = new Core();

    public void startUpdatingEvent() {
        timer = new Timer();
        int intervalInSeconds = 1;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateEvent();
           }
        }, 0, intervalInSeconds * 1000L);
    }

    public long getUptime() {
        return (int) System.currentTimeMillis();
    }
    public float getAveragePing() {
        float totalPing = 0;
        float playerCount = 0;

        for (Player player : Bukkit.getOnlinePlayers()) {
            float ping = player.getPing();
            totalPing += ping;
            playerCount++;
        }
        return totalPing / playerCount;
    }

    public void updateEvent() {
        //Core core = new Core();
        float averageping = getAveragePing();
        int amountofplayers = Bukkit.getOnlinePlayers().size();
        double tps = Bukkit.getServer().getTPS()[0];
        long uptimeinhours = (int) getUptime();
        //sendToDiscordWithoutPlayer(Main.jda, top message, bottom message, channel id, long message)
        Main.jda.getPresence().setStatus(OnlineStatus.ONLINE);
        Main.jda.getPresence().setActivity(Activity.playing("ManaVault \nPlayers: " + amountofplayers + " \nTPS: " + Math.round(tps) + " \nUptime: " + uptimeinhours + "MS"));
        if(tps<=10) {
            //sendToDiscordWithoutPlayer(JDA jda, String h1, String h2, String id, String title)
            stopUpdatingEvent();
            core.sendToDiscordWithoutPlayer(Main.jda, "TPS: "  + tps, "SERVER_UPDATE", "1116988576127787124", "Low tps warning.");
        }
        if(averageping>=300) {
            stopUpdatingEvent();
            core.sendToDiscordWithoutPlayer(Main.jda, "Average player ping: " + averageping, "SERVER_UPDATE", "1116988576127787124", "High ping warning.");
        }
    }

    public void stopUpdatingEvent() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
