package movie;

import java.util.ArrayList;

public class Member {
    /**
     * Design and implement a class Member to model a
     * library member. In this software application, each registered
     * member is represented by an object of the class Member.
     *
     * Fields:
     * their full name, residential address, and a
     * contact phone number are recorded in the system.
     *
     * The system also keeps the information
     * about the movie DVDs that are currently
     * being borrowed by each of the registered members
     *
     *  A registered member can borrow up to 10
     * movies at any time.
     */
    private String username;
    private String fName;
    private String lName;
    private String address;
    private String phoneNum;
    private int password;
    private ArrayList borrowedMovies = new ArrayList();
    private boolean isLoggedIn;

    /**
     * A constructor for a member
     */
    public Member(){


    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    /*
    * Sets a lastname and then uses the lName and first name to set the username*/

    public void setLName(String lName) {

        this.lName = lName;

        setUsername(this.lName + this.fName);


    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }


    public ArrayList getBorrowedMovies() {

        return borrowedMovies;
    }

    public void setBorrowedMovies(ArrayList borrowedMovies) {
        this.borrowedMovies = borrowedMovies;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
