package org.wikipedia.finTechTests

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.qameta.allure.kotlin.junit4.DisplayName
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.wikipedia.TestUtil
import org.wikipedia.finTechTests.pages.MainPage
import org.wikipedia.finTechTests.pages.Onboarding
import org.wikipedia.main.MainActivity
import org.wikipedia.R

class CheckingTheDefaultFeedSettingsTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    @DisplayName("Первый тест")
    fun checkingTheDefaultFeedSettingsTest() {
        Onboarding{
            skipOnboarding()
        }
        MainPage{
            pressButtonMoreAndWaitWindow()
            pressButtonSettingsAndWait()
        }

        TestUtil.delay(5)

        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.explore_feed),
                ViewMatchers.isDisplayed()
            )
        )
            .perform(ViewActions.click())
//        SettingsActivity
    }
}