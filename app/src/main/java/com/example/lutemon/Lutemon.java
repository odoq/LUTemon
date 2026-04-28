package com.example.lutemon;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lutemon extends AppCompatActivity {
    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;

    public Lutemon(String name, int id, int attack, int defence, int maxHealth, String color) {
        this.name = name;
        this.id = id;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.color = color;
        this.experience = 0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lutemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /*
    public Defence(lutemon : Lutemon) {


    }

    public Attack () {


    }
    */
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack + experience;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public void train() {
        this.experience++;
    }
}
