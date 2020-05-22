package movie;

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

    private String fName;
    private String lName;
    private String address;
    private String phoneNum;
    private int password;

    /**
     * A constructor for a member
     */
    public Member(){

    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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












}
