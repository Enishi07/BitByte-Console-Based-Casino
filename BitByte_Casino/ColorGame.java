// 🎨 Philippine Color Game
class ColorGame extends BitByteCasinoGame {
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
        System.out.println("Dropping Color Boxes...");
        System.out.println("The box landed on: " + spunColor);

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
