import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hannahcerezo
 * CSC 102 Lab 2
 */

public class Insert {

    public static void main(String [] args){
        // Read in a list of numbers from the keyboard and store in ArrayList

        Scanner keyboard = new Scanner(System.in);

        // Create an ArrayList
        ArrayList<Integer> sorted_array = new ArrayList<>();

        // Boolean for the while loop to continue asking for integers
        boolean ask = true;

        // the string to save to users input
        // String because must be able to read in "exit" when user wants to stop entering Integers
        String user_input;

        // When the user does not enter "exit", they will most likely be entering an integer will
        // parse the string to an Integer to add to the sorted_array ArrayList
        int user_input_int;


        while(ask){

            // Ask the user for an integer
            System.out.println("Enter an integer or 'exit' to quit: ");

            user_input = keyboard.nextLine();

            // If the user enters exit, ask = false to end the loop
            if(user_input.equals("exit")){
                ask = false;
            }else{
                // Parse the string into an int variable
                user_input_int = Integer.parseInt(user_input);
                sorted_array.add(user_input_int);

                // iterate through the array. if the current input is less, put that input into
                // that spot in the array
                for (int j = 0; j < sorted_array.size(); j++){
                    if (sorted_array.get(j) > user_input_int) {
                        sorted_array.add(j, user_input_int);
                        sorted_array.remove(sorted_array.size() - 1);
                        // Had to remove the last item because it kept adding the current number
                        // to the end
                        break;
                    }
                }System.out.println("Your sorted Array: " + sorted_array);
            }
        }
    }
}

