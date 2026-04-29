package com.example.lutemon;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoveLutemonsActivity extends AppCompatActivity {

    private LutemonMoveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);

        RecyclerView recycler = findViewById(R.id.recyclerMove);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LutemonMoveAdapter(Storage.getInstance().getLutemons());
        recycler.setAdapter(adapter);

        findViewById(R.id.buttonMove).setOnClickListener(v -> move());
    }

    private void move() {
        RadioGroup group = findViewById(R.id.radioGroupMove);
        int selectedId = group.getCheckedRadioButtonId();

        ArrayList<Lutemon> selected = adapter.getSelected();

        for (Lutemon l : selected) {
            if (selectedId == R.id.radioHome) {
                Storage.getInstance().setLocation(l, "home");
            } else if (selectedId == R.id.radioTraining) {
                Storage.getInstance().setLocation(l, "training");
            } else if (selectedId == R.id.radioBattle) {
                Storage.getInstance().setLocation(l, "battle");
            }
        }

        finish();

    }
}
