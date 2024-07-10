package org.example;

import java.util.ArrayList;

public class Node {
    //Fields
    static int ID_FOR_NEW_NODE = 1;

    String name;
    int ID;
    ArrayList<Node> children = new ArrayList<Node>();

    //Constructors
    public Node(String name) {
        this.name = name;
        this.ID = ID_FOR_NEW_NODE;
        ++ID_FOR_NEW_NODE;
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public ArrayList<Node> getChildren() { return children; }

    public void addNewNode(int parentID, String name) {
    }

    public Node findNode(String name) {
        return null;
    }

    public void deleteNodeForName(String name) {
    }

    public void deleteNodeForID(int ID) {
    }

    public void deleteAllChildrenForID(int ID) {
    }

    public void deleteAllChildrenForName(String name) {
    }

    public void Rename(String newName) {
    }
}
