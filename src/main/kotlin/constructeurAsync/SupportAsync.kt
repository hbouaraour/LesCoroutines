package fr.hamtec.constructeurAsync

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

fun fistTestAsync(): Unit {
    println("Before coroutine")
    GlobalScope.async {
        println("Before sleep")
        delay(1000)
        println("After sleep")
    }
    Thread.sleep(1500)  //+ Cette ligne donne le temps à la coroutine de ce lancé
    println("After coroutine")
}