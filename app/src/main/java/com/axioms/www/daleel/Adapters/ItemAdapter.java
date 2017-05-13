package com.axioms.www.daleel.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;

import java.util.List;

/**
 * Created by Ahmad Ababneh on 12/05/2017.
 */

public class ItemAdapter extends CustomAdapter<Item> {

    public ItemAdapter(Context activity, int textViewResourceId, List lItems , ShoppingCartHolder cartHolder) {
        super(activity, textViewResourceId, lItems , cartHolder);
    }

    private class ItemHolder {
        ImageView itemIamge;
        TextView itemName;
        TextView itemPrice;
        Button removeItem;
        Button addedItem;
        TextView typeLabel;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final ItemHolder holder;
        View vi = convertView;
        try{
            if(convertView == null){
                vi = inflater.inflate( textViewResourceId,null);
                if(vi.getTag() == null)
                {
                    holder= new ItemHolder();

                    holder.itemIamge = (ImageView) vi.findViewById(R.id.icon_image_view_details);
                    holder.itemName = (TextView) vi.findViewById(R.id.name_text_view_details);
                    holder.itemPrice = (TextView) vi.findViewById(R.id.price_text_view_details);
                    holder.removeItem= (Button) vi.findViewById(R.id.remove_item_button);
                    holder.typeLabel= (TextView) vi.findViewById(R.id.item_type_label);

                    vi.setTag(holder);
                }else{
                    holder = (ItemHolder) vi.getTag();
                }
            }else{
                holder = (ItemHolder) vi.getTag();
            }


            final Item currentItem = lItems.get(position);

            holder.itemIamge.setImageResource(currentItem.getImage());
            holder.itemName.setText(currentItem.getName());
            holder.itemPrice.setText(currentItem.getPrice().toString());
            holder.typeLabel.setText(currentItem.getType().getType());
            holder.removeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cartHolder.removeFromCart(currentItem);
                    Button cartButton = (Button) view.getRootView().findViewById(R.id.cart_button);
                    cartButton.setText(String.format("%d", cartHolder.shoppingCartSize()));
                    remove(currentItem);
                }
            });
        }catch (Exception e){

        }


        return vi;
    }
}
