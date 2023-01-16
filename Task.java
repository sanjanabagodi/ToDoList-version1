//for each single task

package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task extends JPanel {

	//private JLabel index;
	private JCheckBox done;
	private JTextField taskName;
	//private JButton done;
	private JButton delete;
	
	private boolean checked;	//do we need this even if we use checkbox instead of done button?? yeah, if you want the task background to turn green when checked
	
	
	
	//constructor
	Task(){
		
		this.setPreferredSize(new Dimension(360,20));
		
		this.setLayout(new BorderLayout());		
		// for a single task, so prolly just arranges checkbox, text, button, etc,. horizontally using BorderLayout
		
		checked = false;
		
		
//		index = new JLabel(""); //we'll make a function that automatically updates the index 
//		index.setPreferredSize(new Dimension(20,20)); 
//	    index.setHorizontalAlignment(JLabel.CENTER); //within it's own dimension
//		this.add(index, BorderLayout.WEST); //w.r.t the task's dimension
		
		done = new JCheckBox();
		done.setPreferredSize(new Dimension(50,20));
		done.setHorizontalAlignment(JLabel.CENTER);
		done.setBackground(Color.white);		
		this.add(done, BorderLayout.WEST);
		 		
		taskName = new JTextField("Your task here");
		//taskName.setPreferredSize(new Dimension(300,20));		//can't do this, the layout manager decides the preferred size by itself
		taskName.setBorder(BorderFactory.createEmptyBorder());
		this.add(taskName, BorderLayout.CENTER);	//CENTER uses as much as remaining available space
		
//		done = new JButton("done");
//		done.setBorder(BorderFactory.createEmptyBorder());
//		done.setFont(new Font("Sans-serif", Font.PLAIN, 20));
//		this.add(done, BorderLayout.EAST);
		
	}
	
//	public JButton getDone() {
//		return done;	//method type is JButton coz we'll be returning a JButton
//	}
//	
//	//when tasks are added or cleared
//	public void changeIndex(int number) {
//		this.index.setText(number+"");
//		this.revalidate();
//	}
	
	public JCheckBox getDone() {
		return done;
	}
	
	//when tasks are "done" -> change color, make checked = true
	public void changeState() {
		done.setBackground(Color.green);
		checked = true;
	}
	
	//return state of the task
	public boolean getState() {
		return checked;
	}
	
}
