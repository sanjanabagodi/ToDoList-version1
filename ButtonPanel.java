package classes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ButtonPanel extends JPanel{ //DO NOT FORGET to extend
	
	//JPanel cause we are adding 2 buttons, if we extend to JButton we'll get a single button

	private JButton addTask;
	private JButton clearDone;
	
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	//constructor
	ButtonPanel(){
		
		this.setPreferredSize(new Dimension(400, 80));
		//this.setBackground(Color.red);
		
		addTask = new JButton("Add Task"); 
		
		addTask.setBorder(emptyBorder);
		addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
		this.add(addTask);
		
		//to add space between the buttons
		//this.add(Box.createHorizontalBox()); --> only makes like 5pixel box space b/w buttons
		this.add(Box.createHorizontalStrut(60)); 	//can specify the gap
		
		clearDone = new JButton("Clear finished tasks");
		clearDone.setBorder(emptyBorder);
		clearDone.setFont(new Font("Sans-serif", Font.PLAIN, 20));
		this.add(clearDone);
	
		//you can set preferred size if you want the button to be padded or like big
	}
	
	//like a getter function to get input/data
	public JButton getAddTask() {
		//getter for addTask
		return addTask;
	}
	
	public JButton getClearAll() {
		//getter for clearDone
		return clearDone;
	}
	
	
}
