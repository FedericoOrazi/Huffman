package Huffman;

public class Node {
    private char lettera;
    private int key;
    
    private Node left;
    private Node right;

    public Node(){
    }
    
    public int getKey(){
        return this.key;
    }
    public char getChar(){
        return this.lettera;
    }
    public Node left(){
        return this.left;
    }
    public Node right(){
        return this.right;
    }
    public void setKey(int key){
        this.key = key;
    }
    public void setChar(char lettera){
        this.lettera = lettera;
    }
    public void setLeft(Node l){
        this.left = l;
    }
    public void setRight(Node r){
        this.right = r;
    }
}