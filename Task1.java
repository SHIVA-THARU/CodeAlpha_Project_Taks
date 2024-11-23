import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        // Create an ArrayList to store the grades
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter students' grades (type 'done' to finish):");

        // Loop to accept grades from the teacher
        while (true) {
            System.out.print("Enter grade: ");
            input = scanner.nextLine();

            // Exit the loop if the user types "done"
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                // Add the grade to the list after validating
                double grade = Double.parseDouble(input);
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a grade between 0 and 100.");
                } else {
                    grades.add(grade);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
            }
        }

        // Check if any grades were entered
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            // Calculate the average, highest, and lowest scores
            double total = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                total += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = total / grades.size();

            // Display the results
            System.out.println("\nGrade Summary:");
            System.out.printf("Average score: %.2f%n", average);
            System.out.printf("Highest score: %.2f%n", highest);
            System.out.printf("Lowest score: %.2f%n", lowest);
        }

        scanner.close();
    }
}
