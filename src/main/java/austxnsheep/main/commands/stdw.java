package austxnsheep.main.commands;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class stdw implements Core, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            sender.sendMessage(command.getName() + args[0], args[1], args[2], args[3]);
            String arg1 = args[0];
            String arg2 = args[1];
            String arg3 = args[2];
            String msg = String.join(" ", Arrays.copyOfRange(args, 3, args.length));
            sendToDiscordWithoutPlayer(Main.jda, arg1,arg2, arg3, msg);
            return true;
        }
        return false;
    }
}
