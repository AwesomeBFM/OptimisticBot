package dev.awesomebfm.optimisticbot.models;

public class GuildData {

    private String guildID;
    private int count;

    public GuildData(String guildID, int count) {
        this.guildID = guildID;
        this.count = count;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(String guildID) {
        this.guildID = guildID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
