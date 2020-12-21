

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Loader {
    private String pathToFile;
    
    
    // constructor for reading save
    public Loader(String path) {
        pathToFile = path;
    }
        // methods for loading
    
    static String extractColumn(String txtLine, int txtColumn) {

        String[] temp;
        
        temp = txtLine.split("!");
        
        if (temp[txtColumn] == null) {
            return null;
        }
        
        return temp[txtColumn];
        
    }
     
    static List<String> txtFileToColString(String pathToTxtFile, int columnWanted) {
        
        
        File f = new File(pathToTxtFile);
        
        FileLineIterator a = new FileLineIterator(pathToTxtFile);
        
        ArrayList<String> lines = a.getLines();
        
        int linetotal;
        if (! lines.isEmpty()) {
            linetotal = lines.size();
        } else {
            linetotal = 0;
        }
        
        
        List<String> col = new LinkedList<String>();
        
        int i = 0;
        
        while (i < linetotal) {
            col.add(extractColumn(lines.get(i), columnWanted).replace(
                    System.lineSeparator(), ""));
            i++;
        }
        
        return col;
    }
    
    
    static List<Integer> turnStringListToIntList(List<String> orig) {
        List<Integer> ints = new LinkedList<Integer>();
        
        if (orig.isEmpty()) {
            return null;
        }
        
        int i = 0;
        
        while (i < 2) {
            ints.add(Integer.parseInt(orig.get(i).trim()));
            i++;
        }
        
        return ints;
        
    }
    
    
    public String readCharacterName() {
//        if (txtFileToColString(pathToFile, 0).isEmpty()) {
//              return null;
//        }
        List<String> t = txtFileToColString(pathToFile, 0);
        String name = t.get(0);
        return name;
    }
    
    public String readCharacterElement() {
//        if (txtFileToColString(pathToFile, 1).isEmpty()) {
//            return null;
//        }
        
        List<String> t = txtFileToColString(pathToFile, 1);
        String element = t.get(0);
        return element;
    }
    
    public List<Integer> readCharacterStats() {
//        if (txtFileToColString(pathToFile, 2).isEmpty()) {
//            return null;
//        }
        List<String> t = txtFileToColString(pathToFile, 2);
        List<Integer> tt = turnStringListToIntList(t);
        List<Integer> fin = new LinkedList<Integer>();
        fin.add(tt.get(0)); // read Elementalism stat
        fin.add(tt.get(1)); // read Knowledge Stat
        return fin;
    }
    
    public List<Integer> readCharacterPosition() {
//        if (txtFileToColString(pathToFile, 3).isEmpty()) {
//            return null;
//        }
        
        List<String> t = txtFileToColString(pathToFile, 3);
        List<Integer> tt = turnStringListToIntList(t);
        List<Integer> fin = new LinkedList<Integer>();
        fin.add(tt.get(0)); // read positionX
        fin.add(tt.get(1)); // read positionY
        return fin;
    }
    
    public List<String> readCharacterItems() {
//        if (txtFileToColString(pathToFile, 4).isEmpty()) {
//            return null;
//        }
        
        List<String> t = txtFileToColString(pathToFile, 4);
        return t;
    }
    
}
