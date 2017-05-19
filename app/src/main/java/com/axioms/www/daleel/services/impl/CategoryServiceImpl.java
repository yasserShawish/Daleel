package com.axioms.www.daleel.services.impl;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.services.CategoryService;

import java.util.ArrayList;

/**
 * Created by Ahmad Ababneh on 29/04/2017.
 */

public class CategoryServiceImpl implements CategoryService{

    int[] categ_images = {R.drawable.books ,R.drawable.resturntsfoods ,R.drawable.fernture,R.drawable.water} ;
    String[] catiegory_array = {"كتب","مطاعم","اثاث","مياه"};

    @Override
    public ArrayList<MyCategory> findALlCategory(){
        ArrayList<MyCategory> list = new ArrayList();

        for (int i = 0 ; i < categ_images.length;i++ ) {
            MyCategory category = new MyCategory();
            category.setId(i);
            category.setName(catiegory_array[i]);
            category.setImage(categ_images[i]);
            list.add(category);
        }

        return list;
    }
}
