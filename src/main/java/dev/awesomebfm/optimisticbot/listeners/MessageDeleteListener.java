package dev.awesomebfm.optimisticbot.listeners;

import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageDeleteListener extends ListenerAdapter {

    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent e) {

        /*e.getChannel().retrieveMessageById(e.getMessageId()).queue(m -> {
            m.getAuthor();
            System.out.println("message deleted");
        }); */



    }

}
