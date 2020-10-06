class Rectangle{
   
   Point p1, p2;
   
   Rectangle(int x1, int y1, int x2, int y2){
      
      p1 = new Point (x1, y1);
      p2 = new Point (x2, y2);
      /*this(p1,p2); //Chamar outro construtor;*/
   }
   Rectangle(Point p1, Point p2){
      
      this.p1 = p1; //Estes são os pontos da linha 20;
      this.p2 = p2; // ... ... ... ...
   }

   int area(){
      
      int a = p2.x - p1.x;
      int b = p2.y - p1.y;
      int area = a*b;
      return area;
   }
   
   int perimeter(){
      
      int a = p2.x - p1.x;
      int b = p2.y - p1.y;
      int perimeter = a*2 + b*2;
      return perimeter;
   }
   
   boolean pointInside(Point p){

      if((p.x >= p1.x) && (p.y >= p1.y) && (p.x <= p2.x) && (p.y <= p2.y)) return true;
      else return false;      
   }
   
   boolean rectangleInside(Rectangle r){
      
      if(this.pointInside(r.p1) == true && this.pointInside(r.p2) == true) return true;
      else return false;     
   }
}
