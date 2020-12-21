READ ME

DaHyeon Choi, CIS 120 HW09 documentation

VAST TIME is a choice-based, map-traveling adventure story game. Character movement on a small 2-D map (modeled using 2-D array)
is controlled by a set of directional buttons, NORTH, WEST, SOUTH, EAST. 
It is entirely handwritten and handdrawn (save my fingers please)

During the 'tutorial', players are given a chance to customize their characters. They do this by choosing an element,
and inputting a valid name. The graphics side of the game displays a series of scenes, changing backgrounds, icons, and 
character profiles. Saving your progress will save this character customization as well.
The main player character is an elemental spirit, journeyig through a small forest. The player is guided by their
Elemental Eye, which displays the direction of the final destination, and when the player hits the edges/ borders
of the forest. Adventuring will lead the player character to discover items and special locations. By gaining items and
exploring these special locations, players will alter their story ending.
* Please refer to the .excel file named Map Representation in the README folder to see how the map looks like.

For reference, the GUI of this game looks like this:
(! ALL IMAGES ARE HANDDRAWN BY ME! THERE ARE NO SOURCES FOR IMAGE RESOURCES LISTED IN THIS FILE BECAUSE OF THIS !)


    |_________Save__________Load_____________|
    |          |              |  Character   |
    | Story    |    Story     |  Profile     |
    | Graphics |    scenes    |              |
    |__________|______________|__Inventory___|
    |    North  West  South  East            |



===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. Collections

I used a TreeMap to store the most important states for my game: item possession. Since the game relies on the
 location of these Item objects on the Map and the character picking them up, I used a TreeMap since that allows me 
to add and remove from these collections without having to use recursion, and it can model the game state of item
possession (whether a specified item is in character's inventory or still on map). I only have one collection each
for my Map and Character. The methods of these classes allow Character objects to 'pickup' Items from VastMap objects.
Since I stored my map as a String 2D array, I needed to be able to get an item from an ITem collection via a String
(Item name) key.

  2. File I/O
I/O : I used BufferedReader and BufferedWriter to save to and load from txt files. In these txt files, data is saved
 in columns divided by ! marks. As such, ! marks are not valid choices for user character name inputs, and the program
automatically removes ! inside of names (the only data directly written by user).
These game saves store: Character name, element, position on map, stats, and objects in inventory.
This is done by mainly three classes: FileLineIterator (different from HW08), Loader, and Saver. Loader and Saver
 are the main actors who carryout saving and loading these exclamation mark-separated-txt files.

  3. Inheritance / Subtyping
The classes ItemImage, SceneImage, and CharacterImage all inherit the interface ImageInterface, and the three classes
also extend the JPanel. These are GUI components that show images. They share the same ImageInterface because much of
their uses in Game require the same methods / return types, and they are in essence very similar 'image displayers'.
However, they differ in these ways: first, the changeIcon method will:
    for SceneImage, will change image to new.
    for ItemImage, will add new image into panel. 
    for CharacterImage, will change icon into one of 6 predefined images (defined when class is instantiated)
In addition, while SceneImage and CharacterImage show only one image at a time, ItemImage must show several, and therefore
when prompted for the main BufferedImage of the panel, ItemImage will give only the most recently added one.
These three classes are dynamic classes. Although functionally these panels are similar, image panels, and thus use
similar methods and calls and remove methods, the way images are updated (addition, swapping, deletion+addition, etc)
are significantly different.
* SceneImage si used for visual scene showing is typed with parent type ImageInterface, given dynamic class SceneImage.


  4. JUnit Testing

To test my primary non-GUI related model of the game, I created 4 tests for HW09.
Among my 16 classes, Character, Item, and VastMap are my primary objects for game state storage.
Saver, Loader, and FolderReader along with a new version of FileLineIterator, are for saving and loading game saves.
Since the remainder are GUI-based classes or helper classes,
I created JUnit tests using Character, Item, and VastMap, as well as using Storage to initialize the game.
In CharacterTest, MapTest, and ItemTest, I test 'independent' methods of each class (methods that
do not rely on other objects to run, unlike Character's takeItem method, for example) and encapsulation. 
Since these are fairly basic methods, and I am testing to make sure there are no errors, next I have
GameModelTest. GameModelTest checks the methods I wrote in these three classes that rely on each other.
Consequently, this tests the game model of 'character moves through 2D array grid, collecting items, and
arrives at destination.' (My GUI-entwined game model (sub-model) tracks story movement and visual graphics.)
I keep track of several variables and in-game states, but the most important are: the items remaining in VastMap,
the items collected by Character, and Character Stats according to external commands. Essentially in the game,
VastMap and Character exchanges items, and these tests are designed to check this model.
These dozen or so JUnit tests mainly check methods inside the VastMap and Character classes, including the load
save file method in Character.

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.

Character - main game state storage object #1. Models player's character, and stores location, element, name, item inventory, etc.
CharacterImage - Implements ImageInterface, displays profile icon according to character element
Compass - GUI. displays small text in upper left corner that gives the user hints to navigate forest (aka which direction the
 destination is at, tells player when they're moving along the map border / when they hit corners)
FileLineIterator - takes in a file path and spits out an ArrayList of lines
FolderReader - helper class for Save / Load function
Game - main Java class, runs game
ImageInterface - NOT a class, an interface, parent of CharacterImage, ItemImage, SceneImage
Item - defines Item object with name, description, icon link
ItemImage - GUI Jpanel, adds item icons to visual inventory, implements ImageInterface
Loader - Creates object to help with loading save file, used by Character's loadFile method.
Room - extends JPanel, displays story text and buttons
Saver - Creates object to help with saving game data
SceneImage - JPanel / ImageInterface that displays certain image, given file path
StatShower - Simple class that displays character stats and updates every time its updateStats method is called.
Storage - stores story scenes as strings, Items, and adds Items to map when Storage s is created.
VastMap - main game state storage object #2. Uses 2D array 'map' to store item locations. Character traverses this map and 
 acquires items.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
I had difficulties managing the multiple classes I needed for the GUI and for modeling the game state.
Next time, maybe I can do it more efficiently.

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
Most of my variables were encapsulated, if not all. I would remove some of the more unused variables, however, if given the chance.
Becuase I have quite a number of classes, it gets difficult to wield multiple variables in code.
Other than that, I haven't run into 'editing where something shouldn't be edited' cases.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.

ALL IMAGES WERE HANDDRAWN BY MYSELF so there are no external sources for that.
I have read a few online resources for JPanel etc, but I did not use any specific code.
External resource: HW08. Part of the FileLineIterator in this game was inspired by the class of the same name on HW08, although
they work differently.
