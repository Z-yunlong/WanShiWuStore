package com.example.chentian.schoolwanshiwu.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chentian.schoolwanshiwu.R;
import com.example.chentian.schoolwanshiwu.adapters.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentian on 11/01/2017.
 */

public class FindFragment extends Fragment {
    public List<String> getTiles() {
        return tiles;
    }

    public List<String> getContents() {
        return contents;
    }

    List<String> tiles = new ArrayList<>();
    List<String> contents = new ArrayList<>();
    Context mContext;

    RecyclerView recycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initDatas();
        mContext = getContext();
    }

//    private void initDatas() {
//        tiles.add("取快递");
//        tiles.add("带饭");
//
//        contents.add("下午十点之前取来" +"\n"+
//                "电话：135XXXX5510");
//        contents.add("下午九点之前取来" +"\n"+
//                "电话：135XXXX5509");
//    }

    public RecyclerView getRecycler() {
        return recycler;
    }

    public void setRecycler(RecyclerView recycler) {
        this.recycler = recycler;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_find,container,false);
        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.find_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(tiles,contents,mContext));

        setRecycler(recyclerView);

        return layout;
    }
}
