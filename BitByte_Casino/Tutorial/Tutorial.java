package Tutorial;
import java.util.Scanner;

public class Tutorial {
    private static Scanner sc = new Scanner(System.in);

    public static void showDiceTutorial() {
        System.out.println("\n=== Dice Roll Tutorial ===");
        System.out.println("Rules:");
        System.out.println("- You and the dealer each roll a die (1-6).");
        System.out.println("- If your roll is higher, you win your bet.");
        System.out.println("- If the dealer's roll is higher, you lose your bet.");
        System.out.println("- If it's a tie, no one wins or loses.");
        System.out.println("- Bet amount must not exceed your balance.");
        System.out.println("- Good luck!");
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }

    public static void showBlackjackTutorial() {
        System.out.println("\n=== Blackjack Tutorial ===");
        System.out.println("Objective: Get closer to 21 than the dealer without going over.");
        System.out.println("Rules:");
        System.out.println("- Cards: A=11 (or 1), 2-10=face value, J/Q/K=10.");
        System.out.println("- You start with 2 cards, dealer shows 1 card.");
        System.out.println("- Actions:");
        System.out.println("  - Hit: Take another card.");
        System.out.println("  - Stand: Keep your current hand.");
        System.out.println("  - Double Down: Double bet, take one more card, then stand.");
        System.out.println("- Dealer hits until 17 or higher.");
        System.out.println("- Blackjack (21 with 2 cards) pays 1.5x bet.");
        System.out.println("- Bust (over 21) loses the bet.");
        System.out.println("- Bet amount must not exceed your balance.");
        System.out.println("- Good luck!");
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }

    public static void showSlotMachineTutorial() {
        System.out.println("\n=== Slot Machine Tutorial ===");
        System.out.println("Rules:");
        System.out.println("- Spin the reels to match symbols.");
        System.out.println("- Symbols: ^_^, o_o, O_O, >:), T_T");
        System.out.println("- 3 matching symbols: Jackpot! Win 5x bet.");
        System.out.println("- 2 matching symbols: Win 2x bet.");
        System.out.println("- No matches: Lose the bet.");
        System.out.println("- Bet amount must not exceed your balance.");
        System.out.println("- Good luck!");
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }

    public static void showColorGameTutorial() {
        System.out.println("\n=== Color Game Tutorial ===");
        System.out.println("Rules:");
        System.out.println("- Choose 1 or 2 colors to bet on.");
        System.out.println("- Colors: Red, Blue, Green, Yellow, Pink, White.");
        System.out.println("- 3 color boxes are dropped randomly.");
        System.out.println("- For each color you bet on:");
        System.out.println("  - If it appears 1 time: Win 2x bet.");
        System.out.println("  - If it appears 2 times: Win 3x bet.");
        System.out.println("  - If it appears 3 times: Win 4x bet.");
        System.out.println("  - If it doesn't appear: You lose your bet.");
        System.out.println("- Total bet must not exceed your balance.");
        System.out.println("- Good luck!");
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }

    public static void showCrazyTimeTutorial() {
        System.out.println("\n=== Crazy Time Tutorial ===");
        System.out.println("Objective: Bet on a segment and hope the wheel lands on it!");
        System.out.println("Rules:");
        System.out.println("- The wheel has 54 segments with different multipliers and bonuses.");
        System.out.println("- Segments:");
        System.out.println("  - Numbers: 1, 2, 5, 10 (multipliers for your bet)");
        System.out.println("  - Bonuses: CoinFlip, CashHunt, Pachinko, CrazyTime (big payouts!)");
        System.out.println("- Top Slot: Shows a random segment and multiplier (1-10).");
        System.out.println("  - If the wheel lands on the same segment as Top Slot,");
        System.out.println("    your payout is multiplied by the Top Slot multiplier!");
        System.out.println("- Winning:");
        System.out.println("  - Match a number: Win bet x segment value.");
        System.out.println("  - Match a bonus: Win bet x 10 x random multiplier (2-100).");
        System.out.println("  - Plus Top Slot multiplier if applicable.");
        System.out.println("- Bet amount must not exceed your balance.");
        System.out.println("- Watch the animated wheel spin and good luck!");
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }

    public static void showRouletteTutorial() {
    System.out.println("\n=== Roulette Game Tutorial ===");
    System.out.println("Rules:");
    System.out.println("- You can bet on a COLOR or a NUMBER (0–36).");
    System.out.println("- Colors are:");
    System.out.println("  • Red  → numbers like 1, 3, 5, 7, 9...");
    System.out.println("  • Black → numbers like 2, 4, 6, 8, 10...");
    System.out.println("  • Green → 0 only.");
    System.out.println();
    System.out.println("Betting Options:");
    System.out.println("- Bet on a number → Higher risk, higher reward.");
    System.out.println("- Bet on a color → Safer, smaller reward.");
    System.out.println();
    System.out.println("Winning Mechanics:");
    System.out.println("- If your number is drawn: You win 35x your bet!");
    System.out.println("- If your color matches: You win 2x your bet!");
    System.out.println("- Otherwise: You lose your bet.");
    System.out.println();
    System.out.println("Other Notes:");
    System.out.println("- You can only bet within your current balance.");
    System.out.println("- Type 'exit' anytime to leave the game.");
    System.out.println("- Try your luck and manage your bets wisely!");
    System.out.println("\nPress Enter to continue...");
    sc.nextLine();
}

}
