package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SendActivity extends AppCompatActivity {
    private String mWeight;
    private String mSize;
    private TextView mWeightView;
    private TextView mSizeView;
    private Button mConfirmButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        Bundle extras =getIntent().getExtras();
        mWeight=extras.getString("weight");
        mSize=extras.getString("size");
        setViews();
        updateValues();
        setListner();
    }
    private void setViews(){
        mWeightView=findViewById(R.id.weight);
        mSizeView=findViewById(R.id.size);
        mConfirmButton=findViewById(R.id.confirm_button);

    }
    private void updateValues(){
        mWeightView.setText(mWeight);
        mSizeView.setText(mSize);
    }
    private void setListner(){
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(SendActivity.this,MapActivity.class);
                startActivity(i);
            }
        });
    }
}