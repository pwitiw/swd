package pwr.swd;

import java.util.List;

/**
 * Created by Patryk on 04.05.2016.
 */
public class Node {

    private String name;
    private List<Parameters> neighbors;

    public Node() {
    }

    public Node(String name, List<Parameters> neighbors) {
        this.neighbors = neighbors;
        this.name = name;
    }


    public static Node parseNode(String name) {

        Node node = new Node();


        return node;
    }


}
