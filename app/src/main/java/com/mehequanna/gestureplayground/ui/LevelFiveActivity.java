package com.mehequanna.gestureplayground.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

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

    GestureDetector mGestureDetector;

    int mPigUpId;
    int mPigDownId;
    int mAirplaneBlueId;
    int mAirplaneRedId;
    int mTractorRedId;
    int mCowFiveId;
    int mCowTenId;
    int mChickenPinkId;
    int mChickenBlueId;
    int mViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five);
        ButterKnife.bind(this);

        mPigUpId = mPigUp.getId();
        mPigDownId = mPigDown.getId();
        mAirplaneBlueId = mAirplaneBlue.getId();
        mAirplaneRedId = mAirplaneRed.getId();
        mTractorRedId = mTractorRed.getId();
        mCowFiveId = mCowFive.getId();
        mCowTenId = mCowTen.getId();
        mChickenPinkId = mChickenPink.getId();
        mChickenBlueId = mChickenBlue.getId();

        mGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent e) {
                if (mViewId == mAirplaneBlueId) {
                    Toast.makeText(LevelFiveActivity.this, "Blue!", Toast.LENGTH_SHORT).show();
                } else if (mViewId == mAirplaneRedId) {
                    Toast.makeText(LevelFiveActivity.this, "Red", Toast.LENGTH_SHORT).show();
                } else if (mViewId == mTractorRedId) {
                    Toast.makeText(LevelFiveActivity.this, "Tractor", Toast.LENGTH_SHORT).show();
                }
                return super.onDown(e);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if (mViewId == mAirplaneBlueId || mViewId == mAirplaneRedId || mViewId == mTractorRedId) {
                    Toast.makeText(LevelFiveActivity.this, "Right", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if (mViewId == mAirplaneBlueId || mViewId == mAirplaneRedId || mViewId == mTractorRedId) {
                    Toast.makeText(LevelFiveActivity.this, "Left", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                return super.onSingleTapConfirmed(e);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                return super.onDoubleTap(e);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });

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
        mViewId = view.getId();
        mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
}
