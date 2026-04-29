package com.example.lutemon;
//
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

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private Lutemon attacker;
    private Lutemon defender;
    private TextView battleLog;
    private LutemonListAdapter attackerAdapter;
    private LutemonListAdapter defenderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        battleLog = findViewById(R.id.battleLog);

        RecyclerView attackerList = findViewById(R.id.recyclerAttacker);
        attackerList.setLayoutManager(new LinearLayoutManager(this));
        attackerAdapter = new LutemonListAdapter(this, Storage.getInstance().getLutemonsByLocation("battle"), "attacker");
        attackerList.setAdapter(attackerAdapter);

        RecyclerView defenderList = findViewById(R.id.recyclerDefender);
        defenderList.setLayoutManager(new LinearLayoutManager(this));
        defenderAdapter = new LutemonListAdapter(this, Storage.getInstance().getLutemonsByLocation("battle"), "defender");
        defenderList.setAdapter(defenderAdapter);
    }

    public void setAttacker(Lutemon l) {
        attacker = l;
        if (l.getHealth() == 0) {
            battleLog.setText("Hyökkääjä on kuollut!");
        } else {
            battleLog.setText("Hyökkääjä valittu: " + l.getName());
        }
    }

    public void setDefender(Lutemon l) {
        defender = l;
        if (l.getHealth() == 0) {
            battleLog.setText("Puolustaja on kuollut!");
        } else {
            battleLog.setText("Puolustaja valittu: " + l.getName());
        }

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

    public void updateLutemons() {
        ArrayList<Lutemon> updatedList = Storage.getInstance().getLutemonsByLocation("battle");
        attackerAdapter.updateList(updatedList);
        defenderAdapter.updateList(updatedList);
    }

}
