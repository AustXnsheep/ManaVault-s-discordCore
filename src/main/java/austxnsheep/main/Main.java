package austxnsheep.main;

import austxnsheep.main.Listeners.*;
import austxnsheep.main.commands.std;
import austxnsheep.main.commands.stdw;
import austxnsheep.main.dataManager.PlayerDataConfig;
import austxnsheep.main.verification.VerificationCore;
import austxnsheep.main.verification.commands.DiscordVerify;
import austxnsheep.main.verification.commands.Verify;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

import static net.dv8tion.jda.api.requests.GatewayIntent.MESSAGE_CONTENT;

public final class Main extends JavaPlugin {
    //1116988575737720841
    public ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner();
    public Core core = new Core();
    public PlayerDataConfig pdc = new PlayerDataConfig();
    public static String token = "Some guys token";
    public static JDA jda = JDABuilder.createDefault(token)
            .enableIntents(MESSAGE_CONTENT)
            .addEventListeners(new onMessageReceive())
            .addEventListeners(new DiscordVerify())
            .build();
    @Override
    public void onEnable() {
        this.registerCommand(new std(), "std");
        this.registerCommand(new stdw(), "stdw");
        this.registerCommand(new Verify(), "verify");
        this.registerEvent(new PlayerJoin());
        this.registerEvent(new PlayerLeave());
        this.registerEvent(new PlayerChat());
        new BukkitRunnable() {
            @Override
            public void run() {
                scheduledTaskRunner.startUpdatingEvent();
            }
        }.runTaskLater(this, 1000);
    }

    @Override
    public void onDisable() {
        Core core = new Core();
        //sendToDiscordWithoutPlayer(Main.jda, top message, bottom message, channel id, long message)
        core.sendToDiscordWithoutPlayer(Main.jda, "","SERVER_UNLOAD", "1116988576127787124", "Server is stopping...");

    }
    void registerEvent(Listener listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }
    void registerCommand(CommandExecutor commandExecutor, String commandName) {
        Objects.requireNonNull(this.getCommand(commandName)).setExecutor(commandExecutor);
    }
}
