package miftalm.intro.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import miftalm.intro.domain.PostRepository
import miftalm.intro.ui.state.PostsState
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostRepository
): ViewModel() {

    private val _state = MutableStateFlow< PostsState>(PostsState.Loading)
    val state: StateFlow<PostsState> = _state

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            try {
                val posts = repository.getPosts()
                _state.value = PostsState.Success(posts)
            } catch (e: Exception) {
                _state.value = PostsState.Error(e.message ?: "Unkown error")
            }
        }
    }
}