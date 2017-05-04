package cnpm.com.ires.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import cnpm.com.ires.R;
import cnpm.com.ires.adapter.TableAdapter;
import cnpm.com.ires.model.Table;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public final int START_ACTIVITY_DETAIL_TABLE = 100;
    public final String PUT_TABLE_NAME = "TABLE_NAME";
    public final String PUT_TABLE_ID = "TABLE_ID";
    public final String PUT_TABLE_STATUS = "TABLE_STATUS";

    private GridView grvTable;
    private TableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        init();

    }

    private void init() {
        grvTable = (GridView) findViewById(R.id.grvTable);
        grvTable.setOnItemClickListener(OnItemClick);
        adapter = new TableAdapter(getLsTable(), getLayoutInflater());
        grvTable.setAdapter(adapter);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public ArrayList<Table> getLsTable() {
        ArrayList<Table> lsTable = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lsTable.add(new Table("" + (i + 1), "Table " + (i + 1), new cnpm.com.ires.model.Menu()));
        }
        return lsTable;
    }

    AdapterView.OnItemClickListener OnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, TableDetailActivity.class);
            Table table = adapter.getItem(position);
            intent.putExtra(PUT_TABLE_ID, table.getId());
            intent.putExtra(PUT_TABLE_NAME, table.getName());
            intent.putExtra(PUT_TABLE_STATUS, table.getStatus());

            startActivityForResult(intent, START_ACTIVITY_DETAIL_TABLE);
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == START_ACTIVITY_DETAIL_TABLE) {

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_account: {
                break;
            }
            case R.id.nav_home: {
                break;
            }
            case R.id.nav_menu: {

                break;
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
