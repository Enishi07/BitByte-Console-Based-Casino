import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackRedRouletteGame extends BitByteCasinoGame {

    // ANSI color and screen controls
    private static final String RESET      = "\u001B[0m";
    private static final String RED_BG     = "\u001B[41m";
    private static final String BLACK_BG   = "\u001B[40m";
    private static final String GREEN_BG   = "\u001B[42m";
    private static final String WHITE      = "\u001B[97m";
    private static final String CURSOR_HOME= "\u001B[H";

    // Ball styling
    private static final String BALL_BG = "\u001B[46m";  // Cyan background
    private static final String BOLD    = "\u001B[1m";
    private static final String BLINK   = "\u001B[5m";

    // European wheel sequence (clockwise from 0)
    private static final int[] NUMBERS = {
        0,32,15,19,4,21,2,25,17,34,6,27,13,36,11,30,8,23,10,5,24,16,33,1,20,14,31,9,22,18,29,7,28,12,35,3,26
    };

    // Color: 'G' green, 'R' red, 'B' black
    private static final char[] COLOR = {
        'G','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B','R','B'
    };

    private static final int WIDTH  = 69;
    private static final int HEIGHT = 25;

    @Override
    public double play(double balance) {
        Scanner scanner = sc;
        Random rnd = rand;

        clearScreen();

        if (balance <= 0) {
            System.out.println(RED_BG + WHITE + "You have no balance to play!" + RESET);
            return balance;
        }

        boolean keepPlaying = true;

        while (keepPlaying) {
            displayRouletteTable();
            if (balance <= 0) {
                System.out.println(RED_BG + WHITE + "You have no balance left! Game over." + RESET);
                break;
            }

            // ---------------- Mechanics display ----------------
            System.out.println(BOLD + WHITE + "=== Game Mechanics ===" + RESET);
            System.out.println(GREEN_BG + WHITE + "  Correct number: Win 35x bet  " + RESET);
            System.out.println(RED_BG   + WHITE + "  Correct color:  Win 2x bet   " + RESET);
            System.out.println(BLACK_BG + WHITE + "  Green (0): House wins        " + RESET);
            System.out.println();

            // ---------------- MULTI-BET INPUT ----------------
            ArrayList<Bet> bets = new ArrayList<>();
            double totalBet = 0;

            while (true) {
                System.out.printf(BOLD + WHITE + "=== Balance: PHP%.2f ===" + RESET + "\n", balance);
                System.out.println("============= Place Your Bets =============");
                System.out.println("Format:");
                System.out.println(BOLD + WHITE + "  \"color <red/black/green> <amount>\" " + RESET);
                System.out.println(BOLD + WHITE + "  \"number <0-36> <amount>\"" + RESET);
                System.out.println(BOLD + WHITE + "  done  -> finish betting" + RESET);
                System.out.printf("Total Bet: PHP%.2f\n", totalBet);
                System.out.print("Enter bet: ");

                String input = scanner.nextLine().trim();
                System.out.println();

                if (input.equals("done")) {
                    if (bets.isEmpty()) {
                        System.out.println("You must place at least 1 bet!\n");
                        continue;
                    }
                    break;
                }

                String[] p = input.split(" ");
                if (p.length != 3) {
                    System.out.println("Invalid format. Try again.\n");
                    continue;
                }

                String type = p[0];
                String choice = p[1];
                double amount;

                try {
                    amount = Double.parseDouble(p[2]);
                } catch (Exception e) {
                    System.out.println("Invalid amount.\n");
                    continue;
                }

                if (amount <= 0 || amount > balance) {
                    System.out.println("Not enough balance.\n");
                    continue;
                }

                Bet b = new Bet();
                b.amount = amount;

                // NUMBER BET
                if (type.equalsIgnoreCase("number")) {
                    try {
                        int num = Integer.parseInt(choice);
                        if (num < 0 || num > 36) {
                            System.out.println("Number must be 0–36.\n");
                            continue;
                        }
                        b.type = "number";
                        b.number = num;
                    } catch (Exception e) {
                        System.out.println("Invalid number.\n");
                        continue;
                    }
                }
                // COLOR BET
                else if (type.equalsIgnoreCase("color")) {
                    if (!choice.equalsIgnoreCase("red") && !choice.equalsIgnoreCase("black") && !choice.equalsIgnoreCase("green")) {
                        System.out.println("Invalid color.\n");
                        continue;
                }
                b.type = "color";
                b.color = choice.toLowerCase(); // <--- normalize to lowercase
}

                else {
                    System.out.println("Invalid bet type.\n");
                    continue;
                }

                // Deduct balance immediately
                balance -= amount;
                totalBet += amount;

                bets.add(b);
                System.out.printf("Bet accepted! New balance: PHP%.2f\n\n", balance);
            }

            // ----------------------------------------------------
            // Wheel animation (smoother)
            // ----------------------------------------------------
            clearScreen();
            System.out.println("\nSpinning the wheel...\n");

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
                x = Math.max(0, Math.min(WIDTH - 2, x));
                y = Math.max(0, Math.min(HEIGHT - 1, y));
                px[i] = x;
                py[i] = y;
            }

            char[][] canvas = buildBaseCanvas(WIDTH, HEIGHT, centerX, centerY, radiusX, radiusY);
            for (int i = 0; i < pockets; i++) drawSeparator(canvas, centerX, centerY, ang[i], (int)(radiusX * 0.78));

            int startIndex = rnd.nextInt(pockets);
            int finalIndex = rnd.nextInt(pockets);

            int frames = 80;
            int totalMs = 2000;
            int sleepMs = Math.max(1, totalMs / frames);
            int laps = 5;
            int totalSteps = laps * pockets + ((finalIndex - startIndex) % pockets + pockets) % pockets;

            for (int f = 0; f < frames; f++) {
                double t = f / (double)(frames - 1);
                // smooth easing
                double ease = 1 - Math.pow(1 - t, 3);
                int step = (int)Math.round(ease * totalSteps);
                int current = (startIndex + step) % pockets;

                System.out.print(CURSOR_HOME);
                renderFrame(canvas, px, py, pockets, current);

                try { Thread.sleep(sleepMs); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }

            System.out.print(CURSOR_HOME);
            renderFrame(canvas, px, py, pockets, finalIndex);

            for (int i = 0; i < 6; i++) {
                System.out.print(CURSOR_HOME);
                if (i % 2 == 0) renderFrame(canvas, px, py, pockets, finalIndex);
                else renderFrameWithoutPocket(canvas, px, py, pockets, finalIndex);
                try { Thread.sleep(180); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }

            String winColor = COLOR[finalIndex] == 'R' ? "red" : COLOR[finalIndex] == 'B' ? "black" : "green";
            String winColorCode = COLOR[finalIndex] == 'R' ? RED_BG : COLOR[finalIndex] == 'B' ? BLACK_BG : GREEN_BG;
            int winNumber = NUMBERS[finalIndex];

            System.out.println("============================ Result =============================");
            System.out.println("\nResult: " + winColorCode + WHITE + formatNumber(winNumber) + RESET + " " + winColor.toUpperCase());

            // ---------------- MULTI-BET EVALUATION ----------------
            double winnings = 0;

            for (Bet b : bets) {
                if (b.type.equals("number")) {
                    if (b.number == winNumber) {
                        double win = b.amount * 35;
                        winnings += win;
                        System.out.printf(GREEN_BG + WHITE + "WIN (Number %d): +PHP%.2f\n" + RESET, b.number, win);
                    } else {
                        System.out.printf(RED_BG + WHITE + "LOSE (Number %d)\n" + RESET, b.number);
                    }
                }

                if (b.type.equals("color")) {
                    if (b.color.equals(winColor)) {
                        double win = b.amount * 2;
                        winnings += win;
                        System.out.printf(GREEN_BG + WHITE + "WIN (Color %s): +PHP%.2f\n" + RESET, b.color, win);
                    } else {
                        System.out.printf(RED_BG + WHITE + "LOSE (Color %s)\n" + RESET, b.color);
                    }
                }

            }

            balance += winnings;

            System.out.printf("\nTotal Bet: PHP%.2f\n", totalBet);
            System.out.printf("Total Winnings: PHP%.2f\n", winnings);
            System.out.printf("New Balance: PHP%.2f\n", balance);

            // ---------------- Continue or Exit ----------------
            if (balance <= 0) {
                System.out.println(RED_BG + WHITE + "You don't have enough balance to continue!" + RESET);
                break;
            }

            System.out.println("\n1. Continue playing");
            System.out.println("2. Exit to main menu");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();
            while (!choice.equals("1") && !choice.equals("2")) {
                System.out.print("Invalid option. Choose 1 or 2: ");
                choice = scanner.nextLine().trim();
            }
            if (choice.equals("1")) clearScreen();
            if (choice.equals("2")) { clearScreen(); keepPlaying = false; }
        }

        return balance;
    }

    // ---------------- Helper methods ----------------

    private static void displayRouletteTable() {
        int[][] table = {
            {3,6,9,12,15,18,21,24,27,30,33,36},
            {2,5,8,11,14,17,20,23,26,29,32,35},
            {1,4,7,10,13,16,19,22,25,28,31,34}
        };

        System.out.println("\n=== European Roulette Table ===\n");

        int cols = table[0].length + 1;
        StringBuilder separator = new StringBuilder();
        for (int c = 0; c < cols; c++) separator.append("+----");
        separator.append("+");

        System.out.println(separator);
        System.out.print("|" + colorNameChar(0) + " ");
        for (int i = 0; i < table[0].length; i++) System.out.print("|" + colorNameChar(table[0][i]) + " ");
        System.out.println("|");
        System.out.println(separator);

        for (int r = 1; r < 3; r++) {
            System.out.print("|    ");
            for (int c = 0; c < table[r].length; c++) System.out.print("|" + colorNameChar(table[r][c]) + " ");
            System.out.println("|");
            System.out.println(separator);
        }
        System.out.println();
    }

    private static String colorNameChar(int number) {
        char c = getColorOfNumber(number);
        String numStr = formatNumber(number);
        switch (c) {
            case 'R': return RED_BG + WHITE + numStr + RESET;
            case 'B': return BLACK_BG + WHITE + numStr + RESET;
            case 'G': return GREEN_BG + WHITE + numStr + RESET;
            default: return numStr;
        }
    }

    private static char getColorOfNumber(int number) {
        for (int i = 0; i < NUMBERS.length; i++) if (NUMBERS[i] == number) return COLOR[i];
        return ' ';
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

    static class Bet {
        String type;   // "color" or "number"
        String color;  // red, black, green (if color bet)
        int number;    // 0–36 (if number bet)
        double amount; // bet value
    }

    // ---------------- Wheel animation methods ----------------
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
}

