package com.axioms.www.daleel.category;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.MarketMeta;
import com.axioms.www.daleel.metadata.MyAddress;
import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.metadata.OfferMeta;
import com.axioms.www.daleel.metadata.Price;
import com.axioms.www.daleel.metadata.Product;
import com.axioms.www.daleel.metadata.ProductFamily;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;
import com.axioms.www.daleel.utils.ApiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmad Ababneh on 09/04/2017.
 */

public class CategoryInteractorImpl implements ICategoryInteractor{


    @Override
    public List<MarketMeta> findAllCategoryMarket(MyCategory category) {
        MyAddress address1 = new MyAddress();
        address1.setCountry("الاردن");
        address1.setCity("اربد");
        address1.setEmail("test@test.com");
        address1.setPhoneNumber("0788722431");
        address1.setFax("1100548");
        address1.setAddressLine("اربد مجمع عمان الجديد و شارع الجامعه");
        address1.setLatitude(32.537135);
        address1.setLongitude(35.870043);
        MarketMeta market1 = new MarketMeta("شورمجي", address1);
        market1.setmId(Long.valueOf(1));
        market1.setCategory(category);
        market1.setImage(R.drawable.shawermaji);
        market1.setProductFamily(getFackFamilyProductList());
        market1.setOffers(getFakeOffers());
        market1.setDeliveryPrice(new Price(0.5 , ApiUtils.getDefaultCurrency()));
        //----------------------------------------1
        MyAddress address2 = new MyAddress();
        address2.setCountry("الاردن");
        address2.setCity("اربد");
        address2.setEmail("test@test.com");
        address2.setPhoneNumber("0788722431");
        address2.setFax("1100548");
        address2.setAddressLine("اربد مجمع عمان الجديد و خلف شارع الجامعه");
        MarketMeta market2 = new MarketMeta("خان زيد", address2);
        market2.setmId(Long.valueOf(2));
        market2.setCategory(category);
        market2.setImage(R.drawable.khan_zaid);
        market2.setProductFamily(getFackFamilyProductList());
        market2.setOffers(getFakeOffers());
        //----------------------------------------2
        MyAddress address3 = new MyAddress();
        address3.setCountry("الاردن");
        address3.setCity("اربد");
        address3.setEmail("test@test.com");
        address3.setPhoneNumber("0788722431");
        address3.setFax("1100548");
        address3.setAddressLine("اربد خلف شارع الجامعه");
        MarketMeta market3 = new MarketMeta("دلع كرشك", address3);
        market3.setmId(Long.valueOf(3));
        market3.setCategory(category);
        market3.setImage(R.drawable.aleakarshak);
        market3.setProductFamily(getFackFamilyProductList());
        market3.setOffers(getFakeOffers());
        //----------------------------------------3
        MyAddress address4 = new MyAddress();
        address4.setCountry("الاردن");
        address4.setCity("اربد");
        address4.setEmail("test@test.com");
        address4.setPhoneNumber("0788722431");
        address4.setFax("1100548");
        address4.setAddressLine("اربد شارع الثلاثين");
        MarketMeta market4 = new MarketMeta("اسامه", address4);
        market4.setmId(Long.valueOf(4));
        market4.setCategory(category);
        market4.setImage(R.drawable.osama);
        market4.setProductFamily(getFackFamilyProductList());
        market4.setOffers(getFakeOffers());
        //----------------------------------------4
        MyAddress address5 = new MyAddress();
        address5.setCountry("الاردن");
        address5.setCity("اربد");
        address5.setEmail("test@test.com");
        address5.setPhoneNumber("0788722431");
        address5.setFax("1100548");
        address5.setAddressLine("اربد شارع الثلاثين");
        MarketMeta market5 = new MarketMeta("سمسمه", address5);
        market5.setmId(Long.valueOf(5));
        market5.setCategory(category);
        market5.setImage(R.drawable.semsemeh);
        market5.setProductFamily(getFackFamilyProductList());
        market5.setOffers(getFakeOffers());
        //----------------------------------------5

        List<MarketMeta> markets = new ArrayList<>();
        markets.add(market1);
        markets.add(market2);
        markets.add(market3);
        markets.add(market4);
        markets.add(market5);

        return markets;
    }

    private List<ProductFamily> getFackFamilyProductList(){
        String[] labels = { "ساندويش", "وجبات دجاج"};
        List<ProductFamily> list = new ArrayList<>(2);
        ProductFamily family = new ProductFamily(labels[0]);
        family.setmId((long)0);
        family.setProducts(getFackProductsSandesh());
        list.add(family);

        ProductFamily family1 = new ProductFamily(labels[1]);
        family1.setmId((long)1);
        family1.setProducts(getFackProductsMeals());
        list.add(family1);
        return list;
    }
    private List<Item> getFackProductsSandesh(){


        String[] names = {"سندويشه شورما سوبر","سندويشه شورما عادي"};
        double[] prices = {1.00 ,0.75};
        int[] images =  {R.drawable.supersandesh, R.drawable.normalsandesh};

        List<Item> products = new ArrayList<>();
        for(int i = 0 ; i < names.length ; i++){
            Product product = new Product(names[i]);
            product.setPrice(new Price(prices[i] , ApiUtils.getDefaultCurrency()));
            product.setImage(images[i]);
            products.add(product);
        }
        return products;
    }

    private List<Item> getFackProductsMeals(){

        String[] names = {"وجبه شورما عادي" , "وجبه شورما سوبر" , "وجبه شورما دبل" , "وجبه شورما ايطالي"};
        double[] prices = { 1.5,2.25 ,2.27 ,3.00};
        int[] images =  {R.drawable.normalmeal , R.drawable.supermeal , R.drawable.doublemeal , R.drawable.etalymeal};

        List<Item> products = new ArrayList<>();
        for(int i = 0 ; i < names.length ; i++){
            Product product = new Product(names[i]);
            product.setPrice(new Price(prices[i] ,ApiUtils.getDefaultCurrency()));
            product.setImage(images[i]);
            products.add(product);
        }
        return products;
    }

    public List<Item> getFakeOffers() {
        List<Item> fakeOffers = new ArrayList<>();

        for (int i = 0 ; i < 5 ; i++){
            OfferMeta offerMeta = new OfferMeta();
            offerMeta.setmId((long)i);
            offerMeta.setImage(R.drawable.family_offer);
            offerMeta.setDescription("عرض العائلي خمس ساندويشات وعلبه بيبسي بس 6");
            offerMeta.setName("عرض العائله");
            offerMeta.setPrice(new Price(9.99 ,ApiUtils.getDefaultCurrency()));
            fakeOffers.add(offerMeta);
        }

        return fakeOffers;
    }
}
