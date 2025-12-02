import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = random.nextInt(100) + 1;  // Random number between 1 and 100
        int numberOfTries = 0;
        int guess = 0;
        boolean win = false;

        System.out.println("Welcome to the Guess Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        while (!win) {
            System.out.print("Enter your guess: ");
            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // Consume invalid input
                continue;
            }

            numberOfTries++;

            if (guess < 1 || guess > 100) {
                System.out.println("Invalid guess. Please enter a number between 1 and 100.");
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                win = true;
                System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
            }
        }

        scanner.close();
    }
}

