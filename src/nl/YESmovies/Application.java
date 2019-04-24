package nl.YESmovies;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // Scanner

        boolean keepGoing = true;

        do {
            Scanner reader = new Scanner(System.in);

            System.out.println("If you want to add a new profile, press 'p'. If you want to add a new movie, press 'm'." +
                    "If you want to add a new rating, press r. If you want to quit, press 'q'.");

            String userInput = reader.nextLine();

            if (userInput.equals("p")) {
                // Add Profile
            } else if (userInput.equals("m")) {
                // Add Movie
            } else if (userInput.equals("r")) {
                // Add Rating






                do {
                    System.out.println("To rate a movie, please enter your username. To return to main screen, press c");

                    String userName = reader.nextLine().trim();
                    /*if (userName == "c"){
                    continue MAIN_LOOP;
                    }
                    else */
                    if (Profile.profileList.contains(userName)) {
                        do{
                            System.out.println("You are now rating as user: " + userName + "\nWhat movie would you like to rate?, please enter the full movie title. To return to main screen press c");
                            String movieTitle = reader.nextLine().trim();
                            /*if (movieTitle == "c"){
                            continue MAIN_LOOP;
                            }
                            else */
                            if(Movie.movieList.contains(movieTitle)){
                                do {
                                    System.out.println("You are rating " + movieTitle + "\nHow would you rate this movie? Enter a rating between 0.0 and 10.0. To return to main screen press c");

                                    double movieRating = Double.parseDouble(reader.nextLine());
                                    /*if (movieTitle == "c"){
                                    continue MAIN_LOOP;
                                    }
                                    else */
                                    if (movieRating >= 0 & movieRating <= 10) {
                                        movieRating = (double) Math.round(movieRating * 10) / 10;
                                    } else {
                                        System.out.println("that is not a valid rating, please try again");
                                        continue;
                                    }
                                }
                                while(true);

                            } else{
                                System.out.println("Movie not found, please try again.");
                                continue;
                            }
                        }while(true);

                    } else {
                        System.out.println("Username not found, please try again.");
                        continue;
                    }

                }while(true);














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
