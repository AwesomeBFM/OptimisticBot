package dev.awesomebfm.optimisticbot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {

        Message.suppressContentIntentWarning();

        // Return if the author is a bot
        if (e.getAuthor().isBot()) return;

        // Check if the message is in the counting channel
        if (e.getChannel().getId().equals("931193440593674250")) {

        }

        // Prefix Commands
        if (e.getMessage().getContentRaw().startsWith("?")) {
            String[] args = e.getMessage().getContentRaw().split(" ");
            switch (args[0]) {
                case "?rules":
                    if (!e.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                        return;
                    }
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle("Rules");
                    embed.setColor(Color.WHITE);
                    embed.setDescription(
                            """
                                    1. Treat others with respect
                                    2. Follow all common sense rules
                                    3. No advertising of any kind
                                    4. No NSFW content
                                    5. Excessive spamming and unnecessary pinging is not allowed
                                    6. No impersonation of any kind
                                    7. Follow Discord TOS at all times
                                    
                                    Just don't cause problems, we are not here to moderate you and you are not here to be moderated"""
                    );
                    embed.setFooter("Optimistic Bot v1.0.0");
                    embed.setTimestamp(e.getMessage().getTimeCreated());
                    e.getChannel().sendMessageEmbeds(embed.build()).queue();
                    break;
                case "?ban":
                    if (!e.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                        return;
                    }


                    break;
            }
        }

    }

}
