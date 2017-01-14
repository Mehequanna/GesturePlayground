package com.mehequanna.gestureplayground.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        ButterKnife.bind(this);

        mCowTwo.setVisibility(View.INVISIBLE);
        mCowThree.setVisibility(View.INVISIBLE);
        mCowFour.setVisibility(View.INVISIBLE);
        mCowFive.setVisibility(View.INVISIBLE);
        mCowSix.setVisibility(View.INVISIBLE);
        mCowSeven.setVisibility(View.INVISIBLE);
        mCowEight.setVisibility(View.INVISIBLE);
        mCowNine.setVisibility(View.INVISIBLE);
        mCowTen.setVisibility(View.INVISIBLE);

        mCowOneGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowOne.setVisibility(View.INVISIBLE);
               mCowTwo.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowTwoGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowTwo.setVisibility(View.INVISIBLE);
               mCowThree.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowThreeGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowThree.setVisibility(View.INVISIBLE);
               mCowFour.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowFourGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowFour.setVisibility(View.INVISIBLE);
               mCowFive.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowFiveGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowFive.setVisibility(View.INVISIBLE);
               mCowSix.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowSixGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowSix.setVisibility(View.INVISIBLE);
               mCowSeven.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowSevenGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowSeven.setVisibility(View.INVISIBLE);
               mCowEight.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowEightGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowEight.setVisibility(View.INVISIBLE);
               mCowNine.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowNineGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               mCowNine.setVisibility(View.INVISIBLE);
               mCowTen.setVisibility(View.VISIBLE);
               return true;
           }
        });

        mCowTenGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
                mCowTen.setVisibility(View.INVISIBLE);
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
}
