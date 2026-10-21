package me.juliangarcia.calculadoraapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculadoraViewModel : ViewModel() {

    private val textoInicial = "Aún no has hecho ninguna operación"

    var numeroA by mutableStateOf("")
        private set
    var numeroB by mutableStateOf("")
        private set
    var resultado by mutableStateOf("0")
        private set
    var ultimaOperacion by mutableStateOf(textoInicial)
        private set

    fun cambiarA(valor: String) { numeroA = valor }
    fun cambiarB(valor: String) { numeroB = valor }

    fun calcular(operador: String) {
        val a = numeroA.toDoubleOrNull()
        val b = numeroB.toDoubleOrNull()

        if (a == null || b == null) {
            resultado = "Escribe los dos números"
            return
        }
        if (operador == "÷" && b == 0.0) {
            resultado = "No se puede dividir entre 0"
            return
        }

        val res = when (operador) {
            "+" -> a + b
            "-" -> a - b
            "×" -> a * b
            else -> a / b
        }

        resultado = formatear(res)
        ultimaOperacion = "${formatear(a)} $operador ${formatear(b)} = $resultado"
    }

    fun limpiar() {
        numeroA = ""
        numeroB = ""
        resultado = "0"
        ultimaOperacion = textoInicial
    }

    private fun formatear(n: Double): String =
        if (n % 1.0 == 0.0) n.toLong().toString() else n.toString()
}