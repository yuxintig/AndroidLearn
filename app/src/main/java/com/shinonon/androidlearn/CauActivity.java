package com.shinonon.androidlearn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.googlecode.aviator.AviatorEvaluator;

public class CauActivity extends AppCompatActivity {

    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridlayout);
        input = findViewById(R.id.tv_input);
    }

    public void cal(View view) {
        Object result = AviatorEvaluator.execute(input.getText().toString().replace("x","*"));
        input.setText(input.getText().toString()+"="+"\n"+result.toString());

    }

    public void input(View view) {
        Button btn = (Button) view;
        input.setText(input.getText().toString().equals("0")?btn.getText().toString():input.getText().toString()+btn.getText());
    }

    public void clear(View view) {
        input.setText("0");
    }

    public void back(View view) {

    }

    public void percent(View view) {

    }
}