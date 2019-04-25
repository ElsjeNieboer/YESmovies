package nl.YESmovies;

import java.util.ArrayList;

public class Profile {
    public static ArrayList<String> usernameList = new ArrayList<>();
    private long id;
    private String userName;
    private ArrayList<String> watchedMovies;
    private int[] preferredGenres = new int[4];

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
        usernameList.add(username); //Add username to the ArrayList with all usernames
        this.id = usernameList.size(); // Generate unique id for created profile
    }
}
