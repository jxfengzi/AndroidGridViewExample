package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.section.accessory.Accessory;
import com.example.myapplication.section.accessory.AccessorySection;
import com.example.myapplication.section.scene.Scene;
import com.example.myapplication.section.scene.SceneSection;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SectionedRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initAdapter();
        initView();
        initLayout();
    }

    private void initAdapter() {
        adapter = new SectionedRecyclerViewAdapter();
        adapter.addSection(getSceneSection());
        adapter.addSection(getAccessorySection());
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
    }

    private void initLayout() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 3;

                    default:
                        return 1;
                }
            }
        });

        recyclerView.setLayoutManager(layoutManager);
    }

    private SceneSection getSceneSection() {
        List<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene("出门"));
        scenes.add(new Scene("到家"));
        scenes.add(new Scene("晚安"));
        return new SceneSection("常用场景", scenes);
    }

    private AccessorySection getAccessorySection() {
        List<Accessory> list = new ArrayList<>();
        list.add(new Accessory("客厅", "开关"));
        list.add(new Accessory("客厅", "插座"));
        list.add(new Accessory("阳台", "灯泡1"));
        list.add(new Accessory("主卧", "灯泡2"));
        list.add(new Accessory("次卧", "灯泡3"));
        list.add(new Accessory("卫生间", "灯泡4"));
        list.add(new Accessory("厨房", "风扇"));
        list.add(new Accessory("客厅", "空调"));
        return new AccessorySection("常用配件", list);
    }
}