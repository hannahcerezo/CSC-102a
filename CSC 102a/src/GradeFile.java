import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class GradeFile {

    public static void main(String [] args) {

        // Read in 10 test grades from a file
        // Create the file with 10 test grades from user input


        String input;
        // Wrap in a try/catch for errors
        try {
            FileWriter myWriter = new FileWriter("grades.txt");

            // While loop to ask the user to enter a grade and write it to the grades.txt file
            for(int x = 0; x <= 9; x++){
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter a grade: ");
                // input is a String
                input = keyboard.nextLine();
                myWriter.write(input + "\n");
            }
            myWriter.close();
        } catch (IOException e){
            System.out.println("Error occurred.");
            e.printStackTrace();
        }

        int file_grade;
        // Create and ArrayList
        ArrayList<Integer> grades = new ArrayList<Integer>();

        // Read in the 10 grades from the grades.txt file
        try {
            File myObj = new File("grades.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // While the file is being read, add the grades to the grades ArrayList
                String data = myReader.nextLine();
                // Parse the String and return an integer
                file_grade = Integer.parseInt(data);
                grades.add(file_grade);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Occurred.");
            e.printStackTrace();
        }

        // Sort the Array from lowest to highest
        Collections.sort(grades);

        // Determine the highest and lowest grades entered
        int highest_grade = grades.get(grades.size()-1);
        int lowest_grade = grades.get(0);

        float sum = 0;
        // Calculate the sum of the grades
        for (int j = 0; j <= 9; j++){
            sum = sum + grades.get(j);
        }

        // Divide the sum by the num of items in the list to get the average
        float average = sum / grades.size();

        // Display the Highest grade, lowest grade and average in a display box
        JOptionPane.showMessageDialog(null, "Highest Grade: " +
                highest_grade + "\n" + "Lowest Grade: " +
                lowest_grade + "\n" + "Average: " + average);
    }
}
