package com.trodev.careermatcherpro.mcq_part.mental;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class mentalPagerAdapter extends FragmentPagerAdapter {
    public mentalPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Mental_oneFragment();
        } else if (position == 1) {
            return new Mental_twoFragment();
        } else if (position == 2) {
            return new Mental_threeFragment();
        } else if (position == 3) {
            return new Mental_fourFragment();
        } else if (position == 4) {
            return new Mental_fiveFragment();
        } else if (position == 5) {
            return new Mental_sixFragment();
        } else if (position == 6) {
            return new Mental_sevenFragment();
        } else if (position == 7) {
            return new Mental_eightFragment();
        } else if (position == 8) {
            return new Mental_nineFragment();
    } else{
            return new Mental_tenFragment();
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
            return "01";
        } else if (position == 1) {
            return "02";
        } else if (position == 2) {
            return "03";
        } else if (position == 3) {
            return "04";
        } else if (position == 4) {
            return "05";
        } else if (position == 5) {
            return "06";
        } else if (position == 6) {
            return "07";
        } else if (position == 7) {
            return "08";
        } else if (position == 8) {
            return "09";
    }else {
            return "10";
        }
    }
}
