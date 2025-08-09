package miftalm.intro.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import miftalm.intro.data.PostRepositoryImpl
import miftalm.intro.domain.PostRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class PostsModule {

    @Binds
    abstract fun bindPostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository

}