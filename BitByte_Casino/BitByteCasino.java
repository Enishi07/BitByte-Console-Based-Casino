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
            System.out.println("==============================================================================================================================================================");
            System.out.printf("\t\t\t\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
            System.out.println("==============================================================================================================================================================");
            System.out.println("\t\t\t\t\t\t\t\tChoose a game:");
            System.out.println("\t\t\t\t\t\t\t\t1.  Dice Roll");
            System.out.println("\t\t\t\t\t\t\t\t2.  Blackjack");
            System.out.println("\t\t\t\t\t\t\t\t3.  Slot Machine");
            System.out.println("\t\t\t\t\t\t\t\t4.  Color Game");
            System.out.println("\t\t\t\t\t\t\t\t5.  Crazy Time");
            System.out.println("\t\t\t\t\t\t\t\t6.  Roulette");
            System.out.println("\t\t\t\t\t\t\t\t7.  Exit");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("\t\t\t\t\t\tEnter your choice: ");
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
                    System.out.println("\t\t\t\t\t .----------------.  .----------------.  .----------------.  .----------------.\r\n" + 
                        "\t\t\t\t\t| .--------------. || .--------------. || .--------------. || .--------------. |\r\n" + 
                        "\t\t\t\t\t| |  ________    | || |     _____    | || |     ______   | || |  _________   | |\r\n" + 
                        "\t\t\t\t\t| | |_   ___ `.  | || |    |_   _|   | || |   .' ___  |  | || | |_   ___  |  | |\r\n" + 
                        "\t\t\t\t\t| |   | |   `. \\ | || |      | |     | || |  / .'   \\_|  | || |   | |_  \\_|  | |\r\n" + 
                        "\t\t\t\t\t| |   | |    | | | || |      | |     | || |  | |         | || |   |  _|  _   | |\r\n" +
                        "\t\t\t\t\t| |  _| |___.' / | || |     _| |_    | || |  \\ `.___.'\\  | || |  _| |___/ |  | |\r\n" +
                        "\t\t\t\t\t| | |________.'  | || |    |_____|   | || |   `._____.'  | || | |_________|  | |\r\n" +
                        "\t\t\t\t\t| |              | || |              | || |              | || |              | |\r\n" +
                        "\t\t\t\t\t| '--------------' || '--------------' || '--------------' || '--------------' |\r\n" +
                        "\t\t\t\t\t '----------------'  '----------------'  '----------------'  '----------------' ");
                    System.out.println("==============================================================================================================================================================");
                    System.out.printf("\t\t\t\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("\t\t\t\t\t\t\t\t1. Start playing Dice Roll");
                    System.out.println("\t\t\t\t\t\t\t\t2. Exit to menu");
                    System.out.print("\t\t\t\t\t\tEnter your choice: ");
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

                    System.out.println("\t\t\t\t\t.------..------..------..------..------..------..------..------..------.\r\n" + 
                        "\t\t\t\t\t|B.--. ||L.--. ||A.--. ||C.--. ||K.--. ||J.--. ||A.--. ||C.--. ||K.--. |\r\n" + 
                        "\t\t\t\t\t| :(): || :/\\: || (\\/) || :/\\: || :/\\: || :(): || (\\/) || :/\\: || :/\\: |\r\n" + 
                        "\t\t\t\t\t| ()() || (__) || :\\/: || :\\/: || :\\/: || ()() || :\\/: || :\\/: || :\\/: |\r\n" + 
                        "\t\t\t\t\t| '--'B|| '--'L|| '--'A|| '--'C|| '--'K|| '--'J|| '--'A|| '--'C|| '--'K|\r\n" + 
                        "\t\t\t\t\t`------'`------'`------'`------'`------'`------'`------'`------'`------'");
                    System.out.println("==============================================================================================================================================================");
                    System.out.printf("\t\t\t\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("\t\t\t\t\t\t\t\t1. Start playing BlackJack");
                    System.out.println("\t\t\t\t\t\t\t\t2. Exit to menu");
                    System.out.print("\t\t\t\t\t\tEnter your choice: ");
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

                    System.out.println("\t\t ______     __         ______     ______      __    __     ______     ______     __  __     __     __   __     ______\r\n" + 
                        "\t\t/\\  ___\\   /\\ \\       /\\  __ \\   /\\__  _\\    /\\ \"-./  \\   /\\  __ \\   /\\  ___\\   /\\ \\_\\ \\   /\\ \\   /\\ \"-.\\ \\   /\\  ___\\ \r\n" + 
                        "\t\t\\ \\___  \\  \\ \\ \\____  \\ \\ \\/\\ \\  \\/_/\\ \\/    \\ \\ \\-./\\ \\  \\ \\  __ \\  \\ \\ \\____  \\ \\  __ \\  \\ \\ \\  \\ \\ \\-.  \\  \\ \\  __\\ \r\n" + 
                        "\t\t \\/\\_____\\  \\ \\_____\\  \\ \\_____\\    \\ \\_\\     \\ \\_\\ \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\  \\ \\_\\\\\"\\_\\  \\ \\_____\\\r\n" + 
                        "\t\t  \\/_____/   \\/_____/   \\/_____/     \\/_/      \\/_/  \\/_/   \\/_/\\/_/   \\/_____/   \\/_/\\/_/   \\/_/   \\/_/ \\/_/   \\/_____/ ");
                    System.out.println("==============================================================================================================================================================");
                    System.out.printf("\t\t\t\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("\t\t\t\t\t\t\t\t1. Start playing Slot Machine");
                    System.out.println("\t\t\t\t\t\t\t\t2. Exit to menu");
                    System.out.print("\t\t\t\t\t\tEnter your choice: ");
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
                    System.out.println("\t\t\t\t a88888b.          dP                       .88888.                       88888888b\r\n" + 
                        "\t\t\t\td8'   `88          88                      d8'   `88                      88\r\n" + 
                        "\t\t\t\t88        .d8888b. 88 .d8888b. 88d888b.    88        .d8888b. 88d8b.d8b. a88aaaa\r\n" + 
                        "\t\t\t\t88        88'  `88 88 88'  `88 88'  `88    88   YP88 88'  `88 88'`88'`88  88\r\n" + 
                        "\t\t\t\tY8.   .88 88.  .88 88 88.  .88 88          Y8.   .88 88.  .88 88  88  88  88\r\n" + 
                        "\t\t\t\t Y88888P' `88888P' dP `88888P' dP           `88888'  `88888P8 dP  dP  dP  88888888P\r\n" + 
                        "\t\t\t\toooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
                    System.out.println("==============================================================================================================================================================");
                    System.out.printf("\t\t\t\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("\t\t\t\t\t\t\t\t1. Start playing Slot Machine");
                    System.out.println("\t\t\t\t\t\t\t\t2. Exit to menu");
                    System.out.print("\t\t\t\t\t\tEnter your choice: ");
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
                    System.out.print("Would you like to view the tutorial for Crazy Time? (y/n): ");
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showCrazyTimeTutorial();
                    }
                    System.out.println("\t\t\t\t                                                          d8,\r\n" +
                        "\t\t\t\t                                                   d8P   `8P\r\n" +
                        "\t\t\t\t                                                d888888P\r\n" +
                        "\t\t\t\t d8888b  88bd88b d888b8b  d88888P ?88   d8P       ?88'    88b  88bd8b,d88b  d8888b\r\n" +
                        "\t\t\t\td8P' `P  88P'  `d8P' ?88     d8P' d88   88        88P     88P  88P'`?8P'?8bd8b_,dP\r\n" +
                        "\t\t\t\t88b     d88     88b  ,88b  d8P'   ?8(  d88        88b    d88  d88  d88  88P88b\r\n" +
                        "\t\t\t\t`?888P'd88'     `?88P'`88bd88888P'`?88P'?8b       `?8b  d88' d88' d88'  88b`?888P'\r\n" +
                        "\t\t\t\t                                         )88\r\n" +
                        "\t\t\t\t                                        ,d8P\r\n" +
                        "\t\t\t\t                                     `?888P'");
                    System.out.println("==============================================================================================================================================================");
                    System.out.printf("\t\t\t\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("\t\t\t\t\t\t\t\t1. Start playing Crazy Time");
                    System.out.println("\t\t\t\t\t\t\t\t2. Exit to menu");
                    System.out.print("\t\t\t\t\t\tEnter your choice: ");
                    int startChoice = sc.nextInt();
                    System.out.println("");
                    if (startChoice == 1) {
                        balance = crazyTime.play(balance);
                    } else if (startChoice == 2) {
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                }
                    
                
                case 6 -> {
                     System.out.print("Would you like to view the tutorial for Black Roulette? (y/n): ");
                     String viewTutorial = sc.next();
                    System.out.println("");
                     if (viewTutorial.equalsIgnoreCase("y")) {
                         Tutorial.showRouletteTutorial();
                     }

                    System.out.println("\t\t\t _______   __                      __              _______                       __             __      __ \r\n" + 
                        "\t\t\t|       \\ |  \\                    |  \\            |       \\                     |  \\           |  \\    |  \\\r\n" + 
                        "\t\t\t| $$$$$$$\\| $$  ______    _______ | $$   __       | $$$$$$$\\  ______   __    __ | $$  ______  _| $$_  _| $$_     ______\r\n" + 
                        "\t\t\t| $$__/ $$| $$ |      \\  /       \\| $$  /  \\      | $$__| $$ /      \\ |  \\  |  \\| $$ /      \\|   $$ \\|   $$ \\   /      \\\r\n" + 
                        "\t\t\t| $$    $$| $$  \\$$$$$$\\|  $$$$$$$| $$_/  $$      | $$    $$|  $$$$$$\\| $$  | $$| $$|  $$$$$$\\\\$$$$$$ \\$$$$$$  |  $$$$$$\\\r\n" + 
                        "\t\t\t| $$$$$$$\\| $$ /      $$| $$      | $$   $$       | $$$$$$$\\| $$  | $$| $$  | $$| $$| $$    $$ | $$ __ | $$ __ | $$    $$\r\n" + 
                        "\t\t\t| $$__/ $$| $$|  $$$$$$$| $$_____ | $$$$$$\\       | $$  | $$| $$__/ $$| $$__/ $$| $$| $$$$$$$$ | $$|  \\| $$|  \\| $$$$$$$$\r\n" + 
                        "\t\t\t| $$    $$| $$ \\$$    $$ \\$$     \\| $$  \\$$\\      | $$  | $$ \\$$    $$ \\$$    $$| $$ \\$$     \\  \\$$  $$ \\$$  $$ \\$$     \\\r\n" + 
                        "\t\t\t \\$$$$$$$  \\$$  \\$$$$$$$  \\$$$$$$$ \\$$   \\$$       \\$$   \\$$  \\$$$$$$   \\$$$$$$  \\$$  \\$$$$$$$   \\$$$$   \\$$$$   \\$$$$$$$");
                    
                    System.out.println("==============================================================================================================================================================");
                    System.out.printf("\t\t\t\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("\t\t\t\t\t\t\t\t1. Start playing Black Roulette");
                    System.out.println("\t\t\t\t\t\t\t\t2. Exit to menu");
                    System.out.print("\t\t\t\t\t\tEnter your choice: ");
                    int startChoice = sc.nextInt();
                    System.out.println("");
                    if (startChoice == 1) {
                        balance = rouletteGame.play(balance);
                    } else if (startChoice == 2) {
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                    
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

