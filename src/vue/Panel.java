package vue;

import java.awt.Color;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	public Panel ()
	{
		this.setBounds(300, 60, 500, 400);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		this.setVisible(false);
	}
}