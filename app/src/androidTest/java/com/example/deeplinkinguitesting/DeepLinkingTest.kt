package com.example.deeplinkinguitesting

import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.content.Intent
import android.net.Uri

@RunWith(AndroidJUnit4::class)
class DeepLinkingTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun should_launch_secondActivity_when_deepLinkingToActivityTwo() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("myapp://example.com?screen=activitytwo"))
        activityTestRule.launchActivity(intent)
        intended(hasComponent(SecondActivity::class.java!!.getName()))
    }

}