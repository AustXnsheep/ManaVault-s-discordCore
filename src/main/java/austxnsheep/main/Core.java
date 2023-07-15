package austxnsheep.main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public interface Core {
    default void sendToDiscordWithPlayer(JDA jda, String playername, String h1, String id, String content_message) {
        Player player = Bukkit.getPlayer(playername);
        String playerface = "https://crafatar.com/renders/head/" + player.getUniqueId();
        TextChannel channel = jda.getTextChannelById(id);
        EmbedBuilder ebuilder = new EmbedBuilder();
        ebuilder.setTitle(content_message);
        ebuilder.setAuthor(player.getName());
        ebuilder.setDescription(h1);
        ebuilder.setColor(Color.blue);
        ebuilder.setThumbnail(playerface);
        assert channel != null;
        channel.sendMessageEmbeds(ebuilder.build()).queue();
    }
    default void sendToDiscordWithoutPlayer(JDA jda, String h1, String h2, String id, String title) {
        TextChannel channel = jda.getTextChannelById(id);
        EmbedBuilder ebuilder = new EmbedBuilder();
        ebuilder.setTitle(title);
        ebuilder.setAuthor(h1);
        ebuilder.setDescription(h2);
        ebuilder.setColor(Color.blue);
        assert channel != null;
        channel.sendMessageEmbeds(ebuilder.build()).queue();
    }

    default void executeConsoleCommand(String command) {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        Bukkit.getServer().dispatchCommand(console, command);
    }
    default void sendClickableLink(Player player, String message, String link) {
        String formattedMessage = ChatColor.BLUE + message + " " + ChatColor.UNDERLINE + ChatColor.BOLD + link;
        player.sendMessage(formattedMessage);
    }
}
