package com.example.lbechenjun.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lbechenjun on 16-11-11.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.list_item);

    }
}
