package Huffman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class TextManipulator {
    private static TextManipulator instance = null;
    private int numberOfChar;
    private long textOriginalSize;
    private String text;

    private TextManipulator() {
        this.text = "";
        this.numberOfChar = 0;
        this.textOriginalSize = 0;
    }
    public static TextManipulator getInstance(){
        if(instance == null)instance = new TextManipulator();
        return instance;
    }
    
    public int[] frequenzaLettereTesto(){
        int[] x = new int[65536];
        for (int i = 0; i < 65536; i++) {
            x[i]=0;
        }
        TextManipulator.getInstance().readText();
        String str = TextManipulator.getInstance().getText();
        for (int i = 0; i < str.length(); i++) {
            x[(int)str.charAt(i)]++;
        }
        return x;
    }
    
    public String getText(){
        return this.text;
    }
    public int textLength(){
        return this.numberOfChar;
    }
    public long originalSize(){
        this.textOriginalSize = this.numberOfChar * 16; //numero di bit totale
        return this.textOriginalSize;
    }
    
    private String getFileFullPath(String name) {
        String fileName = this.getClass().getResource(name).toString();
        if (fileName.contains("//"))
            fileName = fileName.substring("file:/".length()); //Windows version
        else if (fileName.contains("/"))
            fileName = fileName.substring("file:".length()); //Linux version
        
        fileName = fileName.replaceAll("%20", " ");
        return fileName;
    }
    public void readText(){
        try {
            FileInputStream in = new FileInputStream(getFileFullPath("testo.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            br.close();
            this.numberOfChar = sb.toString().length();
            this.text =  sb.toString();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public String readTextCompressed(){
        try {
            FileInputStream in = new FileInputStream(getFileFullPath("").substring(0, getFileFullPath("").length()-32)+"testoCodificato.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            
        }
        return null;
    }
    public void writeText(String str){
        try {
            FileWriter w = new FileWriter("testoCodificato.txt");
            //FileWriter wr = new FileWriter("testoCodificato.txt");
            //BufferedWriter b = new BufferedWriter(wr);
            //b.write(str);
            w.write(str);
            //b.flush();
            w.close();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}