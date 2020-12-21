
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Room extends JPanel {
    private String cont;
    private String rn;
    private Character chrc;
    private JPanel textframe;
    private JPanel bf;
    
    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;
    private JButton choice5;
    private JButton choice6;
    int typeno;
    
    // 6 constructors for 5 buttons ~ no button
    
    public Room(Character c, String roomname, String content) {
        rn = roomname;
        cont = content;
        chrc = c;
        textframe = new JPanel();
        bf = new JPanel();
        
        this.makeTextFrame();
        this.add(textframe, BorderLayout.NORTH);
        
        typeno = 0;
    }
    
    public Room(Character c, String roomname, String content, String button1) {
        rn = roomname;
        cont = content;
        chrc = c;
        textframe = new JPanel();
        bf = new JPanel();
        
        this.makeTextFrame();
        this.add(textframe, BorderLayout.NORTH);
        
        choice1 = new JButton(button1);
        
        typeno = 1;
        
        bf.add(choice1);
        
        this.add(bf, BorderLayout.SOUTH);
    }
    
    public Room(Character c, String roomname, String content, String button1, String button2) {
        rn = roomname;
        cont = content;
        chrc = c;
        textframe = new JPanel();
        bf = new JPanel();
        
        this.makeTextFrame();
        this.add(textframe, BorderLayout.NORTH);
        
        choice1 = new JButton(button1);
        choice2 = new JButton(button2);
        
        typeno = 2;
        
        bf.add(choice1);
        bf.add(choice2);
        
        this.add(bf, BorderLayout.SOUTH);
    }
    
    public Room(Character c, String roomname, String content, String button1, String button2,  
            String button3) {
        rn = roomname;
        cont = content;
        chrc = c;
        textframe = new JPanel();
        bf = new JPanel();
        
        this.makeTextFrame();
        this.add(textframe, BorderLayout.NORTH);
        
        choice1 = new JButton(button1);
        choice2 = new JButton(button2);
        choice3 = new JButton(button3);
        
        typeno = 3;
        
        bf.add(choice1);
        bf.add(choice2);
        bf.add(choice3);
        
        this.add(bf, BorderLayout.SOUTH);
    }
    
    public Room(Character c, String roomname, String content, String button1, String button2, 
            String button3, String button4) {
        rn = roomname;
        cont = content;
        chrc = c;
        textframe = new JPanel();
        bf = new JPanel();
        
        this.makeTextFrame();
        this.add(textframe, BorderLayout.NORTH);
        
        choice1 = new JButton(button1);
        choice2 = new JButton(button2);
        choice3 = new JButton(button3);
        choice4 = new JButton(button4);
        
        typeno = 4;
        
        bf.add(choice1);
        bf.add(choice2);
        bf.add(choice3);
        bf.add(choice4);
        
        this.add(bf, BorderLayout.SOUTH);
    }
    
    public Room(Character c, String roomname, String content, String button1, String button2, 
            String button3, String button4, String button5) {
        rn = roomname;
        cont = content;
        chrc = c;
        textframe = new JPanel();
        bf = new JPanel();
        
        this.makeTextFrame();
        this.add(textframe, BorderLayout.NORTH);
        
        choice1 = new JButton(button1);
        choice2 = new JButton(button2);
        choice3 = new JButton(button3);
        choice4 = new JButton(button4);
        choice5 = new JButton(button5);
        
        typeno = 5;
        
        bf.add(choice1);
        bf.add(choice2);
        bf.add(choice3);
        bf.add(choice4);
        bf.add(choice5);
        
        this.add(bf, BorderLayout.SOUTH);
    }
    
    
    // write method to display content in text panel, set font, background.
    
    public void makeTextFrame() {
        JTextArea tf = new JTextArea(cont);
        tf.setEditable(false);
        textframe.add(tf);
    }
    
    // write method for adding actions to buttons
    public void addActionToB1(ActionListener act) {
        choice1.addActionListener(act);
    }
    
    public void addActionToB2(ActionListener act) {
        choice2.addActionListener(act);
    }
    
    public void addActionToB3(ActionListener act) {
        choice3.addActionListener(act);
    }
    
    public void addActionToB4(ActionListener act) {
        choice4.addActionListener(act);
    }
    
    public void addActionToB5(ActionListener act) {
        choice5.addActionListener(act);
    }
    
    public void addActionToB6(ActionListener act) {
        choice6.addActionListener(act);
    }
    
    
}
