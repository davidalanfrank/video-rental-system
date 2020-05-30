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



        /* The new member to be added to the array */
        Movie newMovie = new Movie();

        /* Create a buffered reader for user input */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input;
        System.out.println("Enter Movie's title: ");
        input = reader.readLine();
        newMovie.setTitle(input);

//        System.out.println("Enter what actors star in the movie: ");
//        input = reader.readLine();
//        newMovie.setStarring(input);
//
//        System.out.println("Enter the movie director: ");
//        input = reader.readLine();
//        newMovie.setDirector(input);
//
//        String genreMenu =  "Select one of the following for the movie's genre: \n" +
//                "1. Drama\n" +
//                "2. Adventure\n" +
//                "3. Family\n" +
//                "4. Action\n" +
//                "5. SciFi\n" +
//                "6. Comedy\n" +
//                "7. Animated\n" +
//                "8. Thriller\n" +
//                "9. Other\n" +
//                "===============================\n" +
//                "Please make a selection (1-9)";
//
//        System.out.println(genreMenu);
//        input = reader.readLine();
//
//        int nextInput=0;
//        try{
//            nextInput = Integer.parseInt(input);
//            System.out.println("#####DEBUG:  AddMovie(): nextInput is: ");
//            System.out.println(nextInput);
//        }catch (NumberFormatException e)
//        {
//            System.out.println("Exception Invalid input");
//        }
//        switch(nextInput){
//            case 1:
//                newMovie.setGenre(Movie.Genres.Drama);
//            case 2:
//                newMovie.setGenre(Movie.Genres.Adventure);
//            case 3:
//                newMovie.setGenre(Movie.Genres.Family);
//            case 4:
//                newMovie.setGenre(Movie.Genres.Action);
//            case 5:
//                newMovie.setGenre(Movie.Genres.SciFi);
//            case 6:
//                newMovie.setGenre(Movie.Genres.Comedy);
//            case 7:
//                newMovie.setGenre(Movie.Genres.Animated);
//            case 8:
//                newMovie.setGenre(Movie.Genres.Thriller);
//            case 9:
//                newMovie.setGenre(Movie.Genres.Other);
//            default:
//                System.out.println("Default Invalid input");
//
//        }
//
//
//        String classificationMenu =  "Select one of the following for the movie's genre: \n" +
//                "1. General (G)\n" +
//                "2. Parental Guidance (PG)\n" +
//                "3. Mature (M15+)\n" +
//                "4. Mature Accompanied (MA15+)\n" +
//                "===============================\n" +
//                "Please make a selection (1-4)";
//
//        System.out.println(classificationMenu);
//        input = reader.readLine();
//
//        nextInput=0;
//        try{
//            nextInput = Integer.parseInt(input);
//        }catch (NumberFormatException e)
//        {
//            System.out.println("Invalid input");
//        }
//        switch(nextInput){
//            case 1:
//                newMovie.setClassification(Movie.Classifications.G);
//            case 2:
//                newMovie.setClassification(Movie.Classifications.PG);
//            case 3:
//                newMovie.setClassification(Movie.Classifications.M);
//            case 4:
//                newMovie.setClassification(Movie.Classifications.MA);
//            default:
//                System.out.println("Invalid input");
//
//        }
//
//        System.out.println("Enter the movie duration (minutes): ");
//        input = reader.readLine();
//        try{
//
//        }catch(NumberFormatException e){
//            System.out.println("Must be an integer (eg. 120)");
//        }
//        newMovie.setDuration(Integer.parseInt(input));
//
//        System.out.println("Enter the movie release date (DD/MM/YYYY):");
//        input = reader.readLine();
//        newMovie.setReleaseDate(input);

        System.out.println("Enter how many copies are available: ");
        input = reader.readLine();
        newMovie.setCopies(Integer.parseInt(input));

        System.out.println("Enter how many times this movie has been rented: ");
        input = reader.readLine();
        newMovie.setCopies(Integer.parseInt(input));


        /* A new node to place in the binary tree */
        this.bTree.addNode(newMovie.getTitle(), newMovie);


        System.out.println("The following movie has been added to the movie list.");
        System.out.println(newMovie.getTitle());




    }


    /**
     * Display the top 10 most frequently borrowed movie DVDs by the
     * members in the descending order of the frequency
     */
    public static void displayTop10() {
        System.out.println("#####DEBUG: displayTop10(): " );

        QuickSort ob = new QuickSort();

        int[][] arrayToSort = bTree.treeTo2DArray();

        System.out.println("#####DEBUG: displayTop10(): array before sort");
        for (int[] ints : arrayToSort) {
            System.out.println(ints[0]);
            System.out.println(ints[1]);


        }

        int n = arrayToSort.length;

        ob.sort(arrayToSort, 0, n-1);

        System.out.println("#####DEBUG: displayTop10(): Printing the sorted array");

        for (int i=0; i<n; ++i){
            System.out.println(arrayToSort[i][1]+" ");
            System.out.println(arrayToSort[i][0]);

        }


//        if(n<10){


            for(int i = n; i > 0; i-- ){
                System.out.println(bTree.refArr[arrayToSort[i - 1][0]][1]);

            }


//        for(int i = 10; i > 0; i--){
//
//        }
//
        System.out.println();



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
        }else{
            System.out.println("Error! Cannot remove movie. " + input + "  doesn't exist.");
        }


    }

    /**
     * Displays a list of all movies lexicographically
     */
    public static void displayAllMovies() {
        // InOrderTraversal
        bTree.inOrderTraversal();
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
