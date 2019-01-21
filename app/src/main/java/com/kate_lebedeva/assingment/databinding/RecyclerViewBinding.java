//
//  RecyclerViewBinding.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//
package com.kate_lebedeva.assingment.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.kate_lebedeva.assingment.adapter.RecyclerViewAdapter;


import static android.widget.LinearLayout.VERTICAL;

public class RecyclerViewBinding {
    // Bind a RecyclerView to an adapter without having to hold a hard reference to RecyclerView in the ViewModel
    @BindingAdapter({"setAdapter"})
    public void bind(RecyclerView recyclerView, RecyclerViewAdapter adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
        recyclerView.setAdapter(adapter);

    }
}
