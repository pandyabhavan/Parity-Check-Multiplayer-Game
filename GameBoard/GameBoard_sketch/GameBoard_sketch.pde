
 
void setup() {
  size(800, 800);
  background(255,255,153);
  noLoop(); 
}
 
void draw() {
  
  int BLOCKX; 
  int BLOCKY; 
  int lengthOfBoard = 1;
  int level = 1;
  int d =1;
  level = int (random(1,5));
  switch (level)
  {
    case 1:
    lengthOfBoard = 5;
    d = 5;
    break;
    case 2:
    lengthOfBoard = 5;
    d = 3;
    break;
    case 3:
    lengthOfBoard = 7;
    d = 5;
    break;
    case 4:
    lengthOfBoard = 7;
    d = 3;
    break;
    case 5:
    lengthOfBoard = 9;
    d = 5;
    break;
    case 6:
    lengthOfBoard = 9;
    d = 3;
    break;
    
    
  }
  // Label
  
  PFont f;
  f = createFont("Times New Roman",16,true);
  textFont(f,48);  
  fill(0,0,0);
  text("The Code Titans - Game ", 150, 100);
  
  BLOCKX = 500/lengthOfBoard;
  BLOCKY = 500/lengthOfBoard;
  //fill(255,153,255); // black
  //rect(140, 140, 510, 510);
  
  for (int i = 0; i < lengthOfBoard; i ++) {
    for (int j = 0; j < lengthOfBoard; j ++) {
      
      int c = int(random(1,50));
      if ((c)%4 == 0) {
        //fill(255, 255, 255); // white
        fill(250,0,0); // red
        
      } else {
        //fill(0, 0, 0); // black
        fill(0,220,0); // orange
      }
      rect((i * BLOCKX)+150, (j * BLOCKY)+150, BLOCKX-10, BLOCKY-10, 50);
    
      
    } 
  }
  // Drawing Buttons //
  
  // Insert quit Button
  
  int qw,qh,qx,qy;
  qw = 80;
  qh = 50;
  
 
 
  
  String q = "QUIT";
  textSize(12);
  fill(0, 0, 0); // black
  text (q, 150, 700, 100, 100);
  String s = "SUBMIT";
  textSize(12);
  fill(0, 0, 0); // black
  text (s, 400, 700 ,100,100);
  
  fill(255, 255, 255); // white
  rect(150,700,80,50);
  fill(255, 255, 255); // white
  rect(400,700,80,50);
  
  
}