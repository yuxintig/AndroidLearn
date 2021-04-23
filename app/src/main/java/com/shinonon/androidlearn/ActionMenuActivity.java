package com.shinonon.androidlearn;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.shinonon.androidlearn.databinding.ActivityActionMenuBinding;

public class ActionMenuActivity extends AppCompatActivity {
    private ActivityActionMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActionMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        registerForContextMenu(binding.edTest);

        binding.edTest.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return false;
            }
        });
    }
//浮动菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected
            (@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.copy: tmpStr = binding.edTest.getText().toString();
                return true;
            case R.id.paste: binding.edTest.setText(tmpStr);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    //溢出菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    String tmpStr;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.copy: tmpStr = binding.edTest.getText().toString();
            return true;
            case R.id.paste: binding.edTest.setText(tmpStr);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}