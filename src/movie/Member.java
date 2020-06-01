package movie;

import java.util.ArrayList;

public class Member {
    /**
     * This class models a member of the library
     * @author David Alan Frank Webster
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

    /**
     * This method sets a last name of a member
     * and then sets a username using a lastname
     * and firstname.
     */
    public void setLName(String lName) {
        this.lName = lName;
        setUsername(this.lName + this.fName);

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
