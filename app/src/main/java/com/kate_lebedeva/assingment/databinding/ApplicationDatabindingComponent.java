//
//  ApplicationDatabindingComponent.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//
package com.kate_lebedeva.assingment.databinding;

public class ApplicationDatabindingComponent implements android.databinding.DataBindingComponent {
    @Override
    public RecyclerViewBinding getRecyclerViewBinding() {
        return new RecyclerViewBinding();
    }
}