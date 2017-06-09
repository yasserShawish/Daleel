package com.axioms.www.daleel.main;

import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.services.CategoryService;
import com.axioms.www.daleel.services.impl.CategoryServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad ababneh on 24/02/2017.
 */

public class MainInteractorImpl implements MainInteractor {

    CategoryService categoryService;

      public MainInteractorImpl(){
        categoryService = new CategoryServiceImpl();
    }


    @Override
    public String[] getAllCategory() {
        return new String[0];
    }

    @Override
    public List<MyCategory> findAllCategories() {
        return categoryService.findALlCategory();
    }
}
