package nl.YESmovies;

import java.util.ArrayList;

public class Profile {
    private long id;
    private String userName;
    private ArrayList<String> watchedMovies;
    private ArrayList<String> preferredGenres;

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

    public ArrayList<String> getPreferredGenres() {
        return preferredGenres;
    }

    public void setPreferredGenres(ArrayList<String> preferredGenres) {
        this.preferredGenres = preferredGenres;
    }
}
