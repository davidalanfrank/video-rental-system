package movie;

public class Node {
    /**
     * This class represents a model of a node in a binary search tree
     */
    String title;
    Movie movie;

    Node leftChild;
    Node rightChild;

    /**
     * A constructor for a Node
     * */
    Node(String title, Movie movie){
        this.title = title;
        this.movie= movie;
    }

}
