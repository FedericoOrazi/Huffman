package Huffman;

public abstract class Huffman {
    
    public static Node makeHuffmanHeap(int[] caratteri){
        BinaryHeap.getInstance(); //crea un heap binario vuoto
        int n = 0;
        for (int i = 0; i < caratteri.length; i++) {
            if (caratteri[i] != 0 && i != 10) {
                Node x = new Node();
                x.setChar((char)i);
                x.setKey(caratteri[i]);
                BinaryHeap.getInstance().insert(x);
                n++;
            }
        }
        for (int i = 1; i < n; i++) {
            Node z = new Node();
            Node x = BinaryHeap.getInstance().extractMin();
            Node y = BinaryHeap.getInstance().extractMin();
            z.setLeft(x);
            z.setRight(y);
            z.setKey(x.getKey() + y.getKey());
            BinaryHeap.getInstance().insert(z);
        }
        
        
        return BinaryHeap.getInstance().extractMin();
    }

    public static void printHuffmanCode(Node root){
        print(root,"");
    }
    private static void print(Node x, String h){
        if(x.left() == null && x.right() == null){
            System.out.print(x.getChar());
            System.out.print("-->");
            System.out.println(h);
        }
        if (x.left() != null) {
            print(x.left(), h + "0");
        }
        if(x.right() != null) {
            print(x.right(), h + "1"); 
        }
    }
}