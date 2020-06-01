package movie;

public class BinaryTree {
    /**
     * This class contains all functions for building and operating on a
     * binary search tree.
     * @author David Alan Frank Webster
     */

    Node root;

    // An array of elements than contain [ reference number, title of a movie ]
    String[][] refArr;

    // An arr of elements than contain [ title of a movie, times that movie has been borrowed ]
    String[][] titleAndTimesBorrowed;

    // The number of nodes in the binary search tree
    int sizeOfTree = 0;
    int count;

    /**
     * Adds a single node to the binary search tree.
     * This method calls a recursive addNode function
     * @param movie A single movie object
     * **/
    public void addNode(Movie movie){

        if(root == null){
            root = new Node(movie.getTitle(), movie);
        }else{
            addNode(movie, root);
        }
    }

    /*
    * Recursively adds nodes to a binary search tree
    * */
    private void addNode(Movie givenMovie, Node focusNode ){

        // Compare given title with the current node
        if(givenMovie.getTitle().compareTo(focusNode.title) < 0){
            if(focusNode.leftChild == null){
                focusNode.leftChild = new Node(givenMovie.getTitle(), givenMovie);
            }else{
                addNode(givenMovie, focusNode.leftChild);
            }

        }else{
            if(focusNode.rightChild==null){
                focusNode.rightChild = new Node(givenMovie.getTitle(), givenMovie);
            }else{
                addNode(givenMovie, focusNode.rightChild);
            }

        }

    }

    /**
     * This function removes a selected Node by it's title value from the
     * binary search tree
     * @param title A title of a Movie DVD
     * **/
    public void removeNode(String title)
    {
        Node itemToRemove = root;
        Node parent = null;
        while((itemToRemove!=null)&&(title.compareTo(itemToRemove.title)!=0))
        {
            parent = itemToRemove;
            if(title.compareTo(itemToRemove.title) < 0)
                itemToRemove = itemToRemove.leftChild;
            else
                itemToRemove = itemToRemove.rightChild;
        }
        if(itemToRemove != null)
        {
            if((itemToRemove.leftChild != null)&&(itemToRemove.rightChild != null))
            {
                if(itemToRemove.leftChild.rightChild == null)
                {
                    itemToRemove.title = itemToRemove.leftChild.title;
                    itemToRemove.leftChild = itemToRemove.leftChild.leftChild;
                }
                else
                {
                    Node newParent = itemToRemove.leftChild;
                    Node parentNewParent = itemToRemove;
                    while(newParent.rightChild != null)
                    {
                        parentNewParent = newParent;
                        newParent = newParent.rightChild;
                    }
                    itemToRemove.title = newParent.title;
                    parentNewParent.rightChild = newParent.leftChild;
                }
            }
            else
            {
                Node child;
                if(itemToRemove.leftChild != null)
                    child = itemToRemove.leftChild;
                else
                    child = itemToRemove.rightChild;

                if(itemToRemove == root)
                    root = child;
                else
                {
                    if(itemToRemove == parent.leftChild)
                        parent.leftChild = child;
                    else
                        parent.rightChild = child;
                }
            }

        }
    }

    /**
     * Performs an In Order Traversal of the binary search tree
     * printing the name of each visited node to the console
     * **/
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    /*
    * This function assists in the In Order Traversal
    * by checking if a node is null and recursively calling
    * on the left and right children of the current node
    * */
     private void inOrderTraversal(Node focusNode){

        if(focusNode != null ){
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode.title);
            inOrderTraversal(focusNode.rightChild);

        }
    }

    /**
     * This is a helper method for DisplayTop10().
     * This method Constructs an array of each Nodes movie title
     *      and the amount of times that title has been borrowed.
     * Note: preOrderTraversal() is called to count each Node
     *      in the binary search tree.
     * **/
    public void arbitraryTraverse(){
        count = 0;
        // A node count is performed
        preOrderTraversal();
        titleAndTimesBorrowed = new String[sizeOfTree][2];
        arbitraryTraverse(root);
    }

    /*
    * Assists arbitraryTraverse() by assigning the values of
    * each node as a new "cell" in the array and adding that
    * to the two dimensional array.
    * */
    private void arbitraryTraverse(Node focusNode){
        // Prepares a new cell to be placed in the array
        String[] newCell = new String[2];
        if(focusNode != null ){
            arbitraryTraverse(focusNode.leftChild);
            newCell[0] = focusNode.title;
            newCell[1] = Integer.toString(focusNode.movie.getTimesRented());
            titleAndTimesBorrowed[count++] = newCell;
            arbitraryTraverse(focusNode.rightChild);
        }
    }

    /**
     * This is a helper method for DisplayTop10().
     * This method populates titleAndTimesBorrowed[][]
     * and splits the array into two two dimensional arrays.
     * The first is the array to reference a movie title and
     * the second is a reference to the amount of times a movie
     * has been borrowed.
     * @return arrayToSort an array to be quicksorted
     * * **/
    public int[][] splitArray(){
        // Populates titleAndTimesBorrowed[][]
        arbitraryTraverse();
        int n = titleAndTimesBorrowed.length;
        refArr = new String[n][2];
        int[][] arrayToSort = new int[n][2];
        int i = 0;
        while(i < n  ){
            arrayToSort[i][0]=i;
            arrayToSort[i][1]= Integer.parseInt(titleAndTimesBorrowed[i][1]);
            refArr[i][0] = Integer.toString(i);
            refArr[i][1] = titleAndTimesBorrowed[i][0];
            i++;
        }
        return arrayToSort;
    }

    /**
     * This method performs a Pre-Order traversal of the binary
     * search tree. This method is used to count each Node in the
     * binary search tree.
     * * **/
    public void preOrderTraversal(){
        sizeOfTree = 0;
        preOrderTraversal(root);

    }

    /*
    * A helper method for preOrderTraversal. Recursively
    * visits both the left and right children of the binary
    * search tree
    * */
    private void preOrderTraversal(Node focusNode){
        if(focusNode != null ){
            sizeOfTree++;
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }


    /**
     * This method will return a Movie object if a given title
     * is somewhere in the binary search tree.
     * @param title A title of a Movie DVD
     * @return A move object that matches the given title
     *          or null
     * */
    public Movie SearchTitle(String title){

        return SearchTitle(title, root);
    }

    /*
    * A helper method for SearchTitle()
    *  */
    private Movie SearchTitle(String title, Node r){
        if ( r != null )
        {
            if( title.compareTo(r.movie.getTitle()) == 0 ){

                return r.movie;
            }
            else if (title.compareTo(r.movie.getTitle()) < 0){

                return SearchTitle(title, r.leftChild);

            }else{
                return SearchTitle(title, r.rightChild);
             }
        }
        else{
            System.out.println("Search Error!");
            return null;
        }
    }



/////////// USED FOR TESTING //////////////////
//    public static void main(String[] args){
//
//        BinaryTree tree = new BinaryTree();
//
//
//        Movie newMovie1 = new Movie();
//        newMovie1.setTitle("Movie 1");
//        newMovie1.setStarring("Megumi Ogata, Megumi Hayashibara");
//        newMovie1.setDirector("Hideaki Anno");
//        newMovie1.setGenre(Movie.Genres.SciFi);
//        newMovie1.setClassification(Movie.Classifications.M);
//        newMovie1.setDuration(101);
//        newMovie1.setReleaseDate("1/9/2007");
//        newMovie1.setCopies(3);
//        newMovie1.setTimesRented(30);
//
//        tree.addNode(newMovie1);
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
//        newMovie2.setTimesRented(28);
//        tree.addNode(newMovie2);
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
//        newMovie3.setTimesRented(3);
//        tree.addNode(newMovie3);
//
//        Movie newMovie4= new Movie();
//        newMovie4.setTitle("Movie 9");
//        newMovie4.setStarring("9 Actors");
//        newMovie4.setDirector("Director 9");
//        newMovie4.setGenre(Movie.Genres.SciFi);
//        newMovie4.setClassification(Movie.Classifications.M);
//        newMovie4.setDuration(99);
//        newMovie4.setReleaseDate("0/9/2019");
//        newMovie4.setCopies(9);
//        newMovie4.setTimesRented(0);
//        tree.addNode( newMovie4);
//
//        Movie newMovie5 = new Movie();
//        newMovie5.setTitle("Bee Movie");
//        newMovie5.setStarring("10 Actors");
//        newMovie5.setDirector("Director 10");
//        newMovie5.setGenre(Movie.Genres.Thriller);
//        newMovie5.setClassification(Movie.Classifications.MA);
//        newMovie5.setDuration(190);
//        newMovie5.setReleaseDate("10/10/2019");
//        newMovie5.setCopies(10);
//        newMovie5.setTimesRented(10);
//        tree.addNode(newMovie5);
//
//
//    }
}
