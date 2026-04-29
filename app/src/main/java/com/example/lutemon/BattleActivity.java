package com.example.lutemon;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BattleActivity extends AppCompatActivity {

    private Lutemon attacker;
    private Lutemon defender;
    private TextView battleLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        battleLog = findViewById(R.id.battleLog);

        RecyclerView attackerList = findViewById(R.id.recyclerAttacker);
        attackerList.setLayoutManager(new LinearLayoutManager(this));
        attackerList.setAdapter(new LutemonListAdapter(
                this,
                Storage.getInstance().getLutemonsByLocation("battle"),
                "attacker"
        ));

        RecyclerView defenderList = findViewById(R.id.recyclerDefender);
        defenderList.setLayoutManager(new LinearLayoutManager(this));
        defenderList.setAdapter(new LutemonListAdapter(
                this,
                Storage.getInstance().getLutemonsByLocation("battle"),
                "defender"
        ));
    }

    public void setAttacker(Lutemon l) {
        attacker = l;
        battleLog.setText("Hyökkääjä valittu: " + l.getName());
    }

    public void setDefender(Lutemon l) {
        defender = l;
        battleLog.setText("Puolustaja valittu: " + l.getName());
    }

    public void startBattle(View view) {
        if (attacker == null || defender == null) {
            battleLog.setText("Valitse hyökkääjä ja puolustaja!");
            return;
        }

        BattleField bf = new BattleField();
        String result = bf.fight(attacker, defender);
        battleLog.setText(result);
    }
}
