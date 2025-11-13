import Tutorial.Tutorial;
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
        CrazyTimeGame crazyTime = new CrazyTimeGame();
        System.out.println(" /$$$$$$$  /$$   /$$     /$$$$$$$              /$$                      /$$$$$$                      /$$\r\n" + 
                        "| $$__  $$|__/  | $$    | $$__  $$            | $$                     /$$__  $$                    |__/\r\n" + 
                        "| $$  \\ $$ /$$ /$$$$$$  | $$  \\ $$ /$$   /$$ /$$$$$$    /$$$$$$       | $$  \\__/  /$$$$$$   /$$$$$$$ /$$ /$$$$$$$   /$$$$$$\\ \r\n" + 
                        "| $$$$$$$ | $$|_  $$_/  | $$$$$$$ | $$  | $$|_  $$_/   /$$__  $$      | $$       |____  $$ /$$_____/| $$| $$__  $$ /$$__  $$\r\n" + 
                        "| $$__  $$| $$  | $$    | $$__  $$| $$  | $$  | $$    | $$$$$$$$      | $$        /$$$$$$$|  $$$$$$ | $$| $$  \\ $$| $$  \\ $$\r\n" + 
                        "| $$  \\ $$| $$  | $$ /$$| $$  \\ $$| $$  | $$  | $$ /$$| $$_____/      | $$    $$ /$$__  $$ \\____  $$| $$| $$  | $$| $$  | $$\r\n" +
                        "| $$$$$$$/| $$  |  $$$$/| $$$$$$$/|  $$$$$$$  |  $$$$/|  $$$$$$$      |  $$$$$$/|  $$$$$$$ /$$$$$$$/| $$| $$  | $$|  $$$$$$/\r\n" +
                        "|_______/ |__/   \\___/  |_______/  \\____  $$   \\___/   \\_______/       \\______/  \\_______/|_______/ |__/|__/  |__/ \\______/\r\n" +
                        "                                   /$$  | $$                                                        \r\n" +
                        "                                  |  $$$$$$/                                                        \r\n" +
                        "                                   \\______/                                                         ");
        
        do {
            System.out.println("==============================================================================================");
            System.out.printf("\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
            System.out.println("==============================================================================================");
            System.out.println("\t\t\t\t\tChoose a game:");
            System.out.println("\t\t\t\t\t1.  Dice Roll");
            System.out.println("\t\t\t\t\t2.  Blackjack");
            System.out.println("\t\t\t\t\t3.  Slot Machine");
            System.out.println("\t\t\t\t\t4.  Color Game");
            System.out.println("\t\t\t\t\t5.  Crazy Time");
            System.out.println("\t\t\t\t\t6.  Exit");
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.print("\t\t\tEnter your choice: ");
            choice = sc.nextInt();
            System.out.println("");

            switch (choice) {
                case 1 -> {
                    System.out.print("Would you like to view the tutorial for Dice Roll? (y/n): ");
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showDiceTutorial();
                    }
                    balance = dice.play(balance);
                }
                case 2 -> {
                    System.out.print("Would you like to view the tutorial for Blackjack? (y/n): ");
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showBlackjackTutorial();
                    }
                    balance = blackjack.play(balance);
                }
                case 3 -> {
                    System.out.print("Would you like to view the tutorial for Slot Machine? (y/n): ");
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showSlotMachineTutorial();
                    }
                    balance = slots.play(balance);
                }
                case 4 -> {
                    System.out.print("Would you like to view the tutorial for Color Game? (y/n): ");
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showColorGameTutorial();
                    }
                    balance = colorGame.play(balance);
                }
                case 5 -> {
                    balance = crazyTime.play(balance);
                }
                case 6 -> System.out.printf("Thanks for playing! Final balance: PHP%.2f" , balance);
                default -> System.out.println("Invalid choice!");
            }

            if (balance <= 0) {
                System.out.println("You're out of money! Game over.");
                break;
            }

        } while (choice != 6);

        sc.close();
    }
}

