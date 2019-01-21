//
//  DataItemViewModel.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//

package com.kate_lebedeva.assingment.viewmodels;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.kate_lebedeva.assingment.model.DataModel;

public class DataItemViewModel {

    private DataModel dataModel;

    public DataItemViewModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }


    public String getTitle() {
        return !TextUtils.isEmpty(dataModel.getTitle()) ? dataModel.getTitle() : "";
    }


    public String getSubtitle(){
        return !TextUtils.isEmpty(dataModel.getSubtitle()) ? dataModel.getSubtitle() : "";
    }


    public String getAmount(){
        return !TextUtils.isEmpty(dataModel.getAmount()) ? dataModel.getAmount() : "";
    }

    public Drawable getDrawable(){
        return dataModel.getDrawable();
    }
}
