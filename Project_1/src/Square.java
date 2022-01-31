import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {
	
	public Square(int x, int y){
		this.colorRGB = new int[3];
		for(int i = 0; i < 3; i++)
			this.colorRGB[i] = (int) (Math.random()*256);
		this.x = x;
		this.y = y;
		this.width = (int) (Math.random()*50 + 10);
		this.height = this.width;
		this.surface = width * height;
	}
	
	// for sorting part
	//
	public Square(Square square, int x, int y){
		this.colorRGB = square.getColorRGB();
		this.x = x;
		this.y = y;
		this.width = square.getWidth();
		this.height = square.getHeight();
		this.surface = this.width * this.height;
	}
	
	public void drawShape(Graphics g) {
		g.setColor(new Color(colorRGB[0], colorRGB[1], colorRGB[2]));
		g.fillRect(this.x, this.y, this.width, this.height);
	}


}
