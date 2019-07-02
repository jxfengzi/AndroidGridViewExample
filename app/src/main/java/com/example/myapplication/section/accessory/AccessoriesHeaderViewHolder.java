package com.example.myapplication.section.accessory;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class AccessoriesHeaderViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvTitle;

    public AccessoriesHeaderViewHolder(View view) {
        super(view);

        tvTitle = view.findViewById(R.id.tvTitle);
    }

    public void onBind(String title) {
        tvTitle.setText(title);
    }
}
