package com.shinonon.advance.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kirshi.framework.base.BaseFragment;
import com.shinonon.advance.R;
import com.shinonon.advance.databinding.FragmentDashboradChildBinding;


public class DashboradChildFragment extends BaseFragment<FragmentDashboradChildBinding> {
    private static final String ARGUMENT_POSITION = "argument_position";

    public static DashboradChildFragment newInstance(int position) {
        DashboradChildFragment fragment = new DashboradChildFragment();
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            int position = getArguments().getInt(ARGUMENT_POSITION);
            v.tvDashboard.setText(position == 0 ? R.string.do_not_stop_believing : R.string.life_is_a_very_funny_proposition_after_all);
        }
    }

    @Override
    public void inCreateView() {

    }
}