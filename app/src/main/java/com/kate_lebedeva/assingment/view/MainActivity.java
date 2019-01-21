//
//  MainActivity.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//

package com.kate_lebedeva.assingment.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.kate_lebedeva.assingment.R;
import com.kate_lebedeva.assingment.databinding.MainBinding;
import com.kate_lebedeva.assingment.viewmodels.MainActivityViewModel;



public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupBindings(savedInstanceState);
    }

    private void setupBindings(Bundle savedInstanceState) {
        MainBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.main);
        mainViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        if (savedInstanceState == null) {
            new MainActivityViewModel();
        }
        activityBinding.setViewModel(mainViewModel);

    }

}
