package com.example.splashscreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PaymentFragment extends Fragment {
    private View view;
    private Button confirm_pay_button;
    public PaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_payment, container, false);
        setviews();
        setListners();
        return view;
    }
    private void setviews(){
        confirm_pay_button = view.findViewById(R.id.confirm_pay_button);
    }
    private void setListners() {
        confirm_pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = (getActivity()).getSupportFragmentManager();
                Recipt_Fragment reciptFragment = new Recipt_Fragment();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.slide_out_right)
                        .replace(R.id.screen, reciptFragment, "find this fragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}