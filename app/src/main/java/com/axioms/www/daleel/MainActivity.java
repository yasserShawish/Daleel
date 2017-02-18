package com.axioms.www.daleel;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    int[] categ_images = {R.drawable.food_fork_knife_restaurant_eating_glyph ,R.drawable.food_drink  ,R.drawable.popcorn ,R.drawable.cart ,R.drawable.medical_icon } ;
    String[] catiegory_array = {"مطاعم","مقاهي","ترفيه","تسوق","اطباء"};
    ListView listView ;
    Spinner spinner;
    Button allCatg;
    ImageButton left_ad_nav;
    ImageButton right_ad_nav;
    ImageView adsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bindAllTheElements();

        setACtionListener();

        createListView();

        createSpinnerList();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void setACtionListener() {
        allCatg.setOnClickListener(this);
    }

    private void bindAllTheElements() {
        spinner = (Spinner) findViewById(R.id.city_spinner);
        listView = (ListView) findViewById(R.id.catig_list);
        adsImage = (ImageView) findViewById(R.id.ads_image);
        left_ad_nav = (ImageButton) findViewById(R.id.arro_left);
        right_ad_nav = (ImageButton) findViewById(R.id.arro_right);
        allCatg = (Button) findViewById(R.id.all_cat_botton);
    }

    private void createSpinnerList() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);
    }

    private void createListView() {
        CustomAdapter category_adapter = new CustomAdapter(this ,catiegory_array , categ_images);
        listView.setAdapter(category_adapter);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.all_cat_botton:
                Intent allCat = new Intent(getApplicationContext() , AllCategory.class);
                startActivity(allCat);
            break;
            default:
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
