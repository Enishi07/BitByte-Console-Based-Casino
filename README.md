<div align="center">

# 🎰 **BitByte Casino**  
### A Console-Based Casino Game Simulation

**IT-2108:**  
Collamar, Alexander Joshua D.  
Dela Paz, Jaren Ken Gabriel R.  
Matira, Carl Andrei A.  
</div>

<p align="center">
  <a href="#-overview"><img src="https://img.shields.io/badge/📖_Overview-6b4f29?style=for-the-badge"></a>
  <a href="#-key-features"><img src="https://img.shields.io/badge/⭐_Features-8c6931?style=for-the-badge"></a>
  <a href="#-oop-concepts-applied"><img src="https://img.shields.io/badge/🏗️_OOP_Concepts-b8863b?style=for-the-badge"></a>
  <a href="#-program-structure"><img src="https://img.shields.io/badge/📁_Program_Structure-d4a15f?style=for-the-badge"></a>
  <a href="#-how-to-run"><img src="https://img.shields.io/badge/🚀_How_to_Run-e3b679?style=for-the-badge"></a>
  <a href="#-sample-output"><img src="https://img.shields.io/badge/📜_Sample_Output-efcb9f?style=for-the-badge"></a>
  <a href="#-author--acknowledgement"><img src="https://img.shields.io/badge/👤_Author_Acknowledgement-f7e4c5?style=for-the-badge"></a>
</p>

---

## 📖 **Overview**

BitByte Casino is a Java-based console simulation featuring six casino games, designed as an educational alternative to real gambling. It includes animated ASCII art, tutorials, a balance system, and interactive gameplay.

### **Highlights**
- 🎮 Six games: Dice Roll, Blackjack, Slot Machine, Color Game, Crazy Time, Roulette  
- 💰 Balance management with PHP 1000 starting amount  
- 📘 Interactive tutorials  
- 🖥️ Animated text + ASCII logos  
- ⚠️ Responsible gambling reminders  

---

## 🎯 **Key Features**

### **Games Available**
| Game | Description | Bet Range | Win Condition |
|------|-------------|-----------|----------------|
| 🎲 **Dice Roll** | Predict dice outcomes | PHP 50–500 | Correct prediction |
|  🂡 **Blackjack** | Battle the dealer to 21 | PHP 100–1000 | Beat dealer |
| 🎰 **Slot Machine** | Spin reels for symbol matches | PHP 10–200 | Matching symbols |
| 🟥 **Color Game** | Bet on red/black | PHP 20–300 | Correct color |
| 🎡 **Crazy Time** | Spin wheel with multipliers | PHP 50–1000 | Winning segment |
| 🎯 **Roulette** | Bet on numbers or colors | PHP 25–500 | Correct outcome |

### **Gameplay Mechanics**
- Balance system  
- Interactive tutorials  
- Typing animations  
- Responsible-play warnings  
- Skippable guides  
- Clear-screen effects  

---

## 🏗️ **OOP Concepts Applied**

### **1️⃣ Inheritance**
`BitByteCasinoGame` → six concrete game classes  
Each game overrides `play()`.

### **2️⃣ Polymorphism**
Menu chooses which `play()` method executes at runtime.

### **3️⃣ Encapsulation**
Shared tools protected; game-specific values private.

### **4️⃣ Abstraction**
Game logic hidden behind the abstract base.

### **5️⃣ Composition**
Main class holds instances of all game objects.

---

## 📁 **Program Structure**

```

BitByte_Casino/
├── BitByteCasino.java               # Main program, menu, intro
├── BitByteCasinoGame.java           # Abstract game base
├── DiceGame.java                    # Dice Roll
├── BlackjackGame.java               # Blackjack
├── SlotMachineGame.java             # Slot Machine
├── ColorGame.java                   # Color Game
├── CrazyTimeGame.java               # Crazy Time
├── BlackRedRouletteGame.java        # Roulette
├── Tutorial/
│   └── Tutorial.java                # Tutorial system
├── compile.bat                      # Compile script
├── run.bat                          # Run script
└── clean.bat                        # Cleanup

````

---

## 🚀 **How to Run**

### **Prerequisites**
- ☕ JDK 11+  
- 🪟 Windows CMD / terminal  
- 💾 10MB disk space  

### **Compilation**
```sh
cd /path/to/BitByte-Console-Based-Casino
javac BitByte_Casino/*.java BitByte_Casino/Tutorial/*.java
````

Or simply:

```
compile.bat
```

### **Execution**

```sh
java -cp . BitByte_Casino.BitByteCasino
```

Or:

```
run.bat
```

### **One-Line Quick Start**

```sh
cd /path/to/BitByte-Console-Based-Casino && javac BitByte_Casino/*.java BitByte_Casino/Tutorial/*.java && java -cp . BitByte_Casino.BitByteCasino
```

---

## 🎮 **Gameplay Guide**

### **Game Flow**

1. Launch application
2. View intro animations
3. Choose game (1–6)
4. Optional tutorial
5. ASCII logo appears
6. Enter bet
7. Play rounds until exit or 0 balance

> **Tip:** Tutorials explain rules, odds, and examples.

---

## 📊 **Example Gameplay Scenario**

### **Starting Balance: PHP 1000**

#### **Round 1 — Dice Roll**

* Bet PHP 100
* Roll: 8 → **Win**
* New Balance: PHP 1100

#### **Round 2 — Blackjack**

* Bet PHP 200
* Player hits **21** → Blackjack
* New Balance: PHP 1300

#### **Round 3 — Slot Machine**

* Partial match
* New Balance: PHP 1250

---

## 🎬 **Sample Output**

<details>
<summary>📂 Click to Expand Sample Output</summary>

```
===================================================================================================================
            Balance: PHP1000.00
===================================================================================================================
            Choose a game:
            1.  Dice Roll
            2.  Blackjack
            3.  Slot Machine
            4.  Color Game
            5.  Crazy Time
            6.  Roulette
            7.  Exit
-------------------------------------------------------------------------------------------------------------------
Enter your choice: 
```

### **Centered ASCII Game Logo**

```
      ::::::::: ::::::::::: ::::::::::: :::::::::  :::   ::: ::::::::::: ::::::::::          ::::::::      :::      :::::::: ::::::::::: ::::    :::  ::::::::
     :+:    :+:    :+:         :+:     :+:    :+: :+:   :+:     :+:     :+:                :+:    :+:   :+: :+:   :+:    :+:    :+:     :+:+:   :+: :+:    :+:
    +:+    +:+    +:+         +:+     +:+    +:+  +:+ +:+      +:+     +:+                +:+         +:+   +:+  +:+           +:+     :+:+:+  +:+ +:+    +:+
   +#++:++#+     +#+         +#+     +#++:++#+    +#++:       +#+     +#++:++#           +#+        +#++:++#++: +#++:++#++    +#+     +#+ +:+ +#+ +#+    +:+
  +#+    +#+    +#+         +#+     +#+    +#+    +#+        +#+     +#+                +#+        +#+     +#+        +#+    +#+     +#+  +#+#+# +#+    +#+
 #+#    #+#    #+#         #+#     #+#    #+#    #+#        #+#     #+#                #+#    #+# #+#     #+# #+#    #+#    #+#     #+#   #+#+# #+#    #+#
######### ###########     ###     #########     ###        ###     ##########          ########  ###     ###  ######## ########### ###    ####  #########
       
```

</details>

---

## 👤 **Author & Acknowledgement**

### **Development Team**

| Name                               | Role                 |
| ---------------------------------- | -------------------- |
| **Collamar, Alexander Joshua D.**  | Lead Developer 1     |
| **Dela Paz, Jaren Ken Gabriel R.** | Lead Developer 2     |
| **Matira, Carl Andrei A.**         | UI Designer / Tester |

---

## 🙏 Acknowledgements

### Special Thanks to Our Instructors
- **Ma'am Fatima** - For providing comprehensive lessons, templates, and resources shared through her Discord community server.
- **Sir Emmanuel** - For his dedicated lessons and continuous effort in teaching us whenever possible. His support and expertise greatly contributed to our understanding and development

### Learning Resources & Inspiration
- **YouTube Channels**: 
  - Bro Code - For comprehensive Java tutorials and best practices
  - Coding with Mosh - For clear programming concepts and design patterns
  - Other Indian Coding Tutorials - For diverse perspectives and innovative solutions
- **Open-Source**:
  - **Stack Overflow** - For community support and solving countless technical challenges
  - **Open-Source Community** - For shared knowledge and programming resources

### Personal Support
- **Our Parents** - For their unwavering support, encouragement, and belief in this project. This wouldn't have been possible without their sacrifices and dedication
- **Our Peers & Friends** - For playtesting, constructive feedback, and motivation throughout development

---

**🎰 Enjoy and learn how to gamble responsibly with BitByte Casino! 🎲🃏**


