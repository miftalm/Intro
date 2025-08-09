package miftalm.intro.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import miftalm.intro.ui.state.PostsState

@Composable
fun PostsScreen(viewModel: PostsViewModel) {
    val state by viewModel.state.collectAsState()

    when(val currentState = state) {
        is PostsState.Loading -> {
            Text("loading")
        }
        is PostsState.Success -> {
           LazyColumn {
                items(currentState.posts) {
                    Text(it.id.toString())
                }
            }
        }
        is PostsState.Error -> {
            Text(text = "Error: ${currentState.message}")
        }

    }
}