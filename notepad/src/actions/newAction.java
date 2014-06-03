package actions;
import java.awt.event.*;
import FileChooser.*;

import notepad.NotepadFrame;

public class newAction implements ActionListener {

	public void actionPerformed(ActionEvent event)
	{
		FileChooser.filename = null;
		NotepadFrame.textArea.setText("");
	}

}
