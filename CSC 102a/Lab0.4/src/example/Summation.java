//package example;
//
//import java.util.Scanner;
///*
//Lab 0.4 Number 5
// */
//public class Summation {
//
//    static int sum_nums(int n){
//
//        int ans = 0;
//
//        // Use a for loop to iterate through all of the integers until we reach the users number
//        // Add the integer to the next integer
//        for (int i = 1; i <= n; i++){
//            ans = ans + i;
//        }
//
//        return ans;
//    }
//
//    public static void main(String[] args){
//
//        Scanner keyboard = new Scanner(System.in);
//        int user_input;
//
//        // Get a user to input a number
//        System.out.println("Find the summation of an integer");
//
//        boolean ask = true;
//
//        // Keep asking the user for a number until they enter 0
//        // When they enter 0, the loop will stop
//        while(ask){
//            System.out.println("Enter an integer or enter 0 to quit: ");
//            user_input = keyboard.nextInt();
//            keyboard.nextLine();
//            // If the input is not 0, print out the answer
//            if (user_input != 0){
//                System.out.println(sum_nums(user_input));
//            } else {
//                // If the input is 0, the loop will stop
//                System.out.println("Goodbye.");
//                ask = false;
//            }
//        }
//    }
//}
