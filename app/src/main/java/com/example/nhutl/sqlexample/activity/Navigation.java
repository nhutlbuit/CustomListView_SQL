

package com.example.nhutl.sqlexample.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nhutl.sqlexample.R;
import com.example.nhutl.sqlexample.adapter.ViewColumnAdapter;
import com.example.nhutl.sqlexample.db.DBHelper;
import com.example.nhutl.sqlexample.dto.Column;
import com.example.nhutl.sqlexample.fragment.FlashLightFragment;

import java.util.ArrayList;
import java.util.List;

public class Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    ListView listViewDrower;
    private Context context;
    List<Column> listcolumns= new ArrayList<Column>();
    DBHelper dbHelper;
    Column column;
    ViewColumnAdapter adapter;
    EditText edtCot2,edtCot3,edtCot4,edtUpdateCot2,edtUpdateCot3,edtUpdateCot4;
    Dialog dialog;
    Button btnAdd,btnCancel,btnUpdate,btnCancelUpdate;
    String valueCot2,valueCot3,valueCot4;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Navigation Drawer");
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        switch(item.getItemId()) {
            case R.id.nav_first_fragment:
                 fragment = new FlashLightFragment();
                Toast.makeText(this, "nav_first_fragment is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_second_fragment:
                Intent intent = new Intent(this, ListProduct.class);
                startActivity(intent);
                break;
            case R.id.nav_third_fragment:
                Intent flashLight = new Intent(this, FlashLight.class);
                startActivity(flashLight);
                break;
            case R.id.nav_four_fragment:
                Intent LockScreenActivity = new Intent(this, LockScreen.class);
                startActivity(LockScreenActivity);
                break;
            case R.id.nav_five_fragment:
                Intent part = new Intent(this, Part.class);
                startActivity(part);
                break;
            case R.id.nav_xuxudungkhoc:
                Intent XuXuDungKhoc = new Intent(this, XuXuDungKhoc.class);
                startActivity(XuXuDungKhoc);
                break;
            case R.id.nav_myLife:
                Intent myLife = new Intent(this, XuXuDungKhoc.class);
                startActivity(myLife);
                break;
            case R.id.nav_maimailabaoxa:
                Intent maiMaiLaBaoXa = new Intent(this, XuXuDungKhoc.class);
                startActivity(maiMaiLaBaoXa);
                break;
            default:
                Toast.makeText(this, "Main menu", Toast.LENGTH_SHORT).show();
        }
      /*  replacing the fragment*/
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContent, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar.setTitle(item.getTitle());
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
