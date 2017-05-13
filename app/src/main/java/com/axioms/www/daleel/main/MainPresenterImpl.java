package com.axioms.www.daleel.main;

import com.axioms.www.daleel.metadata.MyCategory;

import java.util.ArrayList;

/**
 * Created by Ahmad Ababneh on 24/02/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    MainView mainView;
    MainInteractor interactor;

    public MainPresenterImpl(MainView mainView  , MainInteractor mainInteractor){
        this.mainView = mainView;
        this.interactor = mainInteractor;
    }

    @Override
    public void showAllCategory() {
        mainView.showAllCategory();
    }

    @Override
    public void navigateToCategory(MyCategory category) {
        mainView.navigateToCategory(category);
    }

    @Override
    public ArrayList<MyCategory> getAllCategories() {
        return interactor.findAllCategories();
    }
}
