import java.util.Random;
import java.util.Scanner;

public class BlackRedRouletteGame {

    // ANSI escape codes for colors (if supported by terminal)
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        System.out.println(GREEN + "Welcome to the Black/Red Roulette Game! 🎰" + RESET);
        System.out.println("-------------------------------------------------");
        
       
        System.out.println("🔴🟢🟠🟡🟠🟢🔴");

        
        System.out.print("💸 Place your bet! Choose 'Black' or 'Red' 🎯: ");
        String playerBet = scanner.nextLine().trim().toLowerCase();
        
        
        while (!playerBet.equals("black") && !playerBet.equals("red")) {
            System.out.println(RED + " Invalid input. Please choose 'Black' or 'Red'." + RESET);
            playerBet = scanner.nextLine().trim().toLowerCase();
        }
        
       
        String result = spinRoulette();
        printRouletteSpinAnimation();
        
        System.out.println("🎉 The wheel lands on: " + (result.equals("black") ? RED + "🔴 Black" : GREEN + "🟢 Red") + RESET);
        
        
        if (playerBet.equals(result)) {
            System.out.println(GREEN + "💥 Congratulations, you win! 💥" + RESET);
        } else {
            System.out.println(RED + "💔 Sorry, you lose. Better luck next time! 💔" + RESET);
        }
        
        
        scanner.close();
    }

    
    public static String spinRoulette() {
        Random random = new Random();
        
        return random.nextBoolean() ? "black" : "red";
    }

    
    public static void printRouletteSpinAnimation() {
        String[] spinFrames = {
            "🔴🟢🟠🟡🟠🟢🔴",
            "🟠🟡🟢🔴🟠🟢🟡",
            "🟡🟠🟢🟡🟢🔴🟠",
            "🟢🟡🟠🟡🟠🟢🔴",
            "🟠🟡🟠🟢🟡🟠🟢"
        };
        
        try {
            for (String frame : spinFrames) {
                System.out.print("\r" + YELLOW + frame + RESET);
                Thread.sleep(500); // Delay for spinning effect
            }
            System.out.println(); // Move to the next line after animation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
