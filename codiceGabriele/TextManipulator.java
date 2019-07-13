import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class TextManipulator {

    public TextManipulator(){
        FileInputStream in = new FileInputStream(getFileFullPath());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private String getFileFullPath() {
        String fileName = this.getClass().getResource("testo.txt").toString();
        System.out.println
        if (fileName.contains("//"))
            fileName = fileName.substring("file:/".length()); //Windows version
        else if (fileName.contains("/"))
            fileName = fileName.substring("file:".length()); //Linux version
        
        fileName = fileName.replaceAll("%20", " ");
        return fileName;
    }
}