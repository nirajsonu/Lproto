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
    private Slider mWeightSlider;
    private Slider mSizeSlider;
    private TextView mWeightTextView;
    private TextView mSizeTextView;
    private Button mSendButton;
    private String mWeightFormattedValue="0.0";
    private String mSizeFormattedValue="0.0";
    private View view;
    private ImageView navButton;

    public screen1fragment() {
        // Required empty public constructor
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
        mWeightSlider=view.findViewById(R.id.weight_slider);
        mSizeSlider=view.findViewById(R.id.size_slider);
        mWeightTextView=view.findViewById(R.id.weight_text);
        mSizeTextView=view.findViewById(R.id.size_text);
        mSendButton=view.findViewById(R.id.send_button);
    }
    private void setListeners(){
        mWeightSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(
                    Slider slider, float value, boolean fromUser) {
                mWeightFormattedValue = String.format("%.02f",value) ;
                mWeightTextView.setText(mWeightFormattedValue + " Kg");
            }
        });
        mSizeSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                mSizeFormattedValue = String.format("%.02f",value) ;
                mSizeTextView.setText(mSizeFormattedValue+" Feet");
            }
        });
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getContext(),SendActivity.class);
//                i.putExtra("weight",mWeightFormattedValue);
//                i.putExtra("size",mSizeFormattedValue);
//                startActivity(i);
                FragmentManager fragmentManager = (getActivity()).getSupportFragmentManager();
                Fragment sendFragment = new SendFragment();
                Bundle data = new Bundle();
                data.putString("weight", mWeightFormattedValue);
                data.putString("size", mSizeFormattedValue);
                sendFragment.setArguments(data);
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_up, android.R.anim.fade_out, android.R.anim.fade_in, R.anim.slide_out_down)
                        .replace(R.id.screen, sendFragment, "find this fragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((demo_Drawer_Activity)getActivity()).mDrawerlayout.openDrawer(Gravity.LEFT);
            }
        });

    }

}