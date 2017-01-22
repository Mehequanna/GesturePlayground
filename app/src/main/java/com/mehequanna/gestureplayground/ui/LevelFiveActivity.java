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
    @Bind(R.id.tractorTralier) ImageView mTractorTrailer;
    @Bind(R.id.cowFive) ImageView mCowFive;
    @Bind(R.id.cowTen) ImageView mCowTen;
    @Bind(R.id.chickenPink) ImageView mChickenPink;
    @Bind(R.id.chickenBlue) ImageView mChickenBlue;

    private GestureDetector mGestureDetector;

    private int mPigUpId;
    private int mPigDownId;
    private int mAirplaneBlueId;
    private int mAirplaneRedId;
    private int mTractorRedId;
    private int mTractorTrailerId;
    private int mCowFiveId;
    private int mCowTenId;
    private int mChickenPinkId;
    private int mChickenBlueId;
    private int mViewId;
    private int mCounter;

    private MediaPlayer planeStartLeft;
    private MediaPlayer planeStartRight;
    private MediaPlayer planeFlyRight;
    private MediaPlayer planeFlyLeft;
    private MediaPlayer tractorStartLeft;
    private MediaPlayer tractorDriveRight;
    private MediaPlayer tractorStartRight;
    private MediaPlayer tractorDriveLeft;
    private MediaPlayer five;
    private MediaPlayer ten;
    private MediaPlayer blue;
    private MediaPlayer pink;
    private MediaPlayer up;
    private MediaPlayer down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five);
        ButterKnife.bind(this);

        mCounter = 0;

        mPigUpId = mPigUp.getId();
        mPigDownId = mPigDown.getId();
        mAirplaneBlueId = mAirplaneBlue.getId();
        mAirplaneRedId = mAirplaneRed.getId();
        mTractorRedId = mTractorRed.getId();
        mTractorTrailerId = mTractorTrailer.getId();
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
        tractorStartRight = MediaPlayer.create(this, R.raw.tractorstartright);
        tractorDriveLeft = MediaPlayer.create(this, R.raw.tractordrivingtoleft);
        five = MediaPlayer.create(this, R.raw.five);
        ten = MediaPlayer.create(this, R.raw.ten);
        pink = MediaPlayer.create(this, R.raw.pink);
        blue = MediaPlayer.create(this, R.raw.blue);
        up = MediaPlayer.create(this, R.raw.up);
        down = MediaPlayer.create(this, R.raw.down);

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
                    mCounter += 1;
                    tractorStartLeft.stop();
                    tractorDriveRight.start();
                    moveRight(mTractorRed);
                } else if (mViewId == mTractorTrailerId) {
                    mCounter += 1;
                    tractorStartRight.stop();
                    tractorDriveLeft.start();
                    moveLeft(mTractorTrailer);
                }
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if (mViewId == mAirplaneBlueId) {
                    mCounter += 1;
                    planeStartLeft.start();
                    planeFlyRight.start();
                    moveRight(mAirplaneBlue);
                } else if (mViewId == mAirplaneRedId) {
                    mCounter += 1;
                    planeStartRight.start();
                    planeFlyLeft.start();
                    moveLeft(mAirplaneRed);
                }
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                if (mViewId == mCowFiveId) {
                    mCounter += 1;
                    scaleUpFadeImage(mCowFive);
                    five.start();
                    return true;
                } else if (mViewId == mCowTenId) {
                    mCounter += 1;
                    scaleDownFadeImage(mCowTen);
                    ten.start();
                    return true;
                }
                return super.onSingleTapConfirmed(e);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (mViewId == mChickenBlueId) {
                    mCounter += 1;
                    scaleImage(mChickenBlue);
                    blue.start();
                } else if (mViewId == mChickenPinkId) {
                    mCounter += 1;
                    rotateImage(mChickenPink);
                    pink.start();
                }
                return super.onDoubleTap(e);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (mViewId == mPigUpId) {
                    mCounter += 1;
                    flingUp(mPigUp);
                    up.start();
                    mPigUp.setVisibility(View.INVISIBLE);
                    fadeIn(mPigDown);
                    mPigDown.setVisibility(View.VISIBLE);
                } else if (mViewId == mPigDownId) {
                    mCounter += 1;
                    flingDown(mPigDown);
                    down.start();
                    mPigDown.setVisibility(View.INVISIBLE);
                    fadeIn(mPigUp);
                    mPigUp.setVisibility(View.VISIBLE);
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });

        mPigUp.setOnTouchListener(this);
        mPigDown.setOnTouchListener(this);
        mAirplaneRed.setOnTouchListener(this);
        mAirplaneBlue.setOnTouchListener(this);
        mTractorRed.setOnTouchListener(this);
        mTractorTrailer.setOnTouchListener(this);
        mCowFive.setOnTouchListener(this);
        mCowTen.setOnTouchListener(this);
        mChickenBlue.setOnTouchListener(this);
        mChickenPink.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mViewId = view.getId();
        mGestureDetector.onTouchEvent(motionEvent);
        winCheck();
        return true;
    }

    public boolean winCheck() {
        if (mCounter > 20) {
            mPigUp.setVisibility(View.INVISIBLE);
            mPigDown.setVisibility(View.INVISIBLE);
            mAirplaneRed.setVisibility(View.INVISIBLE);
            mAirplaneBlue.setVisibility(View.INVISIBLE);
            mTractorRed.setVisibility(View.INVISIBLE);
            mCowFive.setVisibility(View.INVISIBLE);
            mCowTen.setVisibility(View.INVISIBLE);
            mChickenBlue.setVisibility(View.INVISIBLE);
            mChickenPink.setVisibility(View.INVISIBLE);

            mWinTextView.setText(R.string.great_job);
            Animation winAnimation = AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.win_scale_fade_animation);
            mWinTextView.startAnimation(winAnimation);
            return true;
        }
        return false;
    }


    public void moveRight(View view) {
        Animation moveRight = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_right_animation);
        view.startAnimation(moveRight);
    }

    private void moveLeft(View view) {
        Animation moveLeft = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move_left_animation);
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

    public void scaleImage(View view) {
        Animation scaleAnimation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.scale_animation);
        view.startAnimation(scaleAnimation);
    }

    public void rotateImage(View view) {
        Animation rotateAnimation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.rotate_animation);
        view.startAnimation(rotateAnimation);
    }

    private void flingUp(View view) {
        Animation flingUp = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling_up_animation);
        view.startAnimation(flingUp);
    }

    private void flingDown(View view) {
        Animation flingDown = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling_down_animation);
        view.startAnimation(flingDown);
    }

    private void fadeIn(View view) {
        Animation fadeIn = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fade_in_animation);
        view.startAnimation(fadeIn);
    }
}
