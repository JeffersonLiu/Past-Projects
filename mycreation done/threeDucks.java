/*
   Name: Jefferson
   Teacher: Mr Rosen
   Date: Oct 21 2018
This class is has 3 overloaded constructors!!!
The basic constructor creates a duck in a specific predetermined location.
The 2nd constructor allows a parameter pass to change the duck color.
The 3rd constructor creates a duck with a specific color and a time delay to
control the speed of the ducks movement during the animation.

*/
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class

public class threeDucks extends Thread
{
    private Console c;
    private Color duck;
    private int delay = 50;

    public void duck ()
    {
	//local colour variable used for road
	Color darkGrey = new Color (96, 96, 96);
	//local colour variable for the ground
	Color green = new Color (0, 255, 4);
	//local color variable used for wings
	Color darkBrown = new Color (81, 63, 40);
	//local color variable used for eyes
	Color black = new Color (0, 0, 0);
	//local color variable for beak
	Color orange = new Color (255, 14, 0);

	//loop used to animate the duck
	for (int x = -50 ; x < 100 ; x++)
	{
	    //erase
	    c.setColor (darkGrey);
	    c.fillRect (500, 450 - x, 50, 50);
	    c.setColor (green);
	    c.fillRect (500, 350, 50, 50);
	    //duck
	    c.setColor (duck);
	    int duckX[] = {510, 520, 520, 540, 540, 510, 510};
	    int duckY[] = {460 - x, 460 - x, 470 - x, 470 - x, 485 - x, 485 - x, 460 - x};
	    c.fillPolygon (duckX, duckY, 7);
	    c.fillArc (510, 480 - x, 30, 10, 180, 180);
	    //Beak
	    c.setColor (orange);
	    c.fillRect (505, 470 - x, 5, 5);
	    //wings
	    c.setColor (darkBrown);
	    c.fillArc (515, 470 - x, 20, 15, 180, 180);
	    //feet
	    c.drawLine (525, 490 - x, 525, 495 - x);
	    c.drawLine (525, 495 - x, 520, 495 - x);
	    //eyes
	    c.setColor (black);
	    c.fillOval (513, 463 - x, 3, 3);
	    //used to delay the animation
	    try
	    {
		sleep (delay);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    //basic duck
    public threeDucks (Console con)
    {
	c = con;
	duck = new Color (149, 149, 149);
    }


    // duck with a Color parameter
    public threeDucks (Console con, Color n)
    {
	c = con;
	duck = n;
    }


    // duck with a Color parameter, and a new delay time
    public threeDucks (Console con, Color n, int t)
    {
	c = con;
	duck = n;
	delay = t;
    }


    public void run ()
    {
	duck ();
    }
}


