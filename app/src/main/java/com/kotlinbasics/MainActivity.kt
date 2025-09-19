package com.kotlinbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        week02Variables()
        //week02Functions()
        week03Classes()
    }
}

private fun week02Functions(){
    println("== Kotlin Classes ==")

    class Student {
        var name: String = ""
        var age: Int = 0

        fun introduce(){
            println("Hi, I'm$name and I'm $age years old.")
        }
    }

    val student = student()
    student.name = "Mirae"
    student.age = 21
    student.introduce()
}
private fun week02Functions(){
//    println("Week02: Functions")
//
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android developer"))

    println("== Kotlin Functions ==")
    fun greet(name: String): String{
        return "Hello, $name!"
    }

    fun add(a: Int, b: Int)= a+b
    fun introduce(name: String, age: Int=19){
        println("My name is $name and I'm $age years old")
    }

    println(greet("Kotline"))
    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")

    introduce("Kim",7)
    introduce("Park")
}

private fun week02Variables(){
//    println("Week 02: Variables")
//    val courseName="Mobile Programming"
//    //에러 courseName="IoT Programming"
//    var week=1
//    week=2
//
//    println("Course: $courseName")
//    println("Week: $week")

    //prinln("Kotlin Variables ==")
    //val(immutable) var(mutable)
    val name = "Android" //못바꿈
    var version = 8      //바꿈
    println("Hello $name $version")

    val age: Int = 24
    val height: Double = 155.5
    val isStudent: Boolean = true

    println("Age: $age, Height: $height, Student: $isStudent")

    //var nickname: String = null
    var nickname: String? = null
    nickname="mirae"
    println("Nickname: $nickname ${nickname?.length}")
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
    KotlinBasicsTheme {
        Greeting("Android")
    }
}