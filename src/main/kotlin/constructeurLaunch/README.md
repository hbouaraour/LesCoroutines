## Constructeur launch

```
fun CoroutineScope.launch(
    context: CoroutineContext = EmptyCoroutineContext, 
    start: CoroutineStart = CoroutineStart.DEFAULT, 
    block: suspend CoroutineScope.() -> Unit
): Job
```
Lance une nouvelle coroutine sans bloquer le thread courant et renvoie une référence à la coroutine sous la forme d'un job. La coroutine est annulée lorsque le job résultant est annulé. Le contexte de la coroutine est hérité d'un CoroutineScope. Des éléments de contexte supplémentaires peuvent être spécifiés avec l'argument context. Si le contexte n'a pas de répartiteur ni d'autre ContinuationInterceptor, Dispatchers.Default est utilisé. Le job parent est également hérité d'un CoroutineScope, mais il peut également être surchargé avec un élément de contexte correspondant.