package com.example.lutemon;

public class Green extends Lutemon {
    private static final int Attack = 6;
    private static final int Defence = 3;
    private static final int maxHealth = 19;

    public Green(String name, int id) {
        super(name, id, Attack, Defence, maxHealth, "Green");
    }
}
