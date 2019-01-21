//
//  SplashScreenActivity.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//
package com.kate_lebedeva.assingment.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.kate_lebedeva.assingment.view.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(intent);
        finish();
    }
}