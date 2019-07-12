public class BinaryHeap {
    private Node[] elements;
    private int heapSize;

    public BinaryHeap(){
        this.elements = new Node[10];
        this.heapSize=0;
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
    public int search(int key){
        return null;
    }
    public void insert(Node nodo){
        if (this.heapSize + 1 >= this.elements.length) {
            growthStrategy();
        }
        this.heapSize ++;
        this.elements[this.heapSize] = nodo; 
        int i = this.heapSize;
        while (i>1 && elements[parent(i)].getKey() > elements[i].getKey()) {
            Nodo inter = new Nodo();
            inter = elements[i];
            elements[i] = elements[parent(i)];
            elements[parent(i)]= inter;
            i = parent(i);
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
    
    public boolean delete()
    private void growthStrategy(){
        Node[] newArray = new Node[this.elements.length*2];
        for (int i = 0; i < this.elements.length; i++) {
            newArray[i] = this.elements[i];
        }
        this.elements = newArray;
        this.heapSize = this.elements.length;
    }
}