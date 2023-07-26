package lv.kipijz;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int GAME_ROUNDS = 3;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var playerScore = 0;
        var computerScore = 0;

        for (int i = 0; i < GAME_ROUNDS; i++) {
            System.out.println("Make a move!");

            Choice playerChoice = getPlayerChoice(scanner);
            var randomIndex = new Random().nextInt(Choice.values().length);
            var computerChoice = Choice.values()[randomIndex];

            System.out.println("Player choice:" + playerChoice);
            System.out.println("Computer choice:" + computerChoice);

            if (!(playerChoice == computerChoice)) {
                if (playerWins(playerChoice, computerChoice)) {
                    playerScore++;
                } else {
                    computerScore++;
                }
            }
        }

        printWinner(playerScore, computerScore);
    }

    private static void printWinner(int playerScore, int computerScore) {
        if (playerScore > computerScore) {
            System.out.println("You won!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer won!");
        } else {
            System.out.println("Draw");
        }
    }

    private static Choice getPlayerChoice(Scanner scanner) {
        var playerChoice = Choice.map(scanner.nextLine());
        while (playerChoice == null) {
            System.out.println("Invalid move, make a move!");
            playerChoice = Choice.map(scanner.nextLine());
        }
        return playerChoice;
    }

    private static boolean playerWins(Choice playerChoice, Choice computerChoice) {
        if (playerChoice == Choice.ROCK) {
            return computerChoice == Choice.SCISSORS || computerChoice == Choice.LIZARD;
        } else if (playerChoice == Choice.SCISSORS) {
            return computerChoice == Choice.PAPER || computerChoice == Choice.LIZARD;
        } else if (playerChoice == Choice.PAPER) {
            return computerChoice == Choice.ROCK || computerChoice == Choice.SPOCK;
        } else if (playerChoice == Choice.LIZARD) {
            return computerChoice == Choice.SPOCK || computerChoice == Choice.PAPER;
        } else {
            return playerChoice == Choice.SPOCK || computerChoice == Choice.ROCK;
        }
    }
}
