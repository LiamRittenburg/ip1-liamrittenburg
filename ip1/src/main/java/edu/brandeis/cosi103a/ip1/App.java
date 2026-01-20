package edu.brandeis.cosi103a.ip1;

/**
 *  A program that creates a simple dice game in which there are two human players (controlled from the command line)
 *  and each player rolls a die (a random number between 1 and 6). The player can choose to reroll up to 2 times. Once the player chooses
 *  to end their turn, the value of the die is added to their score. Each player gets 10 turns. The player with the highest score at the end of the game wins.
 */
public class App 
{
    public static void main( String[] args )
    {
        int player1Score = 0;
        int player2Score = 0;
        int turns = 10;
        for (int turn = 1; turn <= turns; turn++) {
            System.out.println("Turn " + turn);
            player1Score += playTurn("Player 1");
            player2Score += playTurn("Player 2");
        }
        System.out.println("Final Scores:");
        System.out.println("Player 1: " + player1Score);
        System.out.println("Player 2: " + player2Score);
        if (player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
    }
    }

    public static int playTurn(String playerName) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int roll = rollDie();
        System.out.println(playerName + " rolled a " + roll);
        int rerolls = 2;
        while (rerolls > 0) {
            System.out.println(playerName + ", do you want to reroll? (y/n)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y")) {
                roll = rollDie();
                System.out.println(playerName + " rolled a " + roll);
                rerolls--;
            } else {
                break;
            }
        }
        System.out.println(playerName + "'s turn ends with a roll of " + roll);
        return roll;
    }

    public static int rollDie() {
        return (int)(Math.random() * 6) + 1;
    }
}
