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

        System.out.println(" Welcome to the Mini Java Casino! ");

        System.out.println("__________.__  __ __________          __           _________               .__               \r\n" + //
                        "\\______   \\__|/  |\\______   \\___.__._/  |_  ____   \\_   ___ \\_____    _____|__| ____   ____  \r\n" + //
                        " |    |  _/  \\   __\\    |  _<   |  |\\   __\\/ __ \\  /    \\  \\/\\__  \\  /  ___/  |/    \\ /  _ \\ \r\n" + //
                        " |    |   \\  ||  | |    |   \\\\___  | |  | \\  ___/  \\     \\____/ __ \\_\\___ \\|  |   |  (  <_> )\r\n" + //
                        " |______  /__||__| |______  // ____| |__|  \\___  >  \\______  (____  /____  >__|___|  /\\____/ \r\n" + //
                        "        \\/                \\/ \\/                \\/          \\/     \\/     \\/        \\/        ");
        
        do {
            System.out.println("==============================================================================================");
            System.out.printf("\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
            System.out.println("==============================================================================================");
            System.out.println("\t\t\t\t\tChoose a game:");
            System.out.println("\t\t\t\t\t1.  Dice Roll");
            System.out.println("\t\t\t\t\t2.  Blackjack");
            System.out.println("\t\t\t\t\t3.  Slot Machine");
            System.out.println("\t\t\t\t\t4.  Color Game");
            System.out.println("\t\t\t\t\t5.  Exit");
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.print("\t\t\tEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> balance = dice.play(balance);
                case 2 -> balance = blackjack.play(balance);
                case 3 -> balance = slots.play(balance);
                case 4 -> balance = colorGame.play(balance);
                case 5 -> System.out.printf("Thanks for playing! Final balance: PHP%.2f" , balance);
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

