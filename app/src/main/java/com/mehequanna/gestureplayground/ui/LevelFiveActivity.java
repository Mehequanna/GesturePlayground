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
    @Bind(R.id.pig1) ImageView mPigUp;
    @Bind(R.id.pig2) ImageView mPigDown;
    @Bind(R.id.sixAirplaneRed) ImageView mAirplaneRed;
    @Bind(R.id.sevenAirplaneBlue) ImageView mAirplaneBlue;
    @Bind(R.id.threeTractorRed) ImageView mTractorRed;
    @Bind(R.id.cowFive) ImageView mCowFive;
    @Bind(R.id.cowTen) ImageView mCowTen;
    @Bind(R.id.chicken4) ImageView mChickenPink;
    @Bind(R.id.chicken6) ImageView mChickenBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five);
        ButterKnife.bind(this);

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
