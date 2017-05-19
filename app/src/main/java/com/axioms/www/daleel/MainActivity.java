package com.axioms.www.daleel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.axioms.www.daleel.Adapters.CustomAdapter;
import com.axioms.www.daleel.main.MainInteractorImpl;
import com.axioms.www.daleel.main.MainPresenter;
import com.axioms.www.daleel.main.MainPresenterImpl;
import com.axioms.www.daleel.main.MainView;
import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;
import com.axioms.www.daleel.utils.DallelConstant;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemSelectedListener {


    @BindView(R.id.catig_list)
    AbsListView listView ;
    @BindView(R.id.city_spinner)
    Spinner spinner;
    @BindView(R.id.ads_image)
    ImageView adsImage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.cart_button)
    Button cartButton;

    MainPresenter presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        presenter = new MainPresenterImpl(this , new MainInteractorImpl());
        createListView();
        createSpinnerList();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void createSpinnerList() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);
    }

    private void createListView() {
        ArrayList<MyCategory> categories = getAllCategories();
        CustomAdapter category_adapter = new CustomAdapter(this , R.layout.custom_list , categories , ShoppingCartHolder.Instance());
        listView.setAdapter(category_adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyCategory category = (MyCategory) adapterView.getItemAtPosition(i);
                presenter.navigateToCategory(category);
            }
        });
    }

    private ArrayList<MyCategory> getAllCategories() {
        return presenter.getAllCategories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext()  , "test "+i , Toast.LENGTH_LONG ).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /*@OnClick(R.id.all_cat_botton)
    public void allCatClick() {
        presenter.showAllCategory();
    }
*/
    @OnClick(R.id.cart_button)
    public void goToCart(){
        Intent intent = new Intent(this , ShowCart.class);
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    public void showAllCategory() {
        Intent allCat = new Intent(getApplicationContext() , AllCategory.class);
        startActivity(allCat);
    }

    @Override
    public void navigateToCategory(MyCategory category) {
        Intent intent = new Intent(getApplicationContext() , ShowCategory.class);
        intent.putExtra(DallelConstant.CATEGORY.getName() ,category);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
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
