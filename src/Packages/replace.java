package Packages;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;





public class replace extends JFrame implements ActionListener{
		JButton replace , cancel;
		JTextField previous ,current;
		JLabel prev,curr;
		static String previousText;
		static String currentText;
		
		
		replace(){
			
		
			this.setLocation(new Point(300,200));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setVisible(true);
			this.setMinimumSize(new Dimension(500,240));
			
			prev=new JLabel("Enter Word to be Replaced");
			prev.setFont(new Font("Verdana",Font.PLAIN,16));
			prev.setBounds(20, 20, 250, 25);
			
			
			
			
			curr=new JLabel("Enter New Word");
			curr.setFont(new Font("Verdana",Font.PLAIN,16));
			curr.setBounds(20, 60, 250, 25);
			

			previous=new JTextField();
			previous.setBounds(270, 20, 150, 25);
			
			current=new JTextField();
			current.setBounds(270, 60, 150, 25);
			
			replace=new JButton("Replace");
			replace.setBounds(80, 120, 100, 25);
			replace.setFocusable(false);
			replace.addActionListener(this);
			
			cancel=new JButton("Cancel");
			cancel.setBounds(220, 120, 100, 25);
			cancel.setFocusable(false);
			cancel.addActionListener(this);
			
			this.add(prev);
			this.add(curr);
			this.add(previous);
			this.add(current);
			this.add(replace);
			this.add(cancel);
			this.setLayout(null);
			this.setResizable(false);
			
			
			
			
		}
		
		

		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getSource()==cancel) {
				this.dispose();
			}
			if(a.getSource()==replace) {
				 previousText = previous.getText();
				 currentText = current.getText();
				String s =window.getText();
				s=s.replace(previousText, currentText);
				 window.setText1(s);
				 this.dispose();
				
			}
			
		}

		

		
		
		
}
