# maze-docker-kata
*A dockerized app to collect objects in a maze*

## Introduzione
* L'applicazione legge da un file di input.json un labririnto così specificato:
  * un elenco di stanze collegate tra loro e contenenti oggetti
  * l'identificativo della stanza di partenza 
  * una lista di oggetti da collezionare.
  
  
* L'applicazione mostra un output costituito dall'elenco ordinato delle stanze attraversate.

## Lanciare l'applicazione
- Eseguire dalla root del progetto i seguenti comandi, nell'ordine indicato:

  * docker build -t mytest .
  * docker run -v $(pwd):/mnt -w /mnt mytest ./scripts/build.sh 
  * docker run -v $(pwd):/mnt -w /mnt mytest ./scripts/tests.sh 
  * docker run -v $(pwd):/mnt -w /mnt mytest ./scripts/run.sh [nome-file-input] [nome-file-output]
  

- I parametri nell'ultimo comando sono opzionali:
  * nome-file-input (default: 'input.json'): il path del file relativo alla root di progetto
  * nome-file-output: il path del file di output; l'output viene in ogni caso mostrato anche a video

## Note aggiuntive
- Si assume che il labrinto in input sia ben formato, ad esempio:
  * gli id delle stanze sono tutti diversi
  * le stanze sono collegate reciprocamente in modo simmetrico
  * gli oggetti sono tutti diversi tra loro.


- L'algoritmo visita le stanze finché non ha trovato tutti gli oggetti specificati,
  quindi potrebbe non visitare tutto il labirinto, e il labirinto potrebbe contenere
  più oggetti di quelli richiesti nel parametro "objects to collect".


- Nel caso in cui non tutti gli oggetti richiesti siano presenti,
  l'algoritmo termina ugualmente dopo aver raccolto tutto ciò che può.

  
- L'algoritmo produce, per il secondo caso "Esempio 2" un percorso diverso
  ma ugualmente valido, che non comprende tutte le stanze ma raccoglie tutti gli oggetti specificati.


