package com.example.splashscreen;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ScreenSlideFragment extends Fragment {
    private View view;
    private ImageView image;
    private TextView text;
    private Animation animation;
    private int ResourceId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_screen_slide, container, false);
        setViews();
        setListners();
        return view;
    }
    private void setViews(){
        image=view.findViewById(R.id.info_image);
        ResourceId= getArguments().getInt("imageId");
        image.setImageResource(ResourceId);
        text=view.findViewById(R.id.information);
        text.setText(getArguments().getString("imageName"));
    }
    private void setListners(){
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnClickedImage","Button is clicked");
                animation= AnimationUtils.loadAnimation(getContext(),R.anim.bounce);
                image.startAnimation(animation);
               FragmentManager fragmentManager=(getActivity().getSupportFragmentManager());
               Fragment scrappy_box_Fragment=new Scrappy_box_Fragment();
               Bundle data = new Bundle();
               data.putInt("selectedItem",ResourceId);
               scrappy_box_Fragment.setArguments(data);
               fragmentManager.beginTransaction()
                       .setCustomAnimations(R.anim.slide_in_up, android.R.anim.fade_out, android.R.anim.fade_in, R.anim.slide_out_down)
                       .replace(R.id.screen, scrappy_box_Fragment, "find this fragment")
                       .addToBackStack(null)
                       .commit();
            }
        });
    }
}