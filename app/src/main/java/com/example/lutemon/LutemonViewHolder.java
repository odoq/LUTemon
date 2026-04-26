package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView lutemonName, lutemonAttack, lutemonDefence, lutemonHealth, lutemonExp;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        lutemonName = itemView.findViewById(R.id.txtLutName);
        lutemonAttack = itemView.findViewById(R.id.txtLutAttack);
        lutemonDefence = itemView.findViewById(R.id.txtLutDefence);
        lutemonHealth = itemView.findViewById(R.id.txtLutHealth);
        lutemonExp = itemView.findViewById(R.id.txtLutExp);

    }
}
