package Huffman;

public interface IBinaryHeap {

    public int parent(int index);
    public int left(int index);
    public int right(int index);
    public Node minimum();
    public void minHeapify(int key);
    public void insert(Node nodo);
    public void decreaseKey(int i, int key);
    public void delete(int key);
    public Node extractMin();
    public void destroyHeap();
}