package com.example.jnick.generator;

import java.util.ArrayList;

/**
 * @author fabian
 */
public class Node {

    private char character;
    private ArrayList<Node> children = new ArrayList<Node>();


    public Node(char character) {
        this.character = character;
    }


    public void setCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return this.character;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public Node getFirstChild() {
        return this.children.get(0);
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public int getChildrenNumber() {
        return this.children.size();
    }

    @Override public String toString() {
        return this.hasChildren() ?
            String.format(
                "character: %s\nchildren: %s",
                getCharacter(),
                getChildren()
            ):
            String.format(
                "character: %s",
                getCharacter()
            );
    }

}
