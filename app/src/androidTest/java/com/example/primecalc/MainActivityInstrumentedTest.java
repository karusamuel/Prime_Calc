package com.example.primecalc;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule=
            new ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void clickCalculate_clicksCalculateButton_(){
        onView(allOf(
                isDescendantOfA(withId(R.id.start_int)),
                withClassName(endsWith("TextInputEditText"))
        )).perform(typeText("11"));

        onView(allOf(
                isDescendantOfA(withId(R.id.end_int)),
                withClassName(endsWith("TextInputEditText"))
        )).perform(typeText("200")).
                perform(closeSoftKeyboard());

        try {// the sleep method requires to be checked and handled so we use try block
            Thread.sleep(500);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }

        onView(withId(R.id.calculate)).perform(click());
        onView(withId(R.id.start)).check(matches(withText("11")));
    }
}
