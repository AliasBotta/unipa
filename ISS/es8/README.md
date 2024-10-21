# Consegna

## Obiettivo
Progettare una classe per rappresentare gli studenti universitari, i quali partecipano a varie attività accademiche e extra-accademiche.

## Funzionalità Base dello Studente

- **Corsi**: Ogni studente segue corsi accademici.
- **Esami**: Gli studenti si sottopongono a esami per valutare la loro comprensione dei corsi seguiti.

## Attributi dello Studente

- **Nome**
- **Cognome**
- **Matricola**: Un identificativo unico per ciascuno studente.

## Categorie Specifiche di Studenti

1. **Studenti Tutor**:
   - Oltre alle attività base, gli studenti tutor offrono ricevimento per aiutare altri studenti.
   - Conducono esercitazioni per le materie di cui sono tutor.

2. **Studenti Dimostratori**:
   - Partecipano a eventi come open day, dove distribuiscono materiale informativo e forniscono spiegazioni ai visitatori.
   - Mantengono una lista degli eventi a cui hanno partecipato, che desiderano poter consultare facilmente.

3. **Studenti Laureandi**:
   - Oltre a seguire i corsi e sostenere esami, i laureandi preparano una prova finale (tesi o progetto) per completare i loro studi.

## Dettagli Implementativi

- La classe dovrebbe essere in grado di gestire le differenze tra le varie categorie di studenti, permettendo di aggiungere o modificare categorie e funzionalità nel tempo.
- Considerare l'uso di ereditarietà o composizione per gestire le funzionalità estese degli studenti tutor, dimostratori e laureandi, mantenendo la classe base snella e focalizzata sulle funzionalità comuni a tutti gli studenti.

## Risultati Attesi

- La classe studente dovrebbe fornire metodi per aggiungere o modificare le attività svolte dagli studenti, nonché per accedere e aggiornare i loro attributi.
- Le classi specifiche per i tutor, dimostratori e laureandi dovrebbero estendere la classe base dello studente, aggiungendo metodi e attributi pertinenti alle loro responsabilità aggiuntive.

# Risoluzione

## Rappresentazione degli studenti
Per rappresentare gli studenti sfruttiamo il design pattern decorator, mentre per implementare la feature dello studente dimostratore sfruttiamo il design pattern iterator. 
