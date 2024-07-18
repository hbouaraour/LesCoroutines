package fr.hamtec.blog

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        emit(i)
        delay(1000L) // Simulate delay
    }
}