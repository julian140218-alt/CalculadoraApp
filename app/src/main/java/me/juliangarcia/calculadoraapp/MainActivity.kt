package me.juliangarcia.calculadoraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.juliangarcia.calculadoraapp.ui.screens.PantallaCalculadora
import me.juliangarcia.calculadoraapp.ui.screens.PantallaInicio
import me.juliangarcia.calculadoraapp.ui.theme.CalculadoraAppTheme

object Rutas {
    const val INICIO = "inicio"
    const val CALCULADORA = "calculadora"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraAppTheme {
                AppNavegacion()
            }
        }
    }
}

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    val viewModel: CalculadoraViewModel = viewModel()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Rutas.INICIO,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Rutas.INICIO) {
                PantallaInicio(
                    viewModel = viewModel,
                    onIrACalculadora = { navController.navigate(Rutas.CALCULADORA) }
                )
            }
            composable(Rutas.CALCULADORA) {
                PantallaCalculadora(
                    viewModel = viewModel,
                    onVolver = { navController.popBackStack() }
                )
            }
        }
    }
}