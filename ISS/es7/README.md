# Consegna

Sviluppare un sistema di gestione di progetto, qui i dettagli:

**Responsabilità del Responsabile Scientifico di Progetto:**
- Il responsabile scientifico del progetto ha il compito di guidare l'attività di ricerca.
- Gestisce anche il budget complessivo del progetto.

**Struttura del Progetto:**
- Il progetto è suddiviso in diverse unità di lavoro chiamate "work packages" (WP), numerati da wp1 a wpn.
- Ogni WP può contenere diversi task, che possono essere comuni a più WP o specifici per un singolo WP.
- I task possono essere semplici o possono a loro volta includere sottotask.
- Un task comune a tutti i WP è la memorizzazione dei risultati del task in un database centralizzato.

**Gestione dei Work Packages:**
- Ogni WP è assegnato a un Responsabile di WP, che ha il compito di gestire sia l'attività che il budget del WP.
- Il Responsabile di WP ha la responsabilità di:
  1. Assegnare specifiche attività e sottotask ai membri del team del suo WP.
  2. Gestire il budget assegnato al suo WP per acquisti di materiali, assicurandosi di non superare l'ammontare assegnato.

**Autorizzazioni e Limitazioni:**
- Per spese legate alla mobilità del personale o per spese che superano il budget assegnato al WP (chain of responsibility!), è necessaria un'autorizzazione esplicita dal Responsabile Scientifico di Progetto.

**Regole di Gestione Budgetaria:**
- I responsabili di WP hanno la facoltà di gestire autonomamente il budget assegnato al loro WP, ma devono ottenere autorizzazione per spese che eccedono tale budget o per specifiche categorie di spesa come la mobilità del personale.

# Risoluzione

## Organigramma aziendale
L'organigramma dell'azienda è gestito attraverso una **chain of responsability**, vi è l'interfaccia `Manager` implementata dalle classi concrete: 
- `WpManager`, il quale ha la responsabilità di 
  - gestire autonomamente il budget assegnato al proprio WP
  - assegnare specifiche attività e sottotask ai membri del team del proprio WP
- `ScientificManager`, il il quale ha la responsabilità di: 
  - dirigere spese legate alla mobilità del personale
  - aumentare il budget assegnato ai WP

## Gerarchia di progetto
Per rappresentare il progetto facciamo uso del design pattern **composite**, in modo tale da strutturare il progetto nel seguente modo: 
*  `Project`, un *component* (quindi classe astratta) che dichiara il metodo concreto per 
memorizzare i risultati del task in un db centralizzato (jorunaling). 
   * `WP` (work package), un *composite* che estende la classe astratta project
     *  `Task`, un ulteriore *composite* che estende la classe astratta project
        * `AtomicTask`, una *leaf* che estende la classe project 

> *nota*: il motivo per cui task è stato splittato in Task e AtomicTask risiede nel fatto che un task può contnere altri sottotask, indichiamo quindi con AtomicTask un task per l'appunto **atomico**, perciò non potrà esere suddiviso in più sottotask 


