package com.trodev.careermatcherpro.mcq_part.bangla;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Bangla_oneFragment();
        } else if (position == 1) {
            return new Bangla_twoFragment();
        } else if (position == 2) {
            return new Bangla_threeFragment();
        } else if (position == 3) {
            return new Bangla_fourFragment();
        } else if (position == 4) {
            return new Bangla_fiveFragment();
        } else if (position == 5) {
            return new Bangla_sixFragment();
        } else if (position == 6) {
            return new Bangla_sevenFragment();
        } else if (position == 7) {
            return new Bangla_eightFragment();
        } else if (position == 8) {
            return new Bangla_nineFragment();
        } else{
            return new Bangla_tenFragment();
        }

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "০১";
        } else if (position == 1) {
            return "০২";
        } else if (position == 2) {
            return "০৩";
        } else if (position == 3) {
            return "০৪";
        } else if (position == 4) {
            return "০৫";
        } else if (position == 5) {
            return "০৬";
        } else if (position == 6) {
            return "০৭";
        } else if (position == 7) {
            return "০৮";
        } else if (position == 8) {
            return "০৯";
        } else {
            return "১০";
        }

    }
}
