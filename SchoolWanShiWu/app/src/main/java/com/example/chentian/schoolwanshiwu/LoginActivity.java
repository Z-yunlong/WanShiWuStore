package com.example.chentian.schoolwanshiwu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by chentian on 04/03/2017.
 */

public class LoginActivity extends Activity {
    EditText user,mima;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        user = (EditText) findViewById(R.id.user_edit);
        mima = (EditText) findViewById(R.id.mima_edit);
        login = (Button) findViewById(R.id.login);


    }

    public void ClickLogin(View view) {
        if(user.getText().toString().equals("123")
                &&mima.getText().toString().equals("123")){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void ClickZhuCe(View view) {
        Intent intent2 = new Intent(LoginActivity.this,ZhuCeActivity.class);
        startActivity(intent2);
    }

    public void ClickWangJi(View view) {
        Intent intent3 = new Intent(LoginActivity.this,WangJiActivity.class);
        startActivity(intent3);
    }
}
