import java.util.Collections;

public class SortingTechnique {
	
	public static ShapeFactory surfaceBubbleSort(ShapeFactory shapes) {
		int n = shapes.getShapes().size();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n-1-i; j++) {
				if(shapes.getShapes().get(j).compareTo(shapes.getShapes().get(j+1)) == 1) 
					Collections.swap(shapes.getShapes(), j, j+1);
			}
		return shapes;
	}
}
