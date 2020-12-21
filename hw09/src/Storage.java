

public class Storage {
    private String str1; // choose element
    private String str2; // input name
    private String str3; // start journey
    private String idle; // when character is at non-item spot
    private String r1; // Forest Flute
    private String r2; // Broken Mask
    private String r3; // Rust Blade
    private String r4; // stat gain
    private String r5; // stat gain
    private String fr1; // Asks will you enter final cave?
    private String fr2v1; // Stat sum > 20
    private String fr2v2; // Else
    private String fr3v1; // normal ending
    private String fr3v2; // good ending (collected 1+ items)
    private String fr3v3; // true ending (collected 3 items)
    
    private String instr;
    
    private Item ff;
    private Item bm;
    private Item rb;
    
    public Storage(VastMap m) {
        
        // make items and store it to given map
        ff = new Item("Forest Flute", "This flute holds the melody of the forest sprites.", 
                "files/icon/forestflute.png");
        bm = new Item("Broken Mask", "Once, a young hero used this mask for his safety.",
                "files/icon/brokenmask.png");
        rb = new Item("Rust Blade", "A long blade that has an unknown script engraved along it.",
                "files/icon/rustblade.png");
        
        m.addItemToList(ff, 1, 1);
        m.addItemToList(bm, 4, 2);
        m.addItemToList(rb, 1, 3);
        
        // strings used for story
        str1 = "You wake up." 
                + System.lineSeparator() + 
                "Looking around, you see yourself surrounded by wooden walls."
                + System.lineSeparator() + "Light filters in through a small crack in front of you."
                + System.lineSeparator() + "You reach out..."
                + System.lineSeparator() + "You have stepped out of a great oak tree."
                + System.lineSeparator() + "Which elemental are you?";
        str2 = "The chosen element resonates within yourself." 
                + System.lineSeparator() + 
                "As you look around, you notice that you have an odd, round gem and a small pouch."
                + System.lineSeparator() + "No matter what you do, you cannot open it."
                + System.lineSeparator() + "You peer into the forest, and decide to start walking."
                + System.lineSeparator() + "What is your name?";
        str3 = "Are you sure?"
                + System.lineSeparator() + 
                "You reach back into your memory, but you can't recall anything else."
                + System.lineSeparator() + "Who knows?"
                + System.lineSeparator() + "Maybe you can find answers in this forest..."
                + System.lineSeparator() + "You enter the shadows.";
        
        idle = "The forest stretches around you."
                + System.lineSeparator() + "You must keep walking."
                + System.lineSeparator() + "Far away, you hear the hum of water.";
        
        r1 = "You have discovered a small, sad looking toad."
             + System.lineSeparator() + "The toad looks up at you and croaks."
             + System.lineSeparator() + "When you reach out to touch it, it trills and jumps away."
             + System.lineSeparator() + "It leaves behind a beautiful bamboo flute.";
        
        r2 = "Behind a tall pine split in half by lightning, you see a scarlet tassel."
             + System.lineSeparator() + "You squint at it."
             + System.lineSeparator() + 
             "A strong gust blows through the forest, and the object falls with a clutter."
             + System.lineSeparator() + "It is an antique mask, broken away at a corner.";
        
        r3 = "You see a grave."
             + System.lineSeparator() + "It is overgrown with weeds, and its dirt is upturned."
             + System.lineSeparator() + 
             "Sweeping the dirt back into place, you find that the grave is missing a coffin."
             + System.lineSeparator() + "A sad ending for a man."
             + System.lineSeparator() + 
             "You take the rusted sword that lies embedded within the headstone.";
        
        r4 = "You have come upon a clear, bubbling spring. May this be a landmark?"
             + System.lineSeparator() + "You feel more in tune with your surroundings."
             + System.lineSeparator() + System.lineSeparator()
             + "(Elementalism has increased)";
        
        r5 = "The remnants of a once great library looms ahead."
             + System.lineSeparator() + 
             "After spending some time there, you feel a sense of someone watching you."
             + System.lineSeparator() + "You leave. Maybe you can come back later."
             + System.lineSeparator() + System.lineSeparator()
             + "(Knowledge has increased)";
        
        fr1 = "The Elemental Eye in your pocket quiets."
              + System.lineSeparator() + "You have reached your destination."
              + System.lineSeparator() + "Are you sure you wish to enter the Falls?"
              + System.lineSeparator() + 
              "Once you enter you will no longer be able to look for items or locations.";
        
        fr2v1 = "At first, the cave seems normal. Then, as you continue inside..."
                + System.lineSeparator() + "You slowly start to realize that it is a tomb."
                + System.lineSeparator() + "Dozens... no...."
                + System.lineSeparator() + "hundreds of whispers call at you."
                + System.lineSeparator() + "Even though you're pure nature, you feel... unnerved."
                + System.lineSeparator() + "Eventually, you arrive in front of a coffin.";
        
        fr2v2 = "The air grows colder the further you wander." + System.lineSeparator() + 
                "For some reason, you feel oddly relaxed." + System.lineSeparator() +
                "You can't help but wonder if you should have explored the forest more."
                + System.lineSeparator() + 
                "Eventually, you find a dark, dark room with a mysterious object at its center.";
        
        fr3v1 = "You walk up to the... coffin." + System.lineSeparator()
                + "The surface is solid wood. Somehow, it hasn't decayed at all within this place."
                + System.lineSeparator() +
                "For some reason, you feel compelled to place your Offering on the coffin."
                + System.lineSeparator() + "Nothing happens. Feeling silly, you pocket it again.";
        
        fr3v2 = "You walk up to the... coffin." + System.lineSeparator()
                + "The surface is solid wood. Somehow, it hasn't decayed at all within this place."
                + System.lineSeparator() + "The objects in your pocket hum insistently."
                + System.lineSeparator() + 
                "Compelled, you place them and your Offering on the coffin...";
        
        fr3v3 = "You walk up to the... coffin." + System.lineSeparator()
            + "The surface is solid wood. Somehow, it hasn't decayed at all within this place."
            + System.lineSeparator() + "The objects in your pocket hum insistently."
            + System.lineSeparator() + 
            "You do nothing." + System.lineSeparator()
            + "The humming grows louder. " 
            + "Entranced, you watch as they fall out of your hands on their own" 
            + System.lineSeparator()
            + "The Forest Flute. " + ff.getDescription() + System.lineSeparator()
            + "The Broken Mask. " + bm.getDescription() + System.lineSeparator()
            + "and... the Rust Blade. " + rb.getDescription() 
            + System.lineSeparator() + "They all belong to the Earth elemental."
            + System.lineSeparator() + "You look up at the now- shaking coffin."
            + System.lineSeparator()
            + System.lineSeparator() + "He is awake now."
            + System.lineSeparator()
            + System.lineSeparator() + "You have done your part. The forest hums back to your Eye.";
        
        instr = "Welcome to Vast Times." + System.lineSeparator()
                + "This game is designed to be a choose-your-own-adventure."
                + System.lineSeparator()
                + System.lineSeparator()
                + "Move throughout a small forest by using the direction buttons."
                + System.lineSeparator()
                + "   (North, West, East, South)"
                + System.lineSeparator()
                + "They will become visible after the tutorial."
                + System.lineSeparator()
                + "Once you set your character name and element in the tutorial,"
                + System.lineSeparator()
                + "You will also be given the option to either save or load a previous game."
                + System.lineSeparator()
                + "You may save or load at any given time, EXCEPT for during important scenes."
                + System.lineSeparator()
                + "Please pay attention to your Elemental Eye hints at the top left of the window."
                + System.lineSeparator()
                + "Use this to navigate throughout the map and collect as many items and boosts"
                + System.lineSeparator()
                + " as you can!"
                + System.lineSeparator()
                + "Good luck! Try to find the true ending."
                + System.lineSeparator() + System.lineSeparator()
                + "* All images used in this game were handdrawn by the creator."
                + " No copyright liberties taken.";
    }
    
    public String getSTR1() {
        return str1;
    }
    
    public String getSTR2() {
        return str2;
    }
    
    public String getSTR3() {
        return str3;
    }
    
    public String getIDLE() {
        return idle;
    }
    
    public String getR1() {
        return r1;
    }

    public String getR2() {
        return r2;
    }
    
    public String getR3() {
        return r3;
    }
    
    public String getR4() {
        return r4;
    }
    
    public String getR5() {
        return r5;
    }
    
    public String getFR1() {
        return fr1;
    }
    
    public String getFR2v1() {
        return fr2v1;
    }
    public String getFR2v2() {
        return fr2v2;
    }
    
    public String getFR3v1() {
        return fr3v1;
    }
    public String getFR3v2() {
        return fr3v2;
    }
    public String getFR3v3() {
        return fr3v3;
    }
    
    
    public String instructions() {
        return instr;
    }
    
    
    public Item getFF() {
        return ff;
    }
    
    public Item getBM() {
        return bm;
    }
    
    public Item getRB() {
        return rb;
    }
}
