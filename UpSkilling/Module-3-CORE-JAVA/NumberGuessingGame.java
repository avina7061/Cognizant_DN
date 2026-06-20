import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        int target = ran.nextInt(100) + 1;

        int guess;
        int attempts = 0;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("I have chosen a number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess > target) {
                System.out.println("Too High! Try again.");
            } else if (guess < target) {
                System.out.println("Too Low! Try again.");
            } else {
                System.out.println("Congratulations!");
                System.out.println("You guessed the number in " + attempts + " attempts.");
            }

        } while (guess != target);

        sc.close();
    }
}
