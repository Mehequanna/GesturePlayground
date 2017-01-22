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

public class LevelThreeActivity extends AppCompatActivity implements View.OnTouchListener {
    @Bind(R.id.oneTractorPink) ImageView mOneTractorPink;
    @Bind(R.id.twoTractorBlack) ImageView mTwoTractorBlack;
    @Bind(R.id.threeTractorRed) ImageView mThreeTractorRed;
    @Bind(R.id.fourTractorGreen) ImageView mFourTractorGreen;
    @Bind(R.id.fiveAirplaneGreen) ImageView mFiveAirplaneGreen;
    @Bind(R.id.sixAirplaneRed) ImageView mSixAirplaneRed;
    @Bind(R.id.sevenAirplaneBlue) ImageView mSevenAirplaneBlue;
    @Bind(R.id.eightTractorTrailer) ImageView mEightTractorTrailer;
    @Bind(R.id.winTextView) TextView mWinTextView;

    private GestureDetector mGestureDetector;
    private int mViewId;

    private int mOneTractorId;
    private int mTwoTractorId;
    private int mThreeTractorId;
    private int mFourTractorId;
    private int mFiveAirplaneId;
    private int mSixAirplaneId;
    private int mSevenAirplaneId;
    private int mEightTractorId;

    private MediaPlayer planeStartLeft;
    private MediaPlayer planeStartRight;
    private MediaPlayer planeFlyRight;
    private MediaPlayer planeFlyLeft;
    private MediaPlayer tractorStartLeft;
    private MediaPlayer tractorStartRight;
    private MediaPlayer tractorDriveLeft;
    private MediaPlayer tractorDriveRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);
        ButterKnife.bind(this);

        mOneTractorId = mOneTractorPink.getId();
        mTwoTractorId = mTwoTractorBlack.getId();
        mThreeTractorId = mThreeTractorRed.getId();
        mFourTractorId = mFourTractorGreen.getId();
        mFiveAirplaneId = mFiveAirplaneGreen.getId();
        mSixAirplaneId = mSixAirplaneRed.getId();
        mSevenAirplaneId = mSevenAirplaneBlue.getId();
        mEightTractorId = mEightTractorTrailer.getId();

        planeStartLeft = MediaPlayer.create(this, R.raw.planestartleft);
        planeStartRight = MediaPlayer.create(this, R.raw.planestartright);
        planeFlyLeft = MediaPlayer.create(this, R.raw.planeflytoleft);
        planeFlyRight = MediaPlayer.create(this, R.raw.planeflytoright);
        tractorStartLeft = MediaPlayer.create(this, R.raw.tractorstartleft);
        tractorStartRight = MediaPlayer.create(this, R.raw.tractorstartright);
        tractorDriveLeft = MediaPlayer.create(this, R.raw.tractordrivingtoleft);
        tractorDriveRight = MediaPlayer.create(this, R.raw.tractordrivingtoright);

        mGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent e) {
                if (mViewId == mOneTractorId) {
                    tractorStartLeft.start();
                } else if (mViewId == mTwoTractorId) {
                    tractorStartRight.start();
                } else if (mViewId == mThreeTractorId) {
                    tractorStartLeft.start();
                } else if (mViewId == mFourTractorId) {
                    tractorStartRight.start();
                } else if (mViewId == mFiveAirplaneId) {
                    planeStartLeft.start();
                } else if (mViewId == mSixAirplaneId) {
                    planeStartRight.start();
                } else if (mViewId == mSevenAirplaneId) {
                    planeStartLeft.start();
                } else if (mViewId == mEightTractorId) {
                    tractorStartRight.start();
                }
                return super.onDown(e);
            }

            @Override
            public void onSwipeRight() {
                if (mViewId == mOneTractorId) {
                    tractorStartLeft.stop();
                    tractorDriveRight.start();
                    moveRight(mOneTractorPink);
                    mOneTractorPink.setVisibility(View.INVISIBLE);
                    mTwoTractorBlack.setVisibility(View.VISIBLE);
                } else if (mViewId == mTwoTractorId) {
                    //To future self: When flipping an ImageView in xml via: android:scaleX="-1" you are also flipping the swipe directions. So this should have been onSwipeLeft, but since the scaleX="-1" is used onSwipeRight is needed.
                    tractorStartRight.stop();
                    tractorDriveLeft.start();
                    moveLeft(mTwoTractorBlack);
                    mTwoTractorBlack.setVisibility(View.INVISIBLE);
                    mThreeTractorRed.setVisibility(View.VISIBLE);
                } else if (mViewId == mThreeTractorId) {
                    tractorStartLeft.stop();
                    tractorDriveRight.start();
                    moveRight(mThreeTractorRed);
                    mThreeTractorRed.setVisibility(View.INVISIBLE);
                    mFourTractorGreen.setVisibility(View.VISIBLE);
                } else if (mViewId == mFourTractorId) {
                    // See previous note.
                    tractorStartRight.stop();
                    tractorDriveLeft.start();
                    moveLeft(mFourTractorGreen);
                    mFourTractorGreen.setVisibility(View.INVISIBLE);
                    mFiveAirplaneGreen.setVisibility(View.VISIBLE);
                } else if (mViewId == mEightTractorId) {
                    // See previous note.
                    tractorStartRight.stop();
                    tractorDriveLeft.start();
                    moveLeft(mEightTractorTrailer);
                    mEightTractorTrailer.setVisibility(View.INVISIBLE);

                    mWinTextView.setText(R.string.great_job);
                    Animation winScaleUpAnimation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.win_scale_fade_animation);
                    mWinTextView.startAnimation(winScaleUpAnimation);
                }
                super.onSwipeRight();
            }

            @Override
            public void onSwipeLeft() {
                if (mViewId == mFiveAirplaneId) {
                    //To future self: When flipping an ImageView in xml via: android:scaleX="-1" you are also flipping the swipe directions. So this should have been onSwipeRight, but since the scaleX="-1" is used onSwipeLeft is needed.
                    planeStartLeft.stop();
                    planeFlyRight.start();
                    moveRight(mFiveAirplaneGreen);
                    mFiveAirplaneGreen.setVisibility(View.INVISIBLE);
                    mSixAirplaneRed.setVisibility(View.VISIBLE);
                } else if (mViewId == mSixAirplaneId) {
                    planeStartRight.stop();
                    planeFlyLeft.start();
                    moveLeft(mSixAirplaneRed);
                    mSixAirplaneRed.setVisibility(View.INVISIBLE);
                    mSevenAirplaneBlue.setVisibility(View.VISIBLE);
                } else if (mViewId == mSevenAirplaneId) {
                    // See previous note.
                    planeStartLeft.stop();
                    planeFlyRight.start();
                    moveRight(mSevenAirplaneBlue);
                    mSevenAirplaneBlue.setVisibility(View.INVISIBLE);
                    mEightTractorTrailer.setVisibility(View.VISIBLE);
                }
                super.onSwipeLeft();
            }
        });

        mOneTractorPink.setOnTouchListener(this);
        mTwoTractorBlack.setOnTouchListener(this);
        mThreeTractorRed.setOnTouchListener(this);
        mFourTractorGreen.setOnTouchListener(this);
        mFiveAirplaneGreen.setOnTouchListener(this);
        mSixAirplaneRed.setOnTouchListener(this);
        mSevenAirplaneBlue.setOnTouchListener(this);
        mEightTractorTrailer.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mViewId = view.getId();
        mGestureDetector.onTouchEvent(motionEvent);
        return true;
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
}