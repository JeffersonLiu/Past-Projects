/*@author Jefferson Liu
 * Mrs Krasteva
 * @version 1, 3/8/2019
 * This program will show the uses of GroupLayout, and all of its methods.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * <p>
 * <pre>
 * Variable Name            Variable Type        Description
 * groupLayout               GroupLayout          The LayoutManager for this object
 * buttonW                     JButton               Button for changing the horizontal group from sequential to parallel and back. Its name changes as well.
 * buttonX                      JButton               Button for changing the vertical group from parallel to sequential and back. Its name changes as well.
 * buttonY                      JButton               Button that will be replaced by a JTextField when you click on it.
 * buttonZ                      JButton               Allows you to turn the JTextField back into a button
 * textField                     JTextField           Textfield that replaces a button when the button is clicked, says "This is a textfield"
 * panel1                       JPanel                Panel that all of the elements are shown on
 * frame                        JFrame               The frame that the panel is on
 * componentReplaceable     JComponent           Stores the current shown object
 * </pre>
 */
class GroupLayoutJefferson extends JPanel implements ActionListener
{
  JComponent componentReplaceable;
  JButton buttonW;
  JButton buttonX;
  JButton buttonY;
  JButton buttonZ;
  JTextField textField;
  GroupLayout groupLayout;
//  JPanel panel1 = new JPanel();
    
  public GroupLayoutJefferson ()
  {
    groupLayout = new GroupLayout (this); 
    groupLayout.setAutoCreateGaps (true);
    setLayout(groupLayout);
    buttonW = new JButton ("Parallel Horizontal");
    buttonX = new JButton ("This button shows the change in format");
    buttonY = new JButton ("textfield");
    buttonZ = new JButton ("Go Back");
    textField = new JTextField ("This is a textfield",20);
    componentReplaceable = buttonY;
    groupLayout.setHorizontalGroup (groupLayout.createSequentialGroup ().addComponent (buttonW).addComponent (buttonX).addComponent (componentReplaceable).addComponent (buttonZ));
    groupLayout.setVerticalGroup (groupLayout.createParallelGroup ().addComponent (buttonW).addComponent (buttonX).addComponent (componentReplaceable).addComponent (buttonZ));
    buttonW.addActionListener (this);
    buttonX.addActionListener (this);
    buttonY.addActionListener (this);
    buttonZ.addActionListener (this);
    buttonZ.setVisible (false);
    add(buttonW);
    add(buttonX);
    add(buttonY);
    add(buttonZ);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent e){
    if (e.getActionCommand ().equals ("Parallel Horizontal"))
    {
      groupLayout.setHorizontalGroup (groupLayout.createParallelGroup ().addComponent (buttonW).addComponent (buttonX).addComponent (componentReplaceable).addComponent (buttonZ));
      buttonW.setText ("Sequential Horizontal");
    }
    else if (e.getActionCommand ().equals ("Sequential Horizontal"))
    {
      groupLayout.setHorizontalGroup (groupLayout.createSequentialGroup ().addComponent (buttonW).addComponent (buttonX).addComponent (componentReplaceable).addComponent (buttonZ));
      buttonW.setText ("Sequential Vertical");
    }
    else if (e.getActionCommand ().equals ("Sequential Vertical"))
    {
      groupLayout.setVerticalGroup (groupLayout.createSequentialGroup ().addComponent (buttonW).addComponent (buttonX).addComponent (componentReplaceable).addComponent (buttonZ));
      buttonW.setText ("Parallel Vertical");
    }
    else if (e.getActionCommand ().equals ("Parallel Vertical"))
    {
      groupLayout.setVerticalGroup (groupLayout.createParallelGroup ().addComponent (buttonW).addComponent (buttonX).addComponent (componentReplaceable).addComponent (buttonZ));
      buttonW.setText ("Parallel Horizontal");
    }
    else if (e.getActionCommand ().equals ("textfield"))
    {
      groupLayout.replace (buttonY, textField);
      componentReplaceable = textField;
      buttonZ.setVisible (true);
    }
    else
    {
      if (e.getActionCommand ().equals ("Go Back"))
      {
	groupLayout.replace (textField, buttonY);
	componentReplaceable = buttonY;
	buttonZ.setVisible (false);
      }
    }
    revalidate ();
  }
}
