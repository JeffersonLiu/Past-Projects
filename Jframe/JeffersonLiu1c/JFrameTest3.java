import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * This program uses JFrame components.
 * This class class creates an application window,
 * menu bar, File menu with the Quit File menu item and
 * the helpMenu with the helpItem and about item. It then adds
 * the Quit menu item to the File menu and the File menu to the
 * menubar. Additionally, it adds the helpItem to the
 * helpMenu and the helpMenu to the menuBar. It also enables
 * the window to close if the user clicks the x button or
 * the quit button. If the user clicks the about button,
 * a short dialog will appear containing details about the programmer.
 *
 *
 * @author Jefferson Liu
 * @version 1 03.29.19
 */
public class JFrameTest3 extends JFrame implements ActionListener
{
  /**
   * The constructor passes a String for the title when it creates
   * the superclass object. It also creates an application window,
   * menu bar, File menu and the Quit File menu item. A help menu and menuItem is then created as well.
   * It then adds the menu item to the File menu and the File menu to the
   * menubar. The size of the frame is set to 400x400 and the window closes when the x button is pressed.
   * An additional menu item called about is created which is added to the help menu.
   * Actionlistener is also added to helpitem, quititem and about.
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>quitItem </b> This creates an instance of the JMenuItem class called "Quit".
   * <p>
   * <b>fileMenu </b> This creates an instance of the JMenu class called "File".
   * <p>
   * <b>myMenus </b> This creates an instance of the JMenuBar class.
   * <p>
   * <b>helpMenu </b> This creates an instance of the JMenu class called "Help".
   * <p>
   * <b>helpItem </b> This creates an instance of the JMenuItem class called "Help".
   * <p>
   * <b>about</b> This creates and instance of the JMenuItem class called "About"
   */
  
  public JFrameTest3 ()
  {
    super ("JFrame Test");
    TextTest t = new TextTest();
    add (t);
    JMenuItem quitItem = new JMenuItem ("Quit");
    JMenu fileMenu = new JMenu ("File");
    fileMenu.add (quitItem);
    JMenuItem helpItem = new JMenuItem ("Help");
    JMenuItem aboutItem = new JMenuItem ("About");
    JMenu helpMenu = new JMenu ("Help");
    helpMenu.add (helpItem);
    helpMenu.add (aboutItem);
    JMenuBar myMenus = new JMenuBar ();
    myMenus.add (fileMenu);
    myMenus.add (helpMenu);
    setJMenuBar (myMenus);
    helpItem.addActionListener (this);
    quitItem.addActionListener (this);
    aboutItem.addActionListener (this);
    setSize (400, 400);
    setVisible (true);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
  }
  
  /**
   * @The if statements direct the program to a different method depending on the buton that the user presses. 
   * @If the users presses "Quit", the program will go to dispose method.
   * @If the users presses "Help", the program will go to helpDiaglog method.
   * @If the users presses "About", the program will go to aboutDialog method.
   * */
  public void actionPerformed (ActionEvent ae)
  {
    if (ae.getActionCommand ().equals ("Quit"))
    {
      dispose ();
    }
    if (ae.getActionCommand ().equals ("Help"))
    {
      helpDialog ();
    }
    if (ae.getActionCommand ().equals ("About"))
    {
      aboutDialog ();
    }
  }
  /**
   * @This method creates a text box if the users clicks on help.
   * It then makes a button to close the text box called "Close".
   * */
  private void helpDialog ()
  {
    JDialog myDialog = new JDialog (this, "Help");
    myDialog.setSize (100, 100);
    myDialog.setResizable (false);
    myDialog.setLayout (new FlowLayout ());
    JButton helpButton = new JButton ("Help Button");
    helpButton.addActionListener (new ActionListener ()
                                    {
      public void actionPerformed (ActionEvent e)
      {
        myDialog.dispose ();
      }
    }
    );
    myDialog.add (helpButton);
    myDialog.setLocationRelativeTo (this);
    myDialog.setVisible (true);
  }
  /**
   * @This method makes a text box if the users clicks on help.
   * It also creates a button to close the text box called "Close".
   * */
  private void aboutDialog ()
  {
    JDialog newDialog = new JDialog (this, "About");
    newDialog.setSize (200, 100);
    newDialog.setResizable (false);
    newDialog.setLayout (new FlowLayout ());
    JLabel msg = new JLabel ("I am currently very sleep deprived");
    newDialog.add (msg);
    JButton close = new JButton ("Close");
    close.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent e)
      {
        newDialog.dispose ();
      }
    }
    );
    newDialog.add (close);
    newDialog.setLocationRelativeTo (this);
    newDialog.setVisible (true);
  }
}
