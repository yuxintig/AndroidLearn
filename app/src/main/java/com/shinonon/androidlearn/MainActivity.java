package com.shinonon.androidlearn;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Shinonon
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText 账号输入框 = findViewById(R.id.name);
        EditText 密码输入框 = findViewById(R.id.iphone);

        //寻找登录Button
        Button btnLogin = findViewById(R.id.btn_login);
        //给登录按钮设置点击事件

        String 账号 = 账号输入框.getText().toString();
        String 密码 = 密码输入框.getText().toString();
        btnLogin.setOnClickListener(v -> {
            //todo 按钮点击之后做的事情
            Log.e("====>","登录按钮被点击了");
            Log.e("====>","\n账号:"+账号+"\n密码:"+密码);
            Toast.makeText(MainActivity.this, "哈哈哈哈你点开了", Toast.LENGTH_SHORT).show();
        });



    }
}