package miftalm.intro.data

import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>

}