import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ShapeFactory extends JPanel {
	private ArrayList<Shape> shapes;
	
	public ShapeFactory() {
		this.shapes = new ArrayList<Shape>();
		int x = 10;
		int y = 10;
		for(int i = 0; i < 6; i++) {
			int n = (int) (Math.random()*3);
			if(n == 0) {
				shapes.add(new Rectangle(x,y));
			}
			else if(n == 1) {
				shapes.add(new Square(x,y));
			}
			else {
				shapes.add(new Circle(x,y));
			}
			x += 65;
			y += 65;
	    }
	}
	
	public ShapeFactory(ShapeFactory shapes) {
		this.shapes = new ArrayList<Shape>();
		int x = 10;
		int y = 10;
		for(Shape shape: shapes.getShapes()) {
			if(shape instanceof Rectangle)
				this.shapes.add(new Rectangle((Rectangle)shape, x, y));
			else if(shape instanceof Square)
				this.shapes.add(new Square((Square)shape, x, y));
			else if(shape instanceof Circle)
				this.shapes.add(new Circle((Circle)shape, x, y));
			x += 65;
			y += 65;
		}
		
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	@Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      for (Shape shape: shapes) {
    	  shape.drawShape(g2d);
      }
   } 
	
}
