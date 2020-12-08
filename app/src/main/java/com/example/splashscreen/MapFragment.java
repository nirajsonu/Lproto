package com.example.splashscreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MapFragment extends Fragment {
    private Button mPayButton;
    private View view;
    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_map, container, false);
        setviews();
        setListners();
        return view;
    }
    private void setviews(){
        mPayButton = view.findViewById(R.id.pay_button);
    }
    private void setListners(){
        mPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=(getActivity()).getSupportFragmentManager();
                PaymentFragment paymentFragment = new PaymentFragment();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.fade_out,android.R.anim.fade_in,android.R.anim.slide_out_right)
                        .replace(R.id.screen,paymentFragment, "find this fragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
