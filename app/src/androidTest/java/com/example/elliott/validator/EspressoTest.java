package com.example.elliott.validator;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Elliott on 2018-02-07.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTest
{
    @Rule
    public ActivityTestRule<Validator> mActivityRule = new ActivityTestRule<>(Validator.class);

    @Test
    public void checkPassword()
    {
        Espresso.onView(withId(R.id.enterPass)).perform(typeText("password"));
        Espresso.onView(withId(R.id.validatePass)).perform(click());
        Espresso.onView(withId(R.id.resultValidate)).check(matches(withText(R.string.validate_failure)));
    }
    @Test
    public void checkPasswordCaseInsensitive()
    {
        Espresso.onView(withId(R.id.enterPass)).perform(typeText("PasSwoRd"));
        Espresso.onView(withId(R.id.validatePass)).perform(click());
        Espresso.onView(withId(R.id.resultValidate)).check(matches(withText(R.string.validate_failure)));
    }
    @Test
    public void checkLength()
    {
        Espresso.onView(withId(R.id.enterPass)).perform(typeText("ABC123!"));
        Espresso.onView(withId(R.id.validatePass)).perform(click());
        Espresso.onView(withId(R.id.resultValidate)).check(matches(withText(R.string.validate_failure)));
    }
    @Test
    public void checkSpecialChar()
    {
        Espresso.onView(withId(R.id.enterPass)).perform(typeText("ABCD1234"));
        Espresso.onView(withId(R.id.validatePass)).perform(click());
        Espresso.onView(withId(R.id.resultValidate)).check(matches(withText(R.string.validate_failure)));
    }
    @Test
    public void checkDigit()
    {
        Espresso.onView(withId(R.id.enterPass)).perform(typeText("ABCDEFGH!"));
        Espresso.onView(withId(R.id.validatePass)).perform(click());
        Espresso.onView(withId(R.id.resultValidate)).check(matches(withText(R.string.validate_failure)));
    }
    @Test
    public void checkCaps()
    {
        Espresso.onView(withId(R.id.enterPass)).perform(typeText("abcd1234!"));
        Espresso.onView(withId(R.id.validatePass)).perform(click());
        Espresso.onView(withId(R.id.resultValidate)).check(matches(withText(R.string.validate_failure)));
    }
    @Test
    public void validPassword()
    {
        Espresso.onView(withId(R.id.enterPass)).perform(typeText("ABCD1234!"));
        Espresso.onView(withId(R.id.validatePass)).perform(click());
        Espresso.onView(withId(R.id.resultValidate)).check(matches(withText(R.string.validate_success)));
    }
}
