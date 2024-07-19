package fr.hamtec.attendreLaFinCoroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun firstAttendre(){
    println("Before coroutine")
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000)
        }

        job.join()
    }
    println("Fin prog")
}