package com.alphaomardiallo.parisforkids.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.alphaomardiallo.parisforkids.ui.activity.ui.theme.ParisForKidsTheme

class ListActivities : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ParisForKidsTheme {
                    Greeting3(name = "Screen one")
                }
            }
        }
    }

    @Composable
    fun Greeting3(name: String) {
        Text(text = "Hello $name!")
    }

}