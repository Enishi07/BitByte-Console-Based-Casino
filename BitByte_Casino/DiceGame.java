// 🎲 Dice Roll Game
class DiceGame extends BitByteCasinoGame {
    @Override
    public double play(double balance) {
        System.out.print("Enter your bet: PHP");
        
        double bet = sc.nextDouble();
        if (bet > balance) {
            System.out.println("Not enough balance!");
            return balance;
        }

        int playerRoll = rand.nextInt(6) + 1;
        int computerRoll = rand.nextInt(6) + 1;
        System.out.println("-----------------------------------------------");
        System.out.println("You rolled: " + playerRoll);
        System.out.println("Dealer rolled: " + computerRoll);

        if (playerRoll > computerRoll) {
            System.out.printf("You win PHP%.2f! \n", bet);
            System.out.println("-----------------------------------------------");
            balance += bet;
        } else if (playerRoll < computerRoll) {
            System.out.printf("You lose PHP%.2f \n", bet);
            System.out.println("-----------------------------------------------");
            balance -= bet;
        } else {
            System.out.println("It's a tie!");
        }

        return balance;
    }
}
