package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MemberCollection {



    /**
     * Design and implement a class MemberCollection to represent a
     * collection of registered members (a collection of the objects
     * of the class Member). The class MemberCollection must use an
     * !!!array!!! as a class member to store the members.
     */


    private static Member[] members = new Member[1];
    private static int totalMembers = 0;
    private static int indexOfLoggedInUser;

    /**
     * Constructs and adds a new memeber to the Member collection
     */
    public static void addMember() throws IOException {


        /* The new member to be added to the array */
        Member newMember = new Member();

        /* Create a buffered reader for user input */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        System.out.println("Enter members First name:");
        input = reader.readLine();

        newMember.setFName(input);
        System.out.println("Enter members Last name:");
        input = reader.readLine();

        newMember.setLName(input);
        System.out.println("Enter phone number:");
        input = reader.readLine();

        newMember.setPhoneNum(input);
        System.out.println("Enter address:");
        input = reader.readLine();

        newMember.setAddress(input);
        System.out.println("Enter password (Must be 4 digits):");

        input = reader.readLine();

        try{
            if(input.length()==4 && input.matches("^\\d+$")){

                newMember.setPassword(Integer.parseInt(input));



            }else{

                throw new NumberFormatException();

            }



            Member[] newMembers = new Member[totalMembers + 1];

            for(int i = 0; i < members.length; i++)
            {
                newMembers[i] = members[i];
            }

            newMembers[totalMembers++] = newMember;

            members = sortMembersByUsername(newMembers);


            System.out.println( "User: " +newMember.getFName() + " " + newMember.getLName() + ", has been added!");
        }catch(NumberFormatException e){
            System.out.println("Error! Password must be a 4 digit combination");

        }



    }

    private static Member[] sortMembersByUsername( Member[] members ){


        Member[] sortedMembers = new Member[totalMembers + 1];
        sortedMembers = members;

        int count=0;
        for(int i = 0; i < totalMembers - 1; ++i) {
            for (int j = i + 1; j < totalMembers; ++j) {
                if (sortedMembers[i].getUsername().compareTo(sortedMembers[j].getUsername()) > 0) {
                    // swap words[i] with words[j[
                    Member temp = sortedMembers[i];
                    sortedMembers[i] = sortedMembers[j];
                    sortedMembers[j] = temp;
                    count++;
                }
            }
        }
        return sortedMembers;

    }
    /**
     * Prompts the user for input and finds the phone number of that member
     */
    public void findMember() throws IOException {
        String fName;
        String lName;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        System.out.println("Enter members First name:");
        input = reader.readLine();

        fName = input;

        System.out.println("Enter members Last name:");
        input = reader.readLine();

        lName = input;

        int indexOfSearchMember = binaryMemberSearch(members, lName+fName);

        if(indexOfSearchMember != -1){
            System.out.println(fName + " " + lName + "'s phone number is: " + members[indexOfSearchMember].getPhoneNum());
        }else{
            System.out.println("Error! Member doesn't exist\n");
        }



    }


    /**
     * A helper method that populates the movie list with 1 member
     */
    public static void populateListWithTestMembers() throws IOException {
        /* The new member to be added to the array */
        Member newMember1 = new Member();


        newMember1.setFName("User");
        newMember1.setLName("Test");
        newMember1.setPhoneNum("0120-XXX-XXX");
        newMember1.setAddress("Shinjuku, 3 Chome−27−4 1 3F");
        newMember1.setPassword(1111);


        members[0] = newMember1;
        totalMembers++;


    }

    /*
    A binary search algorithm to find a member given a username
     @param Member[] members the array of members
     @param String username the user name of a potentially registered member
     @return int the index of the member
     */
    private int binaryMemberSearch(Member[] members, String username){
        int l = 0;
        int r  = totalMembers - 1;

        while( l <= r ){

            int middle = l + (r - l )/2;

            if(members[middle].getUsername().compareTo(username) == 0 ){
                return middle;
            }
            if(members[middle].getUsername().compareTo(username) < 0 ){
                l = middle +1;
            }else{
                r = middle - 1;
            }

        }
        return -1;
    }


    public boolean memberLogin(String givenUsername, String givenPassword) {

        int indexOfUsername = binaryMemberSearch(members, givenUsername);

        if ( indexOfUsername == -1 ){
            System.out.println("Username doesn't exist");
            return false;
        }else{
            if( members[indexOfUsername].getPassword() ==  Integer.parseInt(givenPassword) ){

//                members[indexOfUsername].setLoggedIn(true);
                indexOfLoggedInUser = indexOfUsername;

                System.out.println("User: " + members[indexOfLoggedInUser].getUsername() + ", has successfully logged in");
                return true;
            }else{
                System.out.println("Wrong Password");
                return false;
            }

        }


    }

    public static Member[] getMembers() {
        return members;
    }
    public static int getIndexOfLoggedInUser() {
        return indexOfLoggedInUser;
    }

}
