package nl.YESmovies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Movie {
    public static ArrayList<Movie> movieObjectList = new ArrayList<>();
    public static ArrayList<String> movieList = new ArrayList<>();
    //private ArrayList<Float> ratingList = new ArrayList<Float>() ;                 //all rating for one movie. moved to Movie Class
    private HashMap<String,Float> ratingList = new HashMap<String, Float>();

    public static int movieCounter = 0;
    private long id;
    private String title;
    private short releaseYear;
    private float yesRating;
    private int nrRatings;
    private float imdbRating;

    public void addYesRating(String userName, float rating) {
        ratingList.put(userName, rating);
        double total = 0;
        for(Map.Entry<String, Float> rated : ratingList.entrySet()){
            total += rated.getValue();
        }
        this.nrRatings = ratingList.size();

        this.yesRating = (float)Math.round((total / nrRatings)*10)/10;
    }

    public HashMap<String,Float> getRatingList(){
        return ratingList;
    }

    public float getYesRating() {
        return this.yesRating;
    }

    public Movie(String title, short releaseYear, float imdbRating, ArrayList<String> genres) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.id = ++movieCounter;
        this.imdbRating = imdbRating;
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

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
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