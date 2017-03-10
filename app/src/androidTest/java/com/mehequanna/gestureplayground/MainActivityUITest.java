package com.mehequanna.gestureplayground;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mehequanna.gestureplayground.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonLaunchesParentsActivity() throws Exception {
        // Arrange
        String otherActivityString = "Other Activity";

        // Act
        onView(withId(R.id.parentsButton)).perform(click());

        // Assert
        onView(withText(otherActivityString)).check(matches(notNullValue()));
    }
}
