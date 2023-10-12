package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun make_solution(a:Int, b:Int, c:Int):String {
    val root1: Double
    val root2: Double
    val output: String

    val determinant = b * b - 4.0 * a * c

    // condition for real and different roots
    if (determinant > 0.0) {
        root1 = (-b + Math.sqrt(determinant)) / (2 * a)
        root2 = (-b - Math.sqrt(determinant)) / (2 * a)

        output = "root1 = %.2f and root2 = %.2f".format(root1, root2)
    }
    else if (determinant == 0.0) {
        root2 = -b / (2.0 * a)
        root1 = root2

        output = "root1 = root2 = %.2f;".format(root1)
    }
    // If roots are not real
    else {
        output = "Нет действительных корней"
    }
    return output


}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val aEditText = findViewById<EditText>(R.id.editTextA)
        val bEditText = findViewById<EditText>(R.id.editTextB)
        val cEditText = findViewById<EditText>(R.id.editTextC)
        val textViewRes = findViewById<TextView>(R.id.textViewRes)


        val nextButton = findViewById<Button>(R.id.buttonSolution)
        nextButton.setOnClickListener {
            textViewRes.setText("")
            val a = aEditText.text.toString().toInt()
            val b = bEditText.text.toString().toInt()
            val c = cEditText.text.toString().toInt()
            val res = make_solution(a, b, c)
            textViewRes.append(res)
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        Greeting("Android")
    }
}