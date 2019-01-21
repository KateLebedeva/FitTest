//
//  App.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//
package com.kate_lebedeva.assingment;

import android.app.Application;
import android.content.Context;
import android.databinding.DataBindingUtil;

import com.kate_lebedeva.assingment.databinding.ApplicationDatabindingComponent;

public class App extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        // Sets custom data binding component
        DataBindingUtil.setDefaultComponent(new ApplicationDatabindingComponent());
        appContext = getApplicationContext();
    }

    // Needed for CSVUtil
    public static Context getAppContext() {
        return appContext;
    }
}