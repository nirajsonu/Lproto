package com.example.splashscreen;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class screen1fragment extends Fragment {
    private View view;
    private ImageView navButton;
    private ImageView imageView;
    private Animation animation;
    private ImageView email;
    private HorizontalScrollView horizontal;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    @Override
    public void setRetainInstance(boolean retain) {
        super.setRetainInstance(retain);
    }

    public screen1fragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        navButton = ((demo_Drawer_Activity)getActivity()).mNavButton;
        navButton.setImageResource(R.drawable.menu);
        view = inflater.inflate(R.layout.activity_screen1, container, false);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getChildFragmentManager());
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mPager, true);
        setViews();
        setListeners();
        return view;
    }
    private void setViews(){

    }
    private void setListeners(){
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((demo_Drawer_Activity)getActivity()).mDrawerlayout.openDrawer(Gravity.LEFT);
            }
        });
//       imageView.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               animation= AnimationUtils.loadAnimation(getContext(),R.anim.bounce);
//               imageView.startAnimation(animation);
//               FragmentManager fragmentManager=(getActivity().getSupportFragmentManager());
//               Fragment Scrappy_box_Fragment=new Scrappy_box_Fragment();
//               fragmentManager.beginTransaction()
//                       .setCustomAnimations(R.anim.slide_in_up, android.R.anim.fade_out, android.R.anim.fade_in, R.anim.slide_out_down)
//                       .replace(R.id.screen, Scrappy_box_Fragment, "find this fragment")
//                       .addToBackStack(null)
//                       .commit();
//           }
//       });
    }

}