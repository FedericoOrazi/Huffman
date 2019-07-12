public class Node {
    private char lettera;
    private int key;

    public Node(int key, char lettera){
        this.key = key; //in questo caso la chiave rappresenta la freq della lettera se il nodo è foglia
        this.lettera = lettera;
    }
    public int getKey(){
        return this.key;
    }
    public char getChar(){
        return this.lettera;
    }
    public void setKey(int key){
        this.key = key;
    }
}