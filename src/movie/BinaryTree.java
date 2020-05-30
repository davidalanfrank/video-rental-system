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

    HashMap<String,String> map = new HashMap<>();

    public void addNode(String title, Movie movie ){

        Node newNode = new Node(title, movie);

        // If not root exists, new node becomes the root
        if(root == null){
            root = newNode;
        }else{
            Node focusNode = root;

            Node parent;

            while(true){

                parent = focusNode;

                if(title.compareTo(focusNode.title) < 0 ){

                    focusNode = focusNode.leftChild;

                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }

                }else{
                    focusNode = focusNode.rightChild;

                    if(focusNode == null ){
                        parent.rightChild = newNode;
                        return;
                    }

                }
            }
        }
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
        System.out.println("InOrder: ");
        inOrderTraversal(root);
        System.out.println("End");


    }
    // Prints "In order", top down ??
     private void inOrderTraversal(Node focusNode){


        if(focusNode != null ){
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);

        }
    }

    public void arbitraryTraverse(){
        System.out.println("arbitraryTraverse()");
        arbitraryTraverse(root);

    }
    // Prints "In order", top down ??
    private void arbitraryTraverse(Node focusNode){

        if(focusNode != null ){
            arbitraryTraverse(focusNode.leftChild);
            System.out.println("arbitraryTraverse() focusNode.title + Integer.toString(focusNode.movie.getTimesRented()");
            this.map.put(focusNode.title, Integer.toString(focusNode.movie.getTimesRented()));
            System.out.println(focusNode.title + focusNode.movie.getTimesRented());
            arbitraryTraverse(focusNode.rightChild);

        }
    }



    public int[][] treeTo2DArray(){
        System.out.println("treeTo2DArray()");

        arbitraryTraverse();

        refArr = new String[map.size()][2];
        int[][] arrayToSort = new int[map.size()][2];

        int index = 0;
        System.out.println("printing values of map.");
        for (String s : map.keySet()) {

            // using the index as the id
            arrayToSort[index][0]=index;
            refArr[index][0] = Integer.toString(index);

            arrayToSort[index][1]= Integer.parseInt(map.get(s));

            refArr[index][1] = s;


            index++;


        }
        return arrayToSort;

    }

    private void preOrderTraversal(Node focusNode){
        if(focusNode != null ){

            System.out.println(focusNode);

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
        Node focusNode = root;

        return SearchTitle(title, root);
    }

    private Movie SearchTitle(String title, Node root){
        Node focusNode = root;
        if ( root != null ){
            if( title.compareTo(focusNode.title) == 0 ){
                return focusNode.movie;
            }else{
                if(title.compareTo(focusNode.title) < 0){
                    return SearchTitle(title, root.leftChild);
                }else{
                    return SearchTitle(title, root.rightChild);
                }
            }
        }
        else{
            System.out.println("This movie doesn't exists");
            return null;
        }
    }



//    public boolean SearchTitle(String title){
//        Node focusNode = root;
//
//        return SearchTitle(title, root);
//    }
//
//    private boolean SearchTitle(String title, Node root){
//        Node focusNode = root;
//        if ( root != null ){
//            if( title.compareTo(focusNode.title) == 0 ){
//                return true;
//            }else{
//                if(title.compareTo(focusNode.title) < 0){
//                    return SearchTitle(title, root.leftChild);
//                }else{
//                    return SearchTitle(title, root.rightChild);
//                }
//            }
//        }
//        else{
//            return false;
//        }
//
//    }
//    public Node findNode(int key){
//        Node focusNode = root;
//
//        while(focusNode.key != key){
//            if(key < focusNode.key){
//                focusNode = focusNode.leftChild;
//            }else{
//                focusNode = focusNode.rightChild;
//            }
//            if(focusNode == null){
//                return null;
//
//            }
//        }
//        return focusNode;
//    }
    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();


        tree = new BinaryTree();

        Movie newMovie1 = new Movie();
        newMovie1.setTitle("Evangelion: 1.0 You Are (Not) Alone");
        newMovie1.setStarring("Megumi Ogata, Megumi Hayashibara");
        newMovie1.setDirector("Hideaki Anno");
        newMovie1.setGenre(Movie.Genres.SciFi);
        newMovie1.setClassification(Movie.Classifications.M);
        newMovie1.setDuration(101);
        newMovie1.setReleaseDate("1/9/2007");
        newMovie1.setCopies(3);
        newMovie1.setTimesRented(30);

        tree.addNode(newMovie1.getTitle(), newMovie1);

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
        tree.addNode(newMovie2.getTitle(), newMovie2);

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
        tree.addNode(newMovie3.getTitle(), newMovie3);

        tree.arbitraryTraverse();


        int[][] arr = tree.treeTo2DArray();
        int n = arr.length;
        System.out.println("#####DEBUG: main(): Printing array " );
        for (int i=0; i<n; ++i)
            System.out.print(arr[i][1]+" ");
        System.out.println();


    }
}
