package com.example.myapplication.section.scene;

import android.animation.TimeInterpolator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class SceneViewHolder extends RecyclerView.ViewHolder  implements View.OnTouchListener, View.OnClickListener, View.OnLongClickListener {

    private static final String TAG = "AccessoryViewHolder";
    private final TextView textView;

    public SceneViewHolder(View view) {
        super(view);
        textView = view.findViewById(R.id.textView);

        textView.setClickable(true);
        textView.setOnClickListener(this);

        textView.setLongClickable(true);
        textView.setOnLongClickListener(this);

        textView.setOnTouchListener(this);
    }

    public void onBind(Scene scene) {
        textView.setText(scene.name());
    }


    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
//        this.scaleUp();
    }

    @Override
    public boolean onLongClick(View view) {
        Log.d(TAG, "onLongClick");
        return true;
    }

//    private void scaleUp() {
//        Log.d(TAG, "scaleUp");
//        ViewCompat.animate(textView)
//                .setDuration(200)
//                .scaleX(1.1f)
//                .scaleY(1.1f)
//                .withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        scaleDown();
//                    }
//                })
//                .start();
//    }
//
//    private void scaleDown() {
//        Log.d(TAG, "scaleDown");
//        ViewCompat.animate(textView)
//                .setDuration(200)
//                .scaleX(1f)
//                .scaleY(1f)
//                .start();
//    }

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
