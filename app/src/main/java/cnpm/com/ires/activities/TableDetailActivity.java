package cnpm.com.ires.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import cnpm.com.ires.R;
import cnpm.com.ires.fragments.MenuFragment;
import cnpm.com.ires.fragments.PaymentFragment;

import static cnpm.com.ires.R.*;

public class TableDetailActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        PaymentFragment.OnFragmentInteractionListener, MenuFragment.OnFragmentInteractionListener,
        View.OnClickListener {

    public final String PUT_TABLE_NAME = "TABLE_NAME";
    public final String PUT_TABLE_ID = "TABLE_ID";
    public final String PUT_TABLE_STATUS = "TABLE_STATUS";

    public  final  String CHOOSE_BTN_MENU = "#e0ffdb";
    public  final  String CHOOSE_BTN_PAYMENT = "#feedff";
    public  final  String CHOOSE_BTN_NONE = "affaf2fd";
    private Button btnPayment;
    private Button btnMenu;
    private NavigationView navigationView;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_table_detail);
        Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        init();



        String id = (String) getIntent().getSerializableExtra(PUT_TABLE_ID);
        String title = (String) getIntent().getSerializableExtra(PUT_TABLE_NAME);
        int status = (int) getIntent().getSerializableExtra(PUT_TABLE_STATUS);
        getSupportActionBar().setTitle(title);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, string.navigation_drawer_open, string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        callFragment(new PaymentFragment());
    }

    private void init() {
        btnMenu = (Button) findViewById(id.btnMenu);
        btnPayment = (Button) findViewById(id.btnPayment);
        btnPayment.setOnClickListener(this);
        btnMenu.setOnClickListener(this);

        drawer = (DrawerLayout) findViewById(id.drawer_layout);

        navigationView = (NavigationView) findViewById(id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.table_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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

        if (id == R.id.nav_home) {
            // Handle the camera action
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case id.btnMenu: {
                callFragment(new MenuFragment());
                break;
            }
            case id.btnPayment: {
//                btnPayment.setBackgroundColor(CHOOSE_BTN_PAYMENT);
                callFragment(new PaymentFragment());
                break;
            }
        }
    }
    public void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(id.fmContent, fragment);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
