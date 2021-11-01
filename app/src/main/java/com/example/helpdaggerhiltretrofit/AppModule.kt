package com.example.helpdaggerhiltretrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


const val BASE_URL = "https://jsonplaceholder.typicode.com"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getCommentsApi():CommentApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CommentApi::class.java)
    }

    @Singleton
    @Provides
    fun getCommentRepository(commentapi: CommentApi) = CommentRepository(commentapi)

}