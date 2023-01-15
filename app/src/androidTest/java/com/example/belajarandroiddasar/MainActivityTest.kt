package com.example.belajarandroiddasar


import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

//    ini adalah cara manual
//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//
//    @Before
//    fun setUp() {
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
//    @Test
//    fun testBlank() {
//
//    }
//
//    @After
//    fun tearDown() {
//        mainActivityScenario.close()
//    }

    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    

    @Test
    fun testSayBaby() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        val name: String = "Mahesa"


        onView(withId(R.id.nameEditText)).perform(typeText(name))

        onView(withId(R.id.sayBabyButton)).perform(click())

        onView(withId(R.id.sayBabyTextView)).check(matches(withText(context.getString(R.string.sayBabyTextView, name))))


//        Thread.sleep(2000)
    }
}