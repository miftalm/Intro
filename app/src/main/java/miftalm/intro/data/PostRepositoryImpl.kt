package miftalm.intro.data

import miftalm.intro.domain.Post
import miftalm.intro.domain.PostRepository

class PostRepositoryImpl(
    private val postApi: PostApi
): PostRepository {
    override suspend fun getPosts(): List<Post> {
        return postApi.getPosts().map { it.toDomain() }
    }
}