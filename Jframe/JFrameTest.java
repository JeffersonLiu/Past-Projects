import javax.swing.*;
/**
 * The JFrameTest class creates the application window, 
 * menu bar, File menu and the Quit File menu ite. It then adds
 * the menu item to the File menu and the File menu to the
 * menubar. It also ensures that the window will close if the user 
 * clicks the 'x' button.
 *   
 * 
 * @author J Dyke 
 * @version 1 01.28.15
 */ 
public class JFrameTest extends JFrame {
  /**
 * The class constructor passes a String title when it creates
 * the superclass objcet. It then creates the application window, 
 * menu bar, File menu and the Quit File menu ite. It then adds
 * the menu item to the File menu and the File menu to the
 * menubar. It sets the size of the Frame to 400x400, and
 * ensures it will be visible.  It also ensures that the 
 * window will close if the user clicks the 'x' button.
 * <p>
 * <b>Local variables: </b>
 * <p>
 * <b>quitItem </b> This creates an instance of the JMenuItem class called "Quit".
 * <p>
 * <b>fileMenu </b> This creates an instance of the JMenu class called "File".
 * <p>
 * <b>myMenus </b> This creates an instance of the JMenuBar class.
 */ 
  public JFrameTest() { 
    super ("JFrame Test");
    
   /** */
    JMenuItem quitItem = new JMenuItem ("Quit");
    
    JMenu fileMenu = new JMenu ("File");
    
    fileMenu.add (quitItem);
    
    JMenuBar myMenus = new JMenuBar ();
    
    myMenus.add (fileMenu);
    
    setJMenuBar (myMenus);
    
    setSize (400, 400);
    setVisible (true);
    
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);  }
  /* ADD YOUR CODE HERE */
  
}
