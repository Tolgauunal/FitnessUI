package com.example.fitnessui.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;;import com.example.fitnessui.Fragment.FitnessDetail;
import com.example.fitnessui.Fragment.FitnessPictures;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment;
        switch (position) {
            case 0:
                selectedFragment = FitnessPictures.newInstance();
                break;
            case 1:
                selectedFragment = FitnessDetail.newInstance();
                break;
            default:
                return null;
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence selectedTitle;
        switch (position) {
            case 0:
                selectedTitle = "Fitness Picture";
                break;
            case 1:
                selectedTitle = "Fitness Detail";
                break;
            default:
                return null;
        }
        return selectedTitle;
    }
}
