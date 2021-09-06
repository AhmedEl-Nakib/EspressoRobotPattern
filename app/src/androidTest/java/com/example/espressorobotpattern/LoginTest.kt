package com.example.espressorobotpattern

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModelStore
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    lateinit var robot : LoginRobot

    @Before
    fun testNavigationToInGameScreen() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        val titleScenario = launchFragmentInContainer<LoginFragment>()
        titleScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_home)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        robot = LoginRobot()
    }
    @Test
    fun addEmailAddress(){
        robot.addEmailAddress("ahmed.elnakib@gmail.com")
    }
    @Test
    fun addPassword(){
        robot.addPassword("123456")
    }
    @Test
    fun clickOnLoginBtn(){
        robot.clickOnLoginBtn("Dialog Title","yashour@ipmagix.com","12345")
    }

}