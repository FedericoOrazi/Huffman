import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class TextManipulator {

    public TextManipulator(){
        System.out.println(getFileFullPath());
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