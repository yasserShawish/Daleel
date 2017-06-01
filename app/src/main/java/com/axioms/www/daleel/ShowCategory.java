package com.axioms.www.daleel;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.axioms.www.daleel.Adapters.AdapterMarket;
import com.axioms.www.daleel.category.CategoryPresenterImpl;
import com.axioms.www.daleel.category.CategoryView;
import com.axioms.www.daleel.category.ICategoryPresenter;
import com.axioms.www.daleel.metadata.MarketMeta;
import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;
import com.axioms.www.daleel.utils.DallelConstant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowCategory extends AppCompatActivity implements CategoryView {

    @BindView(R.id.categ_name)
    TextView catgName;
    @BindView(R.id.cat_markets_list)
    ListView marketList;
    @BindView(R.id.cart_button)
    Button cartButton;

    ICategoryPresenter categoryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_category);
        ButterKnife.bind(this);
        categoryPresenter = new CategoryPresenterImpl(this);

        final MyCategory category = (MyCategory) getIntent().getSerializableExtra(DallelConstant.CATEGORY.getName());
        catgName.setText(category.getName());

        AdapterMarket adapter  = new AdapterMarket(this ,R.layout.market_list, (ArrayList<MarketMeta>) getCategoryMarket(category));
        marketList.setAdapter(adapter);
        marketList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MarketMeta marketMeta  = (MarketMeta) adapterView.getItemAtPosition(i);
                categoryPresenter.goToMarket(marketMeta);
            }
        });

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    public List<MarketMeta> getCategoryMarket(MyCategory category) {
        return categoryPresenter.getAllCategoryMarket(category);
    }

    @Override
    public void goToMarket(MarketMeta marketMeta) {
        Intent intent = new Intent(getApplicationContext() , MarketActivity.class);
        intent.putExtra(DallelConstant.MARKET.getName() , marketMeta);
        startActivity(intent);
  /*      Toast.makeText(getApplicationContext() , marketMeta.getName() , Toast.LENGTH_LONG).show();*/
    }

    @OnClick(R.id.cart_button)
    public void goToCart(){
        Intent intent = new Intent(this , ShowCart.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        int cartSize = ShoppingCartHolder.Instance().shoppingCartSize();
        if (cartSize > 0){
            cartButton.setText(String.format("%d" , cartSize));
            cartButton.setTextColor(Color.WHITE);
        }else{
            cartButton.setText(String.format("%d" , 0));
            cartButton.setTextColor(Color.RED);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
