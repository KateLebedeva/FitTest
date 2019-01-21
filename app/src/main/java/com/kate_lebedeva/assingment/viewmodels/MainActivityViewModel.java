//
//  MainActivityViewModel.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//

package com.kate_lebedeva.assingment.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.ObservableBoolean;


import com.kate_lebedeva.assingment.App;
import com.kate_lebedeva.assingment.R;
import com.kate_lebedeva.assingment.adapter.RecyclerViewAdapter;
import com.kate_lebedeva.assingment.model.DataModel;
import com.kate_lebedeva.assingment.utils.CSVUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean();
    private RecyclerViewAdapter adapter;
    private List<DataModel> data;
    private CSVUtil csvUtil;


    public MainActivityViewModel(){
        initCsvUtil();
        data = new ArrayList<>();
        fetchData();
        adapter = new RecyclerViewAdapter(R.layout.item, data);

    }


    // Initialise class for fetching and parsing data from .csv file
    private void initCsvUtil(){
        Context context = App.getAppContext();
        InputStream inputStream=context.getResources().openRawResource(R.raw.test_data);
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        csvUtil = new CSVUtil(inputStream, resources, packageName);
    }

    public List<DataModel> getData(){
        return this.data;
    }

    public RecyclerViewAdapter getAdapter(){
        return this.adapter;
    }

    // Gets main applications data
    private void fetchData(){
        this.data = csvUtil.getDataFromCsv();
        isLoading.set(false);

    }

    public void onRefresh() {
        isLoading.set(true);
        fetchData();
    }


}
