package movie;

public class UserMenu {
    /**
     * Prints all of the menu options for different users to the console
     */

    public static void displayWelcomeMenu(){
        String welcomeMenu = "Welcome to the Community Library\n" +
                "===========Main Menu===========\n" +
                "1. Staff Login\n" +
                "2. Member Login\n" +
                "0. Exit\n" +
                "===============================\n" +
                "Please make a selection (1-2, or 0 to exit)";
        System.out.println(welcomeMenu);
    }

    public static void displayStaffMenu(){
        String staffMenu =  "============Staff Menu===========\n" +
                "1. Add a new movie DVD\n" +
                "2. Remove a movie DVD\n" +
                "3. Register a new Member\n" +
                "4. Find a registered member's phone number\n" +
                "0. Return to main menu\n" +
                "===============================\n" +
                "Please make a selection (1-4, or 0 to return to main menu)";
        System.out.println(staffMenu);

    }

    public static void displayMemberMenu(){
        String staffMenu =  "============Member Menu===========\n" +
                "1. Display all movies\n" +
                "2. Borrow a movie DVD\n" +
                "3. Return a movie DVD\n" +
                "4. List current borrowed movie DVDs\n" +
                "5. Display top 10 most popular movies\n" +
                "0. Return to main menu\n" +
                "===============================\n" +
                "Please make a selection (1-5, or 0 to return to main menu)";
        System.out.println(staffMenu);

    }


}
