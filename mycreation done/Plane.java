/*
   Name: Jefferson Liu
   Teacher: Mr Rosen
   Date: Oct 21 2018
   This class animates a Plane.

*/

import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class

public class Plane implements Runnable
{
    private Console c;

    public void plane ()
    {
	//local colour variable for sky
	Color skyBlue = new Color (127, 255, 255);
	//local colour variable for plane body
	Color white = new Color (255, 255, 255);
	//local colour variable for wing
	Color red = new Color (255, 255, 196);
	//local colour variable for tailfin
	Color brightBlue = new Color (0, 97, 255);
	//local colour variable for window
	Color blue = new Color (130, 177, 255);
	//local colour variable for line
	Color black = new Color (0, 0, 0);
	//local variable for delay
	int delay = 15;

	//loop used for animate the plane flying
	for (int x = -80 ; x < 80 ; x++)
	{
	    //array of local int variables for x coordinates of tailfin
	    int finX[] = {10 + x, 20 + x, 20 + x, 10 + x};
	    //array of local int variables for y coordinates of tailfin
	    int finY[] = {165 + x, 170 + x, 180 + x, 170 + x};

	    //array of local int variables for x coordinates of wing
	    int wingX[] = {20 + x, 30 + x, 20 + x};
	    //array of local int variables for y coordinates of wing
	    int wingY[] = {175 + x, 175 + x, 190 + x};

	    //erase
	    c.setColor (skyBlue);
	    c.fillRect (9 + x, 160 + x, 40, 40);

	    c.setColor (red);
	    c.fillPolygon (finX, finY, 4);
	    c.setColor (white);
	    c.fillRect (20 + x, 170 + x, 20, 10);
	    c.fillArc (35 + x, 170 + x, 10, 10, 270, 180);
	    c.setColor (brightBlue);
	    c.fillOval (38 + x, 172 + x, 4, 4);
	    c.setColor (blue);
	    c.fillPolygon (wingX, wingY, 3);
	    c.setColor (black);
	    c.drawLine (20 + x, 175 + x, 30 + x, 175 + x);


	    //used to delay the animation
	    try
	    {
		Thread.sleep (delay);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int x = 80 ; x < 160 ; x++)
	{
	    //array of local int variables for x coordinates of tailfin
	    int finX[] = {10 + x, 20 + x, 20 + x, 10 + x};
	    //array of local int variables for y coordinates of tailfin
	    int finY[] = {325 - x, 330 - x, 340 - x, 330 - x};

	    //array of local int variables for x coordinates of wing
	    int wingX[] = {20 + x, 30 + x, 20 + x};
	    //array of local int variables for y coordinates of wing
	    int wingY[] = {335 - x, 335 - x, 350 - x};

	    //erase
	    c.setColor (skyBlue);
	    c.fillRect (9 + x, 320 - x, 40, 40);

	    c.setColor (red);
	    c.fillPolygon (finX, finY, 4);
	    c.setColor (white);
	    c.fillRect (20 + x, 330 - x, 20, 10);
	    c.fillArc (35 + x, 330 - x, 10, 10, 270, 180);
	    c.setColor (brightBlue);
	    c.fillOval (38 + x, 332 - x, 4, 4);
	    c.setColor (blue);
	    c.fillPolygon (wingX, wingY, 3);
	    c.setColor (black);
	    c.drawLine (20 + x, 335 - x, 30 + x, 335 - x);


	    //used to delay the animation
	    try
	    {
		Thread.sleep (delay);
	    }
	    catch (Exception e)
	    {
	    }
	}

	for (int x = 160 ; x < 220 ; x++)
	{
	    //array of local int variables for x coordinates of tailfin
	    int finX[] = {10 + x, 20 + x, 20 + x, 10 + x};
	    //array of local int variables for y coordinates of tailfin
	    int finY[] = {165, 170, 180, 170};

	    //array of local int variables for x coordinates of wing
	    int wingX[] = {20 + x, 30 + x, 20 + x};
	    //array of local int variables for y coordinates of wing
	    int wingY[] = {175, 175, 190};

	    //erase
	    c.setColor (skyBlue);
	    c.fillRect (9 + x, 160, 40, 40);

	    c.setColor (red);
	    c.fillPolygon (finX, finY, 4);
	    c.setColor (white);
	    c.fillRect (20 + x, 170, 20, 10);
	    c.fillArc (35 + x, 170, 10, 10, 270, 180);
	    c.setColor (brightBlue);
	    c.fillOval (38 + x, 172, 4, 4);
	    c.setColor (blue);
	    c.fillPolygon (wingX, wingY, 3);
	    c.setColor (black);
	    c.drawLine (20 + x, 175, 30 + x, 175);


	    //used to delay the animation
	    try
	    {
		Thread.sleep (delay);
	    }
	    catch (Exception e)
	    {
	    }
	}

	for (int x = 220 ; x < 250 ; x++)
	{
	    //array of local int variables for x coordinates of tailfin
	    int finX[] = {10 + x, 20 + x, 20 + x, 10 + x};
	    //array of local int variables for y coordinates of tailfin
	    int finY[] = {165 - (x - 220), 170 - (x - 220), 180 - (x - 220), 170 - (x - 220) };

	    //array of local int variables for x coordinates of wing
	    int wingX[] = {20 + x, 30 + x, 20 + x};
	    //array of local int variables for y coordinates of wing
	    int wingY[] = {175 - (x - 220), 175 - (x - 220), 190 - (x - 220) };

	    //erase
	    c.setColor (skyBlue);
	    c.fillRect (9 + x, 160 - (x - 220), 40, 40);

	    c.setColor (red);
	    c.fillPolygon (finX, finY, 4);
	    c.setColor (white);
	    c.fillRect (20 + x, 170 - (x - 220), 20, 10);
	    c.fillArc (35 + x, 170 - (x - 220), 10, 10, 270, 180);
	    c.setColor (brightBlue);
	    c.fillOval (38 + x, 172 - (x - 220), 4, 4);
	    c.setColor (blue);
	    c.fillPolygon (wingX, wingY, 3);
	    c.setColor (black);
	    c.drawLine (20 + x, 175 - (x - 220), 30 + x, 175 - (x - 220));


	    //used to delay the animation
	    try
	    {
		Thread.sleep (delay);
	    }
	    catch (Exception e)
	    {
	    }
	}

	for (int x = 250 ; x < 270 ; x++)
	{
	    //array of local int variables for x coordinates of tailfin
	    int finX[] = {10 + x, 20 + x, 20 + x, 10 + x};
	    //array of local int variables for y coordinates of tailfin
	    int finY[] = {135, 140, 150, 140};

	    //array of local int variables for x coordinates of wing
	    int wingX[] = {20 + x, 30 + x, 20 + x};
	    //array of local int variables for y coordinates of wing
	    int wingY[] = {145, 145, 160};

	    //erase
	    c.setColor (skyBlue);
	    c.fillRect (5 + x, 130, 45, 45);

	    c.setColor (red);
	    c.fillPolygon (finX, finY, 4);
	    c.setColor (white);
	    c.fillRect (20 + x, 140, 20, 10);
	    c.fillArc (35 + x, 140, 10, 10, 270, 180);
	    c.setColor (brightBlue);
	    c.fillOval (38 + x, 142, 4, 4);
	    c.setColor (blue);
	    c.fillPolygon (wingX, wingY, 3);
	    c.setColor (black);
	    c.drawLine (20 + x, 145, 30 + x, 145);


	    //used to delay the animation
	    try
	    {
		Thread.sleep (delay);
	    }
	    catch (Exception e)
	    {
	    }
	}

	for (int x = 270 ; x < 290 ; x++)
	{
	    //array of local int variables for x coordinates of tailfin
	    int finX[] = {10 + x, 20 + x, 20 + x, 10 + x};
	    //array of local int variables for y coordinates of tailfin
	    int finY[] = {135 - (x - 270), 140 - (x - 270), 150 - (x - 270), 140 - (x - 270) };

	    //array of local int variables for x coordinates of wing
	    int wingX[] = {20 + x, 30 + x, 20 + x};
	    //array of local int variables for y coordinates of wing
	    int wingY[] = {145 - (x - 270), 145 - (x - 270), 160 - (x - 270) };

	    //erase
	    c.setColor (skyBlue);
	    c.fillRect (9 + x, 130 - (x - 270), 40, 40);

	    c.setColor (red);
	    c.fillPolygon (finX, finY, 4);
	    c.setColor (white);
	    c.fillRect (20 + x, 140 - (x - 270), 20, 10);
	    c.fillArc (35 + x, 140 - (x - 270), 10, 10, 270, 180);
	    c.setColor (brightBlue);
	    c.fillOval (38 + x, 142 - (x - 270), 4, 4);
	    c.setColor (blue);
	    c.fillPolygon (wingX, wingY, 3);
	    c.setColor (black);
	    c.drawLine (20 + x, 145 - (x - 270), 30 + x, 145 - (x - 270));


	    //used to delay the animation
	    try
	    {
		Thread.sleep (delay);
	    }
	    catch (Exception e)
	    {
	    }
	}

	for (int x = 290 ; x < 350 ; x++)
	{
	    //array of local int variables for x coordinates of tailfin
	    int finX[] = {10 + x, 20 + x, 20 + x, 10 + x};
	    //array of local int variables for y coordinates of tailfin
	    int finY[] = {135 - 20, 140 - 20, 150 - 20, 140 - 20};

	    //array of local int variables for x coordinates of wing
	    int wingX[] = {20 + x, 30 + x, 20 + x};
	    //array of local int variables for y coordinates of wing
	    int wingY[] = {145 - 20, 145 - 20, 160 - 20};

	    //erase
	    c.setColor (skyBlue);
	    c.fillRect (5 + x, 100, 40, 40);

	    c.setColor (red);
	    c.fillPolygon (finX, finY, 4);
	    c.setColor (white);
	    c.fillRect (20 + x, 140 - 20, 20, 10);
	    c.fillArc (35 + x, 140 - 20, 10, 10, 270, 180);
	    c.setColor (brightBlue);
	    c.fillOval (38 + x, 142 - 20, 4, 4);
	    c.setColor (blue);
	    c.fillPolygon (wingX, wingY, 3);
	    c.setColor (black);
	    c.drawLine (20 + x, 145 - 20, 30 + x, 145 - 20);


	    //used to delay the animation
	    try
	    {
		Thread.sleep (delay);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int x = 350 ; x < 650 ; x++)
	{
	    //array of local int variables for x coordinates of tailfin
	    int finX[] = {10 + x, 20 + x, 20 + x, 10 + x};
	    //array of local int variables for y coordinates of tailfin
	    int finY[] = {135 - 20, 140 - 20, 150 - 20, 140 - 20};

	    //array of local int variables for x coordinates of wing
	    int wingX[] = {20 + x, 30 + x, 20 + x};
	    //array of local int variables for y coordinates of wing
	    int wingY[] = {145 - 20, 145 + - 20, 160 - 20};

	    //erase
	    c.setColor (skyBlue);
	    c.fillRect (5 + x, 100, 40, 40);

	    c.setColor (red);
	    c.fillPolygon (finX, finY, 4);
	    c.setColor (white);
	    c.fillRect (20 + x, 140 - 20, 20, 10);
	    c.fillArc (35 + x, 140 - 20, 10, 10, 270, 180);
	    c.setColor (brightBlue);
	    c.fillOval (38 + x, 142 - 20, 4, 4);
	    c.setColor (blue);
	    c.fillPolygon (wingX, wingY, 3);
	    c.setColor (black);
	    c.drawLine (20 + x, 145 - 20, 30 + x, 145 - 20);


	    //used to delay the animation
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}


    }


    public Plane (Console con)
    {
	c = con;
    }


    public void run ()
    {
	plane ();
    }
}



