/*@author Jefferson Liu
 * Mrs Krasteva
 * @version 1, 3/8/2019
 * This program will show the uses of FlowLayout, and all of its methods.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class FlowLayoutJefferson extends JPanel implements ActionListener
{
    /*Instance Variables
     */
    FlowLayout layout = new FlowLayout ();
    /*
     * <b>aButton</b> It is a button that returns the alignment of the panel
     */
    JButton aButton = new JButton ("Get alignment");
    /*
    *<b>aButton</b> Button that gets horizontal gap
    */
    JButton bButton = new JButton ("Get horizontal gap");
    /*
    *<b>aButton</b>  Button that gets vertical gap
    */
    JButton cButton = new JButton ("Get vertical gap");
    /*
    *<b>aButton</b> Changes the color, buttons d-g are used to demonstrate the automatic scaling in FlowLayout
    */
    JButton dButton = new JButton ("change color to gray");
    JButton eButton = new JButton ("change color to yellow");
    JButton fButton = new JButton ("change color to orange");
    JButton gButton = new JButton ("change color to white");
    JTextField text = new JTextField (20);
//    JPanel panel1 = new JPanel ();
    
    public FlowLayoutJefferson ()
    {
 aButton.addActionListener (this);
 bButton.addActionListener (this);
 cButton.addActionListener (this);
 dButton.addActionListener (this);
 eButton.addActionListener (this);
 fButton.addActionListener (this);
 gButton.addActionListener (this);
 setLayout (new FlowLayout ());
 add (aButton);
 add (bButton);
 add (cButton);
 add (dButton);
 add (eButton);
 add (fButton);
 add (gButton);
 add (text);
 setVisible (true);
    }


    public void actionPerformed (ActionEvent e)
    {
 if (e.getSource () == aButton)
 {
     text.setText ("Alignment: " + layout.getAlignment ());
 }
 else if (e.getSource () == bButton)
 {
     text.setText ("Horizontal gap: " + layout.getHgap ());
 }
 else if (e.getSource () == cButton)
 {
     text.setText ("Vertical gap: " + layout.getVgap ());
 }
 else if (e.getSource () == dButton)
 {
     setBackground (Color.gray);
 }
 else if (e.getSource () == eButton)
 {
     setBackground (Color.yellow);
 }
 else if (e.getSource () == fButton)
 {
     setBackground (Color.orange);
 }
 else if (e.getSource () == gButton)
 {
     setBackground (Color.white);
 }
    }
}

