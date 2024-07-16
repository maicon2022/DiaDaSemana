package com.example.diadasemana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diadasemana.ui.theme.DiaDaSemanaTheme
import com.example.diadasemana.model.Calendario
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiaDaSemanaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val calendario = Calendario()
    var inputText by remember { mutableStateOf("") }
    var diaDaSemana by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Digite um número de 1 a 7") },
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            Button(onClick = {
                val numero = inputText.toIntOrNull()
                if (numero != null) {
                    diaDaSemana = "Dia: ${calendario.diaDaSemana(numero)}"
                } else {
                    diaDaSemana = "Dia inválido"
                }
            }) {
                Text("Clique aqui")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                inputText = ""
                diaDaSemana = ""
            }) {
                Text("Apagar")
            }
        }

        Text(
            text = diaDaSemana,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

    }
}

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        DiaDaSemanaTheme {
            Greeting("Android")
        }
    }
