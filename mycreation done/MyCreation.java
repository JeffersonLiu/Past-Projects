/*
   Name: Jefferson Liu
   Teacher: Mr Rosen
   Date: Oct 21 2018
   this file runs other files together.
*/

// The "MyCreation" class.
import java.awt.*;
import hsa.Console;


public class MyCreation
{
    Console c;           // The output console

    //adds the Background thread to MyCreation
    public void background ()
    {
	//not a thread because it's not animated!!!
	Background b = new Background (c);
    }





    //adds the threeDucks thread to MyCreation
    public void threeDucks ()
    {
	//creates colors for the ducks
	Color greyBlue = new Color (88, 123, 145);
	Color violet = new Color (100, 93, 175);
	Color lightYellow = new Color (235, 255, 124);

	//creates the duck thread
	threeDucks h = new threeDucks (c, greyBlue, 15);
	//starts the thread
	h.start ();
	threeDucks h1 = new threeDucks (c, violet, 35);
	//starts the thread
	try
	{
	    Thread.sleep (500);
	}
	catch (Exception e)
	{
	}
	h1.start ();
	threeDucks h2 = new threeDucks (c, lightYellow, 55);
	//starts the thread
	try
	{
	    Thread.sleep (5000);
	}
	catch (Exception e)
	{
	}
	h2.start ();
	try
	{
	    h2.join ();
	}
	catch (InterruptedException e)
	{
	}
    }





    //adds the Car thread to MyCreation
    public void car ()
    {
	//creates the thread
	Car j = new Car (c);
	//starts the thread
	j.start ();
	//Joins with Jeep so that the jeep excecutes after the car finishes moving
	try
	{
	    j.join ();
	}
	catch (InterruptedException e)
	{
	}


    }


    //adds the jeep thread to MyCreation
    public void jeep ()
    {
	//creates the thread
	Jeep j = new Jeep (c);
	//starts the thread
	j.start ();
	try
	{
	    j.join ();
	}
	catch (InterruptedException e)
	{
	}
    }




    //adds the bike thread to MyCreation
    public void bike ()
    {
	//creates the thread
	Bike i = new Bike (c);
	//starts the thread
	i.run ();
	try
	{
	    i.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the plane thread to MyCreation
    public void plane ()
    {
	//creates the thread
	Plane i = new Plane (c);
	//starts the thread
	i.run ();

    }


    //adds the Car thread to MyCreation
    public void car1 ()
    {
	//creates the thread
	Car1 j = new Car1 (c);
	//starts the thread
	j.start ();
	//Joins with Jeep so that the jeep excecutes after the car finishes moving
	try
	{
	    j.join ();
	}
	catch (InterruptedException e)
	{
	}


    }


    //adds the jeep thread to MyCreation
    public void jeep1 ()
    {
	//creates the thread
	Jeep1 j = new Jeep1 (c);
	//starts the thread
	j.start ();
	try
	{
	    j.join ();
	}
	catch (InterruptedException e)
	{
	}
    }




    //adds the bike thread to MyCreation
    public void bike1 ()
    {
	//creates the thread
	Bike1 i = new Bike1 (c);
	//starts the thread
	i.run ();
	try
	{
	    i.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    //adds the sun thread to MyCreation
    public void sun ()
    {
	//creates the thread
	Sun i = new Sun (c);
	//starts the thread
	i.run ();
    }




    //creates a new window and gives window a title
    public MyCreation ()
    {
	c = new Console ("Duck crossing");
    }


    public static void main (String[] args)
    {
	MyCreation z = new MyCreation ();
	z.background ();
	z.car ();
	z.jeep ();
	z.bike ();
	z.threeDucks ();
	z.plane ();
	z.car1 ();
	z.jeep1 ();
	z.bike1 ();
	z.sun ();
    }
} // MyCreation class


