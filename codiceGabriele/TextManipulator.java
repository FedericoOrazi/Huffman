package Huffman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class TextManipulator {
    private static TextManipulator instance = null;

    private TextManipulator() {
        
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
        String str = TextManipulator.getInstance().readText();
        for (int i = 0; i < str.length(); i++) {
            x[(int)str.charAt(i)]++;
        }
        return x;
    }
    public String readText(){
        try {
            FileInputStream in = new FileInputStream(getFileFullPath());
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
            //TODO: handle exception
        }
        return null;
    }

    private String getFileFullPath() {
        String fileName = this.getClass().getResource("testo.txt").toString();
        if (fileName.contains("//"))
            fileName = fileName.substring("file:/".length()); //Windows version
        else if (fileName.contains("/"))
            fileName = fileName.substring("file:".length()); //Linux version
        
        fileName = fileName.replaceAll("%20", " ");
        return fileName;
    }
    
}