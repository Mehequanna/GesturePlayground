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
    @Bind(R.id.parentsButton)
    Button mParentsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLevelOneImageButton.setOnClickListener(this);
        mParentsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mLevelOneImageButton) {
            Intent intent = new Intent(MainActivity.this, LevelOneActivity.class);
            startActivity(intent);
        }
        if (view == mParentsButton) {
            Intent intent = new Intent(MainActivity.this, ParentsActivity.class);
            startActivity(intent);
        }
    }
}