package com.java_practice.DSA.BinarySearchTree;


//BinarySearchTree Class
public class BST {
    Node root;
//Node
    class Node{
        int value;
        Node right;
        Node left;

        public Node(int value){
            this.value = value;
        }
    }
    //insert method
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }
        Node temp = root;

        while(true){
            if(temp.value == newNode.value) return false;
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else{
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    //contains method to check if value is present or not
    public boolean contains(int value){
        Node temp = root;
        while(temp != null){
            if(value < temp.value){
                temp = temp.left;
            }else if(value > temp.value){
                temp = temp.right;
            }else{
                return true;
            }
        }
        return false;
    }

    //recursionContains
    private boolean rContains(Node currentNode, int value){
        if(currentNode == null)return false;
        if(currentNode.value == value) return true;
        if(currentNode.value > value){
            return rContains(currentNode.left, value);
        }else{
            return rContains(currentNode.right, value);
        }
    }
    public boolean rContains(int val){
        return rContains(root, val);
    }

    //recursion insert
    private Node rInsert(Node currentNode, int value){
        if(currentNode == null){return new Node(value);}
        if(currentNode.value > value){
            currentNode.left = rInsert(currentNode.left, value);
        }else if(currentNode.value < value){
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root, value);
    }
}
