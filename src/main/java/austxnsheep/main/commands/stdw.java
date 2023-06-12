package austxnsheep.main.commands;

import austxnsheep.main.Core;
import austxnsheep.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class stdw implements CommandExecutor {
    //core.sendToDiscordWithoutPlayer(Main.jda, "","SERVER_UNLOAD", "1116988576127787124", "Server is stopping...");
    @Override
    ///std austxnsheep austxnsheep2 1116988576127787124 austxnsheep3 3333
    //core.sendToDiscordWithPlayer(Main.jda, message on top, bottom message, channel id, Long message);
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            //sendToDiscord(JDA jda, String player, String h1, String h2, String title)
            sender.sendMessage(command.getName() + args[0], args[1], args[2], args[3]);
            Core core = new Core();
            String arg1 = args[0];
            String arg2 = args[1];
            String arg3 = args[2];
            String msg = String.join(" ", Arrays.copyOfRange(args, 3, args.length));
            core.sendToDiscordWithoutPlayer(Main.jda, arg1,arg2, arg3, msg);
            return true;
        }
        return false;
    }
}
