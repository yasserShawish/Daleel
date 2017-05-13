package com.axioms.www.daleel.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.OfferMeta;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 05/05/2017.
 */

public class OfferAdapter<T> extends CustomAdapter<T>{

    public OfferAdapter(Context activity, int textViewResourceId, List lItems) {
        super(activity, textViewResourceId, lItems , ShoppingCartHolder.Instance());
    }


    public class Holder
    {
        TextView tv;
        ImageView img;
        Button orderOffer;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(textViewResourceId, null);
        holder.tv=(TextView) rowView.findViewById(R.id.offer_description);
        holder.img=(ImageView) rowView.findViewById(R.id.offer_image_temp);
        holder.orderOffer = (Button) rowView.findViewById(R.id.offer_order_buttom);

        final OfferMeta currentOffer = (OfferMeta) lItems.get(position);

        holder.tv.setText(currentOffer.getName());
        holder.img.setImageResource(currentOffer.getImage());
        holder.orderOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingCartHolder shoppingCartHolder = ShoppingCartHolder.Instance();
                shoppingCartHolder.addToCart(currentOffer);
                Button cartButton = (Button) view.getRootView().findViewById(R.id.cart_button);
                cartButton.setText(String.format("%d", shoppingCartHolder.shoppingCartSize()));
                cartButton.setTextColor(Color.RED);
            }
        });
        return rowView;
    }
}
