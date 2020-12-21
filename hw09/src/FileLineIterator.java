
import java.util.stream.Stream;
import java.util.*;
import java.io.*;

public class FileLineIterator {

    private BufferedReader file;
    private Stream<String> linelist;
    private Object[] ll;

    public FileLineIterator(String filePath) {
        File f = new File(filePath);
        
        try {
            file =  new BufferedReader(new FileReader(f));
            linelist = file.lines();
            ll = linelist.toArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getLines() {
        int i = 0;
        ArrayList<String> temp = new ArrayList<String>();
        
        if (linelist == null) {
            return null;
        }
        
        while (i < ll.length) {
            temp.add((String) ll[i]);
            i++;
        }
        
        return temp;
    }
    
}
