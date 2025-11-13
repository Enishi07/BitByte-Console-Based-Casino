import java.util.Random;
import java.util.Scanner;


public class BlackRedRouletteGame extends BitByteCasinoGame {

    // ANSI color and screen controls
    private static final String RESET   = "\u001B[0m";
    private static final String RED_BG  = "\u001B[41m";
    private static final String BLACK_BG= "\u001B[40m";
    private static final String GREEN_BG= "\u001B[42m";
    private static final String WHITE   = "\u001B[97m";
    private static final String CURSOR_HOME = "\u001B[H"; // move cursor to top-left

    // Ball styling
    private static final String BALL_BG = "\u001B[46m";  // Cyan background
    private static final String BOLD = "\u001B[1m";
    private static final String BLINK = "\u001B[5m";

    // European wheel sequence (clockwise from 0)
    private static final int[] NUMBERS = {
        0,32,15,19,4,21,2,25,17,34,6,27,13,36,11,30,8,23,10,5,24,16,33,1,20,14,31,9,22,18,29,7,28,12,35,3,26
    };

    // Color: 'G' green, 'R' red, 'B' black
    private static final char[] COLOR = {
        'G','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B'
    };

    private static final int WIDTH = 69;
    private static final int HEIGHT = 25;

    @Override
public double play(double balance) {
    Scanner scanner = sc;
    Random rnd = rand;

    boolean keepPlaying = true;

    while (keepPlaying) {
        clearScreen();
        System.out.println(GREEN_BG + WHITE + "=== BLACK & RED ROULETTE ===" + RESET);
        System.out.println("Current Balance: $" + balance + "\n");

        // Get bet amount
        System.out.print("Enter your bet amount: $");
        double betAmount = 0;
        while (betAmount <= 0 || betAmount > balance) {
            try {
                betAmount = Double.parseDouble(scanner.nextLine().trim());
                if (betAmount <= 0 || betAmount > balance) {
                    System.out.print("Invalid amount. Enter a value between $0 and $" + balance + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid amount: ");
            }
        }

        // Get user's bet color
        System.out.print("Place your bet (Black/Red): ");
        String bet = scanner.nextLine().trim().toLowerCase();
        while (!bet.equals("black") && !bet.equals("red")) {
            System.out.print("Invalid choice. Type 'Black' or 'Red': ");
            bet = scanner.nextLine().trim().toLowerCase();
        }

        System.out.println("\nSpinning the wheel...\n");

        // Setup roulette wheel coordinates
        double centerX = WIDTH / 2.0;
        double centerY = HEIGHT / 2.0;
        double radiusX = WIDTH * 0.38;
        double radiusY = HEIGHT * 0.38;

        int pockets = NUMBERS.length;
        int[] px = new int[pockets];
        int[] py = new int[pockets];
        double[] ang = new double[pockets];

        for (int i = 0; i < pockets; i++) {
            double a = 2 * Math.PI * i / pockets - Math.PI / 2;
            ang[i] = a;
            int x = (int) Math.round(centerX + Math.cos(a) * radiusX);
            int y = (int) Math.round(centerY + Math.sin(a) * radiusY);
            if (x < 0) x = 0;
            if (x > WIDTH - 2) x = WIDTH - 2;
            if (y < 0) y = 0;
            if (y > HEIGHT - 1) y = HEIGHT - 1;
            px[i] = x;
            py[i] = y;
        }

        char[][] canvas = buildBaseCanvas(WIDTH, HEIGHT, centerX, centerY, radiusX, radiusY);
        for (int i = 0; i < pockets; i++) drawSeparator(canvas, centerX, centerY, ang[i], (int)(radiusX * 0.78));

        // Random start and end
        int startIndex = rnd.nextInt(pockets);
        int finalIndex = rnd.nextInt(pockets);

        // Animate ball around the wheel
        int frames = 60;
        int totalMs = 2000;
        int sleepMs = Math.max(1, totalMs / frames);
        int laps = 3;
        int totalSteps = laps * pockets + ((finalIndex - startIndex) % pockets + pockets) % pockets;

        for (int f = 0; f < frames; f++) {
            double t = f / (double)(frames - 1);
            double ease = 1 - Math.pow(1 - t, 3);
            int step = (int)Math.round(ease * totalSteps);
            int current = (startIndex + step) % pockets;

            System.out.print(CURSOR_HOME);
            renderFrame(canvas, px, py, pockets, current);

            try {
                Thread.sleep(sleepMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Animation interrupted!");
            }
        }

        // Final frame
        System.out.print(CURSOR_HOME);
        renderFrame(canvas, px, py, pockets, finalIndex);

        // Flash winning pocket
        for (int i = 0; i < 6; i++) {
            System.out.print(CURSOR_HOME);
            if (i % 2 == 0) renderFrame(canvas, px, py, pockets, finalIndex);
            else renderFrameWithoutPocket(canvas, px, py, pockets, finalIndex);

            try {
                Thread.sleep(180);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Animation interrupted!");
            }
        }

        String winColor = COLOR[finalIndex] == 'R' ? "red" : COLOR[finalIndex] == 'B' ? "black" : "green";
        String winColorCode = COLOR[finalIndex] == 'R' ? RED_BG : COLOR[finalIndex] == 'B' ? BLACK_BG : GREEN_BG;

        // Display result
        System.out.println("\nResult: " + winColorCode + WHITE + formatNumber(NUMBERS[finalIndex]) + RESET +
                           " → " + winColor.toUpperCase());

        // Determine win/loss and update balance
        if (bet.equals(winColor)) {
            balance += betAmount;
            System.out.println(GREEN_BG + WHITE + "You WIN!  +₱" + betAmount + RESET);
        } else {
            balance -= betAmount;
            System.out.println(RED_BG + WHITE + "You LOSE! -₱" + betAmount + RESET);
        }

        System.out.println("New Balance: $" + balance + "\n");

        // Ask user to continue or exit
        System.out.println("1. Continue playing");
        System.out.println("2. Exit to main menu");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine().trim();
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.print("Invalid option. Choose 1 or 2: ");
            choice = scanner.nextLine().trim();
        }

        if (choice.equals("2")) {
            keepPlaying = false;
        }
    }

    return balance;
}


    // ------------------ Helper Methods ------------------
    private static char[][] buildBaseCanvas(int w, int h, double cx, double cy, double rx, double ry) {
        char[][] c = new char[h][w];
        for (int y = 0; y < h; y++) for (int x = 0; x < w; x++) c[y][x] = ' ';

        double outerR = Math.min(rx, ry);
        double innerR = outerR * 0.42;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                double dx = (x - cx) / rx;
                double dy = (y - cy) / ry;
                double dist = Math.hypot(dx, dy);
                if (Math.abs(dist - 1.0) < 0.06) c[y][x] = '=';
                else if (Math.abs(dist - 0.92) < 0.03) c[y][x] = '-';
                else {
                    double dr = Math.hypot((x - cx) / (rx * 0.5), (y - cy) / (ry * 0.5));
                    if (Math.abs(dr - 0.0) < 0.001 && Math.hypot(x - cx, y - cy) < 2) c[y][x] = 'o';
                    else if (Math.hypot((x - cx), (y - cy)) < innerR * 0.6) c[y][x] = '.';
                }
            }
        }

        int hx = (int)Math.round(cx);
        int hy = (int)Math.round(cy);
        if (hy >= 0 && hy < h && hx >= 0 && hx < w) c[hy][hx] = 'O';
        return c;
    }

    private static void drawSeparator(char[][] canvas, double cx, double cy, double angle, int length) {
        int steps = Math.max(3, length / 2);
        for (int s = 0; s < steps; s++) {
            double r = (1.0 - s / (double)steps) * Math.min(canvas[0].length * 0.38, canvas.length * 0.38);
            int x = (int)Math.round(cx + Math.cos(angle) * r);
            int y = (int)Math.round(cy + Math.sin(angle) * r);
            if (y >= 0 && y < canvas.length && x >= 0 && x < canvas[0].length) {
                char mark = '|';
                double dx = Math.cos(angle), dy = Math.sin(angle);
                if (Math.abs(dx) > Math.abs(dy)) mark = '-';
                canvas[y][x] = mark;
            }
        }
    }

    private static void renderFrame(char[][] base, int[] px, int[] py, int pockets, int bulletIndex) {
        int h = base.length, w = base[0].length;
        int[][] pocketAt = new int[h][w];
        for (int y = 0; y < h; y++) for (int x = 0; x < w; x++) pocketAt[y][x] = -1;
        for (int i = 0; i < pockets; i++) pocketAt[py[i]][px[i]] = i;

        for (int y = 0; y < h; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < w; ) {
                if (x <= w - 2 && pocketAt[y][x] != -1) {
                    int idx = pocketAt[y][x];
                    String num = formatNumber(NUMBERS[idx]);
                    String color = pocketColorCode(COLOR[idx]);
                    if (idx == bulletIndex) row.append(BALL_BG).append(BLINK).append(BOLD).append(WHITE).append("OO").append(RESET);
                    else row.append(color).append(WHITE).append(num).append(RESET);
                    x += 2;
                } else { row.append(base[y][x]); x++; }
            }
            System.out.println(row.toString());
        }
    }

    private static void renderFrameWithoutPocket(char[][] base, int[] px, int[] py, int pockets, int hideIndex) {
        int h = base.length, w = base[0].length;
        int[][] pocketAt = new int[h][w];
        for (int y = 0; y < h; y++) for (int x = 0; x < w; x++) pocketAt[y][x] = -1;
        for (int i = 0; i < pockets; i++) if (i != hideIndex) pocketAt[py[i]][px[i]] = i;

        for (int y = 0; y < h; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < w; ) {
                if (x <= w - 2 && pocketAt[y][x] != -1) {
                    int idx = pocketAt[y][x];
                    String num = formatNumber(NUMBERS[idx]);
                    String color = pocketColorCode(COLOR[idx]);
                    row.append(color).append(WHITE).append(num).append(RESET);
                    x += 2;
                } else { row.append(base[y][x]); x++; }
            }
            System.out.println(row.toString());
        }
    }

    private static String pocketColorCode(char c) {
        switch (c) {
            case 'G': return GREEN_BG;
            case 'R': return RED_BG;
            default:  return BLACK_BG;
        }
    }

    private static String formatNumber(int n) {
        return n < 10 ? " " + n : Integer.toString(n);
    }

}
