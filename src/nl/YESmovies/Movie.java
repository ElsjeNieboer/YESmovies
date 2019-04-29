package nl.YESmovies;

import java.util.ArrayList;

public class Movie {
    public static ArrayList<Movie> movieObjectList = new ArrayList<>();
    public static ArrayList<String> movieList = new ArrayList<>();

    public static int movieCounter = 0;

    private long id;
    private String title;
    private short releaseYear;
    private ArrayList<Float> ratingList = new ArrayList<Float>() ;                 //all rating for one movie. moved to Movie Class
    private float yesRating;
    private int nrRatings;

    public void addYesRating(float rating) {
        ratingList.add(rating);
        float total = nrRatings * yesRating + rating;
        this.yesRating = total / ++nrRatings;
    }

    public float getYesRating() {
        return this.yesRating;
    }

    public Movie(String title, short releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.id = ++movieCounter;
        movieList.add(title);
    }

    private String[] genresString = {"Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary",
            "Drama", "Family", "Fantasy", "Film Noir", "History", "Horror", "Music", "Musical", "Mystery", "Romance",
            "Sci-Fi", "Short", "Sport", "Superhero", "Thriller", "War", "Western"};

    private int[] genreInt = new int[genresString.length];

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

    public int[] getGenreInt() {
        return genreInt;
    }

    public void addGenre(int index) {
        this.genreInt[index] = 1;
    }

    public void removeGenre(int index) {
        this.genreInt[index] = 0;
    }

    public String getGenreString(){
        String movieGenre = "";
        for (int i = 0; i < genresString.length; i++){
            if(genreInt[i] == 1){
                movieGenre += genresString[i]+" ";
            }
        }
        return movieGenre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genres=" + this.getGenreString() +
                '}';
    }
}