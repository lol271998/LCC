class Rectangle{

    Point p1,p2;
    //Rectangulo está definido à custa de dois pontos
    Rectangle(int x1,int y1,int x2,int y2){
	p1 = new Point(x1,y1);
	p2 = new Point(x2,y2);
    }
    Rectangle(Point p1, Point p2){
	this.p1 = p1; //Este p1 é o mesmo que o p1 declarado em cima
	this.p2 = p2;
    }
    
    int area(){
	int area = (p2.x-p1.x)*(p2.y-p1.y);
	return area;
    }
    
    int perimeter(){
	int l1 = (p2.y-p1.y);
	int l2 = (p2.x-p1.x);
	return 2*l1+2*l2;
    }

    boolean pointInside(Point p){
	if(p.x >= p1.x && p.y >= p1.y && p.x<=p2.x && p.y<=p2.y) return true;
	else return false;
    }

    boolean rectangleInside(Rectangle r){
	if(this.pointInside(r.p1) == true && this.pointInside(r.p2) == true) return true;
	else return false;
    }
}
