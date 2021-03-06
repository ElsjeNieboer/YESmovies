package nl.YESmovies;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        boolean keepGoing = true;

        MENU_OPTIONS: do {
            Scanner reader = new Scanner(System.in);

            System.out.println("If you want to add a new profile, press 'p'. If you want to add a new movie, press 'm'." +
                    "If you want to add a new rating, press r. If you want to quit, press 'q'.");

            String userInput = reader.nextLine();

            if (userInput.equals("p")) {
                // Add Profile
                boolean retryEnterUsername = true;
                String newUsername;
                do {
                    System.out.println("What username would you like to use?");
                    newUsername = reader.nextLine();
                    // check if username is unique
                    if (Profile.profileList.contains(newUsername)) {
                        System.out.println("The username you entered is already in use. Please enter a different username.");
                    } else {
                        System.out.println("The username you entered is: '"+newUsername+"'. \nIf you are happy with this username, press 'y'. " +
                                "If you wish to make changes, press any other key.");
                        String usernameDone = reader.nextLine();
                        if (usernameDone.equals("y")) {
                        retryEnterUsername = false;
                        }
                    }
                } while (retryEnterUsername);
                Profile newProfile = new Profile(newUsername);
                Profile.profileObjectList.add(newProfile);

                // adding/removing genres to/from the int[] preferred genres
                System.out.println("Thank you for entering a unique username.");
                boolean retryEnterPreferredGenres = true;
                do {
                    System.out.println("Please enter your preferred movie genres to proceed by selecting the numbers indicated in the list below, separated by commas. \n" +
                            "If you would like to remove genres from your preferences, enter the same number with a '-' in front of it.");
                    for (int i =0; i < Movie.genresString.length; i++) {
                        if ((i+1)%12 == 0) {
                            System.out.println(Movie.genresString[i]+"("+(i+1)+")     ");
                        } else {
                            System.out.print(Movie.genresString[i] + "(" + (i + 1) + ")     ");
                        }
                    }
                    System.out.println();
                    String chosenPreferredGenres = reader.nextLine();

                    try {
                        while (chosenPreferredGenres.contains(",")) {
                            String chosenPreferredGenres_a = chosenPreferredGenres.substring(0, chosenPreferredGenres.indexOf(","));
                            if (chosenPreferredGenres_a.charAt(0) == '-') {
                                String chosenPreferredGenres_1 = chosenPreferredGenres_a.substring(1);
                                newProfile.removePreferredGenres(Integer.parseInt(chosenPreferredGenres_1) - 1);
                            } else {
                                newProfile.addPreferredGenres(Integer.parseInt(chosenPreferredGenres_a) - 1);
                            }
                            chosenPreferredGenres = chosenPreferredGenres.substring(chosenPreferredGenres.indexOf(",") + 1);
                        }
                        if (chosenPreferredGenres.charAt(0) == '-') {
                            String chosenPreferredGenres_1 = chosenPreferredGenres.substring(1);
                            newProfile.removePreferredGenres(Integer.parseInt(chosenPreferredGenres_1) - 1);
                        } else {
                            newProfile.addPreferredGenres(Integer.parseInt(chosenPreferredGenres) - 1);
                        }
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println("You have entered an invalid genre number. Please select a number from the list.");
                    }
                    catch (ArrayIndexOutOfBoundsException aioobe) {
                        System.out.println("You have entered an invalid genre number. Please select a number from the list.");
                    }

                    System.out.print("The genres you have chosen are: ");
                    newProfile.getPreferredGenresText();
                    System.out.println();
                    System.out.println("If you are happy with your selection, press 'y'. If you would like to edit your genre selection, press any other key.");
                    String changeRetryEnterPreferredGenres = reader.nextLine();
                    if (changeRetryEnterPreferredGenres.equals("y")) {
                        retryEnterPreferredGenres = false;
                    }
                } while (retryEnterPreferredGenres);

                System.out.println("You have successfully created a new profile with the following username: "+newProfile.getUserName()+".");
                System.out.print("You have entered the following genres as your preferred genres: ");
                newProfile.getPreferredGenresText();
                System.out.println("You will now return to the main menu.");

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


                    float imdbRating = -1;
                    IMDB_LOOP: do {
                        System.out.println("Please enter the IMDB rating of this movie");
                        String imdbRatingInput = reader.nextLine();
                        try {
                            double imdbRatingDouble = Double.parseDouble(imdbRatingInput);
                            if (imdbRatingDouble >= 0 && imdbRatingDouble <= 10) {
                                imdbRatingDouble = (double) Math.round(imdbRatingDouble * 10) / 10;  //round to single digit
                                imdbRating = (float) imdbRatingDouble;
                                break IMDB_LOOP;
                            } else {
                                System.out.println("please enter a number between 0 and 10");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("not a number, please try again");
                        }
                    }while(true);

                    Movie movie = new Movie(movieName, releaseYear, imdbRating);



                    boolean enteredValidGenre;

                    do {
                        enteredValidGenre = true;

                        System.out.println("Which genre(s) is the movie? Please enter the genre number(s).");

                        for (int i = 0; i < Movie.genresString.length; i++) {
                            System.out.print(Movie.genresString[i] + "(" + (i + 1) + ")  ");
                            if((i+1) % 12 == 0){
                                System.out.println();
                            }
                        }
                        System.out.println();

                        String genreInput = reader.nextLine();

                        try {
                            while (genreInput.contains(",")) {
                                String genreInput_a = genreInput.substring(0, genreInput.indexOf(","));
                                movie.addGenre(Integer.parseInt(genreInput_a.trim()) - 1);
                                genreInput = genreInput.substring(genreInput.indexOf(",") + 1);
                            }

                            movie.addGenre(Integer.parseInt(genreInput.trim()) - 1);

                        } catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("You have entered an invalid genre number, please enter a valid genre number.");

                            enteredValidGenre = false;
                        } catch (NumberFormatException e){

                        } finally {
                            System.out.println("The chosen genres are " + movie.getGenreString());
                            System.out.println("If you are content with the chosen genres, press 'y', if not press any other key.");
                            if (!reader.nextLine().equals("y")) {
                                enteredValidGenre = false;
                            }
                        }

                    } while (!enteredValidGenre);

                    Movie.movieObjectList.add(movie);

                    System.out.println(movie);

                    System.out.println("If you want to add another movie, press 'y', if not press any other key.");

                    if (!reader.nextLine().equals("y")){
                        addMovie = false;
                    }
                } while (addMovie);

            } else if (userInput.equals("r")) {
                // Add Rating

                do {
                    System.out.println("To rate a movie, please enter your username. To return to main screen, press c");

                    String userName = reader.nextLine().trim();
                    if (userName.equals("c")){
                        continue MENU_OPTIONS;
                    } else if (Profile.profileList.contains(userName)) {
                        do{
                            System.out.println("You are now rating as user: " + userName + "\nWhat movie would you like to rate?, please enter the full movie title. To return to main screen press c");
                            String movieTitle = reader.nextLine().trim();
                            if (movieTitle.equals("c")){
                                continue MENU_OPTIONS;
                            } else if(Movie.movieList.contains(movieTitle)){ // if exists movietitle
                                RATE_MOVIE: do {
                                    System.out.println("You are rating " + movieTitle + "\nHow would you rate this movie? Enter a rating between 0.0 and 10.0. To return to main screen press c");
                                    String movieRatingInput = reader.nextLine().trim();

                                    try{
                                        double movieRating = Double.parseDouble(movieRatingInput);
                                        if (movieRating >= 0 && movieRating <= 10) {
                                            movieRating = (double) Math.round(movieRating * 10) / 10;  //round to single digit

                                            System.out.println("Would you like to rate " + movieTitle + " with a " + movieRating + "?" +
                                                    "\nTo confirm, press y. To cancel, press n. To cancel and return to main screen, press c");
                                            String rerate = reader.nextLine().trim();
                                            if(rerate.equals("y")){

                                                // Add rating to movie-ratings list and calculate new mean rating for that movie
                                                for(int i = 0; i<Movie.movieObjectList.size();i++){
                                                    if (Movie.movieObjectList.get(i).getTitle().equals(movieTitle)){
                                                        Movie.movieObjectList.get(i).addYesRating(userName,(float)movieRating);
                                                    }
                                                }

                                                // Add rating for this specific movie to profile
                                                for(int i = 0; i<Profile.profileObjectList.size();i++){
                                                    if (Profile.profileObjectList.get(i).getUserName().equals(userName)){
                                                        Profile.profileObjectList.get(i).setMyRating(movieTitle,(float)movieRating);
                                                    }
                                                }

                                                System.out.println("Thank you for rating this movie!");
                                                continue MENU_OPTIONS;
                                            } else if(rerate.equals("c")){
                                                continue MENU_OPTIONS;
                                            } else if(rerate.equals("n")){
                                                continue RATE_MOVIE;
                                            } else {
                                                System.out.println("please enter a valid option");
                                            }
                                        }else {
                                            System.out.println("that is not a valid rating (not within the required range), please try again");
                                        }
                                    }
                                    catch(NumberFormatException e){
                                        if (movieRatingInput.equals("c")) {
                                            continue MENU_OPTIONS;
                                        } else {
                                        System.out.println("that is not a valid rating (not a number), please try again");
                                        }
                                    }
                                }
                                while(true);

                            } else{
                                System.out.println("Movie not found, please try again.");
                            }
                        }while(true);

                    } else {
                        System.out.println("Username not found, please try again.");
                    }

                }while(true);
            } else if (userInput.equals("q")) {
                keepGoing = false;
            } else if (userInput.equals("Test")){

                try {
                    System.out.println("movieList: " + Arrays.toString(Movie.movieList.toArray()));
                    System.out.println("profileList: " + Arrays.toString(Profile.profileList.toArray()));
                    TEST_LOOP: do {
                        System.out.println("\nto get info on a specific Movie or Profile object, type 'm' or 'p' followed by the name/title found in the above list" +
                                "\nTo get info on all movies or all profiles, type 'all m' or 'all p'" +
                                "\nTo return to main menu, type c");
                        String entry = reader.nextLine();
                        if (entry.trim().charAt(0) == 'm') {
                            if (Movie.movieList.contains(entry.substring(1).trim())) {
                                boolean available = false;

                                for (int i = 0; i< Movie.movieObjectList.size();i++) {
                                    if(Movie.movieObjectList.get(i).getTitle().equals(entry.substring(1).trim())) {
                                        Movie movie = Movie.movieObjectList.get(i); //adjust
                                        available = true;

                                        System.out.println("m1 Title: " + movie.getTitle() +
                                                "\nm1 Genres: " + movie.getGenreString() +
                                                "\nm1 Year: " + movie.getReleaseYear() +
                                                "\nm1 ID: " + movie.getId() +
                                                "\nm1 IMDB rating: " + movie.getImdbRating() +
                                                "\nm1 YESrating (average): " + movie.getYesRating());

                                        System.out.println("ratingsList: ");
                                        for (Map.Entry<String, Float> rated : movie.getRatingList().entrySet()) {
                                            System.out.println(rated.getValue() + "");
                                        }
                                    }
                                }
                                if(available==false){
                                    System.out.println("movie with the given name not found in movieObjectList");
                                }

                            } else {
                                System.out.println("movie with the given name not found in movieList");
                            }


                        } else if (entry.trim().charAt(0) == 'p') {
                            if (Profile.profileList.contains(entry.substring(1).trim())) {
                                boolean available = false;

//                System.out.println("m1 Title: " + m1.getTitle() +
//                        "\nm1 Genres: " + m1.getGenreString()+
//                        "\nm1 Year: " + m1.getReleaseYear() +
//                        "\nm1 ID: " + m1.getId() +
//                        "\nm1 IMDB rating: " + m1.getImdbRating() +
//                        "\nm1 YESrating (average): " + m1.getYesRating()
//                );


                                for (int i = 0; i< Profile.profileObjectList.size();i++){
                                    if(Profile.profileObjectList.get(i).getUserName().equals(entry.substring(1).trim())){
                                        Profile profile = Profile.profileObjectList.get(i); //adjust
                                        available = true;


                                        System.out.println("p1 Username: " + profile.getUserName() +
                                                "\np1 Preferred Genres: " + profile.getPreferredGenresText() +
                                                "\np1 Preferred Genres (array): " + profile.getPreferredGenresArray() +
                                                "\np1 Watched movies: " + profile.getWatchedMovies() +
                                                "\np1 Id: " + profile.getId());

//                System.out.println("p1 Username: " + p1.getUserName() +
//                        "\np1 Preferred Genres: " + p1.getPreferredGenresText() +
//                        "\np1 Preferred Genres (array): " + p1.getPreferredGenresArray() +
//                        "\np1 Watched movies: " + p1.getWatchedMovies() +
//                        "\np1 Id: " +p1.getId());


                                        System.out.println("p1 rated movies: ");
                                        for (Map.Entry<String, Float> rating : profile.getMyRatingsList().entrySet()) {
                                            System.out.println(rating.getKey() + ": " + rating.getValue());
                                        }
                                    }
                                }
                                if(available==false){
                                    System.out.println("profile with the given name not found in profileObjectList");
                                }
                            } else {
                                System.out.println("profile with the given name not found in profileList");
                            }

                        } else if (entry.trim().equals("c")) {
                            continue MENU_OPTIONS;

                        } else if (entry.trim().equals("all m")) {
                            for (Movie movie : Movie.movieObjectList) {
                                System.out.println("m1 Title: " + movie.getTitle() +
                                        "\nm1 Genres: " + movie.getGenreString() +
                                        "\nm1 Year: " + movie.getReleaseYear() +
                                        "\nm1 ID: " + movie.getId() +
                                        "\nm1 IMDB rating: " + movie.getImdbRating() +
                                        "\nm1 YESrating (average): " + movie.getYesRating());

                                System.out.println("ratingsList: ");
                                for (Map.Entry<String, Float> rated : movie.getRatingList().entrySet()) {
                                    System.out.println(rated.getValue() + "");
                                }
                            }

                        } else if (entry.trim().equals("all p")) {
                            for (Profile profile : Profile.profileObjectList) {
                                System.out.println("p1 Username: " + profile.getUserName() +
                                        "\np1 Preferred Genres: " + profile.getPreferredGenresText() +
                                        "\np1 Preferred Genres (array): " + profile.getPreferredGenresArray() +
                                        "\np1 Watched movies: " + profile.getWatchedMovies() +
                                        "\np1 Id: " + profile.getId());

                                for (Map.Entry<String, Float> rating : profile.getMyRatingsList().entrySet()) {
                                    System.out.println("p1 rated movies: ");
                                    System.out.println(rating.getKey() + ": " + rating.getValue());
                                }
                            }

                        } else {
                            System.out.println("invalid entry, please try again");
                        }
                    } while (true);
                }catch(RuntimeException e){
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please enter a valid option.");
            }
        } while(keepGoing);
    }
}