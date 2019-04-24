package nl.YESmovies;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // Scanner
        Scanner reader = new Scanner(System.in);

        System.out.println("If you want to add a new profile, press 'p'. If you want to add a new movie, press 'm'." +
                "If you want to add a new rating, press r.");

        String userInput = reader.nextLine();

        if(userInput.equals("p")){
            // Add Profile
        } else if(userInput.equals("m")){
            // Add Movie
        } else if(userInput.equals("r")){
            // Add Rating
        } else {
            System.out.println("Please enter a valid option. If you want to add a new profile, press 'p'. If you" +
                    " want to add a new movie, press 'm'.If you want to add a new rating, press r.");
        }

        // Add Profile

        // Add Movie

        // Add Rating
    }
}
