package com.mehequanna.gestureplayground.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mehequanna.gestureplayground.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelFiveActivity extends AppCompatActivity implements View.OnTouchListener {
    @Bind(R.id.winTextView) TextView mWinTextView;
    @Bind(R.id.pigUp) ImageView mPigUp;
    @Bind(R.id.pigDown) ImageView mPigDown;
    @Bind(R.id.airplaneRed) ImageView mAirplaneRed;
    @Bind(R.id.airplaneBlue) ImageView mAirplaneBlue;
    @Bind(R.id.tractorRed) ImageView mTractorRed;
    @Bind(R.id.cowFive) ImageView mCowFive;
    @Bind(R.id.cowTen) ImageView mCowTen;
    @Bind(R.id.chickenPink) ImageView mChickenPink;
    @Bind(R.id.chickenBlue) ImageView mChickenBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five);
        ButterKnife.bind(this);

//        Log.d("logs", "PigUp " + mPigUp.getId());
//        Log.d("logs", "PigDown: " + mPigDown.getId());
//        Log.d("logs", "PlaneBlue: " + mAirplaneBlue.getId());
//        Log.d("logs", "PlaneRed: " + mAirplaneRed.getId());
//        Log.d("logs", "TractorRed: " + mTractorRed.getId());
//        Log.d("logs", "CowFive: " + mCowFive.getId());
//        Log.d("logs", "CowTen: " + mCowTen.getId());
//        Log.d("logs", "ChickenPink: " + mChickenPink.getId());
//        Log.d("logs", "ChickenBlue: " + mChickenBlue.getId());

        mPigUp.setOnTouchListener(this);
        mPigDown.setOnTouchListener(this);
        mAirplaneRed.setOnTouchListener(this);
        mAirplaneBlue.setOnTouchListener(this);
        mTractorRed.setOnTouchListener(this);
        mCowFive.setOnTouchListener(this);
        mCowTen.setOnTouchListener(this);
        mChickenBlue.setOnTouchListener(this);
        mChickenPink.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
