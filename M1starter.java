/// Midterm Exam M2
//// (Assume ball diameter of 30.)

//// GLOBALS:  pool table, 3 colored balls

String title=  "cst112 Midterm Exam";
String news=   " Click any ball to reset it to right half of table. (r resets all)"; 
String news2=    " press W to remove wall and E to put it back. press Q to Quit";           
String author=  "Brian Salaway";
float left, right, top, bottom;
float button1X=left+50, button1H=top+25,  button1W=left+100, button1Y=top+50;/////pink button
float button2X= left+125, button2H=top+25, button2W=left+175, button2Y=top+50; /////wall button
float button3X=left+525, button3H=top+25, button3W=left+575, button3Y=top+50; //////rat button
float button4X=left+625, button4H=top+25, button4W=left+675, button4Y=top+50;//////reset button



float middle= width/2;
boolean wall=true;


//////balls 
float boardX,  boardY,  boardDX,  boardDY;
float penX,  penY,  penDX,  penDY;
float sailX, sailY, sailDX, sailDY;
float ratX, ratY, ratDX, ratDY;
float l;
float m;
float n;
int r,g,b;


//// SETUP:  size and table
void setup() {
  size( 700, 500 );
  left=   50;
  right=  width-50;
  top=    100;
  bottom= height-50;
  middle= left + (right-left) / 2;
    
  reset();
 }
 
 void reset() {
   {
  r=  100;
  g=  250;
  b=  100;
  
  // Random positions of balls and rat
   boardX=  random( width/2 ,right );   boardY=  random( top, bottom );
   penX=  random( width/2,right );   penY=  random( top, bottom );
   sailX=  random( width/2,right );   sailY=  random( top, bottom );
   ratX= left;       ratY= bottom;            
   // Random speeds
   boardDX=  random( 1,3 );   boardDY=  random( 1,3 );
   penDX=  random( 1,3 );   penDY=  random( 1,3 );
   sailDX=  random( 1,3 );   sailDY=  random( 1,3 );
   ratDX= (0);      ratDY= (0); 
 }
 
 }
 
//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
{
 

 background( r,g,b );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  bounce();
  collisions();
  show();
  messages();
} 
}
//// SCENE:  draw the table with walls
void table( float left, float top, float right, float bottom ) {
  fill( r, g, b );    // green pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( left-20, top-20, right+20, bottom+20 );
  
 ////////////////////////////buttons
  strokeWeight(0); 
    fill (0);
  rect(button1X, button1Y, button1W, button1H); /////////pink button
  fill(240, 128,128);
  text("Pink", button1X+10, button1Y-10);
fill(0);  
  rect(button2X, button2Y, button2W, button2H);///////////wall button
  fill(255);
  text("wall", button2X+10, button2Y-10);
  fill(0);
   rect(button3X, button3Y, button3W, button3H);///////////rat button
  fill(255);
  text("rat", button3X+10, button3Y-10);
  fill(0);
  rect(button4X, button4Y, button4W, button4H);///////////rat button
fill(255);
text("reset", button4X+10, button4Y-10);
fill(0);
  
  
  
 if (wall){
  float middle=(left+right)/2;
  stroke(0,127,0);
  strokeWeight (20);
  line (middle, top+10, middle, bottom-10);} else {middle=left;}

if (wall){
   middle=(left+right)/2;} 
  
}

//// ACTION:  bounce off walls, collisions
void bounce() {
  boardX += boardDX;  if ( boardX<middle+10 || boardX>right ) boardDX *= -1;
  boardY += boardDY;  if ( boardY<top || boardY>bottom ) boardDY *=  -1;

  penX += penDX;  if ( penX<middle+10 || penX>right ) penDX *= -1;
  penY += penDY;  if ( penY<top || penY>bottom ) penDY *=  -1;
  
  sailX += sailDX;  if ( sailX<middle+10 || sailX>right ) sailDX *= -1;
  sailY += sailDY;  if ( sailY<top || sailY>bottom ) sailDY *=  -1;

  ratX += ratDX;  
  
}
 void collisions() {
  float tmp;
  // Swap velocities!
  if ( dist( boardX,boardY, penX,penY ) < 30 ) {
    tmp=penDX;  penDX=boardDX;  boardDX=tmp;
    tmp=penDY;  penDY=boardDY;  boardDY=tmp;}
    
  if ( dist( sailX,sailY, penX,penY ) < 30 ) {
    tmp=penDX;  penDX=sailDX;  sailDX=tmp;
    tmp=penDY;  penDY=sailDY;  sailDY=tmp;}
    
      
      if ( dist( boardX,boardY, sailX,sailY ) < 30 ) {
    tmp=sailDX;  sailDX=boardDX;  boardDX=tmp;
    tmp=sailDY;  sailDY=boardDY;  boardDY=tmp;}   
     
} 
//// SHOW:  balls, rat, and  messages
void show() {
  {
    stroke(0);
  strokeWeight(1);
 
 fill( 255,0,0 );    
  ellipse( boardX,boardY, 30,30 );  
  fill(0);  
   text( "B", boardX,boardY );
       
  fill( 255,255,0 );  
  ellipse( penX,penY, 30,30 );
   fill(0);
   text( "P", penX,penY );
   
  fill( 0,0,255 );    
  ellipse( sailX,sailY, 30,30 );
   fill(0);
   text( "S", sailX,sailY );   
  }
 
  //////rat
 if(frameCount %30>15){l=(ratY-10);}else{l=(ratY+10);}
   if(frameCount %30>15){m=(ratX+20);}else{m=(ratX-50);}
   if(frameCount %30>15){n=(ratX+30);}else{m=(ratX-20);}
 fill(150);
  ellipse (ratX, ratY, 50, 50);
  ellipse (ratX, ratY-25, 30,30);
  triangle(ratX-5, ratY-35, ratX+2, ratY-50, ratX+5, ratY-35);
  fill(0);
  ellipse(ratX+8, ratY-30, 5,5);
  line(ratX, ratY, ratX+30, l);
  line(ratX-15, ratY+15, ratX-50, ratY+30);
  strokeWeight(10);
  line (ratX, ratY+10, m, ratY+30);
  line(ratX, ratY+10, n, ratY+30);
  
 
  
  }


void messages() {
  fill(0);
  text( title, width/3, 20 );
  text( news, width/4, 35 );
  text(news2, width/4,45);
  text( author, 10, height-10 );
}
//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'r') {
    reset();
  }
  if(key=='w') { wall=false;} 
  if (key=='e') { wall=true;}
  if (key=='p') {r=240; g=128; b=128; }   // pink pool table
  if (key =='q') {exit ();}
}

  
  void mousePressed(){ //////resetting balls to right side
   if ((boardX -15) < mouseX && mouseX <= (boardX+15)) { 
        boardX=  random( width/2 ,right );   boardY=  random( top, bottom );
      
   }  
     if ((penX -15) < mouseX && mouseX <= (penX+15)) { 
        penX=  random( width/2 ,right );   penY=  random( top, bottom );
   }
   
   if ((sailX -15) < mouseX && mouseX <= (sailX+15)) { 
        sailX=  random( width/2 ,right );   sailY=  random( top, bottom );
    
   }  ///////buttons
   ////////turning table pink
  if (  mouseX >= button1X && mouseX <=  button1W 
 && mouseY >= button1H && mouseY <= button1Y) {r=240; g=128; b=128; }
 ////////removing wall
 if (  mouseX >= button2X && mouseX <=  button2W 
 && mouseY >= button2H && mouseY <= button2Y)   {wall=false;}
  
  ///////get rat moving
  if (  mouseX >= button3X && mouseX <=  button3W 
 && mouseY >= button3H && mouseY <= button3Y)   {ratDX=(1);}
 //////reset
 if (  mouseX >= button4X && mouseX <=  button4W 
 && mouseY >= button4H && mouseY <= button4Y)    {
    reset(); wall=true;
  }
  }

