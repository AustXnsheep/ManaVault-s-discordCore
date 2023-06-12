package austxnsheep.main.verification.commands;

import austxnsheep.main.dataManager.PlayerDataConfig;
import austxnsheep.main.verification.VerificationCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Verify implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        PlayerDataConfig pdc = new PlayerDataConfig();
        VerificationCore verificationCore = new VerificationCore();
        String code = verificationCore.giveRandomCode();
        sender.sendMessage("Here is your verification code (Don't share it with anybody!): " + code);
        pdc.saveData((Player) sender, "verificationkey", code);
        return false;
    }
}
