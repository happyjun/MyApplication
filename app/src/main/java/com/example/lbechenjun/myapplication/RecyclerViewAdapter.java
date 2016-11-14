package com.example.lbechenjun.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lbechenjun on 16-11-11.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private List<String> list;

    private Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (list != null && list.size() > 0) {
            holder.textView.setText(list.get(position));
        }

    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }else {
            return 0;
        }
    }
}
