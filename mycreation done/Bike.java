/*
   Name: Jefferson Liu
   Teacher: Mr Rosen
   Date: oct 21 2018
   This class animates a Plane.

*/

import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class

public class Bike extends Thread
{
    private Console c;

    public void bike ()
    {
	Color black = new Color (0, 0, 0);
	Color blue = new Color (16, 0, 255);
	Color brown = new Color (81, 63, 40);
	Color darkGrey = new Color (96, 96, 96);

	//loop used to animate the bike
	for (int x = -100 ; x < 30 ; x++)
	{
	    //erase
	    c.setColor (darkGrey);
	    c.fillRect (19 + x, 435, 52, 42);
	    c.setColor (black);
	    c.fillOval (20 + x, 455, 20, 20);
	    c.fillOval (50 + x, 455, 20, 20);
	    c.setColor (blue);
	    c.drawLine (50 + x, 445, 60 + x, 465);
	    c.drawLine (45 + x, 465, 55 + x, 455);
	    c.drawLine (30 + x, 465, 45 + x, 465);
	    c.drawLine (30 + x, 465, 40 + x, 455);
	    c.drawLine (40 + x, 455, 45 + x, 465);
	    c.drawArc (45 + x, 435, 10, 10, 180, 180);
	    c.setColor (brown);
	    c.fillRect (35 + x, 450, 10, 5);

	    //used to delay the animation
	    try
	    {
		sleep (15);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public Bike (Console con)
    {
	c = con;
    }


    public void run ()
    {
	bike ();
    }
}

