package id.ac.ui.cs.mobileprogramming.nataprawiraf.lab

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("id.ac.ui.cs.mobileprogramming.nataprawiraf.lab", appContext.packageName)
    }

    @Test
    fun testHeaderString() {
        onView(withId(R.id.mainHeader))
            .check(matches(withText("Profile")))
    }

    @Test
    fun `shouldShowToastOnSave`() {
        onView(withId(R.id.saveButton)).perform(click()).check(matches(isDisplayed()))
    }

    @Test
    fun `shouldShowToastOnRevert`() {
        onView(withId(R.id.revertButton)).perform(click()).check(matches(isDisplayed()))
    }

}

