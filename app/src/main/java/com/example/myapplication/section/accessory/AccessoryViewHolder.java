package com.example.myapplication.section.accessory;

import android.animation.TimeInterpolator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class AccessoryViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener, View.OnClickListener, View.OnLongClickListener {

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

        layout.setOnTouchListener(this);
    }

    public void onBind(Accessory accessory) {
        textViewRoom.setText(accessory.room());
        textViewName.setText(accessory.name());
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");

//        ViewCompat.animate(layout)
//                .setDuration(150)
//                .scaleX(1.1f)
//                .scaleY(1.1f)
//                .withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        ViewCompat.animate(layout)
//                                .setDuration(150)
//                                .scaleX(1f)
//                                .scaleY(1f)
//                                .start();
//                    }
//                })
//                .start();
    }

    @Override
    public boolean onLongClick(View view) {
        Log.d(TAG, "onLongClick");

//        ViewCompat.animate(layout)
//                .setDuration(150)
//                .scaleX(1.1f)
//                .scaleY(1.1f)
//                .withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        ViewCompat.animate(layout)
//                                .setDuration(150)
//                                .scaleX(1f)
//                                .scaleY(1f)
//                                .withEndAction(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Log.d(TAG, "onLongClick end, open new activity...");
//                                    }
//                                })
//                                .start();
//                    }
//                })
//                .start();

        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "onTouch");

        TimeInterpolator interpolator= new DecelerateInterpolator();
        float scale = 1.1f;
        int duration = 150;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                v.animate().scaleX(scale).scaleY(scale).setDuration(duration).setInterpolator(interpolator);
                v.setPressed(true);
                break;

            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                boolean isInside = (x > 0 && x < v.getWidth() && y > 0 && y < v.getHeight());
                if (v.isPressed() != isInside) {
                    v.setPressed(isInside);
                }
                break;

            case MotionEvent.ACTION_CANCEL:
                v.setPressed(false);
                v.animate().scaleX(1).scaleY(1).setInterpolator(interpolator);
                break;

            case MotionEvent.ACTION_UP:
                v.animate().scaleX(1).scaleY(1).setInterpolator(interpolator);
                if (v.isPressed()) {
                    v.performClick();
                    v.setPressed(false);
                }
                break;
        }

        return false;
    }
}