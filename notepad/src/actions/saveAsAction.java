package actions;
import java.awt.event.*;
import javax.swing.filechooser.*;
import notepad.*;
import FileChooser.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import notepad.NotepadFrame;

public class saveAsAction implements ActionListener {

	private FileChooser chooser;
	
	
	public void actionPerformed(ActionEvent event)
	{
		
		//filtr dla file chooser okreœlaj¹cy typ otwieranych plików
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki .txt", "txt");
				
		//wywo³anie odpowiedniego okna
		chooser = new FileChooser("save" ,filter);
		
		if(chooser.filename != null)
		{
			try {
				saveAction.saveFile(chooser.filename);
			} catch(FileNotFoundException e)
			{}
		} 
		
	}
}
