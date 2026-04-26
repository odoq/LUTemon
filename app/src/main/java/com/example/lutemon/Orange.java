package com.example.lutemon;

public class Orange extends Lutemon {
    private static final int Attack = 8;
    private static final int Defence = 1;
    private static final int maxHealth = 17;

    public Orange(String name, int id) {
        super(name, id, Attack, Defence, maxHealth, "Orange");
    }
}
