package Packages;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;



public class Main {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			window w1=new window();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			
			window w1=new window();	
			
		}
		
		
		
	}

}

class window extends JFrame implements ActionListener{
	String s,s1;
	String current=null;
	private static JPanel mainPanel;
	JLabel font_style;
	 static JTextArea note=new JTextArea(1000,200);
	 static JMenuBar menu;
	private static JMenu file,edit,view;
	private static JMenuItem newFile,save,saveAs,copy,cut,paste,selectAll,replace;
	private static JComboBox cb;
	
	
	window(){
		this.setTitle("NotePad v2.0");
		this.setPreferredSize(new Dimension(1270,700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
		mainPanel = new JPanel();
		
		// start of JmenuBar
		menu=new JMenuBar();
		menu.setBackground(Color.white);
		
		JMenu file=new JMenu("File");
		
		JMenuItem newFile =new JMenuItem("New");
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		newFile.addActionListener(this);
		JMenuItem save =new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		JMenuItem open =new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		open.addActionListener(this);
		JMenuItem saveAs =new JMenuItem("Save as");
		saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		
		file.add(newFile);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		
		
		JMenu edit=new JMenu("Edit");
		JMenuItem copy =new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		copy.addActionListener(this);
		JMenuItem cut =new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		cut.addActionListener(this);
		JMenuItem paste =new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		paste.addActionListener(this);
		JMenuItem selectAll =new JMenuItem("Select All");
		selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		selectAll.addActionListener(this);
		JMenuItem replace =new JMenuItem("Replace");
		replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		replace.addActionListener(this);
		
		
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(selectAll);
		edit.add(replace);
		
		// end of JMenuBar
		
		cb=new JComboBox();
		
		cb.setMaximumSize(new Dimension(100,18));
		cb.setFocusable(false);
		cb.addItem("Arial");
		cb.addItem("Verdana");
		cb.addItem("Georgia");
		
		cb.addActionListener(this);
		menu.add(file);
		menu.add(edit);
		menu.add(cb);
		
		int width=this.getWidth();
		int height=this.getHeight();
		 
		JScrollPane pane=new JScrollPane(note,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		note.setFont(new Font("Arial",Font.BOLD,24));
		note.setLineWrap(true);
		note.setWrapStyleWord(true);
		note.setBorder(BorderFactory.createEmptyBorder());		
		
		// adding to compoenets to JFrame
		this.add(pane);
		this.setJMenuBar(menu);
		this.pack();	
	}
	
	// Action Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Copy")) {
		
			note.copy();
		}
		else if(e.getActionCommand().equals("Paste")) {
			note.paste();
		}
		else if(e.getActionCommand().equals("Cut")) {
			note.cut();
		}
		else if(e.getActionCommand().equals("Replace")) {
			replace r1=new replace();
		}
		else if(e.getActionCommand().equals("Select All")) {
			note.selectAll();
		}
		else if(e.getActionCommand().equals("New")) {
			note.setText("");
		}
		else if(e.getActionCommand().equals("Open")) {
			JFileChooser ch =new JFileChooser();
			
			int i=ch.showOpenDialog(this);
			if(note.getText() != null) {
				note.setText(null);
			}
			
			
				if(i==JFileChooser.APPROVE_OPTION) {
				File file=ch.getSelectedFile();
				String path=file.getPath();
				current=path;
				try {
					BufferedReader br=new BufferedReader(new FileReader(path));
					String s1="",s2="";
					while((s1=br.readLine()) != null) {
						s2+=s1+"\n";
					}
					note.setText(s2);
					br.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}		
				}
			}
			
		else if(e.getActionCommand().equals("Save")) {
			
			if(current == null) {
			 JFileChooser ch=new JFileChooser();
			
			
			int i=ch.showSaveDialog(null);
			
			
				if(i==JFileChooser.APPROVE_OPTION) {
				File file=ch.getSelectedFile();
				String path=file.getAbsolutePath();
				current = path;
				try {
					FileWriter fr=new FileWriter(path);
					fr.write(note.getText());
					fr.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				}
			}
				else {
					
					try {
						FileWriter fr=new FileWriter(current);
						fr.write(note.getText());
						fr.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}
				
			}
		else if(e.getActionCommand()=="SaveAs") {
JFileChooser ch=new JFileChooser();
			
			
			int i=ch.showSaveDialog(null);
			
			
				if(i==JFileChooser.APPROVE_OPTION) {
				File file=ch.getSelectedFile();
				String path=file.getAbsolutePath();
				
				try {
					FileWriter fr=new FileWriter(path);
					fr.write(note.getText());
					fr.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				}
			
		}
		
		}
			
		public static String getText() {
			return note.getText();
		}
		public static void setText1(String s) {
			note.setText(s);
			
		}
	
	}

