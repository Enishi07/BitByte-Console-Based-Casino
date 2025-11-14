import java.util.ArrayList;
import java.util.List;

public class CrazyTimeGame extends BitByteCasinoGame {
    // ANSI color and screen controls
    private static final String RESET   = "\u001B[0m";
    private static final String RED_BG  = "\u001B[41m";
    private static final String BLACK_BG= "\u001B[40m";
    private static final String GREEN_BG= "\u001B[42m";
    private static final String YELLOW_BG= "\u001B[43m";
    private static final String BLUE_BG= "\u001B[44m";
    private static final String MAGENTA_BG= "\u001B[45m";
    private static final String CYAN_BG= "\u001B[46m";
    private static final String WHITE   = "\u001B[97m";
    private static final String CURSOR_HOME = "\u001B[H"; // move cursor to top-left

    // Ball styling
    private static final String BALL_BG = "\u001B[46m";  // Cyan background
    private static final String BOLD = "\u001B[1m";
    private static final String BLINK = "\u001B[5m";

    // Crazy Time wheel segments (54 total) in correct wheel order
    private static final String[] SEGMENTS = {
        "1", "10", "2", "5", "1", "CoinFlip", "2", "10", "1", "5", "2", "1", "CashHunt", "5", "1", "2", "10", "1", "Pachinko", "2", "1", "5", "10", "1", "CrazyTime", "2", "1", "5", "1", "10", "2", "1", "5", "10", "1", "2", "5", "1", "10", "2", "1", "5", "10", "1", "2", "5", "1", "10", "2", "1", "5", "10", "1", "2"
    };

    // Colors for segments: 'G' green, 'R' red, 'B' black, 'Y' yellow, 'U' blue, 'M' magenta, 'C' cyan
    private static final char[] COLORS = {
        'G', 'Y', 'R', 'B', 'G', 'U', 'R', 'Y', 'G', 'B', 'R', 'G', 'M', 'B', 'G', 'R', 'Y', 'G', 'C', 'R', 'G', 'B', 'Y', 'G', 'R', 'R', 'G', 'B', 'G', 'Y', 'R', 'G', 'B', 'Y', 'G', 'R', 'B', 'G', 'Y', 'R', 'G', 'B', 'Y', 'G', 'R', 'B', 'G', 'Y', 'R', 'G', 'B', 'Y', 'G', 'R'
    };

    private static final int WIDTH = 69;
    private static final int HEIGHT = 25;

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
        boolean keepPlaying = true;
        while (keepPlaying) {
            clearScreen();
            System.out.println("Welcome to Crazy Time!");
            System.out.printf("Your balance: PHP%.2f\n", balance);
            System.out.print("Enter bet amount: ");
            double bet = sc.nextDouble();
            sc.nextLine(); // consume newline
            if (bet > balance || bet <= 0) {
                System.out.println("Invalid bet!");
                return balance;
            }
            System.out.println("Bet on: 1, 2, 5, 10, CoinFlip, CashHunt, Pachinko, or CrazyTime");
            System.out.print("Your choice: ");
            String betOn = sc.nextLine().trim();

            // Top Slot: random segment and multiplier 1-10
            String topSlot = wheel.get(rand.nextInt(wheel.size()));
            int topMultiplier = rand.nextInt(10) + 1;
            System.out.println("Top Slot: " + topSlot + " with multiplier x" + topMultiplier);

            // Spin wheel animation
            System.out.println("\nSpinning the wheel...\n");

            double centerX = WIDTH / 2.0;
            double centerY = HEIGHT / 2.0;
            double radiusX = WIDTH * 0.38;
            double radiusY = HEIGHT * 0.38;

            int pockets = SEGMENTS.length;
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

            int startIndex = rand.nextInt(pockets);
            int finalIndex = rand.nextInt(pockets);

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

            String result = SEGMENTS[finalIndex];
            System.out.println("============================ Result =============================");
            System.out.println("\nResult: " + segmentColorCode(COLORS[finalIndex]) + WHITE + formatSegment(result) + RESET);

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

            System.out.println("1. Continue playing");
            System.out.println("2. Exit to main menu");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();
            while (!choice.equals("1") && !choice.equals("2")) {
                System.out.print("Invalid option. Choose 1 or 2: ");
                choice = sc.nextLine().trim();
            }
            if (choice.equals("1")) clearScreen();
            if (choice.equals("2")) keepPlaying = false;
        }
        return balance;
    }

    // Helper methods for segment color
    private static String segmentColorCode(char c) {
        switch (c) {
            case 'G': return GREEN_BG;
            case 'R': return RED_BG;
            case 'B': return BLACK_BG;
            case 'Y': return YELLOW_BG;
            case 'U': return BLUE_BG;
            case 'M': return MAGENTA_BG;
            case 'C': return CYAN_BG;
            default: return RESET;
        }
    }

    private static String formatSegment(String s) {
        if (s.length() == 1) return " " + s;
        else if (s.length() == 2) return s;
        else return s.substring(0, 2); // Truncate longer names
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
                    String seg = formatSegment(SEGMENTS[idx]);
                    String color = segmentColorCode(COLORS[idx]);
                    if (idx == bulletIndex) row.append(BALL_BG).append(BLINK).append(BOLD).append(WHITE).append("OO").append(RESET);
                    else row.append(color).append(WHITE).append(seg).append(RESET);
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
                    String seg = formatSegment(SEGMENTS[idx]);
                    String color = segmentColorCode(COLORS[idx]);
                    row.append(color).append(WHITE).append(seg).append(RESET);
                    x += 2;
                } else { row.append(base[y][x]); x++; }
            }
            System.out.println(row.toString());
        }
    }
}
