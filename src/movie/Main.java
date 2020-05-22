package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static movie.UserMenu.*;

public class Main {
    /**
     * A class that will handle all of the console menu
     *
     * The software application should have a staff menu that allows the staff to do the following:
     *  Add DVDs of a new movie to the software application
     *  Remove a movie DVD from the software application
     *  Register a member with the software application
     *  Find a member’s contact phone number, given the member’s full name
     */
    public static void main(String[] args) throws IOException {
        /* We need some type of event loop
        that reads each input nad break when it
        reads a 0
        * */

        /* Create a buffered reader for user input */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



       int nextInput=1000;
        /* Reading data using readline */
        while(nextInput != 0){

            displayWelcomeMenu();

            /* Prepare String for user input */
            String input;

            /* Read user input */
            input = reader.readLine();

            try{
                /* Parse user input into int */
                nextInput = Integer.parseInt(input);
            }catch (NumberFormatException e)
            {
                System.out.println("Invalid input");
            }

            //TODO Login manager

            if( nextInput == 1 ){

                /* !!! We're inside of the Staff !!! */
                while(nextInput != 0)
                {
                    displayStaffMenu();

                    /* Read user input */
                    input = reader.readLine();
                    try{
                        nextInput = Integer.parseInt(input);
                    }catch (NumberFormatException e)
                    {
                        System.out.println("Invalid input");
                    }
                    switch(nextInput){
                        case 0:
                            break;
                        case 1:
                            MovieCollection.AddMovie();
                        case 2:
                            MovieCollection.removeMovie();
                        case 3:
                            MemberCollection.newMember();
                        case 4:
                            MemberCollection.findMember();
                        default:
                            System.out.println("Invalid input");

                    }

                }

            }

            if( nextInput == 2){

                /* !!! We're inside of Member !!! */
                while(nextInput != 0)
                {
                    displayMemberMenu();

                    /* Read user input */
                    input = reader.readLine();
                    try{
                        nextInput = Integer.parseInt(input);
                    }catch (NumberFormatException e)
                    {
                        System.out.println("Invalid input");
                    }
                    switch(nextInput){
                        case 0:
                            break;
                        case 1:
                            MovieCollection.displayAllMovies();
                        case 2:
                            MovieCollection.borrowMovie();
                        case 3:
                            MovieCollection.returnMovie();
                        case 4:
                            MovieCollection.currentlyBorrowed();
                        case 5:
                            MovieCollection.displayTop10();
                        default:
                            System.out.println("Invalid input");

                    }

                }



            }


        }

        System.out.println("Thank you for visiting the Community Library. Bye ^__^");
        

    }
}
