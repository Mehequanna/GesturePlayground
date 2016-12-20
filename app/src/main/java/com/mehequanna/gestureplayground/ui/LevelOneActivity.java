package com.mehequanna.gestureplayground.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.mehequanna.gestureplayground.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        ButterKnife.bind(this);

        mChicken1.setVisibility(View.INVISIBLE);
        mChicken2.setVisibility(View.INVISIBLE);
        mChicken3.setVisibility(View.INVISIBLE);
        mChicken4.setVisibility(View.INVISIBLE);
        mChicken5.setVisibility(View.INVISIBLE);


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
