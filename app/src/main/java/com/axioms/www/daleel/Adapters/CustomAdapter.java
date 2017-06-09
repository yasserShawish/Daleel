package com.axioms.www.daleel.Adapters;

/**
 * Created by a7mad3babneh on 18/02/2017.
 */

import android.app.Activity;
import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class CustomAdapter<T> extends ArrayAdapter<T> {

    Context context;
    protected List<T> lItems;
    protected static LayoutInflater inflater=null;
    protected int textViewResourceId ;
    protected ShoppingCartHolder cartHolder;


    public CustomAdapter(Context activity, int textViewResourceId, List<T> lItems , ShoppingCartHolder cartHolder) {
        super(activity, textViewResourceId, lItems);
        try {
            context=activity;
            this.lItems = lItems;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.cartHolder = cartHolder;
            this.textViewResourceId = textViewResourceId;
        } catch (Exception e) {

        }
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lItems.size();
    }

    @Override
    public T getItem(int position) {
        // TODO Auto-generated method stub
        return (T) lItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(textViewResourceId, null);
        holder.tv=(TextView) rowView.findViewById(R.id.list_text_view);
        holder.img=(ImageView) rowView.findViewById(R.id.list_image);

        MyCategory currentCateogry = (MyCategory) lItems.get(position);

        holder.tv.setText(currentCateogry.getName());
        Picasso.with(getContext()).load(currentCateogry.getImage()).into(holder.img);
        return rowView;
    }

}