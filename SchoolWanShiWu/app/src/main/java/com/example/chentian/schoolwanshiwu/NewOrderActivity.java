package com.example.chentian.schoolwanshiwu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chentian on 12/02/2017.
 */

public class NewOrderActivity extends Activity {
    RadioButton quKuaiDi,daiFan;
    EditText miaoShuEdit,lianXiEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_order_activity);

        quKuaiDi = (RadioButton) findViewById(R.id.qu_kuai_di);
        daiFan = (RadioButton) findViewById(R.id.dai_fan);
        miaoShuEdit = (EditText) findViewById(R.id.miaoshu_edit);
        lianXiEdit = (EditText) findViewById(R.id.lianxi_edit);

    }

    public void FaBuClick(View view) {
        Toast.makeText(this, "发布", Toast.LENGTH_SHORT).show();
        final Map<String,String> valus = new HashMap<>();
        valus.put("LianXi",lianXiEdit.getText().toString());
        valus.put("MiaoShu",miaoShuEdit.getText().toString());
        if(quKuaiDi.isChecked()){
            valus.put("LeiXing","取快递");
        }else {
            valus.put("LeiXing","带饭");
        }

        FabuActivity.FabuTiles.add(valus.get("LeiXing"));
        FabuActivity.FabuContents.add(valus.get("LianXi")+"\n"+valus.get("MiaoShu"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("TAG", "BaoCunThreadStart...");
                    Socket socket = new Socket("192.168.56.1",8080);
                    Log.d("TAG", "Android客户端已创建");
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    writer.write("write\n");
                    writer.write(valus.get("LeiXing")+"\n");
                    writer.write(valus.get("LianXi")+"\n");
                    writer.write(valus.get("MiaoShu")+"\n");
                    writer.flush();

                    writer.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void QuXiaoClick(View view) {
        Intent intent = new Intent(NewOrderActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
