import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) 
    { 
  
        return x.freq - y.freq; 
    } 
    
    
    // recursive function to print the 
    // huffman-code through the tree traversal. 
    // Here s is the huffman - code generated. 
    public static void printCode(HuffmanNode root, String s) 
    { 
        if (root.left == null && root.right == null && Character.isLetter(root.c)) { 
            System.out.println(root.c + ":" + s); 
            return; 
        } 
  
        printCode(root.left, s + "0"); 
        printCode(root.right, s + "1"); 
    } 

public static void main(String[] args) 
{ 

    Scanner s = new Scanner(System.in); 

    // number of characters. 
    int n = 6; 
    char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
    int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 

    // creating a priority queue q. 
    // makes a min-priority queue(min-heap). 
    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator()); 

    for (int i = 0; i < n; i++) { 

        // creating a Huffman node object 
        // and add it to the priority queue. 
        HuffmanNode hn = new HuffmanNode(); 

        hn.c = charArray[i]; 
        hn.freq = charfreq[i]; 

        hn.left = null; 
        hn.right = null; 

        // add functions adds 
        // the huffman node to the queue. 
        q.add(hn); 
    } 

    // create a root node 
    HuffmanNode root = null; 

    // Here we will extract the two minimum value 
    // from the heap each time until 
    // its size reduces to 1, extract until 
    // all the nodes are extracted. 
    while (q.size() > 1) { 

        // first min extract. 
        HuffmanNode x = q.peek(); 
        q.poll(); 

        // second min extarct. 
        HuffmanNode y = q.peek(); 
        q.poll(); 

        // new node f which is equal 
        HuffmanNode f = new HuffmanNode(); 

        // to the sum of the frequency of the two nodes 
        // assigning values to the f node. 
        f.freq = x.freq + y.freq; 
        f.c = '-'; 

        // first extracted node as left child. 
        f.left = x; 

        // second extracted node as the right child. 
        f.right = y; 

        // marking the f node as the root node. 
        root = f; 

        // add this node to the priority-queue. 
        q.add(f); 
    } 

    // print the codes by traversing the tree 
    printCode(root, ""); 
} 
} 
