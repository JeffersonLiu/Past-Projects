import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * This program reads the users input and performs a calculation
 * with it.
 *
 * @author Jefferson Liu
 * @version 1 03.29.19
 */

public class TextTest extends JPanel
{
  /**
   * This calls
   * inputPrompt() and the outputResult()
   * methods
   * 
   */
  public TextTest ()
  {
    inputPrompt ();
    outputResult ();
  }
  
  /**
   * 
   * This adds a JLabel telling the user to enter input.
   * */
  public void inputPrompt ()
  {
    JLabel enterValue;
    enterValue = new JLabel ("Please enter an int value and then press calculate:");
    enterValue.setFont (new Font ("Serif", Font.PLAIN, 16));
    add (enterValue);
  }
  
  /**
   * This method adds the button calculate, TextFields and
   * it also reads and checks if the user's input is acceptable.
   * */
  public void outputResult ()
  {
    JButton calc = new JButton ("Calculate");
    JTextField inputField = new JTextField (20);
    JTextField outputField = new JTextField (25);
    outputField.setEditable(false);
    add (inputField);
    add (outputField);
    add (calc);
    inputField.requestFocus ();
    calc.addActionListener (new ActionListener ()
                              {
      public void actionPerformed (ActionEvent e)
      {
        try
        {
          int number = Integer.parseInt (inputField.getText ());
          outputField.setText ("The square of " + number + " is " + (number * number));
        }
        catch (NumberFormatException r)
        {
          outputField.setText ("Please enter an integer value.");
          inputField.setText ("");
          inputField.requestFocus();
        }
      }
    }
    );
  }
}