package com.example.lutemon;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.jar.Attributes;

public class Home extends AppCompatActivity {

    private TextView addName;
    protected int idCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void createLutemon(View view) {

        addName = findViewById(R.id.txtAddName);
        String name = addName.getText().toString();

        RadioGroup rgLutemonColor = findViewById(R.id.rgColors);
        int selectedId = rgLutemonColor.getCheckedRadioButtonId();


        if (selectedId == R.id.rbWhite) {
            Storage.getInstance().addLutemon(new White(name, idCounter));
            idCounter++;
        } else if (selectedId == R.id.rbGreen) {
            Storage.getInstance().addLutemon(new Green(name, idCounter));
            idCounter++;
        } else if (selectedId == R.id.rbPink) {
            Storage.getInstance().addLutemon(new Pink(name, idCounter));
            idCounter++;
        } else if (selectedId == R.id.rbOrange) {
            Storage.getInstance().addLutemon(new Orange(name, idCounter));
            idCounter++;
        } else if (selectedId == R.id.rbBlack) {
            Storage.getInstance().addLutemon(new Black(name, idCounter));
            idCounter++;
        }

    }
}