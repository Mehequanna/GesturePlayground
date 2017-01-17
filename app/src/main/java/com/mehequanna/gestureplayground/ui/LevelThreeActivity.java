package com.mehequanna.gestureplayground.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelThreeActivity extends AppCompatActivity implements View.OnTouchListener {
    @Bind(R.id.oneTractorPink) ImageView mOneTractorPink;
    @Bind(R.id.twoTractorBlack) ImageView mTwoTractorBlack;
    @Bind(R.id.threeTractorRed) ImageView mThreeTractorRed;
    @Bind(R.id.fourTractorGreen) ImageView mFourTractorGreen;
    @Bind(R.id.fiveAirplaneGreen) ImageView mFiveAirplaneGreen;
    @Bind(R.id.sixAirplaneRed) ImageView mSixAirplaneRed;
    @Bind(R.id.sevenAirplaneBlue) ImageView mSevenAirplaneBlue;

    private GestureDetector mOneTractorPinkGestureDetector;
    private GestureDetector mTwoTractorBlackGestureDetector;
    private GestureDetector mThreeTractorRedGestureDetector;
    private GestureDetector mFourTractorGreenGestureDetector;
    private GestureDetector mFiveAirplaneGreenGestureDetector;
    private GestureDetector mSixAirplaneRedGestureDetector;
    private GestureDetector mSevenAirplaneBlueGestureDetector;

    MediaPlayer planeStart;
    MediaPlayer planeFlyRight;
    MediaPlayer planeFlyLeft;
    MediaPlayer tractorStart;
    MediaPlayer tractorDriveLeft;
    MediaPlayer tractorDriveRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);
        ButterKnife.bind(this);

        planeStart = MediaPlayer.create(this, R.raw.planestart);
        planeFlyLeft = MediaPlayer.create(this, R.raw.planeflytoleft);
        planeFlyRight = MediaPlayer.create(this, R.raw.planeflytoright);
        tractorStart = MediaPlayer.create(this, R.raw.tractorstarting);
        tractorDriveLeft = MediaPlayer.create(this, R.raw.tractordrivingtoleft);
        tractorDriveRight = MediaPlayer.create(this, R.raw.tractordrivingtoright);

        mOneTractorPinkGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onDown(MotionEvent motionEvent) {

               return true;
           }

            @Override
            public void onSwipeRight() {

            }
        });

        mSevenAirplaneBlueGestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public void onSwipeRight() {
                Toast.makeText(LevelThreeActivity.this, "swiped", Toast.LENGTH_SHORT).show();
                Animation moveRight = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.move_right_fade_animation);
                mSevenAirplaneBlue.startAnimation(moveRight);
            }
        });

        mOneTractorPink.setOnTouchListener(this);
        mTwoTractorBlack.setOnTouchListener(this);
        mThreeTractorRed.setOnTouchListener(this);
        mFourTractorGreen.setOnTouchListener(this);
        mFiveAirplaneGreen.setOnTouchListener(this);
        mSixAirplaneRed.setOnTouchListener(this);
        mSevenAirplaneBlue.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == mOneTractorPink) {
            mOneTractorPinkGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        if (view == mTwoTractorBlack) {
            return true;
        }
        if (view == mThreeTractorRed) {
            return true;
        }
        if (view == mFourTractorGreen) {
            return true;
        }
        if (view == mFiveAirplaneGreen) {
            return true;
        }
        if (view == mSixAirplaneRed) {
            return true;
        }
        if (view == mSevenAirplaneBlue) {
            mSevenAirplaneBlueGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
}
