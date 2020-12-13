package com.example.splashscreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Integer> ImageId;
    private ArrayList<String> ImageName;
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ImageId=new ArrayList<>();
        ImageId.add(R.drawable.email);
        ImageId.add(R.drawable.groceries);
        ImageId.add(R.drawable.gift);
        ImageId.add(R.drawable.cube);
        ImageId.add(R.drawable.geological);
        ImageName=new ArrayList<>();
        ImageName.add("Document");
        ImageName.add("Food/Groceries");
        ImageName.add("Gift Box");
        ImageName.add("Regular Box");
        ImageName.add("Scrappy Box");
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new ScreenSlideFragment();
        Bundle imagedata= new Bundle();
        imagedata.putInt("imageId",ImageId.get(position));
        imagedata.putString("imageName",ImageName.get(position));
        fragment.setArguments(imagedata);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
