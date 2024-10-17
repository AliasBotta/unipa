# Consegna
Sviluppare un sistema di prelievo ATM proposto, dove le richieste di prelievo sono gestite secondo tre criteri specifici:

1. **Importi Direttamente Prelavabili**: Il sistema ATM permette prelievi diretti per importi predefiniti. Questi importi sono *disponibili immediatamente* per essere prelevati dall'utente senza necessità di ulteriori autorizzazioni.

2. **Prelievo di Importi Non Standard**: Se l'utente desidera prelevare un importo che non rientra tra quelli predefiniti, può digitare manualmente la quantità desiderata. 

3. **Limitazioni per Importi Elevati**: Nel caso in cui l'importo richiesto superi un certo limite prestabilito, il prelievo non può essere effettuato direttamente tramite l'ATM. Invece, l'utente deve recarsi in banca per gestire il prelievo.


# Risoluzione

Per risolvere il problema del sistema di prelievo ATM, ho utilizzato due design pattern: **Proxy** e **Chain of Responsibility**. Di seguito è descritta la soluzione implementata.

1. **Design Pattern Proxy**: 
   Il **Proxy** è utilizzato per gestire la registrazione delle richieste di prelievo. Questo pattern permette di aggiungere un livello intermedio tra il cliente e il gestore delle richieste di prelievo, consentendo di loggare tutte le richieste effettuate. La classe `WithdrawalProxy` implementa l'interfaccia `WithdrawalHandler` e contiene un attributo `List<Response> log` che memorizza la storia delle richieste. Ogni volta che una richiesta di prelievo viene effettuata, questa viene processata e registrata nel log tramite il metodo `WithdrawalRequest(Request)`.

2. **Design Pattern Chain of Responsibility**: 
   Il pattern **Chain of Responsibility** è utilizzato per distribuire la gestione delle richieste di prelievo tra diversi handler. Abbiamo una catena di handler che può gestire vari tipi di prelievo:

   - **DefaultAmountHandler**: Gestisce i prelievi con importi predefiniti e standard, che sono immediatamente disponibili senza ulteriori autorizzazioni.
   - **CustomAmountHandler**: Gestisce prelievi di importi personalizzati, permettendo all'utente di digitare manualmente l'importo desiderato, purché rientri in un limite definito.
   - **BankAmountHandler**: Gestisce richieste di importi elevati, che superano un certo limite e richiedono l'intervento di un gestore di banca.

   Ogni handler implementa l'interfaccia `WithdrawalHandler` tramite la classe astratta `WithdrawalRequestHandler`. Se un handler non è in grado di gestire una richiesta, questa viene inoltrata al successivo handler nella catena tramite il metodo `forwardWithdrawalRequest(Request)`.

3. **Funzionamento della Catena di Gestione**: 
   Quando una richiesta di prelievo viene effettuata, il sistema passa la richiesta attraverso la catena di handler. La catena si comporta come segue:

   - Il **DefaultAmountHandler** verifica se l'importo richiesto è uno degli importi predefiniti. Se lo è, la richiesta viene processata immediatamente.
   - Se l'importo non è predefinito, la richiesta viene inoltrata al **CustomAmountHandler**, che permette di inserire un importo personalizzato, se rientra nei limiti.
   - Se l'importo supera i limiti definiti, la richiesta viene inoltrata al **BankAmountHandler**, che avvisa l'utente di recarsi in banca per completare l'operazione.

# Correzioni

Sistemare il proxy, poichè questo deve essere solamente un surrogato, mentre in realtà ciò che ho implementato è stato un decorator
