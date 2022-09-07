package dev.awesomebfm.optimisticbot.models;

import java.util.Date;

public class UserData {

    private String userUUID;
    private int userXP;
    private int userLevel;
    private int userTotalXP;
    private Date joinDate;

    public UserData(String userUUID, int userXP, int userLevel, int userTotalXP, Date joinDate) {
        this.userUUID = userUUID;
        this.userXP = userXP;
        this.userLevel = userLevel;
        this.userTotalXP = userTotalXP;
        this.joinDate = joinDate;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public int getUserXP() {
        return userXP;
    }

    public void setUserXP(int userXP) {
        this.userXP = userXP;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserTotalXP() {
        return userTotalXP;
    }

    public void setUserTotalXP(int userTotalXP) {
        this.userTotalXP = userTotalXP;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
