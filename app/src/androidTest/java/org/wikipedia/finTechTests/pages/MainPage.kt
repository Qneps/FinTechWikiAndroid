package org.wikipedia.finTechTests.pages

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import io.qameta.allure.kotlin.Allure
import io.qameta.allure.kotlin.Step
import org.hamcrest.Matchers
import org.wikipedia.R
import org.wikipedia.TestUtil

class MainPage{
    companion object{
        inline operator fun invoke(block: MainPage.() -> Unit) = MainPage().block()
    }
    @Step("Нажимаем на кнопку \"Еще\"")
    fun pressButtonMoreAndWaitWindow(){
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.nav_more_container), ViewMatchers.isDisplayed()))
                .perform(ViewActions.click())
    }
    @Step("Нажимаем кнопку \"Пожертвовать\"")
    fun pressButtonDonateAndWaitWindow(){
        Intents.init()
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.main_drawer_donate_container), ViewMatchers.isDisplayed()))
                .perform(ViewActions.click())
        Allure.step("Проверяем, что случился переход на окно выбора браузера для открытия") {
            Intents.intended(IntentMatchers.hasAction(Intent.ACTION_CHOOSER))
        }
    }
    @Step("Нажимаем кнопку \"Настройки\"")
    fun pressButtonSettingsAndWait(){
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.main_drawer_settings_container),
                ViewMatchers.isDisplayed()
            )
        )
            .perform(ViewActions.click())

        TestUtil.delay(5)
    }
}