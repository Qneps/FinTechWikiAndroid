package org.wikipedia.finTechTests

import org.wikipedia.finTechTests.pages.Onboarding
import org.wikipedia.finTechTests.pages.MainPage
import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.qameta.allure.kotlin.junit4.DisplayName
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class DonateTests {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @DisplayName("Проверка перехода в браузер")
    fun transitionBrowserTest() {
        Onboarding{
            skipOnboarding()
        }
        MainPage{
            pressButtonMoreAndWaitWindow()
            pressButtonDonateAndWaitWindow()
        }
    }
}