//
//  CSVUtil.java
//  FitTest
//
//  Created by Kate Lebedeva on 1/19/19.
//  Copyright © 2019 Kate Lebedeva. All rights reserved.
//

package com.kate_lebedeva.assingment.utils;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.kate_lebedeva.assingment.model.DataModel;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    private InputStream inputStream;
    private Resources resources;
    private String packageName;
    private Integer indexesAmount = 2;

    public CSVUtil(InputStream inputStream, Resources resources, String packageName){
        this.inputStream = inputStream;
        this.resources = resources;
        this.packageName = packageName;
    }

    public List<DataModel> getDataFromCsv(){

        CSVReader reader;
        List<DataModel> items = new ArrayList<>();

        try {
            // Omits the first row from the .csv file
            reader = new CSVReader(new InputStreamReader(inputStream), CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER, 1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                // Check if all needed indexes exist
                if(line.length >= indexesAmount) {
                    DataModel obj = new DataModel(capitalize(line[0]), capitalize(line[1]), line[2], getDrawableByName(line[0]));
                    items.add(obj);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
    // Makes first letters capital
    private String capitalize(String str){
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        return cap;
    }

    // Sets images for items
    private Drawable getDrawableByName(String name) {
        int resourceId = resources.getIdentifier(name.toLowerCase(), "mipmap", packageName);
        int defaultResource = resources.getIdentifier("ic_launcher_foreground","mipmap", packageName);
        if (resourceId!=0) {
            return resources.getDrawable(resourceId);
        } else {
            return resources.getDrawable(defaultResource);
        }
    }



}
