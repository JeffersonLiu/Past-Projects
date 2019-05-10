/*  
   Name: Jefferson Liu
   Teacher: Mr Rosen
   Date: Oct 21 2018
   This class animates a car

*/
import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class

public class Car extends Thread
{
    private Console c;

    public void car ()
    {
	Color black = new Color (0,0,0);
	Color purple = new Color (134, 85, 135);
	Color darkGrey = new Color (96,96,96);
	Color yellow = new Color (221,255,0);
	Color red = new Color (255,0,0);
	Color blue = new Color (0,255,255); 
	
	//loop used to animate the lightning
	for (int x = -100 ; x < 200 ; x++)
	{
	    //ERASE
	    c.setColor (darkGrey);
	    c.fillRect (-1+x,435,109+x,50);
	     
	    c.setColor (purple);
	    c.fillRect (0+x,445,100,20);
	    c.setColor (blue);
	    int xPoints[] = {30+x,70+x,80+x,20+x};
	    int yPoints[] = {435,435,445,445};
	    c.fillPolygon (xPoints,yPoints,4);
	    c.setColor (black);
	    c.drawLine (30+x,435,70+x,435);
	    c.drawLine (45+x,435,45+x,445);
	    c.drawLine (55+x,435,55+x,445);
	    c.setColor (red);
	    c.fillOval (48+x,438,6,6);
	    c.setColor (black);
	    c.fillArc (20+x,460,20,10,180,180);
	    c.fillArc (60+x,460,20,10,180,180);
	    c.setColor (yellow);
	    c.fillArc (95+x,440,10,10,180,90);
	     //used to delay the animation
	    try
	    {
		sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}

	   
	}
    


    public Car (Console con)
    {
	c = con;
    }


    public void run ()
    {
	car ();
    }
}

