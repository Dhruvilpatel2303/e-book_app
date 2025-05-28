package com.example.e_bookapp.presentation.navigation

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_bookapp.presentation.screens.AllBooksScreenUI
import com.example.e_bookapp.presentation.screens.BookByCategoryScreenUI
import com.example.e_bookapp.presentation.screens.BookDetailsScreenUI
import com.example.e_bookapp.presentation.screens.HomeScreenUI
import com.example.e_bookapp.presentation.screens.TabScreenUI
import com.example.e_bookapp.viewmodel.MainViewModel

@Composable
fun AppNavigation(viewModel: MainViewModel = hiltViewModel()) {


    val navController= rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen,

    ){

        composable<Routes.HomeScreen>{
          TabScreenUI(viewModel,navController)
        }
        composable<Routes.AllBooks> {
            AllBooksScreenUI(viewModel,navController )
        }

        composable<Routes.BookByCategory> {
            BookByCategoryScreenUI()
        }

        composable<Routes.BookDetails> {
            BookDetailsScreenUI()

        }
    }



}