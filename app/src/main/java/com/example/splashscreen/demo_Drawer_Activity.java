package com.example.splashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class demo_Drawer_Activity extends AppCompatActivity {
    public DrawerLayout mDrawerlayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private Fragment fragment;
    public ImageView mNavButton;
    private ImageView mBackButton;
    private FragmentManager fragmentManager;
    private screen1fragment sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_screen);
        mToolbar= findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mNavigationView =findViewById(R.id.nav_bar);
        mDrawerlayout=findViewById(R.id.screen_1_navigation);
        mNavigationView=findViewById(R.id.nav_bar);
        mNavButton=findViewById(R.id.drawerMenu);
        mNavButton.setClickable(true);
        View header=mNavigationView.getHeaderView(0);
        mBackButton=header.findViewById(R.id.back_arrow);
        mBackButton.setClickable(true);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerlayout.closeDrawer(Gravity.LEFT);
            }
        });
        sc=new screen1fragment();
        fragment=sc;
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.screen,fragment,null).commit();
        setListner();
    }
    private void setListner(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_user:
                        fragment=new UserFragment();
                        break;
                    case R.id.item_order:
                        fragment=new OrderFragment();
                        break;
                    default:
                        fragment=sc;
                }
                fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.fade_out,android.R.anim.fade_in,android.R.anim.slide_out_right)
                .replace(R.id.screen,fragment,"find this fragment").addToBackStack(null).commit();
                mDrawerlayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }
}