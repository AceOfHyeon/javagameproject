

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Saver {
    String pathToFile;
    
    private List<String> namecol;
    private List<String> elementcol;
    private List<String> statscol;
    private List<String> positioncol;
    private List<String> itemnamescol;
        
    private String filename;
    
    private File f;
    
    
    // constructor for making save
    public Saver(Character c) {
        namecol = new LinkedList<String>();
        elementcol = new LinkedList<String>();
        statscol = new LinkedList<String>();
        positioncol = new LinkedList<String>();
        itemnamescol = new LinkedList<String>();
        
        namecol.add(c.getCharacterName());
        elementcol.add(c.getCharacterElement());
        statscol.add(Integer.toString(c.getElementalism()));
        statscol.add(Integer.toString(c.getKnowledge()));
        positioncol.add(Integer.toString(c.getPositionX()));
        positioncol.add(Integer.toString(c.getPositionY()));
        
        TreeMap<String, Item> temp = c.getItems();
        itemnamescol.addAll(temp.keySet());
        
        List<String> t1 = makeListOfEqualLength(namecol, itemnamescol.size());
        List<String> t2 = makeListOfEqualLength(elementcol, itemnamescol.size());
        List<String> t3 = makeListOfEqualLength(statscol, itemnamescol.size());
        List<String> t4 = makeListOfEqualLength(positioncol, itemnamescol.size());
        
        namecol = t1;
        elementcol = t2;
        statscol = t3;
        positioncol = t4;
        
        filename = c.getCharacterName() + c.getCharacterElement() + ".txt"; // save file is empty?
        
    }
        
    // methods for saving
    
    public static List<String> makeListOfEqualLength(List<String> shorter, int length) {
        List<String> output = new LinkedList<String>();
        int i = 0;
        
        while (i < length) {
            if (i < shorter.size()) {
                output.add(shorter.get(i));
            } else {
                output.add("-");
            }
            i++;
        }
        
        return output;
    }
    
    public void saveToFile() {
        String filePath = "files/saves/" + filename;
        
        File file = Paths.get(filePath).toFile();
        BufferedWriter bw = null;
        
        try {

            int i = 0;
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
      
            while (i < itemnamescol.size()) {
                try {
                    String s = (namecol.get(i) + "!" + elementcol.get(i) + "!" + statscol.get(i) + 
                            "!" + positioncol.get(i) + "!" + itemnamescol.get(i) 
                            + System.lineSeparator());
                    bw.write(s);
                } catch (IOException ioe) {
                }
                i++;
            }
            bw.flush();
            
        } catch (IOException ioe) {
        }
                
    }
    
}
