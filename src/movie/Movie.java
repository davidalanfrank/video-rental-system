package movie;

public class Movie {


    /**
     * This class represents a model a Movie DVD title. The same title may have more
     * than one copy.
     * The information about a movie
     * Fields: title, starring, director, duration, genre, classification, and release date
     *
     * The genre of
     * a movie may be Drama, Adventure, Family, Action, Sci-Fi, Comedy, Animated, Thriller, or
     * Other. A movie is classified as General (G), Parental Guidance (PG), Mature (M15+), or
     * Mature Accompanied (MA15+). The community library may have multiple DVDs of the
     * same movie.
     */

    private String title;
    private String starring;
    private String director;
    private Genres genre;
    private Classifications classification;
    private int duration;
    private int releaseDate;
    private int copies;
    private int timesRented;

    enum Classifications {
        G,
        PG,
        M,
        MA
    }
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
     * A constructor for a movie object.
     * @return void
     */
    public Movie(){

    }
    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public Classifications getClassification() {
        return classification;
    }

    public void setClassification(Classifications classification) {
        this.classification = classification;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
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