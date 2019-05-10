// The "Shape" class.

// This is an abstract class from which all shapes descend. It contains 
// all the methods and data that are common to all shapes. For example, 
// you can call the show and hide methods of any Shape object, even 
// if you do not know the exact type of the object (Rectangle, Oval, 
// or Triangle).

import java.awt.*;

public abstract class Shape
{
    protected Component surface; // The surface to draw on.
    protected int x, y; // The x, y location of the shape.
    protected boolean visible = false; // Is the shape currently visible.
    protected Color color; // The color of the shape.

    protected abstract void draw (); // The method to draw the shape.
    protected abstract void erase (); // The method to erase the shape.
    
    // Create a shape that is to be drawn on the surface (which should
    // be either an Applet or a Frame). 
    public Shape (Component surface, int x, int y, Color color)
    {
	this.surface = surface;
	this.x = x;
	this.y = y;
	this.color = color;
    } // Shape constructor
    
    // Create a shape that is to be drawn on the surface (which should
    // be either an Applet or a Frame). Randomly place it on the 
    // drawing surface. 
    public Shape (Component surface, Color color)
    {
	int surfaceWidth = surface.getSize ().width;
	int surfaceHeight = surface.getSize ().height;

	this.surface = surface;
	this.x = (int) (Math.random () * surfaceWidth);
	this.y = (int) (Math.random () * surfaceHeight);
	this.color = color;
    } // Shape constructor
    
    // If the shape is not already visible, make it visible.
    public void show ()
    {
	if (!visible)
	{
	    draw ();
	    visible = true;
	}
    } // show method

   // If the shape is visible, hide it.
    public void hide ()
    {
	if (visible)
	{
	    erase ();
	    visible = false;
	}
    } // hide method

    // Redraw the shape if it is visible.
    public void paint ()
    {
	if (visible)
	{
	    draw ();
	}
    } // paint method

    // Move the shape to a new location.
    public void move (int x, int y)
    {
	if (visible)
	{
	    erase ();   
	    this.x = x;
	    this.y = y;
	    draw ();
	}
	else
	{
	    this.x = x;
	    this.y = y;
	}
    } // move method

    // If the user does not specify the coordinates to move to, then
    // move the shape to a new random location.
    public void move ()
    {
	int surfaceWidth = surface.getSize ().width;
	int surfaceHeight = surface.getSize ().height;

	int newX = (int) (Math.random () * surfaceWidth);
	int newY = (int) (Math.random () * surfaceHeight);

	if (visible)
	{
	    erase ();   
	    this.x = newX;
	    this.y = newY;
	    draw ();
	}
	else
	{
	    this.x = newX;
	    this.y = newY;
	}
    } // move method
} /* Shape class */     
