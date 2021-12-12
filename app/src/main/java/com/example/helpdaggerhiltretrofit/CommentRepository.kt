package com.example.helpdaggerhiltretrofit

import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityScoped
class CommentRepository @Inject constructor(private val commentApi: CommentApi) {

    //trying try catch
    suspend fun getcommentss(): Resource<List<Comment>> {
        val response =
            try {
                commentApi.getComment()
            } catch (e: Exception) {
                return Resource.Error(e.message.toString())
            }
        return Resource.Success(response)
    }

}