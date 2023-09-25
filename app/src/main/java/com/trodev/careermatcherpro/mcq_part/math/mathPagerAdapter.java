package com.trodev.careermatcherpro.mcq_part.math;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class mathPagerAdapter extends FragmentPagerAdapter {
    public mathPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Math_oneFragment();
        } else if (position == 1) {
            return new Math_twoFragment();
        } else if (position == 2) {
            return new Math_threeFragment();
        } else if (position == 3) {
            return new Math_fourFragment();
        } else{
            return new Math_fiveFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "01";
        } else if (position == 1) {
            return "02";
        } else if (position == 2) {
            return "03";
        } else if (position == 3) {
            return "04";
        }else {
            return "05";
        }

    }
}
