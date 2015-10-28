

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "William Allen";

float left=50, right=450, top=100, bottom=250;        // Table boundaries
float middle=250;

///Floats
float rightScreen, bottomScreen, leftScreen, topScreen;
float jimX,jimY;
float warX,warY;
float aimX,aimY;
float jimDX,jimDY;
float warDX,warDY;
float aimDX,aimDY;
float temp;
float wallwidth;

boolean wall;

///SetUp
void setup(){
 size(700,500);
  
 rightScreen=width-20;
 bottomScreen=height-60;
 topScreen=100;
 leftScreen=20;
 jimX=random(leftScreen,rightScreen);
 jimY=random(topScreen,bottomScreen);
 warX=random(leftScreen,rightScreen);
 warY=random(topScreen,bottomScreen);
 aimX=random(leftScreen,rightScreen);
 aimY=random(topScreen,bottomScreen);
 jimDX=random(-2,2);
 jimDY=random(-2,2);
 warDX=random(-2,2);
 warDY=random(-2,2);
 aimDX=random(-2,2);
 aimDY=random(-2,2);
 wallwidth=30;
 wall=true;
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
 ///jim ball
fill(250,0,0); 
ellipse(jimX,jimY,30,30);
fill(255);
text("2",jimX,jimY);
///war
fill(0,0,250); 
ellipse(warX,warY,30,30);
fill(255);
text("1",warX,warY);
///aimlow ball
fill(252,255,88); 
ellipse(aimX,aimY,30,30);
fill(0);
text("3",aimX,aimY);
}
///Movement
void movement(){
  aimX += aimDX;
  aimY += aimDY;
  warX += warDX;
  warY += warDY;
  jimX += jimDX;
  jimY += jimDY;
}
///Bounce
void bounce() {
 if(jimX>rightScreen || jimX<leftScreen){
   jimDX*=-1;
 }
 if(jimY>bottomScreen || jimY<topScreen) {
   jimDY*=-1;
 }
   if(warX>rightScreen || warX<leftScreen){
   warDX*=-1;
 }
 if(warY>bottomScreen || warY<topScreen) {
   warDY*=-1;}
   if(aimX>rightScreen || aimX<leftScreen){
   aimDX*=-1;
 }
 if(aimY>bottomScreen || aimY<topScreen) {
   aimDY*=-1;}
}
/// Collisions
void ballcollide() {
 if(dist(jimX,jimY,warX,warY)<30){
   temp=warDX; warDX=jimDX; jimDX=temp;
   temp=warDY; warDY=jimDY; jimDY=temp;
}
if(dist(jimX,jimY,aimX,aimY)<30){
   temp=aimDX; aimDX=jimDX; jimDX=temp;
   temp=aimDY; aimDY=jimDY; jimDY=temp;
}
if(dist(aimX,aimY,warX,warY)<30){
   temp=warDX; warDX=aimDX; aimDX=temp;
   temp=warDY; warDY=aimDY; aimDY=temp;
}}

////WALL
void wall(){
  if(wall == true){fill(254,255,6);
  rect(width/2-wallwidth, topScreen, width/2+wallwidth, bottomScreen);}
}
/// Messages
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );
}

void reset(){
 
 rightScreen=width-20;
 bottomScreen=height-60;
 topScreen=100;
 leftScreen=20;
 jimX=random(leftScreen,rightScreen);
 jimY=random(topScreen,bottomScreen);
 warX=random(leftScreen,rightScreen);
 warY=random(topScreen,bottomScreen);
 aimX=random(leftScreen,rightScreen);
 aimY=random(topScreen,bottomScreen);
 jimDX=random(-2,2);
 jimDY=random(-2,2);
 warDX=random(-2,2);
 warDY=random(-2,2);
 aimDX=random(-2,2);
 aimDY=random(-2,2);
 wall=true;
}

///Handlers: KEYS
void keyPressed() {
  if (key == 'r') {
    reset();
  }
  if (key == 'w') { 
  wall=false;
  }
}
