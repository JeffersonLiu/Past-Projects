// The "ClassTestMain" class.
import java.awt.*;
import hsa.Console;
import java.util.*;

public class ClassTestMain
{
    public static void myTest ()
    {
	ArrayList n = new ArrayList ();
	n.add (0, new Integer (10));
	n.add (1, new Integer (11));
	System.out.println (n.get (1).toString ());

    }


    public static void main (String[] args)
    {
//        myTest ();
	ClassTestSuper me = new ClassTestSub ();
	
       ((ClassTestSub) me).dothis2 ();  //to access unique method w/in sub
	me.dothis3 ();   //no override  so accesses super
	me.dothis ();   // override  so accesses sub
	ClassTestMain.myTest();

	// Place your program here.  'c' is the output console
    } // main method
} // ClassTestMain class
