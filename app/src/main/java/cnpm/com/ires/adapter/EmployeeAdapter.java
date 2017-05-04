package cnpm.com.ires.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cnpm.com.ires.R;
import cnpm.com.ires.model.Employee;

public class EmployeeAdapter extends BaseAdapter {
    private static final String TAG = "EmployeeAdapter";
    private ArrayList<Employee> listEmployee;
    private Context context;
    private LayoutInflater inflater;

    public EmployeeAdapter(Context context, ArrayList<Employee> listEmployee) {
        this.context = context;
        this.listEmployee = listEmployee;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listEmployee.size();
    }

    @Override
    public Employee getItem(int position) {
        return listEmployee.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img_Employee;
        TextView txt_Name;
        TextView txt_PhoneNumber;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_employee, parent, false);
        }
        txt_Name = (TextView) convertView.findViewById(R.id.txtTen);
        txt_PhoneNumber = (TextView) convertView.findViewById(R.id.txtSoDienThoai);
        img_Employee = (ImageView) convertView.findViewById(R.id.imgAvatar);

        txt_Name.setText(getItem(position).getName());
        txt_PhoneNumber.setText(getItem(position).getPhoneNumber());
//        img_Employee.setImageResource(getItem(position).getAvatar());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "comming soon", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}