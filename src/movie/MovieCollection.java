package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieCollection {

    /**
     * A class that represents a collection of Movie DVD's
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

        System.out.println("Enter how many times has this movie has been rented: ");
        input = reader.readLine();
        newMovie.setCopies(Integer.parseInt(input));


        this.bTree.addNode(newMovie);


        System.out.println("The following movie has been added to the movie list:");
        System.out.println(newMovie.getTitle() + "\n");


    }


    /**
     * Display the top 10 most frequently borrowed movie DVDs by the
     * members in the descending order of the frequency
     */
    public static void displayTop10() {

        QuickSort quickSort = new QuickSort();
        // Counts each not null node in the bst
        bTree.preOrderTraversal();

        if(bTree.sizeOfTree < 1){
            System.out.println("There are currently no movie DVD's in the collection");
        }else{

            // populates the array of times a movie DVD has been borrowed
            int[][] arrayToSort = bTree.splitArray();

            int n = arrayToSort.length;

            System.out.println("Top 10 most frequently borrowed movie DVDs: ");

            // if nodes exists
            if( n > 1 ){
                // Quick sort the array
                quickSort.sort(arrayToSort, 0, n-1);

                if(n<10){
                    // If there are less than 10 movies in the collection
                    for(int i = 0; i < n ; i++){
                        System.out.println(bTree.refArr[arrayToSort[i][0]][1]);

                    }
                }else{
                    // Print all the movies from the end of the array until top 10
                    //      have been printed
                    for(int i = 0; i < 10; i++){
                        System.out.println(bTree.refArr[arrayToSort[( n - i ) - 1][0]][1]);
                    }
                }
            }

        }

    }

    /**
     * Removes a movie from the movie collection
     */
    public static void removeMovie() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        System.out.println("Enter Movie's title: ");
        input = reader.readLine();

        // search for the given movie title and if it exists...
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

        // Count the nodes in the binary search tree
        bTree.preOrderTraversal();

        if(bTree.sizeOfTree < 1){
            System.out.println("There are no movies in the collection");

        }else{
            System.out.println("These are all the movies in the collection: ");
            // prints the node titles In Order
            bTree.inOrderTraversal();

        }


    }

    /**
     * Handles a user borrowing a movie DVD
     */
    public static void borrowMovie() throws IOException {

        // Count the nodes in the binary search tree
        bTree.preOrderTraversal();

        if(bTree.sizeOfTree < 1) {
            System.out.println("There are no movies to borrow");
        }else{
            // If the member already has 10 movies borrowed
            if( MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().size() >= 10){
                System.out.println("Sorry, you are already borrowing 10 movies which is a members limit. \n\tPlease return some movies before borrowing again.");

            }else{

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                String input;
                System.out.println("Enter movie title: ");

                input = reader.readLine();

                try{
                    String movieTitle = bTree.SearchTitle(input).getTitle();

                    // If the title that the member is looking for exists in their borrowed movies
                    if( MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().contains(movieTitle))
                    {
                        System.out.println("It seems you are already borrowing a copy of " + movieTitle + ". Members may only borrow one copy of the same movie DVD at a time.");
                    }else{
                        if(bTree.SearchTitle(input).getCopiesAvailable() < 1){
                            System.out.println("Sorry, there are no more copies available for " + movieTitle);
                        }else{
                            System.out.println("Movie Borrowed! Enjoy your viewing(s) of " + movieTitle  );
                            MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().add(movieTitle);
                            bTree.SearchTitle(input).decrementCopiesAvailable();
                            bTree.SearchTitle(input).incrementTimesRented();


                        }
                    }

                }catch(NullPointerException e){
                    System.out.println("Movie title doesn't exist");
                }
            }


        }





    }

    /**
     * Handles the return of a movie from a member
     */
    public static void returnMovie() throws IOException {

        // If member has no borrowed movies
        if(MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().size() < 1){
            System.out.println("You have no movies to return");

        }else{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String input;
            System.out.println("Enter movie title: ");

            input = reader.readLine();


            try{
                // Returns the title or null
                String movieTitle = bTree.SearchTitle(input).getTitle();

                // If the member is borrowing the given movie title
                if( MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().contains(bTree.SearchTitle(movieTitle).getTitle())){
                    // Remove that title from their list
                    MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().remove(bTree.SearchTitle(movieTitle).getTitle());
                    bTree.SearchTitle(input).incrementCopiesAvailable();
                    System.out.println("Movie Returned! Thank you, we hope you enjoyed " + bTree.SearchTitle(input).getTitle());

                }else{
                    System.out.println("Oops, you aren't currently borrowing " + bTree.SearchTitle(input).getTitle() );
                }

            }catch(NullPointerException e){
                System.out.println("Movie title doesn't exist");
            }
        }




    }

    /**
     * List all movies currently borrowed by members
     */
    public static void currentlyBorrowed() {

            // If the member has borrowed movies
        if ( MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies().size() > 1 ){
            System.out.println("You are borrowing the following movie DVD(s):  ");

            for (Object o : MemberCollection.getMembers()[MemberCollection.getIndexOfLoggedInUser()].getBorrowedMovies()) {
                System.out.println(o);
            }
        }else{
            System.out.println("You are not borrowing any movie DVD's at the moment");
        }


    }

//    /////////// USED FOR TESTING /////////////////
//    public void populateBinaryTreeWithMoviesTitles() {
//
//
//        bTree = new BinaryTree();
//        Movie newMovie1 = new Movie();
//        newMovie1.setTitle("Evangelion");
//        newMovie1.setStarring("Megumi Ogata, Megumi Hayashibara");
//        newMovie1.setDirector("Hideaki Anno");
//        newMovie1.setGenre(Movie.Genres.SciFi);
//        newMovie1.setClassification(Movie.Classifications.M);
//        newMovie1.setDuration(101);
//        newMovie1.setReleaseDate("1/9/2007");
//        newMovie1.setCopies(3);
//        newMovie1.setTimesRented(59);
//        bTree.addNode(newMovie1);
//
//        Movie newMovie2 = new Movie();
//        newMovie2.setTitle("Arrival");
//        newMovie2.setStarring("\t\n" +
//                "Amy Adams,\n" +
//                "Jeremy Renner,\n" +
//                "Forest Whitaker,\n" +
//                "Michael Stuhlbarg and\n" +
//                "Tzi Ma");
//        newMovie2.setDirector("\tDenis Villeneuve");
//        newMovie2.setGenre(Movie.Genres.SciFi);
//        newMovie2.setClassification(Movie.Classifications.M);
//        newMovie2.setDuration(116);
//        newMovie2.setReleaseDate("1/9/2016");
//        newMovie2.setCopies(4);
//        newMovie2.setTimesRented(2);
//        bTree.addNode(newMovie2);
//
//        Movie newMovie3 = new Movie();
//        newMovie3.setTitle("The Lighthouse");
//        newMovie3.setStarring("\t\n" +
//                "Willem Dafoe,\n" +
//                "Robert Pattinson");
//        newMovie3.setDirector("Robert Eggers");
//        newMovie3.setGenre(Movie.Genres.Thriller);
//        newMovie3.setClassification(Movie.Classifications.MA);
//        newMovie3.setDuration(109);
//        newMovie3.setReleaseDate("19/5/2019");
//        newMovie3.setCopies(2);
//        newMovie3.setTimesRented(100);
//        bTree.addNode(newMovie3);

//


//
//
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        MovieCollection collection = new MovieCollection();
//
//        collection.populateBinaryTreeWithMoviesTitles();
//
//        collection.displayTop10();
//
//
//    }
}
