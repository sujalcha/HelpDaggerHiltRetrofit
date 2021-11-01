package com.example.helpdaggerhiltretrofit

import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityScoped
class CommentRepository @Inject constructor(private val commentApi: CommentApi){

    suspend fun getcommentss(): Response<List<Comment>> {
        val response = commentApi.getComment()
        return response
    }

}