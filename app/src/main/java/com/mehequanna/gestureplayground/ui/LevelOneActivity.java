package com.mehequanna.gestureplayground.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelOneActivity extends AppCompatActivity implements View.OnTouchListener {
    @Bind(R.id.chicken0) ImageView mChicken0;
    @Bind(R.id.chicken1) ImageView mChicken1;
    @Bind(R.id.chicken2) ImageView mChicken2;
    @Bind(R.id.chicken3) ImageView mChicken3;
    @Bind(R.id.chicken4) ImageView mChicken4;
    @Bind(R.id.chicken5) ImageView mChicken5;

    private GestureDetector mChicken0GestureDetector;
    private GestureDetector mChicken1GestureDetector;
    private GestureDetector mChicken2GestureDetector;
    private GestureDetector mChicken3GestureDetector;
    private GestureDetector mChicken4GestureDetector;
    private GestureDetector mChicken5GestureDetector;

    MediaPlayer blue;
    MediaPlayer brown;
    MediaPlayer pink;
    MediaPlayer red;
    MediaPlayer white;
    MediaPlayer yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        ButterKnife.bind(this);

        blue = MediaPlayer.create(this, R.raw.bluef);
        brown = MediaPlayer.create(this, R.raw.brownf);
        pink = MediaPlayer.create(this, R.raw.pinkf);
        red = MediaPlayer.create(this, R.raw.redf);
        white = MediaPlayer.create(this, R.raw.whitef);
        yellow = MediaPlayer.create(this, R.raw.yellowf);

        mChicken1.setVisibility(View.INVISIBLE);
        mChicken2.setVisibility(View.INVISIBLE);
        mChicken3.setVisibility(View.INVISIBLE);
        mChicken4.setVisibility(View.INVISIBLE);
        mChicken5.setVisibility(View.INVISIBLE);

        mChicken0.setOnTouchListener(this);
        mChicken1.setOnTouchListener(this);
        mChicken2.setOnTouchListener(this);
        mChicken3.setOnTouchListener(this);
        mChicken4.setOnTouchListener(this);
        mChicken5.setOnTouchListener(this);

        mChicken0GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
                anim.setInterpolator(new LinearInterpolator());
                anim.setRepeatCount(0);
                anim.setDuration(700);

                // Start animating the image
                mChicken0.startAnimation(anim);

                mChicken0.setVisibility(View.INVISIBLE);

//                white.start();
                mChicken1.setVisibility(View.VISIBLE);

                return true;
            }
        });

        mChicken1GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                mChicken1.setVisibility(View.INVISIBLE);

//                red.start();
                mChicken2.setVisibility(View.VISIBLE);
                return true;
            }
        });

        mChicken2GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                mChicken2.setVisibility(View.INVISIBLE);

//                pink.start();
                mChicken3.setVisibility(View.VISIBLE);
                return true;
            }
        });

        mChicken3GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                mChicken3.setVisibility(View.INVISIBLE);

//                brown.start();
                mChicken4.setVisibility(View.VISIBLE);
                return true;
            }
        });

        mChicken4GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                mChicken4.setVisibility(View.INVISIBLE);

//                blue.start();
                mChicken5.setVisibility(View.VISIBLE);
                return true;
            }
        });

        mChicken5GestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                mChicken0.setVisibility(View.VISIBLE);
                mChicken1.setVisibility(View.VISIBLE);
                mChicken2.setVisibility(View.VISIBLE);
                mChicken3.setVisibility(View.VISIBLE);
                mChicken4.setVisibility(View.VISIBLE);
                mChicken5.setVisibility(View.INVISIBLE);
                return true;
            }
        });

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == mChicken0) {
            mChicken0GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken1) {
            mChicken1GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken2) {
            mChicken2GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken3) {
            mChicken3GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken4) {
            mChicken4GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        if (view == mChicken5) {
            mChicken5GestureDetector.onTouchEvent(motionEvent);
            return true;
        }

            return false;
    }
}
