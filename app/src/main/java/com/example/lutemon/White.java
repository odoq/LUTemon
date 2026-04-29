package com.example.lutemon;

public class White extends Lutemon {
    private static final int Attack = 5;
    private static final int Defence = 4;
    private static final int maxHealth = 20;

    public White(String name, int id) {
        super(name, id, Attack, Defence, maxHealth, "White");

        image = R.drawable.white;
    }
}
