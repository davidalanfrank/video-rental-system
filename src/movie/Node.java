package movie;

public class Node {
    String title;
    Movie movie;

    Node leftChild;
    Node rightChild;

    Node(String title , Movie movie){
        this.title = title;
        this.movie= movie;
    }
//    public String toString(){
//
//        return  title + " has been borrowed  " + movie;
//
//    }
}
