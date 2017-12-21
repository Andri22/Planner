package com.example.andri.planner;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.andri.planner.db.DataHelper;
import com.example.andri.planner.fragment.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DataHelper(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout =  findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Hari Ini"));
        tabLayout.addTab(tabLayout.newTab().setText("Minggu Ini"));
        tabLayout.addTab(tabLayout.newTab().setText("Semua"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        FloatingActionButton buttonTambah = findViewById(R.id.buttonTambah);

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /***SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into agenda (id,judul,tempat,deskripsi,kategori) values(1,'berangkat kerja','uin sunan kalijaga','harus pagi','Agenda Kerja')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                 */
                Intent tambahagenda = new Intent(MainActivity.this, TambahAgenda.class);
                startActivity(tambahagenda);

            }
        });

        final ViewPager viewPager =  findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.preferences) {

            return true;
        }
        if (id == R.id.aboutMeMenuItem) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
