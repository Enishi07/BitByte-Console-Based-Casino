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
                    System.out.println(" .----------------.  .----------------.  .----------------.  .----------------.\r\n" + 
                        "| .--------------. || .--------------. || .--------------. || .--------------. |\r\n" + 
                        "| |  ________    | || |     _____    | || |     ______   | || |  _________   | |\r\n" + 
                        "| | |_   ___ `.  | || |    |_   _|   | || |   .' ___  |  | || | |_   ___  |  | |\r\n" + 
                        "| |   | |   `. \\ | || |      | |     | || |  / .'   \\_|  | || |   | |_  \\_|  | |\r\n" + 
                        "| |   | |    | | | || |      | |     | || |  | |         | || |   |  _|  _   | |\r\n" +
                        "| |  _| |___.' / | || |     _| |_    | || |  \\ `.___.'\\  | || |  _| |___/ |  | |\r\n" +
                        "| | |________.'  | || |    |_____|   | || |   `._____.'  | || | |_________|  | |\r\n" +
                        "| |              | || |              | || |              | || |              | |\r\n" +
                        "| '--------------' || '--------------' || '--------------' || '--------------' |\r\n" +
                        " '----------------'  '----------------'  '----------------'  '----------------' ");
                    System.out.println("1. Start playing Dice Roll");
                    System.out.println("2. Exit to menu");
                    System.out.print("Enter your choice: ");
                    int startChoice = sc.nextInt();
                    System.out.println("");
                    if (startChoice == 1) {
                        balance = dice.play(balance);
                    } else if (startChoice == 2) {
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                }
                case 2 -> {
                    System.out.print("Would you like to view the tutorial for Blackjack? (y/n): ");
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showBlackjackTutorial();
                    }

                    System.out.println(".------..------..------..------..------..------..------..------..------.\r\n" + 
                        "|B.--. ||L.--. ||A.--. ||C.--. ||K.--. ||J.--. ||A.--. ||C.--. ||K.--. |\r\n" + 
                        "| :(): || :/\\: || (\\/) || :/\\: || :/\\: || :(): || (\\/) || :/\\: || :/\\: |\r\n" + 
                        "| ()() || (__) || :\\/: || :\\/: || :\\/: || ()() || :\\/: || :\\/: || :\\/: |\r\n" + 
                        "| '--'B|| '--'L|| '--'A|| '--'C|| '--'K|| '--'J|| '--'A|| '--'C|| '--'K|\r\n" + 
                        "`------'`------'`------'`------'`------'`------'`------'`------'`------'");
                    System.out.println("1. Start playing Blackjack");
                    System.out.println("2. Exit to menu");
                    System.out.print("Enter your choice: ");
                    int startChoice = sc.nextInt();
                    System.out.println("");
                    if (startChoice == 1) {
                        balance = blackjack.play(balance);
                    } else if (startChoice == 2) {
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                }
                case 3 -> {
                    System.out.print("Would you like to view the tutorial for Slot Machine? (y/n): ");
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showSlotMachineTutorial();
                    }

                    System.out.println(" ______     __         ______     ______      __    __     ______     ______     __  __     __     __   __     ______\r\n" + 
                        "/\\  ___\\   /\\ \\       /\\  __ \\   /\\__  _\\    /\\ \"-./  \\   /\\  __ \\   /\\  ___\\   /\\ \\_\\ \\   /\\ \\   /\\ \"-.\\ \\   /\\  ___\\ \r\n" + 
                        "\\ \\___  \\  \\ \\ \\____  \\ \\ \\/\\ \\  \\/_/\\ \\/    \\ \\ \\-./\\ \\  \\ \\  __ \\  \\ \\ \\____  \\ \\  __ \\  \\ \\ \\  \\ \\ \\-.  \\  \\ \\  __\\ \r\n" + 
                        " \\/\\_____\\  \\ \\_____\\  \\ \\_____\\    \\ \\_\\     \\ \\_\\ \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\  \\ \\_\\\\\"\\_\\  \\ \\_____\\\r\n" + 
                        "  \\/_____/   \\/_____/   \\/_____/     \\/_/      \\/_/  \\/_/   \\/_/\\/_/   \\/_____/   \\/_/\\/_/   \\/_/   \\/_/ \\/_/   \\/_____/ ");
                    System.out.println("1. Start playing Slot Machine");
                    System.out.println("2. Exit to menu");
                    System.out.print("Enter your choice: ");
                    int startChoice = sc.nextInt();
                    System.out.println("");
                    if (startChoice == 1) {
                        balance = slots.play(balance);
                    } else if (startChoice == 2) {
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                }
                case 4 -> {
                    System.out.print("Would you like to view the tutorial for Color Game? (y/n): ");
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showColorGameTutorial();
                    }

                    System.out.println("      _____           _____     ____                _____         _____         _____           ____        ______  _______        ______  \r\n" + 
                        "  ___|\\    \\     ____|\\    \\   |    |          ____|\\    \\    ___|\\    \\    ___|\\    \\     ____|\\   \\      |      \\/       \\   ___|\\     \\ \r\n" + 
                        " /    /\\    \\   /     /\\    \\  |    |         /     /\\    \\  |    |\\    \\  /    /\\    \\   /    /\\    \\    /          /\\     \\ |     \\     \\ \r\n" + 
                        "|    |  |    | /     /  \\    \\ |    |        /     /  \\    \\ |    | |    ||    |  |____| |    |  |    |  /     /\\   / /\\     ||     ,_____/|\r\n" + 
                        "|    |  |____||     |    |    ||    |  ____ |     |    |    ||    |/____/ |    |    ____ |    |__|    | /     /\\ \\_/ / /    /||     \\--'\\_|/\r\n" + 
                        "|    |   ____ |     |    |    ||    | |    ||     |    |    ||    |\\    \\ |    |   |    ||    .--.    ||     |  \\|_|/ /    / ||     /___/|\r\n" + 
                        "|    |  |    ||\\     \\  /    /||    | |    ||\\     \\  /    /||    | |    ||    |   |_,  ||    |  |    ||     |       |    |  ||     \\____|\\\r\n" + 
                        "|\\ ___\\/    /|| \\_____\\/____/ ||____|/____/|| \\_____\\/____/ ||____| |____||\\ ___\\___/  /||____|  |____||\\____\\       |____|  /|____ '     /|\r\n" + 
                        "| |   /____/ | \\ |    ||    | /|    |     || \\ |    ||    | /|    | |    || |   /____ / ||    |  |    || |    |      |    | / |    /_____/ |\r\n" +
                        " \\|___|    | /  \\|____||____|/ |____|_____|/  \\|____||____|/ |____| |____| \\|___|    | / |____|  |____| \\|____|      |____|/  |____|     | /\r\n" +
                        "   \\( |____|/      \\(    )/      \\(    )/        \\(    )/      \\(     )/     \\( |____|/    \\(      )/      \\(          )/       \\( |_____|/ \r\n" +
                        "   '   )/          '    '        '    '          '    '        '     '       '   )/        '      '        '          '         '    )/ \r\n" +
                        "        '                                                                         '                                                   '");
                    System.out.println("1. Start playing Color Game");
                    System.out.println("2. Exit to menu");
                    System.out.print("Enter your choice: ");
                    int startChoice = sc.nextInt();
                    System.out.println("");
                    if (startChoice == 1) {
                        balance = colorGame.play(balance);
                    } else if (startChoice == 2) {
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
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

