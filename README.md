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


- È possibile testare l'applicazione con mappe diverse in due modi:
  * modificando direttamente il file input.json
  * creando un file apposito all'interno dell'alberatura di progetto e specificandolo come parametro
    
    (es. docker run -v $(pwd):/mnt -w /mnt mytest ./scripts/run.sh *custom-input.json*)
    

## Note aggiuntive
- Non essendo esplicitato nella traccia, ho omesso di considerare i casi di errore, 
  assumendo che il labrinto fornito in input sia sempre ben formato.
  In particolare ho assunto che:
  * gli id delle stanze siano tutti diversi
  * l'identificativo della stanza di partenza sia valido (corrisponda ad una stanza effettivamente presente) 
  * le stanze siano collegate reciprocamente in modo simmetrico
  * nei collegamenti di una stanza siano indicati solo id validi di altre stanze

- L'algoritmo visita le stanze finché non ha trovato tutti gli oggetti specificati,
  quindi potrebbe non visitare tutto il labirinto, e il labirinto potrebbe contenere
  più oggetti di quelli richiesti nel parametro "objects to collect".
  

- Per tale ragione l'algoritmo produce per il secondo caso ("Esempio 2") 
  un percorso diverso da quello indicato nella traccia ma ugualmente valido.
  Il percorso trovato non comprende tutte le stanze ma raccoglie tutti gli oggetti specificati.


- Nel caso in cui non tutti gli oggetti richiesti siano presenti,
  l'algoritmo termina ugualmente dopo aver raccolto tutto ciò che può.

  


