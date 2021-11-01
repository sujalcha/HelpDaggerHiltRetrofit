package com.example.helpdaggerhiltretrofit

import retrofit2.Response
import retrofit2.http.GET

interface CommentApi {

    @GET("/comments")
    suspend fun getComment() : List<Comment>
}