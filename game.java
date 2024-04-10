import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain = 'y';

        while (playAgain == 'y' || playAgain == 'Y') {
            Game game = new Game();
            game.displayWelcomeMessage();

            boolean guessedCorrectly = false;
            while (!guessedCorrectly) {
                game.generateNumberToBeGuessed();
                game.displayPleaseGuessMessage();

                int guess = scanner.nextInt();
                game.makeGuess(guess);

                if (game.isCorrectGuess()) {
                    guessedCorrectly = true;
                    game.displayCorrectGuessMessage();
                } else {
                    game.displayGuessAgainMessage();
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

class Game {
    private int number;
    private int guessNumber;
    private int counter;

    public Game() {
        this.number = 0;
        this.guessNumber = 0;
        this.counter = 0;
    }

    public void generateNumberToBeGuessed() {
        Random rand = new Random();
        this.number = rand.nextInt(100) + 1;
    }

    public void makeGuess(int guess) {
        this.guessNumber = guess;
        this.counter++;
    }

    public boolean isCorrectGuess() {
        return this.guessNumber == this.number;
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Number Guessing Game!");
    }

    public void displayPleaseGuessMessage() {
        System.out.println("Please guess a number between 1 and 100:");
    }

    public void displayCorrectGuessMessage() {
        if (counter <= 3) {
            System.out.println("Great work! You are a mathematical wizard.");
        } else if (counter >= 4 && counter <= 7) {
            System.out.println("Not too bad! You’ve got some potential.");
        } else {
            System.out.println("What took you so long.");
        }
    }

    public void displayGuessAgainMessage() {
        int difference = Math.abs(guessNumber - number);

        if (guessNumber > number) {
            if (difference > 10) {
                System.out.println("Way too high! Guess again.");
            } else {
                System.out.println("Too high! Guess again.");
            }
        } else {
            if (difference > 10) {
                System.out.println("Way too low! Guess again.");
            } else {
                System.out.println("Too low! Guess again.");
            }
        }
    }
}
