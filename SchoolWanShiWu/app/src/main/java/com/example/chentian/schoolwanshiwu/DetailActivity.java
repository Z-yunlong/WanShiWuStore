package com.example.chentian.schoolwanshiwu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chentian on 02/03/2017.
 */

public class DetailActivity extends Activity {
    TextView titleText,detailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        titleText = (TextView) findViewById(R.id.leixin_text);
        detailText = (TextView) findViewById(R.id.detail_text);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("valu");
        String detail = bundle.getString("detail");
        String title = bundle.getString("leixin");
        Toast.makeText(this,detail,Toast.LENGTH_SHORT).show();

        titleText.setText(title);
        detailText.setText(detail);
    }

    public void ClickGetOrder(View view) {
        Toast.makeText(this, "已成功接单", Toast.LENGTH_SHORT).show();
        GetOrderActivity.getOrderTiles.add(titleText.getText().toString());
        GetOrderActivity.getOrderContents.add(detailText.getText().toString());
        //GetOrderActivity.recyclerView.getAdapter().notifyDataSetChanged();
    }
}
