public class Node {
    private char lettera;
    private int key;

    public Node(int key, char lettera){
        this.key = key;
        this.lettera = lettera;
    }
    public int getKey(){
        return this.key;
    }
    public char getChar(){
        return this.lettera;
    }
}