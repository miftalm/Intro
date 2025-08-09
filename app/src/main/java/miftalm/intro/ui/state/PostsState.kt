package miftalm.intro.ui.state

import miftalm.intro.domain.Post

sealed class PostsState {
    object Loading : PostsState()
    data class Success(val posts: List<Post>) : PostsState()
    data class Error(val message: String) : PostsState()
}