package movie;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MemberCollection {

    public static Member[] getMembers() {
        return members;
    }

    public static void setMembers(Member[] members) {
        MemberCollection.members = members;
    }

    /**
     * Design and implement a class MemberCollection to represent a
     * collection of registered members (a collection of the objects
     * of the class Member). The class MemberCollection must use an
     * !!!array!!! as a class member to store the members.
     */
    private static Member[] members = new Member[1];
    private static int totalMembers = 0;

    public static int getIndexOfLoggedInUser() {
        return indexOfLoggedInUser;
    }

    public static void setIndexOfLoggedInUser(int indexOfLoggedInUser) {
        MemberCollection.indexOfLoggedInUser = indexOfLoggedInUser;
    }

    private static int indexOfLoggedInUser;


    public static void main( String[] args)
    {
        populateListWithTestMembers();

    }

    public MemberCollection() {

    }

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

//        for (int n = 0; n < totalMembers; n++) {
//            System.out.println(members[n].getUsername());
//          }


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

        /* Create a buffered reader for user input */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        System.out.println("Enter members First name:");
        input = reader.readLine();

        fName = input;

        System.out.println("Enter members Last name:");
        input = reader.readLine();

        lName = input;

        int indexOfSearchMember = binaryMemberSearch(members, lName+fName);

        System.out.println(fName + " " + lName + "'s phone number is: " + members[indexOfSearchMember].getPhoneNum());


    }

    /**
     * Marks a movie as borrowed
     */
    public static void borrowMovie(){


    }
    /**
     * Marks a movie as returned
     */
    public static void returnMovie(){

    }

    /**
     * Lists the movies that are held by a member
     */
    public static void listMoviesBorrowedByMember(){

    }

    /**
     * A method that populates the movie list with 3 members
     */
    public static void populateListWithTestMembers(){
        /* The new member to be added to the array */
        Member newMember1 = new Member();
        Member newMember2 = new Member();
        Member newMember3 = new Member();
        Member newMember4 = new Member();
        Member newMember5 = new Member();
        Member newMember6 = new Member();


        newMember3.setFName("Niander");
        newMember3.setLName("Wallace");
        newMember3.setPhoneNum("unreachable");
        newMember3.setAddress("Off World");
        newMember3.setPassword(1010);


        members[totalMembers++] = newMember3;

        newMember1.setFName("Toshiki");
        newMember1.setLName("Kadomatsu");
        newMember1.setPhoneNum("0120-XXX-XXX");
        newMember1.setAddress("Shinjuku, 3 Chome−27−4 1 3F");
        newMember1.setPassword(1985);



        members[totalMembers++] = newMember1;

        newMember2.setFName("Patrick");
        newMember2.setLName("Bateman");
        newMember2.setPhoneNum("1800ILUVDorsia");
        newMember2.setAddress("55 West 81st Street");
        newMember2.setPassword(6666);


        members[totalMembers++] = newMember2;

        newMember4.setFName("Thomas");
        newMember4.setLName("Anderson");
        newMember4.setPhoneNum("@theRealNeo");
        newMember4.setAddress("SomeWhereInTheMatrix");
        newMember4.setPassword(9999);


        members[totalMembers++] = newMember4;

        newMember5.setFName("Levi");
        newMember5.setLName("Ackerman");
        newMember5.setPhoneNum("pigeon?");
        newMember5.setAddress("Wall Maria");
        newMember5.setPassword(0000);


        members[totalMembers++] = newMember5;

        newMember6.setFName("t");
        newMember6.setLName("");
        newMember6.setPhoneNum("Abnormal");
        newMember6.setAddress("Mainland");
        newMember6.setPassword(1);

        ArrayList<String> testBorrowedMovieList = new ArrayList<>();
        testBorrowedMovieList.add("Evangelion: 1.0 You Are (Not) Alone");
        testBorrowedMovieList.add("Arrival");

        newMember6.setBorrowedMovies(testBorrowedMovieList);

        members[totalMembers++] = newMember6;

        members = sortMembersByUsername(members);

    }
    /*
    A binary search algorithm to find a member given a username
     @param Member[] members the array of members
     @param String username the user name of a potentially registered member
     @return int the index of the memeber
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

                members[indexOfUsername].setLoggedIn(true);
                indexOfLoggedInUser = indexOfUsername;

                System.out.println("User: " + members[indexOfLoggedInUser].getUsername() + ", has successfully logged in");
                return true;
            }else{
                System.out.println("Wrong Password");
                return false;
            }

        }


    }
}
