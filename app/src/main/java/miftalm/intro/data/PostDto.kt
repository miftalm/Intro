package miftalm.intro.data

import com.google.gson.annotations.SerializedName
import miftalm.intro.domain.Post

data class PostDto(
    @SerializedName("id")
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
)

fun PostDto.toDomain(): Post {
    return Post(
        id = this.id,
        userId = this.userId,
        title = this.title,
        body = this.body
    )
}
