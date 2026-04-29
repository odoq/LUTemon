package com.example.lutemon;
//
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonMoveAdapter extends RecyclerView.Adapter<LutemonMoveAdapter.ViewHolder> {

    private ArrayList<Lutemon> lutemons;
    private ArrayList<Lutemon> selected = new ArrayList<>();

    public LutemonMoveAdapter(ArrayList<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    public ArrayList<Lutemon> getSelected() {
        return selected;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
            name = itemView.findViewById(R.id.name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lutemon_move_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lutemon l = lutemons.get(position);

        holder.name.setText(l.getName() + " (" + l.getColor() + ")");

        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(selected.contains(l));

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) selected.add(l);
            else selected.remove(l);
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
