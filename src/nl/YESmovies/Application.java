package nl.YESmovies;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // Scanner

        boolean keepGoing = true;

        ArrayList<Movie> movieList = new ArrayList<>();

        MENU_OPTIONS: do {
            Scanner reader = new Scanner(System.in);

            System.out.println("If you want to add a new profile, press 'p'. If you want to add a new movie, press 'm'." +
                    "If you want to add a new rating, press r. If you want to quit, press 'q'.");

            String userInput = reader.nextLine();

            if (userInput.equals("p")) {
                // Add Profile
            } else if (userInput.equals("m")) {

                boolean addMovie = true;

                do {
                    System.out.println("What is the title of the movie?");

                    String movieName = reader.nextLine();

                    System.out.println("What is the release year?");

                    short releaseYear = 0;

                    boolean enteredValidReleaseYear;

                    do {
                        enteredValidReleaseYear = true;
                        try {
                            releaseYear = Short.parseShort(reader.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("You have entered an invalid release year, please enter the release year in digits.");
                            enteredValidReleaseYear = false;
                        }
                    } while (!enteredValidReleaseYear);

                    String[] genreOptions = {"Action", "Animation", "Comedy", "Drama", "Fantasy", "Horror", "Thriller"};

                    ArrayList<String> genres = new ArrayList<>();

                    System.out.println("Which genre(s) is the movie? Please enter the genre number(s).");

                    for (int i = 0; i < genreOptions.length; i++) {
                        System.out.print(genreOptions[i] + "(" + (i + 1) + ") ");
                        }

                    System.out.println();

                    boolean enteredValidGenre;

                    do {
                        enteredValidGenre = true;

                        String genreInput = reader.nextLine();

                        try {
                            for (int i = 0; i < genreInput.length(); i++) {
                                genres.add(genreOptions[(Character.getNumericValue(genreInput.charAt(i)) - 1)]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("You have entered an invalid genre number, please enter a valid genre number.");

                            enteredValidGenre = false;
                        }
                    } while (!enteredValidGenre);

                    Collections.sort(genres);

                    Movie movie = new Movie(movieName, releaseYear, genres);

                    movieList.add(movie);

                    System.out.println(movie);

                    System.out.println("If you want to add another movie, press 'y', if not press 'n'.");

                    if (reader.nextLine().equals("n")){
                        addMovie = false;
                    }
                } while (addMovie);

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