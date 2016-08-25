package interpret.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import interpret.AppData;
import interpret.ui.component.ClosableTabbedPane;

@SuppressWarnings("serial")
public class InterpretFrame extends JFrame {

	AppData ad = AppData.getInstance();
	
	private final InterpretMenuBar menubar = new InterpretMenuBar();
	
	private final ClosableTabbedPane tabPane = (ClosableTabbedPane)ad.getObject(AppData.TABPANE);
	
	
	

	public InterpretFrame() {
		setTitle("Interpret");
		setSize(800, 600);

		setLayout(new BorderLayout());
		getContentPane().add(BorderLayout.NORTH, menubar);
		getContentPane().add(BorderLayout.CENTER, tabPane);
		
		tabPane.removeAll();

		
		tabPane.addTab("new Object", new ObjectCreator());
		tabPane.addTab("new Array", new ArrayCreator());

		
		ActionListener newObjectListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabPane.addTab("new Object", new ObjectCreator());
				tabPane.setSelectedIndex(tabPane.getComponentCount() - 2);
			}
			
		};
		menubar.addNewObjectListener(newObjectListener);
		
		ActionListener newArrayListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabPane.addTab("new Array", new ArrayCreator());
				tabPane.setSelectedIndex(tabPane.getComponentCount() - 2);
			}
			
		};
		
		menubar.addNewArrayListener(newArrayListener);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
