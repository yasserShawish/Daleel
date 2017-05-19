package com.axioms.www.daleel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.TextView;

import com.axioms.www.daleel.Adapters.CustomAdapter;
import com.axioms.www.daleel.Adapters.ItemAdapter;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowCart extends AppCompatActivity {

    @BindView(R.id.cart_list)
    AbsListView itemsListView;
    @BindView(R.id.empty_cart)
    TextView emptyMessage;
    @BindView(R.id.cartPrice)
    TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);
        ButterKnife.bind(this);

        ShoppingCartHolder cartHolder = ShoppingCartHolder.Instance();
        if(cartHolder.isEmptyCart()){
            emptyMessage.setVisibility(View.VISIBLE);
        }else{
            CustomAdapter<Item> adapter = new ItemAdapter(this , R.layout.product_details_layout , cartHolder.getCartItems() , cartHolder);
            itemsListView.setAdapter(adapter);
            emptyMessage.setVisibility(View.INVISIBLE);
            totalPrice.setText("المجموع: "+cartHolder.getCartPriceTotal().getPrice()+cartHolder.getCartPriceTotal().getCurrency());
        }
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
