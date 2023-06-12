package austxnsheep.main.dataManager;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerDataConfig {
    private File configFile;
    private YamlConfiguration config;

    public PlayerDataConfig() {
        configFile = new File("plugins/YourPlugin/playerdata.yml");
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
}
