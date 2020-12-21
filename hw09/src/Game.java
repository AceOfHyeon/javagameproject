

/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
    
    public static void itemHelper(ItemImage i, Character c) {
        i.updateInventory(c);
        
        Iterator<String> iter = c.getItems().navigableKeySet().iterator();
        
        while (iter.hasNext()) {
            i.changeIcon(c.getSingleItem((iter.next())).getImageLink());
        }
    }
    
    public void run() {
        // NOTE : recall that the 'final' keyword notes immutability even for local variables.

        // Top-level frame in which game components live
        // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame("VAST TIMES");
        frame.setLocation(300, 300);
        
        final JPanel visuals = new JPanel();
        
        final JPanel controls = new JPanel();
                
        final JPanel characterprofile = new JPanel();
        
        LayoutManager cplayout = new BoxLayout(characterprofile, BoxLayout.Y_AXIS);
        characterprofile.setLayout(cplayout);
        
        // Save and load button panel
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);
                
        Container con;
        con = frame.getContentPane();
                
        // Create needed objects: Character, initialize map, storage s
        Character mc = new Character();
        VastMap map = new VastMap();
        Storage s = new Storage(map);
        Compass compass = new Compass(mc);
        compass.setVisible(true);
        
        StatShower statbox = new StatShower(mc);
        
        BoxLayout bl = new BoxLayout(visuals, BoxLayout.Y_AXIS);
        visuals.setLayout(bl);
        visuals.add(compass);
        
        JOptionPane.showMessageDialog(frame, s.instructions(),
                "Game Instructions", JOptionPane.PLAIN_MESSAGE);

        
        // list images and create image-holding panels
        
        final String srpath = "files/storyscenes/sr.png";
        final String idlepath = "files/storyscenes/idle.png";
        final String r1path = "files/storyscenes/r1.png";
        final String r2path = "files/storyscenes/r2.png";
        final String r3path = "files/storyscenes/r3.png";
        final String r4path = "files/storyscenes/r4.png";
        final String r5path = "files/storyscenes/r5.png";
        final String fr1path = "files/storyscenes/fr1.png";
        final String fr2v1path = "files/storyscenes/fr2v1.png";
        final String fr2v2path = "files/storyscenes/fr2v2.png";
        final String e1path = "files/storyscenes/ending1.png";
        final String e2path = "files/storyscenes/ending2.png";
        final String e3path = "files/storyscenes/ending3.png";
        
        
        ImageInterface si = new SceneImage(srpath, "test");
        CharacterImage cpi = new CharacterImage(mc);
        ItemImage ii = new ItemImage(mc);
        
        
        // Make
        Room startroom1, startroom2, startroom3;
        Room idleroom;
        Room r1;
        Room r2;
        Room r3;
        Room r4;
        Room r5;
        Room finalroom1;
        Room finalroom2v1;
        Room finalroom2v2;
        Room finalroom3v1;
        Room finalroom3v2;
        Room finalroom3v3;
        
        // create rooms in order
        
        startroom1 = new Room(mc, "sroom1", s.getSTR1(), "Shadow", "Light", "Air", "Water", "Fire");
        startroom2 = new Room(mc, "sroom2", s.getSTR2());
        startroom3 = new Room(mc, "sroom3", s.getSTR3(), "Move on");
        idleroom = new Room(mc, "idleroom", s.getIDLE());
        r1 = new Room(mc, "room1", s.getR1(), "Move on");
        r2 = new Room(mc, "room2", s.getR2(), "Move on");
        r3 = new Room(mc, "room3", s.getR3(), "Move on");
        r4 = new Room(mc, "room4", s.getR4(), "Leave");
        r5 = new Room(mc, "room5", s.getR5(), "Leave");
        finalroom1 = new Room(mc, "finalroom1", s.getFR1(), "Enter", "Come back later");
        finalroom2v1 = new Room(mc, "fr2v1", s.getFR2v1(), "You feel sorrow.");
        finalroom2v2 = new Room(mc, "fr2v2", s.getFR2v2(), "You feel at peace.");
        finalroom3v1 = new Room(mc, "fr3v1", s.getFR3v1(), "The forest mourns. You move on.");
        finalroom3v2 = new Room(mc, "fr3v2", s.getFR3v2(), "The coffin opens.");
        finalroom3v3 = new Room(mc, "fr3v3", s.getFR3v3(), "You return to the forest.");
        
        JTextField namejtf = new JTextField(20);
        JButton entername = new JButton("Enter Name");
        startroom2.add(namejtf, BorderLayout.PAGE_END);
        startroom2.add(entername, BorderLayout.PAGE_END);
        
        // create actionlistener for button, apply it to Room
        startroom1.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.changeElement("Shadow");
                cpi.changeIcon("Shadow");
                con.add(startroom2);
                startroom2.setVisible(true);
                startroom1.setVisible(false);
                frame.revalidate();
                frame.repaint(); // need both? idk
                con.revalidate();
                con.repaint();
            }
        });
        
        startroom1.addActionToB2(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.changeElement("Light");
                cpi.changeIcon("Light");
                con.add(startroom2);
                startroom2.setVisible(true);
                startroom1.setVisible(false);
                frame.revalidate();
                frame.repaint(); // need both? idk
                con.revalidate();
                con.repaint();
            }
        });
        
        startroom1.addActionToB3(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.changeElement("Air");
                cpi.changeIcon("Air");
                
                con.add(startroom2);
                startroom2.setVisible(true);
                startroom1.setVisible(false);
                con.revalidate();
                con.repaint();
            }
        });
        
        startroom1.addActionToB4(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.changeElement("Water");
                cpi.changeIcon("Water");

                con.add(startroom2);
                startroom2.setVisible(true);
                startroom1.setVisible(false);
                con.revalidate();
                con.repaint();
            }
        });
        
        startroom1.addActionToB5(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.changeElement("Fire");
                cpi.changeIcon("Fire");

                con.add(startroom2);
                startroom2.setVisible(true);
                startroom1.setVisible(false);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        entername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.changeName(namejtf.getText());
                con.add(startroom3);
                startroom2.setVisible(false);
                startroom3.setVisible(true);
//                test.changeIcon(testpath2); // works!!
                
                frame.revalidate();
                frame.repaint();
            }
        });
        
        startroom3.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.changeName(namejtf.getText());
                con.add(idleroom);
                si.changeIcon(idlepath);
                startroom3.setVisible(false);
                idleroom.setVisible(true);
                controls.setVisible(true);
                control_panel.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        r1.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                con.remove(r1);
                r1.setVisible(false);
                si.changeIcon(idlepath);
                idleroom.setVisible(true);
                controls.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        r2.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(r2);
                r2.setVisible(false);
                si.changeIcon(idlepath);
                idleroom.setVisible(true);
                controls.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        r3.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(r3);
                r3.setVisible(false);
                si.changeIcon(idlepath);
                idleroom.setVisible(true);
                controls.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        r4.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(r4);
                r4.setVisible(false);
                si.changeIcon(idlepath);
                idleroom.setVisible(true);
                controls.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        r5.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(r5);
                r5.setVisible(false);
                si.changeIcon(idlepath);
                idleroom.setVisible(true);
                controls.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        finalroom1.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(finalroom1);
                finalroom1.setVisible(false);
                control_panel.setVisible(false);
                if ((mc.getElementalism() + mc.getKnowledge()) > 27) {
                    con.add(finalroom2v1);
                    si.changeIcon(fr2v1path);
                    finalroom2v1.setVisible(true);
                } else {
                    con.add(finalroom2v2);
                    si.changeIcon(fr2v2path);
                    finalroom2v2.setVisible(true);
                }
                frame.revalidate();
                frame.repaint();
            }
        });
        
        finalroom1.addActionToB2(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(finalroom1);
                finalroom1.setVisible(false);
                si.changeIcon(idlepath);
                idleroom.setVisible(true);
                controls.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        finalroom2v1.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(finalroom2v1);
                finalroom2v1.setVisible(false);
                
                if (mc.getItems().size() > 4) {
                    con.add(finalroom3v3);
                    finalroom3v3.setVisible(true);
                    si.changeIcon(e3path);
                } else if ((5 > mc.getItems().size()) && (mc.getItems().size() > 2)) {
                    con.add(finalroom3v2);
                    si.changeIcon(e2path);
                    finalroom3v2.setVisible(true);
                } else {
                    con.add(finalroom3v1);
                    si.changeIcon(e1path);
                    finalroom3v1.setVisible(true);
                }
                frame.revalidate();
                frame.repaint();
            }
        });
        
        finalroom2v2.addActionToB1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(finalroom2v2);
                finalroom2v2.setVisible(false);
                if (mc.getItems().size() > 4) {
                    con.add(finalroom3v3);
                    finalroom3v3.setVisible(true);
                    si.changeIcon(e3path);
                } else if ((5 > mc.getItems().size()) && (mc.getItems().size() > 2)) {
                    con.add(finalroom3v2);
                    si.changeIcon(e2path);
                    finalroom3v2.setVisible(true);
                } else {
                    con.add(finalroom3v1);
                    si.changeIcon(e1path);
                    finalroom3v1.setVisible(true);
                }
                frame.revalidate();
                frame.repaint();
            }
        });
        
        Room endmessage = new Room(mc, "ending",
                "This is the end of the game. To play again, please exit and restart.");
        
        finalroom3v1.addActionToB1(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                con.add(endmessage);
                con.remove(finalroom3v1);
                endmessage.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        finalroom3v2.addActionToB1(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                con.add(endmessage);
                con.remove(finalroom3v2);
                endmessage.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        finalroom3v3.addActionToB1(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                con.add(endmessage);
                con.remove(finalroom3v3);
                endmessage.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        
        /* Create needed panels and buttons (West : Visuals, South: Controls (movement buttons),
        Central: Story, East: Character profile*/
        // buttons: West, North, South, East & Save, Load
        
        frame.add(visuals, BorderLayout.WEST);
        con.add(controls, BorderLayout.SOUTH);
        con.add(startroom1, BorderLayout.CENTER);
        frame.add(characterprofile, BorderLayout.EAST);
        
        final JButton west = new JButton("West");
        final JButton east = new JButton("East");
        final JButton north = new JButton("North");
        final JButton south = new JButton("South");
        
        west.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.moveW();
                
                if ((mc.getPositionX() == 1) && (mc.getPositionY() == 1)
                        && map.containsItem(s.getFF())) { // location
                    con.add(r1);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r1.setVisible(true);
                    si.changeIcon(r1path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 4) && (mc.getPositionY() == 2)
                        && map.containsItem(s.getBM())) { // location
                    con.add(r2);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r2.setVisible(true);
                    si.changeIcon(r2path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 1) && (mc.getPositionY() == 3)
                        && map.containsItem(s.getRB())) { // location
                    con.add(r3);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r3.setVisible(true);
                    si.changeIcon(r3path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 3) && (mc.getPositionY() == 0)) { // location
                    con.add(r4);
                    mc.addElementalism(2);
                    r4.setVisible(true);
                    si.changeIcon(r4path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 0) && (mc.getPositionY() == 4)) { // location
                    con.add(r5);
                    mc.addKnowledge(2);
                    r5.setVisible(true);
                    si.changeIcon(r5path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 4) && (mc.getPositionY() == 4)) { // location
                    con.add(finalroom1);
                    finalroom1.setVisible(true);
                    si.changeIcon(fr1path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                compass.updateDirection();
                
                // repeat if for all 6 locations.. haha...
                
                frame.revalidate();
                frame.repaint();
            }
        });
        
        east.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.moveE();
                
                if ((mc.getPositionX() == 1) && (mc.getPositionY() == 1)
                        && map.containsItem(s.getFF())) { // location
                    con.add(r1);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r1.setVisible(true);
                    si.changeIcon(r1path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 4) && (mc.getPositionY() == 2)
                        && map.containsItem(s.getBM())) { // location
                    con.add(r2);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r2.setVisible(true);
                    si.changeIcon(r2path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 1) && (mc.getPositionY() == 3)
                        && map.containsItem(s.getRB())) { // location
                    con.add(r3);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r3.setVisible(true);
                    si.changeIcon(r3path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 3) && (mc.getPositionY() == 0)) { // location
                    con.add(r4);
                    mc.addElementalism(2);
                    r4.setVisible(true);
                    si.changeIcon(r4path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 0) && (mc.getPositionY() == 4)) { // location
                    con.add(r5);
                    mc.addKnowledge(2);
                    r5.setVisible(true);
                    si.changeIcon(r5path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 4) && (mc.getPositionY() == 4)) { // location
                    con.add(finalroom1);
                    finalroom1.setVisible(true);
                    si.changeIcon(fr1path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                compass.updateDirection();

                // repeat if for all 6 locations.. haha...
                
                frame.revalidate();
                frame.repaint();
            }
        });
        
        north.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.moveN();
                
                if ((mc.getPositionX() == 1) && (mc.getPositionY() == 1)
                        && map.containsItem(s.getFF())) { // location
                    con.add(r1);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r1.setVisible(true);
                    si.changeIcon(r1path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 4) && (mc.getPositionY() == 2)
                        && map.containsItem(s.getBM())) { // location
                    con.add(r2);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r2.setVisible(true);
                    si.changeIcon(r2path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 1) && (mc.getPositionY() == 3)
                        && map.containsItem(s.getRB())) { // location
                    con.add(r3);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r3.setVisible(true);
                    si.changeIcon(r3path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 3) && (mc.getPositionY() == 0)) { // location
                    con.add(r4);
                    mc.addElementalism(2);
                    r4.setVisible(true);
                    si.changeIcon(r4path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 0) && (mc.getPositionY() == 4)) { // location
                    con.add(r5);
                    mc.addKnowledge(2);
                    r5.setVisible(true);
                    si.changeIcon(r5path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 4) && (mc.getPositionY() == 4)) { // location
                    con.add(finalroom1);
                    finalroom1.setVisible(true);
                    si.changeIcon(fr1path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                compass.updateDirection();

                // repeat if for all 6 locations.. haha...
                
                frame.revalidate();
                frame.repaint();
            }
        });
        
        south.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mc.moveS();
                
                if ((mc.getPositionX() == 1) && (mc.getPositionY() == 1)
                        && map.containsItem(s.getFF())) { // location
                    con.add(r1);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r1.setVisible(true);
                    si.changeIcon(r1path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 4) && (mc.getPositionY() == 2)
                        && map.containsItem(s.getBM())) { // location
                    con.add(r2);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r2.setVisible(true);
                    si.changeIcon(r2path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 1) && (mc.getPositionY() == 3)
                        && map.containsItem(s.getRB())) { // location
                    con.add(r3);
                    map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
                    r3.setVisible(true);
                    si.changeIcon(r3path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 3) && (mc.getPositionY() == 0)) { // location
                    con.add(r4);
                    mc.addElementalism(2);
                    r4.setVisible(true);
                    si.changeIcon(r4path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 0) && (mc.getPositionY() == 4)) { // location
                    con.add(r5);
                    mc.addKnowledge(2);
                    r5.setVisible(true);
                    si.changeIcon(r5path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                if ((mc.getPositionX() == 4) && (mc.getPositionY() == 4)) { // location
                    con.add(finalroom1);
                    finalroom1.setVisible(true);
                    si.changeIcon(fr1path);
                    itemHelper(ii, mc);
                    statbox.updateStats();
                    
                    controls.setVisible(false);
                    idleroom.setVisible(false);
                }
                
                compass.updateDirection();

                // repeat if for all 6 locations.. haha...
                
                frame.revalidate();
                frame.repaint();
            }
        });
        
        controls.add(west, 0);
        controls.add(north, 1);
        controls.add(south, 2);
        controls.add(east, 3);
        
        controls.setVisible(false);
        

        // Note here that when we add an action listener to the button, we define it as an
        // anonymous inner class that is an instance of ActionListener with its actionPerformed()
        // method overridden. When the button is pressed, actionPerformed() will be called.
        final JButton save = new JButton("SAVE");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Saver s = new Saver(mc);
                s.saveToFile();
            }
        });
        control_panel.add(save, BorderLayout.WEST);
        
        // create file viewing frame to open upon clicking load
        JFrame fileviewer = new JFrame();
        JPanel filelist = new JPanel();
        JTextField textbox = new JTextField(35);
        JButton loadfile = new JButton("Load this file");
        
        loadfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final String inputfilepath = textbox.getText();
                mc.loadSaveFile(map, "files/saves/" + inputfilepath);
                compass.updateDirection();
                cpi.changeIcon("Placeholder");
                itemHelper(ii, mc);
                statbox.updateStats();
                
                frame.revalidate();
                frame.repaint();
            }
        });

        
        File f = new File("files/saves");
        ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
        
        String listOfFileNames = "copy and paste one of the below file names." 
            + System.lineSeparator() + "!! warning !! load only files ending in .txt."
            + System.lineSeparator() + "-----" + System.lineSeparator();
        
        for (File file : files) {
            if (file.exists()) {
                listOfFileNames = listOfFileNames + file.getName() + System.lineSeparator();
            }
        }
            
        
        JTextArea filesdisplay = new JTextArea();
        filesdisplay.setText(listOfFileNames);

        filelist.add(filesdisplay, BorderLayout.SOUTH);
        
        filelist.add(textbox, BorderLayout.NORTH);
        filelist.add(loadfile, BorderLayout.CENTER);
        
        fileviewer.add(filelist);
        
        fileviewer.pack();
        fileviewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        // actual load button
        final JButton load = new JButton("LOAD");
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileviewer.setVisible(true);
            }
        });
        
        control_panel.add(load, BorderLayout.EAST);
        control_panel.setVisible(false);
        
        // Add visuals!!
        visuals.add((Component) si);
        
        characterprofile.add(cpi);
        characterprofile.add(statbox);
        characterprofile.add(ii);
        
        
        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}