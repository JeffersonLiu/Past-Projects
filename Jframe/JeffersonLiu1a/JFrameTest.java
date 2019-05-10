import javax.swing.*;
/**
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * This program uses JFrame components.
 *
 *
 * @author Jefferson Liu
 * 03/29/19
 */
public class JFrameTest extends JFrame
{

    /**
      * The constructor passes a String for the title when it creates
      * the superclass object. It also creates an application window,
      * menu bar, File menu and the Quit File menu item. A help menu and menuItem is then created as well.
      * It then adds the menu item to the File menu and the File menu to the
      * menubar. The size of the frame is set to 400x400 and the window closes when the x button is pressed.
      * <p>
      * <b>Local variables: </b>
      * <p>
      * <b>quitItem </b> This creates an instance of JMenuItem class "Quit".
      * <p>
      * <b>fileMenu </b> This creates an instance of JMenu class "File".
      * <p>
      * <b>myMenus </b> This creates an instance of JMenuBar .
      * <p>
      * <b>helpMenu </b> This creates an instance of JMenu class "Help".
      * <p>
      * <b>helpItem </b> This creates an instance of JMenuItem class "Help".
     */
    public JFrameTest ()
    {
	super ("JFrame Test");

	JMenuItem quitItem = new JMenuItem ("Quit"); /* MenuItem object */
	JMenu fileMenu = new JMenu ("File"); /* JMenu object */

	fileMenu.add (quitItem); /* Adding the menu item to the menu */
	JMenuBar myMenus = new JMenuBar (); /* Creating a menubar */
	myMenus.add (fileMenu); /* adding the menu to the menubar */

	JMenu helpMenu = new JMenu ("Help"); /* MenuItem object */
	myMenus.add (helpMenu); /* Adding the menuitem to the menubar */
	JMenuItem helpItem = new JMenuItem ("Help");
	helpMenu.add (helpItem); /* adding a menuitem to the menu */

	setJMenuBar (myMenus);
	setSize (400, 400);
	setVisible (true);
	setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);


    }
}
