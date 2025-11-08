
import java.util.Random;
import java.util.Scanner;


abstract class BitByteCasinoGame {
    protected Scanner sc = new Scanner(System.in);
    protected Random rand = new Random();

    // ✅ Universal clear screen method
    protected void clearScreen() {
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
    }

    public abstract double play(double balance);
}
