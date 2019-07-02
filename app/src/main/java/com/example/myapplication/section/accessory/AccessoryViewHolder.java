package com.example.myapplication.section.accessory;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class AccessoryViewHolder extends RecyclerView.ViewHolder {

    private final TextView textViewRoom;
    private final TextView textViewName;

    public AccessoryViewHolder(View view) {
        super(view);
        textViewRoom = view.findViewById(R.id.textViewRoom);
        textViewName = view.findViewById(R.id.textViewName);
    }

    public void onBind(Accessory accessory) {
        textViewRoom.setText(accessory.room());
        textViewName.setText(accessory.name());
    }
}