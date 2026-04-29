package com.example.lutemon;

import java.io.Serializable;

public class Lutemon implements Serializable {
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

    public String getColor() { return color; }
    public String getName() { return name; }
    public int getAttack() { return attack + experience; }
    public int getDefence() { return defence; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getExperience() { return experience; }
    public int getId() { return id; }

    public void train() {
        this.experience++;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
