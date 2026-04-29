package com.example.lutemon;
//
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

@SuppressLint("NotifyDataSetChanged")
public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private String mode;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons, String mode) {
        this.context = context;
        this.lutemons = lutemons;
        this.mode = mode;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        holder.lutemonName.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
        holder.lutemonAttack.setText("Hyökkäys: " + lutemon.getAttack());
        holder.lutemonDefence.setText("Puolustus: " + lutemon.getDefence());
        holder.lutemonHealth.setText("Elämä: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth());
        holder.lutemonExp.setText("Kokemus: " + lutemon.getExperience());
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());


        if (mode.equals("training")) {
            holder.trainButton.setOnClickListener(v -> {
                TrainingArea.getInstance().train(lutemon);
                notifyDataSetChanged();
            });
        } else {
            holder.trainButton.setVisibility(ViewGroup.GONE);
        }

        if (mode.equals("attacker")) {
            holder.itemView.setOnClickListener(v -> {
                ((BattleActivity) context).setAttacker(lutemon);
            });
        }

        if (mode.equals("defender")) {
            holder.itemView.setOnClickListener(v -> {
                ((BattleActivity) context).setDefender(lutemon);
            });
        }
    }

    public void updateList(ArrayList<Lutemon> newList) {
        this.lutemons = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}



