package com.mehequanna.gestureplayground.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mehequanna.gestureplayground.R;
import com.mehequanna.gestureplayground.util.DetectGestures;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelFourActivity extends AppCompatActivity implements View.OnTouchListener {
    @Bind(R.id.TractorGreen) ImageView mTractorGreen;

    GestureDetector mTractorDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four);
        ButterKnife.bind(this);

        mTractorDetector = new GestureDetector(this, new DetectGestures(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Toast.makeText(LevelFourActivity.this, "You!", Toast.LENGTH_SHORT).show();
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });

        mTractorGreen.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == mTractorGreen) {
            mTractorDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
}
