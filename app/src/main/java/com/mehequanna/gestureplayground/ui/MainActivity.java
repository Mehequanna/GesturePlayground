package com.mehequanna.gestureplayground.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    @Bind(R.id.levelOneImageButton) ImageButton mLevelOneImageButton;
    @Bind(R.id.levelTwoImageButton) ImageButton mLevelTwoImageButton;
    @Bind(R.id.levelThreeImageButton) ImageButton mLevelThreeImageButton;
    @Bind(R.id.levelFourImageButton) ImageButton mLevelFourImageButton;
    @Bind(R.id.levelFiveImageButton) ImageButton mLevelFiveImageButton;
    @Bind(R.id.parentsButton) Button mParentsButton;
    @Bind(R.id.mainVideoView) VideoView mMainVideoView;

    private GestureDetector mVideoGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.maintap);
        mMainVideoView.setVideoURI(uri);
        mMainVideoView.start();

        mVideoGestureDetector = new GestureDetector(this, new DetectGestures() {
            @Override
            public boolean onDown(MotionEvent e) {
                mMainVideoView.stopPlayback();
                mMainVideoView.setVisibility(View.GONE);
                return true;
            }
        });

        mLevelOneImageButton.setOnClickListener(this);
        mLevelTwoImageButton.setOnClickListener(this);
        mLevelThreeImageButton.setOnClickListener(this);
        mLevelFourImageButton.setOnClickListener(this);
        mLevelFiveImageButton.setOnClickListener(this);
        mParentsButton.setOnClickListener(this);
        mMainVideoView.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        //TODO: Connect onClick View to activity after they are created.
        if (view == mLevelOneImageButton) {
            Toast.makeText(this, "Level One Tapped", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, LevelOneActivity.class);
//            startActivity(intent);
        }
        if (view == mLevelTwoImageButton) {
            Intent intent = new Intent(MainActivity.this, LevelTwoActivity.class);
            startActivity(intent);
        }
        if (view == mLevelThreeImageButton) {
            Toast.makeText(this, "Level Three Tapped", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, LevelThreeActivity.class);
//            startActivity(intent);
        }
        if (view == mLevelFourImageButton) {
            Toast.makeText(this, "Level Four Tapped", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, LevelFourActivity.class);
//            startActivity(intent);
        }
        if (view == mLevelFiveImageButton) {
            Toast.makeText(this, "Level Five Tapped", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, LevelFiveActivity.class);
//            startActivity(intent);
        }
        if (view == mParentsButton) {
            Intent intent = new Intent(MainActivity.this, ParentsActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == mMainVideoView) {
            mVideoGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
}
