package com.axioms.www.daleel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.TextView;

import com.axioms.www.daleel.Adapters.CustomAdapter;
import com.axioms.www.daleel.Adapters.ItemAdapter;
import com.axioms.www.daleel.metadata.Price;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;
import com.axioms.www.daleel.utils.ApiUtils;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowCart extends AppCompatActivity {

    @BindView(R.id.cart_list)
    AbsListView itemsListView;
    @BindView(R.id.empty_cart)
    TextView emptyMessage;
    @BindView(R.id.cartPrice)
    TextView totalPrice;
    @BindView(R.id.order_buttom)
    Button confermOrder;
    PayPalConfiguration m_configuration;
    // the id is the link to the paypal account, we have to create an app and get its id
    String m_paypalClientId ;
    Intent m_service;
    int m_paypalRequestCode = 999;
    CustomAdapter<Item> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);
        ButterKnife.bind(this);

        ShoppingCartHolder cartHolder = ShoppingCartHolder.Instance();
        if(cartHolder.isEmptyCart()){
            emptyMessage.setVisibility(View.VISIBLE);
        }else{
            adapter = new ItemAdapter(this , R.layout.product_details_layout , cartHolder.getCartItems() , cartHolder);
            itemsListView.setAdapter(adapter);
            emptyMessage.setVisibility(View.INVISIBLE);
            totalPrice.setText(getString(R.string.cartSum)+ ApiUtils.getFormattedPrice(cartHolder.getCartPriceTotal()));
        }
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //PayPal webservice setup
        m_paypalClientId = getString(R.string.payPal_appclientId);
        m_configuration = new PayPalConfiguration()
                .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX) // sandbox for test, production for real
                .clientId(m_paypalClientId);

        m_service = new Intent(this, PayPalService.class);
        m_service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration); // configuration above
        startService(m_service); // paypal service, listening to calls to paypal app

    }

    @OnClick(R.id.order_buttom)
    public void payOrder(View view){
        if(!ShoppingCartHolder.Instance().isEmptyCart()){
            Price price = ShoppingCartHolder.Instance().getCartPriceTotal();
            PayPalPayment payment = new PayPalPayment(new BigDecimal(price.getPrice()), "USD", "Test payment with Paypal",
                    PayPalPayment.PAYMENT_INTENT_ORDER);

            Intent intent = new Intent(this, PaymentActivity.class); // it's not paypalpayment, it's paymentactivity !
            intent.putExtra(PayPalPayment.PAYMENT_INTENT_SALE, m_configuration);
            intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
            startActivityForResult(intent, m_paypalRequestCode);
        }else {
            // add something in the future
        }


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == m_paypalRequestCode)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                // we have to confirm that the payment worked to avoid fraud
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                if(confirmation != null)
                {
                    String state = confirmation.getProofOfPayment().getState();

                    if(state.equals("approved")) { // if the payment worked, the state equals approved
                        emptyMessage.setText("تمت عمليه اشراء بنجاح");
                        emptyMessage.setVisibility(View.VISIBLE);
                        ShoppingCartHolder.Instance().removeAllItems();
                        adapter.notifyDataSetChanged();
                        totalPrice.setVisibility(View.INVISIBLE);
                    }
                    else {
                        emptyMessage.setText("خطاء في عمليه الشراء");
                        emptyMessage.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    emptyMessage.setText("لايوجد موافقه!");
                    emptyMessage.setVisibility(View.VISIBLE);
                }
            }
        }
    }

}
