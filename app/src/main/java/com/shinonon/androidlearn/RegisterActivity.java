package com.shinonon.androidlearn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private LinearLayout signLayout;
    private EditText etName,etIphone;
    private RadioGroup rgSex;
    private CheckBox cbJava,cbAndroid,cbEnglish,cbMath;
    private Button  btnDet;
    private String sex;
    private String select = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signLayout = findViewById(R.id.sign );
        etName = findViewById(R.id.etName);
        etIphone = findViewById(R.id.etIphone);
        rgSex = findViewById(R.id.rgSex);
        cbJava = findViewById(R.id.cbJava);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbEnglish = findViewById(R.id.cbEnglish);
        cbMath = findViewById(R.id.cbMath);
        btnDet = findViewById(R.id.btnDet);

        cbJava.setOnCheckedChangeListener(this);
        cbAndroid.setOnCheckedChangeListener(this);
        cbEnglish.setOnCheckedChangeListener(this);
        cbMath.setOnCheckedChangeListener(this);
        btnDet.setOnClickListener(this);


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
        CheckBox checkBox = (CheckBox) buttonView;
        if(isChecked){
            select += checkBox.getText().toString() + ",";
        }else{
            select = select.replace(checkBox.getText().toString()+
                    ",","");
        }
        Snackbar.make(signLayout,select,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString().trim();
        String iphone = etIphone.getText().toString().trim();
        String result = "用户名: " + name + "   手机号: " + iphone + "    性别 : " +sex +"\n喜欢的课程: "
                +select;

        Snackbar.make(signLayout,result,Snackbar.LENGTH_LONG)
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RegisterActivity.this,
                                "信息已确认", Toast.LENGTH_LONG).show();
                    }
                }).show();

    }

}


