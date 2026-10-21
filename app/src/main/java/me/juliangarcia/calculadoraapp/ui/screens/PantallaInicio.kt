package me.juliangarcia.calculadoraapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.juliangarcia.calculadoraapp.CalculadoraViewModel

@Composable
fun PantallaInicio(
    viewModel: CalculadoraViewModel,
    onIrACalculadora: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculadora con ViewModel",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = "El ViewModel guarda los datos fuera de la pantalla, " +
                    "así no se pierden al girar el celular ni al cambiar de pantalla.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Última operación",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = viewModel.ultimaOperacion,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }

        Button(
            onClick = onIrACalculadora,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a la calculadora")
        }
    }
}