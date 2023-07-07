package com.example.project;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.sql.Time;

public class ChatTitle {
    Image dp;
    String name;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    int pos;

    public void setDp(Image dp) {
        this.dp = dp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    @Override
    public String toString() {
        return "ChatTitle{" +
                "dp=" + dp +
                ", name='" + name + '\'' +
                ", lastMessage='" + lastMessage + '\'' +
                ", time='" + time + '\'' +
                ", newMessage=" + newMessage +
                '}';
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNewMessage(Drawable newMessage) {
        this.newMessage = newMessage;
    }

    public Image getDp() {
        return dp;
    }

    public String getName() {
        return name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getTime() {
        return time;
    }

    public Drawable getNewMessage() {
        return newMessage;
    }

    String lastMessage;
    String time;
    Drawable newMessage;
}
