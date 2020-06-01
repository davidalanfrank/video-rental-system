package movie;

public class Movie {

    /**
     * This class represents a model a Movie DVD title
     */
    private String title;
    private String starring;
    private String director;
    private Genres genre;
    private Classifications classification;
    private int duration;
    private String releaseDate;
    private int copies;
    private int copiesAvailable;
    private int timesRented;

    /**
     * A constructor for a movie object.
     * @return void
     */
    public Movie(){

    }

    /**
     * Increments the instance var every time a movie is borrowed
     */
    public void incrementTimesRented() {
        this.timesRented++;
    }

    /**
     * Increments the instance var for available copies
     */
    public void incrementCopiesAvailable(){
        if (copiesAvailable > copies){
            System.out.println("Oops, You've tried to return an non existent copy");
        }else{
            this.copiesAvailable++;
        }

    }

    /**
     * decrements the instance var for available copies
     */
    public void decrementCopiesAvailable(){
        if (copiesAvailable < 1){
            System.out.println("Oops, there is no more copies to lease");
        }else{

            this.copiesAvailable--;
        }

    }

    /**
     * Getter for copies available
     */
    public int getCopiesAvailable(){
        return this.copiesAvailable;
    }

    // Helper for handling Ratings
    enum Classifications {
        G,
        PG,
        M,
        MA
    }

    // Helper for handling genres
    enum Genres {
        Drama,
        Adventure,
        Family,
        Action,
        SciFi,
        Comedy, Animated
        , Thriller ,
        Other
    }

    /**
     * !! Only used when staff adds a movie to the movie list
     * */
    public void setCopies(int copies) {
        this.copies = copies;
        this.copiesAvailable = copies;
    }

    // Getters and setters for instance variables
    public void setStarring(String starring) {
        this.starring = starring;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public void setClassification(Classifications classification) {
        this.classification = classification;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getTimesRented() {
        return timesRented;
    }

    public void setTimesRented(int timesRented) {
        this.timesRented = timesRented;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}