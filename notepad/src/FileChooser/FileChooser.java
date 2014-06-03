package FileChooser;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
import notepad.*;
import notepad.NotepadFrame.*;
import java.io.*;

public class FileChooser {

	/**
	 * @param args
	 */	
	private int result;
	public static String filename = null;
	public static String filepath = null;
	public static File selectedfile;
	public String file;
	
	public FileChooser(String name, FileNameExtensionFilter filter)
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new File("."));
			
		if(name.equals("open"))
		{
			result = chooser.showOpenDialog(Notepad.frame);
		} else if(name.equals("save"))
		{
			result = chooser.showSaveDialog(Notepad.frame);
		}
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			filename = chooser.getSelectedFile().getPath();
			selectedfile = chooser.getSelectedFile();
		}
	}
	
	
}
