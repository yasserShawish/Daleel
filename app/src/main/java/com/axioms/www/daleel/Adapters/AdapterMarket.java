package com.axioms.www.daleel.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.AbstractMeta;
import com.axioms.www.daleel.metadata.MarketMeta;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 15/04/2017.
 */

public class AdapterMarket<T extends AbstractMeta> extends CustomAdapter<T> {

    public AdapterMarket (Context context, int textViewResourceId, List _lMarket) {
        super(context, textViewResourceId, _lMarket , ShoppingCartHolder.Instance());
    }

    public static class ViewHolder {
        public TextView display_name;
        public TextView display_address;
        public ImageView display_image;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.market_list, null);
                holder = new ViewHolder();

                holder.display_name = (TextView) vi.findViewById(R.id.market_list_name_view);
                holder.display_address = (TextView) vi.findViewById(R.id.market_list_address_view);
                holder.display_image = (ImageView) vi.findViewById(R.id.market_list_image);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

            MarketMeta currentMArket = (MarketMeta) lItems.get(position);
            holder.display_name.setText(currentMArket.getName());
            holder.display_address.setText(currentMArket.getAddress().getCity());
            holder.display_image.setImageResource(currentMArket.getImage());


        } catch (Exception e) {


        }
        return vi;
    }
}