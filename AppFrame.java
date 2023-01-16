//to hold the JFrame (JavaScript? how it looks)

package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame { // uses things from JFrame class (

	// in the order you want it to be in the app!
	private TitleBar title;
	private List list; // task will be in the list
	private ButtonPanel btnPanel;
	
	private JButton addTask;
	private JButton clearDone;
	//variables are private, so same names can be used in different classes
	
	private int length;

	// Constructor
	AppFrame() {
		// 'this' is a kind of self referencing thingy
		this.setSize(400, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what to do to or when closing/how to close
		this.setVisible(true);
		
		title = new TitleBar();
		list = new List();
		btnPanel = new ButtonPanel();

		// alignment w.r.t the frame/container dimension mentioned (no space from the
		// border, hence called BorderLayout
		this.add(title, BorderLayout.NORTH);
		this.add(btnPanel, BorderLayout.SOUTH);
		this.add(list, BorderLayout.CENTER);
		
		addTask = btnPanel.getAddTask();
		clearDone = btnPanel.getClearAll();		//basically gives addTask=addTask and clearDone=clearDone (LOL)
		
		length = list.getLength();		//YASSS BICH!!!
		
		addListeners();

	}
	
	
	//function/method to make the buttons actually work
	public void addListeners()	//user defined
	{
		Component[] listItems = this.getComponents();
		//now a bunch of predefined and user defined methods
		addTask.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent abc) 
			{
				if(length < 10) {
					length++;
					Task task = new Task();		//HERE we created a private variable task using Task class to add a new task
					list.add(task);
					//list.updateNumbers();
				
					//we wanna add listeners to the done button & we do that after we have created the done button using task variable
					task.getDone().addMouseListener(new MouseAdapter()		//could have made done = task.getDone(); beforehand & used just "done"
					{
						@Override
						public void mousePressed(MouseEvent abc)
						{
							task.changeState();
							length--;
							revalidate();
						}
					});
					
					revalidate();
				}
			}
		});
		
		clearDone.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent abc)
			{
				//remove the tasks if done/checked
				list.clearCompletedTasks();
				revalidate();
			}
		});
	}
	
}
