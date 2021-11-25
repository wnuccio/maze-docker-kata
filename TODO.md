Casi di test
- tre stanze collegate con solo le prime due aventi oggetti 
  (e due oggetti da collezionare, si ferma alla seconda stanza)
- stanze senza oggetti (si ferma comunque appena terminata la visita)
- casi di errore (da non testare): labirinto malformed (stanze non collegate reciprocamente,
  valutare se eseguire un check preliminare:
  - stanze ben collegate in modo simmetrico,
  - oggetti tutti diversi,
  )

Completati
- labirinto vuoto
- stanza unica
- due stanze collegate con due oggetti
- due stanze collegate partendo però dalla seconda
- più stanze collegate, ciascuna con un oggetto

Da fare
- differenziare i concetti di Input e Maze (segregando l'interfaccia, anche per disaccoppiare 
  il layer room da inout)
- valutare di inlinare il RouteFinder dentro Room
- valutare se disaccoppiare il modello json (input+room+namedobject) da quello di business (con nuove classi)
  in tal caso le prime saranno semplici DTO
- la lista di oggetti deve diventare un set?
- 
