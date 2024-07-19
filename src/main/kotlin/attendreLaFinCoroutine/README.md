## Attendre la fin de la coroutine

```
suspend fun <T> Promise<T>.await(): T

interface Job : CoroutineContext.Element
    abstract suspend fun join()
```
join<br>
Suspend la coroutine jusqu'à ce que ce travail soit terminé. Cette invocation reprend normalement (sans exception) lorsque le travail est terminé, quelle qu'en soit la raison, et que le travail de la coroutine invoquée est toujours actif. Cette fonction démarre également la coroutine correspondante si le Job était encore dans un nouvel état.

await<br>
Cette fonction de suspension est annulable : si le travail de la coroutine en cours est annulé pendant que cette fonction de suspension attend la promesse, cette fonction reprend immédiatement avec une exception d'annulation. Il existe une garantie d'annulation rapide : même si cette fonction est prête à renvoyer le résultat, mais qu'elle a été annulée alors qu'elle était suspendue, une exception d'annulation sera levée. Voir suspendCancellableCoroutine pour les détails de bas niveau.