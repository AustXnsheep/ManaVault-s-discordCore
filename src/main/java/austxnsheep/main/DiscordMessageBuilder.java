package austxnsheep.main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.entity.Player;

import java.awt.*;

public class DiscordMessageBuilder implements Core {
    private String channelid;
    private TextChannel channel;
    private String message;
    private String messagedetails;
    private Player player;
    private boolean containsPlayer = true;
    private JDA jda = Main.jda;
    Guild guild = jda.getGuildById("1116988575360241716");
    public DiscordMessageBuilder(String channelid, Player player) {
        if (player==null) {
            this.containsPlayer = false;
        }
        this.channel = jda.getTextChannelById(channelid);
        this.channelid = channelid;
    }
    public void sendMessage() {
        if (this.containsPlayer) {
            EmbedBuilder ebuilder = new EmbedBuilder();
            ebuilder.setTitle(this.player.getName());
            ebuilder.setAuthor(this.messagedetails);
            ebuilder.setDescription(this.message);
            ebuilder.setColor(Color.blue);
            assert this.channel != null;
            this.channel.sendMessageEmbeds(ebuilder.build()).queue();
        } else {
            String playerheadurl = "https://crafatar.com/renders/head/" + this.player.getUniqueId();
            EmbedBuilder ebuilder = new EmbedBuilder();
            ebuilder.setTitle(this.message);
            ebuilder.setAuthor(this.player.getName());
            ebuilder.setDescription(this.messagedetails);
            ebuilder.setColor(Color.blue);
            ebuilder.setThumbnail(playerheadurl);
            assert this.channel != null;
            this.channel.sendMessageEmbeds(ebuilder.build()).queue();
        }
    }
    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public TextChannel getChannel() {
        return channel;
    }

    public void setChannel(TextChannel channel) {
        this.channel = channel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessagedetails() {
        return messagedetails;
    }

    public void setMessagedetails(String messagedetails) {
        this.messagedetails = messagedetails;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean containsPlayer() {
        return containsPlayer;
    }

    public void setContainsPlayer(boolean containsPlayer) {
        this.containsPlayer = containsPlayer;
    }
}
