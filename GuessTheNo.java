 import java.util.Scanner;
import java.util.Random;

public class GuessTheNo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 8;
        int totalRounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have " + totalRounds + " rounds to play.");
        
        for (int round = 1; round <= totalRounds; round++) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + round + ": I've chosen a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");
            
            while (!hasGuessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please guess a number between " + lowerBound + " and " + upperBound + ".");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Higher! Try again.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Lower! Try again.");
                } else {
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                    System.out.println("Round " + round + " score: " + roundScore + " points");
                    System.out.println("Total score: " + totalScore + " points");
                    hasGuessedCorrectly = true;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts for this round. The number was " + numberToGuess + ".");
            }

            if (round < totalRounds) {
                System.out.println("End of round " + round + ". You have " + (totalRounds - round) + " rounds left.");
            }
        }

        System.out.println("Game over! Your total score is: " + totalScore + " points");
        scanner.close();
    }
}

    