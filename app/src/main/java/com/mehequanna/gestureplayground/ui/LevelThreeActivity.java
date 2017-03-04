package com.mehequanna.gestureplayground.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelThreeActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {
    @Bind(R.id.oneTractorPink) ImageView mOneTractorPink;
    @Bind(R.id.twoTractorBlack) ImageView mTwoTractorBlack;
    @Bind(R.id.threeTractorRed) ImageView mThreeTractorRed;
    @Bind(R.id.fourTractorGreen) ImageView mFourTractorGreen;
    @Bind(R.id.fiveAirplaneGreen) ImageView mFiveAirplaneGreen;
    @Bind(R.id.sixAirplaneRed) ImageView mSixAirplaneRed;
    @Bind(R.id.sevenAirplaneBlue) ImageView mSevenAirplaneBlue;
    @Bind(R.id.eightTractorTrailer) ImageView mEightTractorTrailer;
    @Bind(R.id.winTextView) TextView mWinTextView;
    @Bind(R.id.homeButtonImageView) ImageView mHomeButton;
    @Bind(R.id.playAgainButtonImageView) ImageView mPlayAgain;
    @Bind(R.id.level3VideoView) VideoView mVideoView;

    private GestureDetector mGestureDetector;

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

        Toast.makeText(this, "Tap to continue.", Toast.LENGTH_SHORT).show();

        initResources();
        initGestures();

        mVideoView.start();

        mOneTractorPink.setOnTouchListener(this);
        mTwoTractorBlack.setOnTouchListener(this);
        mThreeTractorRed.setOnTouchListener(this);
        mFourTractorGreen.setOnTouchListener(this);
        mFiveAirplaneGreen.setOnTouchListener(this);
        mSixAirplaneRed.setOnTouchListener(this);
        mSevenAirplaneBlue.setOnTouchListener(this);
        mEightTractorTrailer.setOnTouchListener(this);
        mVideoView.setOnTouchListener(this);
        mHomeButton.setOnClickListener(this);
        mPlayAgain.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaRelease();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                onBackPressed();
                break;
            case R.id.homeAsUp:
                onBackPressed();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void mediaRelease() {
        planeStartLeft.release();
        planeStartRight.release();
        planeFlyLeft.release();
        planeFlyRight.release();
        tractorStartLeft.release();
        tractorStartRight.release();
        tractorDriveLeft.release();
        tractorDriveRight.release();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
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

    private void fadeInButtons(View view) {
        Animation fadeInButtons = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fade_in_buttons_animation);
        view.startAnimation(fadeInButtons);
    }

    @Override
    public void onClick(View view) {
        if (view == mHomeButton) {
            Intent intent = new Intent(LevelThreeActivity.this, MainActivity.class);
            startActivity(intent);
            onBackPressed();
        } else if (view == mPlayAgain) {
            mPlayAgain.setVisibility(View.INVISIBLE);
            mHomeButton.setVisibility(View.INVISIBLE);
            mWinTextView.setVisibility(View.INVISIBLE);

            mOneTractorPink.clearAnimation();
            mTwoTractorBlack.clearAnimation();
            mThreeTractorRed.clearAnimation();
            mFourTractorGreen.clearAnimation();
            mFiveAirplaneGreen.clearAnimation();
            mSixAirplaneRed.clearAnimation();
            mSevenAirplaneBlue.clearAnimation();
            mEightTractorTrailer.clearAnimation();

            mOneTractorPink.setVisibility(View.VISIBLE);
        }
    }

    private void initResources() {
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.level3med720);
        mVideoView.setVideoURI(uri);

        planeStartLeft = MediaPlayer.create(this, R.raw.planestartleft);
        planeStartRight = MediaPlayer.create(this, R.raw.planestartright);
        planeFlyLeft = MediaPlayer.create(this, R.raw.planeflytoleft);
        planeFlyRight = MediaPlayer.create(this, R.raw.planeflytoright);
        tractorStartLeft = MediaPlayer.create(this, R.raw.tractorstartleft);
        tractorStartRight = MediaPlayer.create(this, R.raw.tractorstartright);
        tractorDriveLeft = MediaPlayer.create(this, R.raw.tractordrivingtoleft);
        tractorDriveRight = MediaPlayer.create(this, R.raw.tractordrivingtoright);
    }

    private void initGestures() {
        mGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDown(MotionEvent e) {
                if (mVideoView.isShown()) {
                    mVideoView.stopPlayback();
                    mVideoView.setVisibility(View.GONE);
                    mOneTractorPink.setVisibility(View.VISIBLE);
                } else if (mOneTractorPink.isShown()) {
                    tractorStartLeft.start();
                } else if (mTwoTractorBlack.isShown()) {
                    tractorStartRight.start();
                } else if (mThreeTractorRed.isShown()) {
                    tractorStartLeft.start();
                } else if (mFourTractorGreen.isShown()) {
                    tractorStartRight.start();
                } else if (mFiveAirplaneGreen.isShown()) {
                    planeStartLeft.start();
                } else if (mSixAirplaneRed.isShown()) {
                    planeStartRight.start();
                } else if (mSevenAirplaneBlue.isShown()) {
                    planeStartLeft.start();
                } else if (mEightTractorTrailer.isShown()) {
                    tractorStartRight.start();
                }
                return super.onDown(e);
            }

            @Override
            public void onSwipeRight() {
                if (mOneTractorPink.isShown()) {
                    tractorStartLeft.stop();
                    tractorDriveRight.start();
                    moveRight(mOneTractorPink);
                    mOneTractorPink.setVisibility(View.INVISIBLE);
                    mTwoTractorBlack.setVisibility(View.VISIBLE);
                } else if (mTwoTractorBlack.isShown()) {
                    //To future self: When flipping an ImageView in xml via: android:scaleX="-1" you are also flipping the swipe directions. So this should have been onSwipeLeft, but since the scaleX="-1" is used onSwipeRight is needed.
                    tractorStartRight.stop();
                    tractorDriveLeft.start();
                    moveLeft(mTwoTractorBlack);
                    mTwoTractorBlack.setVisibility(View.INVISIBLE);
                    mThreeTractorRed.setVisibility(View.VISIBLE);
                } else if (mThreeTractorRed.isShown()) {
                    tractorStartLeft.stop();
                    tractorDriveRight.start();
                    moveRight(mThreeTractorRed);
                    mThreeTractorRed.setVisibility(View.INVISIBLE);
                    mFourTractorGreen.setVisibility(View.VISIBLE);
                } else if (mFourTractorGreen.isShown()) {
                    // See previous note.
                    tractorStartRight.stop();
                    tractorDriveLeft.start();
                    moveLeft(mFourTractorGreen);
                    mFourTractorGreen.setVisibility(View.INVISIBLE);
                    mFiveAirplaneGreen.setVisibility(View.VISIBLE);
                } else if (mEightTractorTrailer.isShown()) {
                    // See previous note.
                    tractorStartRight.stop();
                    tractorDriveLeft.start();
                    moveLeft(mEightTractorTrailer);
                    mEightTractorTrailer.setVisibility(View.INVISIBLE);

                    mWinTextView.setText(R.string.great_job);
                    Animation winScaleUpAnimation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.win_scale_fade_animation);
                    mWinTextView.startAnimation(winScaleUpAnimation);

                    fadeInButtons(mHomeButton);
                    mHomeButton.setVisibility(View.VISIBLE);
                    fadeInButtons(mPlayAgain);
                    mPlayAgain.setVisibility(View.VISIBLE);
                }
                super.onSwipeRight();
            }

            @Override
            public void onSwipeLeft() {
                if (mFiveAirplaneGreen.isShown()) {
                    //To future self: When flipping an ImageView in xml via: android:scaleX="-1" you are also flipping the swipe directions. So this should have been onSwipeRight, but since the scaleX="-1" is used onSwipeLeft is needed.
                    planeStartLeft.stop();
                    planeFlyRight.start();
                    moveRight(mFiveAirplaneGreen);
                    mFiveAirplaneGreen.setVisibility(View.INVISIBLE);
                    mSixAirplaneRed.setVisibility(View.VISIBLE);
                } else if (mSixAirplaneRed.isShown()) {
                    planeStartRight.stop();
                    planeFlyLeft.start();
                    moveLeft(mSixAirplaneRed);
                    mSixAirplaneRed.setVisibility(View.INVISIBLE);
                    mSevenAirplaneBlue.setVisibility(View.VISIBLE);
                } else if (mSevenAirplaneBlue.isShown()) {
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
    }
}