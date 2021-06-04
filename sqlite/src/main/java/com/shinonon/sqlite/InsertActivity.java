package com.shinonon.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.shinonon.sqlite.Dao.StudentDao;
import com.shinonon.sqlite.databinding.ActivityInsertBinding;

/**
 * @author Shinonon
 */
public class InsertActivity extends AppCompatActivity implements View.OnClickListener{
    StudentDao StudentDao;
    private Student currentStudent;
    private boolean isUpdate  = false;
    private ActivityInsertBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        StudentDao = new StudentDao(this);
        binding.btnConfirm.setOnClickListener(this);
        binding.btnCancel.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            currentStudent = (Student)bundle.get("student");
        }

        if(currentStudent != null){
            isUpdate = true;
            binding.etName.setText(currentStudent.getName());
            binding.etAge.setText(String.valueOf(currentStudent.getAge()));

            SpinnerAdapter spinnerAdapter = binding.spClassmate.getAdapter();
            for(int i = 0;i<spinnerAdapter.getCount();i++){
                if (spinnerAdapter.getItem(i).toString()
                .equals(currentStudent.getClassmate())){
                    binding.spClassmate.setSelection(i);
                    break;
                }
            }
        }


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_confirm){
            Student student = new Student(
                    binding.etName.getText().toString(),
                    binding.spClassmate.getSelectedItem().toString(),
                    Integer.parseInt(binding.etAge.getText().toString())
            );
            if(isUpdate) {
                student.setId(currentStudent.getId());
                StudentDao.update(student);
            }else {
                StudentDao.insert(student);
            }
            setResult(RESULT_OK,new Intent());
            finish();
        }else if(v.getId() == R.id.btn_cancel){
            finish();

        }

    }
}
