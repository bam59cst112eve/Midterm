//Midterm 2 code for 59CST112Eve

//My first name is....Ana
//My middle name is....Luisa
//My last name is....Collantes

//first word....apple
//second word....lake
//third word....calm

////Globals for 3 colored balls////


float appleX, appleY, appleDX, appleDY;
float lakeX, lakeY, lakeDX, lakeDY;
float calmX, calmY, calmDX, calmDY;


float horizon;
float x, y;       // Position.
float dx, dy;     // Speed.
float ratX, dratY;



float button1X=100, button1Y=100, button1W=80, button1H=40;
int counter=0;


String title= "CST112 MIDTERM 2 EXAM";

String author= "Ana Collantes";

////Table boundariesfloat left=90, right=480, top=80, bottom=230

float left=50, right=450, top=100, bottom=250;
float middle=250;
boolean wall=true, all=false, rat=false;;

////Green pool table
int tableRed=150, tableGreen=250, tableBlue=150;
int score=0,m=0,k=0;

////other declarations


void setup() {
 ///size of background
size(700, 500);

//Table boundaries
left=115;
right=575;
top=120;
bottom=387;
middle=290;

///Random Positions
  appleX=  random( middle,right );   appleY=  random( top, bottom );
   lakeX=  random( middle,right );   lakeY=  random( top, bottom );
   calmX=  random( middle,right );   calmY=  random( top, bottom );
   // Random speeds
   appleDX=  random( 2,3 );   appleDY=  random( 2,3 );
   lakeDX=  random( 3,4 );   lakeDY=  random( 3,4 );
   calmDX=  random( 2,5 );   calmDY=  random( 2,5 );

}



// void reset() {
  
 

void draw() {
  background(248,201,255);
  rectMode ( CORNERS );
  table( left, top, right, bottom);
  bounce();
 
  show();
  messages();
}


    void showButton( float x, float y, float w, float h) {
  fill(255);
  rect(150, 50, 60, 50);
  
   }
  
  




////Table
void table( float east, float north, float west, float south) {
  ///pool table
  fill( tableRed, tableGreen, tableBlue);
  strokeWeight(20);
  ///brown walls
  stroke(127,0,0);
  rect( east-20, north-20, west+20, south+20);
  
  /////Wall in the middle of the pool table
  if (wall) {
    float middle= (east+west)/2;
    stroke(0,127,0);
    line( middle, north+10, middle, south-10);
  }
  stroke(0);
  strokeWeight(1);
  
  
   if (wall) {
         appleX=  random( 355,right-10 );   appleY=  random( top,bottom );
         lakeX=  random( 355,right-10 );      lakeY=  random( top,bottom );
         calmX=  random( 355,right-10 );     calmY=  random( top,bottom );         
  }else{
         appleX=  random( left+1,right-10 );   appleY=  random( top,bottom );
         lakeX=  random( left+1,right-10 );       lakeY=  random( top,bottom );
         calmX=  random( left+1,right-10 );     calmY=  random( top,bottom );         
  }
  }

  
  /////Bounce off the walls, and collisions
///void bounce
void bounce() {
  appleX += appleDX;  if ( appleX<left || appleX>right ) appleDX *= -1;
  appleY += appleDY;  if ( appleY<top || appleY>bottom ) appleDY *=  -1;

///yellow ball
  lakeX += lakeDX; if ( lakeX<left || lakeX>right ) lakeDX *= -1;
  lakeY += lakeDY; if ( lakeY<top || lakeY>bottom ) lakeDY *= -1;
  
//blue ball
calmX += calmDX; if ( calmX<left || calmX>right ) calmDX *= -1;
calmY += calmDY; if (calmY<top || calmY>bottom ) calmDY *= -1;
}
////collisions
//id collisions() {
  



void show() {
   
  fill( 250,0,0 );    ellipse( appleX,appleY, 30,30 );
  fill( 30,160,245 );  ellipse( lakeX,lakeY, 30,30 );
  fill( 31,80,40 );    ellipse( calmX,calmY, 30,30 );

  /// four black circles
//up--left
fill(0);
ellipse(110, 118, 30, 30);
 //up--right
fill(0);
ellipse(580, 118, 30, 30);
// down--left
fill(0);
ellipse(110,390, 30, 30);
//down--right
fill(0);
ellipse(580, 390, 30, 30);



///reset button
fill(227, 115, 46);
rect(70, 32, 172, 83);
///text on box
fill(0);
text("CLick 'r' to reset", 76, 60);

///button #1
fill(227, 115, 46);
rect(200, 32, 306, 83);
///text on box
fill(0);
text("click 'w' to remove", 201, 52);
text("wall", 240, 70);

/////button#2
fill(227, 115, 46);
rect(335, 32, 435, 83);
///text on box
fill(0);
text("click 'p' for pink", 339, 53);
text("table", 370, 70);

///button#3
fill(227,115,46);
rect(465, 32, 565, 83);
///text on box
fill(0);
text("click 'm' for", 480, 53);
text("animated mouse", 467, 68);
}

///void buttons() {
  
  
  ///messages
 void messages() {
   fill (0);
   text(title, width/3, 15);
   
   text(author, 10, height-5);
   
 }
 ///void balls(){
 void keyPressed() {
 if (key == 'r') {exit(); }
   if (keyPressed && key == 'w') { wall=!wall; }
  if (keyPressed) {
    tableRed= key == 'p' ? 250 : 150;
    tableGreen= key == 'p' ? 150 : 250;
    if (keyPressed && key == 'm') {rat=!rat; }
  
  ///if (key == 'p') {
  // fill(255, 67, 215);

 }  
  }
  
