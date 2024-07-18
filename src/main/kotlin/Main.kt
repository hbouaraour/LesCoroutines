package fr.hamtec

import fr.hamtec.blog.simpleFlow
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking{
        launch {
            simpleFlow().collect { value ->
                println(value)
            }
        }

        val transformedFlow = simpleFlow()
            .map { it * 2 }
            .filter { it % 3 == 0 }


    }

}

