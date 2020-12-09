package com.example.splashscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class screen1fragment extends Fragment {
    private View view;
    private ImageView navButton;
    private ImageView imageView;
    public screen1fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        navButton = ((demo_Drawer_Activity)getActivity()).mNavButton;
        navButton.setImageResource(R.drawable.menu);
        view = inflater.inflate(R.layout.activity_screen1, container, false);
        setViews();
        setListeners();
        return view;
    }
    private void setViews(){
        imageView=view.findViewById(R.id.geological);
    }
    private void setListeners(){
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((demo_Drawer_Activity)getActivity()).mDrawerlayout.openDrawer(Gravity.LEFT);
            }
        });
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FragmentManager fragmentManager=(getActivity().getSupportFragmentManager());
               Fragment Scrappy_box_Fragment=new Scrappy_box_Fragment();
               fragmentManager.beginTransaction()
                       .setCustomAnimations(R.anim.slide_in_up, android.R.anim.fade_out, android.R.anim.fade_in, R.anim.slide_out_down)
                       .replace(R.id.screen, Scrappy_box_Fragment, "find this fragment")
                       .addToBackStack(null)
                       .commit();
           }
       });
    }

}