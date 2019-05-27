package com.mytaxi.android_demo.e2e;


import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.e2e.pages.DriverActivityPage;
import com.mytaxi.android_demo.e2e.pages.LoginActivityPage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SearchActivityTest {

    DriverActivityPage driverPage = new DriverActivityPage();
    LoginActivityPage loginPage = new LoginActivityPage();

    private final String successfulLogin = "crazydog335";
    private final String successfulPassword = "venture";
    private final String textForSearch = "sa";
    private final String textForClick = "Sarah Scott";

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule
            = new IntentsTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void searchAndCallTest() {
        LoginActivityPage.login(successfulLogin, successfulPassword);
        DriverActivityPage.searchText(textForSearch);
        DriverActivityPage.clickOnTextResult(textForClick);
        DriverActivityPage.callToDriver();
        intended(hasAction(Intent.ACTION_DIAL));
    }
}
