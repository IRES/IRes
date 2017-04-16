package cnpm.com.ires.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import cnpm.com.ires.R;
import cnpm.com.ires.model.Meal;

/**
 * Created by dinht on 16/04/2017.
 */

public class MealAdapter extends BaseAdapter {
    private ArrayList<Meal> lsMeal;
    private LayoutInflater inflater;

    public MealAdapter(ArrayList<Meal> lsMeal, Context context) {
        this.lsMeal = lsMeal;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lsMeal.size();
    }

    @Override
    public Meal getItem(int position) {
        return lsMeal.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            return inflater.inflate(R.layout.item_meal, null);
        }
        Meal meal = getItem(position);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtMealName);
        TextView txtCost = (TextView) convertView.findViewById(R.id.txtMealCost);
        TextView txtCount = (TextView) convertView.findViewById(R.id.txtMealCount);
        ImageView imgMealAvatar = (ImageView) convertView.findViewById(R.id.imgMealAvar);

        txtName.setText(meal.getName());
        txtCost.setText(meal.getCost() + "");
        txtCount.setText(meal.getCount() + "");
        imgMealAvatar.setImageDrawable(meal.getImage());


        return convertView;
    }
}
