import java.util.ArrayList;
import java.util.List;

public class CrazyTimeGame extends BitByteCasinoGame {
    private List<String> wheel;

    public CrazyTimeGame() {
        wheel = new ArrayList<>();
        // Add segments: 20 "1", 13 "2", 7 "5", 4 "10", 2 each for bonuses
        for (int i = 0; i < 20; i++) wheel.add("1");
        for (int i = 0; i < 13; i++) wheel.add("2");
        for (int i = 0; i < 7; i++) wheel.add("5");
        for (int i = 0; i < 4; i++) wheel.add("10");
        for (int i = 0; i < 2; i++) wheel.add("CoinFlip");
        for (int i = 0; i < 2; i++) wheel.add("CashHunt");
        for (int i = 0; i < 2; i++) wheel.add("Pachinko");
        for (int i = 0; i < 2; i++) wheel.add("CrazyTime");
    }

    @Override
    public double play(double balance) {
        clearScreen();
        System.out.println("Welcome to Crazy Time!");
        System.out.printf("Your balance: PHP%.2f\n", balance);
        System.out.print("Enter bet amount: ");
        double bet = sc.nextDouble();
        if (bet > balance || bet <= 0) {
            System.out.println("Invalid bet!");
            return balance;
        }
        System.out.println("Bet on: 1, 2, 5, 10, CoinFlip, CashHunt, Pachinko, or CrazyTime");
        System.out.print("Your choice: ");
        String betOn = sc.next();

        // Top Slot: random segment and multiplier 1-10
        String topSlot = wheel.get(rand.nextInt(wheel.size()));
        int topMultiplier = rand.nextInt(10) + 1;
        System.out.println("Top Slot: " + topSlot + " with multiplier x" + topMultiplier);

        // Spin wheel animation
        System.out.println("\nSpinning the wheel...");
        try {
            for (int i = 0; i < 12; i++) {
                String spinSegment = wheel.get(rand.nextInt(wheel.size()));
                clearScreen();
                printWheel(spinSegment);
                Thread.sleep(120 + i * 10); // Gradually slow down
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final spin result
        String result = wheel.get(rand.nextInt(wheel.size()));
        clearScreen();
        printWheel(result);
        System.out.println("Wheel landed on: " + result);

        double payout = 0;
        if (result.equals(betOn)) {
            if (result.equals("1")) payout = bet * 1;
            else if (result.equals("2")) payout = bet * 2;
            else if (result.equals("5")) payout = bet * 5;
            else if (result.equals("10")) payout = bet * 10;
            else { // Bonus
                payout = bet * 10; // Base for bonus
                int bonusMult = rand.nextInt(99) + 2; // 2-100
                payout *= bonusMult;
                System.out.println("Bonus multiplier: x" + bonusMult);
            }
            // Apply Top Slot if matches
            if (result.equals(topSlot)) {
                payout *= topMultiplier;
                System.out.println("Top Slot applied! Total multiplier x" + topMultiplier);
            }
            balance += payout;
            System.out.printf("You win PHP%.2f!\n", payout);
        } else {
            balance -= bet;
            System.out.println("You lose!");
        }
        System.out.printf("New balance: PHP%.2f\n", balance);
        System.out.println("Press enter to continue...");
        sc.nextLine(); // Consume newline
        sc.nextLine();
        return balance;
    }

    // 🎡 Crazy Time Wheel
    private void printWheel(String segment) {
        System.out.println("         _____________________         ");
        System.out.println("       /                       \\       ");
        System.out.println("     /                           \\     ");
        System.out.println("    |                             |    ");
        System.out.println("   /                               \\   ");
        System.out.println("  |                                 |  ");
        System.out.println(" /                                   \\ ");
        System.out.println("|                                     |");
        System.out.println(" \\                                   / ");
        System.out.println("  |                                 |  ");
        System.out.println("   \\                               /   ");
        System.out.println("    |                             |    ");
        System.out.println("     \\                           /     ");
        System.out.println("       \\_______________________/       ");
        System.out.println("                " + segment + "                ");
    }
}
