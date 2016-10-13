package com.example.jnick.app;

import com.example.jnick.generator.Node;

import java.util.ArrayList;

/**
 * @author fabian 
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        System.out.println("working in generator...");

        ArrayList<Node> children = new ArrayList<Node>();
        children.add(new Node('a'));
        children.add(new Node('b'));
        children.add(new Node('c'));

        Node x = new Node('x');
        x.setChildren(children);
        
        System.out.println(x);
    
    }
    
}
