package fr.hamtec.constructeurRunBlocking

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun premTest(){
    runBlocking {
        println("Before sleep")
        Thread.sleep(1000)
        println("After sleep")
    }
}
fun secondTest() = runBlocking {
    println("Before sleep")
    Thread.sleep(1000)
    println("After sleep")
}
fun thirdTest(): Unit = runBlocking {
    println("Before sleep")
    Thread.sleep(1000)
    println("After sleep")
}
fun fourthTest() = runBlocking {
    println("Before sleep")
    delay(1000)
    println("After sleep")
}