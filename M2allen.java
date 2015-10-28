

String title=  "CST112 MIDTERM EXAM";
String news= "Click any ball to reset it to right half of table. (r resets all.)";
String control= " '1' resets blue, '2' resets red '3' resets yellow";
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
float wallLeft;
float wallRight;
float ballDiameter;

boolean wall;


void reset(){
 
 rightScreen=width-20;
 bottomScreen=height-60;
 topScreen=100;
 leftScreen=20;
 resetJim();
 resetWar();
 resetAim();
 wallwidth=30;
 wall=true;
 wallLeft=(width/2-wallwidth);
 wallRight=(width/2+wallwidth);
 ballDiameter=30;
}

///SetUp
void setup(){
 size(700,500);
  reset();
 
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
ellipse(jimX,jimY,ballDiameter,ballDiameter);
fill(255);
text("2",jimX,jimY);
///war
fill(0,0,250); 
ellipse(warX,warY,ballDiameter,ballDiameter);
fill(255);
text("1",warX,warY);
///aimlow ball
fill(252,255,88); 
ellipse(aimX,aimY,ballDiameter,ballDiameter);
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
 if(wall==true){ 
   if(jimX<wallRight){jimDX*=-1;}
   if(warX<wallRight){warDX*=-1;}
   if(aimX<wallRight){aimDX*=-1;}
 }
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
  rect(wallLeft, topScreen, wallRight, bottomScreen);}
}
/// Messages
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );
  text( control, width/12, 45);
}


///Ball Reset
void resetJim(){
 jimX=random(width/2+wallwidth,rightScreen);
 jimY=random(topScreen,bottomScreen);
 jimDX=random(-2,2);
 jimDY=random(-2,2);
}
void resetWar(){
 warX=random(width/2+wallwidth,rightScreen);
 warY=random(topScreen,bottomScreen); 
 warDX=random(-2,2);
 warDY=random(-2,2);
}
void resetAim(){
 aimX=random(width/2+wallwidth,rightScreen);
 aimY=random(topScreen,bottomScreen);
 aimDX=random(-2,2);
 aimDY=random(-2,2);
}
///Handlers: KEYS
void keyPressed() {
  if (key == 'r') {
    reset();
  }
  if (key == 'w') { 
  wall=false;
  }
   if (key== '1')  {
  resetWar();
  }
  if (key== '2')  {
  resetJim();
  }
   if (key== '3')  {
  resetAim();
  }
  
}

void mousePressed(){
  if(dist(mouseX,mouseY,warX,warY) <ballDiameter/2){
   resetWar();}
 if(dist(mouseX,mouseY,jimX,jimY) <ballDiameter/2){
   resetJim();}
  if(dist(mouseX,mouseY,aimX,aimY) <ballDiameter/2){
   resetAim();}
 
}
