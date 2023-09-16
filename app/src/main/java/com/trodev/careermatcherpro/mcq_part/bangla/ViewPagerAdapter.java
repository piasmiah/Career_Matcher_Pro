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
        } else{
            return new Bangla_threeFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "পার্ট-০১";
        } else if (position == 1) {
            return "পার্ট-০২";
        }else {
            return "পার্ট-০৩";
        }

    }
}
