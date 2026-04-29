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

public class Home extends AppCompatActivity {

    private TextView addName;

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

        Storage storage = Storage.getInstance();
        int id = storage.getNextId();

        if (selectedId == R.id.rbWhite) {
            storage.addLutemon(new White(name, id));
        } else if (selectedId == R.id.rbGreen) {
            storage.addLutemon(new Green(name, id));
        } else if (selectedId == R.id.rbPink) {
            storage.addLutemon(new Pink(name, id));
        } else if (selectedId == R.id.rbOrange) {
            storage.addLutemon(new Orange(name, id));
        } else if (selectedId == R.id.rbBlack) {
            storage.addLutemon(new Black(name, id));
        }

    }
}
