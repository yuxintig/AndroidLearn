package com.shinonon.advance.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.shinonon.framework.base.BaseFragment;
import com.shinonon.advance.R;
import com.shinonon.advance.databinding.FragmentNotificationBinding;


public class NotificationFragment extends BaseFragment<FragmentNotificationBinding> {


    public static NotificationFragment newInstance() {
        return new NotificationFragment();
    }

    @Override
    public void inCreateView() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v.tvNotification.setText(R.string.life_is_a_very_funny_proposition_after_all);
    }

}