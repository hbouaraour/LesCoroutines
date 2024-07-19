package fr.hamtec.blog

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        emit(i)
        delay(100L) // Simulate delay
    }
}
//+ StateFlow +---------------------------------------
private val _state = MutableStateFlow("Initial State")
val state: StateFlow<String> get() = _state

fun updateState(newState: String) {
    _state.value = newState
}
//+ SharedFlow +---------------------------------------
private val _events = MutableSharedFlow<Int>(replay = 2, onBufferOverflow = BufferOverflow.DROP_LATEST)
val events: SharedFlow<Int> get() = _events

fun sharedTes() = GlobalScope.launch {
        _events.emit(555)

    }


