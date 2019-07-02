package com.example.myapplication.section.scene;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class SceneViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public SceneViewHolder(View view) {
        super(view);
        textView = view.findViewById(R.id.textView);
    }

    public void onBind(Scene scene) {
        textView.setText(scene.name());
    }
}
