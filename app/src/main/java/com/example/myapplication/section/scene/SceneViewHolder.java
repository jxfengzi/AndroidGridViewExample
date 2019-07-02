package com.example.myapplication.section.scene;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class SceneViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener, View.OnLongClickListener {

    private static final String TAG = "AccessoryViewHolder";
    private final TextView textView;

    public SceneViewHolder(View view) {
        super(view);
        textView = view.findViewById(R.id.textView);

        textView.setClickable(true);
        textView.setOnClickListener(this);

        textView.setLongClickable(true);
        textView.setOnLongClickListener(this);
    }

    public void onBind(Scene scene) {
        textView.setText(scene.name());
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
        ViewCompat.animate(textView)
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
        ViewCompat.animate(textView)
                .setDuration(200)
                .scaleX(1f)
                .scaleY(1f)
                .start();
    }
}
