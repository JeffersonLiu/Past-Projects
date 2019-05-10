import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The GridBagLayoutNicholasGlenn demonstrates the capabilities of the GridBagLayout. It displays a
 * demonstration button whose constraints may be modified by clicking other buttons. The constraints
 * that are modified are fill, position, and padding.
 * 
 * @author Nicholas Glenn
 */
public class GridBagLayoutNicholas extends JPanel {

  /**
   * The GridBagConstraints object used for {@link demoButton}
   */
  GridBagConstraints demo;

  /**
   * The button used to demonstrate the capabilities of the GridBagLayout
   */
  JButton demoButton;

  private void update() {
    remove(demoButton);
    add(demoButton, demo);
    repaint();
    revalidate();
  }

  /**
   * Default constructor. Displays demoButton whose constraints may be modified by clicking other
   * buttons
   */
  public GridBagLayoutNicholas() {
    super(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();

    JLabel header;
    JTextField textField;
    demo = new GridBagConstraints();

    ActionListener actionListener = new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Vertical Fill")) {
          if (demo.fill == GridBagConstraints.NONE) {
            demo.fill = GridBagConstraints.VERTICAL;
          } else if (demo.fill == GridBagConstraints.BOTH) {
            demo.fill = GridBagConstraints.HORIZONTAL;
          } else if (demo.fill == GridBagConstraints.HORIZONTAL) {
            demo.fill = GridBagConstraints.BOTH;
          } else {
            demo.fill = GridBagConstraints.NONE;
          }
        } else if (e.getActionCommand().equals("Horizontal Fill")) {
          if (demo.fill == GridBagConstraints.NONE) {
            demo.fill = GridBagConstraints.HORIZONTAL;
          } else if (demo.fill == GridBagConstraints.BOTH) {
            demo.fill = GridBagConstraints.VERTICAL;
          } else if (demo.fill == GridBagConstraints.VERTICAL) {
            demo.fill = GridBagConstraints.BOTH;
          } else {
            demo.fill = GridBagConstraints.NONE;
          }
        } else if (e.getActionCommand().equals("Move Up")) {
          if (demo.gridy > 1) {
            demo.gridy--;
          }
        } else if (e.getActionCommand().equals("Move Down")) {
          if (demo.gridy < 4) {
            demo.gridy++;
          }
        } else if (e.getActionCommand().equals("Move Left")) {
          if (demo.gridx > 1) {
            demo.gridx--;
          }
        } else if (e.getActionCommand().equals("Move Right")) {
          if (demo.gridx < 4) {
            demo.gridx++;
          }
        } else if (e.getActionCommand().equals("Padding")) {
          if (demo.insets.equals(new Insets(0, 0, 0, 0))) {
            demo.insets = new Insets(40, 40, 40, 40);
          } else {
            demo.insets = new Insets(0, 0, 0, 0);
          }
        }
        update();
      }

    };

    demo.fill = 0;
    demo.gridx = 1;
    demo.gridy = 1;
    demo.insets = new Insets(0, 0, 0, 0);
    demo.ipadx = 0;
    demo.ipady = 0;
    demo.weightx = 1;
    demo.weighty = 1;

    for (int i = 1; i < 5; i++) {
      header = new JLabel("Column " + i);
      c.gridx = i;
      c.gridy = 0;
      add(header, c);
      header = new JLabel("Row " + i);
      c.gridx = 0;
      c.gridy = i;
      add(header, c);
    }

    JButton vFill = new JButton("Vertical Fill");
    vFill.addActionListener(actionListener);
    c.gridx = 1;
    c.gridy = 5;
    c.weightx = 1;
    c.weighty = 1;
    add(vFill, c);

    JButton hFill = new JButton("Horizontal Fill");
    hFill.addActionListener(actionListener);
    c.gridx = 2;
    c.gridy = 5;
    add(hFill, c);

    JButton pad = new JButton("Padding");
    pad.addActionListener(actionListener);
    c.gridx = 3;
    c.gridy = 5;
    add(pad, c);

    JButton up = new JButton("Move Up");
    up.addActionListener(actionListener);
    c.gridx = 1;
    c.gridy = 6;
    add(up, c);

    JButton down = new JButton("Move Down");
    down.addActionListener(actionListener);
    c.gridx = 2;
    c.gridy = 6;
    add(down, c);

    JButton left = new JButton("Move Left");
    left.addActionListener(actionListener);
    c.gridx = 3;
    c.gridy = 6;
    add(left, c);

    JButton right = new JButton("Move Right");
    right.addActionListener(actionListener);
    c.gridx = 4;
    c.gridy = 6;
    add(right, c);

    demoButton = new JButton("Look at me!");
    add(demoButton, demo);
  }

}
