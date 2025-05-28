package com.example.e_bookapp.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.e_bookapp.viewmodel.MainViewModel

@Composable
fun AllBooksScreenUI(viewModel: MainViewModel = hiltViewModel(),navController: NavController) {

    val state=viewModel.getallbooksstate.value

    LaunchedEffect(Unit) {
        viewModel.getAllBooks()
    }


    when{

        state.isLoading->{
            CircularProgressIndicator()
        }

        state.error !=""->{
            Text(text = state.error)
            Log.d("TAG", "AllBooksScreenUI: ${state.error}")
            Text("error")



        }
        state.data!=null->{
            Log.d("TAG", "AllBooksScreenUI success : ${state.data}")
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(60.dp)
            ) {

                items(state.data) {

                    Text(it.BookName, fontSize = 50.sp)
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
    
}