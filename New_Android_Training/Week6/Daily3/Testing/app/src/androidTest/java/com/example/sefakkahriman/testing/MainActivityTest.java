package com.example.sefakkahriman.testing;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void updateTextView() {
//        find the edittext and update test
        onView(withId(R.id.etMain))
                .perform(typeText("something"), closeSoftKeyboard());

//        perform the button click
        onView(withId(R.id.btnMain))
                .perform(click());

//        assert the textview for the text entered
        onView(withId(R.id.tvMain))
                .check(matches(withText("something")));
    }
}