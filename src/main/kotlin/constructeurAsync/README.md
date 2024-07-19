## Constructeur async

```
fun <T> CoroutineScope.async(
    context: CoroutineContext = EmptyCoroutineContext, 
    start: CoroutineStart = CoroutineStart.DEFAULT, 
    block: suspend CoroutineScope.() -> T
): Deferred<T>
```

Crée une coroutine et renvoie son résultat futur sous la forme d'une implémentation de Deferred. La coroutine en cours d'exécution est annulée lorsque le différé résultant est annulé. La coroutine résultante présente une différence essentielle par rapport à des primitives similaires dans d'autres langages et cadres : elle annule le job parent (ou la portée extérieure) en cas d'échec, afin d'appliquer le paradigme de la concurrence structurée. Pour modifier ce comportement, il est possible d'utiliser un parent superviseur (SupervisorJob ou supervisorScope).<br><br>
Le contexte de la coroutine est hérité d'un CoroutineScope, des éléments de contexte supplémentaires peuvent être spécifiés avec l'argument context. Si le contexte n'a pas de dispatcher ni d'autre ContinuationInterceptor, alors Dispatchers.Default est utilisé. Le job parent est également hérité d'un CoroutineScope, mais il peut également être surchargé avec l'élément de contexte correspondant.<br><br>
Par défaut, l'exécution de la coroutine est immédiatement programmée. D'autres options peuvent être spécifiées via le paramètre start. Voir CoroutineStart pour plus de détails. Un paramètre optionnel de démarrage peut être défini à CoroutineStart.LAZY pour démarrer la coroutine de manière paresseuse. Dans ce cas, le différé résultant est créé dans un nouvel état. Il peut être démarré explicitement avec la fonction start et sera démarré implicitement à la première invocation de join, await ou awaitAll.