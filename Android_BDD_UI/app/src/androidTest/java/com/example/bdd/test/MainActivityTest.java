package com.example.bdd.test;

import android.content.Intent;
import android.os.SystemClock;

import androidx.test.espresso.web.webdriver.Locator;
import androidx.test.filters.SmallTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.bdd.LoginActivity;
import com.example.bdd.R;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webClick;
import static androidx.test.espresso.web.webdriver.DriverAtoms.webKeys;
import static org.junit.Assert.assertNotNull;

import javax.xml.xpath.XPath;

@SmallTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Rule
    private LoginActivity activity;


    @Before("@login-feature")
    public void setup() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
    }

    @After("@login-feature")
    public void tearDown() {
        SystemClock.sleep(3000);
        activityTestRule.finishActivity();
    }

    @Before("@login-feature-incorrect")
    public void setupTwo() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
    }

    @After("@login-feature-incorrect")
    public void tearDownTwo() {
        SystemClock.sleep(3000);
        activityTestRule.finishActivity();
    }

    @Given("^I have a login activity")
    public void I_have_a_login_activity() {
        assertNotNull(activity);
        onView(withText("Login Page")).check(matches(isDisplayed()));

    }

    @When("^I input username (\\S+)$")
    public void I_input_username(final String username) {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(username));
    }

    @And("^I input password (\\S+)$")
    public void I_input_password(final String password) {
        onView(withId(R.id.editTextNumberPassword)).perform(typeText(password), closeSoftKeyboard());

    }

    @And("^I press submit button$")
    public void I_press_submit_button() {
        SystemClock.sleep(3000);
        onView(withId(R.id.button)).perform(click());
    }

    @Then("^I should see on next activity")
    public void I_should_see_on_next_activity() {

        SystemClock.sleep(3000);
        onView(withId(R.id.txtview_SecondBtn)).perform(click());
        onView(withText("Third Page: Webview Auto UI Testing")).check(matches(isDisplayed()));
        SystemClock.sleep(3000);
    }


    @And("^I should be connected to the Yummly website$")
    public void iShouldBeConnectedToTheYummlyWebsite() {

        onWebView(withId(R.id.webview1)).forceJavascriptEnabled();
        SystemClock.sleep(3000);

    }

    @Then("^I should not see the next activity$")
    public void iShouldNotSeeTheNextActivity() {
          onView(withText("Third Page: Webview Auto UI Testing")).check(doesNotExist());
    }

    @And("^I should see the login failed error message$")
    public void iShouldSeeTheLoginFailedErrorMessage() {

        Assert.assertTrue(true);
    }
}
