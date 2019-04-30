package nl.YESmovies;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        boolean keepGoing = true;

        String[] genreOptions = {"Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary",
                "Drama", "Family", "Fantasy", "Film Noir", "History", "Horror", "Music", "Musical", "Mystery", "Romance",
                "Sci-Fi", "Short", "Sport", "Superhero", "Thriller", "War", "Western"};

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

                System.out.println("You have successfully created a new profile with the following username: "+newProfile.getUserName()+".\n" +
                        "You have entered the following genres as your preferred genres: "+newProfile.getPreferredGenresText()+".");
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

                    System.out.println("Which genre(s) is the movie? Please enter the genre number(s).");

                    for (int i = 0; i < genreOptions.length; i++) {
                        System.out.print(genreOptions[i] + "(" + (i + 1) + ")  ");
                        if((i+1) % 12 == 0){
                            System.out.println();
                        }
                        }
                    System.out.println();

                    boolean enteredValidGenre;

                    do {
                        enteredValidGenre = true;

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

                        }
                    } while (!enteredValidGenre);
                    
                    Movie.movieObjectList.add(movie);

                    System.out.println(movie);

                    System.out.println("If you want to add another movie, press 'y', if not press any key.");

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

//                                break;

                            } else{
                                System.out.println("Movie not found, please try again.");
                            }
                        }while(true);

//                        break;

                    } else {
                        System.out.println("Username not found, please try again.");
                    }

                }while(true);
            } else if (userInput.equals("q")) {
                keepGoing = false;
            } else if (userInput.equals("Test")){
                Movie m1 = Movie.movieObjectList.get(0);
                Movie m2 = Movie.movieObjectList.get(1);
                Profile p1 = Profile.profileObjectList.get(0);
                Profile p2 = Profile.profileObjectList.get(1);

                System.out.println("movieList: " + Arrays.toString(Movie.movieList.toArray()));

                System.out.println("m1 ratingsList: ");

                try {
                    for(Map.Entry<String,Float> rated : m1.getRatingList().entrySet()){
                        System.out.println(rated.getValue() + "");
                    }

                } catch(IndexOutOfBoundsException e){
                    System.out.println("RatingList has " + m1.getRatingList().size() + "elements... Index out of bounds!");
                }

                System.out.println("m1 Title: " + m1.getTitle() +
                        "\nm1 Genres: " + m1.getGenreString()+
                        "\nm1 Year: " + m1.getReleaseYear() +
                        "\nm1 ID: " + m1.getId() +
                        "\nm1 IMDB rating: " + m1.getImdbRating() +
                        "\nm1 YESrating (average): " + m1.getYesRating()
                );

                System.out.println("profileList: " + Arrays.toString(Profile.profileList.toArray()));

                System.out.println("p1 Username: " + p1.getUserName() +
                        "\np1 Preferred Genres: " + p1.getPreferredGenresText() +
                        "\np1 Preferred Genres (array): " + p1.getPreferredGenresArray() +
                        "\np1 Watched movies: " + p1.getWatchedMovies() +
                        "\np1 Id: " +p1.getId());

                p1.getMyRating("m1");
                p1.getMyRating("m2");


            } else {
                System.out.println("Please enter a valid option.");
            }
        } while(keepGoing);
    }
}