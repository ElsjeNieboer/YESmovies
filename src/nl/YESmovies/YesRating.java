package nl.YESmovies;

public class YesRating {

    private float yesRating;
    private int nrRatings;

    public void addYesRating(float rating) {
        float total = nrRatings * yesRating + rating;
        this.yesRating = total / ++nrRatings;
    }

    public float getYesRating() {
        return this.yesRating;
    }

}
