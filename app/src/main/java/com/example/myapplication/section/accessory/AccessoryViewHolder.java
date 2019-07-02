package com.example.myapplication.section.accessory;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class AccessoryViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public AccessoryViewHolder(View view) {
        super(view);
        textView = view.findViewById(R.id.textView);
    }

    public void onBind(Accessory accessory) {
        textView.setText(accessory.name());
    }
}