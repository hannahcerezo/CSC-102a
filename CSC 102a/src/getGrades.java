import javax.swing.*;
import java.util.ArrayList; // import the ArrayList
import java.util.Collections;


public class getGrades {

    public static void main(String [] args){


        // Ask the user for 10 test grades - make a loop that loops 10 times
        // Store each grade into an ArrayList
        int grade;
        String response;

        // Create and ArrayList
        ArrayList<Integer> grades = new ArrayList<Integer>();

        //Loop through to add each grade entered into the ArrayList
        for (int i = 0; i <= 9; i++){
            response = JOptionPane.showInputDialog("Enter a test grade: ");
            grade = Integer.parseInt(response);
            grades.add(grade);
        }

        // Sort the ArrayList from lowest to highest
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
