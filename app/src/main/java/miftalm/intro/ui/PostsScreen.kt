package miftalm.intro.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import miftalm.intro.domain.Post
import miftalm.intro.ui.state.PostsState

@Composable
fun PostsScreen(viewModel: PostsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    when(val currentState = state) {
        is PostsState.Loading -> {
            Text("loading")
        }
        is PostsState.Success -> {
           LazyColumn(
               modifier = Modifier
                   .fillMaxSize()
                   .statusBarsPadding()
                   .navigationBarsPadding()
           ) {
                items(currentState.posts) {
                    PostItem(it)
                }
            }
        }
        is PostsState.Error -> {
            Text(text = "Error: ${currentState.message}")
        }

    }
}

@Composable
private fun PostItem(post: Post) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = post.title,
            color = Color.Red,
            fontSize = 20.sp
        )
        Text(
            text = post.body,
            fontSize = 16.sp
        )
    }
}