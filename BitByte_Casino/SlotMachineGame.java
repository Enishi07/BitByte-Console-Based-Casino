
class SlotMachineGame extends BitByteCasinoGame {
    @Override
    public double play(double balance) {
        System.out.print("Enter your bet: PHP");
        double bet = sc.nextDouble();
        if (bet > balance) {
            System.out.println("Not enough balance!");
            return balance;
        }
        else if (bet <= 0 || bet > balance) {}

        String[] symbols = {"^_^", "o_o", "O_O", ">:)", "T_T"};
        String s1 = "", s2 = "", s3 = "";

        System.out.println("\nSpinning...");
        try {
            //  Spin animation (with screen refresh)
            for (int i = 0; i < 12; i++) {
                s1 = symbols[rand.nextInt(symbols.length)];
                s2 = symbols[rand.nextInt(symbols.length)];
                s3 = symbols[rand.nextInt(symbols.length)];
                clearScreen();
                printMachine(s1, s2, s3);
                Thread.sleep(120 + i * 10); // Gradually slow down
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final spin result
        s1 = symbols[rand.nextInt(symbols.length)];
        s2 = symbols[rand.nextInt(symbols.length)];
        s3 = symbols[rand.nextInt(symbols.length)];

        clearScreen();
        printMachine(s1, s2, s3);
        System.out.println();

        // Outcome
        if (s1.equals(s2) && s2.equals(s3)) {
            System.out.println("🎉 JACKPOT! You win PHP" + (bet * 5) + "!");
            balance += bet * 5;
        } else if (s1.equals(s2) || s2.equals(s3) || s1.equals(s3)) {
            System.out.println("Nice! You win PHP" + (bet * 2) + "!");
            balance += bet * 2;
        } else {
            System.out.println("You lose PHP" + bet + ".");
            balance -= bet;
        }

        return balance;
    }

    // 🧱 Slot machine
    private void printMachine(String s1, String s2, String s3) {
        System.out.println("                    ___                     ");
        System.out.println("          ___#####################___       ");
        System.out.println("          ###@@@@@@@@@@@@@@@@@@@@@###       ");
        System.out.println("              ________________               ");
        System.out.println("             |##|           |##|    ####    ");
        System.out.println("             |##|" + s1 + " " + s2 + " " + s3 + "|##|    ----    ");
        System.out.println("             |##|___________|##|    ||||    ");
        System.out.println("             |#################|   |||||    ");
        System.out.println("             |#################|   |||||    ");
        System.out.println("              -----------------     ---     ");
        System.out.println("          ___#####   ██   #####___           ");
        System.out.println("        ###@@@@@@@@@@@@@@@@@@@@@@###         ");
        System.out.println("        |@@@@@@@@@@@@@@@@@@@@@@@@@@|         ");
        System.out.println("        ###@@@@@@@@@@@@@@@@@@@@@@###         ");
        System.out.println("            ---------------------           ");
    }
}
