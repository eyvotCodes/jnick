package com.example.jnick.generator;

import java.util.ArrayList;

/**
 * @author fabian
 */
public class Generator {

    private final int TREE_FIRST_LEVEL  =  1;
    private final int ASCII_A_MINUS     = 97;
    private final int FIRST_ELEMENT     =  0;


    public Generator() {}


    /**
     * Generates a n-ary tree that contains all possible combinations of
     * characters given in the alphabet. The tree is generated in width,
     * i.e. level by level.
     * <p>
     * Each combination is represented by the path from the root to each
     * one of its leafs.
     *
     * @param   rootNodes first level of the tree
     * @param   alphabet  characters to use
     * @param   length    combinatios length
     * @return            root nodes of the tree
     * */
    public ArrayList<Node> generateTree(ArrayList<Node> rootNodes,
            char[] alphabet, int length) {
        if(length <= 1) {
            return rootNodes;
        } else {
            ArrayList<Node> newLevelNodes = new ArrayList<Node>();

            for(Node node:rootNodes) {
                node.setChildren(generateRootNodes(alphabet));
                newLevelNodes.addAll(node.getChildren());
            }

            generateTree(newLevelNodes, alphabet, length-1);
            return rootNodes;
        }
    }

    /**
     * Calculates the number of leafs of the tree, which should be equals to
     * the number of combinations.
     *
     * @param   rootNode root node of the tree.
     * @return           number of leafs of the tree.
     * */
    public int getLeafsNumber(Node rootNode) {
        int counter = 0;
        if(rootNode.hasChildren()) {
            for(Node child:rootNode.getChildren()) {
                counter += getLeafsNumber(child);
            }
        } else {
            counter++;
        }
        return counter;
    }

    /**
     * Calculates the number of leafs of the tree, which should be equals to
     * the number of combinations.
     *
     * @param   rootNodes root nodes of the tree.
     * @return            number of leafs of the tree.
     * */
    public int getLeafsNumber(ArrayList<Node> rootNodes) {
        int counter = 0;
        for(Node node:rootNodes) {
            if(node.hasChildren()) {
                for(Node child:node.getChildren()) {
                    counter += getLeafsNumber(child);
                }
            } else {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Calculates the height of the tree.
     *
     * @param   rootNode root node of the tree.
     * @return           height of the tree.
     * */
    public int getTreeHeight(Node rootNode) {
        int height = TREE_FIRST_LEVEL;
        while(rootNode.hasChildren()) {
            height++;
            rootNode = rootNode.getFirstChild();
        }
        return height;
    }

    /**
     * Calculates the height of the tree.
     *
     * @param   rootNodes root nodes of the tree.
     * @return            height of the tree.
     * */
    public int getTreeHeight(ArrayList<Node> rootNodes) {
        int height = TREE_FIRST_LEVEL;
        Node node = rootNodes.get(FIRST_ELEMENT);
        while(node.hasChildren()) {
            height++;
            node = node.getFirstChild();
        }
        return height;
    }

    /**
     * Converts an alphabet array to a list of nodes.
     *
     * @param   alphabet alphabet of characters.
     * @return           nodes list.
     * */
    public ArrayList<Node> generateRootNodes(char[] alphabet) {
        ArrayList<Node> alphabetList = new ArrayList<Node>();

        for(char character:alphabet) {
            Node node = new Node(character);
            alphabetList.add(node);
        }

        return alphabetList;
    }

    /**
     * Generates an alphabet from the ascii character 'a', until ascii
     * character that follows in the given position.
     *
     * @param   length number of positions after character 'a'.
     * @return         alphabet generated.
     * */
    public char[] generateAlphabet(int length) {
        char[] alphabet = new char[length];
        for(int i=0; i<length; i++) {
            alphabet[i] =(char) (ASCII_A_MINUS + i);
        }
        return alphabet;
    }

}
