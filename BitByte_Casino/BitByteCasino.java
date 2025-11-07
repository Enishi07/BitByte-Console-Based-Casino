import java.util.Scanner;

// Main Casino Application (keeps only the public entry point here)
public class BitByteCasino {
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
            System.out.println("3. � Slot Machine");
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

