package com.example.chentian.schoolwanshiwu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chentian.schoolwanshiwu.adapters.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentian on 02/03/2017.
 */

public class GetOrderActivity extends Activity{
    static RecyclerView recyclerView;
    static List<String> getOrderTiles = new ArrayList<>();
    static List<String> getOrderContents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getorder_layout);

        //initDatas();

        recyclerView = (RecyclerView) findViewById(R.id.getorder_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(getOrderTiles,getOrderContents,this));


    }

//    private void initDatas() {
//        getOrderTiles.add("取快递");
//        getOrderTiles.add("带饭");
//
//        getOrderContents.add("下午十点之前取来" +"\n"+
//                "电话：135XXXX5510");
//        getOrderContents.add("下午九点之前取来" +"\n"+
//                "电话：135XXXX5509");
//    }
}
