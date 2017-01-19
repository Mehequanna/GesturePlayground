package com.mehequanna.gestureplayground.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.mehequanna.gestureplayground.R;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.mehequanna.gestureplayground.R.id.imageView;

public class LevelFourActivity extends AppCompatActivity {
    @Bind(R.id.TractorGreen) ImageView mTractorGreen;
    @Bind(imageView) ImageView mBackground;

    private ScaleGestureDetector scaleGestureDetector;
    private int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four);
        ButterKnife.bind(this);

        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        scaleGestureDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Log.d("LOGS", "onScale: " + mCounter);
            if (mCounter == 0) {
                mTractorGreen.requestLayout();
                mTractorGreen.getLayoutParams().height = 200 - (mCounter * 10);
                mCounter++;
                return false;
            } else if (mCounter == 1) {
                mTractorGreen.requestLayout();
                mTractorGreen.getLayoutParams().height = 200 - (mCounter * 10);
                mCounter ++;
                return false;
            }

            return true;
        }
    }
}
