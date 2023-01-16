package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleBar extends JPanel {

	// Constructor
	TitleBar() {
		this.setPreferredSize(new Dimension(400, 80));
		this.setBackground(Color.white);
		// this.setBackground(Color.red); // to check size visibly, doesn't work if not 'added' to AppFrame

		JLabel titleText = new JLabel("To-Do List ^^");
		titleText.setPreferredSize(new Dimension(400, 80));
		titleText.setFont(new Font("Sans-serif", Font.BOLD, 22));
		titleText.setHorizontalAlignment(JLabel.CENTER); // alignment w.r.t the Label dimension mentioned

		this.add(titleText);
	}
}
