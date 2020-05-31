package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieCollection {



    /**
     * A class that represents a collection of DVD's
     * This class implements a !!!binary search tree!!! to store
     * the movie DVD's
     * The community library may have multiple DVDs of the
     * same movie
     */


    public static BinaryTree bTree = new BinaryTree();

    /**
     * Constructs and adds a Movie to the Movie Collection
     */
    public void addMovie() throws IOException {

        Movie newMovie = new Movie();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input;
        System.out.println("Enter Movie's title: ");
        input = reader.readLine();
        newMovie.setTitle(input);

        System.out.println("Enter what actors star in the movie: ");
        input = reader.readLine();
        newMovie.setStarring(input);

        System.out.println("Enter the movie director: ");
        input = reader.readLine();
        newMovie.setDirector(input);

        String genreMenu =  "Select one of the following for the movie's genre: \n" +
                "1. Drama\n" +
                "2. Adventure\n" +
                "3. Family\n" +
                "4. Action\n" +
                "5. SciFi\n" +
                "6. Comedy\n" +
                "7. Animated\n" +
                "8. Thriller\n" +
                "9. Other\n" +
                "===============================\n" +
                "Please make a selection (1-9)";

        System.out.println(genreMenu);
        input = reader.readLine();

        int nextInput=0;
        try{
            nextInput = Integer.parseInt(input);
        }catch (NumberFormatException e)
        {
            System.out.println("Exception Invalid input");
        }
        switch(nextInput){
            case 1:
                newMovie.setGenre(Movie.Genres.Drama);
                break;
            case 2:
                newMovie.setGenre(Movie.Genres.Adventure);
                break;
            case 3:
                newMovie.setGenre(Movie.Genres.Family);
                break;
            case 4:
                newMovie.setGenre(Movie.Genres.Action);
                break;
            case 5:
                newMovie.setGenre(Movie.Genres.SciFi);
                break;
            case 6:
                newMovie.setGenre(Movie.Genres.Comedy);
                break;
            case 7:
                newMovie.setGenre(Movie.Genres.Animated);
                break;
            case 8:
                newMovie.setGenre(Movie.Genres.Thriller);
                break;
            case 9:
                newMovie.setGenre(Movie.Genres.Other);
                break;
            default:
                System.out.println("Default Invalid input");
                break;

        }


        String classificationMenu =  "Select one of the following for the movie's genre: \n" +
                "1. General (G)\n" +
                "2. Parental Guidance (PG)\n" +
                "3. Mature (M15+)\n" +
                "4. Mature Accompanied (MA15+)\n" +
                "===============================\n" +
                "Please make a selection (1-4)";

        System.out.println(classificationMenu);
        input = reader.readLine();

        nextInput=0;
        try{
            nextInput = Integer.parseInt(input);
        }catch (NumberFormatException e)
        {
            System.out.println("Invalid input");
        }
        switch(nextInput){
            case 1:
                newMovie.setClassification(Movie.Classifications.G);
                break;
            case 2:
                newMovie.setClassification(Movie.Classifications.PG);
                break;
            case 3:
                newMovie.setClassification(Movie.Classifications.M);
                break;
            case 4:
                newMovie.setClassification(Movie.Classifications.MA);
                break;
            default:
                System.out.println("Invalid input");

        }

        System.out.println("Enter the movie duration (minutes): ");
        input = reader.readLine();
        try{

        }catch(NumberFormatException e){
            System.out.println("Must be an integer (eg. 120)");
        }
        newMovie.setDuration(Integer.parseInt(input));

        System.out.println("Enter the movie release date (DD/MM/YYYY):");
        input = reader.readLine();
        newMovie.setReleaseDate(input);

        System.out.println("Enter how many copies are available: ");
        input = reader.readLine();
        newMovie.setCopies(Integer.parseInt(input));

        System.out.println("Enter how many times this movie has been rented: ");
        input = reader.readLine();
        newMovie.setCopies(Integer.parseInt(input));


        this.bTree.addNode(newMovie.getTitle(), newMovie);


        System.out.println("The following movie has been added to the movie list:");
        System.out.println(newMovie.getTitle() + "\n");


    }


    /**
     * Display the top 10 most frequently borrowed movie DVDs by the
     * members in the descending order of the frequency
     */
    public static void displayTop10() {
        System.out.println("Top 10 most frequently borrowed movie DVDs");
        QuickSort quickSort = new QuickSort();
        int[][] arrayToSort = bTree.splitArray();
        int n = arrayToSort.length;
        quickSort.sort(arrayToSort, 0, n-1);

        if(n<10){
            for(int i = n; i > 0; i-- ){
                System.out.println(bTree.refArr[arrayToSort[i - 1][0]][1]);

            }
        }else{
            for(int i = 0; i < 10; i++){
                System.out.println(bTree.refArr[arrayToSort[( n - i ) - 1][0]][1]);
            }
        }
    }

    /**
     * Removes a movie from the movie collection
     */
    public static void removeMovie() throws IOException {


        /* Create a buffered reader for user input */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input;
        System.out.println("Enter Movie's title: ");
        input = reader.readLine();

        if(bTree.SearchTitle(input) != null){
            bTree.removeNode(input);
            System.out.println("The following movie has been removed from the collection: ");
            System.out.println(input);


        }else{
            System.out.println("Cannot remove movie. Movie: " + input + ", doesn't exist.");
        }


    }

    /**
     * Displays a list of all movies lexicographically
     */
    public static void displayAllMovies() {
        System.out.println("These are all the movies in the collection: ");
        // InOrderTraversal
        bTree.inOrderTraversal();
        if(bTree.sizeOfTree < 1){
            System.out.println("There are no movies in the collection");

        }
        System.out.println("These are all the movies in the collection: ");

    }

    /**
     * Marks a movie as borrowed
     */
    public static void borrowMovie() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        System.out.println("Enter movie title: ");

        input = reader.readLine();

        System.out.println("Input: " );
        System.out.println(input);
        System.out.println("#####DEBUG: borrowMovie(): information about the searched movie: " );
        System.out.println("Title: " );
        System.out.println(bTree.SearchTitle(input).getTitle());

        System.out.println("Director: " );
        System.out.println(bTree.SearchTitle(input).getDirector());

        System.out.println("Times Rented: " );
        System.out.println(bTree.SearchTitle(input).getTimesRented());

        System.out.println("Director: " );
        System.out.println(bTree.SearchTitle(input).getDirector());

        System.out.println("Times Rented Before: " );
        System.out.println(bTree.SearchTitle(input).getTimesRented());
        bTree.SearchTitle(input).incrementTimesRented();

        System.out.println("Times Rented after increment: " );
        System.out.println(bTree.SearchTitle(input).getTimesRented());

        System.out.println("available copies Before: " );
        System.out.println(bTree.SearchTitle(input).getCopiesAvailable());
        bTree.SearchTitle(input).decrementCopiesAvailable();

        System.out.println("available copies after: " );
        System.out.println(bTree.SearchTitle(input).getCopiesAvailable());

        MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().add(bTree.SearchTitle(input).getTitle());



    }

    /**
     * Mark a borrowed movie returned
     */
    public static void returnMovie() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        System.out.println("Enter movie title: ");

        input = reader.readLine();

        System.out.println("Input: " );
        System.out.println(input);

        // Find the movie in the BTsearch
        System.out.println("#####DEBUG: borrowMovie(): information about the searched movie: " );
        System.out.println("Title: " );
        System.out.println(bTree.SearchTitle(input).getTitle());

        // Increment copiesAvailable
        System.out.println("available copies Before: " );
        System.out.println(bTree.SearchTitle(input).getCopiesAvailable());
        bTree.SearchTitle(input).incrementCopiesAvailable();
        System.out.println("available copies after: " );
        System.out.println(bTree.SearchTitle(input).getCopiesAvailable());

        // remove that movie from the members movie list
        if( MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().contains(bTree.SearchTitle(input).getTitle())){
            MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().remove(bTree.SearchTitle(input).getTitle());

        }else{
            System.out.println("Oops, you aren't currently borrowing: " + bTree.SearchTitle(input).getTitle() );
        }


    }

    /**
     * List all movies currently borrowed by members
     */
    public static void currentlyBorrowed() {

        System.out.println("Printing all borrowed movies " );

        for (Object o : MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies()) {
            System.out.println(o);
        }

    }

    // A method that adds some movie for testing
    public void populateBinaryTreeWithMoviesTitles() {


        bTree = new BinaryTree();
        Movie newMovie1 = new Movie();
        newMovie1.setTitle("Evangelion: 1.0 You Are (Not) Alone");
        newMovie1.setStarring("Megumi Ogata, Megumi Hayashibara");
        newMovie1.setDirector("Hideaki Anno");
        newMovie1.setGenre(Movie.Genres.SciFi);
        newMovie1.setClassification(Movie.Classifications.M);
        newMovie1.setDuration(101);
        newMovie1.setReleaseDate("1/9/2007");
        newMovie1.setCopies(3);
        newMovie1.setTimesRented(59);
        bTree.addNode(newMovie1.getTitle(), newMovie1);

        Movie newMovie2 = new Movie();
        newMovie2.setTitle("Arrival");
        newMovie2.setStarring("\t\n" +
                "Amy Adams,\n" +
                "Jeremy Renner,\n" +
                "Forest Whitaker,\n" +
                "Michael Stuhlbarg and\n" +
                "Tzi Ma");
        newMovie2.setDirector("\tDenis Villeneuve");
        newMovie2.setGenre(Movie.Genres.SciFi);
        newMovie2.setClassification(Movie.Classifications.M);
        newMovie2.setDuration(116);
        newMovie2.setReleaseDate("1/9/2016");
        newMovie2.setCopies(4);
        newMovie2.setTimesRented(2);
        bTree.addNode(newMovie2.getTitle(), newMovie2);

        Movie newMovie3 = new Movie();
        newMovie3.setTitle("The Lighthouse");
        newMovie3.setStarring("\t\n" +
                "Willem Dafoe,\n" +
                "Robert Pattinson");
        newMovie3.setDirector("Robert Eggers");
        newMovie3.setGenre(Movie.Genres.Thriller);
        newMovie3.setClassification(Movie.Classifications.MA);
        newMovie3.setDuration(109);
        newMovie3.setReleaseDate("19/5/2019");
        newMovie3.setCopies(2);
        newMovie3.setTimesRented(100);
        bTree.addNode(newMovie3.getTitle(), newMovie3);

        Movie newMovie4 = new Movie();
        newMovie4.setTitle("The Cameras Shutter");
        newMovie4.setStarring("Liam Hemsworth");
        newMovie4.setDirector("Cam Eria");
        newMovie4.setGenre(Movie.Genres.SciFi);
        newMovie4.setClassification(Movie.Classifications.M);
        newMovie4.setDuration(134);
        newMovie4.setReleaseDate("1/9/2007");
        newMovie4.setCopies(12);
        newMovie4.setTimesRented(101);
        bTree.addNode(newMovie4.getTitle(), newMovie4);

        Movie newMovie5 = new Movie();
        newMovie5.setTitle("Sinbads rescue");
        newMovie5.setStarring("\t\n" +
                "Nathanial Greiger,\n");
        newMovie5.setDirector("\tThomas Chaplin");
        newMovie5.setGenre(Movie.Genres.SciFi);
        newMovie5.setClassification(Movie.Classifications.M);
        newMovie5.setDuration(200);
        newMovie5.setReleaseDate("1/9/2016");
        newMovie5.setCopies(2);
        newMovie5.setTimesRented(299);
        bTree.addNode(newMovie5.getTitle(), newMovie5);

        Movie newMovie6 = new Movie();
        newMovie6.setTitle("The Overhaul at Camaroon");
        newMovie6.setStarring("Antonito Montana");
        newMovie6.setDirector("Roberto Alto");
        newMovie6.setGenre(Movie.Genres.Thriller);
        newMovie6.setClassification(Movie.Classifications.MA);
        newMovie6.setDuration(190);
        newMovie6.setReleaseDate("19/5/2019");
        newMovie6.setCopies(45);
        newMovie6.setTimesRented(87);
        bTree.addNode(newMovie6.getTitle(), newMovie6);

        Movie newMovie7 = new Movie();
        newMovie7.setTitle("Movie 7");
        newMovie7.setStarring("7 actors");
        newMovie7.setDirector("Director 7");
        newMovie7.setGenre(Movie.Genres.Thriller);
        newMovie7.setClassification(Movie.Classifications.MA);
        newMovie7.setDuration(109);
        newMovie7.setReleaseDate("7/7/2019");
        newMovie7.setCopies(7);
        newMovie7.setTimesRented(7000);
        bTree.addNode(newMovie7.getTitle(), newMovie7);

        Movie newMovie8 = new Movie();
        newMovie8.setTitle("Movie 8");
        newMovie8.setStarring("8 Actors");
        newMovie8.setDirector("Director 8");
        newMovie8.setGenre(Movie.Genres.SciFi);
        newMovie8.setClassification(Movie.Classifications.M);
        newMovie8.setDuration(88);
        newMovie8.setReleaseDate("8/8/2008");
        newMovie8.setCopies(8);
        newMovie8.setTimesRented(88);
        bTree.addNode(newMovie8.getTitle(), newMovie8);

//        Movie newMovie9 = new Movie();
//        newMovie9.setTitle("Movie 9");
//        newMovie9.setStarring("9 Actors");
//        newMovie9.setDirector("Director 9");
//        newMovie9.setGenre(Movie.Genres.SciFi);
//        newMovie9.setClassification(Movie.Classifications.M);
//        newMovie9.setDuration(99);
//        newMovie9.setReleaseDate("0/9/2019");
//        newMovie9.setCopies(9);
//        newMovie9.setTimesRented(0);
//        bTree.addNode(newMovie9.getTitle(), newMovie9);
//
//        Movie newMovie10 = new Movie();
//        newMovie10.setTitle("Movie 10");
//        newMovie10.setStarring("10 Actors");
//        newMovie10.setDirector("Director 10");
//        newMovie10.setGenre(Movie.Genres.Thriller);
//        newMovie10.setClassification(Movie.Classifications.MA);
//        newMovie10.setDuration(190);
//        newMovie10.setReleaseDate("10/10/2019");
//        newMovie10.setCopies(10);
//        newMovie10.setTimesRented(10);
//        bTree.addNode(newMovie10.getTitle(), newMovie10);





    }

    public static void main(String[] args) throws IOException {

        MovieCollection collection = new MovieCollection();

        collection.populateBinaryTreeWithMoviesTitles();

        collection.displayTop10();






//        MovieCollection collection = new MovieCollection();
//
//        collection.populateBinaryTreeWithMoviesTitles();
//        System.out.println("#####DEBUG: DISPLAY ALL MOVIES" );
//
//        displayAllMovies();
//
//        removeMovie();
//        System.out.println("#####DEBUG: DISPLAY ALL MOVIES" );
//
//        displayAllMovies();

    }
}
