package com.cmmplayground

import MainScreen
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
            val systemUiController = rememberSystemUiController()

            systemUiController.setSystemBarsColor(color = Color.Transparent)
        }
    }
}



