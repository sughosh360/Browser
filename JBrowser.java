import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
public class SBrowser extends JFrame {
	private JTextField addressBar;
	private JEditorPane display;
	//constructor
	public SBrowser(){
		super("Suggi Browser");
		addressBar = new JTextField("Enter a URL hoss!");
		addressBar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						loadData(event.getActionCommand());
					}
				});
		add(addressBar,BorderLayout.NORTH);
		JFrame myJFrame = new JFrame();
		myJFrame .getContentPane().setBackground( Color.CYAN );
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent event){
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							loadData(event.getURL().toString());
						}
					}
				});
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
		
	}
	private void loadData(String string) {
		try{		
			display.setPage(string);
			addressBar.setText(string);
		}catch(Exception e){
			System.out.println("not a good url!");
		}
	}	
	
}
