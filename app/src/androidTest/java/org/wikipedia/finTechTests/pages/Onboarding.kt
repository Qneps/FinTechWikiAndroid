package org.wikipedia.finTechTests.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import io.qameta.allure.kotlin.Step
import org.hamcrest.Matchers
import org.wikipedia.R
import org.wikipedia.TestUtil

class Onboarding {
    companion object{
        inline operator fun invoke(block: Onboarding.() -> Unit) = Onboarding().block()
    }
    @Step("Пропускаем онбординг")
    fun skipOnboarding(){
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.fragment_onboarding_skip_button), ViewMatchers.isDisplayed()))
                .perform(ViewActions.click())
        TestUtil.delay(1)
    }
}