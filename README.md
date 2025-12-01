<div align="center">

# BitByte Casino
A Console-Based Casino Game Simulation

<b>IT-2108:</b><br>
Collamar, Alexander Joshua D.<br>
Dela Paz, Jaren Ken Gabriel R.<br>
Matira, Carl Andrei A.<br>
</div>

<p align="center">
  <a href="#-overview">
    <img src="https://img.shields.io/badge/📖_Overview-6b4f29?style=for-the-badge">
  </a>
  <a href="#-key-features">
    <img src="https://img.shields.io/badge/⭐_Features-8c6931?style=for-the-badge">
  </a>
  <a href="#-oop-concepts-applied">
    <img src="https://img.shields.io/badge/🏗️_OOP_Concepts_Applied-b8863b?style=for-the-badge">
  </a>
  <a href="#-program-structure">
    <img src="https://img.shields.io/badge/📁_Program_Structure-d4a15f?style=for-the-badge">
  </a>
  <a href="#-how-to-run">
    <img src="https://img.shields.io/badge/🚀_How_to_Run-e3b679?style=for-the-badge">
  </a>
  <a href="#-sample-output">
    <img src="https://img.shields.io/badge/📜_Sample_Output-efcb9f?style=for-the-badge">
  </a>
  <a href="#-author--acknowledgement">
    <img src="https://img.shields.io/badge/👤_Author_Acknowledgement-f7e4c5?style=for-the-badge">
  </a>
</p>


--------------------------------------------------------------------------------------------------------      

## 📖 Overview
BitByte Casino is a comprehensive Java-based console application simulating various casino games, designed as an alternative to real-life gambling. It provides simulations of popular casino games to test your luck, complete with interactive tutorials, a balance management system, and engaging ASCII art animations.

6 playable games with unique mechanics (Dice Roll, Blackjack, Slot Machine, Color Game, Crazy Time, Roulette)
Turn-based gameplay with balance management and risk assessment
Tutorial system for learning game rules
Progressive betting system with starting balance of PHP 1000
Animated introductions and game logos with typing effects

-------------------------------------------------------------------------------------------------------- 

## 🎯 Key Features
Games Available
Game	Description	Bet Range	Win Conditions
Dice Roll	Bet on dice outcomes (high/low, exact numbers)	PHP 50-500	Correct predictions on dice rolls
Blackjack	Classic card game against dealer	PHP 100-1000	Beat dealer without busting (21 or under)
Slot Machine	Spin reels for matching symbols	PHP 10-200	Matching symbols on paylines
Color Game	Bet on color outcomes (Red/Black)	PHP 20-300	Correct color prediction
Crazy Time	Spin wheel with multipliers	PHP 50-1000	Landing on winning segments
Roulette	Bet on numbers, colors, or ranges	PHP 25-500	Correct number/color/range prediction
Gameplay Mechanics
Balance Management: Starting balance of PHP 1000, bets deducted and winnings added
Tutorial System: Optional tutorials for each game before playing
Animated UI: Typing effects for text, ASCII art logos, clear screen transitions
Risk Warnings: Introductory messages about responsible gambling
Exit Conditions: Game ends when balance reaches zero or player chooses to exit
Inventory System (Balance)
Capacity: Unlimited (virtual currency)
Currency: Philippine Peso (PHP)
Effects: Betting, winnings, loss prevention

-------------------------------------------------------------------------------------------------------- 

## 🏗️ OOP Concepts Applied
1. Inheritance
BitByteCasinoGame (abstract) → 6 concrete game classes (DiceGame, BlackjackGame, SlotMachineGame, ColorGame, CrazyTimeGame, BlackRedRouletteGame)
Abstract methods implemented uniquely per game: play() method for game logic
2. Polymorphism
Abstract play() method overridden in each game class for specific implementations
Runtime resolution selects concrete game logic based on user choice
3. Encapsulation
Protected fields in BitByteCasinoGame (Scanner, Random) for shared utilities
Private game-specific variables in each game class
Static methods for clear screen and utility functions
4. Abstraction
Abstract BitByteCasinoGame class hides implementation while defining play() interface
Game selection operates through abstract type, not concrete classes
Complex game logic hidden behind simple play() method calls
5. Composition
BitByteCasino contains instances of all game classes
Tutorial system composed of separate Tutorial class with static methods
Main menu combines game instances and user input handling

-------------------------------------------------------------------------------------------------------- 

## 📁 Program Structure
BitByte_Casino/
├── BitByteCasino.java                          # Application entry point, main menu, intro animations
├── BitByteCasinoGame.java                      # Abstract base class for all games
├── DiceGame.java                               # Dice Roll game implementation
├── BlackjackGame.java                          # Blackjack game implementation
├── SlotMachineGame.java                        # Slot Machine game implementation
├── ColorGame.java                              # Color Game implementation
├── CrazyTimeGame.java                          # Crazy Time game implementation
├── BlackRedRouletteGame.java                   # Roulette game implementation
├── Tutorial/
│   └── Tutorial.java                           # Tutorial methods for all games
├── compile.bat                                 # Windows compilation script
├── run.bat                                     # Windows execution script
└── clean.bat                                   # Cleanup script

-------------------------------------------------------------------------------------------------------- 

## 🚀 How to Run
Prerequisites
Java Development Kit (JDK) 11 or later
Windows Command Prompt or compatible terminal
~10MB disk space for compiled bytecode
Compilation
# Navigate to project root
cd /path/to/BitByte-Console-Based-Casino

# Compile all Java files
javac BitByte_Casino/*.java BitByte_Casino/Tutorial/*.java

# Or use the provided batch file on Windows
compile.bat
Execution
# Run the game
java -cp . BitByte_Casino.BitByteCasino

# Or use the provided batch file on Windows
run.bat
Quick Start (One Command)
cd /path/to/BitByte-Console-Based-Casino && javac BitByte_Casino/*.java BitByte_Casino/Tutorial/*.java && java -cp . BitByte_Casino.BitByteCasino
Rebuild After Modifications
javac BitByte_Casino/*.java BitByte_Casino/Tutorial/*.java

-------------------------------------------------------------------------------------------------------- 

## 🎮 Gameplay Guide
Starting the Game
Run java -cp . BitByte_Casino.BitByteCasino
View animated producer text and gambling warnings
Choose: Select game (1-6) or Exit (7)
Game Selection
Enter your choice (1-7)
Optional tutorial for selected game
View game-specific ASCII logo animation
Choose to start playing or return to menu
Betting System
Each game prompts for bet amount within specified range
Balance updated after each round
Game ends if balance reaches zero
Tutorials
Available for each game before playing
Explains rules, betting, and winning conditions
Can be skipped by entering 'n'
Responsible Gambling
Introductory messages emphasize gambling risks
"The House Always Wins" reminder
Encourages responsible play

-------------------------------------------------------------------------------------------------------- 

## 📊 Example Gameplay Scenario
Starting BitByte Casino
    └─ Player begins with PHP 1000 balance

Round 1: Dice Roll Game
    Player selects Dice Roll (option 1)
    Views tutorial (optional)
    Sees animated dice logo
    
    Player bets PHP 100 on "High" (7-12)
    Dice rolls: 8 (win!)
    
    Balance: PHP 1100 (+PHP 100 winnings)
    
Round 2: Blackjack Game
    [Player switches to Blackjack, bets PHP 200...]
    Player hits 21 (Blackjack!)
    Balance: PHP 1300 (+PHP 300 winnings)
    
Round 3: Slot Machine
    [Spins reels, gets partial match...]
    Balance: PHP 1250 (-PHP 50 loss)
    
Balance Management: Player continues until balance depletes or chooses to exit

-------------------------------------------------------------------------------------------------------- 

## 🎬 Sample Output
Main Menu
==============================================================================================================================================================
            Balance: PHP1000.00
==============================================================================================================================================================
            Choose a game:
            1.  Dice Roll
            2.  Blackjack
            3.  Slot Machine
            4.  Color Game
            5.  Crazy Time
            6.  Roulette
            7.  Exit
--------------------------------------------------------------------------------------------------------------------------------------------------------------
Enter your choice: 
Game Logo Animation
      ::::::::: ::::::::::: ::::::::::: :::::::::  :::   ::: ::::::::::: ::::::::::          ::::::::      :::      :::::::: ::::::::::: ::::    :::  ::::::::
     :+:    :+:    :+:         :+:     :+:    :+: :+:   :+:     :+:     :+:                :+:    :+:   :+: :+:   :+:    :+:    :+:     :+:+:   :+: :+:    :+:
    +:+    +:+    +:+         +:+     +:+    +:+  +:+ +:+      +:+     +:+                +:+         +:+   +:+  +:+           +:+     :+:+:+  +:+ +:+    +:+
   +#++:++#+     +#+         +#+     +#++:++#+    +#++:       +#+     +#++:++#           +#+        +#++:++#++: +#++:++#++    +#+     +#+ +:+ +#+ +#+    +:+
  +#+    +#+    +#+         +#+     +#+    +#+    +#+        +#+     +#+                +#+        +#+     +#+        +#+    +#+     +#+  +#+#+# +#+    +#+
 #+#    #+#    #+#         #+#     #+#    #+#    #+#        #+#     #+#                #+#    #+# #+#     #+# #+#    #+#    #+#     #+#   #+#+# #+#    #+#
######### ###########     ###     #########     ###        ###     ##########          ########  ###     ###  ######## ########### ###    ####  #########

Tutorial Prompt
Would you like to view the tutorial for Dice Roll? (y/n): 

-------------------------------------------------------------------------------------------------------- 

## 👤 Author & Acknowledgement

### Development
Developed as a comprehensive Java educational project demonstrating OOP principles, design patterns, and game architecture.

### Information Table

| | Name | Role |
|----------|----------|----------|
| <img src="images/wyn.jpg" width="120">| Aguho, Alwynn L. | Lead Developer 1    |
|<img src="images/red.jpg" width="120">| Jamilano, John Red S. | Lead Developer 2    |
|<img src="images/nhel.jpg" width="120">| Cortuna, Nhel Edward B. |  UI Designer / Tester    |

---

## 📞 Support & Contribution

For bug reports, feature requests, or contributions, refer to the project repository on GitHub. 

---

## 🙏 Acknowledgements

### Special Thanks to Our Instructors
- **Ma'am Fatima** - For providing comprehensive lessons, templates, and resources shared through her Discord.
- **Sir Emmanuel** - For his dedicated lessons and continuous effort in teaching us whenever possible. His support and expertise greatly contributed to our understanding and development

### Learning Resources & Inspiration
- **YouTube Channels**: 
  - Bro Code - For comprehensive Java tutorials and best practices
  - Coding with Mosh - For clear programming concepts and design patterns
  - Other Indian Coding Tutorials - For diverse perspectives and innovative solutions
- **Stack Overflow** - For community support and solving countless technical challenges
- **Open-Source Community** - For shared knowledge and programming resources

### Personal Support
- **Our Parents** - For their unwavering support, encouragement, and belief in this project. This wouldn't have been possible without their sacrifices and dedication
- **Our Peers & Friends** - For playtesting, constructive feedback, and motivation throughout development

---

**Enjoy and learn how to gamble responsively with Bitbyte Casino!** 🃏🎰🎲
