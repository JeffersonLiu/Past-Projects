/*
   Name: Jefferson
   Teacher: Mr Rosen
   Date: oct 21 2018
   This class is draws a jeep!!!

*/
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class

public class Jeep extends Thread
{
    private Console c;

    public void jeep ()
    {
	Color black = new Color (0, 0, 0);
	Color green = new Color (123, 147, 93);
	Color darkGrey = new Color (96, 96, 96);
	Color magenta = new Color (255, 0, 255);
	Color blue = new Color (0, 255, 255);

	//loop used to animate the jeep
	for (int x = -100 ; x < 100 ; x++)
	{
	    //array of local int varibles of x coordinates to make jeep windows
	    int jeepX[] = {20 + x, 50 + x, 60 + x, 20 + x};
	    //array of local int varibles of y coordinates to make jeep windows
	    int jeepY[] = {435, 435, 445, 445};

	    //ERASE
	    c.setColor (darkGrey);

	    c.fillRect (-1 + x, 435, 80, 50);
	    c.setColor (green);
	    c.fillRect (20 + x, 445, 60, 20);
	    c.setColor (blue);
	    c.fillPolygon (jeepX, jeepY, 4);
	    c.setColor (black);
	    c.drawLine (45 + x, 435, 50 + x, 435);
	    c.drawLine (35 + x, 435, 35 + x, 445);
	    c.fillOval (20 + x, 455, 20, 20);
	    c.fillOval (50 + x, 455, 20, 20);
	    c.fillArc (10 + x, 445, 20, 20, 90, 180);


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


    public Jeep (Console con)
    {
	c = con;
    }


    public void run ()
    {
	jeep ();
    }
}

