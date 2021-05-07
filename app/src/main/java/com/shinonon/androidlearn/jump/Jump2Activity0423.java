package com.shinonon.androidlearn.jump;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.shinonon.androidlearn.R;

public class Jump2Activity0423 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump20423);
        TextView tv = findViewById(R.id.textView);
        User user = (User) getIntent().getSerializableExtra("user");
        tv.setText(user.name);
    }
}