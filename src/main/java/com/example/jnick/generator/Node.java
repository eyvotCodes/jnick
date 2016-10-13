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
    
    public boolean hasChildren() {
        return !this.children.isEmpty();
    }
    
    @Override public String toString() {
        return this.hasChildren()
             ? "character: " + this.getCharacter()
             +  "\nchilds: " + this.getChildren()
             : "character: " + this.getCharacter()
             ;
    }
    
}
