import Tutorial.Tutorial;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

// Main Casino Application (keeps only the public entry point here)
public class BitByteCasino {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            // Fallback (just print blank lines)
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
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

        AtomicBoolean skipIntro = new AtomicBoolean(false);
        Thread inputThread = new Thread(() -> {
            try {
                int ch;
                while ((ch = System.in.read()) != -1) {
                    if (ch == '\n' || ch == '\r') {
                        skipIntro.set(true);
                        break;
                    }
                }
            } catch (Exception ex) {
                // ignore
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();

        clearScreen();

        if (!skipIntro.get()) {
            // Producer text with typing effect
            String producerText = "Produced by Mindoro Plus +";
            int consoleWidth = 120; // Approximate console width
            for (int i = 0; i < producerText.length(); i++) {
                if (skipIntro.get()) break;
                String currentText = producerText.substring(0, i + 1);
                int padding = (consoleWidth - currentText.length()) / 2;
                String line = " ".repeat(Math.max(0, padding)) + currentText;
                System.out.print("\r" + line);
                try {
                    Thread.sleep(100); // 100ms delay per character
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            if (!skipIntro.get()) {
                System.out.println(); // New line after typing
            }

            // Wait 3 seconds
            if (!skipIntro.get()) {
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < 3000) {
                    if (skipIntro.get()) break;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            if (!skipIntro.get()) {
                clearScreen();

                // Display "Gambling is a financially risky activity" with typing effect over 2 seconds
                String gamblingRisk = "Gambling is a financially risky activity";
                int gamblingRiskTotalChars = gamblingRisk.length();
                int gamblingRiskTotalTimeMs = 2000;
                int gamblingRiskDelayPerChar = gamblingRiskTotalTimeMs / gamblingRiskTotalChars;
                int gamblingRiskPadding = (consoleWidth - gamblingRisk.length()) / 2;
                String gamblingRiskPrefix = " ".repeat(Math.max(0, gamblingRiskPadding));
                for (int i = 0; i < gamblingRiskTotalChars; i++) {
                    if (skipIntro.get()) break;
                    String currentText = gamblingRisk.substring(0, i + 1);
                    String line = gamblingRiskPrefix + currentText;
                    System.out.print("\r" + line);
                    try {
                        Thread.sleep(gamblingRiskDelayPerChar);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (!skipIntro.get()) {
                    System.out.println(); // New line
                }

                // Display "and should not be a source of income" with typing effect over 2 seconds
                String incomeSource = "and should not be a source of income";
                int incomeSourceTotalChars = incomeSource.length();
                int incomeSourceTotalTimeMs = 2000;
                int incomeSourceDelayPerChar = incomeSourceTotalTimeMs / incomeSourceTotalChars;
                int incomeSourcePadding = (consoleWidth - incomeSource.length()) / 2;
                String incomeSourcePrefix = " ".repeat(Math.max(0, incomeSourcePadding));
                for (int i = 0; i < incomeSourceTotalChars; i++) {
                    if (skipIntro.get()) break;
                    String currentText = incomeSource.substring(0, i + 1);
                    String line = incomeSourcePrefix + currentText;
                    System.out.print("\r" + line);
                    try {
                        Thread.sleep(incomeSourceDelayPerChar);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (!skipIntro.get()) {
                    System.out.println(); // New line
                }

                // Wait 3 seconds with both lines displayed
                if (!skipIntro.get()) {
                    long startTime2 = System.currentTimeMillis();
                    while (System.currentTimeMillis() - startTime2 < 3000) {
                        if (skipIntro.get()) break;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }

                if (!skipIntro.get()) {
                    clearScreen();

                    // Display "Please gamble responsibly and remember." with typing effect over 1 second, then display for 2 seconds
                    String responsible = "Please gamble responsibly and remember.";
                    int responsibleTotalChars = responsible.length();
                    int responsibleTotalTimeMs = 1000;
                    int responsibleDelayPerChar = responsibleTotalTimeMs / responsibleTotalChars;
                    int responsiblePadding = (consoleWidth - responsible.length()) / 2;
                    String responsiblePrefix = " ".repeat(Math.max(0, responsiblePadding));
                    for (int i = 0; i < responsibleTotalChars; i++) {
                        if (skipIntro.get()) break;
                        String currentText = responsible.substring(0, i + 1);
                        String line = responsiblePrefix + currentText;
                        System.out.print("\r" + line);
                        try {
                            Thread.sleep(responsibleDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (!skipIntro.get()) {
                        System.out.println(); // New line
                    }

                    // Wait 2 seconds
                    if (!skipIntro.get()) {
                        long startTime3 = System.currentTimeMillis();
                        while (System.currentTimeMillis() - startTime3 < 2000) {
                            if (skipIntro.get()) break;
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }

                    if (!skipIntro.get()) {
                        clearScreen();

                        // Display word by word: "The House." then "Always." then "Wins."
                        String house = "The House.";
                        int housePadding = (consoleWidth - house.length()) / 2;
                        String houseLine = " ".repeat(Math.max(0, housePadding)) + house;
                        System.out.println(houseLine);
                        if (!skipIntro.get()) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }

                        if (!skipIntro.get()) {
                            String always = "Always.";
                            int alwaysPadding = (consoleWidth - always.length()) / 2;
                            String alwaysLine = " ".repeat(Math.max(0, alwaysPadding)) + always;
                            System.out.println(alwaysLine);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }

                        if (!skipIntro.get()) {
                            String wins = "Wins.";
                            int winsPadding = (consoleWidth - wins.length()) / 2;
                            String winsLine = " ".repeat(Math.max(0, winsPadding)) + wins;
                            System.out.println(winsLine);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }

                        if (!skipIntro.get()) {
                            clearScreen();
                        }
                    }
                }
            }
        } else {
            clearScreen();
        }

        if (skipIntro.get()) {
            clearScreen();
        }

        // Display logo with typing effect over 3 seconds
        String logo = "      ::::::::: ::::::::::: ::::::::::: :::::::::  :::   ::: ::::::::::: ::::::::::          ::::::::      :::      :::::::: ::::::::::: ::::    :::  ::::::::\r\n" +
                      "     :+:    :+:    :+:         :+:     :+:    :+: :+:   :+:     :+:     :+:                :+:    :+:   :+: :+:   :+:    :+:    :+:     :+:+:   :+: :+:    :+: \r\n" +
                      "    +:+    +:+    +:+         +:+     +:+    +:+  +:+ +:+      +:+     +:+                +:+         +:+   +:+  +:+           +:+     :+:+:+  +:+ +:+    +:+\r\n" +
                      "   +#++:++#+     +#+         +#+     +#++:++#+    +#++:       +#+     +#++:++#           +#+        +#++:++#++: +#++:++#++    +#+     +#+ +:+ +#+ +#+    +:+\r\n" +
                      "  +#+    +#+    +#+         +#+     +#+    +#+    +#+        +#+     +#+                +#+        +#+     +#+        +#+    +#+     +#+  +#+#+# +#+    +#+\r\n" +
                      " #+#    #+#    #+#         #+#     #+#    #+#    #+#        #+#     #+#                #+#    #+# #+#     #+# #+#    #+#    #+#     #+#   #+#+# #+#    #+#\r\n" +
                      "######### ###########     ###     #########     ###        ###     ##########          ########  ###     ###  ######## ########### ###    ####  ########";
        int totalChars = logo.length();
        int totalTimeMs = 3000; // under 3 seconds
        int delayPerChar = totalTimeMs / totalChars; // approximately 3ms per char
        for (int i = 0; i < totalChars; i++) {
            System.out.print(logo.charAt(i));
            try {
                Thread.sleep(delayPerChar);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // Ensure newline after logo

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
                    clearScreen();
                    String diceTutorialPrompt = "Would you like to view the tutorial for Dice Roll? (y/n): ";
                    int diceTutorialTotalChars = diceTutorialPrompt.length();
                    int diceTutorialTotalTimeMs = 1000;
                    int diceTutorialDelayPerChar = diceTutorialTotalTimeMs / diceTutorialTotalChars;
                    for (int i = 0; i < diceTutorialTotalChars; i++) {
                        System.out.print(diceTutorialPrompt.charAt(i));
                        try {
                            Thread.sleep(diceTutorialDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showDiceTutorial();
                    }
                    clearScreen();
                    String diceLogo = "\t\t\t\t\t .----------------.  .----------------.  .----------------.  .----------------.\r\n" +
                        "\t\t\t\t\t| .--------------. || .--------------. || .--------------. || .--------------. |\r\n" +
                        "\t\t\t\t\t| |  ________    | || |     _____    | || |     ______   | || |  _________   | |\r\n" +
                        "\t\t\t\t\t| | |_   ___ `.  | || |    |_   _|   | || |   .' ___  |  | || | |_   ___  |  | |\r\n" +
                        "\t\t\t\t\t| |   | |   `. \\ | || |      | |     | || |  / .'   \\_|  | || |   | |_  \\_|  | |\r\n" +
                        "\t\t\t\t\t| |   | |    | | | || |      | |     | || |  | |         | || |   |  _|  _   | |\r\n" +
                        "\t\t\t\t\t| |  _| |___.' / | || |     _| |_    | || |  \\ `.___.'\\  | || |  _| |___/ |  | |\r\n" +
                        "\t\t\t\t\t| | |________.'  | || |    |_____|   | || |   `._____.'  | || | |_________|  | |\r\n" +
                        "\t\t\t\t\t| |              | || |              | || |              | || |              | |\r\n" +
                        "\t\t\t\t\t| '--------------' || '--------------' || '--------------' || '--------------' |\r\n" +
                        "\t\t\t\t\t '----------------'  '----------------'  '----------------'  '----------------' ";
                    int diceTotalChars = diceLogo.length();
                    int diceTotalTimeMs = 3000;
                    int diceDelayPerChar = diceTotalTimeMs / diceTotalChars;
                    for (int i = 0; i < diceTotalChars; i++) {
                        System.out.print(diceLogo.charAt(i));
                        try {
                            Thread.sleep(diceDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println();
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
                        clearScreen();
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                }
                case 2 -> {
                    clearScreen();
                    String blackjackTutorialPrompt = "Would you like to view the tutorial for Blackjack? (y/n): ";
                    int blackjackTutorialTotalChars = blackjackTutorialPrompt.length();
                    int blackjackTutorialTotalTimeMs = 1000;
                    int blackjackTutorialDelayPerChar = blackjackTutorialTotalTimeMs / blackjackTutorialTotalChars;
                    for (int i = 0; i < blackjackTutorialTotalChars; i++) {
                        System.out.print(blackjackTutorialPrompt.charAt(i));
                        try {
                            Thread.sleep(blackjackTutorialDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showBlackjackTutorial();
                    }

                    clearScreen();
                    String blackjackLogo = "\t\t\t\t\t.------..------..------..------..------..------..------..------..------.\r\n" +
                        "\t\t\t\t\t|B.--. ||L.--. ||A.--. ||C.--. ||K.--. ||J.--. ||A.--. ||C.--. ||K.--. |\r\n" +
                        "\t\t\t\t\t| :(): || :/\\: || (\\/) || :/\\: || :/\\: || :(): || (\\/) || :/\\: || :/\\: |\r\n" +
                        "\t\t\t\t\t| ()() || (__) || :\\/: || :\\/: || :\\/: || ()() || :\\/: || :\\/: || :\\/: |\r\n" +
                        "\t\t\t\t\t| '--'B|| '--'L|| '--'A|| '--'C|| '--'K|| '--'J|| '--'A|| '--'C|| '--'K|\r\n" +
                        "\t\t\t\t\t`------'`------'`------'`------'`------'`------'`------'`------'`------'";
                    int blackjackTotalChars = blackjackLogo.length();
                    int blackjackTotalTimeMs = 3000;
                    int blackjackDelayPerChar = blackjackTotalTimeMs / blackjackTotalChars;
                    for (int i = 0; i < blackjackTotalChars; i++) {
                        System.out.print(blackjackLogo.charAt(i));
                        try {
                            Thread.sleep(blackjackDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println();
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
                        clearScreen();
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                }
                case 3 -> {
                    clearScreen();
                    String slotTutorialPrompt = "Would you like to view the tutorial for Slot Machine? (y/n): ";
                    int slotTutorialTotalChars = slotTutorialPrompt.length();
                    int slotTutorialTotalTimeMs = 1000;
                    int slotTutorialDelayPerChar = slotTutorialTotalTimeMs / slotTutorialTotalChars;
                    for (int i = 0; i < slotTutorialTotalChars; i++) {
                        System.out.print(slotTutorialPrompt.charAt(i));
                        try {
                            Thread.sleep(slotTutorialDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showSlotMachineTutorial();
                    }

                    clearScreen();
                    String slotLogo = "\t\t ______     __         ______     ______      __    __     ______     ______     __  __     __     __   __     ______\r\n" +
                        "\t\t/\\  ___\\   /\\ \\       /\\  __ \\   /\\__  _\\    /\\ \"-./  \\   /\\  __ \\   /\\  ___\\   /\\ \\_\\ \\   /\\ \\   /\\ \"-.\\ \\   /\\  ___\\ \r\n" +
                        "\t\t\\ \\___  \\  \\ \\ \\____  \\ \\ \\/\\ \\  \\/_/\\ \\/    \\ \\ \\-./\\ \\  \\ \\  __ \\  \\ \\ \\____  \\ \\  __ \\  \\ \\ \\  \\ \\ \\-.  \\  \\ \\  __\\ \r\n" +
                        "\t\t \\/\\_____\\  \\ \\_____\\  \\ \\_____\\    \\ \\_\\     \\ \\_\\ \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\  \\ \\_\\\\\"\\_\\  \\ \\_____\\\r\n" +
                        "\t\t  \\/_____/   \\/_____/   \\/_____/     \\/_/      \\/_/  \\/_/   \\/_/\\/_/   \\/_____/   \\/_/\\/_/   \\/_/   \\/_/ \\/_/   \\/_____/ ";
                    int slotTotalChars = slotLogo.length();
                    int slotTotalTimeMs = 3000;
                    int slotDelayPerChar = slotTotalTimeMs / slotTotalChars;
                    for (int i = 0; i < slotTotalChars; i++) {
                        System.out.print(slotLogo.charAt(i));
                        try {
                            Thread.sleep(slotDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println();
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
                        clearScreen();
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                }
                case 4 -> {
                    clearScreen();
                    String colorTutorialPrompt = "Would you like to view the tutorial for Color Game? (y/n): ";
                    int colorTutorialTotalChars = colorTutorialPrompt.length();
                    int colorTutorialTotalTimeMs = 1000;
                    int colorTutorialDelayPerChar = colorTutorialTotalTimeMs / colorTutorialTotalChars;
                    for (int i = 0; i < colorTutorialTotalChars; i++) {
                        System.out.print(colorTutorialPrompt.charAt(i));
                        try {
                            Thread.sleep(colorTutorialDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showColorGameTutorial();
                    }
                    clearScreen();
                    String colorLogo = "\t\t\t\t a88888b.          dP                       .88888.                       88888888b\r\n" +
                        "\t\t\t\td8'   `88          88                      d8'   `88                      88\r\n" +
                        "\t\t\t\t88        .d8888b. 88 .d8888b. 88d888b.    88        .d8888b. 88d8b.d8b. a88aaaa\r\n" +
                        "\t\t\t\t88        88'  `88 88 88'  `88 88'  `88    88   YP88 88'  `88 88'`88'`88  88\r\n" +
                        "\t\t\t\tY8.   .88 88.  .88 88 88.  .88 88          Y8.   .88 88.  .88 88  88  88  88\r\n" +
                        "\t\t\t\t Y88888P' `88888P' dP `88888P' dP           `88888'  `88888P8 dP  dP  dP  88888888P\r\n" +
                        "\t\t\t\toooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";
                    int colorTotalChars = colorLogo.length();
                    int colorTotalTimeMs = 3000;
                    int colorDelayPerChar = colorTotalTimeMs / colorTotalChars;
                    for (int i = 0; i < colorTotalChars; i++) {
                        System.out.print(colorLogo.charAt(i));
                        try {
                            Thread.sleep(colorDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println();
                    System.out.println("==============================================================================================================================================================");
                    System.out.printf("\t\t\t\t\t\t\t\tBalance: PHP%.2f \n" ,balance);
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("\t\t\t\t\t\t\t\t1. Start playing Color Game");
                    System.out.println("\t\t\t\t\t\t\t\t2. Exit to menu");
                    System.out.print("\t\t\t\t\t\tEnter your choice: ");
                    int startChoice = sc.nextInt();
                    System.out.println("");
                    if (startChoice == 1) {
                        balance = colorGame.play(balance);
                    } else if (startChoice == 2) {
                        clearScreen();
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                    
                }

                case 5 -> {
                    clearScreen();
                    String crazyTutorialPrompt = "Would you like to view the tutorial for Crazy Time? (y/n): ";
                    int crazyTutorialTotalChars = crazyTutorialPrompt.length();
                    int crazyTutorialTotalTimeMs = 1000;
                    int crazyTutorialDelayPerChar = crazyTutorialTotalTimeMs / crazyTutorialTotalChars;
                    for (int i = 0; i < crazyTutorialTotalChars; i++) {
                        System.out.print(crazyTutorialPrompt.charAt(i));
                        try {
                            Thread.sleep(crazyTutorialDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    String viewTutorial = sc.next();
                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showCrazyTimeTutorial();
                    }
                    clearScreen();
                    String crazyLogo = "\t\t\t\t                                                          d8,\r\n" +
                        "\t\t\t\t                                                   d8P   `8P\r\n" +
                        "\t\t\t\t                                                d888888P\r\n" +
                        "\t\t\t\t d8888b  88bd88b d888b8b  d88888P ?88   d8P       ?88'    88b  88bd8b,d88b  d8888b\r\n" +
                        "\t\t\t\td8P' `P  88P'  `d8P' ?88     d8P' d88   88        88P     88P  88P'`?8P'?8bd8b_,dP\r\n" +
                        "\t\t\t\t88b     d88     88b  ,88b  d8P'   ?8(  d88        88b    d88  d88  d88  88P88b\r\n" +
                        "\t\t\t\t`?888P'd88'     `?88P'`88bd88888P'`?88P'?8b       `?8b  d88' d88' d88'  88b`?888P'\r\n" +
                        "\t\t\t\t                                         )88\r\n" +
                        "\t\t\t\t                                        ,d8P\r\n" +
                        "\t\t\t\t                                     `?888P'";
                    int crazyTotalChars = crazyLogo.length();
                    int crazyTotalTimeMs = 3000;
                    int crazyDelayPerChar = crazyTotalTimeMs / crazyTotalChars;
                    for (int i = 0; i < crazyTotalChars; i++) {
                        System.out.print(crazyLogo.charAt(i));
                        try {
                            Thread.sleep(crazyDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println();
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
                        clearScreen();
                        // Exit to menu, do nothing
                    } else {
                        System.out.println("Invalid choice! Returning to menu.");
                    }
                }
                    
                
                case 6 -> {
                    clearScreen();
                    String rouletteTutorialPrompt = "Would you like to view the tutorial for Black Roulette? (y/n): ";
                    int rouletteTutorialTotalChars = rouletteTutorialPrompt.length();
                    int rouletteTutorialTotalTimeMs = 1000;
                    int rouletteTutorialDelayPerChar = rouletteTutorialTotalTimeMs / rouletteTutorialTotalChars;
                    for (int i = 0; i < rouletteTutorialTotalChars; i++) {
                        System.out.print(rouletteTutorialPrompt.charAt(i));
                        try {
                            Thread.sleep(rouletteTutorialDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    String viewTutorial = sc.next();

                    System.out.println("");
                    if (viewTutorial.equalsIgnoreCase("y")) {
                        Tutorial.showRouletteTutorial();
                    }

                    clearScreen();
                    String rouletteLogo = "\t\t\t _______   __                      __              _______                       __             __      __ \r\n" +
                        "\t\t\t|       \\ |  \\                    |  \\            |       \\                     |  \\           |  \\    |  \\\r\n" +
                        "\t\t\t| $$$$$$$\\| $$  ______    _______ | $$   __       | $$$$$$$\\  ______   __    __ | $$  ______  _| $$_  _| $$_     ______\r\n" +
                        "\t\t\t| $$__/ $$| $$ |      \\  /       \\| $$  /  \\      | $$__| $$ /      \\ |  \\  |  \\| $$ /      \\|   $$ \\|   $$ \\   /      \\\r\n" +
                        "\t\t\t| $$    $$| $$  \\$$$$$$\\|  $$$$$$$| $$_/  $$      | $$    $$|  $$$$$$\\| $$  | $$| $$|  $$$$$$\\\\$$$$$$ \\$$$$$$  |  $$$$$$\\\r\n" +
                        "\t\t\t| $$$$$$$\\| $$ /      $$| $$      | $$   $$       | $$$$$$$\\| $$  | $$| $$  | $$| $$| $$    $$ | $$ __ | $$ __ | $$    $$\r\n" +
                        "\t\t\t| $$__/ $$| $$|  $$$$$$$| $$_____ | $$$$$$\\       | $$  | $$| $$__/ $$| $$__/ $$| $$| $$$$$$$$ | $$|  \\| $$|  \\| $$$$$$$$\r\n" +
                        "\t\t\t| $$    $$| $$ \\$$    $$ \\$$     \\| $$  \\$$\\      | $$  | $$ \\$$    $$ \\$$    $$| $$ \\$$     \\  \\$$  $$ \\$$  $$ \\$$     \\\r\n" +
                        "\t\t\t \\$$$$$$$  \\$$  \\$$$$$$$  \\$$$$$$$ \\$$   \\$$       \\$$   \\$$  \\$$$$$$   \\$$$$$$  \\$$  \\$$$$$$$   \\$$$$   \\$$$$   \\$$$$$$$";
                    int rouletteTotalChars = rouletteLogo.length();
                    int rouletteTotalTimeMs = 3000;
                    int rouletteDelayPerChar = rouletteTotalTimeMs / rouletteTotalChars;
                    for (int i = 0; i < rouletteTotalChars; i++) {
                        System.out.print(rouletteLogo.charAt(i));
                        try {
                            Thread.sleep(rouletteDelayPerChar);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println();
                    
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
                        clearScreen();
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

