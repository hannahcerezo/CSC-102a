//package example;
//
//import java.util.Scanner;
///*
//Lab 0.4 Number 4
// */
//
//public class BoxCalculator {
//
//    // Function to calculate the volume of a box
//    static int volume(int n, int m, int s){
//
//        int box_volume = n*m*s;
//
//        return box_volume;
//    }
//    public static void main(String[] args){
//
//        Scanner keyboard = new Scanner(System.in);
//
//        // Get user input for length, width and height
//        int length;
//        int width;
//        int height;
//        boolean calculate_for_me = true;
//
//        /* While loop to continuously ask if the user wants to calculate the volume of a box.
//        If they do want to continue to calculate, they will be asked to provide a length, width and a height.
//        The volume will be printed. If they no longer wish to continue, they should enter 0
//        0 is the sentinel value
//         */
//        while (calculate_for_me){
//
//            System.out.println("Enter '1' to calculate the volume of a box or enter '0' to quit");
//
//            int choice;
//            choice = keyboard.nextInt();
//
//            if (choice == 1){
//                System.out.println("Enter a length: ");
//                length = keyboard.nextInt();
//                System.out.println("Enter a width: ");
//                width = keyboard.nextInt();
//                System.out.println("Enter a height: ");
//                height = keyboard.nextInt();
//                keyboard.nextLine();
//
//                System.out.println("The volume is " + volume(length, width, height) + "\n");
//
//            } else {
//                System.out.println("Finish");
//                calculate_for_me = false;
//            }
//        }
//    }
//}
