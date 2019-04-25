package nl.YESmovies;

import java.util.ArrayList;
import java.util.HashMap;

public class YesRating {

    // Move this to Profile
    private HashMap<String,Float> myRatingsList = new HashMap<String,Float>();       //all ratings from one profile. move to Profile Class

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
        System.out.print("you gave " + movieTitle + "a rating of myRatingsList.get(movieTitle)");
        return myRatingsList.get(movieTitle);
    }




    // Move this to Movie
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

}
