package com.axioms.www.daleel.Market;

import com.axioms.www.daleel.metadata.MyCategory;

/**
 * Created by Ahmad Ababneh on 04/05/2017.
 */

public class MarketPresenterImpl implements MarketPresenter {
    MarketView activity;
    MarketInteractor interactor;

    public MarketPresenterImpl(MarketView activity , MarketInteractor interactor){
        this.activity = activity;
        this.interactor = interactor;
    }

    @Override
    public void goBack(MyCategory category) {
        activity.goBack(category);
    }
}
