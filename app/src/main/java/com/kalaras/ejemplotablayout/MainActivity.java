package com.kalaras.ejemplotablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtengo los elementos del layout
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        //Agrego los tab al TabLayout
        tab.addTab(tab.newTab().setText("TAB 1"));
        tab.addTab(tab.newTab().setText("TAB 2"));
        tab.addTab(tab.newTab().setText("TAB 3"));

        tab.setTabGravity(TabLayout.GRAVITY_FILL);

        //Instancio el custom adapter
        CustomTabAdapter adapter = new CustomTabAdapter(getSupportFragmentManager(), tab.getTabCount());

        //le paso el adapter al viewpager
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }
}
