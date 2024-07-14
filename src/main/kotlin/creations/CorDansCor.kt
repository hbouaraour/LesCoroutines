package fr.hamtec.creations

import kotlinx.coroutines.*

fun gest() {

    runBlocking {

        val parentJob = GlobalScope.launch {

            println("Parent coroutine")

            launch {
                println("First child")
                delay(1000)
                println("++ End of First child")
            }

            launch(SupervisorJob()) {
                println("Second child")
                1/0
                println("++ End of Second child")
            }

            println("Fin parent coroutine")
        }
        parentJob.join()
    }
    println("Fin prog")
}
fun opDemarAsyncr(): Unit {
    runBlocking {

        val parentJob = GlobalScope.launch {
            println("Parent coroutine")

            launch {
                println("First coroutine")
                delay(1000L)
                println("End of first coroutine")
            }

            val childJob = async(start = CoroutineStart.LAZY) {
                println("Second coroutine")
                delay(1500L)
                println("End of second coroutine")
            }

            childJob.await()

        }

        parentJob.join()
        println("End of parentJob")
    }

    println("End of program")
}
fun opDemarLaunch(){
    runBlocking {

        val parentJob = GlobalScope.launch {
            println("Parent coroutine")

            launch {
                println("First coroutine")
                delay(1000L)
                println("End of first coroutine")
            }

            val childJob = launch(start = CoroutineStart.LAZY) {
                println("Second coroutine")
                delay(1500L)
                println("End of second coroutine")
            }

            childJob.start()

        }

        parentJob.join()
        println("End of parentJob")
    }

    println("End of program")
}