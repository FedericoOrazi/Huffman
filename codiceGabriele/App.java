package Huffman;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        //System.out.println(TextManipulator.getInstance().readText());
        int[] x = TextManipulator.getInstance().frequenzaLettereTesto();
        for (int i = 0; i < x.length ; i++) {
            if(x[i] != 0){
                System.out.print((char)i);
                System.out.print(" -->");
                System.out.println(x[i]);
            }
        }
    }
}
