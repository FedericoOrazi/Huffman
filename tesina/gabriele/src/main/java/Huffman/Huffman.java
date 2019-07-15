package Huffman;

public class Huffman {
    private String[] huffman = new String[65536];
    private static Huffman instance = null;
    private Node root;

    private Huffman(){

    }
    public static Huffman getInstance(){
        if(instance == null)instance = new Huffman();
        return instance;
    }
    public Node makeHuffmanTree(int[] frequenze){
        BinaryHeap.getInstance(); //crea un heap binario vuoto
        int n = 0;
        for (int i = 0; i < frequenze.length; i++) {
            if (frequenze[i] != 0) {
                Node x = new Node();
                x.setChar((char)i);
                x.setKey(frequenze[i]);
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
        
        
        this.root = BinaryHeap.getInstance().extractMin();
        return this.root;
    }
    public void visitHuffmanTree(Node root){
        if(root == null) return ; 
        visit(root,"");
    }  
    private void visit(Node x, String h){
        if(x.left() == null && x.right() == null){
            System.out.print(x.getChar());
            System.out.print("-->");
            System.out.println(h);
            huffman[(int)x.getChar()] = h;
        }
        if (x.left() != null) {
            visit(x.left(), h + "0");
        }
        if(x.right() != null) {
            visit(x.right(), h + "1"); 
        }
    }
    public long compressedSize(int[] x){
        long sum = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0) {
                int lunghezza = huffman[i].length();
                int frequenza = x[i];
                sum = sum + lunghezza * frequenza;
            }
        }
        return sum;
    }
    public void compressCode(String str){
        String newString = "";
        long start = System.currentTimeMillis();
        System.out.println("attendere per scrittura del testo");
        for (int i = 0; i < str.length(); i++) {
            newString += huffman[(int)str.charAt(i)];
        }
        long end = System.currentTimeMillis();
        TextManipulator.getInstance().writeText(newString);
        System.out.println("testo scritto");
        System.out.println(end-start + "--> tempo impiegato a tradurre da testo originale a Huffman");
    }
    public String translate(String str){
        long start = System.currentTimeMillis();
        String ret = "";
        Node x = this.root;
        for (int i = 0; i < str.length(); i++) {
            if(x.left()==null && x.right()==null){
                ret = ret + x.getChar();
                x = this.root;
            }
            if(x.left()!=null && str.charAt(i)=='0'){
                x = x.left();
            }
            if(x.right()!=null && str.charAt(i)=='1'){
                x = x.right();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + "-->tempo a tradurre da Huffman a Testo originale");
        return ret;
    }
}