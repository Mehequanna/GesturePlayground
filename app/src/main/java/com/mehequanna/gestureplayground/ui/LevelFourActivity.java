package com.mehequanna.gestureplayground.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelFourActivity extends AppCompatActivity implements View.OnTouchListener {
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

    GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four);
        ButterKnife.bind(this);

        mGestureDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (mPig1.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "One!", Toast.LENGTH_SHORT).show();
                    mPig1.setVisibility(View.INVISIBLE);
                    mPig2.setVisibility(View.VISIBLE);
                } else if (mPig2.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Two!", Toast.LENGTH_SHORT).show();
                    mPig2.setVisibility(View.INVISIBLE);
                    mPig3.setVisibility(View.VISIBLE);
                } else if (mPig3.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Three!", Toast.LENGTH_SHORT).show();
                    mPig3.setVisibility(View.INVISIBLE);
                    mPig4.setVisibility(View.VISIBLE);
                } else if (mPig4.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Four!", Toast.LENGTH_SHORT).show();
                    mPig4.setVisibility(View.INVISIBLE);
                    mPig5.setVisibility(View.VISIBLE);
                } else if (mPig5.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Five!", Toast.LENGTH_SHORT).show();
                    mPig5.setVisibility(View.INVISIBLE);
                    mPig6.setVisibility(View.VISIBLE);
                } else if (mPig6.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Six!", Toast.LENGTH_SHORT).show();
                    mPig6.setVisibility(View.INVISIBLE);
                    mPig7.setVisibility(View.VISIBLE);
                } else if (mPig7.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Seven!", Toast.LENGTH_SHORT).show();
                    mPig7.setVisibility(View.INVISIBLE);
                    mPig8.setVisibility(View.VISIBLE);
                } else if (mPig8.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Eight!", Toast.LENGTH_SHORT).show();
                    mPig8.setVisibility(View.INVISIBLE);
                    mPig9.setVisibility(View.VISIBLE);
                } else if (mPig9.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Nine!", Toast.LENGTH_SHORT).show();
                    mPig9.setVisibility(View.INVISIBLE);
                    mPig10.setVisibility(View.VISIBLE);
                } else if (mPig10.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Ten!", Toast.LENGTH_SHORT).show();
                    mPig10.setVisibility(View.INVISIBLE);
                    mPig11.setVisibility(View.VISIBLE);
                } else if (mPig11.isShown()) {
                    Toast.makeText(LevelFourActivity.this, "Eleven!", Toast.LENGTH_SHORT).show();
                    mPig11.setVisibility(View.INVISIBLE);
                    mWinTextView.setText(R.string.great_job);

                    Animation winScaleUpAnimation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.win_scale_fade_animation);
                    mWinTextView.startAnimation(winScaleUpAnimation);
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
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
}
