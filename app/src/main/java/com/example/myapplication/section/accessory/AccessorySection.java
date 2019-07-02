package com.example.myapplication.section.accessory;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;

public class AccessorySection extends Section {

    private String title;
    private List<Accessory> list;

    public AccessorySection(String title, List<Accessory> list) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.item_accessory)
                .headerResourceId(R.layout.item_accessories_header)
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
        return new AccessoryViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AccessoryViewHolder)holder).onBind(list.get(position));
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new AccessoriesHeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        ((AccessoriesHeaderViewHolder)holder).onBind(title);
    }
}