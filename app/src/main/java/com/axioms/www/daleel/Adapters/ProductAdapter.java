package com.axioms.www.daleel.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.Product;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 02/05/2017.
 */

public class ProductAdapter<T> extends CustomAdapter<T> {

    public ProductAdapter(Context context, int resource, List objects ) {
        super(context, resource, objects , ShoppingCartHolder.Instance());

    }


    public class Holder
    {
        TextView name;
        TextView price;
        ImageView img;
        Button orderButton;
    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        final Product currentProduct = (Product) lItems.get(position);
        View rowView;
        rowView = inflater.inflate(textViewResourceId, null);
        holder.name=(TextView) rowView.findViewById(R.id.product_name_row);
        holder.price = (TextView) rowView.findViewById(R.id.price_txt_row);
        holder.img=(ImageView) rowView.findViewById(R.id.product_image_row);
        holder.orderButton=(Button) rowView.findViewById(R.id.order_row_buttom);
        holder.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartHolder.addToCart(currentProduct);
                Button cartButton = (Button) view.getRootView().findViewById(R.id.cart_button);
                cartButton.setText(String.format("%d", cartHolder.shoppingCartSize()));
                cartButton.setTextColor(Color.RED);
            }
        });
        holder.name.setText(currentProduct.getName());
        holder.price.setText(currentProduct.getPrice().getPrice()+""+currentProduct.getPrice().getCurrency());
        holder.img.setImageResource(currentProduct.getImage());
        return rowView;
    }



}
