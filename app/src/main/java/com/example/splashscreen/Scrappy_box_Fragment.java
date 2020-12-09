package com.example.splashscreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Scrappy_box_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Scrappy_box_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private View view;
    private Slider mWeightSlider;
    private Slider mSizeSlider;
    private TextView mWeightTextView;
    private TextView mSizeTextView;
    private Button mSendButton;
    private TextView size;
    private TextView weight;
    private String mWeightFormattedValue="0.0";
    private String mSizeFormattedValue="0.0";

    public Scrappy_box_Fragment() {

    }
    public static Scrappy_box_Fragment newInstance(String param1, String param2) {
        Scrappy_box_Fragment fragment = new Scrappy_box_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_scrappy_box_, container, false);
        setViews();
        setListeners();
        return view;
    }
    private void setViews() {
        size=view.findViewById(R.id.size);
        weight=view.findViewById(R.id.weight);
        mWeightSlider=view.findViewById(R.id.weight_slider);
        mSizeSlider=view.findViewById(R.id.size_slider);
        mWeightTextView=view.findViewById(R.id.weight_text);
        mSizeTextView=view.findViewById(R.id.size_text);
        mSendButton=view.findViewById(R.id.send_button);
    }
    private void setListeners() { mWeightSlider.addOnChangeListener(new Slider.OnChangeListener() {
        @Override
        public void onValueChange(
                @NonNull Slider slider, float value, boolean fromUser) {
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

    }


}