public class BinaryHeap implements IBinaryHeap{
    private Node[] elements;
    private int heapSize;

    public BinaryHeap(){
        this.elements = new Node[10];
        this.heapSize= -1; //heap vuoto
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
    public Node maximum(){
        if(this.heapSize<0)
            return null;
        else
            return this.elements[0];
    }
    public void maxHeapify(int key){
        int l=left(key);
        int r=right(key);
        int max = key;
        if(l <= this.heapSize && this.elements[l].getKey() > this.elements[i].getKey())
            max = l;
        if(r <= this.heapSize && this.elements[r].getKey() > this.elements[max].getKey())
            max = r;
        if (max != key) {
            scambiaNodo(this.elements[key], this.elements[max]);
            maxHeapify(max);
        }
    }
    public void insert(Node nodo){
        if (this.heapSize + 1 >= this.elements.length) {
            growthStrategy();
        }
        this.heapSize ++;
        this.elements[this.heapSize] = nodo;
        
        int i = this.heapSize;

        while (i>0 && this.elements[parent(i)].getKey() > this.elements[i].getKey()) {
            scambiaNodo(this.elements[i], this.elements[parent(i)]);
            i = parent(i);
        }       
    }
    public void decreaseKey(int i, int key){
        if( key > this.elements[i].getKey())
            System.out.println("Chiave più grande della precedente");
        else{
            this.elements[i].setKey(key);
            while (i > 0 && this.elements[parent(i)].getKey() > this.elements[i].getKey()) {
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
        while (key > 0 && this.elements[parent(key)].getKey() > this.elements[key].getKey()) {
            scambiaNodo(this.elements[parent(key)], this.elements[key]);
            key = parent(key);
        }
        maxHeapify(key);
    }
    public Node extractMax(){
        if(this.heapSize < 0){
            System.out.println("Coda vuota");
            return null;
        }
        Node max = this.elements[0];
        this.elements[0] = this.elements[this.heapSize];
        this.heapSize --;
        maxHeapify(0);
        return max;
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