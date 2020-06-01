package movie;

import java.util.HashMap;

public class BinaryTree {

    Node root;



    public String[][] getRefArr() {
        return refArr;
    }

    public void setRefArr(String[][] refArr) {
        this.refArr = refArr;
    }

    String[][] refArr;
    String[][] titleAndTimesRented;

    int sizeOfTree = 0;
    int count;



    public void addNode(Movie movie){

        if(root == null){
            root = new Node(movie.getTitle(), movie);
        }else{
            addNode(movie, root);
        }
    }

    private void addNode(Movie givenMovie, Node focusNode ){



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

        // If not root exists, new node becomes the root
//        if(root == null){
//            root = newNode;
//        }else{
//            Node focusNode = root;
//
//            Node parent;
//
//
//            while(true){
//
//                parent = focusNode;
//
//                if(title.compareTo(focusNode.title) < 0 ){
//
//                    focusNode = focusNode.leftChild;
//
//                    if(focusNode == null){
//                        System.out.println("Left node added");
//                        parent.leftChild = newNode;
//                        return;
//                    }
//
//                }else{
//                    System.out.println("Right node added");
//                    focusNode = focusNode.rightChild;
//
//                    if(focusNode == null ){
//                        parent.rightChild = newNode;
//                        return;
//                    }
//
//                }
//            }
//        }

    }

    // there are three cases to consider:
    // 1. the node to be deleted is a leaf
    // 2. the node to be deleted has only one child
    // 3. the node to be deleted has both left and right children
    public void removeNode(String title)
    {
        // search for item and its parent
        Node itemToRemove = root; // search reference
        Node parent = null; // parent of ptr
        while((itemToRemove!=null)&&(title.compareTo(itemToRemove.title)!=0))
        {
            parent = itemToRemove;
            if(title.compareTo(itemToRemove.title) < 0) // move to the left child of ptr
                itemToRemove = itemToRemove.leftChild;
            else
                itemToRemove = itemToRemove.rightChild;
        }

        if(itemToRemove != null) // if the search was successful
        {
            // case 3: item has two children
            if((itemToRemove.leftChild != null)&&(itemToRemove.rightChild != null))
            {
                // find the right-most node in left subtree of ptr
                if(itemToRemove.leftChild.rightChild == null) // a special case: the right subtree of ptr.LChild is empty
                {
                    itemToRemove.title = itemToRemove.leftChild.title;
                    itemToRemove.leftChild = itemToRemove.leftChild.leftChild;
                }
                else
                {
                    Node newParent = itemToRemove.leftChild;
                    Node parentNewParent = itemToRemove; // parent of p
                    while(newParent.rightChild != null)
                    {
                        parentNewParent = newParent;
                        newParent = newParent.rightChild;
                    }
                    // copy the item at p to ptr
                    itemToRemove.title = newParent.title;
                    parentNewParent.rightChild = newParent.leftChild;
                }
            }
            else // cases 1 & 2: item has no or only one child
            {
                Node child;
                if(itemToRemove.leftChild != null)
                    child = itemToRemove.leftChild;
                else
                    child = itemToRemove.rightChild;

                // remove node ptr
                if(itemToRemove == root) //need to change root
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

    public void inOrderTraversal(){


        inOrderTraversal(root);



    }
    // Prints "In order", top down ??
     private void inOrderTraversal(Node focusNode){

        if(focusNode != null ){

            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode.title);
            inOrderTraversal(focusNode.rightChild);

        }
    }

    public void arbitraryTraverse(){
        // Size of the tree
        count = 0;
        preOrderTraversal();
        titleAndTimesRented = new String[sizeOfTree][2];
        arbitraryTraverse(root);
    }
    // Prints "In order", top down ??
    private void arbitraryTraverse(Node focusNode){


        String[] newCell = new String[2];

        if(focusNode != null ){

            arbitraryTraverse(focusNode.leftChild);
            newCell[0] = focusNode.title;
            newCell[1] = Integer.toString(focusNode.movie.getTimesRented());
            titleAndTimesRented[count++] = newCell;
            arbitraryTraverse(focusNode.rightChild);


        }


    }



    public int[][] splitArray(){

        arbitraryTraverse();
        int n = titleAndTimesRented.length;
        refArr = new String[n][2];
        int[][] arrayToSort = new int[n][2];
        int i = 0;
        while(i < n  ){
            // using the index as the id
            arrayToSort[i][0]=i;
            refArr[i][0] = Integer.toString(i);
            arrayToSort[i][1]= Integer.parseInt(titleAndTimesRented[i][1]);
            refArr[i][1] = titleAndTimesRented[i][0];
            i++;
        }


        return arrayToSort;

    }

    public void preOrderTraversal(){
        sizeOfTree = 0;
        preOrderTraversal(root);

    }
    private void preOrderTraversal(Node focusNode){
        if(focusNode != null ){
            sizeOfTree++;
//            System.out.println(focusNode);

            preOrderTraversal(focusNode.leftChild);

            preOrderTraversal(focusNode.rightChild);
        }
    }

    private void postOrderTraversal(Node focusNode){
        if(focusNode != null ){

            postOrderTraversal(focusNode.leftChild);

            postOrderTraversal(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    ///// SEARCH AND RETURN THE MOVIE /////
    public Movie SearchTitle(String title){

        return SearchTitle(title, root);
    }

    private Movie SearchTitle(String title, Node r){
//        System.out.println("In new Node. Title is :");
//        System.out.println(title);

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





    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();


        Movie newMovie1 = new Movie();
        newMovie1.setTitle("Movie 1");
        newMovie1.setStarring("Megumi Ogata, Megumi Hayashibara");
        newMovie1.setDirector("Hideaki Anno");
        newMovie1.setGenre(Movie.Genres.SciFi);
        newMovie1.setClassification(Movie.Classifications.M);
        newMovie1.setDuration(101);
        newMovie1.setReleaseDate("1/9/2007");
        newMovie1.setCopies(3);
        newMovie1.setTimesRented(30);

        tree.addNode(newMovie1);

        Movie newMovie2 = new Movie();
        newMovie2.setTitle("Arrival");
        newMovie2.setStarring("\t\n" +
                "Amy Adams,\n" +
                "Jeremy Renner,\n" +
                "Forest Whitaker,\n" +
                "Michael Stuhlbarg and\n" +
                "Tzi Ma");
        newMovie2.setDirector("\tDenis Villeneuve");
        newMovie2.setGenre(Movie.Genres.SciFi);
        newMovie2.setClassification(Movie.Classifications.M);
        newMovie2.setDuration(116);
        newMovie2.setReleaseDate("1/9/2016");
        newMovie2.setCopies(4);
        newMovie2.setTimesRented(28);
        tree.addNode(newMovie2);

        Movie newMovie3 = new Movie();
        newMovie3.setTitle("The Lighthouse");
        newMovie3.setStarring("\t\n" +
                "Willem Dafoe,\n" +
                "Robert Pattinson");
        newMovie3.setDirector("Robert Eggers");
        newMovie3.setGenre(Movie.Genres.Thriller);
        newMovie3.setClassification(Movie.Classifications.MA);
        newMovie3.setDuration(109);
        newMovie3.setReleaseDate("19/5/2019");
        newMovie3.setCopies(2);
        newMovie3.setTimesRented(3);
        tree.addNode(newMovie3);

        Movie newMovie4= new Movie();
        newMovie4.setTitle("Movie 9");
        newMovie4.setStarring("9 Actors");
        newMovie4.setDirector("Director 9");
        newMovie4.setGenre(Movie.Genres.SciFi);
        newMovie4.setClassification(Movie.Classifications.M);
        newMovie4.setDuration(99);
        newMovie4.setReleaseDate("0/9/2019");
        newMovie4.setCopies(9);
        newMovie4.setTimesRented(0);
        tree.addNode( newMovie4);

        Movie newMovie5 = new Movie();
        newMovie5.setTitle("Bee Movie");
        newMovie5.setStarring("10 Actors");
        newMovie5.setDirector("Director 10");
        newMovie5.setGenre(Movie.Genres.Thriller);
        newMovie5.setClassification(Movie.Classifications.MA);
        newMovie5.setDuration(190);
        newMovie5.setReleaseDate("10/10/2019");
        newMovie5.setCopies(10);
        newMovie5.setTimesRented(10);
        tree.addNode(newMovie5);

//
        Movie newMovie6 = new Movie();
//        newMovie6.setTitle("Movie 13");
//        newMovie6.setStarring("11 Actors");
//        newMovie6.setDirector("Director 10");
//        newMovie6.setGenre(Movie.Genres.Thriller);
//        newMovie6.setClassification(Movie.Classifications.MA);
//        newMovie6.setDuration(190);
//        newMovie6.setReleaseDate("10/10/2019");
//        newMovie6.setCopies(10);
//        newMovie6.setTimesRented(11);
//        tree.addNode(newMovie6);

//        tree.arbitraryTraverse();
//        tree.inOrderTraversal();
//        System.out.println("compareToTEST");
//        System.out.println("Arrival".compareTo("Movie"));
//        System.out.println("Movie".compareTo("Arrival"));
//        System.out.println("tree.SearchTitle(\"Bee Movie\")");
//
//        System.out.println( tree.SearchTitle("Bee Movie").getTitle());
//        int[][] arr = tree.splitArray();
//        int n = arr.length;
//        System.out.println("#####DEBUG: main(): Printing array " );
//        for (int i=0; i<n; ++i)
//            System.out.print(arr[i][1]+" ");
//        System.out.println();


        // Fix the binary tree


    }
}
