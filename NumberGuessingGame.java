import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int maxAttempts = 7;
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int number = rand.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessed) {
                System.out.println("Enter your guess: ");
                int guess = input.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number in " + attempts + " tries.");
                    totalScore++;
                    guessed = true;
                } else if (guess < number) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }

            if (!guessed) {
                System.out.println("You've used all attempts. The number was: " + number);
            }

            System.out.println("Do you want to play again? (yes/no): ");
            String response = input.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your total score: " + totalScore);
        input.close();
    }
}