import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain = 'y';

        while (playAgain == 'y' || playAgain == 'Y') {
            Game game = new Game();
            game.displayWelcomeMessage();
            game.generateNumberToBeGuessed();
            
            boolean guessedCorrectly = false;
            while (!guessedCorrectly) {
                
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