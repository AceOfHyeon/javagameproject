

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FolderReader {
    
    public FolderReader() {
        
    }
    
    public ArrayList<String> getFileList() {
        File folder = new File("files/saves");
        
        File f = new File("files/saves");
        ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
        
        ArrayList<String> listOfFileNames = new ArrayList<String>();
        listOfFileNames.add("copy and paste one of the below file names.");
        
        try {
            for (File file : files) {
                if (file.exists()) {
                    listOfFileNames.add(file.getName());
                }
            }
            
            return listOfFileNames;
            
        } catch (NullPointerException npe) {
            return listOfFileNames;
        }
        
    }
    
    public String stringOfFiles() {
        int i = 0;
        String str = "";
        while (i < this.getFileList().size()) {
            str = str + this.getFileList().get(i) + System.lineSeparator();
        }
        
        return str;
    }
    
}
