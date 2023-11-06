package com.trodev.careermatcherpro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class OrderPagerAdapter extends FragmentPagerAdapter {
    public OrderPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new PackageOrderFragment();
        } else{
            return new CvOrderFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "প্যাকেজ কার্ট";
        } else {
            return "সিভি কার্ট";
        }

    }
}
