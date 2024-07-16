package fr.hamtec.creations

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class ExampleViewModel {
    private val _mutableSharedFlow = MutableSharedFlow<Int>()
    //+ Représente ce flux partagé mutable comme un flux partagé en lecture seule.
    val sharedFlow = _mutableSharedFlow.asSharedFlow()

    private val _mutableStateFlow = MutableStateFlow(0)
    //+ Représente ce flux d'état mutable comme un flux d'état en lecture seule.
    val stateFlow = _mutableStateFlow.asStateFlow()
}