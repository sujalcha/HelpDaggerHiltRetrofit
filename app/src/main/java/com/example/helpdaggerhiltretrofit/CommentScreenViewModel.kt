package com.example.helpdaggerhiltretrofit

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentScreenViewModel @Inject constructor(private val commentRepository: CommentRepository) :
    ViewModel() {

    init {
        getcomments()
    }

    var commentList = mutableStateOf<List<Comment>>(listOf())

    fun getcomments() {
        viewModelScope.launch {
            var result = commentRepository.getcommentss()

            when (result) {
                is Resource.Success -> {
                    result.data!!.mapIndexed { index, comment ->
                        val comment = Comment(
                            comment.body,
                            comment.email,
                            comment.id,
                            comment.name,
                            comment.postId
                        )
                        commentList.value += comment
                    }
                }
                is Resource.Error -> {
                     Log.d("Error",result.message!!)
                }
            }
        }
    }
}