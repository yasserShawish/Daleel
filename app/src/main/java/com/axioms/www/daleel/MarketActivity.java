package com.axioms.www.daleel;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.axioms.www.daleel.Adapters.GenericExpandableListAdapter;
import com.axioms.www.daleel.Adapters.OfferAdapter;
import com.axioms.www.daleel.Market.MarketInteractorImpl;
import com.axioms.www.daleel.Market.MarketPresenter;
import com.axioms.www.daleel.Market.MarketPresenterImpl;
import com.axioms.www.daleel.Market.MarketView;
import com.axioms.www.daleel.metadata.MarketMeta;
import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.metadata.OfferMeta;
import com.axioms.www.daleel.metadata.Price;
import com.axioms.www.daleel.metadata.ProductFamily;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;
import com.axioms.www.daleel.utils.ApiUtils;
import com.axioms.www.daleel.utils.DallelConstant;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MarketActivity extends AppCompatActivity implements MarketView {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    static MarketPresenter presenter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.market_name_text)
    TextView marketName;
    @BindView((R.id.market_image))
    ImageView marketImage;
    @BindView(R.id.cart_button)
    Button cartButton;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.market_city_text)
    TextView marketCity;
    @BindView(R.id.market_distance_text)
    TextView distanceText;
    @BindView(R.id.market_delvery_text)
    TextView delveryPrice;
    static MarketMeta marketMeta;
    Location currentLocation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        ButterKnife.bind(this);
        presenter = new MarketPresenterImpl(this , new MarketInteractorImpl());

        marketMeta = (MarketMeta) getIntent().getSerializableExtra(DallelConstant.MARKET.getName());
        marketName.setText(marketMeta.getName());
        marketCity.setText(marketMeta.getAddress().getCity());
        marketImage.setImageResource(marketMeta.getImage());
        this.setTitle(marketMeta.getName());

        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager() , marketMeta);

        // Set up the ViewPager with the sections adapter.
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout.setupWithViewPager(mViewPager);

        ShoppingCartHolder shoppingCartHolder = ShoppingCartHolder.Instance();
        cartButton.setText(String.format("%d", shoppingCartHolder.getCart().getSize()));
        cartButton.setTextColor(Color.RED);
        Gson gson = new Gson();
        SharedPreferences shared = getSharedPreferences(
                DallelConstant.SHARED_PREF_NAME.getName()
                , MODE_PRIVATE);
        currentLocation = gson.fromJson(shared.getString(DallelConstant.USER_LOCATION.getName(), null), Location.class);
        distanceLocation();
    }
    public void distanceLocation(){
        if(currentLocation != null){
            Location marketLocation = new Location("marketLocation");
            marketLocation.setLatitude(marketMeta.getAddress().getLatitude());
            marketLocation.setLongitude(marketMeta.getAddress().getLongitude());

            Double dis = (ApiUtils.distanceBetween(currentLocation , marketLocation))/1000.0;//transfer the distance from meters to km
            DecimalFormat df = new DecimalFormat("#.##");
            String distance = df.format(dis);
            distanceText.setText("المسافه: "+distance+"كم");
            Price dPrice = marketMeta.getDeliveryPrice();
            if(dPrice != null){
                delveryPrice.setText("سعر التوصيل: "+(ApiUtils.convertDigits(String.valueOf(Math.round(dis)*dPrice.getPrice())))+dPrice.getCurrency().getCurrencyCode());
            }
        }
    }

    @OnClick(R.id.fab)
    public void returnToBack(){
        presenter.goBack(marketMeta.getCategory());
    }
    @OnClick(R.id.cart_button)
    void productDetails(){
    }
    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_market, menu);
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
    public void goBack(MyCategory category) {
        /*Intent intent = new Intent(this , ShowCategory.class);
        intent.putExtra(DallelConstant.CATEGORY.getName() ,category );
        startActivity(intent);*/
        finish();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static View rootView;

        public PlaceholderFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber , MarketMeta marketMeta) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER,sectionNumber);
            args.putSerializable(DallelConstant.MARKET.getName() , marketMeta);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //in this method the process of rendering the taps happens here (need to clean up)
            int section_number = getArguments().getInt(ARG_SECTION_NUMBER);
            rootView = inflater.inflate(getLayoutId(section_number), container, false);
            if(section_number == 1){
                List<ProductFamily> pfList = marketMeta.getProductFamily();
                GenericExpandableListAdapter productAdapter =
                        new GenericExpandableListAdapter(getContext() ,pfList , marketMeta.getChildProductMap(),
                                R.layout.product_group_lay ,R.layout.products_list_lay);
                ExpandableListView productsList = (ExpandableListView) rootView.findViewById(R.id.products_list);
                productsList.setAdapter(productAdapter);
            }else if(section_number == 2){
                OfferAdapter<OfferMeta> adapter = new OfferAdapter(getContext() , R.layout.offers_templates , marketMeta.getOffers());
                AbsListView offersListView = (AbsListView) rootView.findViewById(R.id.offers_list_view);
                offersListView.setAdapter(adapter);
                offersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(getContext() , "offer "+i , Toast.LENGTH_SHORT).show();
                    }
                });
            }else if(section_number == 3){
                //here just we render the contact information about the current market
                renderMarketInformation(marketMeta);
            }
            return rootView;
        }

        private void renderMarketInformation(MarketMeta currentMarket) {
            TableRow informationName = (TableRow) rootView.findViewById(R.id.name_row);
            TextView nameText = new TextView(getContext());
            nameText.setText(getString(R.string.market_name_info)+currentMarket.getName());
            informationName.addView(nameText);
            //-----------------name
            TableRow informationCity = (TableRow) rootView.findViewById(R.id.city_row);
            TextView cityText = new TextView(getContext());
            cityText.setText(getString(R.string.city_info)+currentMarket.getAddress().getCity());
            informationCity.addView(cityText);
            //-----------------city
            TableRow informationPhone = (TableRow) rootView.findViewById(R.id.phone_row);
            TextView phoneText = new TextView(getContext());
            phoneText.setText(getString(R.string.phone_number_info)+currentMarket.getAddress().getPhoneNumber());
            informationPhone.addView(phoneText);
            //-----------------phone
            TableRow informationFax = (TableRow) rootView.findViewById(R.id.fax_row);
            TextView faxText = new TextView(getContext());
            faxText.setText(getString(R.string.fax_info)+currentMarket.getAddress().getFax());
            informationFax.addView(faxText);
            //-----------------fax
            TableRow informationAddress = (TableRow) rootView.findViewById(R.id.address_row);
            TextView addressText = new TextView(getContext());
            addressText.setText(String.format(getString(R.string.address_info)+"%s", currentMarket.getAddress().getAddressLine()));
            informationAddress.addView(addressText);
            //-----------------address

        }

        private CharSequence getTabTitle(int section_number) {
            String[] titles = getResources().getStringArray(R.array.tabs_titles);
            return titles[section_number];
        }

        private int getLayoutId(int postion) {
            switch (postion){
                case 1:
                    return R.layout.main_menu_layout;
                case 2:
                    return R.layout.offers_layout;
                case 3:
                    return R.layout.location_information_layout;
                default:
                    return R.layout.fragment_market;
            }
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        MarketMeta marketMeta;
        public SectionsPagerAdapter(FragmentManager fm , MarketMeta marketMeta) {
            super(fm);
            this.marketMeta = marketMeta;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1 , marketMeta);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            int totalNumberofPages = getResources().getInteger(R.integer.numberOfTabsForMarket);
            return totalNumberofPages;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String[] titles = getResources().getStringArray(R.array.tabs_titles);
            return titles[position];
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
