import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * The JFrameTestApp is the driver class that creates JFrameTest
 * and executes the program
 *
 * @author Jefferson Liu
 * @version 1.0 03/29/19
 */

public class JFrameTest2 extends JFrame implements ActionListener
{
  /*
   * The constructor passes a String for the title when it creates
   * the superclass object. It also creates an application window,
   * menu bar, File menu and the Quit File menu item. helpItem is added to helpmenu which is added to the menubar.
   * menubar. The size of the frame is set to 400x400 and the window closes when the x button is pressed.
   * <b>Local variables: </b>
   */
  
  public JFrameTest2 ()
  {
    super ("JFrame Test 2");
    /**
     *<b>quitItem </b> This creates an instance of JMenuItem class "Quit".
     */
    JMenuItem quitItem = new JMenuItem ("Quit");
    /**
     *<b>fileMenu</b> This creates an instance of JMenu class "File".
     */
    JMenu fileMenu = new JMenu ("File");
    fileMenu.add (quitItem);
    /**
     *<b >myMenus </b> This creates an instance of JMenuBar .
     */
    JMenuBar myMenus = new JMenuBar ();
    /**
     *<b >myMenus </b> This creates an instance of JMenu class "Help" .
     */
    JMenu helpMenu = new JMenu ("Help");
    myMenus.add (helpMenu);
    /**
     *<b>myMenus</b>ThiscreatesaninstanceofJMenuItem class "Help" .
     */
    JMenuItem helpItem = new JMenuItem ("Help");
    helpMenu.add (helpItem);
    JMenuItem about = new JMenuItem ("About");
    helpMenu.add (about);
    myMenus.add (fileMenu);
    setJMenuBar (myMenus);
    quitItem.addActionListener (this);
    helpItem.addActionListener (this);
    about.addActionListener (this);
    setSize (400, 400);
    setVisible (true);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
  }
  
  
  /**
   * 
   * The if statements direct the program to a different method depending on the buton that the user presses.
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
    else if (ae.getActionCommand ().equals ("Help"))
    {
      helpDialog ();
    }
    else if (ae.getActionCommand ().equals ("About"))
    {
      aboutDialog ();
    }
  }
  
  
  /**
   *
   *@This method creates a text box if the users clicks on help.
   *It also creates a button to close the text box called "Close".
   **/
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
  
  
  /**
   *
   *@This method creates a text box if the users clicks on help.
   *It then makes a button to close the text box called "Close".
   **/
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
}
