// The "Rectangle" class.

// This class handles rectangles on a graphics surface. Once created, they
// can be moved, hidden, and shown again.

import java.awt.*;

public class Rectangle extends Shape
{
    protected int rectWidth, rectHeight; // The rectangle's width and height.

    // Create a rectangle that is to be drawn on the surface (which should
    // be either an Applet or a Frame). 
    public Rectangle (Component surface, int x, int y, int rectWidth, 
	int rectHeight)
    {
	super (surface, x, y, Color.red);
	this.rectWidth = rectWidth;
	this.rectHeight = rectHeight;
	show ();
    } // Rectangle constructor

    // Create a rectangle that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the 
    // drawing surface. 
    public Rectangle (Component surface, int rectWidth, int rectHeight)
    {
	super (surface, Color.red);
	this.rectWidth = rectWidth;
	this.rectHeight = rectHeight;
	show ();
    } // Rectangle constructor

    // Create a rectangle that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the
    // drawing surface. Randomly determine the width and height  
    // of the rectangle. 
    public Rectangle (Component surface)
    {
	super (surface, Color.red);
	this.rectWidth = (int) (Math.random () * 20) + 10;
	this.rectHeight = (int) (Math.random () * 20) + 10;
	show ();
    } // Rectangle constructor

    // Draw the shape.
    protected void draw ()
    {
	Graphics g = surface.getGraphics ();
	g.setColor (color);
	g.fillRect (x, y, rectWidth, rectHeight);
    } // draw method

    // Erase the shape.
    protected void erase ()
    {
	Graphics g = surface.getGraphics ();
	g.setColor (surface.getBackground ());
	g.fillRect (x, y, rectWidth, rectHeight);
    } // erase method
} /* Rectangle class */
