package com.axioms.www.daleel;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.axioms.www.daleel.Adapters.CustomAdapter;
import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;
import com.axioms.www.daleel.services.CategoryService;
import com.axioms.www.daleel.services.impl.CategoryServiceImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AllCategory extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @BindView(R.id.all_category_list)
    ListView allCat_list;
    @BindView(R.id.cart_button)
    Button cartButton;
    CategoryService categoryService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);
        ButterKnife.bind(this);
        categoryService = new CategoryServiceImpl();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        createListViewAdapter();
    }

    private void createListViewAdapter() {
        ArrayList<MyCategory> allCategories = categoryService.findALlCategory();
        CustomAdapter adapter = new CustomAdapter(this , R.layout.custom_list ,allCategories , ShoppingCartHolder.Instance());
        allCat_list.setAdapter(adapter);
        allCat_list.setOnItemSelectedListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
}
