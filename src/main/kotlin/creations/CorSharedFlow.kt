package fr.hamtec.creations

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun sharFlow1() {
    val sharedFlow = MutableSharedFlow<Int>()
    runBlocking {


        // Collect values from sharedFlow
        launch {
            sharedFlow.collect { value ->
                println("Collector 1 received: $value")
            }
        }

        // Collect values from sharedFlow
        launch {
            sharedFlow.collect { value ->
                println("Collector 2 received: $value")
            }
        }

        // Emit values to sharedFlow
        launch {
            repeat(3) { i ->
                sharedFlow.emit(i)
            }
        }

    }
}
fun sharFlow2(){
    val mutableStateFlow = MutableStateFlow(0)
    val stateFlow: StateFlow<Int> = mutableStateFlow
    runBlocking {

// Collect values from stateFlow
        launch {
            stateFlow.collect { value ->
                println("Collector 1 received: $value")
            }
        }

// Collect values from stateFlow
        launch {
            stateFlow.collect { value ->
                println("Collector 2 received: $value")
            }
        }

// Update the state
        val sharedF = launch {
            repeat(3) { i ->
                mutableStateFlow.value = i
            }

        }

    }
}