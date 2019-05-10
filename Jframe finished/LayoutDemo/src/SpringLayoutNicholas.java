import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * The SpringLayoutNicholasGlenn demonstrates the capabilities of the SpringLayout. It consists of a
 * JLabel which is surrounded by four buttons that move the label up, down, left, or right. The
 * buttons stay in the same place relative to the label due to SpringLayout's ability to place
 * constraints on two components.
 * 
 * @author Nicholas Glenn
 */
public class SpringLayoutNicholas extends JPanel {

  /**
   * X-Coordinate of text
   */
  int xCoord = 200;

  /**
   * Y-Coordinate of text
   */
  int yCoord = 100;

  /**
   * SpringLayout object which has all constraints for all components
   */
  SpringLayout s;

  /**
   * Centre label that all other components are constrained to
   */
  JLabel text = new JLabel("Click the surrounding buttons");

  /**
   * Updates position of centre label
   */
  private void update() {
    s.putConstraint(SpringLayout.NORTH, text, yCoord, SpringLayout.NORTH, this);
    s.putConstraint(SpringLayout.WEST, text, xCoord, SpringLayout.WEST, this);
    repaint();
    revalidate();
  }

  /**
   * Moves label up
   */
  private void moveUp() {
    yCoord -= 10;
    update();
  }

  /**
   * Moves label down
   */
  private void moveDown() {
    yCoord += 10;
    update();
  }

  /**
   * Moves label left
   */
  private void moveLeft() {
    xCoord -= 10;
    update();
  }

  /**
   * Moves label right
   */
  private void moveRight() {
    xCoord += 10;
    update();
  }


  /**
   * Default constructor. Displays label text that may be moved around.
   */
  public SpringLayoutNicholas() {
    super();
    s = new SpringLayout();
    setLayout(s);
    JButton upButton = new JButton("Up");
    JButton downButton = new JButton("Down");
    JButton leftButton = new JButton("Left");
    JButton rightButton = new JButton("Right");

    ActionListener actionListener = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Up")) {
          moveUp();
        } else if (e.getActionCommand().equals("Down")) {
          moveDown();
        } else if (e.getActionCommand().equals("Left")) {
          moveLeft();
        } else if (e.getActionCommand().equals("Right")) {
          moveRight();
        }
      }

    };

    upButton.addActionListener(actionListener);
    downButton.addActionListener(actionListener);
    leftButton.addActionListener(actionListener);
    rightButton.addActionListener(actionListener);
    add(text);
    update();
    add(upButton);
    s.putConstraint(SpringLayout.SOUTH, upButton, -10, SpringLayout.NORTH, text);
    s.putConstraint(SpringLayout.HORIZONTAL_CENTER, upButton, 0, SpringLayout.HORIZONTAL_CENTER,
        text);
    add(downButton);
    s.putConstraint(SpringLayout.NORTH, downButton, 10, SpringLayout.SOUTH, text);
    s.putConstraint(SpringLayout.HORIZONTAL_CENTER, downButton, 0, SpringLayout.HORIZONTAL_CENTER,
        text);
    add(leftButton);
    s.putConstraint(SpringLayout.EAST, leftButton, -10, SpringLayout.WEST, text);
    s.putConstraint(SpringLayout.VERTICAL_CENTER, leftButton, 0, SpringLayout.VERTICAL_CENTER,
        text);
    add(rightButton);
    s.putConstraint(SpringLayout.WEST, rightButton, 10, SpringLayout.EAST, text);
    s.putConstraint(SpringLayout.VERTICAL_CENTER, rightButton, 0, SpringLayout.VERTICAL_CENTER,
        text);

    setPreferredSize(new Dimension(400, 240));
  }

}
