package com.example.helpdaggerhiltretrofit

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentScreenViewModel @Inject constructor(private val commentRepository: CommentRepository) :ViewModel(){

    init {
        getcomments()
    }

    var commentList = mutableStateOf<List<Comment>>(listOf())

    fun getcomments(){
        viewModelScope.launch {
            var response = commentRepository.getcommentss()

            if(response.isSuccessful){
                for((i,comment) in response.body()!!.withIndex())
                {
//                    Log.d("comment $i","${comment.id}")
//                    Log.d("comment $i","${comment.body}")
//                    Log.d("comment $i","${comment.email}")
//                    Log.d("comment $i","${comment.postId}")

                    val comment = Comment(comment.body,comment.email,comment.id,comment.name,comment.postId)

                    commentList.value += comment
                }
            }



        }
    }
}