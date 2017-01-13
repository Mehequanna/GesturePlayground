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

        return false;
    }
}
