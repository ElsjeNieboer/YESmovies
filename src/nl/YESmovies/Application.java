package nl.YESmovies;

import java.util.Scanner;

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
                boolean retryEnterUsername = true;
                String newUsername;
                System.out.println("What username would you like to use?");
                do {
                    newUsername = reader.nextLine();
                    // check if username is unique
                    if (Profile.usernameList.contains(newUsername)) {
                        System.out.println("The username you entered is already in use. Please enter a different username.");
                    } else {
                        retryEnterUsername = false;
                    }
                } while (retryEnterUsername);
                Profile newProfile = new Profile(newUsername);

                // adding/removing genres to/from the int[] preferred genres, where index 0 = action, 1 = drama, 2 = horror, and 3 = fantasy
                System.out.println("Thank you for entering a unique username.");
                boolean retryEnterPreferredGenres = true;
                do {
                    System.out.println("Please enter your preferred movie genres to proceed by selecting the numbers indicated in the list below. \n" +
                            "If you would like to remove genres from your preferences, enter the same number with a '-' in front of it. \n " +
                            "Selectable genres: 1: Action, 2: Drama, 3: Horror, 4: Fantasy");
                    String chosenPreferredGenres = reader.nextLine();
                    if (chosenPreferredGenres.contains("1") && chosenPreferredGenres.indexOf('1') == 0) {
                        newProfile.addPreferredGenres(0);
                    } else if (chosenPreferredGenres.contains("1") && chosenPreferredGenres.charAt(chosenPreferredGenres.indexOf('1')-1) != '-') {
                        newProfile.addPreferredGenres(0);
                    }
                    if (chosenPreferredGenres.contains("2") && chosenPreferredGenres.indexOf('2') == 0) {
                        newProfile.addPreferredGenres(1);
                    } else if (chosenPreferredGenres.contains("2") && chosenPreferredGenres.charAt(chosenPreferredGenres.indexOf('2')-1) != '-') {
                        newProfile.addPreferredGenres(1);
                    }
                    if (chosenPreferredGenres.contains("3") && chosenPreferredGenres.indexOf('3') == 0) {
                        newProfile.addPreferredGenres(2);
                    } else if (chosenPreferredGenres.contains("3") && chosenPreferredGenres.charAt(chosenPreferredGenres.indexOf('3')-1) != '-') {
                        newProfile.addPreferredGenres(2);
                    }
                    if (chosenPreferredGenres.contains("4") && chosenPreferredGenres.indexOf('4') == 0) {
                        newProfile.addPreferredGenres(3);
                    } else if (chosenPreferredGenres.contains("4") && chosenPreferredGenres.charAt(chosenPreferredGenres.indexOf('4')-1) != '-') {
                        newProfile.addPreferredGenres(3);
                    }
                    if (chosenPreferredGenres.contains("-1")) {
                        newProfile.removePreferredGenres(0);
                    }
                    if (chosenPreferredGenres.contains("-2")) {
                        newProfile.removePreferredGenres(1);
                    }
                    if (chosenPreferredGenres.contains("-3")) {
                        newProfile.removePreferredGenres(2);
                    }
                    if (chosenPreferredGenres.contains("-4")) {
                        newProfile.removePreferredGenres(3);
                    }
                    System.out.println("The genres you have chosen are: "+ newProfile.getPreferredGenresText()+". \n " +
                            "If you are happy with your selection, press 'y'. If you would like to edit your genre selection, press any other key.");
                    String changeRetryEnterPreferredGenres = reader.nextLine();
                    if (changeRetryEnterPreferredGenres.equals("y")) {
                        retryEnterPreferredGenres = false;
                    }
                } while (retryEnterPreferredGenres);

            } else if (userInput.equals("m")) {
                // Add Movie
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
