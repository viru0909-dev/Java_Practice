package com.java_practice.DSA.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(12);
        bst.insert(11);
        bst.insert(10);
        bst.insert(15);
        bst.insert(13);
        bst.insert(16);
        bst.rInsert(17);


        System.out.println("11 is Present : "+ bst.contains(11));
        System.out.println("Using Recursion to see it contains 17 is in tree : "+ bst.rContains(17));

        System.out.println("Root = " + bst.root.value);
    }
}
