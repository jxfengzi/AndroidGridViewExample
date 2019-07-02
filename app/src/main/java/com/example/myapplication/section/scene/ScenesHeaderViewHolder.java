package com.example.myapplication.section.scene;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ScenesHeaderViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvTitle;

    public ScenesHeaderViewHolder(View view) {
        super(view);

        tvTitle = view.findViewById(R.id.tvTitle);
    }

    public void onBind(String title) {
        tvTitle.setText(title);
    }
}