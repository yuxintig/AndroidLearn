package com.shinonon.course;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import com.shinonon.course.java.databinding.ActivityProfileBinding;
import com.shinonon.framework.base.BaseActivity;

public class ProfileActivity extends BaseActivity<ActivityProfileBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSharedPreferences();
        v.tvName.setOnClickListener(v->{
            showDialogAndSave("姓名","s_name");
        });
        v.tvClass.setOnClickListener(v->{
            showDialogAndSave("班级","s_class");

        });
        v.tvCollege.setOnClickListener(v->{
            showDialogAndSave("学院","s_college");
        });
    }

    private void getSharedPreferences(){
        SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("date", Context.MODE_PRIVATE);
        v.tvName.setText("姓名："+
                sharedPreferences.getString("s_name","")
        );
        v.tvClass.setText("班级："+
                sharedPreferences.getString("s_class","")
        );
        v.tvCollege.setText("学院："+
                sharedPreferences.getString("s_college","")
        );
    }

    private void showDialogAndSave(String title,String key){
        EditText editText = new EditText(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(title).setView(editText)
                    .setNegativeButton("Cancel", null);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("date", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(key,editText.getText().toString());
                    editor.apply();
                    getSharedPreferences();
                }
            });
            builder.show();
    }
}