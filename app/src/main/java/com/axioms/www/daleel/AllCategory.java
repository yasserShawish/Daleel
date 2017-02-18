package com.axioms.www.daleel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



public class AllCategory extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    int[] categ_images = {R.drawable.food_fork_knife_restaurant_eating_glyph ,R.drawable.food_drink  ,R.drawable.popcorn ,R.drawable.cart ,R.drawable.medical_icon , R.drawable.food_fork_knife_restaurant_eating_glyph ,R.drawable.food_drink  ,R.drawable.popcorn ,R.drawable.cart ,R.drawable.medical_icon } ;
    String[] catiegory_array = {"مطاعم","مقاهي","ترفيه","تسوق","اطباء" , "مطاعم","مقاهي","ترفيه","تسوق","اطباء"};
    ListView allCat_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        bindElement();

        createListViewAdapter();
    }

    private void createListViewAdapter() {
        CustomAdapter adapter = new CustomAdapter(this , catiegory_array ,categ_images);
        allCat_list.setAdapter(adapter);
        allCat_list.setOnItemSelectedListener(this);
    }

    private void bindElement() {
        allCat_list = (ListView) findViewById(R.id.all_category_list);
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
}
