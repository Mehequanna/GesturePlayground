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

public class LevelOneActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {
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
    @Bind(R.id.homeButtonImageView) ImageView mHomeButton;
    @Bind(R.id.playAgainButtonImageView) ImageView mPlayAgain;
    @Bind(R.id.level1VideoView) VideoView mVideoView;

    private int mCowOneId;
    private int mCowTwoId;
    private int mCowThreeId;
    private int mCowFourId;
    private int mCowFiveId;
    private int mCowSixId;
    private int mCowSevenId;
    private int mCowEightId;
    private int mCowNineId;
    private int mCowTenId;
    private int mVideoViewId;
    private int mViewId;

    private GestureDetector mGestureDetector;

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

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.level1med720);
        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mCowOneId = mCowOne.getId();
        mCowTwoId = mCowTwo.getId();
        mCowThreeId = mCowThree.getId();
        mCowFourId = mCowFour.getId();
        mCowFiveId = mCowFive.getId();
        mCowSixId = mCowSix.getId();
        mCowSevenId = mCowSeven.getId();
        mCowEightId = mCowEight.getId();
        mCowNineId = mCowNine.getId();
        mCowTenId = mCowTen.getId();
        mVideoViewId = mVideoView.getId();

        mGestureDetector = new GestureDetector(this, new DetectGestures(){
           @Override
            public boolean onSingleTapConfirmed(MotionEvent e){
               if (mViewId == mVideoViewId) {
                   mVideoView.stopPlayback();
                   mVideoView.setVisibility(View.GONE);
                   mCowOne.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowOneId) {
                   scaleUpFadeImage(mCowOne);
                   one.start();
                   mCowOne.setVisibility(View.INVISIBLE);
                   mCowTwo.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowTwoId) {
                   scaleDownFadeImage(mCowTwo);
                   two.start();
                   mCowTwo.setVisibility(View.INVISIBLE);
                   mCowThree.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowThreeId) {
                   scaleUpFadeImage(mCowThree);
                   three.start();
                   mCowThree.setVisibility(View.INVISIBLE);
                   mCowFour.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowFourId) {
                   scaleDownFadeImage(mCowFour);
                   four.start();
                   mCowFour.setVisibility(View.INVISIBLE);
                   mCowFive.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowFiveId) {
                   scaleUpFadeImage(mCowFive);
                   five.start();
                   mCowFive.setVisibility(View.INVISIBLE);
                   mCowSix.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowSixId) {
                   scaleDownFadeImage(mCowSix);
                   six.start();
                   mCowSix.setVisibility(View.INVISIBLE);
                   mCowSeven.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowSevenId) {
                   scaleUpFadeImage(mCowSeven);
                   seven.start();
                   mCowSeven.setVisibility(View.INVISIBLE);
                   mCowEight.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowEightId) {
                   scaleDownFadeImage(mCowEight);
                   eight.start();
                   mCowEight.setVisibility(View.INVISIBLE);
                   mCowNine.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowNineId) {
                   scaleUpFadeImage(mCowNine);
                   nine.start();
                   mCowNine.setVisibility(View.INVISIBLE);
                   mCowTen.setVisibility(View.VISIBLE);
               } else if (mViewId == mCowTenId) {
                   scaleDownFadeImage(mCowTen);
                   ten.start();
                   mCowTen.setVisibility(View.INVISIBLE);

                   mWinTextView.setText(R.string.great_job);

                   Animation winScaleUpAnimation = AnimationUtils.loadAnimation(
                           getApplicationContext(), R.anim.win_scale_fade_animation);
                   mWinTextView.startAnimation(winScaleUpAnimation);

                   mHomeButton.setVisibility(View.VISIBLE);
                   mPlayAgain.setVisibility(View.VISIBLE);
               }

              return super.onSingleTapConfirmed(e);
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
        mVideoView.setOnTouchListener(this);
        mHomeButton.setOnClickListener(this);
        mPlayAgain.setOnClickListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mViewId = view.getId();
        mGestureDetector.onTouchEvent(motionEvent);
        return true;
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

    @Override
    public void onClick(View view) {
        if (view == mHomeButton) {
            Intent intent = new Intent(LevelOneActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (view == mPlayAgain) {
            mPlayAgain.setVisibility(View.INVISIBLE);
            mHomeButton.setVisibility(View.INVISIBLE);
            mWinTextView.setVisibility(View.INVISIBLE);
            mCowOne.setVisibility(View.VISIBLE);
        }
    }
}
