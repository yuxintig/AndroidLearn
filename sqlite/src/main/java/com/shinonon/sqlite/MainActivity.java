package com.shinonon.sqlite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shinonon.sqlite.Dao.StudentDao;
import com.shinonon.sqlite.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private List<Student> students;
    private StudentDao dao;
    private Student currentStudent;
    private  StudentAdapter adapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dao = new StudentDao(this);
        students = dao.selectAll();
        //currentStudent = students==null ?null:students.get(0);

        initView();

    }

    private void initView(){
        binding.btnAdd.setOnClickListener(this);
        binding.btnUpdate.setOnClickListener(this);
        binding.btnDelete.setOnClickListener(this);

        binding.rvStudent.setLayoutManager(new LinearLayoutManager(this));
        binding.rvStudent.setItemAnimator(new DefaultItemAnimator());
        adapter = new StudentAdapter(students);
        binding.rvStudent.setAdapter(adapter);

        adapter.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v){
                StudentAdapter.ViewHolder viewHolder = (StudentAdapter.ViewHolder)v.getTag();
                int position = viewHolder.getAdapterPosition();
                adapter.setSelectedIndex(position);
                currentStudent = students.get(position);
            }
        });


    }

    private void changeData(){
        students.clear();
        students.addAll(dao.selectAll());
        adapter.notifyDataSetChanged();
    }


    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    changeData();
                }
            }
    );

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, InsertActivity.class);

        if(view.getId() == R.id.btn_add){
            launcher.launch(intent);
        }else if(view.getId() == R.id.btn_update){
            Bundle bundle = new Bundle();
            bundle.putSerializable("student",currentStudent);
            intent.putExtra("flag",1);
            intent.putExtras(bundle);
            launcher.launch(intent);
        }else if(view.getId() == R.id.btn_delete){
            new AlertDialog.Builder(this).setTitle("删除").setMessage("确认删除？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dao.delete(currentStudent.getId());
                            dialog.dismiss();
                            changeData();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        }



    }
}