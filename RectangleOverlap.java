package amazon;

class Point{
	int x,y;
	public Point(int i, int j) {
		// TODO Auto-generated constructor stub
		x=i;
		y=j;
	}
}
public class RectangleOverlap {
	
	public static boolean overlap(Point l1, Point r1, Point l2, Point r2){
		if((l2.x>r1.x)||(l1.x>r2.x)||(r1.y<l2.y)||(l1.y>r2.y))
			return false;
		return true;
		
	}
	
	public static void main(String[] args){
		Point l1=new Point(0,0);
		Point r1=new Point(5,5);
		Point l2=new Point(4,4);
		Point r2=new Point(10,10);
		
		System.out.println(overlap(l1,r1,l2,r2));
	}
}
