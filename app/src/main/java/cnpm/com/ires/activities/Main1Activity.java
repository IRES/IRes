package cnpm.com.ires.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cnpm.com.ires.R;


public class Main1Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_menu;
    private Button btn_Table;
    private Button btn_statistics;
    private Button btn_employee;
    Intent _intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btn_employee = (Button) findViewById(R.id.btn_Employee);
        btn_menu = (Button) findViewById(R.id.btn_Menu);
        btn_Table = (Button) findViewById(R.id.btn_Table);
        btn_statistics = (Button) findViewById(R.id.btn_statistics);
        btn_menu.setOnClickListener(this);
        btn_statistics.setOnClickListener(this);
        btn_Table.setOnClickListener(this);
        btn_employee.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Menu:
                // do something
                Toast.makeText(this, "Comming soon", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_Table:
                _intent = new Intent(this, MainActivity.class);
                startActivity(_intent);
                //do something
                break;
            case R.id.btn_statistics:
                Toast.makeText(this, "Comming soon", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_Employee:
                Intent intent = new Intent(this, EmployeeActivity.class);
                startActivity(intent);
                break;

        }


    }
}
