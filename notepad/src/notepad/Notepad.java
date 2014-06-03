package notepad;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import actions.*;
import GBC.*;

public class Notepad {

	public static NotepadFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				frame = new NotepadFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setExtendedState(Frame.MAXIMIZED_BOTH);  
			}
		});

	}
}


