package miftalm.intro.domain

interface PostRepository {
    suspend fun getPosts(): List<Post>
}