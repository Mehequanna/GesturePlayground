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
import android.widget.TextView;

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

    MediaPlayer planeStartLeft;
    MediaPlayer planeStartRight;
    MediaPlayer planeFlyRight;
    MediaPlayer planeFlyLeft;
    MediaPlayer tractorStartLeft;
    MediaPlayer tractorDriveRight;
    MediaPlayer five;
    MediaPlayer ten;

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

        planeStartLeft = MediaPlayer.create(this, R.raw.planestartleft);
        planeStartRight = MediaPlayer.create(this, R.raw.planestartright);
        planeFlyLeft = MediaPlayer.create(this, R.raw.planeflytoleft);
        planeFlyRight = MediaPlayer.create(this, R.raw.planeflytoright);
        tractorStartLeft = MediaPlayer.create(this, R.raw.tractorstartleft);
        tractorDriveRight = MediaPlayer.create(this, R.raw.tractordrivingtoright);
        five = MediaPlayer.create(this, R.raw.five);
        ten = MediaPlayer.create(this, R.raw.ten);

        mGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent e) {
                if (mViewId == mAirplaneBlueId) {
                    planeStartLeft.start();
                } else if (mViewId == mAirplaneRedId) {
                    planeStartRight.start();
                } else if (mViewId == mTractorRedId) {
                    tractorStartLeft.start();
                }
                return super.onDown(e);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if (mViewId == mTractorRedId) {
                    tractorStartLeft.stop();
                    tractorDriveRight.start();
                    moveRight(mTractorRed);
                }
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if (mViewId == mAirplaneBlueId) {
                    planeStartLeft.start();
                    planeFlyRight.start();
                    moveRight(mAirplaneBlue);
                } else if (mViewId == mAirplaneRedId) {
                    planeStartRight.start();
                    planeFlyLeft.start();
                    moveLeft(mAirplaneRed);
                }
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                if (mViewId == mCowFiveId) {
                    scaleUpFadeImage(mCowFive);
                    five.start();
                    return true;
                } else if (mViewId == mCowTenId) {
                    scaleDownFadeImage(mCowTen);
                    ten.start();
                    return true;
                }
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

    public void moveRight(View view) {
        Animation moveRight = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_right_fade_animation);
        view.startAnimation(moveRight);
    }

    private void moveLeft(View view) {
        Animation moveLeft = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_left_fade_animation);
        view.startAnimation(moveLeft);
    }

    public void scaleUpFadeImage(View view) {
        Animation scaleUpFade = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.scale_up_fade_animation);
        view.startAnimation(scaleUpFade);
    }

    public void scaleDownFadeImage(View view) {
        Animation scaleDownFade = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.scale_down_fade_animation);
        view.startAnimation(scaleDownFade);
    }
}
