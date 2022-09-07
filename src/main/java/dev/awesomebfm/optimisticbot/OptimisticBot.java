package dev.awesomebfm.optimisticbot;

import dev.awesomebfm.optimisticbot.listeners.MessageDeleteListener;
import dev.awesomebfm.optimisticbot.listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class OptimisticBot {
    public static void main(String[] args) throws LoginException {

        JDA jda = JDABuilder.createDefault("")
                .setActivity(Activity.watching("SkyBlock Optimists"))
                .addEventListeners(new MessageListener())
                .addEventListeners(new MessageDeleteListener())
                .build();

    }
}
