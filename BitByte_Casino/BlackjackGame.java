//  Enhanced Blackjack Game (Real Rules)
class BlackjackGame extends BitByteCasinoGame {
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String[] suits = {"♠", "♥", "♦", "♣"};

    // ✅ FIXED: Safe value extraction (handles "8♣" or "10♦" properly)
    private int getCardValue(String card) {
        // remove suit symbols, keep only rank
        String rank = card.replaceAll("[^A0-9JQK]", "");

        switch (rank) {
            case "A": return 11;
            case "J":
            case "Q":
            case "K": return 10;
            default: return Integer.parseInt(rank);
        }
    }

    private int calculateTotal(java.util.List<String> hand) {
        int total = 0;
        int aces = 0;
        for (String card : hand) {
            int value = getCardValue(card);
            total += value;
            if (card.startsWith("A")) aces++;
        }
        // Adjust Aces if total > 21
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

    private void printHand(String owner, java.util.List<String> hand) {
        System.out.println(owner + " hand: " + String.join("  ", hand) + " (Total: " + calculateTotal(hand) + ")");
    }

    private String drawCard() {
        return ranks[rand.nextInt(ranks.length)] + suits[rand.nextInt(suits.length)];
    }

    @Override
    public double play(double balance) {
        System.out.print("Enter your bet: PHP");
        double bet = sc.nextDouble();
        if (bet > balance) {
            System.out.println("Not enough balance!");
            return balance;
        }

        // Deal initial hands
        java.util.List<String> playerHand = new java.util.ArrayList<>();
        java.util.List<String> dealerHand = new java.util.ArrayList<>();

        playerHand.add(drawCard());
        playerHand.add(drawCard());
        dealerHand.add(drawCard());
        dealerHand.add(drawCard());

        System.out.println("\nDealer's hand: " + dealerHand.get(0) + " [Hidden]");
        printHand("Your", playerHand);

        // Check for blackjack
        if (calculateTotal(playerHand) == 21) {
            if (calculateTotal(dealerHand) == 21) {
                System.out.println("Both you and the dealer have Blackjack! Push!");
                return balance;
            } else {
                System.out.println("🎉 Blackjack! You win PHP" + (bet * 1.5) + "!");
                return balance + bet * 1.5;
            }
        }

        // Player's turn
        boolean playerBust = false;
        boolean doubled = false;

        while (true) {
            System.out.println("\nChoose action:");
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            System.out.println("3. Double Down");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) { // Hit
                playerHand.add(drawCard());
                printHand("Your", playerHand);
                if (calculateTotal(playerHand) > 21) {
                    System.out.println("💥 You bust!");
                    playerBust = true;
                    break;
                }
            } else if (choice == 2) { // Stand
                break;
            } else if (choice == 3) { // Double Down
                if (balance < bet * 2) {
                    System.out.println("Not enough balance to double down!");
                    continue;
                }
                bet *= 2;
                playerHand.add(drawCard());
                printHand("Your", playerHand);
                doubled = true;
                if (calculateTotal(playerHand) > 21) {
                    System.out.println("💥 You bust!");
                    playerBust = true;
                }
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        // Dealer's turn
        if (!playerBust) {
            System.out.println("\nDealer reveals their hand...");
            printHand("Dealer's", dealerHand);

            while (calculateTotal(dealerHand) < 17) {
                System.out.println("Dealer hits...");
                dealerHand.add(drawCard());
                printHand("Dealer's", dealerHand);
            }

            int playerTotal = calculateTotal(playerHand);
            int dealerTotal = calculateTotal(dealerHand);

            System.out.println("\nYour total: " + playerTotal);
            System.out.println("Dealer's total: " + dealerTotal);

            if (dealerTotal > 21) {
                System.out.println("Dealer busts! You win ₱" + bet + "!");
                balance += bet;
            } else if (playerTotal > dealerTotal) {
                System.out.println("You win PHP" + bet + "!");
                balance += bet;
            } else if (playerTotal < dealerTotal) {
                System.out.println("You lose PHP" + bet + ".");
                balance -= bet;
            } else {
                System.out.println("Push! No one wins.");
            }
        } else {
            balance -= bet;
        }

        return balance;
    }
}
