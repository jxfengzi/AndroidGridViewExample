package com.example.myapplication.section.scene;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;

public class SceneSection extends Section {

    private String title;
    private List<Scene> list;

    public SceneSection(String title, List<Scene> list) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.item_scene)
                .headerResourceId(R.layout.item_scenes_header)
                .build());

        this.title = title;
        this.list = list;
    }

    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new SceneViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SceneViewHolder)holder).onBind(list.get(position));
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new ScenesHeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        ((ScenesHeaderViewHolder)holder).onBind(title);
    }
}