package com.axioms.www.daleel.category;

import com.axioms.www.daleel.metadata.MarketMeta;
import com.axioms.www.daleel.metadata.MyCategory;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 09/04/2017.
 */

public interface ICategoryInteractor {

    List<MarketMeta> findAllCategoryMarket(MyCategory category);
}
