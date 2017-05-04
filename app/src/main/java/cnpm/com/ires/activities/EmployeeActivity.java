package cnpm.com.ires.activities;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cnpm.com.ires.R;
import cnpm.com.ires.adapter.EmployeeAdapter;
import cnpm.com.ires.databases.DatabaseHandler;
import cnpm.com.ires.model.Employee;


public class EmployeeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Toolbar toolbar;

    private SearchView searchView;
    private ListView lvEmployee;
    private EmployeeAdapter employeeAdapter;
    LayoutInflater inflater;
    private ArrayList<Employee> listEmployee;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        init();
        DatabaseHandler db = new DatabaseHandler(this);
//        db.deleteAllEmployee();
//         Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addEmployee(new Employee("Ravi", "9100000000", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Srinivas", "9199999999", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Tommy", "9522222222", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Karthik", "9533333333", R.drawable.avataremployee));
//
//        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
        List<Employee> employees = db.getAllEmployee();
        employeeAdapter = new EmployeeAdapter(this, (ArrayList<Employee>) employees);
        Log.d("length", listEmployee.size() + "");
        lvEmployee.setAdapter(employeeAdapter);
        employeeAdapter.notifyDataSetChanged();
    }

    private void init() {
        lvEmployee = (ListView) findViewById(R.id.lvEmployee);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem menuItem = menu.findItem(R.id.actionSearch);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Employee> newList = new ArrayList<>();
        for (Employee employee : listEmployee) {
            String name = employee.getName().toLowerCase();
            if (name.contains(newText)) {
                newList.add(employee);

            }
            lvEmployee.setFilterText(newText.toString());
        }
        return true;
    }

}