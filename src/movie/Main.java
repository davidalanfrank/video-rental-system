package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static movie.UserMenu.*;


public class Main {


    /**
     * The main entry point for the application.
     * This class runs the main "event loop".
     * This class handles a users navigation through menu items a
     * @author David Alan Frank Webster
     */
    public static void main(String[] args) throws IOException {

        String givenUsername;
        String givenPassword;

        boolean staffIsLoggedIn = false;
        boolean memberIsLoggedIn;

        final String staffUsername = "staff";
        final String staffPassword= "today123";

        MovieCollection allMovies = new MovieCollection();
        MemberCollection allMembers = new MemberCollection();

        ////////// These two methods were used for testing ///////
        //  allMembers.populateListWithTestMembers();
        //  allMovies.populateBinaryTreeWithMoviesTitles();
        //////////////////////////////////////////////////////////


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       int nextInput=1000;

       // The main "Event Loop" for the console application
        while(true){

            displayWelcomeMenu();

            String input;
            input = reader.readLine();
            try{
                nextInput = Integer.parseInt(input);

            }catch (NumberFormatException e)
            {
                System.out.println("Invalid input");
            }
            if(nextInput == 0 ){
                break;
            }

            if( nextInput == 1 ){
                // Staff Login
                System.out.println("Enter username");
                input = reader.readLine();
                givenUsername = input;

                System.out.println("Enter password");
                input = reader.readLine();
                givenPassword = input;

                // Compares the given username and password with the Staff login credentials
                if(( givenUsername.compareTo(staffUsername) == 0 ) && (givenPassword.compareTo(staffPassword) == 0))
                {
                    System.out.println("\nStaff member login successful. Welcome!");
                    staffIsLoggedIn = true;
                }
                else{

                    System.out.println("Incorrect login details!");
                }

                if(staffIsLoggedIn){

                    // Staff is logged in
                    while(nextInput != 0 && staffIsLoggedIn )
                    {
                        displayStaffMenu();

                        input = reader.readLine();
                        try{
                            nextInput = Integer.parseInt(input);

                        }catch (NumberFormatException e)
                        {
                            System.out.println("Exception Invalid input");
                        }
                        switch(nextInput){

                            case 0:
                                System.out.println("Returning to Main Menu and logging you out");
                                staffIsLoggedIn =false;
                                break;
                            case 1:
                                allMovies.addMovie();
                                break;
                            case 2:
                                allMovies.removeMovie();
                                break;
                            case 3:
                                allMembers.addMember();
                                break;
                            case 4:
                                allMembers.findMember();
                                break;
                            default:
                                System.out.println("Default: Invalid input");
                                break;

                        }

                    }

                }


            }


            if( nextInput == 2){

                // Member login
                System.out.println("Enter username");
                input = reader.readLine();
                givenUsername = input;

                System.out.println("Enter password");
                input = reader.readLine();
                givenPassword = input;

                // Handling 4 digit password input
                if(input.length()==4 && input.matches("^\\d+$")){

                    memberIsLoggedIn = allMembers.memberLogin(givenUsername, givenPassword);

                }else{
                    System.out.println("Error! Password must be a 4 digit combination");
                    memberIsLoggedIn = false;
                }



                if ( memberIsLoggedIn){

                    // Member is logged in
                    while(nextInput != 0 && memberIsLoggedIn)
                    {
                        displayMemberMenu();

                        input = reader.readLine();

                        try{
                            nextInput = Integer.parseInt(input);
                        }catch (NumberFormatException e)
                        {
                            System.out.println("Exception Invalid input");
                        }
                        switch(nextInput){
                            case 0:
                                System.out.println("Returning to Main Menu and logging you out");
                                memberIsLoggedIn =false;
                                break;
                            case 1:
                                MovieCollection.displayAllMovies();
                                break;
                            case 2:
                                MovieCollection.borrowMovie();
                                break;
                            case 3:
                                MovieCollection.returnMovie();
                                break;
                            case 4:
                                MovieCollection.currentlyBorrowed();
                                break;
                            case 5:
                                MovieCollection.displayTop10();
                                break;
                            default:
                                System.out.println("Default Invalid input");
                                break;

                        }

                    }

                }else{

                    System.out.println("Incorrect Login details");

                }


            }

        }

        System.out.println("Thank you for visiting the Community Library. See you next time (~￣▽￣)~");

    }
}
