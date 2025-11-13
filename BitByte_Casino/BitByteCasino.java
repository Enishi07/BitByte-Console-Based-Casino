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
        BlackRedRouletteGame rouletteGame = new BlackRedRouletteGame();

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
        System.out.println("      ::::::::: ::::::::::: ::::::::::: :::::::::  :::   ::: ::::::::::: ::::::::::          ::::::::      :::      :::::::: ::::::::::: ::::    :::  ::::::::\r\n" + 
                        "     :+:    :+:    :+:         :+:     :+:    :+: :+:   :+:     :+:     :+:                :+:    :+:   :+: :+:   :+:    :+:    :+:     :+:+:   :+: :+:    :+: \r\n" + 
                        "    +:+    +:+    +:+         +:+     +:+    +:+  +:+ +:+      +:+     +:+                +:+         +:+   +:+  +:+           +:+     :+:+:+  +:+ +:+    +:+\r\n" + 
                        "   +#++:++#+     +#+         +#+     +#++:++#+    +#++:       +#+     +#++:++#           +#+        +#++:++#++: +#++:++#++    +#+     +#+ +:+ +#+ +#+    +:+\r\n" + 
                        "  +#+    +#+    +#+         +#+     +#+    +#+    +#+        +#+     +#+                +#+        +#+     +#+        +#+    +#+     +#+  +#+#+# +#+    +#+\r\n" + 
                        " #+#    #+#    #+#         #+#     #+#    #+#    #+#        #+#     #+#                #+#    #+# #+#     #+# #+#    #+#    #+#     #+#   #+#+# #+#    #+#\r\n" + 
                        "######### ###########     ###     #########     ###        ###     ##########          ########  ###     ###  ######## ########### ###    ####  ########");
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
            System.out.println("\t\t\t\t\t6.  Roulette");
            System.out.println("\t\t\t\t\t7.  Exit");
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
                    balance = colorGame.play(balance);
                }

                case 5 -> {
                    // System.out.print("Would you like to view the tutorial for Color Game? (y/n): ");
                    // String viewTutorial = sc.next();
                    System.out.println("                                                          d8,\r\n" + 
                        "                                                   d8P   `8P\r\n" + 
                        "                                                d888888P\r\n" + 
                        " d8888b  88bd88b d888b8b  d88888P ?88   d8P       ?88'    88b  88bd8b,d88b  d8888b\r\n" + 
                        "d8P' `P  88P'  `d8P' ?88     d8P' d88   88        88P     88P  88P'`?8P'?8bd8b_,dP\r\n" + 
                        "88b     d88     88b  ,88b  d8P'   ?8(  d88        88b    d88  d88  d88  88P88b\r\n" + 
                        "`?888P'd88'     `?88P'`88bd88888P'`?88P'?8b       `?8b  d88' d88' d88'  88b`?888P'\r\n" + 
                        "                                         )88\r\n" + 
                        "                                        ,d8P\r\n" + 
                        "                                     `?888P'");
                    
                    System.out.println("Comming Soon!");
                    // if (viewTutorial.equalsIgnoreCase("y")) {
                    //     Tutorial.showColorGameTutorial();
                    }
                    
                
                case 6 -> {
                     System.out.print("Would you like to view the tutorial for Color Game? (y/n): ");
                     String viewTutorial = sc.next();
                    System.out.println(" _______   __                      __              _______                       __             __      __ \r\n" + 
                        "|       \\ |  \\                    |  \\            |       \\                     |  \\           |  \\    |  \\\r\n" + 
                        "| $$$$$$$\\| $$  ______    _______ | $$   __       | $$$$$$$\\  ______   __    __ | $$  ______  _| $$_  _| $$_     ______\r\n" + 
                        "| $$__/ $$| $$ |      \\  /       \\| $$  /  \\      | $$__| $$ /      \\ |  \\  |  \\| $$ /      \\|   $$ \\|   $$ \\   /      \\\r\n" + 
                        "| $$    $$| $$  \\$$$$$$\\|  $$$$$$$| $$_/  $$      | $$    $$|  $$$$$$\\| $$  | $$| $$|  $$$$$$\\\\$$$$$$ \\$$$$$$  |  $$$$$$\\\r\n" + 
                        "| $$$$$$$\\| $$ /      $$| $$      | $$   $$       | $$$$$$$\\| $$  | $$| $$  | $$| $$| $$    $$ | $$ __ | $$ __ | $$    $$\r\n" + 
                        "| $$__/ $$| $$|  $$$$$$$| $$_____ | $$$$$$\\       | $$  | $$| $$__/ $$| $$__/ $$| $$| $$$$$$$$ | $$|  \\| $$|  \\| $$$$$$$$\r\n" + 
                        "| $$    $$| $$ \\$$    $$ \\$$     \\| $$  \\$$\\      | $$  | $$ \\$$    $$ \\$$    $$| $$ \\$$     \\  \\$$  $$ \\$$  $$ \\$$     \\\r\n" + 
                        " \\$$$$$$$  \\$$  \\$$$$$$$  \\$$$$$$$ \\$$   \\$$       \\$$   \\$$  \\$$$$$$   \\$$$$$$  \\$$  \\$$$$$$$   \\$$$$   \\$$$$   \\$$$$$$$");
                    System.out.println("");
                     if (viewTutorial.equalsIgnoreCase("y")) {
                         Tutorial.showRouletteTutorial();
                     }
                    balance = rouletteGame.play(balance);
                }

                case 7 -> System.out.printf("Thanks for playing! Final balance: PHP%.2f" , balance);
                default -> System.out.println("Invalid choice!");
            }

            if (balance <= 0) {
                System.out.println("You're out of money! Game over.");
                break;
            }

        } while (choice != 7);

        sc.close();
    }
}

