package com.shinonon.androidlearn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private EditText etName,etIphone;
    private RadioGroup rgSex;
    private CheckBox cbJava,cbAndroid,cbEnglish,cbMath;
    private Button  btnDet;
    private String sex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = findViewById(R.id.etName);
        etIphone = findViewById(R.id.etIphone);
        rgSex = findViewById(R.id.rgSex);
        cbJava = findViewById(R.id.cbJava);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbEnglish = findViewById(R.id.cbEnglish);
        cbMath = findViewById(R.id.cbMath);
        btnDet = findViewById(R.id.btnDet);
        rgSex.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.rbMan){
                sex= "男";
            }else {
                sex = "女";
            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onClick(View v) {

    }
}