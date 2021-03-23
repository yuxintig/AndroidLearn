package com.shinonon.androidlearn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class BmiActivity extends AppCompatActivity {
    private TextInputEditText edWeight,edHeight;
    private TextView result;
    private Button calculate;
    private RadioGroup gender;
    boolean isman ;
    boolean iswoman;
    @SuppressLint({"SetTextI18n","DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_bmi);
        edWeight = findViewById(R.id.weight);
        edHeight = findViewById(R.id.height);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);
        gender = findViewById(R.id.grander);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.man){
                     isman = true;
                }else {
                    iswoman = true;
                }
            }
        });
        calculate.setOnClickListener(v -> {
            double bmi;
            double weight = Double.parseDouble(edWeight.getText().toString());
            double height = Double.parseDouble(edHeight.getText().toString());
            bmi = weight/(height*height);
            if(isman){
                if(bmi<20){
                    result.setText("BMI: "+bmi+"\n 诊断： 体重过轻");
                }else if(bmi<25 && bmi >= 20 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 体重正常");
                }else if(bmi<27 && bmi >= 25 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 体重超重");
                }else if(bmi<30 && bmi >= 27 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 轻度肥胖");
                }else if(bmi<35 && bmi >= 30 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 中度肥胖");
                }else if(bmi >= 35 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 重度肥胖");
                }
            }else {
                if(bmi<19){
                    result.setText("BMI: "+bmi+"\n 诊断： 体重过轻");
                }else if(bmi<24 && bmi >= 19 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 体重正常");
                }else if(bmi<26 && bmi >= 24 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 体重超重");
                }else if(bmi<29 && bmi >= 26 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 轻度肥胖");
                }else if(bmi<34 && bmi >= 29 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 中度肥胖");
                }else if(bmi >= 34 ){
                    result.setText("BMI: "+bmi+"\n 诊断： 重度肥胖");
                }
            }

        });

    }
}