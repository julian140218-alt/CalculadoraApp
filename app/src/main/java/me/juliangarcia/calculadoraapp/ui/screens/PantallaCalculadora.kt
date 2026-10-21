package me.juliangarcia.calculadoraapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.juliangarcia.calculadoraapp.CalculadoraViewModel

@Composable
fun PantallaCalculadora(
    viewModel: CalculadoraViewModel,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .padding(24.dp)
    ) {
        Text(
            text = "Calculadora",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.numeroA,
            onValueChange = { viewModel.cambiarA(it) },
            label = { Text("Primer número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.numeroB,
            onValueChange = { viewModel.cambiarB(it) },
            label = { Text("Segundo número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("+", "-", "×", "÷").forEach { operador ->
                Button(
                    onClick = { viewModel.calcular(operador) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(operador)
                }
            }
        }
        Spacer(Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text(
                text = viewModel.resultado,
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            )
        }
        Spacer(Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { viewModel.limpiar() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Limpiar")
            }
            Button(
                onClick = onVolver,
                modifier = Modifier.weight(1f)
            ) {
                Text("Volver al inicio")
            }
        }
    }
}