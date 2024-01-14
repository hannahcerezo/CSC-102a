package example;
import java.util.Scanner;

//public class hello {
//
//    public static void main(String[] args) {
//        /*
//        Create a number guessing game. Program generates a random number in the range 1,100.
//        Continually prompt the user to guess the number.
//        Have the user enter a number from the keyboard.
//        If guess is correct, congratulate the user, tell them how many guesses it took to reveal the number.
//        If guess is not correct supply a hint by telling the user whether the number is higher or lower than the guess
//        they supplied. Then promp the user again and read the next guess.
//        Allow the user to play multiple times, use a sentinel val when they want to exit.
//        Display a banner informing the user of the rules of the game at each iteration
//         */
//
//        boolean full_play = true;
//        while (full_play){
//
//            int user_choice;
//            System.out.println("------------------------");
//            System.out.println("Welcome to the number guessing game!");
//            System.out.println("Rules: Guess a number from 1 - 100");
//            System.out.println("Enter a number using your keyboard. If your number is incorrect you will be supplied with a hint");
//            System.out.println("------------------------");
//            //Press 1 to play, Press 2 to quit
//            Scanner keyboard = new Scanner(System.in);
//            System.out.println("Input 1 to start playing: ");
//            user_choice = keyboard.nextInt();
//
//            // Switch statement for if user wants to play or quit
//
//            switch (user_choice) {
//                // User wants to play
//
//                case 1:
//                    // Generate a random number 1,100.
//                    int max = 100;
//                    int min = 1;
//                    int rand_int = (int) Math.floor(Math.random() * (max - min + 1) + min); // Generate a random number 1 - 100
//                    // Have user enter their own number
//                    int user_guess;
//
//                    // Keep track of the incorrect guesses
//                    int guess_tracker = 1;
//
//                    // While loop to keep asking for a new number if their guess is incorrect
//                    boolean playing = true;
//                    while (playing) {
//
//                        System.out.println("Input your guess then press enter: ");
//                        user_guess = keyboard.nextInt();
//                        keyboard.nextLine();
//
//                        if (user_guess != rand_int) {
//                            System.out.println("Your guess is incorrect.");
//
//                            // Hint if rand_int is higher or lower than user_guess
//                            if (user_guess > rand_int) {
//                                System.out.println("The number is lower than your guess.");
//                            } else {
//                                System.out.println("The number is higher than your guess.");
//                            }
//
//                            guess_tracker = guess_tracker + 1;
//
//                        } else {
//                            System.out.println("Congratulations! Your guess is correct.");
//                            System.out.println("It took you " + guess_tracker + " guess's.");
//
//                            playing = false;
//                        }
//                    }
//
//                case 2:
//                    // Ask the user if they want to play again
//                    System.out.println("Would you like the play again? Yes or No: ");
//                    String play_again;
//                    play_again = keyboard.next();
//
//                    if (play_again.equals("No")) {
//                        System.out.println("Thank you for playing!");
//                        full_play = false;
//                    }
//            }
//        }
//    }
//}
