package classes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame { 

	// in the order you want it to be in the app!
	private TitleBar title;
	private List list; // task will be in the list
	private ButtonPanel btnPanel;
	
	private JButton addTask;
	private JButton clearDone;
	
	private int length;

	// Constructor
	AppFrame() {
		this.setSize(400, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what to do to or when closing/how to close
		this.setVisible(true);
		
		title = new TitleBar();
		list = new List();
		btnPanel = new ButtonPanel();

		this.add(title, BorderLayout.NORTH);
		this.add(btnPanel, BorderLayout.SOUTH);
		this.add(list, BorderLayout.CENTER);
		
		addTask = btnPanel.getAddTask();
		clearDone = btnPanel.getClearAll();		
		
		length = list.getLength();		
		
		addListeners();

	}
	
	
	//function/method to make the buttons actually work
	public void addListeners()	//user defined
	{
		Component[] listItems = this.getComponents();
		addTask.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent abc) 
			{
				if(length < 10) {
					length++;
					Task task = new Task();		
					list.add(task);
				
					task.getDone().addMouseListener(new MouseAdapter()		
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
