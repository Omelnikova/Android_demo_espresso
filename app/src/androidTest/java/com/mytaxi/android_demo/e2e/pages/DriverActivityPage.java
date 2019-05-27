package com.mytaxi.android_demo.e2e.pages;

import android.support.test.espresso.matcher.RootMatchers;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DriverActivityPage {

    public static void searchText(String text) {
        onView(withId(R.id.textSearch)).perform(typeText(text));
    }

    public static void clickOnTextResult(String textForClick) {
        onView(withText(textForClick))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public static void callToDriver() {
        onView(withId(R.id.fab)).perform(click());
    }
}
