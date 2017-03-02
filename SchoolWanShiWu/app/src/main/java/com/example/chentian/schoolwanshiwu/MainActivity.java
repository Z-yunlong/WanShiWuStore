package com.example.chentian.schoolwanshiwu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.chentian.schoolwanshiwu.adapters.FragmentAdapter;
import com.example.chentian.schoolwanshiwu.fragments.FindFragment;
import com.example.chentian.schoolwanshiwu.fragments.NoScrollViewPager;
import com.example.chentian.schoolwanshiwu.fragments.OrderFragment;
import com.example.chentian.schoolwanshiwu.fragments.PersonFragment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView titleText;//顶部标题栏
    NoScrollViewPager mViewPager;
    FragmentAdapter mAdapter;//初始化FragmentAdapter
    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        mViewPager.setAdapter(mAdapter);
    }

    private void initView() {
        titleText = (TextView) findViewById(R.id.title_text);
        mViewPager = (NoScrollViewPager) findViewById(R.id.view_pager);

        fragments.add(new FindFragment());
        fragments.add(new OrderFragment());
        fragments.add(new PersonFragment());

        mAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments);

    }

    public void ClickPerson(View view) {
        //将顶部标题栏改为当前点击的
        titleText.setText("");
        //更改ViewPager的显示
        mViewPager.setCurrentItem(2);
    }

    public void ClickOrder(View view) {
        //将顶部标题栏改为当前点击的
        titleText.setText("订单");
        //更改ViewPager的显示
        mViewPager.setCurrentItem(1);
    }

    public void ClickFind(View view) {
        //将顶部标题栏改为当前点击的
        titleText.setText("发现");
        //更改ViewPager的显示
        mViewPager.setCurrentItem(0);

        //这里刷新一下
        FreshData();
    }

    //刷新recyclerView的item,更新数据
    private void FreshData() {
        FindFragment find = (FindFragment) fragments.get(0);
        final RecyclerView recycler = find.getRecycler();
        final List<String> mtiles = find.getTiles();
        final List<String> mcontents = find.getContents();

        //避免数据重复，先清空之前的数据
        mtiles.clear();
        mcontents.clear();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("TAG", "FreshThreadStart...");
                    Socket socket = new Socket("192.168.56.1",8080);
                    Log.d("TAG", "Android客户端已创建");
                    //这里发给服务器"fresh"表示要刷新数据
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    writer.write("fresh\n");
                    writer.flush();


                    //这里接受从服务器传过来的数据
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String valu = null;

//                    while((valu = reader.readLine())!=null){
//                        Log.d("TAG",valu);
//                    }
                    valu = reader.readLine();
                    Log.d("TAG",valu);

                    String[] strs = valu.split(" ");

                    for (int i = 0;i<strs.length;i++){
                        mtiles.add(strs[i]);
                        mcontents.add(strs[i+2] +"\n"+
                                strs[i+1]);
                        i+=2;
                    }

                    reader.close();
                    writer.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        recycler.getAdapter().notifyDataSetChanged();
    }
}
