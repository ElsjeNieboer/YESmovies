package nl.YESmovies;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // Scanner

        boolean keepGoing = true;

        MENU_OPTIONS: do {
            Scanner reader = new Scanner(System.in);

            System.out.println("If you want to add a new profile, press 'p'. If you want to add a new movie, press 'm'." +
                    "If you want to add a new rating, press r. If you want to quit, press 'q'.");

            String userInput = reader.nextLine();

            if (userInput.equals("p")) {
                // Add Profile
            } else if (userInput.equals("m")) {
                System.out.println("What is the title of the movie?");
                String movieName = reader.nextLine();
                System.out.println("What is the release year?");
                short releaseYear = Short.parseShort(reader.nextLine());
                String[] genreOptions = {"Action", "Animation", "Comedy", "Drama", "Fantasy", "Horror", "Thriller"};
                ArrayList<String> genres = new ArrayList<>();
                System.out.println("Which genre(s) is the movie?");
                for (String genre: genreOptions){
                    System.out.print(genre+" ");
                }
                System.out.println();
                String genreInput = reader.nextLine();
                for (int i = 0; i<genreInput.length(); i++){
                     genres.add(genreOptions[(Character.getNumericValue(genreInput.charAt(i)) - 1)]);
                }
                Movie movie = new Movie(movieName, releaseYear, genres);
                System.out.println(movie);
            } else if (userInput.equals("r")) {
                // Add Rating
            } else if (userInput.equals("q")){
                keepGoing = false;
            } else {
                System.out.println("Please enter a valid option.");
            }
        } while(keepGoing);

        // Add Profile

        // Add Movie


        // Add Rating
    }
}
