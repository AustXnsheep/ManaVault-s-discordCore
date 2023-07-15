package austxnsheep.main.commands;

import austxnsheep.main.Core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class discord implements Core, CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String message = "Click here to visit the discord:";
        String link = "https://discord.gg/R4nkKnjjHy";
        sendClickableLink((Player) sender, message, link);
        return false;
    }
}
