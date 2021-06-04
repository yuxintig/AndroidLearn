package com.shinonon.androidlearn.fish;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.shinonon.androidlearn.R;
import com.shinonon.androidlearn.databinding.ActivityWorkBinding;


public class WorkActivity extends AppCompatActivity {
    ActivityWorkBinding v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = ActivityWorkBinding.inflate(getLayoutInflater());
        setContentView(v.getRoot());
        v.btn1.setOnClickListener(view->{
            String num1 = v.ed1.getText().toString();
            String num2 = v.ed2.getText().toString();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);
            startActivity(intent);
        });

        v.btn2.setOnClickListener(view->{
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new LifecycleFragment())
                    .commit();
        });

        v.btn3.setOnClickListener(view->{
            JumpDialog dialog = new JumpDialog();
            dialog.show(getSupportFragmentManager(),"dialog");
        });
    }
}