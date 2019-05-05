package nl.YESmovies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public Movie(String title, short releaseYear, float imdbRating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.id = ++movieCounter;
        this.imdbRating = imdbRating;
        movieList.add(title);
    }

    public static String[] genresString = {"Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary",
            "Drama", "Family", "Fantasy", "Film Noir", "History", "Horror", "Music", "Musical", "Mystery", "Romance",
            "Sci-Fi", "Short", "Sport", "Superhero", "Thriller", "War", "Western"};

    private int[] genreInt = new int[genresString.length];

    public static short enterReleaseYear(){
        Scanner reader = new Scanner(System.in);

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
        return releaseYear;
    }

    public void addGenre(){
        Scanner reader = new Scanner(System.in);
        boolean enteredValidGenre;

        do {
            enteredValidGenre = true;

            System.out.println("Which genre(s) is the movie? Please enter the genre numbers separated by a ','.");

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
                    this.genreInt[Integer.parseInt(genreInput_a.trim()) - 1] = 1;
                    genreInput = genreInput.substring(genreInput.indexOf(",") + 1);
                }

                this.genreInt[Integer.parseInt(genreInput.trim()) - 1] = 1;

            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("You have entered an invalid genre number, please enter a valid genre number.");

                enteredValidGenre = false;
            } catch (NumberFormatException e){

            }

        } while (!enteredValidGenre);
    }

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
                ", genres=" + this.getGenreString() +
                '}';
    }
}