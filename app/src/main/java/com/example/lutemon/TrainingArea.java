package com.example.lutemon;
//
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class TrainingArea {

    private static TrainingArea instance = null;

    private TrainingArea() {}

    public static TrainingArea getInstance() {
        if (instance == null) {
            instance = new TrainingArea();
        }
        return instance;
    }

    public void train(Lutemon lutemon) {
        lutemon.train();
    }
}
