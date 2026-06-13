# 📌 DungeonGrinder

DungeonGrinder è un gioco Dungeon-Crawler con nemici e funzionalità basilari che permette di giocare senza fine, infatti
presenta la funzionalità di avere una generazione procedurale di stanze in modo illimitato.

![Screenshot del Gioco](https://i.imgur.com/5mtRU6Q.png)

---

## 🚀 Come eseguire il progetto

### Prerequisiti
- Java 25 (LTS)
- Gradle

### Istruzioni

```bash
git clone https://github.com/nicecraftz/DungeonGrinder.git
cd DungeonGrinder
```

### Build del progetto
```bash
./gradlew build
```

### Esecuzione
```bash
./gradlew run
```

---

## 🤖 Uso di strumenti di AI
L'uso dell'AI è stato limitato a scopi di documentazione e apprendimento, code-review e studio dei casi d'uso per i
design pattern, nessuna parte di codice del progetto è stata generata da AI.

* Utilizzato Gemini per:
  * comprendere concetti teorici (design pattern e best practice nel mondo del Game Development)
  * suggerimenti su struttura del codice

* Utilizzato Copilot per:
  * autocompletamento di metodi semplici
  * generazione di codice ripetitivo (es. getter/setter)
---


## ⚠️ Nota
Gli assets per questo gioco sono stati presi da [0x72.itch.io](https://0x72.itch.io/16x16-dungeon-tileset) che fornisce
un tileset avanzato e gratuito perfetto per l'use-case e l'idea del gioco.

---

## Funzionalità Presenti

- Movement System Basilare da tastiera (W,A,S,D)
- Sistema di Goal per le Entità (Pathfinding, Attack)
- Asset Registry System
- Debug Screen

---
## Note Tecniche

Per questo progetto è stato fatto uso del pattern MVC (Model View Controller) consigliato dal prof. Rossi a lezione
(molto carino btw)

---

## TODO

### In Sviluppo
- Sistema di switching delle stanze
- AttackGoal dei nemici in modo che ti provochino effettivamente danno.
- Meccanismo di salvataggio e restore

### Pianificati
- Main Menu / Pause Menu

### Possibili Miglioramenti Futuri
- Rotation delle texture "vive" a seconda del movimento
- Possibilità di impostare il seed (permette magari ad amici di giocare lo "stesso" dungeon e competere tra di loro)
- UI migliorata (Health-bar Player/Nemici)
- Più Entità
- Collezionabili
- Achievement
- Incantesimi