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
//        db.addEmployee(new Employee("Srinivas", "9237482", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Tommy", "923842", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Jane", "923742", R.drawable.avataremployee));
//        db.addEmployee(new Employee("John", "283742", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Elizabeth", "2348729", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Mars", "34820934", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Tony", "3472983", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Holo", "345678", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Mimi", "456789", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Cris", "2345232", R.drawable.avataremployee));
//        db.addEmployee(new Employee("Aladin", "75823472", R.drawable.avataremployee));
//        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
        ArrayList<Employee> employees = db.getAllEmployee();

        employeeAdapter = new EmployeeAdapter(this, employees);
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
//        for (Employee employee : listEmployee) {
//            String name = employee.getName().toLowerCase();
//            if (name.contains(newText)) {
//                newList.add(employee);
//
//            }
//            lvEmployee.setFilterText(newText.toString());
//        }
        return true;
    }

}