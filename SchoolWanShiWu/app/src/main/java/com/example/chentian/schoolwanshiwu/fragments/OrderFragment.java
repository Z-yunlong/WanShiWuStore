package com.example.chentian.schoolwanshiwu.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chentian.schoolwanshiwu.NewOrderActivity;
import com.example.chentian.schoolwanshiwu.R;

/**
 * Created by chentian on 11/01/2017.
 */

public class OrderFragment extends Fragment implements View.OnClickListener{
    TextView textPublish,textAccept,textNew;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout =  inflater.inflate(R.layout.fragment_order,container,false);

        textPublish = (TextView) layout.findViewById(R.id.text_publish);
        textAccept = (TextView) layout.findViewById(R.id.text_accept);
        textNew = (TextView) layout.findViewById(R.id.text_new);

        textNew.setOnClickListener(this);
        textPublish.setOnClickListener(this);
        textAccept.setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_accept:
                Toast.makeText(getContext(), "接受的订单", Toast.LENGTH_SHORT).show();
                break;

            case R.id.text_publish:
                Toast.makeText(getContext(), "发布的订单", Toast.LENGTH_SHORT).show();
                break;

            case R.id.text_new:
                Toast.makeText(getContext(), "新的订单", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), NewOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
