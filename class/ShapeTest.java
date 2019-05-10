// The "ShapeTest" class.

// This applet randomly places 10 shapes on the drawing surface.

import java.applet.*;
import java.awt.*;

public class ShapeTest extends Applet
{
    protected final static int NUM_SHAPES = 10;

    // The array containing the Shape objects.
    protected Shape[] shapes = new Shape [NUM_SHAPES];

    // This method is called when the Applet object is created.
    public void init ()
    {
	// Get the width and height of the drawing surface.
	int surfaceWidth = getSize ().width;
	int surfaceHeight = getSize ().height;

	// Create the shapes and place them randomly on the drawing surface.
	for (int count = 0 ; count < NUM_SHAPES ; count++)
	{
	    int shapeKind = (int) (Math.random () * 3);

	    if (shapeKind == 0)
	    {
		// The following two lines place the upper-left corner
		// of the rectangle in the upper-left quadrant.
		int x = (int) (Math.random () * surfaceWidth / 2);
		int y = (int) (Math.random () * surfaceHeight / 2);
		int rectWidth = (int) (Math.random () * 20) + 10;
		int rectHeight = (int) (Math.random () * 20) + 10;
		shapes [count] = new Rectangle (this, x, y, rectWidth, 
		    rectHeight);
	    }
	    else if (shapeKind == 1)
	    {
		int xRadius = (int) (Math.random () * 30) + 10;
		int yRadius = (int) (Math.random () * 10) + 10;
		shapes [count] = new Oval (this, xRadius, yRadius);
	    }
	    else if (shapeKind == 2)
	    {
		shapes [count] = new Triangle (this);
	    }
	}
    } // init method

    // This method is called whenever the applet's drawing surface is
    // obscured and then revealed. We call the paint method for each
    // shape to redraw that shape (if the shape is currently visible).
    public void paint (Graphics g)
    {
	// For each shape, call its paint method.
	for (int count = 0 ; count < NUM_SHAPES ; count++)
	{
	    shapes [count].paint ();
	}
    } // paint method
} /* ShapeTest class */
