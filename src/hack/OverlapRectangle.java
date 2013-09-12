package hack;

public class OverlapRectangle {
	
	class Point{
		int x;
		int y;
	}
	
	// think out of box
	boolean isOverlap_simple(Point p1, Point p2, Point p3, Point p4){
		return !( p2.y < p3.y || p1.y > p4.y || p2.x < p3.x || p1.x > p4.x );
	}
	
	boolean isOverlap(Point p1, Point p2, Point p3, Point p4){
		
		return isPointInrectangle(p1, p2, p3) 
				|| isPointInrectangle(p1, p2, p4)
				|| isPointInrectangle(p3, p4, p1)
				|| isPointInrectangle(p3, p4, p2);
	}

	private boolean isPointInrectangle(Point p1, Point p2, Point p3) {
		return p3.x >= p1.x && p3.x <= p2.x && p3.y <= p1.y && p3.y >= p2.y;
	}

}
