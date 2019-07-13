package Huffman;

public class BinaryHeap implements IBinaryHeap {
    private Node[] elements;
    private int heapSize;
    private static BinaryHeap instance = null;

    private BinaryHeap(){
        this.elements = new Node[10];
        this.heapSize= -1; //heap vuoto
    }
    public static BinaryHeap getInstance(){
        if(instance == null)instance = new BinaryHeap();
        return instance;
    }

    public int parent(int index){
        return (int)index/2;
    }
    public int left(int index){
        return 2*index;
    }
    public int right(int index){
        return 2*index + 1;
    }
    public Node minimum(){
        if(this.heapSize<0)
            return null;
        else
            return this.elements[0];
    }
    public void minHeapify(int key){
        int l=left(key);
        int r=right(key);
        int min = key;
        if(l <= this.heapSize && this.elements[l].getKey() < this.elements[key].getKey())
            min = l;
        if(r <= this.heapSize && this.elements[r].getKey() < this.elements[min].getKey())
            min = r;
        if (min != key) {
            scambiaNodo(this.elements[key], this.elements[min]);
            minHeapify(min);
        }
    }
    public void insert(Node nodo){
        if (this.heapSize + 1 >= this.elements.length) {
            growthStrategy();
        }
        this.heapSize ++;
        this.elements[this.heapSize] = nodo;
        
        int i = this.heapSize;

        while (i>0 && this.elements[parent(i)].getKey() < this.elements[i].getKey()) {
            scambiaNodo(this.elements[i], this.elements[parent(i)]);
            i = parent(i);
        }       
    }
    public void decreaseKey(int i, int key){
        if( key > this.elements[i].getKey())
            System.out.println("Chiave più grande della precedente");
        else{
            this.elements[i].setKey(key);
            while (i > 0 && this.elements[parent(i)].getKey() < this.elements[i].getKey()) {
                scambiaNodo(this.elements[parent(i)], this.elements[i]);
                i = parent(i);
            }
        }
    }
    public Node getNodeAt(int index){
        if (index >= this.elements.length) {
            System.out.println("non esiste un nodo con tale indice");
            return null;
        } else {
            return elements[index];
        }
    }
    public void delete(int key){
        this.elements[key] = this.elements[this.heapSize];
        this.heapSize --;
        while (key > 0 && this.elements[parent(key)].getKey() < this.elements[key].getKey()) {
            scambiaNodo(this.elements[parent(key)], this.elements[key]);
            key = parent(key);
        }
        minHeapify(key);
    }
    public Node extractMin(){
        if(this.heapSize < 0){
            System.out.println("Coda vuota");
            return null;
        }
        Node min = this.elements[0];
        this.elements[0] = this.elements[this.heapSize];
        this.heapSize --;
        minHeapify(0);
        return min;
    }
    public void destroyHeap(){
        instance = null;
    }
    private void growthStrategy(){
        Node[] newArray = new Node[this.elements.length*2];
        for (int i = 0; i < this.elements.length; i++) {
            newArray[i] = this.elements[i];
        }
        this.elements = newArray;
        this.heapSize = this.elements.length;
    }
    private void scambiaNodo(Node a, Node b){
        int inter;
        inter = a.getKey();
        a.setKey(b.getKey());
        b.setKey(inter);
    }
}