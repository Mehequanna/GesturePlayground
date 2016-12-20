package com.mehequanna.gestureplayground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelOneActivity extends AppCompatActivity {
    @Bind(R.id.chicken0) ImageView mChicken0;
    @Bind(R.id.chicken1) ImageView mChicken1;
    @Bind(R.id.chicken2) ImageView mChicken2;
    @Bind(R.id.chicken3) ImageView mChicken3;
    @Bind(R.id.chicken4) ImageView mChicken4;
    @Bind(R.id.chicken5) ImageView mChicken5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        ButterKnife.bind(this);


    }
}
