package miftalm.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import miftalm.intro.ui.PostsScreen
import miftalm.intro.ui.PostsViewModel
import miftalm.intro.ui.theme.IntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroTheme {
              PostsScreen(PostsViewModel())
            }
        }
    }
}