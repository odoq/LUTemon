package com.example.lutemon;

public class Black extends Lutemon {
    private static final int Attack = 9;
    private static final int Defence = 0;
    private static final int maxHealth = 16;

    public Black(String name, int id) {
        super(name, id, Attack, Defence, maxHealth, "Black");

        image = R.drawable.black;
    }
}
