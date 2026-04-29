package com.example.lutemon;
//
import java.util.ArrayList;
import java.util.HashMap;

public class Storage {

    private static Storage instance;
    private int idCounter = 1;

    private final HashMap<Integer, Lutemon> lutemons = new HashMap<>();
    private final HashMap<Integer, String> locations = new HashMap<>();

    private Storage() {}

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public int getNextId() {
        return idCounter++;
    }

    public void setLocation(Lutemon l, String place) {
        locations.put(l.id, place);
    }

    public String getLocation(Lutemon l) {
        return locations.getOrDefault(l.id, "home");
    }

    public ArrayList<Lutemon> getLutemonsByLocation(String place) {
        ArrayList<Lutemon> result = new ArrayList<>();
        for (Lutemon l : lutemons.values()) {
            if (getLocation(l).equals(place)) {
                result.add(l);
            }
        }
        return result;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.put(lutemon.id, lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon.id);
        locations.remove(lutemon.id);
    }

    public ArrayList<Lutemon> getLutemons() {
        return new ArrayList<>(lutemons.values());
    }
}
