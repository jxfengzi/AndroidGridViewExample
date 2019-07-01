package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setItemAnimator( new DefaultItemAnimator());

        myAdapter = new MyAdapter(this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.list.add(new DeviceSummary("开关"));
        myAdapter.list.add(new DeviceSummary("插座"));
        myAdapter.list.add(new DeviceSummary("风扇"));
        myAdapter.list.add(new DeviceSummary("空调"));
        myAdapter.list.add(new DeviceSummary("电视"));
        myAdapter.list.add(new DeviceSummary("空气净化器"));
        myAdapter.list.add(new DeviceSummary("扫地机"));
    }

    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView textViewName;

        public ViewHolder(View v) {
            super(v);
            textViewName = v.findViewById(R.id.textView);
            v.setBackgroundColor(Color.GRAY);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
        }

        public void onBind(DeviceSummary d) {
            textViewName.setText(d.name);
        }

        @Override
        public void onClick(View view) {
            DeviceSummary d = myAdapter.getDevices().get(getAdapterPosition());
            Log.d(TAG, "onClick: " + d.name);
        }

        @Override
        public boolean onLongClick(View view) {
            DeviceSummary d = myAdapter.getDevices().get(getAdapterPosition());
            Log.d(TAG, "onLongClick: " + d.name);
            return true;
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        private List<DeviceSummary> list = new ArrayList<>();
        private final int mBackground;
        private final TypedValue mTypedValue = new TypedValue();

        public MyAdapter(Context context) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mBackground = mTypedValue.resourceId;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summary, parent, false);
            v.setBackgroundResource(mBackground);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
            holder.onBind(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public List<DeviceSummary> getDevices() {
            return list;
        }
    }
}
