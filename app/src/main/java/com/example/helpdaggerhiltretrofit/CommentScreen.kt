package com.example.helpdaggerhiltretrofit

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CommentScreen(
    navController: NavController,
    commentScreenViewModel: CommentScreenViewModel = hiltViewModel()
) {

    val commentslist by remember { commentScreenViewModel.commentList }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.LightGray)) {
        LazyColumn()
        {
          //  Log.d("comment","${commentslist.size}")

            item(commentslist.size) {
                for(comment in commentslist){
             //       Log.d("comment","${comment.toString()}")
                    Card(modifier = Modifier.padding(20.dp)) {
                        CommentDecor(comment)
                    }

                }
            }

        }
    }
}

@Composable
fun CommentDecor(comment: Comment) {
    Column(modifier = Modifier.padding(20.dp).background(color = Color.White)) {
        Text(text = "Comment id: "+comment.id.toString())
        Text(text = "Comment postid: "+comment.postId.toString())
        Text(text = "Comment email: "+comment.email.toString())
        Text(text = "Comment name: "+comment.name.toString())
        Text(text = "Comment body: "+comment.body.toString())
    }

}



