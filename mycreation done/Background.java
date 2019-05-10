/*
   Name: Jefferson Liu
   Teacher: Mr.rosen
   Date: 10/15/2018
   This class is NOT a Thread!!!  There are no moving objects

*/


import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class

public class Background
{
    //global variable used to a
    private Console c;

    //class to make background
    public void draw ()
    {
	//local colour variable for the sky
	Color skyBlue = new Color (127, 255, 255);
	//local colour variable for the road
	Color darkGrey = new Color (96, 96, 96);
	//local colour variable for the ground
	Color green = new Color (0, 255, 4);
	//local colour variable for the snow
	Color white = new Color (255, 255, 255);
	//local colour variable for the railing
	Color grey = new Color (119, 119, 119);

	//loop used to make the sky, road, railing and ground
	for (int x = 0 ; x < 650 ; x++)
	{
	    c.setColor (skyBlue);
	    c.drawRect (0, 0, x, 300);
	    c.setColor (green);
	    c.drawRect (0, 300, x, 325);
	    c.setColor (grey);
	    c.drawRect (0, 325, x, 400);
	    c.setColor (darkGrey);
	    c.drawRect (0, 400, x, 500);
	}

	//loop used to make the mountain
	for (int x = 0 ; x < 125 ; x++)
	{
	    c.setColor (darkGrey);
	    c.drawLine (325 + x, 200 + x, 325 - x, 200 + x);

	}

	//loop used to make the snow cap on top of the mountain
	for (int x = 0 ; x < 75 ; x++)
	{
	    c.setColor (white);
	    c.drawLine (325 + x, 200 + x, 325 - x, 200 + x);
	}
	//loop used to make the gaps in the railings
	for (int x = 0 ; x < 50 ; x++)
	{
	    c.setColor (green);
	    c.drawLine (0, 350 + x, 25, 350 + x);
	    c.drawLine (50, 350 + x, 100, 350 + x);
	    c.drawLine (125, 350 + x, 175, 350 + x);
	    c.drawLine (200, 350 + x, 250, 350 + x);
	    c.drawLine (275, 350 + x, 325, 350 + x);
	    c.drawLine (350, 350 + x, 400, 350 + x);
	    c.drawLine (425, 350 + x, 475, 350 + x);
	    c.drawLine (500, 350 + x, 550, 350 + x);
	    c.drawLine (575, 350 + x, 625, 350 + x);
	}
	c.drawString ("Jefferson Liu", 300, 300);
    }



    public Background (Console con)
    {
	c = con;
	draw ();
    }
}


