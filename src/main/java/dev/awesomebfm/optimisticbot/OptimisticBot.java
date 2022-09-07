package dev.awesomebfm.optimisticbot;

import dev.awesomebfm.optimisticbot.commands.moderation.BanCommand;
import dev.awesomebfm.optimisticbot.listeners.MessageDeleteListener;
import dev.awesomebfm.optimisticbot.listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import javax.security.auth.login.LoginException;

public class OptimisticBot {
    public static void main(String[] args) throws LoginException {

        JDA jda = JDABuilder.createDefault("")
                .setActivity(Activity.watching("SkyBlock Optimists"))
                .addEventListeners(new MessageListener())
                .addEventListeners(new MessageDeleteListener())
                .addEventListeners(new BanCommand())
                .build();

        jda.upsertCommand("ban", "Ban a member")
                .addOptions(
                        new OptionData(OptionType.USER, "user", "The user to kick", true),
                        new OptionData(OptionType.STRING, "reason", "The reason for the kick", true),
                        new OptionData(OptionType.STRING, "duration", "The duration of the kick", false)
                )
                .queue();

    }
}
