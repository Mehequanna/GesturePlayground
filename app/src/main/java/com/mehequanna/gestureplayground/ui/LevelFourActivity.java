package com.mehequanna.gestureplayground.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelFourActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {
    @Bind(R.id.pig1) ImageView mPig1;
    @Bind(R.id.pig2) ImageView mPig2;
    @Bind(R.id.pig3) ImageView mPig3;
    @Bind(R.id.pig4) ImageView mPig4;
    @Bind(R.id.pig5) ImageView mPig5;
    @Bind(R.id.pig6) ImageView mPig6;
    @Bind(R.id.pig7) ImageView mPig7;
    @Bind(R.id.pig8) ImageView mPig8;
    @Bind(R.id.pig9) ImageView mPig9;
    @Bind(R.id.pig10) ImageView mPig10;
    @Bind(R.id.pig11) ImageView mPig11;
    @Bind(R.id.winTextView) TextView mWinTextView;
    @Bind(R.id.playAgainButtonImageView) ImageView mPlayAgainButton;
    @Bind(R.id.homeButtonImageView) ImageView mHomeButton;
    @Bind(R.id.level4VideoView) VideoView mVideoView;

    private GestureDetector mGestureDetector;

    private MediaPlayer up;
    private MediaPlayer down;
    private MediaPlayer pigsnort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four);
        ButterKnife.bind(this);

        up = MediaPlayer.create(this, R.raw.up);
        down = MediaPlayer.create(this, R.raw.down);
        pigsnort = MediaPlayer.create(this, R.raw.pigsnort);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.level4med720);
        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                if (mVideoView.isShown()) {
                    mVideoView.stopPlayback();
                    mVideoView.setVisibility(View.GONE);
                    mPig1.setVisibility(View.VISIBLE);
                }
                return super.onSingleTapConfirmed(e);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (mPig1.isShown()) {
                    flingUp(mPig1);
                    up.start();
                    mPig1.setVisibility(View.INVISIBLE);
                    fadeIn(mPig2);
                    mPig2.setVisibility(View.VISIBLE);
                } else if (mPig2.isShown()) {
                    flingDown(mPig2);
                    down.start();
                    mPig2.setVisibility(View.INVISIBLE);
                    fadeIn(mPig3);
                    mPig3.setVisibility(View.VISIBLE);
                } else if (mPig3.isShown()) {
                    flingLeft(mPig3);
                    pigsnort.start();
                    mPig3.setVisibility(View.INVISIBLE);
                    fadeIn(mPig4);
                    mPig4.setVisibility(View.VISIBLE);
                } else if (mPig4.isShown()) {
                    flingRight(mPig4);
                    pigsnort.start();
                    mPig4.setVisibility(View.INVISIBLE);
                    fadeIn(mPig5);
                    mPig5.setVisibility(View.VISIBLE);
                } else if (mPig5.isShown()) {
                    flingUpLeft(mPig5);
                    up.start();
                    mPig5.setVisibility(View.INVISIBLE);
                    fadeIn(mPig6);
                    mPig6.setVisibility(View.VISIBLE);
                } else if (mPig6.isShown()) {
                    flingDownLeft(mPig6);
                    down.start();
                    mPig6.setVisibility(View.INVISIBLE);
                    fadeIn(mPig7);
                    mPig7.setVisibility(View.VISIBLE);
                } else if (mPig7.isShown()) {
                    flingUpRight(mPig7);
                    up.start();
                    mPig7.setVisibility(View.INVISIBLE);
                    fadeIn(mPig8);
                    mPig8.setVisibility(View.VISIBLE);
                } else if (mPig8.isShown()) {
                    flingDownRight(mPig8);
                    down.start();
                    mPig8.setVisibility(View.INVISIBLE);
                    fadeIn(mPig9);
                    mPig9.setVisibility(View.VISIBLE);
                } else if (mPig9.isShown()) {
                    flingUp(mPig9);
                    pigsnort.start();
                    mPig9.setVisibility(View.INVISIBLE);
                    fadeIn(mPig10);
                    mPig10.setVisibility(View.VISIBLE);
                } else if (mPig10.isShown()) {
                    flingUp(mPig10);
                    up.start();
                    mPig10.setVisibility(View.INVISIBLE);
                    fadeIn(mPig11);
                    mPig11.setVisibility(View.VISIBLE);
                } else if (mPig11.isShown()) {
                    flingUp(mPig11);
                    pigsnort.start();
                    mPig11.setVisibility(View.INVISIBLE);

                    mWinTextView.setText(R.string.great_job);
                    Animation winScaleUpAnimation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.win_scale_fade_animation);
                    mWinTextView.startAnimation(winScaleUpAnimation);

                    mHomeButton.setVisibility(View.VISIBLE);
                    mPlayAgainButton.setVisibility(View.VISIBLE);
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });

        mPig1.setOnTouchListener(this);
        mPig2.setOnTouchListener(this);
        mPig3.setOnTouchListener(this);
        mPig4.setOnTouchListener(this);
        mPig5.setOnTouchListener(this);
        mPig6.setOnTouchListener(this);
        mPig7.setOnTouchListener(this);
        mPig8.setOnTouchListener(this);
        mPig9.setOnTouchListener(this);
        mPig10.setOnTouchListener(this);
        mPig11.setOnTouchListener(this);
        mVideoView.setOnTouchListener(this);
        mHomeButton.setOnClickListener(this);
        mPlayAgainButton.setOnClickListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mGestureDetector.onTouchEvent(motionEvent);
        return true;
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

    private void flingDownRight(View view) {
        Animation flingDownRight = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling_down_right_animation);
        view.startAnimation(flingDownRight);
    }

    private void flingDownLeft(View view) {
        Animation flingDownLeft = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling_down_left_animation);
        view.startAnimation(flingDownLeft);
    }

    private void flingUpRight(View view) {
        Animation flingUpRight = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling_up_right_animation);
        view.startAnimation(flingUpRight);
    }

    private void flingUpLeft(View view) {
        Animation flingUpLeft = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling_up_left_animation);
        view.startAnimation(flingUpLeft);
    }

    private void flingLeft(View view) {
        Animation flingLeft = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling_left_animation);
        view.startAnimation(flingLeft);
    }

    private void flingRight(View view) {
        Animation flingRight = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fling_right_animation);
        view.startAnimation(flingRight);
    }

    private void fadeIn(View view) {
        Animation fadeIn = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fade_in_animation);
        view.startAnimation(fadeIn);
    }

    @Override
    public void onClick(View view) {
        if (view == mHomeButton) {
            Intent intent = new Intent(LevelFourActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (view == mPlayAgainButton) {
            mPlayAgainButton.setVisibility(View.INVISIBLE);
            mHomeButton.setVisibility(View.INVISIBLE);
            mWinTextView.setVisibility(View.INVISIBLE);
            mPig1.setVisibility(View.VISIBLE);
        }
    }
}
