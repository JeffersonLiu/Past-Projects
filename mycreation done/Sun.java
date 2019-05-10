/*
   Name: Jefferson Liu
   Teacher: Mr Rosen
   Date: Oct 21 2018
   This class animates a sun.

*/

import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class

public class Sun implements Runnable
{
    private Console c;

    public void sun ()
    {
	//local colour variable for sky
	Color skyBlue = new Color (127, 255, 255);
	//local colour variable for sun and suns rays
	Color yellow = new Color (255, 255, 196);
	//local colour variable for mouth
	Color black = new Color (0, 0, 0);
	//local colour variable for eyes
	Color blue = new Color (130, 177, 255);

	//loop used for animate the sun
	for (int x = -100 ; x < 200 ; x++)
	{
	    //Erase
	    c.setColor (skyBlue);
	    c.fillRect (0, 0 + x, 100, 100);

	    //suns rays
	    c.setColor (yellow);
	    c.drawLine (10, 10 + x, 90, 90 + x);
	    c.drawLine (50, 10 + x, 50, 90 + x);
	    c.drawLine (90, 10 + x, 10, 90 + x);
	    c.drawLine (10, 50 + x, 90, 50 + x);

	    //sun
	    c.fillOval (20, 20 + x, 60, 60);

	    //face
	    c.setColor (blue);
	    c.fillRect (30, 40 + x, 10, 10);
	    c.fillRect (60, 40 + x, 10, 10);
	    c.setColor (black);
	    c.drawArc (40, 50 + x, 19, 10, 180, 180);

	    //used to delay the animation
	    try
	    {
		Thread.sleep (50);
	    }
	    catch (Exception e)
	    {
	    }
	}
	//loop used for animate the sun
	for (int x = 200 ; x > -101 ; x--)
	{
	    //Erase
	    c.setColor (skyBlue);
	    c.fillRect (0, 0 + x, 100, 100);

	    //suns rays
	    c.setColor (yellow);
	    c.drawLine (10, 10 + x, 90, 90 + x);
	    c.drawLine (50, 10 + x, 50, 90 + x);
	    c.drawLine (90, 10 + x, 10, 90 + x);
	    c.drawLine (10, 50 + x, 90, 50 + x);

	    //sun
	    c.fillOval (20, 20 + x, 60, 60);

	    //face
	    c.setColor (blue);
	    c.fillRect (30, 40 + x, 10, 10);
	    c.fillRect (60, 40 + x, 10, 10);
	    c.setColor (black);
	    c.drawArc (40, 50 + x, 19, 10, 180, 180);

	    //used to delay the animation
	    try
	    {
		Thread.sleep (50);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public Sun (Console con)
    {
	c = con;
    }


    public void run ()
    {
	sun ();
    }
}



