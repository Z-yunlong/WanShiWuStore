package com.example.chentian.schoolwanshiwu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chentian.schoolwanshiwu.adapters.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.chentian.schoolwanshiwu.GetOrderActivity.getOrderContents;

/**
 * Created by chentian on 02/03/2017.
 */

public class FabuActivity extends Activity {
    RecyclerView recyclerView;
    static List<String> FabuTiles = new ArrayList<>();
    static List<String> FabuContents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fabu_layout);

        recyclerView = (RecyclerView) findViewById(R.id.fabu_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(FabuTiles,FabuContents,this));
    }
}
