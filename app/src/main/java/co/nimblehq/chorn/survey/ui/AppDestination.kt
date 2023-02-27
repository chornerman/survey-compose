package co.nimblehq.chorn.survey.ui

import androidx.navigation.*

sealed class AppDestination(val route: String = "") {

    open val arguments: List<NamedNavArgument> = emptyList()

    open var destination: String = route

    object Up : AppDestination()

    object Login : AppDestination("login")

    object Home : AppDestination("home")
}
