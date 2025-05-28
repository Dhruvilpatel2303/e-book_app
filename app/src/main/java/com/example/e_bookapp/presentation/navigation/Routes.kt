package com.example.e_bookapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes{

    @Serializable
    object HomeScreen

    @Serializable
    object BookByCategory

    @Serializable
    object AllBooks

    @Serializable
    object BookDetails

}