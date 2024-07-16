package fr.hamtec.creations

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
fun opDemarDispatcher(){
    runBlocking {

        val parentJob = GlobalScope.launch(newSingleThreadContext("-Parent-")) {
            println("Parent coroutine name: ${Thread.currentThread().name}")

            val firstCildJob = launch(newSingleThreadContext("-First-")) {
                println("First coroutine name: ${Thread.currentThread().name}")
                delay(1000L)
                println("End of first coroutine")
            }

            val secondChildJob = launch(newSingleThreadContext("-Second-")) {
                println("Second coroutine name: ${Thread.currentThread().name}")

                withContext(NonCancellable){
                    println(Thread.currentThread().name)
                    delay(1000L)
                    println("End of second coroutine")
                }

            }

            delay(200L)
            firstCildJob.cancel()
            secondChildJob.cancel()

        }

        parentJob.join()
        println("End of parent")
    }

    println("End of program")
}
fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

val flo: Flow<Int> = flow {

}