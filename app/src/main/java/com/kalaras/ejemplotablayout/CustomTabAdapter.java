package com.kalaras.ejemplotablayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CustomTabAdapter extends FragmentStatePagerAdapter {

    private int numerosTab;

    public CustomTabAdapter(FragmentManager fm, int numerosTab) {
        super(fm);
        this.numerosTab = numerosTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new Tab1Fragment();
            case 1: return new Tab2Fragment();
            case 2: return new Tab3Fragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return numerosTab;
    }
}
