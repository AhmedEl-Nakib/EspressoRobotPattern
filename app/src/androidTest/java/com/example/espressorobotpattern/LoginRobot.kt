package com.example.espressorobotpattern

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.espressorobotpattern.login.LoginRequestModel
import com.example.espressorobotpattern.login.LoginResponseModel
import com.example.espressorobotpattern.magixResponse.MagixResponse
import com.example.espressorobotpattern.networking.ApiClient
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginRobot {

    fun addEmailAddress(email:String) : ViewInteraction? = Espresso.onView(withId(R.id.emailId))
        .perform(ViewActions.typeText(email), ViewActions.closeSoftKeyboard())


    fun addPassword(password:String): ViewInteraction? = Espresso.onView(withId(R.id.passwordId))
            .perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())

    fun clickOnLoginBtn(dialogTitle:String , email: String , password: String){
        Espresso.onView(withId(R.id.loginBtnId)).perform(click())
        Espresso.onView(withText(dialogTitle)).check(matches(isDisplayed()))
        clickOnDialogAndCallAPI(email,password)
    }

    private fun clickOnDialogAndCallAPI(email: String, password: String) {
        Espresso.onView(withId(android.R.id.button1)).perform(click())
        Espresso.onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
        try{
            CoroutineScope(Dispatchers.IO).async {
                val response =  ApiClient.makeRetrofitService().login(LoginRequestModel(email,password)).execute()
                withContext(Dispatchers.Main){
                    val loginResponse = response.body()
                    assertTrue(response.isSuccessful && loginResponse!!.code!! == 200)
                }
            }
        }catch (e:Exception){
            Log.i("ErrorTest",e.message.toString())
        }
    }
}