package com.example.chentian.schoolwanshiwu.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chentian.schoolwanshiwu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentian on 12/01/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter {
    List<String> tiles = new ArrayList<>();
    List<String> contents = new ArrayList<>();
    Context mContext;

    public MyRecyclerViewAdapter(List<String> tiles, List<String> contents, Context mContext){
        this.tiles = tiles;
        this.contents = contents;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.recy_item_find,parent,false));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myHolder = (MyViewHolder) holder;
        myHolder.tile.setText(tiles.get(position));
        myHolder.content.setText(contents.get(position));
    }

    @Override
    public int getItemCount() {
        return tiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tile,content;

        public MyViewHolder(View itemView) {
            super(itemView);
            tile = (TextView) itemView.findViewById(R.id.find_title);
            content = (TextView) itemView.findViewById(R.id.find_content);
        }
    }
}
