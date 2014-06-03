package actions;
import java.awt.event.*;
import notepad.*;

public class selectAllAction implements ActionListener {

	public void actionPerformed(ActionEvent event)
	{
		NotepadFrame.textArea.selectAll();
	}
	

}



