package com.example.myapplication.section.accessory;

public class Accessory {

    private String room;
    private String name;

    public Accessory(String room, String name) {
        this.room = room;
        this.name = name;
    }

    public String room() {
        return room;
    }

    public String name() {
        return name;
    }
}
