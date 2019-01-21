//
//  DataModel.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.

package com.kate_lebedeva.assingment.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

public class DataModel {

    private String title;
    private String subtitle;
    private String amount;
    private Drawable photo;


    public DataModel(String title, String subtitle, String amount, Drawable photo){
        this.title = title;
        this.subtitle = subtitle;
        this.amount = amount;
        this.photo = photo;
    }

    @Nullable
    public String getTitle(){
        return title;
    }

    @Nullable
    public String getSubtitle(){
        return subtitle;
    }

    @Nullable
    public String getAmount(){
        return amount;
    }

    @Nullable
    public Drawable getDrawable(){
        return photo;
    }

}
