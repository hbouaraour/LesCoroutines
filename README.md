## Les coroutines

Une coroutine est une instance de calcul suspendable. Cela ressemble conceptuellement à un thread dans le sens où elle exécute un bloc de code et possède un cycle de vie similaire.

Dans les coroutines, un flux est un type qui peut émettre plusieurs valeurs de manière séquentielle, par opposition aux fonctions de suspension qui ne renvoient qu'une seule valeur. Par exemple, vous pouvez utiliser un flux pour recevoir les mises à jour en direct d'une base de données.

Les flux sont basés sur des coroutines et peuvent fournir plusieurs valeurs. Un flux est conceptuellement un flux de données qui peut être calculé de manière asynchrone. Les valeurs émises doivent être du même type. Par exemple, Flow<Int> est un flux qui émet des valeurs entières.

Un flux est très semblable à un Iterator qui produit une séquence de valeurs, mais qui utilise des fonctions de suspension pour produire et consommer des valeurs de manière asynchrone. Cela signifie, par exemple, que le flux peut effectuer de façon sécurisée une requête réseau pour produire la valeur suivante sans bloquer le thread principal.