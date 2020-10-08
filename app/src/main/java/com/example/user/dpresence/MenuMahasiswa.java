package com.example.user.dpresence;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MenuMahasiswa extends AppCompatActivity {
    AlertDialog.Builder alertDialog;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapterMahasiswa pageAdapter;
    TabItem tabPresensi;
    TabItem tabAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_mahasiswa);

        alertDialog = new AlertDialog.Builder(this);
        toolbar = findViewById(R.id.toolbarMenuMhs);
        toolbar.setTitle("INFORMATICS");
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabLayoutMenuMhs);
        viewPager = findViewById(R.id.viewPagerMhs);
        tabPresensi = findViewById(R.id.tabPresensiMhs);
        tabAkun = findViewById(R.id.tabAkunMhs);
        pageAdapter = new PageAdapterMahasiswa(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MenuMahasiswa.this, R.color.colorSky));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MenuMahasiswa.this, R.color.colorSky));
                }
                else if(tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MenuMahasiswa.this, R.color.colorSky));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MenuMahasiswa.this, R.color.colorSky));
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAbout:
                Toast.makeText(this, "Menu is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, AboutMahasiswa.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MenuMahasiswa.this, "Back is Clicked", Toast.LENGTH_SHORT).show();
        alertDialog.setTitle("Close Application");
        alertDialog.setMessage("Do you want to close the application ?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create().show();
    }
}