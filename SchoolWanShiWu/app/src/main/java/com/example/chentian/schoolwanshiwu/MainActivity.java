package com.example.chentian.schoolwanshiwu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.chentian.schoolwanshiwu.fragments.FindFragment;
import com.example.chentian.schoolwanshiwu.fragments.FragmentAdapter;
import com.example.chentian.schoolwanshiwu.fragments.NoScrollViewPager;
import com.example.chentian.schoolwanshiwu.fragments.OrderFragment;
import com.example.chentian.schoolwanshiwu.fragments.PersonFragment;

import java.util.ArrayList;

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
        titleText.setText("用户");
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
    }
}
