

class DiceGame extends BitByteCasinoGame {
    private String[] diceFaces = {
            "",
            "+---------+\n" +
            "|         |\n" +
            "|    *    |\n" +
            "|         |\n" +
            "+---------+",
            "+---------+\n" +
            "|  *      |\n" +
            "|         |\n" +
            "|      *  |\n" +
            "+---------+",
            "+---------+\n" +
            "| *       |\n" +
            "|    *    |\n" +
            "|       * |\n" +
            "+---------+",
            "+---------+\n" +
            "| *     * |\n" +
            "|         |\n" +
            "| *     * |\n" +
            "+---------+",
            "+---------+\n" +
            "| *     * |\n" +
            "|    *    |\n" +
            "| *     * |\n" +
            "+---------+",
            "+---------+\n" +
            "| *     * |\n" +
            "| *     * |\n" +
            "| *     * |\n" +
            "+---------+"
    };

    private void printDice(int roll) {
        System.out.println(diceFaces[roll]);
    }

    @Override
    public double play(double balance) {
        clearScreen();
        System.out.print("Enter your bet: PHP");
        double bet = sc.nextDouble();
        if (bet > balance) {
            System.out.println("Not enough balance!");
            return balance;
        }

        // Player's roll animation
        System.out.println("\nRolling your dice...");
        try {
            for (int i = 0; i < 12; i++) {
                int tempRoll = rand.nextInt(6) + 1;
                clearScreen();
                System.out.println("Rolling your dice...");
                printDice(tempRoll);
                Thread.sleep(120 + i * 10); // Gradually slow down
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int playerRoll = rand.nextInt(6) + 1;
        clearScreen();
        System.out.println("You rolled:");
        printDice(playerRoll);

        // Dealer's roll animation
        System.out.println("\nRolling dealer's dice...");
        try {
            for (int i = 0; i < 12; i++) {
                int tempRoll = rand.nextInt(6) + 1;
                clearScreen();
                System.out.println("You rolled:");
                printDice(playerRoll);
                System.out.println("\nRolling dealer's dice...");
                printDice(tempRoll);
                Thread.sleep(120 + i * 10); // Gradually slow down
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int dealerRoll = rand.nextInt(6) + 1;
        clearScreen();
        System.out.println("You rolled:");
        printDice(playerRoll);
        System.out.println("\nDealer rolled:");
        printDice(dealerRoll);

        if (playerRoll > dealerRoll) {
            System.out.println("\nYou win PHP" + bet + "!");
            balance += bet;
        } else if (playerRoll < dealerRoll) {
            System.out.println("\nYou lose PHP" + bet + ".");
            balance -= bet;
        } else {
            System.out.println("\nIt's a tie!");
        }
        return balance;
    }
}
