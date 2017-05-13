package com.axioms.www.daleel.category;

import com.axioms.www.daleel.ShowCategory;
import com.axioms.www.daleel.metadata.MarketMeta;
import com.axioms.www.daleel.metadata.MyCategory;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 09/04/2017.
 */

public class CategoryPresenterImpl implements ICategoryPresenter {

    private ICategoryInteractor categoryInteractor;
    private CategoryView categoryView;

    public CategoryPresenterImpl(CategoryView categoryView){
        categoryInteractor = new CategoryInteractorImpl();
        this.categoryView = categoryView;
    }

    @Override
    public List<MarketMeta> getAllCategoryMarket(MyCategory category) {
        return categoryInteractor.findAllCategoryMarket(category);
    }

    @Override
    public void goToMarket(MarketMeta marketMeta) {
        categoryView.goToMarket(marketMeta);
    }
}
