package com.example.android.miscontactos.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/15/2017.
 */

public class PageAdapter extends FragmentPagerAdapter{

    //de esta forma el PageAdapter es como va a estar viendo los fragments incrustdos en cada tab sera una arreglo de fragments
    private ArrayList<Fragment> fragments;

    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
