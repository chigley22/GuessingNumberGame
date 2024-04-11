import java.util.Random;

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
        if (guessNumber > number) {
            System.out.println("To High! Guess again.");
        } else{
            System.out.println("To Low! Guess again.");
        }
    }
    // public void displayGuessAgainMessage() {
    //     int difference = Math.abs(guessNumber - number);

    //     if (guessNumber > number) {
    //         if (difference > 10) {
    //             System.out.println("Way too high! Guess again.");
    //         } else {
    //             System.out.println("Too high! Guess again.");
    //         }
    //     } else {
    //         if (difference > 10) {
    //             System.out.println("Way too low! Guess again.");
    //         } else {
    //             System.out.println("Too low! Guess again.");
    //         }
    //     }
    // }
}
