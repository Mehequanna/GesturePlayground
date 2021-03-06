package com.mehequanna.gestureplayground.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.mehequanna.gestureplayground.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.levelOneImageButton) ImageButton mLevelOneImageButton;
    @Bind(R.id.levelTwoImageButton) ImageButton mLevelTwoImageButton;
    @Bind(R.id.levelThreeImageButton) ImageButton mLevelThreeImageButton;
    @Bind(R.id.levelFourImageButton) ImageButton mLevelFourImageButton;
    @Bind(R.id.levelFiveImageButton) ImageButton mLevelFiveImageButton;
    @Bind(R.id.parentsButton) Button mParentsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLevelOneImageButton.setOnClickListener(this);
        mLevelTwoImageButton.setOnClickListener(this);
        mLevelThreeImageButton.setOnClickListener(this);
        mLevelFourImageButton.setOnClickListener(this);
        mLevelFiveImageButton.setOnClickListener(this);
        mParentsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mLevelOneImageButton) {
            Intent intent = new Intent(MainActivity.this, LevelOneActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        if (view == mLevelTwoImageButton) {
            Intent intent = new Intent(MainActivity.this, LevelTwoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        if (view == mLevelThreeImageButton) {
            Intent intent = new Intent(MainActivity.this, LevelThreeActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        if (view == mLevelFourImageButton) {
            Intent intent = new Intent(MainActivity.this, LevelFourActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        if (view == mLevelFiveImageButton) {
            Intent intent = new Intent(MainActivity.this, LevelFiveActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
        if (view == mParentsButton) {
            Intent intent = new Intent(MainActivity.this, ParentsActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        }
    }
}
