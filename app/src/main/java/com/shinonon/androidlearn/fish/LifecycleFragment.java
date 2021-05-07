package com.shinonon.androidlearn.fish;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shinonon.androidlearn.databinding.FragmentLifecycleBinding;

public class LifecycleFragment extends Fragment {
    FragmentLifecycleBinding v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Fragment>>>>>>", "onCreateView");
        v = FragmentLifecycleBinding.inflate(getLayoutInflater());
        return v.getRoot();
    }


    @Override
    public void onInflate(Activity activity, AttributeSet attrs,
                          Bundle savedInstanceState) {
        Log.d("Fragment>>>>>>", "onInflate");
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d("Fragment>>>>>>", "onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Fragment>>>>>>", "onCreate");
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d("Fragment>>>>>>", "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("Fragment>>>>>>", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("Fragment>>>>>>", "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("Fragment>>>>>>", "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("Fragment>>>>>>", "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("Fragment>>>>>>", "onStop");

        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("Fragment>>>>>>", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("Fragment>>>>>>", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("Fragment>>>>>>", "onDetach");
        super.onDetach();
    }

}