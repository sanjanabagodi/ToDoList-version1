//for the actual list of things/tasks to do 

package classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class List extends JPanel{
	//NOT JFrame coz it's just base, you can't have a base over another, dummy, JPanel are like Lego blocks!
	
	private int length;
	
	//constructor
	List(){
		GridLayout layout = new GridLayout(10,1);
		layout.setVgap(5);
		
		this.setLayout(layout);
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.white));
		
		length = 0;
	}
	
	public void updateNumbers() {
		
		//1. make/get an array of components/tasks using getComponents
		//2. then loop through the array and add the right number (even when we clear the completed tasks from between the lists) 
//		Component[] listItems = this.getComponents();
//		for(int i=0; i<listItems.length; i++)		//i=0 for referencing the list elements
//		{
//			if(listItems[i] instanceof Task) {
//				((Task)listItems[i]).changeIndex(i+1);		//calling changeindex method
//				//((type/class)variableName[index]).someMethod(arguements..);
//			}
//		}
		
	}//removed since i'm using checkboxes
	
	public void clearCompletedTasks() {
		
		//1. make/get an array of components/tasks using getComponents
		//2. then loop through the array and clear the tasks which are marked checked=true
		for(Component abc : getComponents())	
		{
			if(abc instanceof Task) {	
				if(((Task)abc).getState()) {
					remove(abc);
					updateNumbers();
					repaint();
				}
			}
		}
	}
	
	public int getLength() {
		return length;
	}
	
}
