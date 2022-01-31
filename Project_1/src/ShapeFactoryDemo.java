import java.awt.Component;
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.event.*;

public class ShapeFactoryDemo extends JFrame{ 

	static JFrame frame;

	public ShapeFactoryDemo() {
        frame = new JFrame("ShapeFactoryDemo"); 
        
        JPanel panel1 = new JPanel();
      
        // Load shapes Button
        // 
        JButton button1 = new JButton();  
        button1.setText("Load shapes");    
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      		    // find previous ShapeFactory component in JFrame and remove
	    			for(Component c1: frame.getRootPane().getComponents()) 
	    				if(c1 instanceof JLayeredPane) 
	    					for(Component c2 : ((JLayeredPane)c1).getComponents()) 
	    						for(Component c3 : ((JPanel)c2).getComponents()) 
	    							if(c3 instanceof ShapeFactory) 
	    								frame.remove(c3);
            	
            	JPanel panel2 = new ShapeFactory();
            	frame.add(panel2);
            	
            	panel1.revalidate();
            	panel2.revalidate();
            }
        });  
        panel1.add(button1);  
           
        // Sort shapes Button
        //
        JButton button2 = new JButton();  
        button2.setText("Sort shapes");    
        button2.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
      		    // find ShapeFactory component in JFrame
	    			for(Component c1: frame.getRootPane().getComponents()) 
	    				if(c1 instanceof JLayeredPane) 
	    					for(Component c2 : ((JLayeredPane)c1).getComponents()) 
	    						for(Component c3 : ((JPanel)c2).getComponents()) 
	    							if(c3 instanceof ShapeFactory) {
	    								ShapeFactory shapes = (ShapeFactory)c3; // make a new ShapeFactory to sort, previous one will be removed
	    								shapes = SortingTechnique.surfaceBubbleSort(shapes);  // Use BubbleSort to sort shapes
	    								frame.remove(c2);	// remove unsorted ShapeFactory		
	    								JPanel panel2 = new ShapeFactory(shapes);
	    				            	frame.add(panel2); // Display sorted shapes	
	    				            	
	    				            	panel1.revalidate();
	    				            	panel2.revalidate();    				            	
	    							}	
        		  } 
        		} );  
        panel1.add(button2); 

        frame.add(panel1);
        
        frame.setSize(600, 600);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);   
	}
	
    public static void main(String s[]) {  
    	new ShapeFactoryDemo();
    }  
   
    
    
}  