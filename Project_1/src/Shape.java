import java.awt.Graphics;

public abstract class Shape implements Comparable<Shape>{
	protected int[] colorRGB;
	protected int x, y;
	protected int width, height;
	protected double surface;

	public int[] getColorRGB() {
		return colorRGB;
	}
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setColorRGB(int[] colorRGB) {
		for(int i = 0; i < 3; i++)
			this.colorRGB[i] = colorRGB[i];
	}
	 
	public void setWidth(int width) {
		this.width = width;
	}
	    
	public void setHeight(int height) {
		this.height = height;
	}
	 
	public void setX(int x) {
		this.x = x;
	}
		
	public void setY(int y) {
		this.y = y;
	}
	
	public double getSurface() {
		return this.surface;
	}
	
	public abstract void drawShape(Graphics	g);
	
	@Override
	public int compareTo(Shape shape) {
		return Double.compare(this.getSurface(), shape.getSurface());
	}
}
