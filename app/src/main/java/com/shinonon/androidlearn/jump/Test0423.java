package com.shinonon.androidlearn.jump;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.shinonon.androidlearn.R;

public class Test0423 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test0423);
        findViewById(R.id.button).setOnClickListener(v->{
            Intent intent = new Intent(this, Jump2Activity0423.class);
            User user = new User();
            user.name = "余欣婷";
            user.age = 18;
            intent.putExtra("user",user);
            startActivity(intent);
        });
    }
}