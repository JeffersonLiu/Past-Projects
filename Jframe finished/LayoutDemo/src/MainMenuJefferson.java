import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The MainMenuJefferson is the driver class and manages all layouts. Layouts may be accessed from a menu
 * which opens each layout in a new window.
 * 
 * @author Jefferson Liu
 */
public class MainMenuJefferson extends JFrame {

  /**
   * Default constructor.
   */
  public MainMenuJefferson() {
    super("Layout Demo");
    setLayout(new FlowLayout());
    FlowLayoutJefferson flow = new FlowLayoutJefferson();
    GroupLayoutJefferson group = new GroupLayoutJefferson();
    GridBagLayoutNicholas gridBag = new GridBagLayoutNicholas();
    SpringLayoutNicholas spring = new SpringLayoutNicholas();

    getContentPane().add(new JLabel("Main Menu"));

    ActionListener actionListener = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("GridBagLayout")) {
          JFrame window = new JFrame("GridBagLayout");
          window.add(gridBag);
          window.setSize(600, 400);
          window.setVisible(true);
          window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getActionCommand().equals("SpringLayout")) {
          JFrame window = new JFrame("SpringLayout");
          window.add(spring);
          window.setSize(600, 400);
          window.setVisible(true);
          window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getActionCommand().equals("FlowLayout")) {
          JFrame window = new JFrame("FlowLayout");
          window.add(flow);
          window.setSize(600, 400);
          window.setVisible(true);
          window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getActionCommand().equals("GroupLayout")) {
          JFrame window = new JFrame("GroupLayout");
          window.add(group);
          window.setSize(700, 400);
          window.setVisible(true);
          window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getActionCommand().equals("Close")) {
          System.exit(0);
        }
      }

    };
    JButton flowButton = new JButton("FlowLayout");
    flowButton.addActionListener(actionListener);
    getContentPane().add(flowButton);

    JButton groupButton = new JButton("GroupLayout");
    groupButton.addActionListener(actionListener);
    getContentPane().add(groupButton);
    
    JButton gridBagButton = new JButton("GridBagLayout");
    gridBagButton.addActionListener(actionListener);
    getContentPane().add(gridBagButton);

    JButton springButton = new JButton("SpringLayout");
    springButton.addActionListener(actionListener);
    getContentPane().add(springButton);


    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(actionListener);
    getContentPane().add(closeButton);

    pack();
    setVisible(true);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  /**
   * Main method. Creates instance of this.
   * 
   * @param args - command-line arguments
   */
  public static void main(String[] args) {
    new MainMenuJefferson();
  }

}
