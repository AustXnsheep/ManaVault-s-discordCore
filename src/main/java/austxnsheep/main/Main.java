package austxnsheep.main;

import austxnsheep.main.Listeners.*;
import austxnsheep.main.commands.discord;
import austxnsheep.main.commands.std;
import austxnsheep.main.commands.stdw;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

import static net.dv8tion.jda.api.requests.GatewayIntent.MESSAGE_CONTENT;

public final class Main extends JavaPlugin implements Core {
    public ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner();
    public static String token = "";
    public static JDA jda = JDABuilder.createDefault(token)
            .enableIntents(MESSAGE_CONTENT)
            .addEventListeners(new onMessageReceive())
            .build();
    @Override
    public void onEnable() {
        this.registerCommand(new std(), "std");
        this.registerCommand(new stdw(), "stdw");
        this.registerCommand(new discord(), "discord");
        this.registerEvent(new PlayerJoin());
        this.registerEvent(new PlayerLeave());
        this.registerEvent(new PlayerChat());
        sendToDiscordWithoutPlayer(Main.jda, "","SERVER_LOAD", "1116988576127787124", "Server is starting...");
        new BukkitRunnable() {
            @Override
            public void run() {
                scheduledTaskRunner.startUpdatingEvent();
            }
        }.runTaskLater(this, 1000);
    }

    @Override
    public void onDisable() {
        //sendToDiscordWithoutPlayer(Main.jda, top message, bottom message, channel id, long message)
        sendToDiscordWithoutPlayer(Main.jda, "","SERVER_UNLOAD", "1116988576127787124", "Server is stopping...");

    }
    void registerEvent(Listener listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }
    void registerCommand(CommandExecutor commandExecutor, String commandName) {
        Objects.requireNonNull(this.getCommand(commandName)).setExecutor(commandExecutor);
    }
}
