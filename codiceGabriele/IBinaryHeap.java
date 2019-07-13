package Huffman;

public interface IBinaryHeap {

    public int parent(int index);
    public int left(int index);
    public int right(int index);
    public Node maximum();
    public void maxHeapify(int key);
    public void insert(Node nodo);
    public void decreaseKey(int i, int key);
    public Node getNodeAt(int index);
    public void delete(int key);
    public Node extractMax();
}