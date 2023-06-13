package austxnsheep.main.dataManager;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerDataConfig {
    private File configFile;
    private YamlConfiguration config;

    public PlayerDataConfig() {
        configFile = new File("plugins/discordcore/playerdata.yml");
        Core core = new Core();

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                //sendToDiscordAsError(Main.jda, top message, bottom message, long message) It always sends to the private channel.
                core.sendToDiscordAsError(Main.jda, "ID #1", "UNKNOWN_ERROR", String.valueOf(e));
            }
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveData(Player player, String dataKey, Object data) {
        String playerUUID = player.getUniqueId().toString();
        config.set(playerUUID + "." + dataKey, data);

        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object loadData(Player player, String dataKey) {
        String playerUUID = player.getUniqueId().toString();
        return config.get(playerUUID + "." + dataKey);
    }

    public boolean containsData(Player player, String dataKey) {
        String playerUUID = player.getUniqueId().toString();
        return config.contains(playerUUID + "." + dataKey);
    }
}
