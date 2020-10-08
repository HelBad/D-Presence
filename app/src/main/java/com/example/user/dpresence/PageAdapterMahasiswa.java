package com.example.user.dpresence;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapterMahasiswa extends FragmentPagerAdapter {
    private int numTabs;

    PageAdapterMahasiswa(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PresensiMahasiswaFragment();
            case 1:
                return new AkunMahasiswaFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}