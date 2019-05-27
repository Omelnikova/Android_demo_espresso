package com.mytaxi.android_demo.e2e.pages;

import android.support.test.espresso.ViewInteraction;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class LoginActivityPage {

    static ViewInteraction navigationTab = onView(withContentDescription("Open navigation drawer"));
    static ViewInteraction logoutButton = onView(withText("Logout"));
    static ViewInteraction loginButton = onView(withId(R.id.btn_login));


    public static void login(String login, String password) {
        onView(withId(R.id.edt_username)).perform(typeText(login));
        onView(withId(R.id.edt_password)).perform(typeText(password));
        onView(withId(R.id.btn_login)).perform(click());
    }

    public static void checkDriverNameIsCorrect(String driverName) {
        navigationTab.perform(click());
        onView(withId(R.id.nav_username)).check(matches(withText(driverName)));
    }

    public static void logout() {
        navigationTab.perform(click());
        logoutButton.perform(click());
    }

    public static void checkLogoinButtonDisplayed() {
        loginButton.check(matches(isDisplayed()));

    }


}
