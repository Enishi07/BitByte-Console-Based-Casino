import java.util.Random;
import java.util.Scanner;

// Base class for all games
abstract class CasinoGame {
    protected Scanner sc = new Scanner(System.in);
    protected Random rand = new Random();

    // ✅ Universal clear screen method
    protected void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Fallback (just print blank lines)
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public abstract double play(double balance);
}

// 🎲 Dice Roll Game
class DiceGame extends CasinoGame {
    @Override
    public double play(double balance) {
        System.out.print("Enter your bet: PHP");
        double bet = sc.nextDouble();
        if (bet > balance) {
            System.out.println("Not enough balance!");
            return balance;
        }

        int playerRoll = rand.nextInt(6) + 1;
        int computerRoll = rand.nextInt(6) + 1;

        System.out.println("You rolled: " + playerRoll);
        System.out.println("Dealer rolled: " + computerRoll);

        if (playerRoll > computerRoll) {
            System.out.println("You win PHP" + bet + "!");
            balance += bet;
        } else if (playerRoll < computerRoll) {
            System.out.println("You lose PHP" + bet + ".");
            balance -= bet;
        } else {
            System.out.println("It's a tie!");
        }

        return balance;
    }
}

// 🃏 Blackjack Game
// 🃏 Enhanced Blackjack Game (Real Rules)
class BlackjackGame extends CasinoGame {
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String[] suits = {"♠", "♥", "♦", "♣"};

    // ✅ FIXED: Safe value extraction (handles "8♣" or "10♦" properly)
    private int getCardValue(String card) {
        // remove suit symbols, keep only rank
        String rank = card.replaceAll("[^A0-9JQK]", "");

        switch (rank) {
            case "A": return 11;
            case "J":
            case "Q":
            case "K": return 10;
            default: return Integer.parseInt(rank);
        }
    }

    private int calculateTotal(java.util.List<String> hand) {
        int total = 0;
        int aces = 0;
        for (String card : hand) {
            int value = getCardValue(card);
            total += value;
            if (card.startsWith("A")) aces++;
        }
        // Adjust Aces if total > 21
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

    private void printHand(String owner, java.util.List<String> hand) {
        System.out.println(owner + " hand: " + String.join("  ", hand) + " (Total: " + calculateTotal(hand) + ")");
    }

    private String drawCard() {
        return ranks[rand.nextInt(ranks.length)] + suits[rand.nextInt(suits.length)];
    }

    @Override
    public double play(double balance) {
        System.out.print("Enter your bet: PHP");
        double bet = sc.nextDouble();
        if (bet > balance) {
            System.out.println("Not enough balance!");
            return balance;
        }

        // Deal initial hands
        java.util.List<String> playerHand = new java.util.ArrayList<>();
        java.util.List<String> dealerHand = new java.util.ArrayList<>();

        playerHand.add(drawCard());
        playerHand.add(drawCard());
        dealerHand.add(drawCard());
        dealerHand.add(drawCard());

        System.out.println("\nDealer's hand: " + dealerHand.get(0) + " [Hidden]");
        printHand("Your", playerHand);

        // Check for blackjack
        if (calculateTotal(playerHand) == 21) {
            if (calculateTotal(dealerHand) == 21) {
                System.out.println("Both you and the dealer have Blackjack! Push!");
                return balance;
            } else {
                System.out.println("🎉 Blackjack! You win PHP" + (bet * 1.5) + "!");
                return balance + bet * 1.5;
            }
        }

        // Player's turn
        boolean playerBust = false;
        boolean doubled = false;

        while (true) {
            System.out.println("\nChoose action:");
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            System.out.println("3. Double Down");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) { // Hit
                playerHand.add(drawCard());
                printHand("Your", playerHand);
                if (calculateTotal(playerHand) > 21) {
                    System.out.println("💥 You bust!");
                    playerBust = true;
                    break;
                }
            } else if (choice == 2) { // Stand
                break;
            } else if (choice == 3) { // Double Down
                if (balance < bet * 2) {
                    System.out.println("Not enough balance to double down!");
                    continue;
                }
                bet *= 2;
                playerHand.add(drawCard());
                printHand("Your", playerHand);
                doubled = true;
                if (calculateTotal(playerHand) > 21) {
                    System.out.println("💥 You bust!");
                    playerBust = true;
                }
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        // Dealer's turn
        if (!playerBust) {
            System.out.println("\nDealer reveals their hand...");
            printHand("Dealer's", dealerHand);

            while (calculateTotal(dealerHand) < 17) {
                System.out.println("Dealer hits...");
                dealerHand.add(drawCard());
                printHand("Dealer's", dealerHand);
            }

            int playerTotal = calculateTotal(playerHand);
            int dealerTotal = calculateTotal(dealerHand);

            System.out.println("\nYour total: " + playerTotal);
            System.out.println("Dealer's total: " + dealerTotal);

            if (dealerTotal > 21) {
                System.out.println("Dealer busts! You win ₱" + bet + "!");
                balance += bet;
            } else if (playerTotal > dealerTotal) {
                System.out.println("You win PHP" + bet + "!");
                balance += bet;
            } else if (playerTotal < dealerTotal) {
                System.out.println("You lose PHP" + bet + ".");
                balance -= bet;
            } else {
                System.out.println("Push! No one wins.");
            }
        } else {
            balance -= bet;
        }

        return balance;
    }
}



// 🎰 Slot Machine Game (Animated + Clean Screen)
class SlotMachineGame extends CasinoGame {
    @Override
    public double play(double balance) {
        System.out.print("Enter your bet: PHP");
        double bet = sc.nextDouble();
        if (bet > balance) {
            System.out.println("Not enough balance!");
            return balance;
        }
        else if (bet <= 0 || bet > balance) {}

        String[] symbols = {"^_^", "o_o", "O_O", ">:)", "T_T"};
        String s1 = "", s2 = "", s3 = "";

        System.out.println("\nSpinning...");
        try {
            // 🎞️ Spin animation (with screen refresh)
            for (int i = 0; i < 12; i++) {
                s1 = symbols[rand.nextInt(symbols.length)];
                s2 = symbols[rand.nextInt(symbols.length)];
                s3 = symbols[rand.nextInt(symbols.length)];
                clearScreen();
                printMachine(s1, s2, s3);
                Thread.sleep(120 + i * 10); // Gradually slow down
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final spin result
        s1 = symbols[rand.nextInt(symbols.length)];
        s2 = symbols[rand.nextInt(symbols.length)];
        s3 = symbols[rand.nextInt(symbols.length)];

        clearScreen();
        printMachine(s1, s2, s3);
        System.out.println();

        // Outcome
        if (s1.equals(s2) && s2.equals(s3)) {
            System.out.println("🎉 JACKPOT! You win PHP" + (bet * 5) + "!");
            balance += bet * 5;
        } else if (s1.equals(s2) || s2.equals(s3) || s1.equals(s3)) {
            System.out.println("⭐ Nice! You win PHP" + (bet * 2) + "!");
            balance += bet * 2;
        } else {
            System.out.println("You lose PHP" + bet + ".");
            balance -= bet;
        }

        return balance;
    }

    // 🧱 Slot machine
    private void printMachine(String s1, String s2, String s3) {
        System.out.println("                    ___                     ");
        System.out.println("          ___#####################___       ");
        System.out.println("          ###@@@@@@@@@@@@@@@@@@@@@###       ");
        System.out.println("              ________________               ");
        System.out.println("             |##|           |##|    ####    ");
        System.out.println("             |##|" + s1 + " " + s2 + " " + s3 + "|##|    ----    ");
        System.out.println("             |##|___________|##|    ||||    ");
        System.out.println("             |#################|   |||||    ");
        System.out.println("             |#################|   |||||    ");
        System.out.println("              -----------------     ---     ");
        System.out.println("          ___#####   ██   #####___           ");
        System.out.println("        ###@@@@@@@@@@@@@@@@@@@@@@###         ");
        System.out.println("        |@@@@@@@@@@@@@@@@@@@@@@@@@@|         ");
        System.out.println("        ###@@@@@@@@@@@@@@@@@@@@@@###         ");
        System.out.println("            ---------------------           ");
    }
}

// 🎨 Philippine Color Game
class ColorGame extends CasinoGame {
    @Override
    public double play(double balance) {
        System.out.print("Enter your bet: PHP");
        double bet = sc.nextDouble();
        if (bet > balance) {
            System.out.println("Not enough balance!");
            return balance;
        }

        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        int choice;
        do {
            System.out.println("Choose a color:");
            System.out.println("1. Red");
            System.out.println("2. Blue");
            System.out.println("3. Green");
            System.out.println("4. Yellow");
            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice! Please choose 1-4.");
            }
        } while (choice < 1 || choice > 4);

        String playerColor = colors[choice - 1];
        String spunColor = colors[rand.nextInt(colors.length)];
        System.out.println("Spinning the wheel...");
        System.out.println("The wheel landed on: " + spunColor);

        if (playerColor.equals(spunColor)) {
            double winnings = bet * 3;
            System.out.println("You win PHP" + winnings + "!");
            balance += winnings;
        } else {
            System.out.println("You lose PHP" + bet + ".");
            balance -= bet;
        }

        return balance;
    }
}

// 💼 Main Casino Application
public class CasinoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000.0;
        int choice;

        DiceGame dice = new DiceGame();
        BlackjackGame blackjack = new BlackjackGame();
        SlotMachineGame slots = new SlotMachineGame();
        ColorGame colorGame = new ColorGame();

        System.out.println("🎰 Welcome to the Mini Java Casino! 🎰");
        do {
            System.out.println("\nBalance: PHP" + balance);
            System.out.println("Choose a game:");
            System.out.println("1. 🎲 Dice Roll");
            System.out.println("2. 🃏 Blackjack");
            System.out.println("3. 🎰 Slot Machine");
            System.out.println("4. 🎨 Color Game");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> balance = dice.play(balance);
                case 2 -> balance = blackjack.play(balance);
                case 3 -> balance = slots.play(balance);
                case 4 -> balance = colorGame.play(balance);
                case 5 -> System.out.println("Thanks for playing! Final balance: ₱" + balance);
                default -> System.out.println("Invalid choice!");
            }

            if (balance <= 0) {
                System.out.println("You're out of money! Game over.");
                break;
            }

        } while (choice != 5);

        sc.close();
    }
}
