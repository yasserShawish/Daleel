package com.axioms.www.daleel.services.impl;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.services.CategoryService;

import java.util.ArrayList;

/**
 * Created by Ahmad Ababneh on 29/04/2017.
 */

public class CategoryServiceImpl implements CategoryService{

    int[] categ_images = {R.drawable.food_fork_knife_restaurant_eating_glyph ,R.drawable.food_drink  ,R.drawable.popcorn ,R.drawable.cart ,R.drawable.medical_icon } ;
    String[] catiegory_array = {"مطاعم","مقاهي","ترفيه","تسوق","اطباء"};

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
