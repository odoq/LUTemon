package com.example.lutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void switchToListLutemon(View view) {
        Intent intent = new Intent(this, LutemonListActivity.class);
        startActivity(intent);
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void switchToBattleArena(View view) {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }

    public void switchToMoveLutemon(View view) {
        Intent intent = new Intent(this, MoveLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToTraining(View view) {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }

    public ArrayList<Lutemon> getAllLutemons() {
        return Storage.getInstance().getLutemons();
    }




}