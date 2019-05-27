package com.mytaxi.android_demo.e2e;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.e2e.pages.LoginActivityPage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    LoginActivityPage loginPage = new LoginActivityPage();

    private final String successfulLogin = "crazydog335";
    private final String successfulPassword = "venture";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void loginTest() {
        LoginActivityPage.login(successfulLogin, successfulPassword);
        LoginActivityPage.checkDriverNameIsCorrect(successfulLogin);
    }

    @Test
    public void logoutTest() {
        LoginActivityPage.logout();
        LoginActivityPage.checkLogoinButtonDisplayed();
    }
}
