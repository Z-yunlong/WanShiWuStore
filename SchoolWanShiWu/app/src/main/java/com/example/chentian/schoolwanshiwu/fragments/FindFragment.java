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
    List<String> tiles = new ArrayList<>();
    List<String> contents = new ArrayList<>();
    Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
        mContext = getContext();
    }

    private void initDatas() {
        tiles.add("取快递");
        tiles.add("带饭");
        tiles.add("取快递");
        tiles.add("取快递");
        tiles.add("取快递");
        tiles.add("带饭");
        tiles.add("带饭");
        tiles.add("带饭");
        tiles.add("取快递");
        tiles.add("取快递");

        contents.add("下午十点之前取来\\n电话：135XXXX5510");
        contents.add("下午九点之前取来\\n电话：135XXXX5509");
        contents.add("下午八点之前取来\\n电话：135XXXX5508");
        contents.add("下午七点之前取来\\n电话：135XXXX5507");
        contents.add("下午六点之前取来\\n电话：135XXXX5506");
        contents.add("下午五点之前取来\\n电话：135XXXX5505");
        contents.add("下午四点之前取来\\n电话：135XXXX5504");
        contents.add("下午三点之前取来\\n电话：135XXXX5503");
        contents.add("下午二点之前取来\\n电话：135XXXX5502");
        contents.add("下午一点之前取来\\n电话：135XXXX5501");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_find,container,false);
        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.find_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(tiles,contents,mContext));

        return layout;
    }
}
