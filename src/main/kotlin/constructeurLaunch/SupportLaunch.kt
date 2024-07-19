package fr.hamtec.constructeurLaunch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun firstTestLaunch(): Unit {
    println("Before coroutine")
    GlobalScope.launch {
        println("Before sleep")
        delay(1000)
        println("After sleep")
    }
    Thread.sleep(1500)  //+ Cette ligne donne le temps à la coroutine de ce lancé
    println("After coroutine")
}