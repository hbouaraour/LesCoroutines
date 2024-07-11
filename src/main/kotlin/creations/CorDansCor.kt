package fr.hamtec.creations

import kotlinx.coroutines.*

fun gest() {
    runBlocking {

        val parentJob = GlobalScope.launch(CoroutineExceptionHandler { _, throwable ->
            println("ERROR => ${throwable.message}")
        }) {

            println("Parent coroutine")

            launch() {
                println("First child")
                delay(1000)
                println("End of First child")
            }

            launch {
                println("Second child")
                10 / 0
                println("End of Second child")
            }
            println("Fin parent coroutine")
        }
        parentJob.join()
    }

    println("Fin prog")
}