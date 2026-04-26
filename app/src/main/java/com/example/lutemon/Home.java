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
    protected int id;

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
        int id = 1;

        RadioGroup rgLutemonColor = findViewById(R.id.rgColors);

        if (rgLutemonColor.getCheckedRadioButtonId() == R.id.rbWhite) {
            Storage.getInstance().addLutemon(new White(name, id));
            id++;
        } else if (rgLutemonColor.getCheckedRadioButtonId() == R.id.rbGreen) {
            Storage.getInstance().addLutemon(new Green(name, id));
            id++;
        } else if (rgLutemonColor.getCheckedRadioButtonId() == R.id.rbPink) {
            Storage.getInstance().addLutemon(new Pink(name, id));
            id++;
        } else if (rgLutemonColor.getCheckedRadioButtonId() == R.id.rbOrange) {
            Storage.getInstance().addLutemon(new Orange(name, id));
            id++;
        } else if (rgLutemonColor.getCheckedRadioButtonId() == R.id.rbBlack) {
            Storage.getInstance().addLutemon(new Black(name, id));
            id++;
        }
    }
}