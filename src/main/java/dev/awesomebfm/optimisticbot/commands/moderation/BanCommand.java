package dev.awesomebfm.optimisticbot.commands.moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class BanCommand extends ListenerAdapter {

    //@Override
    public void onCommand(@NotNull SlashCommandInteractionEvent e) {

        if (!e.getName().equals("ban")) {
            return;
        }

        // Tell Discord to take a chill pill
        e.deferReply().queue();

        EmbedBuilder errorEmbed = new EmbedBuilder();
        errorEmbed.setColor(Color.RED);

        EmbedBuilder successEmbed = new EmbedBuilder();
        EmbedBuilder dmEmbed = new EmbedBuilder();
        EmbedBuilder loggingEmbed = new EmbedBuilder();

        // Check if the command user has the correct permission
        if (!e.getMember().hasPermission(Permission.BAN_MEMBERS)) {
            errorEmbed.setDescription("⛔ Error: Missing Permission");
            e.replyEmbeds(errorEmbed.build()).setEphemeral(true).queue();
            return;
        }

        // Check if the target is a moderator
        if (e.getOption("user").getAsMember().hasPermission(Permission.BAN_MEMBERS)) {
            errorEmbed.setDescription("⛔ Error: Target is a moderator");
            e.replyEmbeds(errorEmbed.build()).setEphemeral(true).queue();
            return;
        }

        // Check if the bot can ban people
        if (!e.getGuild().getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
            errorEmbed.setDescription("⛔ Error: There is an error with the bot and it cannot ban people");
            e.replyEmbeds(errorEmbed.build()).setEphemeral(true).queue();
            return;
        }

        // Check if the target is the sender
        if (e.getOption("user").getAsMember().getId().equals(e.getMember().getId())) {
            errorEmbed.setDescription("⛔ Error: You cannot ban yourself");
            e.replyEmbeds(errorEmbed.build()).setEphemeral(true).queue();
            return;
        }

        // Check if the target is the bot
        if (e.getOption("user").getAsMember().getId().equals(e.getGuild().getSelfMember().getId())) {
            errorEmbed.setDescription("⛔ Error: You cannot ban me");
            e.replyEmbeds(errorEmbed.build()).setEphemeral(true).queue();
            return;
        }

        // Check if the target's highest role is above the bot's highest role
        if (e.getOption("user").getAsMember().getRoles().get(0).getPosition() > e.getGuild().getSelfMember().getRoles().get(0).getPosition()) {
            errorEmbed.setDescription("⛔ Error: The target is the bot's superior");
            e.replyEmbeds(errorEmbed.build()).setEphemeral(true).queue();
            return;
        }



        dmEmbed.setTitle("You have been banned!");
        dmEmbed.addField("Server:", "SkyBlock Optimists", false);
        dmEmbed.addField("Reason:", e.getOption("reason").getAsString(), false);
        dmEmbed.addField("Appeal:", "https://sbo.awesomebfm.dev/appeal", false);

        e.getOption("user").getAsMember().ban(0, e.getOption("reason").getAsString()).queue();

        successEmbed.setTitle("User Banned!");
        successEmbed.setColor(Color.YELLOW);
        successEmbed.setFooter("Optimistic Bot v1.0.0");
        successEmbed.setTimestamp(e.getTimeCreated());
        e.replyEmbeds(successEmbed.build()).setEphemeral(true).queue();



    }

}
