package movie;

public class MemberCollection {

    /**
     * Design and implement a class MemberCollection to represent a
     * collection of registered members (a collection of the objects
     * of the class Member). The class MemberCollection must use an
     * !!!array!!! as a class member to store the members.
     */
    private Member[] members = new Member[20];
    private static int totalMembers;

    public MemberCollection() {
    }

    /**
     * Constructs and adds a new memeber to the Member collection
     */
    public void addMember(Member newMember) {

        this.members[totalMembers++] = newMember;



    }

    /**
     * Prompts the user for input and finds a the phone number of that member
     */
    public static void findMember() {
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




}
