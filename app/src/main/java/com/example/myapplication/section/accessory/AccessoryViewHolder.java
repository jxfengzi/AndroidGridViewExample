package com.example.myapplication.section.accessory;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class AccessoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private static final String TAG = "AccessoryViewHolder";
    private final ConstraintLayout layout;
    private final TextView textViewRoom;
    private final TextView textViewName;

    public AccessoryViewHolder(View view) {
        super(view);
        layout = view.findViewById(R.id.accessoryLayout);
        textViewRoom = view.findViewById(R.id.textViewRoom);
        textViewName = view.findViewById(R.id.textViewName);

        layout.setClickable(true);
        layout.setOnClickListener(this);

        layout.setLongClickable(true);
        layout.setOnLongClickListener(this);
    }

    public void onBind(Accessory accessory) {
        textViewRoom.setText(accessory.room());
        textViewName.setText(accessory.name());
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
        this.scaleUp();
    }

    @Override
    public boolean onLongClick(View view) {
        Log.d(TAG, "onLongClick");
        return true;
    }

    private void scaleUp() {
        Log.d(TAG, "scaleUp");
        ViewCompat.animate(layout)
                .setDuration(200)
                .scaleX(1.1f)
                .scaleY(1.1f)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        scaleDown();
                    }
                })
                .start();
    }

    private void scaleDown() {
        Log.d(TAG, "scaleDown");
        ViewCompat.animate(layout)
                .setDuration(200)
                .scaleX(1f)
                .scaleY(1f)
                .start();
    }
}