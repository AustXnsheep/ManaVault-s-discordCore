package austxnsheep.main;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskRunner implements Core {
    public Timer timer;

    public void startUpdatingEvent() {
        timer = new Timer();
        int intervalInSeconds = 10;
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
        float averageping = getAveragePing();
        int amountofplayers = Bukkit.getOnlinePlayers().size();
        double tps = Bukkit.getServer().getTPS()[0];
        long uptimeinhours = TimeUnit.MILLISECONDS.toHours(getUptime());
        Main.jda.getPresence().setStatus(OnlineStatus.ONLINE);
        Main.jda.getPresence().setActivity(Activity.playing("ManaVault \nPlayers: " + amountofplayers + " \nTPS: " + Math.round(tps) + " \nUptime: " + Math.round(uptimeinhours) + "H"));
        if(tps<=10) {
            stopUpdatingEvent();
            sendToDiscordWithoutPlayer(Main.jda, "TPS: "  + tps, "SERVER_UPDATE", "1116988576127787124", "Low tps warning. Stopping Updating.");
        }
        if(averageping>=300) {
            stopUpdatingEvent();
            sendToDiscordWithoutPlayer(Main.jda, "Average player ping: " + averageping, "SERVER_UPDATE", "1116988576127787124", "High ping warning. Stopping Updating.");
        }
    }

    public void stopUpdatingEvent() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
