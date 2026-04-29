package com.example.lutemon;

public class Pink extends Lutemon {
    private static final int Attack = 7;
    private static final int Defence = 2;
    private static final int maxHealth = 18;

    public Pink(String name, int id) {
        super(name, id, Attack, Defence, maxHealth, "Pink");

        image = R.drawable.pink;
    }
}
