# DungeonGrinder

DungeonGrinder è un gioco Dungeon-Crawler con nemici e funzionalità basilari che permette di giocare senza fine, infatti
presenta la funzionalità di avere una generazione procedurale di stanze in modo illimitato.

---

## Acknowledgments

Gli assets per questo gioco sono stati presi da [0x72.itch.io](https://0x72.itch.io/16x16-dungeon-tileset) che fornisce
un tileset avanzato e gratuito perfetto per l'use-case e l'idea del gioco.

---

## Funzionalità Presenti

- Movement System Basilare da tastiera (W,A,S,D)
- Sistema di Goal Modulare per le Entità (Pathfinding, Attack)
- Asset Registry System
- Debug Screen

---

## Note Tecniche

Per questo progetto è stato fatto uso del pattern MVC (Model View Controller) consigliato dal prof. Rossi a lezione
(molto carino btw)

### Riguardo L'Asset Registry System (ASR)

L'approccio ASR (Asset Registry) offre il significativo vantaggio di una spiccata semplicità implementativa e di
un'elevata scalabilità, in quanto non richiede la specifica manuale delle dimensioni dei singoli asset o di altri
parametri di configurazione. Di contro, tale soluzione comporta un incremento delle operazioni di I/O durante la fase di
caricamento (loading) delle risorse, poiché le texture sono memorizzate in file distinti anziché in un unico archivio
ottimizzato.

Questa scelta architetturale è stata ritenuta ottimale in quanto l'impatto prestazionale in fase di avvio risulta
irrilevante ai fini del gameplay. Sebbene molti titoli del genere dungeon crawler operino tradizionalmente a 30 FPS,
l'applicazione corrente garantisce un target di 60 FPS. È inoltre opportuno evidenziare che la gestione del game/render
loop, affidata alla
classe [AnimationTimer](https://openjfx.io/javadoc/17/javafx.graphics/javafx/animation/AnimationTimer.html) di JavaFX,
si sincronizza nativamente con la frequenza di aggiornamento (refresh rate) del display in uso, garantendo la necessaria
fluidità senza sovraccaricare la CPU, nonostante tutto per migliorare
le prestazioni ed evitare desync è stato implementato un delta-counter che permette di evitare uno "speedup" della
logica del gioco.

---

## TODO

### In Sviluppo

- Rotation delle texture "vive" a seconda dell'ultimo movimento
- Meccanismo di salvataggio e restore
- Possibilità di impostare il seed (permette magari ad amici di giocare lo "stesso" dungeon e competere tra di loro)
- UI migliorata (Health-bar Player/Nemici)

### Pianificati

- Main Menu / Pause Menu

### Possibili Miglioramenti Futuri

- Animazioni Sprite (Attualmente il gioco è statico in quanto non ho nessuna familiarità con i design pattern applicati
  all'interno del Game Development)
- Aggiungere più nemici / Entità (Magari dei mercanti che per degli item speciali ti danno altri oggetti)
- Collezionabili
- Achievement
- Incantesimi

---

## Uso dell'AI

L'uso dell'AI è stato limitato a scopi di documentazione (apprendimento), code-review e studio dei casi d'uso per i
design pattern, nessuna parte
di codice del progetto è stata generata da AI.