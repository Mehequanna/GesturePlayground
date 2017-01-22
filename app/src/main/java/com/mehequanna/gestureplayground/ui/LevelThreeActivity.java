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

    private GestureDetector mOneTractorPinkGestureDetector;
    private GestureDetector mTwoTractorBlackGestureDetector;
    private GestureDetector mThreeTractorRedGestureDetector;
    private GestureDetector mFourTractorGreenGestureDetector;
    private GestureDetector mFiveAirplaneGreenGestureDetector;
    private GestureDetector mSixAirplaneRedGestureDetector;
    private GestureDetector mSevenAirplaneBlueGestureDetector;

    MediaPlayer planeStartLeft;
    MediaPlayer planeStartRight;
    MediaPlayer planeFlyRight;
    MediaPlayer planeFlyLeft;
    MediaPlayer tractorStartLeft;
    MediaPlayer tractorStartRight;
    MediaPlayer tractorDriveLeft;
    MediaPlayer tractorDriveRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);
        ButterKnife.bind(this);

        planeStartLeft = MediaPlayer.create(this, R.raw.planestartleft);
        planeStartRight = MediaPlayer.create(this, R.raw.planestartright);
        planeFlyLeft = MediaPlayer.create(this, R.raw.planeflytoleft);
        planeFlyRight = MediaPlayer.create(this, R.raw.planeflytoright);
        tractorStartLeft = MediaPlayer.create(this, R.raw.tractorstartleft);
        tractorStartRight = MediaPlayer.create(this, R.raw.tractorstartright);
        tractorDriveLeft = MediaPlayer.create(this, R.raw.tractordrivingtoleft);
        tractorDriveRight = MediaPlayer.create(this, R.raw.tractordrivingtoright);

        mOneTractorPinkGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onDown(MotionEvent motionEvent) {
               tractorStartLeft.start();
               return true;
           }

            @Override
            public void onSwipeRight() {
                tractorStartLeft.stop();
                tractorDriveRight.start();
                moveRight(mOneTractorPink);
                mOneTractorPink.setVisibility(View.INVISIBLE);
                mTwoTractorBlack.setVisibility(View.VISIBLE);
            }
        });

        mTwoTractorBlackGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                tractorStartRight.start();
                return true;
            }

            //To future self: When flipping an ImageView in xml via: android:scaleX="-1" you are also flipping the swipe directions. So this should have been onSwipeLeft, but since the scaleX="-1" is used onSwipeRight is needed.
            @Override
            public void onSwipeRight() {
                tractorStartRight.stop();
                tractorDriveLeft.start();
                moveLeft(mTwoTractorBlack);
                mTwoTractorBlack.setVisibility(View.INVISIBLE);
                mThreeTractorRed.setVisibility(View.VISIBLE);
            }
        });

        mThreeTractorRedGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                tractorStartLeft.start();
                return true;
            }

            @Override
            public void onSwipeRight() {
                tractorStartLeft.stop();
                tractorDriveRight.start();
                moveRight(mThreeTractorRed);
                mThreeTractorRed.setVisibility(View.INVISIBLE);
                mFourTractorGreen.setVisibility(View.VISIBLE);
            }
        });

        mFourTractorGreenGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                tractorStartRight.start();
                return true;
            }

            //To future self: When flipping an ImageView in xml via: android:scaleX="-1" you are also flipping the swipe directions. So this should have been onSwipeLeft, but since the scaleX="-1" is used onSwipeRight is needed.
            @Override
            public void onSwipeRight() {
                tractorStartRight.stop();
                tractorDriveLeft.start();
                moveLeft(mFourTractorGreen);
                mFourTractorGreen.setVisibility(View.INVISIBLE);
                mFiveAirplaneGreen.setVisibility(View.VISIBLE);
            }
        });

        mFiveAirplaneGreenGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                planeStartLeft.start();
                return true;
            }

            //To future self: When flipping an ImageView in xml via: android:scaleX="-1" you are also flipping the swipe directions. So this should have been onSwipeRight, but since the scaleX="-1" is used onSwipeLeft is needed.
            @Override
            public void onSwipeLeft() {
                planeStartLeft.stop();
                planeFlyRight.start();
                moveRight(mFiveAirplaneGreen);
                mFiveAirplaneGreen.setVisibility(View.INVISIBLE);
                mSixAirplaneRed.setVisibility(View.VISIBLE);
            }
        });

        mSixAirplaneRedGestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                planeStartRight.start();
                return true;
            }

            @Override
            public void onSwipeLeft() {
                planeStartRight.stop();
                planeFlyLeft.start();
                moveLeft(mSixAirplaneRed);
                mSixAirplaneRed.setVisibility(View.INVISIBLE);
                mSevenAirplaneBlue.setVisibility(View.VISIBLE);
            }
        });

        mSevenAirplaneBlueGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                planeStartLeft.start();
                return true;
            }

            //To future self: When flipping an ImageView in xml via: android:scaleX="-1" you are also flipping the swipe directions. So this should have been onSwipeRight, but since the scaleX="-1" is used onSwipeLeft is needed.
            @Override
            public void onSwipeLeft() {
                planeStartLeft.stop();
                planeFlyRight.start();
                moveRight(mSevenAirplaneBlue);
                mSevenAirplaneBlue.setVisibility(View.INVISIBLE);
                mWinTextView.setText(R.string.great_job);

                Animation winScaleUpAnimation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.win_scale_fade_animation);
                mWinTextView.startAnimation(winScaleUpAnimation);
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
        if (view == mOneTractorPink) {
            mOneTractorPinkGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        if (view == mTwoTractorBlack) {
            mTwoTractorBlackGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        if (view == mThreeTractorRed) {
            mThreeTractorRedGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        if (view == mFourTractorGreen) {
            mFourTractorGreenGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        if (view == mFiveAirplaneGreen) {
            mFiveAirplaneGreenGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        if (view == mSixAirplaneRed) {
            mSixAirplaneRedGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        if (view == mSevenAirplaneBlue) {
            mSevenAirplaneBlueGestureDetector.onTouchEvent(motionEvent);
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
}
