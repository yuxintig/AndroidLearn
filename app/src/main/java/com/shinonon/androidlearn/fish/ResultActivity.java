package com.shinonon.androidlearn.fish;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.shinonon.androidlearn.databinding.ActivityResultBinding;


public class ResultActivity extends AppCompatActivity {

    ActivityResultBinding v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(v.getRoot());
        String num1 = getIntent().getStringExtra("num1");
        String num2 = getIntent().getStringExtra("num2");
        Log.e("================>",num1+" "+num2);
        v.tvRes.setText("结果为"+(Integer.parseInt(num1)+Integer.parseInt(num2)));
    }
}