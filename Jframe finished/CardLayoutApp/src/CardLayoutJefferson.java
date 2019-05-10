import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * The CardLayoutApp is the driver class and manages all layouts. Layouts may be accessed from a
 * tabbed pane which opens the card with a layout(s).
 * 
 * @author Jefferson Liu
 */
public class CardLayoutJefferson extends JFrame {

  /**
   * Default constructor.
   */
  public CardLayoutJefferson() {
    super("CardLayout - Jefferson");

    JPanel cards = new JPanel();
    JPanel contents;
    JTabbedPane tabbedPane = new JTabbedPane();

    cards.setLayout(new CardLayout());
    
    contents = new JPanel();
    contents.add(new FlowLayoutJefferson());
    cards.add(contents, "Flow Layout");
    tabbedPane.addTab("Flow Layout", contents);

    contents = new JPanel();
    contents.add(new GroupLayoutJefferson());
    cards.add(contents, "Group Layout");
    tabbedPane.addTab("Group Layout", contents);
    
        contents = new JPanel(new BorderLayout());
    contents.add(new FlowLayoutJefferson(), BorderLayout.NORTH);
    contents.add(new GroupLayoutJefferson(), BorderLayout.SOUTH);
    cards.add(contents, "Flow and Group Layouts");
    tabbedPane.addTab("Flow and Group Layouts", contents);
    
    contents = new JPanel(new BorderLayout());
    contents.add(new SpringLayoutNicholas(), BorderLayout.CENTER);
    cards.add(contents, "Spring Layout");
    tabbedPane.addTab("Spring Layout", contents);

    contents = new JPanel();
    contents.add(new GridBagLayoutNicholas());
    cards.add(contents, "GridBag Layout");
    tabbedPane.addTab("GridBag Layout", contents);



    JPanel border = new JPanel(new BorderLayout());
    border.add(new SpringLayoutNicholas(), BorderLayout.NORTH);
    border.add(new GridBagLayoutNicholas(), BorderLayout.WEST);
    border.add(new JLabel("<html>Spring & GridBag: Nicholas<br>Group & Flow: Jefferson</html>"),
        BorderLayout.CENTER);
    border.add(new GroupLayoutJefferson(), BorderLayout.EAST);
    border.add(new FlowLayoutJefferson(), BorderLayout.SOUTH);
    cards.add(border, "Border Layout");
    tabbedPane.addTab("Border Layout", border);

    getContentPane().add(cards);
    getContentPane().add(tabbedPane);

    setSize(1800, 720);
    setVisible(true);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  /**
   * Main method. Creates instance of this.
   * 
   * @param args - command-line arguments
   */
  public static void main(String[] args) {
    new CardLayoutJefferson();
  }

}
