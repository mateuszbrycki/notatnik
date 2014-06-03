package notepad;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import actions.*;
import GBC.*;
import java.net.*;
import java.io.*;
import javax.swing.ImageIcon;

public class NotepadFrame extends JFrame
{

	public static JTextArea textArea;
	public static JPanel textPanel;

	
	public NotepadFrame()
	{
		//ustawienie tytu³u ramki oraz rozmiaru
		setTitle("Notatnik 1.0");
		
		
		setSize(800, 600);
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		//dadanie menu "Plik"
		JMenu fileMenu = new JMenu("Plik");
		
			//"Nowy"
			JMenuItem fileItem = fileMenu.add("Nowy");
			fileItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
			fileItem.addActionListener(new newAction());
			
			//Otwórz
			JMenuItem openItem = fileMenu.add("Otwórz");
			openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
			openItem.addActionListener(new openAction());
			
			fileMenu.addSeparator();
			
			//zapisz
			JMenuItem saveItem = fileMenu.add("Zapisz");
			saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
			saveItem.addActionListener(new saveAction());
			
			//zapisz jako
			JMenuItem saveAsItem = fileMenu.add("Zapisz jako...");
			saveAsItem.setAccelerator(KeyStroke.getKeyStroke("alt ctrl S"));
			saveAsItem.addActionListener(new saveAsAction());
			
			fileMenu.addSeparator();
			
			//zamknij
			JMenuItem closeItem = fileMenu.add("Zamknij");
			closeItem.addActionListener(new closeAction());
		
		JMenu editMenu = new JMenu("Edytuj");
			//zaznacz wszystko
			JMenuItem selectAllItem = editMenu.add("Zaznacz wszystko");
			selectAllItem.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
			selectAllItem.addActionListener(new selectAllAction());
			
			editMenu.addSeparator();
		
			//cofnij
			JMenuItem backItem = editMenu.add("Cofnij");
			backItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
			
			//do przodu
			JMenuItem forwardItem = editMenu.add("Do przodu");
			forwardItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Y"));
			
			editMenu.addSeparator();
			
			//wytnij
			JMenuItem cutItem = editMenu.add("Wytnij");
			cutItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
			
			//kopiuj
			JMenuItem copyItem = editMenu.add("Kopiuj");
			copyItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
			
			//wklej
			JMenuItem pasteItem = editMenu.add("Wklej");
			pasteItem.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
			
		JMenu helpMenu = new JMenu("Pomoc");
			//o programie
			JMenuItem aboutItem = helpMenu.add("O programie");
			aboutItem.setMnemonic('O');
			
		
		//dodanie wszystkich menu do belki menu
		JMenuBar bar = new JMenuBar();
		//setJMenuBar(bar);
		bar.add(fileMenu); //menu plik
		bar.add(editMenu); //menu edytuj
		bar.add(helpMenu); //menu pomoc
		
		/*
		 * //ikony przycisków
		URL saveURL = getClass().getResource("save.png");
		Image saveImage = Toolkit.getDefaultToolkit().getImage(saveURL);
		
		URL backURL = getClass().getResource("back.png";
		Image backImage = Toolkit.getDefaultToolkit().getImage(backURL);
		
		URL forwardURL = getClass().getResource("forward.png");
		Image forwardImage = Toolkit.getDefaultToolkit().getImage(forwardURL);
		*/
		
		//System.out.println(getClass().getResource("/save.png"));
		//powi¹zanie ikon
		ImageIcon saveIcon = new ImageIcon(getClass().getResource("/save.png"));
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/back.png"));
		ImageIcon forwardIcon = new ImageIcon(getClass().getResource("/forward.png"));
		
		//dodanie panelu z przyciskami oraz utworzenie konkretnych przycisków wraz z przypisaniem akcji
		JButton saveButton = new JButton(saveIcon);
		saveButton.addActionListener(new saveAction());
		
		JButton backButton = new JButton(backIcon);
		backButton.addActionListener(new backAction());
		
		JButton forwardButton = new JButton(forwardIcon);
		forwardButton.addActionListener(new forwardAction());
				
		//dodanie pola tekstowego
		
		textPanel = new JPanel();
		textArea = new JTextArea(40,123);
		
		//w³¹czenie przewijania pola tekstowego
		JScrollPane scrollPane = new JScrollPane(textArea);
		textPanel.add(scrollPane);
		
		//add(textPanel, BorderLayout.CENTER);
		
		
		//dodanie wszystkich komponentów do rozk³adu GRID
		add(bar, new GBC(0,0,100,0).setFill(GBC.HORIZONTAL).setInsets(0).setWeight(100,100).setAnchor(GBC.NORTH));
		add(saveButton, new GBC(0,0).setAnchor(GBC.NORTHWEST).setWeight(0,100).setInsets(23,0,10,0));
		add(backButton, new GBC(1,0).setAnchor(GBC.NORTHWEST).setWeight(0,100).setInsets(23,0,10,0));
		add(forwardButton, new GBC(2,0).setAnchor(GBC.NORTHWEST).setWeight(0,100).setInsets(23,0,10,0));
		add(textPanel, new GBC(0,0,10,10).setAnchor(GBC.CENTER).setInsets(50,0,0,0));
		
	}
	
	
}
