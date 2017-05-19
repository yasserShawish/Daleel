package com.axioms.www.daleel.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.axioms.www.daleel.R;
import com.axioms.www.daleel.metadata.Product;
import com.axioms.www.daleel.metadata.ProductFamily;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.Item;
import com.axioms.www.daleel.metadata.ecommerce.shoppingcart.model.ShoppingCartHolder;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ahmad Ababneh on 5/17/2017.
 */

public class GenericExpandableListAdapter<T , E> extends BaseExpandableListAdapter{

    private Context _context;
    private List<ProductFamily> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<ProductFamily, List<Item>> _listDataChild;
    int groupLayId;
    int childLayId;
    ShoppingCartHolder cartHolder;
    protected static LayoutInflater inflater=null;

    public GenericExpandableListAdapter(Context context, List<ProductFamily> listDataHeader,
                                 HashMap<ProductFamily, List<Item>> listChildData ,int groupLayId , int childLayId ) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.childLayId = childLayId;
        this.groupLayId = groupLayId;
        this.cartHolder = ShoppingCartHolder.Instance();
        try {
            this.inflater = LayoutInflater.from(context);
        }catch (Exception e){

        }
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this._listDataChild.get(this._listDataHeader.get(i))
                .size();
    }

    @Override
    public T getGroup(int i) {
        return (T) this._listDataHeader.get(i);
    }

    @Override
    public E getChild(int groupPosition, int childPosititon) {
        return (E) this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    public class GroupHolder {

    }

    @Override
    public View getGroupView(int gi, boolean b, View view, ViewGroup viewGroup) {
        ProductFamily currentGruop = (ProductFamily) getGroup(gi);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.product_group_lay, null);
        }

        TextView lblListHeader = (TextView) view.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(currentGruop.getName());

        return view;
    }

    public class ChildHolder {
        TextView name;
        TextView price;
        ImageView img;
        Button orderButton;
    }
    @Override
    public View getChildView(int gi, int ci, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder holder= new ChildHolder();
        final Product currentProduct = (Product) getChild(gi , ci);
        View rowView;
        rowView = inflater.inflate(childLayId, null);
        holder.name=(TextView) rowView.findViewById(R.id.product_name_row);
        holder.price = (TextView) rowView.findViewById(R.id.price_txt_row);
        holder.orderButton=(Button) rowView.findViewById(R.id.order_row_buttom);
        holder.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartHolder.addToCart(currentProduct ,1);
                Button cartButton = (Button) view.getRootView().findViewById(R.id.cart_button);
                cartButton.setText(String.format("%d", cartHolder.shoppingCartSize()));
                cartButton.setTextColor(Color.RED);
            }
        });
        holder.name.setText(currentProduct.getName());
        holder.price.setText(currentProduct.getPrice().getPrice()+""+currentProduct.getPrice().getCurrency());
        return rowView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
