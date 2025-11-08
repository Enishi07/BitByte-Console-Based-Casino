
// 🎨 Philippine Color Game
class ColorGame extends BitByteCasinoGame {
    @Override
    public double play(double balance) {
        System.out.println("Choose betting mode:");
        System.out.println("1. Single Color Bet");
        System.out.println("2. Multiple Color Bet (Two Colors)");
        System.out.print("Enter your choice (1-2): ");
        int betMode = sc.nextInt();
        System.out.println("");

        double totalBet = 0;
        String[] playerColors = new String[2];
        double[] bets = new double[2];

        String[] colors = {"Red", "Blue", "Green", "Yellow", "Pink", "White"};

        if (betMode == 1) {
            // Single bet
            System.out.print("Enter your bet: PHP");
            bets[0] = sc.nextDouble();
            if (bets[0] > balance) {
                System.out.println("Not enough balance!");
                return balance;
            }
            totalBet = bets[0];

            int choice;
            do {
                System.out.println("");
                System.out.println("Choose a color:");
                System.out.println("1. Red");
                System.out.println("2. Blue");
                System.out.println("3. Green");
                System.out.println("4. Yellow");
                System.out.println("5. Pink");
                System.out.println("6. White");
                System.out.print("Enter your choice (1-6): ");
                choice = sc.nextInt();
                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice! Please choose 1-6.");
                }
            } while (choice < 1 || choice > 6);

            playerColors[0] = colors[choice - 1];
        } else {
            // Multiple bet
            for (int i = 0; i < 2; i++) {
                System.out.print("Enter bet for color " + (i + 1) + ": PHP");
                bets[i] = sc.nextDouble();
                if (bets[i] > balance - totalBet) {
                    System.out.println("Not enough balance!");
                    return balance;
                }
                totalBet += bets[i];

                int choice;
                do {
                    System.out.println("Choose color " + (i + 1) + ":");
                    System.out.println("1. Red");
                    System.out.println("2. Blue");
                    System.out.println("3. Green");
                    System.out.println("4. Yellow");
                    System.out.println("5. Pink");
                    System.out.println("6. White");
                    System.out.print("Enter your choice (1-6): ");
                    choice = sc.nextInt();
                    if (choice < 1 || choice > 6) {
                        System.out.println("Invalid choice! Please choose 1-6.");
                    }
                } while (choice < 1 || choice > 6);

                playerColors[i] = colors[choice - 1];
            }
        }

        System.out.println("\nDropping Color Boxes...");
        try {
            // 🎨 Color box animation (with screen refresh)
            for (int i = 0; i < 12; i++) {
                String[] randomColors = new String[3];
                for (int j = 0; j < 3; j++) {
                    randomColors[j] = colors[rand.nextInt(colors.length)];
                }
                clearScreen();
                printColorBoxes(randomColors);
                Thread.sleep(120 + i * 10); // Gradually slow down
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final result
        String[] spunColors = new String[3];
        for (int j = 0; j < 3; j++) {
            spunColors[j] = colors[rand.nextInt(colors.length)];
        }
        clearScreen();
        printColorBoxes(spunColors);

        if (betMode == 1) {
            System.out.println("\nYou chose: " + playerColors[0]);
        } else {
            System.out.println("\nYou chose: " + playerColors[0] + " and " + playerColors[1]);
        }
        System.out.println("The boxes landed on: " + String.join(", ", spunColors));

        double totalWinnings = 0;
        if (betMode == 1) {
            // Single bet logic
            int count = 0;
            for (String spunColor : spunColors) {
                if (playerColors[0].equals(spunColor)) {
                    count++;
                }
            }
            if (count > 0) {
                double multiplier = 1 + count; // 2 for 1, 3 for 2, 4 for 3
                double winnings = bets[0] * multiplier;
                System.out.println("You win PHP" + winnings + " on " + playerColors[0] + "! (Multiplier: " + multiplier + "x)");
                totalWinnings += winnings;
            } else {
                System.out.println("You lose PHP" + bets[0] + " on " + playerColors[0] + ".");
            }
        } else {
            // Multiple bet logic
            for (int i = 0; i < 2; i++) {
                int count = 0;
                for (String spunColor : spunColors) {
                    if (playerColors[i].equals(spunColor)) {
                        count++;
                    }
                }
                if (count > 0) {
                    double multiplier = 1 + count; // 2 for 1, 3 for 2, 4 for 3
                    double winnings = bets[i] * multiplier;
                    System.out.println("You win PHP" + winnings + " on " + playerColors[i] + "! (Multiplier: " + multiplier + "x)");
                    totalWinnings += winnings;
                } else {
                    System.out.println("You lose PHP" + bets[i] + " on " + playerColors[i] + ".");
                }
            }
        }

        balance += totalWinnings - totalBet;

        return balance;
    }

    // 🎨 Color box
    private void printColorBox(String color) {
        int width = 11;
        int leftPad = (width - color.length()) / 2;
        int rightPad = width - color.length() - leftPad;
        String centered = " ".repeat(leftPad) + color + " ".repeat(rightPad);
        System.out.println("       .-----------.    ");
        System.out.println("     .`          .'     ");
        System.out.println("    |           |    ");
        System.out.println("    |           |    ");
        System.out.println("    |" + centered + "|    ");
        System.out.println("    |           |  .  ");
        System.out.println("    |___________|.'    ");
    }

    // 🎨 Color boxes (3 boxes)
    private void printColorBoxes(String[] colors) {
        int width = 11;
        String[] centered = new String[3];
        for (int i = 0; i < 3; i++) {
            int leftPad = (width - colors[i].length()) / 2;
            int rightPad = width - colors[i].length() - leftPad;
            centered[i] = " ".repeat(leftPad) + colors[i] + " ".repeat(rightPad);
        }
        System.out.println("       .-----------.      .-----------.      .-----------. ");
        System.out.println("     .`          .'|    .`          .'|    .`          .'|    ");
        System.out.println("    |           |  |   |           |  |   |           |  | ");
        System.out.println("    |           |  |   |           |  |   |           |  | ");
        System.out.println("    |" + centered[0] + "|  |   |" + centered[1] + "|  |   |" + centered[2] + "|  |   |");
        System.out.println("    |           |  .   |           |  .   |           |  .    ");
        System.out.println("    |___________|.'    |___________|.'    |___________|.'    ");
    }
}
