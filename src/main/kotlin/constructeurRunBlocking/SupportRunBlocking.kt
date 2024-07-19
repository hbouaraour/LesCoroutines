package fr.hamtec.constructeurRunBlocking

import kotlinx.coroutines.runBlocking

fun premTest(){
    runBlocking {
        println("Before sleep")
        Thread.sleep(1000)
        println("After sleep")
    }
}