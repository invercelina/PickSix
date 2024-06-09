package com.example.picksix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.picksix.ui.theme.PickSixTheme

class ForSupabaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PickSixTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        Column(Modifier.fillMaxSize()) {
            Button(onClick = { dateFunction() }) {
                Text(text = "갱신")
            }
        }
    }
}