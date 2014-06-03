package actions;
import java.awt.event.*;
import notepad.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import FileChooser.*;
import javax.swing.filechooser.*;

//klasa odpowiada za nadpisanie otwartego pliku
public class saveAction implements ActionListener {
	
	private FileChooser chooser;
	
	public void actionPerformed(ActionEvent event)
	{	
		//niepotrzebne przy zapisywaniu otwartego pliku
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki .txt", "txt");
		//chooser = new FileChooser("save" ,filter);
		
		if(openAction.filename != null)
		{
			try {
				saveFile(openAction.filename);
			} catch(FileNotFoundException e)
			{}
		} else {
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki .txt", "txt");
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
	
	public static void saveFile(String filename) throws FileNotFoundException
	{
		PrintWriter zapis = new PrintWriter(filename);
		String text = NotepadFrame.textArea.getText().replace("\n", System.getProperty("line.separator"));
		zapis.println(text);
	    zapis.close();
	
	}
	

}



