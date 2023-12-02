package proj4;

public class Plot {
	private int width, depth, x, y;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width= 1;
		this.depth = 1;
	}
	public Plot(int width, int depth) {
		this.width = width;
		this.depth= depth;
	}
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	public Plot(Plot p) {
		this.x = p.getX();
		this.y = p.getY();
		this.width = p.getWidth();
		this.depth  = p.getDepth();
	}
	public boolean encompasses(Plot p) {
		int x1,x2,y1,y2, px1,px2,py1,py2;
		boolean result=false;
		x1 = x;
		x2 = x1+width;
		y1 = y; 
		y2 = depth+y1;
		
		px1 = p.getX();
		px2= px1 + p.getWidth();
		py1 = p.getY();
		py2 = py1+p.getDepth();
		
		if (((x1<=px1) && (px1<= x2)) // px1 within bounds
			&&((y1<= py1) && (py1 <= y2)) // py1 within bounds
			&&((x1 <= px2) && (px2<= x2)) // px2 within bounds
			&&((y1 <= py2) && (py2 <= y2)))// py2 within bounds
			{ 
			result = true;
			}
		
		 return result;
	}
	
	public boolean overlap(Plot p) {
		int x1,x2,y1,y2, px1,px2,py1,py2;
		boolean result=false;
		x1 = x;
		x2 = x1+width;
		y1 = y; 
		y2 = depth+y1;
		
		px1 = p.getX();
		px2= px1 + p.getWidth();
		py1 = p.getY();
		py2 = py1+p.getDepth();
		
		if (((x1< px1) && (px1 < x2)) // if p starts  within x range 
			&&( ((y1 < py1) && (py1 < y2)) || ((y1< py2) && (py2 < y2)))) // andp0y starts or ends in y range
			{
				result = true;
			}
		if (((x1< px2) && (px2 < x2)) // if p ends within x range 
			&&( ((y1 < py1) && (py1 < y2)) || ((y1< py2) && (py2 < y2)))) // and py starts or ends in y range
			{
				result = true;
			}
		if (((px1< x1) && (x1 < px2)) // if x starts within p range 
			&&( ((py1 < y1) && (y1 < py2)) || ((py1< y2) && (y2 < py2)))) // and y starts or ends in py range
			{
				result = true;
			}
		if (((px1< x2) && (x2 < px2)) // if x ends within p range 
			&&( ((py1 < y1) && (y1 < py2)) || ((py1< y2) && (y2 < py2)))) // and y starts or ends in py range
			{
				result = true;
			}
		
		
		return result;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getDepth() {
		return depth;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String toString() {
		return ("Upper Left: (" + x + "," + y + "). Width:" + width + " Depth: " + depth);
	}
	
}
