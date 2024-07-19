## Constructeur runBlocking

```
expect fun <T> runBlocking(
    context: CoroutineContext = EmptyCoroutineContext, 
    block: suspend CoroutineScope.() -> T
): T
```
Lance une nouvelle coroutine et bloque le thread en cours jusqu'à son achèvement. Il est conçu pour faire le lien entre le code bloquant normal et les bibliothèques écrites dans un style suspensif, à utiliser dans les fonctions principales et dans les tests.