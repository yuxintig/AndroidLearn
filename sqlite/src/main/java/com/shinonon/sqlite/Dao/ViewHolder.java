package com.shinonon.sqlite.Dao;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.shinonon.sqlite.databinding.ItemStudentBinding;

public class ViewHolder extends RecyclerView.ViewHolder {
    ItemStudentBinding binding;

    public ViewHolder(ItemStudentBinding binding){
        super(binding.getRoot());
        this.binding = binding;
        this.itemView.setTag(this);
        this.itemView.setOnClickListener(onClickListener);
        this.itemView.setOnLongClickListener(onLongClickListener);



    }


    private  View.OnClickListener onClickListener = null;
    private View.OnLongClickListener onLongClickListener = null;
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
}
