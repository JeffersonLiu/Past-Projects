// The "Triangle" class.

// This class handles equilateral triangles on a graphics surface. Once 
// created, they can be moved, hidden, and shown again.

import java.awt.*;

public class Triangle extends Shape
{
    protected int sideLength; // The length of a side of the triangle.

    // Create a triangle that is to be drawn on the surface (which should
    // be either an Applet or a Frame). 
    public Triangle (Component surface, int x, int y, int sideLength)
    {
	super (surface, x, y, Color.green);
	this.sideLength = sideLength;
	show ();
    } // Triangle constructor

    // Create a triangle that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the 
    // drawing surface. 
    public Triangle (Component surface, int sideLength)
    {
	super (surface, Color.green);
	this.sideLength = sideLength;
	show ();
    } // Triangle constructor

    // Create a triangle that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the
    // drawing surface. Randomly determine the length of a side of 
    // the triangle. 
    public Triangle (Component surface)
    {
	super (surface, Color.green);
	this.sideLength = (int) (Math.random () * 20) + 10;
	show ();
    } // Triangle constructor

    // Draw the shape.
    protected void draw ()
    {
	Graphics g = surface.getGraphics ();
	int[] xp = new int [3];
	int[] yp = new int [3];
	xp [0] = x;
	yp [0] = y;
	xp [1] = x + sideLength / 2;
	yp [1] = (int) (y - Math.sqrt (3.0) / 2.0 * sideLength);
	xp [2] = x + sideLength;
	yp [2] = y;
	g.setColor (color);
	g.fillPolygon (xp, yp, 3);
    } // draw method

    // Erase the shape.
    protected void erase ()
    {
	Graphics g = surface.getGraphics ();
	int[] xp = new int [3];
	int[] yp = new int [3];
	xp [0] = x;
	yp [0] = y;
	xp [1] = x + sideLength / 2;
	yp [1] = (int) (y - Math.sqrt (3.0) / 2.0 * sideLength);
	xp [2] = x + sideLength;
	yp [2] = y;
	g.setColor (surface.getBackground ());
	g.fillPolygon (xp, yp, 3);
    } // erase method
} /* Triangle class */
