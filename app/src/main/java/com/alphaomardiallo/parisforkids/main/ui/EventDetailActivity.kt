package com.alphaomardiallo.parisforkids.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.parisforkids.common.ui.theme.ParisForKidsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ParisForKidsTheme() {


            }

        }


    }

    @Composable
    fun WelcomeText() {
        Text(text = "Hello bitches", modifier = Modifier.padding(24.dp).background(MaterialTheme.colorScheme.background))
    }

    @Preview
    @Composable
    fun Preview() {
        ParisForKidsTheme() {
            WelcomeText()
        }
    }
}
