package fr.hamtec.creations

import kotlinx.coroutines.runBlocking

fun simpleRunBlocking(){
    println("Avant")
    runBlocking {
        println("Dans la coroutine")
    }
    println("Après")
}