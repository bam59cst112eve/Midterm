

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "William Allen";

float left=50, right=450, top=100, bottom=250;        // Table boundaries
float middle=250;

///Floats
float rightScreen, bottomScreen, leftScreen, topScreen;
float redX,redY;
float blueX,blueY;
float yelX,yelY;
float redDX,redDY;
float blueDX,blueDY;
float yelDX,yelDY;
float temp;

///SetUp
void setup(){
 size(600,480);
  
 rightScreen=width-20;
 bottomScreen=height-60;
 topScreen=100;
 leftScreen=20;
 redX=random(leftScreen,rightScreen);
 redY=random(topScreen,bottomScreen);
 blueX=random(leftScreen,rightScreen);
 blueY=random(topScreen,bottomScreen);
 yelX=random(leftScreen,rightScreen);
 yelY=random(topScreen,bottomScreen);
 redDX=random(-2,2);
 redDY=random(-2,2);
 blueDX=random(-2,2);
 blueDY=random(-2,2);
 yelDX=random(-2,2);
 yelDY=random(-2,2);
 
}

void draw(){
 background(254,255,5);
 ///Pool Table
fill(232,165,19);
rectMode(CORNERS);
strokeWeight(15);
rect(leftScreen,topScreen,rightScreen,bottomScreen);
strokeWeight(2);
balls();
movement();
bounce();
ballcollide();
wall();
messages();


}


void balls(){
 ///red ball
fill(250,0,0); 
ellipse(redX,redY,30,30);
///blue
fill(0,0,250); 
ellipse(blueX,blueY,30,30);
///yellow ball
fill(252,255,88); 
ellipse(yelX,yelY,30,30);
}
///Movement
void movement(){
  yelX += yelDX;
  yelY += yelDY;
  blueX += blueDX;
  blueY += blueDY;
  redX += redDX;
  redY += redDY;
}
///Bounce
void bounce() {
 if(redX>rightScreen || redX<leftScreen){
   redDX*=-1;
 }
 if(redY>bottomScreen || redY<topScreen) {
   redDY*=-1;
 }
   if(blueX>rightScreen || blueX<leftScreen){
   blueDX*=-1;
 }
 if(blueY>bottomScreen || blueY<topScreen) {
   blueDY*=-1;}
   if(yelX>rightScreen || yelX<leftScreen){
   yelDX*=-1;
 }
 if(yelY>bottomScreen || yelY<topScreen) {
   yelDY*=-1;}
}
/// Collisions
void ballcollide() {
 if(dist(redX,redY,blueX,blueY)<30){
   temp=blueDX; blueDX=redDX; redDX=temp;
   temp=blueDY; blueDY=redDY; redDY=temp;
}
if(dist(redX,redY,yelX,yelY)<30){
   temp=yelDX; yelDX=redDX; redDX=temp;
   temp=yelDY; yelDY=redDY; redDY=temp;
}
if(dist(yelX,yelY,blueX,blueY)<30){
   temp=blueDX; blueDX=yelDX; yelDX=temp;
   temp=blueDY; blueDY=yelDY; yelDY=temp;
}}

void wall(){
  rect(200,440,300,50);
}
/// Messages
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );
}



///Handlers: KEYS
void keyPressed() {
  if (key == 'r') {
    
  }
}
