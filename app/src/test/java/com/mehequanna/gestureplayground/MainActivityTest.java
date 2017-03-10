package com.mehequanna.gestureplayground;

import android.content.Intent;
import android.os.Build;

import com.mehequanna.gestureplayground.ui.MainActivity;
import com.mehequanna.gestureplayground.ui.ParentsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void buttonLauchesParentsActivity() throws Exception {
        // Arrange
        Class clazz = ParentsActivity.class;
        Intent expectedIntent = new Intent(activity, clazz);

        // Act
        activity.mParentsButton.callOnClick();

        // Assert
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }

}
