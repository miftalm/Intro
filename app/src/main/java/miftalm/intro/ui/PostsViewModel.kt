package miftalm.intro.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import miftalm.intro.data.PostApi
import miftalm.intro.data.PostRepositoryImpl
import miftalm.intro.ui.state.PostsState
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsViewModel: ViewModel() {
    private val repository = PostRepositoryImpl(
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    )

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