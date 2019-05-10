/*
    Jefferson Liu
    Mr.Rosen
    Jan 9 2019
    This program creates a calculator. It includes splashscreen, mainMenu, display, viewAns, saveAns, instructions, calculate, and goodbye methods.
    The splashscreen displays a short animation.
    The mainMenu displays a main menu.
    The display contains all the errortraps and contains the black box return method.
    viewAns lets the user enter a name and view the saved file under that name. It is errortrapped.
    saveAns lets the user enter a name and save a file under that name.
    instructions tells the user how to use the program.
    calculate is the black box method. It goes through the entire equation and does the calculations in order of operations.
    goodbye exits the program. If the user has an unsaved file it asks them if they want to save.
    pauseProgram pauses the program.
    title clears the screen and prints a title.


    Name            Variable Type               Function
    -----------------------------------------------------------------------
    choice          static String               It is the choice that the users enter when they are in mainMenu.
    save            static boolean              It changes if the user has saved or not and lets the program know if the user has saved.
    exists          static boolean              It detects if an equation exists.
    answer          double                      It saves the answer of an equation.
    operand         double                      It saves an operand which is part of an equation.
    fileName        String                      It is the file name that the user enters
    header          String                      It is the header.
    equation        static String               It stores the equation.
    equationArray   String[]                    It stores the equation in array form.
    operator        char                        It stores the operator.
    pauseChar       static char                 It stores what the user pressed in the pause program.
    displayDetector int                         It stores how many times the user has accessed display.
    inDisplay       boolean                     It detects if the user is currently in display.

*/


// The "Calculator" class.
//imports classes for use in the program
import java.awt.*;
import hsa.*;
import java.io.*;

public class Calculator
{
    static Console c;           // The output console

    //Global declarations
    static String choice = "";
    static boolean save = false, exists = false;
    double answer, operand;
    String fileName, header = "-~^Calculator_Saved_Answer^~-";
    static String equation;
    String[] equationArray = new String [0];
    char operator = '0';
    static char pauseChar;
    int displayDetector = 1;
    boolean inDisplay = false;

    public Calculator ()
    {
	//sets the console window name to "Calculator - by Jefferson Liu"
	c = new Console ("Calculator - by Jefferson Liu");
    }


    /* This is the title, it clears the screen and prints a title
    --------------------------------------------------------------
    local variables: none
    global variables: exists , save
    */
    public void title ()
    {
	//clears the screen
	c.clear ();
	//prints the actual title
	c.print (' ', 40);
	c.println ("Calculator");
	//checks if there is an unsaved file
	if (exists == true & save == false)
	{
	    c.print (' ', 30);
	    c.println ("You currently have an unsaved file");
	}
	c.println ();
	c.println ();
	c.println ();
    }

    /* The mainMenu displays a main menu.
    --------------------------------------------------------------
    local variables: none
    global variables: inDisplay , choice
    */
    public void mainMenu ()  //main menu
    {
	//sets the inDisplay variable to false
	inDisplay = false;
	title ();
	c.println ("Press the key that corresponds with your choice");
	c.println ("~1~ Calculator");
	c.println ("~2~ Instructions");
	c.println ("~3~ Save answer");
	c.println ("~4~ View answer");
	c.println ("~5~ Exit");
	//lets the user enter their choice
	choice = c.readLine ();
    }

    /* The splashscreen displays a short animation.
    --------------------------------------------------------------
    local variables: none
    global variables: none
    */
    
    public void splashScreen ()      //splashScreen
    {
	//creates the thread
	SplashScreen i = new SplashScreen (c);
	//starts the thread
	i.run ();
	pauseProgram ();

    }

    /* Goodbye exits the program. If the user has an unsaved file it asks them if they want to save.
    --------------------------------------------------------------
    local variables: none
    global variables: save, exists, pauseChar
    */
    public void goodbye ()
    {
	//calls title
	title ();
	//checks if there is an existing file that is unsaved
	if (save == true || exists == false)
	{
	    c.println ("This program was made by Jefferson Liu");
	    pauseProgram ();
	    c.close ();
	}
	else
	{
	    c.println ("Are you sure you want to exit without saving?");
	    c.println ("Press e to exit. Press anything else to take you back to the main menu");
	    pauseProgram ();
	}
	if (pauseChar == 'e')
	{
	    c.close ();
	}
    }

    /* pauseProgram pauses the program.
    --------------------------------------------------------------
    local variables: none
    global variables: save, exists, pauseChar, displayDetector, inDisplay
    */
    public void pauseProgram ()    //pause program
    {
	//checks if there is an existing file
	if (choice.equals ("1") & save == false & exists == true & displayDetector > 1 & inDisplay == false)
	{
	    c.println ("Are you sure you want to overwrite your file? Press e if you are sure");
	}
	else
	{
	    c.println ("Press any key to continue: ");
	}
	pauseChar = c.getChar ();
    }


    /* viewAns lets the user enter a name and view the saved file under that name. It is errortrapped.
    --------------------------------------------------------------
    global variables: save, exists, pauseChar, displayDetector, inDisplay
    --------------------Name--------Variable type-------Description
    local variables: currentLine    String              This variable saves the data on one line
    */
    public void viewAns ()
    {
	//calls title
	title ();
	BufferedReader br;
	String currentLine;
	c.println ("Please input the name of the file you want to search for");
	fileName = c.readString ();
	fileName = fileName + ".calc";
	//reads the file
	try
	{
	    br = new BufferedReader (new FileReader (fileName));
	    currentLine = br.readLine ();
	    if (currentLine.equals (header))
	    {
		currentLine = br.readLine ();
		c.println ("the equation was: " + currentLine);
		currentLine = br.readLine ();
		c.println ("the answer was " + currentLine);
	    }
	    else
	    {
		c.println ("the file you named was not created by this program");
	    }
	    pauseProgram ();
	}
	catch (IOException e)
	{
	    c.println ("That isnt an existing file");
	    pauseProgram ();
	}
    }


    public void instructions ()
    {
	title ();
	//contains instructions
	c.println ("This is a java calculator\nIt works like a regular calculator\nEnter a number and enter a sign\nThe answer will update as you input your numbers\nThe calculator will exit when you press the '=' key\nwhich will also exit the equation");
	pauseProgram ();
    }


    public void display ()
    {
	//local declarations
	String operandStr = "noValue";
	boolean zeroDivide = false;
	equationArray = new String [0];
	//sets inDisplay to true
	inDisplay = true;
	//clears equation
	if (exists == false)
	{
	    equation = null;
	}
	//loops until an = sign is pressed
	while (true)
	{
	    //loops until a number is inputted
	    while (true)
	    {
		//users enter their number here
		//calls title
		title ();
		c.setCursor (5, 1);
		c.print ("Your equation is:");
		c.setCursor (5, 20);
		if (equation != null)
		{
		    c.println (equation);
		}
		c.setCursor (15, 1);
		c.print ("Please input your number: ");
		operandStr = c.readLine ();
		try
		{
		    operand = Double.parseDouble (operandStr);
		    //Errortraps
		    //checks for division by zero
		    if (operand == 0 & operator == '/')
		    {
			new Message ("You cannot divide by zero");
			zeroDivide = true;
			operand = 0;
		    }
		    //checks if there is an existing equation to add on to
		    if (equation != null & exists == true & zeroDivide == false)
		    {
			equation = equation + ' ' + operand;
			equationArray = equation.split (" ");
			break;
		    }
		    //resets equation
		    else if (equation == null || exists == false & zeroDivide == false)
		    {
			equation = Double.toString (operand);
			equationArray = equation.split (" ");

		    }
		    //checks if user divided by zero
		    if (zeroDivide == false)
		    {
			operator = '0';
			break;
		    }
		    //resets zeroDivide variable to false
		    zeroDivide = false;
		}
		catch (Exception e)
		{
		    //alerts user
		    new Message ("Please enter a number");
		}
	    }



	    //loops until a valid operator is inputted
	    while (true)
	    {
		//user can enter their operand here
		exists = true;
		//calls title
		title ();
		c.setCursor (5, 1);
		c.print ("Your equation is:");
		c.setCursor (5, 20);
		c.println (equation);
		c.setCursor (8, 1);
		c.println ("the answer is: " + calculate (equationArray));
		c.setCursor (15, 1);
		c.println ("Please input your number: " + operandStr);
		c.print ("Please input your operand: ");
		operator = c.getChar ();
		//checks if the user entered a valid input
		if (operator != '*' & operator != '-' & operator != '+' & operator != '/' & operator != '=')
		{
		    new Message ("Please enter one of these operators.  + - * / = ");
		}
		//checks if the operator is = or not
		else if (operator != '=')
		{
		    equation = equation + " " + operator;
		    break;
		}
		//checks if operator is =
		else if (operator == '=')
		{
		    c.setCursor (5, 1);
		    c.println (equation + " = ");
		    break;
		}
	    }
	    //detects if an = sign is pressed and ends display
	    if (operator == '=')
	    {
		c.setCursor (5, 1);
		c.println (equation + " = " + calculate (equationArray));
		answer = calculate (equationArray);
		pauseProgram ();
		break;
	    }
	    //adds to the displaydetector
	    displayDetector++;
	}
    }


    private double calculate (String[] equationArray)
    {
	//local declarations
	double calculate;
	int operatorFind;
	final int arrayAdd = 999;
	String[] tempEquation = new String [equationArray.length + arrayAdd];

	//  for loop: loops through the entire equation array in order to make a copy of it
	for (int x = 0 ; x < equationArray.length ; x++)
	{
	    tempEquation [x] = equationArray [x];
	}


	operatorFind = equationArray.length - 1;

	//multiplication and division
	for (int y = 0 ; y < operatorFind ; y++)
	{
	    //checks for * sign
	    if (tempEquation [y].equals ("*") && tempEquation [y + 1] != null) //multi
	    {
		tempEquation [y - 1] = (Double.parseDouble (tempEquation [y - 1])) * (Double.parseDouble (tempEquation [y + 1])) + "";
		operatorFind -= 2;
		//deletes current operator and operand and shifts everything over
		for (int z = 0 ; z < operatorFind ; z++)
		{
		    tempEquation [y + z] = tempEquation [y + z + 2];
		}
		tempEquation [operatorFind + 1] = null;
		tempEquation [operatorFind + 2] = null;
		y = -1; //restarts loop
	    }
	    //checks for / sign
	    else if (tempEquation [y].equals ("/") && tempEquation [y + 1] != null) //div
	    {
		tempEquation [y - 1] = (Double.parseDouble (tempEquation [y - 1])) / (Double.parseDouble (tempEquation [y + 1])) + "";
		operatorFind -= 2;
		//deletes current operator and operand and shifts everything over

		for (int z = 0 ; z < operatorFind ; z++) //shifting every element over
		{
		    tempEquation [y + z] = tempEquation [y + z + 2];
		}
		tempEquation [operatorFind + 1] = null;
		tempEquation [operatorFind + 2] = null;
		y = -1; //"restarting" the loop
	    }
	}


	//checks for addition and subtraction
	for (int i = 0 ; i < operatorFind ; i++)
	{
	    //checks for + sign if its not there it checks for - sign
	    //addition
	    if (tempEquation [i].equals ("+") && tempEquation [i + 1] != null)
	    {
		//does the operation
		tempEquation [i - 1] = (Double.parseDouble (tempEquation [i - 1])) + (Double.parseDouble (tempEquation [i + 1])) + "";
		operatorFind -= 2;
		//deletes current operator and operand and shifts everything over

		for (int x = 0 ; x < operatorFind ; x++)
		{
		    tempEquation [i + x] = tempEquation [i + x + 2];
		}
		//sets the two last strings to null
		tempEquation [operatorFind + 1] = null;
		tempEquation [operatorFind + 2] = null;
		i = -1;
	    }
	    //subtraction
	    else if (tempEquation [i].equals ("-") && tempEquation [i + 1] != null)
	    {
		//does the operation
		tempEquation [i - 1] = (Double.parseDouble (tempEquation [i - 1])) - (Double.parseDouble (tempEquation [i + 1])) + "";
		operatorFind -= 2;
		//deletes current operator and operand and shifts everything over
		for (int x = 0 ; x < operatorFind ; x++)
		{
		    tempEquation [i + x] = tempEquation [i + x + 2];
		}
		//sets the two last strings to null
		tempEquation [operatorFind + 1] = null;
		tempEquation [operatorFind + 2] = null;
		i = -1;
	    }
	}

	//sets the calculate variable
	calculate = Double.parseDouble (tempEquation [0]);
	return calculate;
    }



    public void saveAns ()
    {
	//checks if there is an existing file
	if (exists)
	{
	    title ();
	    PrintWriter pw;

	    //local declarations
	    String newFile = "";

	    c.print ("Save as: ");
	    fileName = c.readLine ();

	    //loops through the file name and detects any illegal characters
	    for (int x = 0 ; x < fileName.length () ; x++)
	    {
		//detects if the user enters an illegal character
		if (fileName.charAt (x) == '\\' || fileName.charAt (x) == '/' || fileName.charAt (x) == '*' || fileName.charAt (x) == ':' || fileName.charAt (x) == '?' || fileName.charAt (x) == '"' || fileName.charAt (x) == '<' || fileName.charAt (x) == '>' || fileName.charAt (x) == '.')
		{
		    new Message ("Your file name is invalid");
		    saveAns ();
		}
	    }

	    //adds the extention .calc to the file name
	    fileName = fileName + ".calc";
	    try
	    {
		//prints it in a file
		pw = new PrintWriter (new FileWriter (fileName));
		pw.println (header);
		pw.println (equation);
		pw.println (answer);
		pw.close ();
	    }
	    catch (IOException e)
	    {
	    }
	    save = true;
	    exists = false;
	    equation = null; // empties equation
	}


	else
	{
	    //if there is nothing to save
	    new Message ("There is nothing to save right now");
	}
    }




    //main method
    public static void main (String[] args)
    {
	Calculator c = new Calculator ();
	c.splashScreen (); //calls splashScreen
	while (true)
	{
	    c.mainMenu ();
	    //checks if the user has saved or the user is using display for the first time
	    if (choice.equals ("1") & save == false & equation == null || choice.equals ("1") & save == true & equation == null)
	    {
		c.display ();
	    }
	    //checks if the equation is not null and the user has not saved yet
	    else if (choice.equals ("1") & save == false & equation != null)
	    {
		c.pauseProgram ();
		//checks pauseChar
		if (pauseChar == 'e')
		{
		    exists = false;
		    c.display ();
		}
	    }
	    else if (choice.equals ("2"))
	    {
		c.instructions ();
	    }
	    else if (choice.equals ("3"))
	    {
		c.saveAns ();
	    }
	    else if (choice.equals ("4"))
	    {
		c.viewAns ();
	    }
	    else if (choice.equals ("5"))
	    {
		c.goodbye ();
		//if the user hasnt saved, then the pauseProgram will let them know. This checks if the user has pressed e, which will let them exit without saving
		if (pauseChar == 'e' || exists == false)
		{
		    break;
		}
	    }
	    else
	    {
		//alerts the user to enter a valid input
		new Message ("Please enter a valid input");
	    }
	}


	// Place your program here.  'c' is the output console
    } // main method
} // Calculator class


