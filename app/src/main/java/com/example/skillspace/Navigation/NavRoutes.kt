package com.example.practice.SkillSpace

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoutes {

    @Serializable
    object HomeScreen : NavRoutes()

    @Serializable
    object Resources : NavRoutes()

    @Serializable
    object Schedule : NavRoutes()

    @Serializable
    object TrendList : NavRoutes()

    @Serializable
    object PlayPreview : NavRoutes()
}