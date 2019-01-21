//
//  RecyclerViewAdapter.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//

package com.kate_lebedeva.assingment.adapter;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.kate_lebedeva.assingment.BR;
import com.kate_lebedeva.assingment.model.DataModel;
import com.kate_lebedeva.assingment.viewmodels.DataItemViewModel;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private int layoutId;
    private List<DataModel> items;

    public RecyclerViewAdapter(@LayoutRes int layoutId, List<DataModel> data){
        this.layoutId = layoutId;
        this.items = data;
    }

    private int getLayoutId(int position) {
        return layoutId;
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutId(position);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new RecyclerViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder recyclerViewHolder, int position) {
        DataModel dataModel = items.get(position);
        recyclerViewHolder.bindHolder(new DataItemViewModel(dataModel));
    }


    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
       private final ViewDataBinding binding;


       public RecyclerViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

       public void bindHolder(DataItemViewModel viewModel) {
            binding.setVariable(BR.viewModel, viewModel);
            binding.executePendingBindings();
        }

    }
}
