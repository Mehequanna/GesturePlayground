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

public class LevelOneActivity extends AppCompatActivity implements View.OnTouchListener {
    @Bind(R.id.cowOne) ImageView mCowOne;
    @Bind(R.id.cowTwo) ImageView mCowTwo;
    @Bind(R.id.cowThree) ImageView mCowThree;
    @Bind(R.id.cowFour) ImageView mCowFour;
    @Bind(R.id.cowFive) ImageView mCowFive;
    @Bind(R.id.cowSix) ImageView mCowSix;
    @Bind(R.id.cowSeven) ImageView mCowSeven;
    @Bind(R.id.cowEight) ImageView mCowEight;
    @Bind(R.id.cowNine) ImageView mCowNine;
    @Bind(R.id.cowTen) ImageView mCowTen;
    @Bind(R.id.winTextView) TextView mWinTextView;

    private GestureDetector mCowOneGestureDetector;
    private GestureDetector mCowTwoGestureDetector;
    private GestureDetector mCowThreeGestureDetector;
    private GestureDetector mCowFourGestureDetector;
    private GestureDetector mCowFiveGestureDetector;
    private GestureDetector mCowSixGestureDetector;
    private GestureDetector mCowSevenGestureDetector;
    private GestureDetector mCowEightGestureDetector;
    private GestureDetector mCowNineGestureDetector;
    private GestureDetector mCowTenGestureDetector;

    private MediaPlayer one;
    private MediaPlayer two;
    private MediaPlayer three;
    private MediaPlayer four;
    private MediaPlayer five;
    private MediaPlayer six;
    private MediaPlayer seven;
    private MediaPlayer eight;
    private MediaPlayer nine;
    private MediaPlayer ten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        ButterKnife.bind(this);

        one = MediaPlayer.create(this, R.raw.one);
        two = MediaPlayer.create(this, R.raw.two);
        three = MediaPlayer.create(this, R.raw.three);
        four = MediaPlayer.create(this, R.raw.four);
        five = MediaPlayer.create(this, R.raw.five);
        six = MediaPlayer.create(this, R.raw.six);
        seven = MediaPlayer.create(this, R.raw.seven);
        eight = MediaPlayer.create(this, R.raw.eight);
        nine = MediaPlayer.create(this, R.raw.nine);
        ten = MediaPlayer.create(this, R.raw.ten);

        mCowOneGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleUpFadeImage(mCowOne);
               one.start();
               mCowOne.setVisibility(View.INVISIBLE);
               mCowTwo.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowTwoGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleDownFadeImage(mCowTwo);
               two.start();
               mCowTwo.setVisibility(View.INVISIBLE);
               mCowThree.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowThreeGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleUpFadeImage(mCowThree);
               three.start();
               mCowThree.setVisibility(View.INVISIBLE);
               mCowFour.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowFourGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleDownFadeImage(mCowFour);
               four.start();
               mCowFour.setVisibility(View.INVISIBLE);
               mCowFive.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowFiveGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleUpFadeImage(mCowFive);
               five.start();
               mCowFive.setVisibility(View.INVISIBLE);
               mCowSix.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowSixGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleDownFadeImage(mCowSix);
               six.start();
               mCowSix.setVisibility(View.INVISIBLE);
               mCowSeven.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowSevenGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleUpFadeImage(mCowSeven);
               seven.start();
               mCowSeven.setVisibility(View.INVISIBLE);
               mCowEight.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowEightGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleDownFadeImage(mCowEight);
               eight.start();
               mCowEight.setVisibility(View.INVISIBLE);
               mCowNine.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowNineGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               scaleUpFadeImage(mCowNine);
               nine.start();
               mCowNine.setVisibility(View.INVISIBLE);
               mCowTen.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowTenGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
                scaleDownFadeImage(mCowTen);
                ten.start();
                mCowTen.setVisibility(View.INVISIBLE);

                mWinTextView.setText(R.string.great_job);

                Animation winScaleUpAnimation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.win_scale_fade_animation);
                mWinTextView.startAnimation(winScaleUpAnimation);
                return true;
            }
        });

        mCowOne.setOnTouchListener(this);
        mCowTwo.setOnTouchListener(this);
        mCowThree.setOnTouchListener(this);
        mCowFour.setOnTouchListener(this);
        mCowFive.setOnTouchListener(this);
        mCowSix.setOnTouchListener(this);
        mCowSeven.setOnTouchListener(this);
        mCowEight.setOnTouchListener(this);
        mCowNine.setOnTouchListener(this);
        mCowTen.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == mCowOne) {
            mCowOneGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowTwo) {
            mCowTwoGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowThree) {
            mCowThreeGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowFour) {
            mCowFourGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowFive) {
            mCowFiveGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowSix) {
            mCowSixGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowSeven) {
            mCowSevenGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowEight) {
            mCowEightGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowNine) {
            mCowNineGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mCowTen) {
            mCowTenGestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        return false;
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
