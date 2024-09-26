package com.firstapp.kotlin_bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firstapp.kotlin_bootcamp.ui.theme.KotlinBootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBootcampTheme {
                CombinedDemo()
            }
        }
    }
}

@Composable
fun CombinedDemo() { //define HelloWorld function
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(60.dp)) {
        HelloWorld()
        Spacer(modifier = Modifier.height(16.dp))
        NamedArgument()
        Spacer(modifier = Modifier.height(16.dp))
        NamedArgument1()
        Spacer(modifier = Modifier.height(16.dp))
        TripleQuoted()
    }
}

//Step 1: Hello, World

@Composable
fun HelloWorld(modifier: Modifier = Modifier) { //define HelloWorld function
    Text(
        text = "Hello ARUN!",
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    )
}

//Step 2: Named Arguments

@Composable
fun NamedArgument(modifier: Modifier = Modifier) {
    Text(
        text = greet(greeting = "Welcome", name = "Android Developer"),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    )
}

fun greet(greeting: String, name: String): String {
    return "$greeting, $name!"
}

//Step 3: Default Arguments

@Composable
fun NamedArgument1(modifier: Modifier = Modifier) {
    Text(
        text = greet1(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    )
}

fun greet1(greeting: String = "Hello", name: String = "Kotlin Developer"): String {
    return "$greeting, $name!"
}

//Step 4: Triple-Quoted Strings

@Composable
fun TripleQuoted() {
    val rawString = """
        |Hello, 
        |This is a triple-quoted string.
        |It preserves line breaks.
    """.trimMargin()

    val rawStringWithIndent = """
        Hello,
        This is a triple-quoted string
        with indentation removed.
    """.trimIndent()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = rawString)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = rawStringWithIndent)
    }
}


@Preview(showBackground = true)
@Composable
fun HelloWorldPreview() {
    KotlinBootcampTheme {
        HelloWorld()
    }
}

@Preview(showBackground = true)
@Composable
fun NamedArgumentPreview() {
    KotlinBootcampTheme {
        NamedArgument()
    }
}

@Preview(showBackground = true)
@Composable
fun NamedArgument1Preview() {
    KotlinBootcampTheme {
        NamedArgument1()
    }
}

@Preview(showBackground = true)
@Composable
fun TripleQuotedStringPreview() {
    KotlinBootcampTheme {
        TripleQuoted()
    }
}