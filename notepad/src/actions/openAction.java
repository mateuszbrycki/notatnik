package actions;
import java.awt.event.*;
import javax.swing.filechooser.*;
import notepad.*;
import FileChooser.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class openAction implements ActionListener {

	private FileChooser chooser;
	public static String filename = null;
	
	public void actionPerformed(ActionEvent event)
	{	
		//filtr dla file chooser okreœlaj¹cy typ otwieranych plików
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki .txt", "txt");
		
		//wywo³anie odpowiedniego okna
		chooser = new FileChooser("open" ,filter);
		
		//pobranie nazwy wskazanego pliku
		if(FileChooser.filename != null)
		{
			filename = FileChooser.filename;
			
			try {
				
				openFile();
				
			} catch(FileNotFoundException e)
			{
				//w przypadu nie wybrania pliku filechooser jest uruchamiany ponownie
				chooser = new FileChooser("open" ,filter);
			}
		}
	}
	
	//funkcja odpowiadaj¹ca za otwarcie pliku
	private void openFile() throws FileNotFoundException
	{
		File plik = new File(FileChooser.filename);		
		
		Scanner in = new Scanner(plik);
		
		//pobranie istniej¹cego ju¿ tekstu
		String text = "";
		
		//wyczyszczenie tekstu z pola tekstowego
		NotepadFrame.textArea.setText("");
		
		
		//pobranie kolejnych wierszy z pliku
		while(in.hasNext())
		{
			text += in.nextLine();
			text += "\n";			
		}
		
		//ustawnienie pobranego teksu
		NotepadFrame.textArea.setText(text);
	}
}



