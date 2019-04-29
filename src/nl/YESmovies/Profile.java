package nl.YESmovies;

import java.util.ArrayList;
import java.util.HashMap;

public class Profile {
    public static ArrayList<Profile> profileObjectList = new ArrayList<>();
    public static ArrayList<String> profileList = new ArrayList<>();
    private HashMap<String,Float> myRatingsList = new HashMap<String,Float>();
    private long id;
    private String userName;
    private ArrayList<String> watchedMovies;
    private int[] preferredGenres = new int[4];


    public void setMyRating(String movieTitle, float ratingGiven) {
        myRatingsList.put(movieTitle,ratingGiven);
    }

    public float getMyRating(String movieTitle){
        if(myRatingsList.get(movieTitle)==null){
            if (Movie.movieList.contains(movieTitle)){
                System.out.println("You have not yet Rated this movie");
                return -1;
                // add option to immediately rate the movie
            } else {
                System.out.println("The movie title was not recognised ");
                return -2;
                //make sure no invalid names can be passed
                //did you mean ....? option
                //or just show a selection of movies you rated
            }
        }
        System.out.println("you gave " + movieTitle + "a rating of myRatingsList.get(movieTitle)");
        return myRatingsList.get(movieTitle);
    }


    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<String> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(ArrayList<String> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    //Traditional getter
    public int[] getPreferredGenresArray() {
        return this.preferredGenres;
    }

    //Getter that displays the preferred genres in text form
    public String getPreferredGenresText() {
        String outputPreferredGenres = "";
        if (this.preferredGenres[0] == 1) {
            outputPreferredGenres += " Action";
        }
        if (this.preferredGenres[1] == 1) {
            outputPreferredGenres += " Drama";
        }
        if (this.preferredGenres[2] == 1) {
            outputPreferredGenres += " Horror";
        }
        if (this.preferredGenres[3] == 1) {
            outputPreferredGenres += " Fantasy";
        }
        return outputPreferredGenres;
    }

    public void addPreferredGenres(int index) {
        this.preferredGenres[index] = 1;
    }

    public void removePreferredGenres(int index) {
        this.preferredGenres[index] = 0;
    }

    public Profile(String username) {
        this.userName = username;
        profileList.add(username); //Add username to the ArrayList with all usernames
        this.id = profileList.size(); // Generate unique id for created profile
    }
}
