import java.awt.Color;
import java.awt.Graphics;


public class Circle extends Shape {
	
	public Circle(int x, int y){
		this.colorRGB = new int[3];
		for(int i = 0; i < 3; i++)
			this.colorRGB[i] = (int) (Math.random()*256);
		this.x = x;
		this.y = y;
		this.width = (int) (Math.random()*50 + 10);
		this.height = this.width;
		this.surface = Math.PI * Math.pow((width/2),2);
	}
	
	// for sorting part
	//
	public Circle(Circle circle, int x, int y){
		this.colorRGB = circle.getColorRGB();
		this.x = x;
		this.y = y;
		this.width = circle.getWidth();
		this.height = circle.getHeight();
		this.surface = Math.PI * Math.pow((width/2),2);
	}
	
	public void drawShape(Graphics g) {
		g.setColor(new Color(colorRGB[0], colorRGB[1], colorRGB[2]));
		g.fillOval(this.x, this.y, this.width, this.height);
	}

}
