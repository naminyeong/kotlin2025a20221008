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
import android.util.Log

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
        //week02Variables()
        //week02Functions()
        week03Classes()
        //week03Collections()
    }
}

private fun week03Collections(){
    println("== Kotlin Collections ==")

    val fruits = listOf("apple", "banana", "orange")
    val mutableFruits = mutableListOf("kiwi", "wartermelon")

    //fruits.add(kiwi) 오류
    println("Fruits: $fruits")
    mutableFruits.add("banana")
    println("Mutable fruits: $mutableFruits")

    val scores = mapOf("Kim" to 100, "Park" to 97, "Lee" to 99)
    println("Scores: $scores")

    //범위기반 for문
    for(fruit in fruits) {
        println("I like $fruit")
    }

    scores.forEach{(name, score) -> println("$name scored $score")}
}

private fun week03Classes(){
    //Println("== Kotlin Classes ==")
    Log.d("KotlinWeek03", "== Kotlin Classes ==")

    //var 가변
    class Person(val name: String, var age: Int){
        fun introduce(){
            Log.d("KotlinWeek03", "안녕하세요, $name ($age 세)입니다.")
        }
        fun birthday(){
            age++
            Log.d("KotlinWeek03", "$name 의 생일! 이제 $age 세...")
        }
    }
    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    class Animal(var species: String){
        var weight: Double = 0.0
        constructor(species: String, weight: Double): this(species){
            this.weight = weight
            Log.d("KotlinWeek03", "$species 의 무게: $weight kg")
        }
        fun makeSound() {
            Log.d("KotlinWeek03", "$species 가 소리를 냅니다.")
        }
    }
    val puppy = Animal("웰시코기", 10.5)
    puppy.makeSound()

//    class Student {
//        var name: String = ""
//        var age: Int = 0
//
//        fun introduce(){
//            println("Hi, I'm $name and I'm $age years old.")
//        }
//    }
//
//    val student = Student()
//    student.name = "Mirae"
//    student.age = 21
//    student.introduce()
//
//    data class Person(val name: String, val age: Int)
//
//    var person1 = Person("Kim", 23)
//    var person2 = Person("Kim", 23)
//    println("Person1: $person1")
//    println("Person2: $person2")
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