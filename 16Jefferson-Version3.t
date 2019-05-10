%Jefferson
%December 15 2017
%Mr.Rosen
% This is Jefferson's ISP. It is a face creator.
% This program allows you to create a face from many different parts.
% You can choose the styles of many different facial features and colors
% to make your own unique face.

import GUI

forward procedure title
forward procedure mainMenu
forward procedure instructions
forward procedure display

%Declaration section
var button : int %This variable detects if the left mouse button is pressed
var mousex : int %This detects the x coordinates of the mouse
var mousey : int %This detects the y coordinates of the mouse
var quitbtn : int  %This is the quit button in the main menu
var helpbtn : int %this is the instructions button
var menubtn : int %This is the button to go to the main menu
var playGamebtn : int  %This is the play game button in the main menu
var mainWin := Window.Open ("position:260;550, graphics:1000;800")


process introMusic
    Music.PlayFile ("startMusic.wav")
end introMusic

process gameMusic
    Music.PlayFileLoop ("gameMusic.wav")
end gameMusic

procedure goodbye
    title
    locate (15, 47)
    put "Thank You for using the Face Creator"
    locate (17, 45)
    put "This program was created by Jefferson Liu"
    locate (19, 10)
    put "If you want to show your appreciation to the creator of this lovely program, please give him money or snacks."
    locate (21, 60)
    put "Good bye"
    locate (23, 55)
    put "Please play again"

    delay (5000)
    for x : 0 .. 400
	drawfillbox (0, x, 1000, x, 7)
	drawfillbox (0, 800 - x, 1000, 800 - x, 7)
	delay (10)
    end for
    Music.PlayFileStop
    Window.Close (mainWin)
end goodbye

%This is the title
body procedure title
    cls
    locate (1, 50)
    put "Face Creator Program"
end title

body procedure instructions     %These contain the instructions on how to use this program
    title
    GUI.Hide (helpbtn)
    GUI.Hide (quitbtn)
    GUI.Hide (playGamebtn)
    var font1 := Font.New ("serif:16")
    locate (2, 55)
    put "Instructions"
    drawfillbox (50, 700, 200, 650, 53)
    drawbox (50, 700, 200, 650, 7)
    Font.Draw ("Label", 110, 670, font1, 7)
    drawfillbox (50, 650, 100, 600, 15)
    drawbox (50, 650, 100, 600, 7)
    drawfillbox (100, 650, 150, 600, 15)
    drawbox (100, 650, 150, 600, 7)
    drawfillbox (150, 650, 200, 600, 15)
    drawbox (150, 650, 200, 600, 7)
    locatexy (50, 580)
    put "Click on any box "
    locatexy (50, 570)
    put "below a label to "
    locatexy (50, 560)
    put "change the aspects of "
    locatexy (50, 550)
    put "your face."
    locatexy (50, 530)
    put "For example, if the"
    locatexy (50, 520)
    put "label says hair, "
    locatexy (50, 500)
    put "then the boxes below"
    locatexy (50, 490)
    put "change the hair"
    locatexy (350, 500)
    put "This is where your face is displayed."
    locatexy (250, 150)
    put "You must select a face shape to select other options."
    drawbox (250, 200, 750, 700, 7)
    GUI.Show (menubtn) %this is the button to go to the main menu
end instructions

%This contains the animation of the face for the introduction
%There is a face that is drawn and then it slides out of the screen
procedure introduction
    setscreen ("offscreenonly")
    title
    fork introMusic
    drawfilloval (500, 400, 200, 200, 14)
    for x : 0 .. 360
	View.Update
	%This is the circle that makes the outline of the face
	drawarc (500, 400, 200, 200, 0, x, 1)
	delay (4)
    end for
    for x : 0 .. 360
	View.Update
	%This is the right eye
	drawarc (400, 450, 30, 30, 0, x, 1)
	delay (2)
    end for
    for x : 0 .. 360
	View.Update
	%This is the left eye
	drawarc (600, 450, 30, 30, 0, x, 1)
	delay (2)
    end for
    for x : 200 .. 340
	View.Update
	%This is the mouth
	drawarc (500, 350, 100, 50, 200, x, 1)
	delay (4)
    end for
    for x : 0 .. 700
	View.Update
	drawfilloval (500 + x, 400, 201, 201, 0)
	drawfilloval (500 + x, 400, 200, 200, 14)
	drawoval (500 + x, 400, 200, 200, 1)
	drawoval (400 + x, 450, 30, 30, 1)
	drawoval (600 + x, 450, 30, 30, 1)
	drawarc (500 + x, 350, 100, 50, 200, 340, 1)
	delay (5)
    end for
    setscreen ("nooffscreenonly")
    locate (20, 20)
    put "Welcome to the Face Creator Program. This program will help you to create your own unique face"
    menubtn := GUI.CreateButton (700, 100, 0, "Main Menu", mainMenu)     %this is the button to go to the main menu
end introduction

%This is the main menu. It has options to quit, play, or to see the instructions.
body procedure mainMenu
    title
    fork gameMusic
    GUI.Hide (menubtn)

    playGamebtn := GUI.CreateButton (450, 400, 0, "Play", display) %This is the play game button in the main menu
    quitbtn := GUI.CreateButtonFull (450, 300, 0, "Quit", GUI.Quit, 0, '^Q', false)     %This is the quit button in the main menu
    helpbtn := GUI.CreateButton (450, 350, 0, "Instructions", instructions)     %this is the instructions button
    GUI.Show (playGamebtn)
    GUI.Show (helpbtn)
    GUI.Show (quitbtn)
end mainMenu

%This is the display. It contains the game and it is the largest procedure in the program. The display contains the options to change the facial features and the face display area.
body procedure display
    var font := Font.New ("serif:16")
    var skinclr : int := 90
    var prevshape : int := 0 %This saves the previous value of face shape
    var prevhair : int := 0 %This saves the previous value of hair
    var prevnose : int := 0 %This saves the previous value of nose
    var prevear : int := 0  %This saves the previous value of ears
    var preveye : int := 0  %This saves the previous value of eyes
    var prevmth : int := 0  %This saves the previous value of mouth
    var prevbrow : int := 0 %This saves the previous value of eyebrow
    var faceshape : boolean := false

    title
    GUI.Hide (playGamebtn)
    GUI.Hide (helpbtn)
    GUI.Hide (quitbtn)
    drawbox (250, 200, 750, 750, 7) %This is the outline for the face display area
    Text.ColorBack (0)
    locatexy (300, 550)
    put "You must select a face shape to select other options." .. %This is the message that is in the face display area when a face shape is not selected.


    %These contain the labels and the button shapes of their section
    %-------------------------------%
    %This is the hair section
    drawfillbox (50, 700, 200, 650, 53)
    drawbox (50, 700, 200, 650, 7)
    Font.Draw ("Face Shapes", 80, 670, font, 7)
    drawfillbox (50, 650, 100, 600, 15)
    drawbox (50, 650, 100, 600, 7)
    drawfillbox (100, 650, 150, 600, 15)
    drawbox (100, 650, 150, 600, 7)
    drawfillbox (150, 650, 200, 600, 15)
    drawbox (150, 650, 200, 600, 7)
    %-------------------------------%

    %-------------------------------%
    %This is the Face shapes section
    drawfillbox (50, 550, 200, 500, 53)
    drawbox (50, 550, 200, 500, 7)
    Font.Draw ("Hair", 100, 520, font, 7)
    drawfillbox (50, 500, 100, 450, 15)
    drawbox (50, 500, 100, 450, 7)
    drawfillbox (100, 500, 150, 450, 15)
    drawbox (100, 500, 150, 450, 7)
    drawfillbox (150, 500, 200, 450, 15)
    drawbox (150, 500, 200, 450, 7)
    %-------------------------------%

    %-------------------------------%
    %This is the Nose section
    drawfillbox (50, 400, 200, 350, 53)
    drawbox (50, 400, 200, 350, 7)
    Font.Draw ("Nose", 110, 370, font, 7)
    drawfillbox (50, 350, 100, 300, 15)
    drawbox (50, 350, 100, 300, 7)
    drawfillbox (100, 350, 150, 300, 15)
    drawbox (100, 350, 150, 300, 7)
    drawfillbox (150, 350, 200, 300, 15)
    drawbox (150, 350, 200, 300, 7)
    %-------------------------------%

    %-------------------------------%
    %This is the Ears section
    drawfillbox (50, 250, 200, 200, 53)
    drawbox (50, 250, 200, 200, 7)
    Font.Draw ("Ears", 110, 220, font, 7)
    drawfillbox (50, 200, 100, 150, 15)
    drawbox (50, 200, 100, 150, 7)
    drawfillbox (100, 200, 150, 150, 15)
    drawbox (100, 200, 150, 150, 7)
    drawfillbox (150, 200, 200, 150, 15)
    drawbox (150, 200, 200, 150, 7)
    %-------------------------------%

    %-------------------------------%
    %This is the Eyes section
    drawfillbox (250, 150, 400, 100, 53)
    drawbox (250, 150, 400, 100, 7)
    Font.Draw ("Eyes", 290, 120, font, 7)
    drawfillbox (250, 50, 300, 100, 15)
    drawbox (250, 50, 300, 100, 7)
    drawfillbox (300, 50, 350, 100, 15)
    drawbox (300, 50, 350, 100, 7)
    drawfillbox (350, 50, 400, 100, 15)
    drawbox (350, 50, 400, 100, 7)
    %-------------------------------%

    %-------------------------------%
    %This is the Mouth section
    drawfillbox (600, 150, 750, 100, 53)
    drawbox (600, 150, 750, 100, 7)
    Font.Draw ("Mouth", 640, 120, font, 7)
    drawfillbox (600, 50, 650, 100, 15)
    drawbox (600, 50, 650, 100, 7)
    drawfillbox (650, 50, 700, 100, 15)
    drawbox (650, 50, 700, 100, 7)
    drawfillbox (700, 50, 750, 100, 15)
    drawbox (700, 50, 750, 100, 7)
    %-------------------------------%

    %-------------------------------%
    %This is the Eyebrows section
    drawfillbox (800, 400, 950, 350, 53)
    drawbox (800, 400, 950, 350, 7)
    Font.Draw ("Eyebrows", 835, 370, font, 7)
    drawfillbox (800, 300, 850, 350, 15)
    drawbox (800, 300, 850, 350, 7)
    drawfillbox (850, 300, 900, 350, 15)
    drawbox (850, 300, 900, 350, 7)
    drawfillbox (900, 300, 950, 350, 15)
    drawbox (900, 300, 950, 350, 7)
    %-------------------------------%

    %-------------------------------%
    %This is the Skin Colours section
    drawfillbox (800, 700, 950, 650, 53)
    drawbox (800, 700, 950, 650, 7)
    Font.Draw ("Skin Colours", 820, 670, font, 7)

    drawfillbox (800, 650, 850, 600, 91)
    drawbox (800, 650, 850, 600, 7)
    drawfillbox (850, 650, 900, 600, 90)
    drawbox (850, 650, 900, 600, 7)
    drawfillbox (900, 650, 950, 600, 89)
    drawbox (900, 650, 950, 600, 7)

    drawfillbox (800, 600, 850, 550, 88)
    drawbox (800, 600, 850, 550, 7)
    drawfillbox (850, 600, 900, 550, 65)
    drawbox (850, 600, 900, 550, 7)
    drawfillbox (900, 600, 950, 550, 43)
    drawbox (900, 600, 950, 550, 7)

    drawfillbox (800, 550, 850, 500, 67)
    drawbox (800, 550, 850, 500, 7)
    drawfillbox (850, 550, 900, 500, 6)
    drawbox (850, 550, 900, 500, 7)
    drawfillbox (900, 550, 950, 500, 20)
    drawbox (900, 550, 950, 500, 7)

    drawfillbox (800, 500, 850, 450, 102)
    drawbox (800, 500, 850, 450, 7)
    drawfillbox (850, 500, 900, 450, 29)
    drawbox (850, 500, 900, 450, 7)
    drawfillbox (900, 500, 950, 450, 69)
    drawbox (900, 500, 950, 450, 7)
    %-------------------------------%



    %-------------------------------%
    %This is the Menu button
    drawfillbox (800, 250, 950, 150, 12)
    drawbox (800, 250, 950, 150, 7)
    Font.Draw ("Menu", 850, 200, font, 7)
    %-------------------------------%

    %-------------------------------%
    %This is the reset button
    drawfillbox (425, 150, 575, 100, 10)
    drawbox (425, 150, 575, 100, 7)
    Font.Draw ("Reset", 475, 120, font, 7)
    %-------------------------------%

    loop
	View.Update
	%This detects where the mouse is
	mousewhere (mousex, mousey, button)
	if button = 1 then
	    %%%%%%%%%%%%%%%%%%%%%%%%%FACE SHAPES%%%%%%%%%%%%%%%%%%%%%%%%
	    %The face shapes are the base of the face. It is drawn first in every face.
	    %To change the face, the face display area is cleared and then the new face is drawn with the facial features on top.
	    if mousex >= 50 and mousex <= 100 and mousey >= 600 and mousey <= 650 then %This is the face shape box #1
		if prevshape ~= 1 then
		    %Erase
		    drawfillbox (251, 201, 749, 749, 0)
		    %FaceShapes
		    Draw.ThickLine (500, 540, 500, 450, 200, skinclr)
		    drawarc (500, 540, 100, 100, 0, 180, 7)
		    drawarc (500, 450, 100, 100, 180, 0, 7)
		    drawline (400, 550, 400, 440, 7)
		    drawline (600, 550, 600, 440, 7)
		    %Draws the previous ear shape
		    if prevear = 1 then
			drawfillarc (600, 510, 20, 20, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 20, 90, 270, skinclr)
			drawarc (600, 510, 20, 20, 273, 95, 7)
			drawarc (400, 510, 20, 20, 90, 273, 7)
		    elsif prevear = 2 then
			drawfillarc (600, 510, 20, 40, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 40, 90, 270, skinclr)
			drawarc (600, 510, 20, 40, 273, 95, 7)
			drawarc (400, 510, 20, 40, 90, 273, 7)
		    elsif prevear = 3 then
			drawfillarc (600, 510, 15, 50, 270, 100, skinclr)
			drawfillarc (400, 510, 15, 50, 80, 270, skinclr)
			drawarc (600, 510, 15, 50, 270, 100, 7)
			drawarc (400, 510, 15, 50, 80, 270, 7)
		    end if
		    %Draws the previous hair shape
		    if prevhair = 1 then
			drawfillarc (500, 600, 100, 50, 340, 215, 7)
			drawfilloval (400, 550, 10, 55, 7)
			Draw.ThickLine (420, 595, 405, 510, 30, 7)
		    elsif prevhair = 2 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
		    elsif prevhair = 3 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
			drawfilloval (500, 700, 50, 50, 7)
			Draw.ThickLine (450, 687, 550, 687, 5, 53)
		    end if
		    %Draws the previous nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if
		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if
		end if
		faceshape := true
		prevshape := 1
	    elsif mousex >= 100 and mousex <= 150 and mousey >= 600 and mousey <= 650 then %This is the face shape box #2
		if prevshape ~= 2 then
		    %Erase
		    drawfillbox (251, 201, 749, 749, 0)
		    %FaceShapes
		    drawfillarc (500, 450, 101, 150, 180, 360, skinclr)
		    drawfillbox (600, 600, 400, 450, skinclr)
		    drawfillarc (500, 600, 100, 50, 0, 180, skinclr)
		    drawarc (500, 450, 101, 150, 180, 360, 7)
		    drawarc (500, 600, 100, 50, 0, 180, 7)
		    drawline (600, 600, 600, 449, 7)
		    drawline (400, 601, 400, 450, 7)
		    %Draws the previous ear shape
		    if prevear = 1 then
			drawfillarc (600, 510, 20, 20, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 20, 90, 270, skinclr)
			drawarc (600, 510, 20, 20, 273, 95, 7)
			drawarc (400, 510, 20, 20, 90, 273, 7)
		    elsif prevear = 2 then
			drawfillarc (600, 510, 20, 40, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 40, 90, 270, skinclr)
			drawarc (600, 510, 20, 40, 273, 95, 7)
			drawarc (400, 510, 20, 40, 90, 273, 7)
		    elsif prevear = 3 then
			drawfillarc (600, 510, 15, 50, 270, 100, skinclr)
			drawfillarc (400, 510, 15, 50, 80, 270, skinclr)
			drawarc (600, 510, 15, 50, 270, 100, 7)
			drawarc (400, 510, 15, 50, 80, 270, 7)
		    end if
		    %Draws the previous hair shape
		    if prevhair = 1 then
			drawfillarc (500, 600, 100, 50, 340, 215, 7)
			drawfilloval (400, 550, 10, 55, 7)
			Draw.ThickLine (420, 595, 405, 510, 30, 7)
		    elsif prevhair = 2 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
		    elsif prevhair = 3 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
			drawfilloval (500, 700, 50, 50, 7)
			Draw.ThickLine (450, 687, 550, 687, 5, 53)

		    end if
		    %Draws the previous nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if
		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if
		end if
		faceshape := true
		prevshape := 2
	    elsif mousex >= 150 and mousex <= 200 and mousey >= 600 and mousey <= 650 then %This is the face shape box #3
		if prevshape ~= 3 then
		    %Erase
		    drawfillbox (251, 201, 749, 749, 0)
		    %FaceShapes
		    drawfillbox (600, 600, 400, 450, skinclr)
		    drawfillarc (500, 450, 101, 180, 180, 360, skinclr)
		    drawline (600, 600, 400, 600, 7)
		    drawline (600, 600, 600, 450, 7)
		    drawline (400, 600, 400, 450, 7)
		    drawarc (500, 450, 101, 180, 180, 360, 7)
		    %Draws the previous ear shape
		    if prevear = 1 then
			drawfillarc (600, 510, 20, 20, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 20, 90, 270, skinclr)
			drawarc (600, 510, 20, 20, 273, 95, 7)
			drawarc (400, 510, 20, 20, 90, 273, 7)
		    elsif prevear = 2 then
			drawfillarc (600, 510, 20, 40, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 40, 90, 270, skinclr)
			drawarc (600, 510, 20, 40, 273, 95, 7)
			drawarc (400, 510, 20, 40, 90, 273, 7)
		    elsif prevear = 3 then
			drawfillarc (600, 510, 15, 50, 270, 100, skinclr)
			drawfillarc (400, 510, 15, 50, 80, 270, skinclr)
			drawarc (600, 510, 15, 50, 270, 100, 7)
			drawarc (400, 510, 15, 50, 80, 270, 7)
		    end if
		    %Draws the previous hair shape
		    if prevhair = 1 then
			drawfillarc (500, 600, 100, 50, 340, 215, 7)
			drawfilloval (400, 550, 10, 55, 7)
			Draw.ThickLine (420, 595, 405, 510, 30, 7)
		    elsif prevhair = 2 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
		    elsif prevhair = 3 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
			drawfilloval (500, 700, 50, 50, 7)
			Draw.ThickLine (450, 687, 550, 687, 5, 53)

		    end if
		    %Draws the previous nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if
		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if
		end if
		faceshape := true
		prevshape := 3



		%%%%%%%%%%%%%%%%%%%%%%%%%HAIR%%%%%%%%%%%%%%%%%%%%%%%%
		%The erase for the hair works like the face because the hair overlaps with the face. It clears the display area and draws the face with the facial features with a new hairstyle.
	    elsif mousex >= 50 and mousex <= 100 and mousey >= 450 and mousey <= 500 and faceshape = true then %This is the hair box #1
		if prevhair ~= 1 then
		    %Erase
		    drawfillbox (251, 201, 749, 749, 0)
		    %Draws the previous face shape
		    if prevshape = 1 then
			Draw.ThickLine (500, 540, 500, 450, 200, skinclr)
			drawarc (500, 540, 100, 100, 0, 180, 7)
			drawarc (500, 450, 100, 100, 180, 0, 7)
			drawline (400, 550, 400, 440, 7)
			drawline (600, 550, 600, 440, 7)
		    elsif prevshape = 2 then
			drawfillarc (500, 450, 101, 150, 180, 360, skinclr)
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 600, 100, 50, 0, 180, skinclr)
			drawarc (500, 450, 101, 150, 180, 360, 7)
			drawarc (500, 600, 100, 50, 0, 180, 7)
			drawline (600, 600, 600, 449, 7)
			drawline (400, 601, 400, 450, 7)
		    elsif prevshape = 3 then
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 450, 101, 180, 180, 360, skinclr)
			drawline (600, 600, 400, 600, 7)
			drawline (600, 600, 600, 450, 7)
			drawline (400, 600, 400, 450, 7)
			drawarc (500, 450, 101, 180, 180, 360, 7)
		    end if
		    %Draws the previous nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if
		    %Draws the previous ear shape
		    if prevear = 1 then
			drawfillarc (600, 510, 20, 20, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 20, 90, 270, skinclr)
			drawarc (600, 510, 20, 20, 273, 95, 7)
			drawarc (400, 510, 20, 20, 90, 273, 7)
		    elsif prevear = 2 then
			drawfillarc (600, 510, 20, 40, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 40, 90, 270, skinclr)
			drawarc (600, 510, 20, 40, 273, 95, 7)
			drawarc (400, 510, 20, 40, 90, 273, 7)
		    elsif prevear = 3 then
			drawfillarc (600, 510, 15, 50, 270, 100, skinclr)
			drawfillarc (400, 510, 15, 50, 80, 270, skinclr)
			drawarc (600, 510, 15, 50, 270, 100, 7)
			drawarc (400, 510, 15, 50, 80, 270, 7)
		    end if
		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if

		    %Hair
		    drawfillarc (500, 600, 100, 50, 340, 215, 7)
		    drawfilloval (400, 550, 10, 55, 7)
		    Draw.ThickLine (420, 595, 405, 510, 30, 7)
		end if

		prevhair := 1

	    elsif mousex >= 100 and mousex <= 150 and mousey >= 450 and mousey <= 500 and faceshape = true then %This is the hair box #2
		if prevhair ~= 2 then
		    drawfillbox (251, 201, 749, 749, 0)
		    %Draws the previous face shape
		    if prevshape = 1 then
			Draw.ThickLine (500, 540, 500, 450, 200, skinclr)
			drawarc (500, 540, 100, 100, 0, 180, 7)
			drawarc (500, 450, 100, 100, 180, 0, 7)
			drawline (400, 550, 400, 440, 7)
			drawline (600, 550, 600, 440, 7)
		    elsif prevshape = 2 then
			drawfillarc (500, 450, 101, 150, 180, 360, skinclr)
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 600, 100, 50, 0, 180, skinclr)
			drawarc (500, 450, 101, 150, 180, 360, 7)
			drawarc (500, 600, 100, 50, 0, 180, 7)
			drawline (600, 600, 600, 449, 7)
			drawline (400, 601, 400, 450, 7)
		    elsif prevshape = 3 then
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 450, 101, 180, 180, 360, skinclr)
			drawline (600, 600, 400, 600, 7)
			drawline (600, 600, 600, 450, 7)
			drawline (400, 600, 400, 450, 7)
			drawarc (500, 450, 101, 180, 180, 360, 7)
		    end if
		    %Draws the previous nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if
		    %Draws the previous ear shape
		    if prevear = 1 then
			drawfillarc (600, 510, 20, 20, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 20, 90, 270, skinclr)
			drawarc (600, 510, 20, 20, 273, 95, 7)
			drawarc (400, 510, 20, 20, 90, 273, 7)
		    elsif prevear = 2 then
			drawfillarc (600, 510, 20, 40, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 40, 90, 270, skinclr)
			drawarc (600, 510, 20, 40, 273, 95, 7)
			drawarc (400, 510, 20, 40, 90, 273, 7)
		    elsif prevear = 3 then
			drawfillarc (600, 510, 15, 50, 270, 100, skinclr)
			drawfillarc (400, 510, 15, 50, 80, 270, skinclr)
			drawarc (600, 510, 15, 50, 270, 100, 7)
			drawarc (400, 510, 15, 50, 80, 270, 7)
		    end if
		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if
		    %Hair
		    drawfillarc (500, 600, 100, 100, 350, 190, 7)
		end if

		prevhair := 2

	    elsif mousex >= 150 and mousex <= 200 and mousey >= 450 and mousey <= 500 and faceshape = true then %This is the hair box #3
		if prevhair ~= 3 then
		    drawfillbox (251, 201, 749, 749, 0)
		    %Draws previous face shape
		    if prevshape = 1 then
			Draw.ThickLine (500, 540, 500, 450, 200, skinclr)
			drawarc (500, 540, 100, 100, 0, 180, 7)
			drawarc (500, 450, 100, 100, 180, 0, 7)
			drawline (400, 550, 400, 440, 7)
			drawline (600, 550, 600, 440, 7)
		    elsif prevshape = 2 then
			drawfillarc (500, 450, 101, 150, 180, 360, skinclr)
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 600, 100, 50, 0, 180, skinclr)
			drawarc (500, 450, 101, 150, 180, 360, 7)
			drawarc (500, 600, 100, 50, 0, 180, 7)
			drawline (600, 600, 600, 449, 7)
			drawline (400, 601, 400, 450, 7)
		    elsif prevshape = 3 then
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 450, 101, 180, 180, 360, skinclr)
			drawline (600, 600, 400, 600, 7)
			drawline (600, 600, 600, 450, 7)
			drawline (400, 600, 400, 450, 7)
			drawarc (500, 450, 101, 180, 180, 360, 7)
		    end if
		    %Draws previous nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if
		    %Draws previous ear shape
		    if prevear = 1 then
			drawfillarc (600, 510, 20, 20, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 20, 90, 270, skinclr)
			drawarc (600, 510, 20, 20, 273, 95, 7)
			drawarc (400, 510, 20, 20, 90, 273, 7)
		    elsif prevear = 2 then
			drawfillarc (600, 510, 20, 40, 270, 90, skinclr)
			drawfillarc (400, 510, 20, 40, 90, 270, skinclr)
			drawarc (600, 510, 20, 40, 273, 95, 7)
			drawarc (400, 510, 20, 40, 90, 273, 7)
		    elsif prevear = 3 then
			drawfillarc (600, 510, 15, 50, 270, 100, skinclr)
			drawfillarc (400, 510, 15, 50, 80, 270, skinclr)
			drawarc (600, 510, 15, 50, 270, 100, 7)
			drawarc (400, 510, 15, 50, 80, 270, 7)
		    end if
		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if
		    %Hair
		    drawfillarc (500, 600, 100, 100, 350, 190, 7)
		    drawfilloval (500, 700, 50, 50, 7)
		    Draw.ThickLine (450, 687, 550, 687, 5, 53)
		end if


		prevhair := 3



		%%%%%%%%%%%%%%%%%%%%%%%%%NOSE%%%%%%%%%%%%%%%%%%%%%%%%
		%This is the nose section
		%There is one universal erase
	    elsif mousex >= 50 and mousex <= 100 and mousey >= 300 and mousey <= 350 and faceshape = true then
		%Erase
		if prevnose ~= 1 then
		    drawfilloval (500, 460, 20, 30, skinclr)
		end if
		%Nose
		drawoval (500, 460, 20, 30, 7)
		prevnose := 1
	    elsif mousex >= 100 and mousex <= 150 and mousey >= 300 and mousey <= 350 and faceshape = true then
		%Erase
		if prevnose = 1 then
		    drawoval (500, 460, 20, 30, skinclr)
		elsif prevnose = 3 then
		    drawline (500, 480, 510, 460, skinclr)
		    drawline (510, 460, 490, 460, skinclr)
		    drawline (490, 460, 500, 480, skinclr)
		end if
		%Nose
		drawarc (490, 450, 5, 5, 90, 0, 7)
		drawarc (510, 450, 5, 5, 180, 90, 7)
		drawarc (500, 460, 10, 20, -20, 200, 7)
		drawline (495, 450, 505, 450, 7)
		drawdot (491, 453, 7)
		prevnose := 2

	    elsif mousex >= 150 and mousex <= 200 and mousey >= 300 and mousey <= 350 and faceshape = true then
		%Erase
		if prevnose ~= 2 then
		    drawfilloval (500, 460, 20, 30, skinclr)
		end if

		%Nose
		drawline (500, 480, 510, 460, 7)
		drawline (510, 460, 490, 460, 7)
		drawline (490, 460, 500, 480, 7)
		prevnose := 3


		%%%%%%%%%%%%%%%%%%%%%%%%%EARS%%%%%%%%%%%%%%%%%%%%%%%%
		%This is the Ear section
	    elsif mousex >= 50 and mousex <= 100 and mousey >= 150 and mousey <= 200 and faceshape = true then
		%Erase
		if prevear ~= 1 then
		    drawfillbox (251, 201, 749, 749, 0)
		    %Draws the previous face shape
		    if prevshape = 1 then
			Draw.ThickLine (500, 540, 500, 450, 200, skinclr)
			drawarc (500, 540, 100, 100, 0, 180, 7)
			drawarc (500, 450, 100, 100, 180, 0, 7)
			drawline (400, 550, 400, 440, 7)
			drawline (600, 550, 600, 440, 7)
		    elsif prevshape = 2 then
			drawfillarc (500, 450, 101, 150, 180, 360, skinclr)
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 600, 100, 50, 0, 180, skinclr)
			drawarc (500, 450, 101, 150, 180, 360, 7)
			drawarc (500, 600, 100, 50, 0, 180, 7)
			drawline (600, 600, 600, 449, 7)
			drawline (400, 601, 400, 450, 7)
		    elsif prevshape = 3 then
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 450, 101, 180, 180, 360, skinclr)
			drawline (600, 600, 400, 600, 7)
			drawline (600, 600, 600, 450, 7)
			drawline (400, 600, 400, 450, 7)
			drawarc (500, 450, 101, 180, 180, 360, 7)
		    end if

		    %Ears
		    drawfillarc (600, 510, 20, 20, 270, 90, skinclr)
		    drawfillarc (400, 510, 20, 20, 90, 270, skinclr)
		    drawarc (600, 510, 20, 20, 273, 95, 7)
		    drawarc (400, 510, 20, 20, 90, 273, 7)

		    %Draws the previous hair shape
		    if prevhair = 1 then
			drawfillarc (500, 600, 100, 50, 340, 215, 7)
			drawfilloval (400, 550, 10, 55, 7)
			Draw.ThickLine (420, 595, 405, 510, 30, 7)
		    elsif prevhair = 2 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
		    elsif prevhair = 3 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
			drawfilloval (500, 700, 50, 50, 7)
			Draw.ThickLine (450, 687, 550, 687, 5, 53)

		    end if

		    %Draws the nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if
		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if
		end if


		prevear := 1

	    elsif mousex >= 100 and mousex <= 150 and mousey >= 150 and mousey <= 200 and faceshape = true then
		%Erase
		if prevear ~= 2 then
		    drawfillbox (251, 201, 749, 749, 0)

		    %Draws the previous face shape
		    if prevshape = 1 then
			Draw.ThickLine (500, 540, 500, 450, 200, skinclr)
			drawarc (500, 540, 100, 100, 0, 180, 7)
			drawarc (500, 450, 100, 100, 180, 0, 7)
			drawline (400, 550, 400, 440, 7)
			drawline (600, 550, 600, 440, 7)
		    elsif prevshape = 2 then
			drawfillarc (500, 450, 101, 150, 180, 360, skinclr)
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 600, 100, 50, 0, 180, skinclr)
			drawarc (500, 450, 101, 150, 180, 360, 7)
			drawarc (500, 600, 100, 50, 0, 180, 7)
			drawline (600, 600, 600, 449, 7)
			drawline (400, 601, 400, 450, 7)
		    elsif prevshape = 3 then
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 450, 101, 180, 180, 360, skinclr)
			drawline (600, 600, 400, 600, 7)
			drawline (600, 600, 600, 450, 7)
			drawline (400, 600, 400, 450, 7)
			drawarc (500, 450, 101, 180, 180, 360, 7)
		    end if

		    %Ears
		    drawfillarc (600, 510, 20, 30, 270, 90, skinclr)
		    drawfillarc (400, 510, 20, 30, 90, 270, skinclr)
		    drawarc (600, 510, 20, 30, 273, 95, 7)
		    drawarc (400, 510, 20, 30, 90, 273, 7)

		    %Draws the previous hair shape
		    if prevhair = 1 then
			drawfillarc (500, 600, 100, 50, 340, 215, 7)
			drawfilloval (400, 550, 10, 55, 7)
			Draw.ThickLine (420, 595, 405, 510, 30, 7)
		    elsif prevhair = 2 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
		    elsif prevhair = 3 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
			drawfilloval (500, 700, 50, 50, 7)
			Draw.ThickLine (450, 687, 550, 687, 5, 53)

		    end if

		    %Draws the nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if
		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if
		end if


		prevear := 2
	    elsif mousex >= 150 and mousex <= 200 and mousey >= 150 and mousey <= 200 and faceshape = true then
		%Erase
		if prevear ~= 3 then
		    drawfillbox (251, 201, 749, 749, 0)
		    %Draws the previous face shape
		    if prevshape = 1 then
			Draw.ThickLine (500, 540, 500, 450, 200, skinclr)
			drawarc (500, 540, 100, 100, 0, 180, 7)
			drawarc (500, 450, 100, 100, 180, 0, 7)
			drawline (400, 550, 400, 440, 7)
			drawline (600, 550, 600, 440, 7)
		    elsif prevshape = 2 then
			drawfillarc (500, 450, 101, 150, 180, 360, skinclr)
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 600, 100, 50, 0, 180, skinclr)
			drawarc (500, 450, 101, 150, 180, 360, 7)
			drawarc (500, 600, 100, 50, 0, 180, 7)
			drawline (600, 600, 600, 449, 7)
			drawline (400, 601, 400, 450, 7)
		    elsif prevshape = 3 then
			drawfillbox (600, 600, 400, 450, skinclr)
			drawfillarc (500, 450, 101, 180, 180, 360, skinclr)
			drawline (600, 600, 400, 600, 7)
			drawline (600, 600, 600, 450, 7)
			drawline (400, 600, 400, 450, 7)
			drawarc (500, 450, 101, 180, 180, 360, 7)
		    end if

		    %Ears
		    drawfillarc (600, 510, 15, 50, 270, 100, skinclr)
		    drawfillarc (400, 510, 15, 50, 80, 270, skinclr)
		    drawarc (600, 510, 15, 50, 270, 100, 7)
		    drawarc (400, 510, 15, 50, 80, 270, 7)

		    %Draws the previous hair shape
		    if prevhair = 1 then
			drawfillarc (500, 600, 100, 50, 340, 215, 7)
			drawfilloval (400, 550, 10, 55, 7)
			Draw.ThickLine (420, 595, 405, 510, 30, 7)
		    elsif prevhair = 2 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
		    elsif prevhair = 3 then
			drawfillarc (500, 600, 100, 100, 350, 190, 7)
			drawfilloval (500, 700, 50, 50, 7)
			Draw.ThickLine (450, 687, 550, 687, 5, 53)

		    end if

		    %Draws the previous nose shape
		    if prevnose = 1 then
			drawoval (500, 460, 20, 30, 7)
		    elsif prevnose = 2 then
			drawarc (490, 450, 5, 5, 90, 0, 7)
			drawarc (510, 450, 5, 5, 180, 90, 7)
			drawarc (500, 460, 10, 20, -20, 200, 7)
			drawline (495, 450, 505, 450, 7)
			drawdot (491, 453, 7)
		    elsif prevnose = 3 then
			drawline (500, 480, 510, 460, 7)
			drawline (510, 460, 490, 460, 7)
			drawline (490, 460, 500, 480, 7)
		    end if

		    %Draws the previous eye shape
		    if preveye = 1 then
			%Left eye
			drawfilloval (450, 500, 20, 15, 0)
			drawoval (450, 500, 20, 15, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 20, 15, 0)
			drawoval (550, 500, 20, 15, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 2 then
			%Left eye
			drawfilloval (450, 500, 30, 10, 0)
			drawoval (450, 500, 30, 10, 7)
			drawfilloval (450, 500, 5, 5, 7)
			%Right eye
			drawfilloval (550, 500, 30, 10, 0)
			drawoval (550, 500, 30, 10, 7)
			drawfilloval (550, 500, 5, 5, 7)
		    elsif preveye = 3 then
			%Left eye
			drawfilloval (450, 500, 25, 25, 0)
			drawoval (450, 500, 25, 25, 7)
			drawfilloval (450, 500, 10, 10, 7)
			%Right eye
			drawfilloval (550, 500, 25, 25, 0)
			drawoval (550, 500, 25, 25, 7)
			drawfilloval (550, 500, 10, 10, 7)
		    end if
		    %Draws the previous mouth shape
		    if prevmth = 1 then
			%This is the mouth
			drawfillarc (500, 400, 50, 20, 180, 0, 4)
			%This is the teeth
			drawfillbox (480, 400, 520, 390, 0)
			drawline (500, 400, 500, 390, 7)
			drawarc (500, 400, 50, 20, 180, 0, 7)
			drawline (450, 400, 550, 400, 7)
		    elsif prevmth = 2 then
			drawfilloval (500, 400, 30, 20, 12)
			drawfilloval (500, 400, 25, 10, 4)
			drawoval (500, 400, 31, 20, 7)
		    elsif prevmth = 3 then
			drawfillarc (500, 400, 50, 15, 180, 0, 4)
			drawfilloval (480, 400, 30, 10, 4)
			drawfilloval (520, 400, 30, 10, 4)
			drawarc (500, 400, 50, 15, 180, 0, 7)
			drawarc (520, 400, 30, 10, 0, 135, 7)
			drawarc (480, 400, 30, 10, 45, 180, 7)
			drawdot (499, 407, 4)
			Draw.ThickLine (450, 400, 550, 400, 2, 7)
		    end if
		    %Draws the previous eyebrow shape
		    if prevbrow = 1 then
			%Left eyebrow
			drawfillarc (450, 530, 15, 5, 0, 180, 7)
			drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 15, 5, 0, 180, 7)
			drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
			prevbrow := 1
		    elsif prevbrow = 2 then
			%Left eyebrow
			drawfillarc (450, 530, 25, 10, 0, 180, 7)
			drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

			%Right eyebrow
			drawfillarc (550, 530, 25, 10, 0, 180, 7)
			drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
			prevbrow := 2
		    elsif prevbrow = 3 then
			%Left eyebrow
			Draw.ThickLine (450, 540, 470, 520, 6, 7)

			%Right eyebrow
			Draw.ThickLine (550, 540, 530, 520, 6, 7)
			prevbrow := 3
		    end if

		end if


		prevear := 3


		%%%%%%%%%%%%%%%%%%%EYES%%%%%%%%%%%%%%%%%%%%%%%%
	    elsif mousex >= 250 and mousex <= 300 and mousey >= 50 and mousey <= 100 and faceshape = true then
		%Erase
		if preveye ~= 1 then
		    %Left eye
		    drawfilloval (450, 500, 31, 25, skinclr)

		    %Right eye
		    drawfilloval (550, 500, 31, 25, skinclr)

		    %This draws the eyes
		    %Left eye
		    drawfilloval (450, 500, 20, 15, 0)
		    drawoval (450, 500, 20, 15, 7)
		    drawfilloval (450, 500, 5, 5, 7)

		    %Right eye
		    drawfilloval (550, 500, 20, 15, 0)
		    drawoval (550, 500, 20, 15, 7)
		    drawfilloval (550, 500, 5, 5, 7)
		end if


		preveye := 1

	    elsif mousex >= 300 and mousex <= 350 and mousey >= 50 and mousey <= 100 and faceshape = true then
		%Erase
		if preveye ~= 2 then
		    %Left eye
		    drawfilloval (450, 500, 31, 25, skinclr)

		    %Right eye
		    drawfilloval (550, 500, 31, 25, skinclr)

		    %This draws the eyes
		    %Left eye
		    drawfilloval (450, 500, 30, 10, 0)
		    drawoval (450, 500, 30, 10, 7)
		    drawfilloval (450, 500, 5, 5, 7)

		    %Right eye
		    drawfilloval (550, 500, 30, 10, 0)
		    drawoval (550, 500, 30, 10, 7)
		    drawfilloval (550, 500, 5, 5, 7)
		end if


		preveye := 2

	    elsif mousex >= 350 and mousex <= 400 and mousey >= 50 and mousey <= 100 and faceshape = true then
		%Erase
		if preveye ~= 3 then
		    %Left eye
		    drawfilloval (450, 500, 31, 25, skinclr)

		    %Right eye
		    drawfilloval (550, 500, 31, 25, skinclr)

		    %This draws the eyes
		    %Left eye
		    drawfilloval (450, 500, 25, 25, 0)
		    drawoval (450, 500, 25, 25, 7)
		    drawfilloval (450, 500, 10, 10, 7)

		    %Right eye
		    drawfilloval (550, 500, 25, 25, 0)
		    drawoval (550, 500, 25, 25, 7)
		    drawfilloval (550, 500, 10, 10, 7)
		end if


		preveye := 3



		%%%%%%%%%%%%%%%%%%MOUTH%%%%%%%%%%%%%%%%%%
	    elsif mousex >= 600 and mousex <= 650 and mousey >= 50 and mousey <= 100 and faceshape = true then
		if prevmth ~= 1 then
		    %This is the erase
		    drawfilloval (500, 400, 51, 21, skinclr)
		    %This is the mouth
		    drawfillarc (500, 400, 50, 20, 180, 0, 4)
		    %This is the teeth
		    drawfillbox (480, 400, 520, 390, 0)
		    drawline (500, 400, 500, 390, 7)
		    drawarc (500, 400, 50, 20, 180, 0, 7)
		    drawline (450, 400, 550, 400, 7)
		end if

		prevmth := 1

	    elsif mousex >= 650 and mousex <= 700 and mousey >= 50 and mousey <= 100 and faceshape = true then
		if prevmth ~= 2 then
		    %This is the erase
		    drawfilloval (500, 400, 51, 21, skinclr)
		    %This is the mouth
		    drawfilloval (500, 400, 30, 20, 12)
		    drawfilloval (500, 400, 25, 10, 4)
		    drawoval (500, 400, 31, 20, 7)
		end if

		prevmth := 2

	    elsif mousex >= 700 and mousex <= 750 and mousey >= 50 and mousey <= 100 and faceshape = true then
		if prevmth ~= 3 then
		    %This is the erase
		    drawfilloval (500, 400, 51, 21, skinclr)
		    %This is the mouth
		    drawfillarc (500, 400, 50, 15, 180, 0, 4)
		    drawfilloval (480, 400, 30, 10, 4)
		    drawfilloval (520, 400, 30, 10, 4)
		    drawarc (500, 400, 50, 15, 180, 0, 7)
		    drawarc (520, 400, 30, 10, 0, 135, 7)
		    drawarc (480, 400, 30, 10, 45, 180, 7)
		    drawdot (499, 407, 4)
		    Draw.ThickLine (450, 400, 550, 400, 2, 7)
		end if

		prevmth := 3



		%%%%%%%%%%%%%%%%EYEBROWS%%%%%%%%%%%%%%%%%
	    elsif mousex >= 800 and mousex <= 850 and mousey >= 300 and mousey <= 350 and faceshape = true then
		if prevbrow = 3 then
		    %Left eyebrow
		    Draw.ThickLine (450, 540, 470, 520, 6, skinclr)

		    %Right eyebrow
		    Draw.ThickLine (550, 540, 530, 520, 6, skinclr)
		elsif prevbrow ~= 1 then
		    %Left eyebrow
		    drawfillarc (450, 530, 25, 10, 0, 180, skinclr)

		    %Right eyebrow
		    drawfillarc (550, 530, 25, 10, 0, 180, skinclr)
		end if

		%Left eyebrow
		drawfillarc (450, 530, 15, 5, 0, 180, 7)
		drawfillarc (450, 530, 15, 2, 0, 180, skinclr)

		%Right eyebrow
		drawfillarc (550, 530, 15, 5, 0, 180, 7)
		drawfillarc (550, 530, 15, 2, 0, 180, skinclr)
		prevbrow := 1

	    elsif mousex >= 850 and mousex <= 900 and mousey >= 300 and mousey <= 350 and faceshape = true then
		if prevbrow = 3 then
		    %Left eyebrow
		    Draw.ThickLine (450, 540, 470, 520, 6, skinclr)

		    %Right eyebrow
		    Draw.ThickLine (550, 540, 530, 520, 6, skinclr)
		elsif prevbrow ~= 2 then
		    %Left eyebrow
		    drawfillarc (450, 530, 25, 10, 0, 180, skinclr)

		    %Right eyebrow
		    drawfillarc (550, 530, 25, 10, 0, 180, skinclr)
		end if

		%Left eyebrow
		drawfillarc (450, 530, 25, 10, 0, 180, 7)
		drawfillarc (450, 530, 20, 5, 0, 180, skinclr)

		%Right eyebrow
		drawfillarc (550, 530, 25, 10, 0, 180, 7)
		drawfillarc (550, 530, 20, 5, 0, 180, skinclr)
		prevbrow := 2

	    elsif mousex >= 900 and mousex <= 950 and mousey >= 300 and mousey <= 350 and faceshape = true then
		if prevbrow ~= 3 then
		    %Left eyebrow
		    drawfillarc (450, 530, 25, 10, 0, 180, skinclr)

		    %Right eyebrow
		    drawfillarc (550, 530, 25, 10, 0, 180, skinclr)
		end if

		%Left eyebrow
		Draw.ThickLine (450, 540, 470, 520, 6, 7)

		%Right eyebrow
		Draw.ThickLine (550, 540, 530, 520, 6, 7)
		prevbrow := 3



		%%%%%%%%%%%%%%%%SKIN COLORS%%%%%%%%%%%%%%
	    elsif mousex >= 800 and mousex <= 850 and mousey >= 600 and mousey <= 650 and faceshape = true then
		skinclr := 91
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 850 and mousex <= 900 and mousey >= 600 and mousey <= 650 and faceshape = true then
		skinclr := 90
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 900 and mousex <= 950 and mousey >= 600 and mousey <= 650 and faceshape = true then
		skinclr := 89
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 800 and mousex <= 850 and mousey >= 550 and mousey <= 600 and faceshape = true then
		skinclr := 88
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 850 and mousex <= 900 and mousey >= 550 and mousey <= 600 and faceshape = true then
		skinclr := 65
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 900 and mousex <= 950 and mousey >= 550 and mousey <= 600 and faceshape = true then
		skinclr := 43
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 800 and mousex <= 850 and mousey >= 500 and mousey <= 550 and faceshape = true then
		skinclr := 67
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 850 and mousex <= 900 and mousey >= 500 and mousey <= 550 and faceshape = true then
		skinclr := 6
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 900 and mousex <= 950 and mousey >= 500 and mousey <= 550 and faceshape = true then
		skinclr := 20
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 800 and mousex <= 850 and mousey >= 450 and mousey <= 500 and faceshape = true then
		skinclr := 102
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 850 and mousex <= 900 and mousey >= 450 and mousey <= 500 and faceshape = true then
		skinclr := 29
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
	    elsif mousex >= 900 and mousex <= 950 and mousey >= 450 and mousey <= 500 and faceshape = true then
		skinclr := 69
		drawfill (500, 461, skinclr, 7)
		drawfill (500, 500, skinclr, 7)
		%%%%%%%%%%%%%%%%RESET%%%%%%%%%%%%%%%%%
	    elsif mousex >= 425 and mousex <= 575 and mousey >= 100 and mousey <= 150 and faceshape = true then
		display
		drawfillbox (251, 201, 749, 749, 0)
		locatexy (300, 550)
		put "You must select a face shape to select other options." ..


		%%%%%%%%%%%%%%%%MAINMENU%%%%%%%%%%%%%%%%%
	    elsif mousex >= 800 and mousex <= 950 and mousey >= 150 and mousey <= 250 then         %Main Menu
		exit
	    end if
	end if
    end loop
    mainMenu
end display

introduction
loop
    exit when GUI.ProcessEvent
end loop
goodbye
