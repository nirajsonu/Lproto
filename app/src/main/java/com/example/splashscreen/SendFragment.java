package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SendFragment extends Fragment {
    private View view;
    private String mWeight;
    private String mSize;
    private TextView mWeightView;
    private TextView mSizeView;
    private Button mConfirmButton;

    public SendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_send, container, false);
        Bundle data=getArguments();
        mWeight=data.getString("weight");
        mSize=data.getString("size");
        changeNavbutton();
        setViews();
        updateValues();
        setListner();
        return view;
    }
    private void changeNavbutton(){
        ((demo_Drawer_Activity)getActivity()).mNavButton.setImageResource(R.drawable.left_arrow);
        ((demo_Drawer_Activity)getActivity()).mNavButton.setOnClickListener(null);
        ((demo_Drawer_Activity)getActivity()).mNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }
    private void setViews(){
        mWeightView=view.findViewById(R.id.weight);
        mSizeView=view.findViewById(R.id.size);
        mConfirmButton=view.findViewById(R.id.confirm_button);
    }
    private void updateValues(){
        mWeightView.setText(mWeight);
        mSizeView.setText(mSize);
    }
    private void setListner(){
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=(getActivity()).getSupportFragmentManager();
                MapFragment mapFragment = new MapFragment();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.fade_out,android.R.anim.fade_in,android.R.anim.slide_out_right)
                        .replace(R.id.screen,mapFragment, "find this fragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}