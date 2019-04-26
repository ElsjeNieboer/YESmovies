package nl.YESmovies;

import java.util.ArrayList;

public class Movie {
    public static ArrayList<String> movieList = new ArrayList<>();

    public static int movieCounter = 0;

    private long id;
    private String title;
    private short releaseYear;

    public Movie(String title, short releaseYear, ArrayList<String> genres) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.id = ++movieCounter;
        movieList.add(title);
    }

    private ArrayList<String> genres;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(short releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genres=" + genres +
                '}';
    }
}