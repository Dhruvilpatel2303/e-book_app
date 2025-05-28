package com.example.e_bookapp.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_bookapp.common.ResultState
import com.example.e_bookapp.data.BookModels
import com.example.e_bookapp.repo.repo
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(val repo: repo): ViewModel() {


        private val _getallbooksstate:MutableState<GetAllBooksState> = mutableStateOf(GetAllBooksState())
        val getallbooksstate: MutableState<GetAllBooksState> = _getallbooksstate


    fun getAllBooks(){
        viewModelScope.launch(Dispatchers.IO) {

            repo.getAllBooks().collect {
                when(it){

                    is ResultState.Success -> {
                        Log.d("TAG", "getAllBooks: ${it.data}")
                        _getallbooksstate.value = GetAllBooksState(data = it.data, isLoading = false)
                    }

                    is ResultState.Eroor -> {
                        _getallbooksstate.value = GetAllBooksState(error = it.exception, isLoading = false)

                    }

                    is ResultState.Loading -> {
                        _getallbooksstate.value = GetAllBooksState(isLoading = true)

                    }
                }

            }
        }
    }
}


data class GetAllBooksState(
    val isLoading: Boolean=false,
    val data: List<BookModels> = emptyList(),
    val error: String=""

)