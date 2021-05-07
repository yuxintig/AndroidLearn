package com.shinonon.androidlearn.fish;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.shinonon.androidlearn.databinding.FragmentDialogBinding;


public class JumpDialog extends DialogFragment {

    FragmentDialogBinding v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = FragmentDialogBinding.inflate(getLayoutInflater());
        v.btnJump.setOnClickListener(view -> {
            String num1 = v.edNum1.getText().toString();
            String num2 = v.edNum2.getText().toString();
            JumpDialog.this.dismiss();
            Intent intent = new Intent(getActivity(), ResultActivity.class);
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);
            startActivity(intent);
        });

        v.btnCancel.setOnClickListener(view -> JumpDialog.this.dismiss());
        return v.getRoot();
    }
}
