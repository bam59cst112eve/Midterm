//// Midterm code for 59CST112

/**************************************************************
BE SURE TO CHANGE THE NEXT SEVERAL LINES, USING YOUR REAL NAME.

    MY FIRST NAME IS......Mahmoud
    MY MIDDLE NAME IS.....Medhat
    MY LAST NAME IS.......Mohamed
    
PICK 3 WORDS THAT START WITH YOUR INITIALS, using lower case letters:

    first word............monkey
    second word...........manatine
    third word............maleficent
    
USE THESE 3 WORDS TO NAME ALL VARIABLES FOR 3 POOL BALLS.
(You may abbreviate any words, but start with same letter.)
***************************************************************/


//// GLOBALS FOR 3 colored balls ////
//// (Assume ball diameter is 30.) ////
float monX,  monY,  monDX,  monDY;          //++++ MODIFY THIS.  Don' use "wolf". ++++
float manaX,  manaY,  manaDX,  manaDY;              //++++ MODIFY THIS.  Don' use "ham". ++++
float maleX,  maleY,  maleDX,  maleDY;      //++++ MODIFY THIS.  Don' use "hippo". ++++
            //++++ MODIFY THESE DECLARATIONS -- Do not use "wolf" or "ham" or "hippo" ++++


//// OTHER GLOBALS:  strings, pool table, etc ////

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Mahmoud Mohamed ";

float left=50, right=450, top=100, bottom=250;        // Table boundaries
float middle=50;
boolean wall=true;

int tableRed=150, tableGreen=250, tableBlue=150;      // green pool table
int score=0,m=0,k=0;

    // ADD YOUR OWN DECLARATIONS HERE. ++++


//// SETUP:  size and table
void setup() {
    size( 640, 480 );          //++++ CHANGE THE SIZE -- see instructions! ++++
  
    //// MODIFY THIS CODE TO MAKE TABLE CENTERED IN WINDOW.  ++++

    // Table boundaries
 }
 
  void reset() {
   monX=  random( middle,right );   monY=  random( top, bottom );
   manaX=  random( middle,right );   manaY=  random( top, bottom );
   maleX=  random( middle,right );   maleY=  random( top, bottom );
 
   monDX=  random( 1,3 );   monDY=  random( 1,3 );
   manaDX=  random( 1,3 );   manaDY=  random( 1,3 );
   maleDX=  random( 1,3 );   maleDY=  random( 1,3 );
 }
 
//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250,250,200 );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  buttons();
  bounce();
  collisions();
  show();
  messages();
  reset();
  frameRate(5);
}

void keyPressed() {
  if (key == 'q') { exit();}
  if (keyPressed && key == 'w') { wall=!wall; }
  if (keyPressed) {
    tableRed= key == 'p' ? 250 : 150;
    tableGreen= key == 'p' ? 150 : 250;  }
}

void table( float east, float north, float west, float south ) {
  fill( tableRed, tableGreen, tableBlue );    // pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( east+15, north+60, west+120, south+150 );

 if (wall) {
    float middle=  (east+west)/1.59;    
    stroke( 0, 127, 0 );
    line( middle,north/.48, middle,south+100 );
  }
  stroke(0);
  strokeWeight(1);
}

void bounce() {
  monX += monDX;  if ( monX<left || monX>right ) 
  monDX = -monDX;
  
  monY += monDY;  if ( monY<top || monY>bottom ) 
  monDY =  -monDY;

  manaX += manaDX;  if ( manaX<left || manaX>right ) 
  manaDX = manaDX;
  
  manaY += manaDY;  if ( manaY<top || manaY>bottom ) 
  manaDY =  -manaDY;
   
  maleX += maleDX;  if ( maleX<left || maleX>right ) 
  maleDX = -maleDX;
  maleY += maleDY;  if ( maleY<top || maleY>bottom ) 
  maleDY =  -maleDY;
}

void collisions() {
  float tmp;
  if ( dist( monX,monY, manaX,manaY, maleX,maleY ) < 50 ) {
    tmp=manaDX;  manaDX=monDX;  monDX=tmp;
    tmp=manaDY;  manaDY=monDY;  monDY=tmp;
  }
}

void show() {
  fill( 255,200,255 );    
  ellipse( monX,monY, 30,30 );
  
  fill( 255,180,40 );  
  ellipse( manaX,manaY, 30,30 );
  
  fill( 55,0,255 );    
  ellipse( maleX,maleY, 30,30 );
}

void buttons() {
    //++++ ADD YOUR OWN CODE HERE. ++++
}
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );

  // Also, display the number of collisions.

    //++++ ADD YOUR OWN CODE HERE. ++++

}
