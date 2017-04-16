package cnpm.com.ires.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cnpm.com.ires.R;
import cnpm.com.ires.model.Table;

/**
 * Created by dinht on 15/04/2017.
 */

public class TableAdapter extends BaseAdapter {
    private ArrayList<Table> lsTable;
    private LayoutInflater inflater;

    public TableAdapter(ArrayList<Table> lsTable, LayoutInflater inflater) {
        this.lsTable = lsTable;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return lsTable.size();
    }

    @Override
    public Table getItem(int position) {
        return lsTable.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_table, null);
        }
        Table table = getItem(position);
        TextView txtTableName = (TextView) convertView.findViewById(R.id.txtTableName);
        txtTableName.setText(table.getName());
        return convertView;
    }
}
