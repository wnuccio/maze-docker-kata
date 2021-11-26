Precisazioni
- si assume che il labrinto in input sia ben formato, cioè che ad esempio,
  gli id delle stanze siano tutti diversi, le
  stanze siano collegate reciprocamente in modo simmetrico,
  che gli oggetti siano tutti diversi tra loro
- l'algoritmo visita le stanze finché non ha trovato tutti gli oggetti specificati,
  quindi potrebbe non visitare tutto il labirinto, e il labirinto potrebbe contenere 
  più oggetti di quelli richiesti nel parametro "objects to collect";
  tuttavia nel caso in cui non tutti gli oggetti richiesti siano presenti,
  l'algoritmo termina ugualmente dopo aver raccolto tutto ciò che può
- l'algoritmo produce, per il secondo caso "Esempio 2" un percorso diverso
  ma ugualmente valido, che non comprende tutte le stanze ma raccoglie tutti gli oggetti specificati
- il comando da eseguire è app input.json [optionalOutput]
  dove 'input.json' è il path (relativo alla root) del file contenente il json di input,
  mentre il secondo parametro, opzionale, è il file di output generato (di base l'output è su standard out)
  
