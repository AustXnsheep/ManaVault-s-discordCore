package austxnsheep.main.verification.commands;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import austxnsheep.main.dataManager.PlayerDataConfig;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Objects;

public class DiscordVerify extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Core core = new Core();
        if (event.getChannel().getId().equals("1117930951385808947")) {
            if (!event.getAuthor().isBot()) {
                String[] args = event.getMessage().getContentRaw().substring(1).split(" ");
                String command = args[0];
                if (command=="!verify") {
                    String code;
                    Player player;
                    //int score = (int) playerDataConfig.loadData(player, "score");\
                    PlayerDataConfig pdc = new PlayerDataConfig();
                    String playerName = args[1];
                    String sentCode = args[2];
                    player = Bukkit.getPlayer(playerName);
                    if (pdc.containsData(player, "verificationkey")) {
                        core.sendToDiscordWithoutPlayer(Main.jda, "", "VERIFICATION_INFO", "1117930951385808947", "Could not find your code try doing the command ingame again and double check you've typed everything right.");
                    }
                    core.sendToDiscordWithoutPlayer(Main.jda, "", "VERIFICATION_INFO", "1117930951385808947", "Attempting to verify you.");
                    code = (String) pdc.loadData(player, "verificationkey");
                    if (Objects.equals(sentCode, code)) {
                        core.sendToDiscordWithoutPlayer(Main.jda, "", "VERIFICATION_INFO", "1117930951385808947", "Verified. Welcome " + playerName);
                    } else {
                        core.sendToDiscordWithoutPlayer(Main.jda, "", "VERIFICATION_INFO", "1117930951385808947", "Failed to verify. Try again.");
                    }
                }
            }
        }
    }
}
