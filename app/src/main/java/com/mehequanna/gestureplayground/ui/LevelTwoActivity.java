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
import android.widget.VideoView;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelTwoActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {
    @Bind(R.id.chicken1) ImageView mChicken1;
    @Bind(R.id.chicken2) ImageView mChicken2;
    @Bind(R.id.chicken3) ImageView mChicken3;
    @Bind(R.id.chicken4) ImageView mChicken4;
    @Bind(R.id.chicken5) ImageView mChicken5;
    @Bind(R.id.chicken6) ImageView mChicken6;
    @Bind(R.id.winTextView) TextView mWinTextView;
    @Bind(R.id.level2VideoView) VideoView mVideoView;
    @Bind(R.id.homeButtonImageView) ImageView mHomeButton;
    @Bind(R.id.playAgainButtonImageView) ImageView mPlayAgain;

    private GestureDetector mGestureDetector;

    private MediaPlayer blue;
    private MediaPlayer brown;
    private MediaPlayer pink;
    private MediaPlayer red;
    private MediaPlayer white;
    private MediaPlayer yellow;

    private int mChicken1Count;
    private int mChicken2Count;
    private int mChicken3Count;
    private int mChicken4Count;
    private int mChicken5Count;
    private int mChicken6Count;

    private int mChicken1Id;
    private int mChicken2Id;
    private int mChicken3Id;
    private int mChicken4Id;
    private int mChicken5Id;
    private int mChicken6Id;
    private int mVideoId;
    private int mViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);
        ButterKnife.bind(this);

        initResources();
        initGestures();

        mVideoView.start();

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mVideoView.stopPlayback();
                mVideoView.setVisibility(View.GONE);
                mChicken1.setVisibility(View.VISIBLE);
            }
        });

        mChicken1.setOnTouchListener(this);
        mChicken2.setOnTouchListener(this);
        mChicken3.setOnTouchListener(this);
        mChicken4.setOnTouchListener(this);
        mChicken5.setOnTouchListener(this);
        mChicken6.setOnTouchListener(this);
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
        blue.release();
        brown.release();
        pink.release();
        red.release();
        white.release();
        yellow.release();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mViewId = view.getId();
        mGestureDetector.onTouchEvent(motionEvent);
        if (mChicken1Count > 1) {
            winCheck();
        }
        return true;
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

    public void fadeOutImage(View view) {
        Animation fadeOutAnimation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fade_out_animation);
        view.startAnimation(fadeOutAnimation);
    }

    private void fadeInButtons(View view) {
        Animation fadeInButtons = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.fade_in_buttons_animation);
        view.startAnimation(fadeInButtons);
    }

    public void winCheck() {
        if (mChicken1.getVisibility() >= 4 && mChicken2.getVisibility() >= 4 && mChicken3.getVisibility() >= 4 && mChicken4.getVisibility() >= 4 && mChicken5.getVisibility() >= 4 && mChicken6.getVisibility() >= 4) {
            mWinTextView.setText(R.string.great_job);

            Animation winAnimation = AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.win_scale_fade_animation);
            mWinTextView.startAnimation(winAnimation);

            fadeInButtons(mPlayAgain);
            mPlayAgain.setVisibility(View.VISIBLE);
            fadeInButtons(mHomeButton);
            mHomeButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mHomeButton) {
            Intent intent = new Intent(LevelTwoActivity.this, MainActivity.class);
            startActivity(intent);
            onBackPressed();
        } else if (view == mPlayAgain) {
            mPlayAgain.setVisibility(View.INVISIBLE);
            mHomeButton.setVisibility(View.INVISIBLE);
            mWinTextView.setVisibility(View.INVISIBLE);
            mChicken1Count = 0;
            mChicken2Count = 0;
            mChicken3Count = 0;
            mChicken4Count = 0;
            mChicken5Count = 0;
            mChicken6Count = 0;
            mChicken1.setVisibility(View.VISIBLE);
        }
    }

    private void initGestures() {
        mGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (mViewId == mChicken1Id) {
                    if (mChicken1Count == 0) {
                        rotateImage(mChicken1);
                        mChicken1.setVisibility(View.INVISIBLE);
                        yellow.start();
                        mChicken2.setVisibility(View.VISIBLE);
                    } else if (mChicken1Count >= 1) {
                        scaleImage(mChicken1);
                        mChicken1.setVisibility(View.INVISIBLE);
                        yellow.start();
                    }
                    mChicken1Count += 1;
                } else if (mViewId == mChicken2Id) {
                    if (mChicken2Count == 0) {
                        scaleImage(mChicken2);
                        mChicken2.setVisibility(View.INVISIBLE);
                        white.start();
                        mChicken3.setVisibility(View.VISIBLE);
                    } else if (mChicken2Count >= 1) {
                        fadeOutImage(mChicken2);
                        mChicken2.setVisibility(View.INVISIBLE);
                        white.start();
                    }
                    mChicken2Count += 1;
                } else if (mViewId == mChicken3Id) {
                    if (mChicken3Count == 0) {
                        fadeOutImage(mChicken3);
                        red.start();
                        mChicken3.setVisibility(View.INVISIBLE);
                        mChicken4.setVisibility(View.VISIBLE);
                    } else if (mChicken3Count >= 1) {
                        rotateImage(mChicken3);
                        mChicken3.setVisibility(View.INVISIBLE);
                        red.start();
                    }
                    mChicken3Count += 1;
                } else if (mViewId == mChicken4Id) {
                    if (mChicken4Count == 0) {
                        rotateImage(mChicken4);
                        pink.start();
                        mChicken4.setVisibility(View.INVISIBLE);
                        mChicken5.setVisibility(View.VISIBLE);
                    } else if (mChicken4Count >= 1) {
                        scaleImage(mChicken4);
                        pink.start();
                        mChicken4.setVisibility(View.INVISIBLE);
                    }
                    mChicken4Count += 1;
                } else if (mViewId == mChicken5Id) {
                    if (mChicken5Count == 0) {
                        scaleImage(mChicken5);
                        brown.start();
                        mChicken5.setVisibility(View.INVISIBLE);
                        mChicken6.setVisibility(View.VISIBLE);
                    } else if (mChicken5Count >= 1) {
                        fadeOutImage(mChicken5);
                        brown.start();
                        mChicken5.setVisibility(View.INVISIBLE);
                    }
                    mChicken5Count += 1;
                } else if (mViewId == mChicken6Id) {
                    if (mChicken6Count == 0) {
                        fadeOutImage(mChicken6);
                        blue.start();
                        mChicken1.setVisibility(View.VISIBLE);
                        mChicken2.setVisibility(View.VISIBLE);
                        mChicken3.setVisibility(View.VISIBLE);
                        mChicken4.setVisibility(View.VISIBLE);
                        mChicken5.setVisibility(View.VISIBLE);
                    } else if (mChicken6Count >= 1) {
                        rotateImage(mChicken6);
                        blue.start();
                        mChicken6.setVisibility(View.INVISIBLE);
                    }
                    mChicken6Count += 1;
                }
                return super.onDoubleTap(e);
            }
        });
    }

    private void initResources() {
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.level2sd480);
        mVideoView.setVideoURI(uri);

        mChicken1Id = mChicken1.getId();
        mChicken2Id = mChicken2.getId();
        mChicken3Id = mChicken3.getId();
        mChicken4Id = mChicken4.getId();
        mChicken5Id = mChicken5.getId();
        mChicken6Id = mChicken6.getId();
        mVideoId = mVideoView.getId();

        blue = MediaPlayer.create(this, R.raw.blue);
        brown = MediaPlayer.create(this, R.raw.brown);
        pink = MediaPlayer.create(this, R.raw.pink);
        red = MediaPlayer.create(this, R.raw.red);
        white = MediaPlayer.create(this, R.raw.white);
        yellow = MediaPlayer.create(this, R.raw.yellow);

        mChicken1Count = 0;
        mChicken2Count = 0;
        mChicken3Count = 0;
        mChicken4Count = 0;
        mChicken5Count = 0;
        mChicken6Count = 0;
    }
}
