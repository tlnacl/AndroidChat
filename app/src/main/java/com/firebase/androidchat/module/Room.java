package com.firebase.androidchat.module;

/**
 * Created by tlnacl on 17/06/15.
 */
public class Room {
    private String name;

    private Room(){};

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
