/**
 * 
 */
package interpret;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import interpret.ui.InterpretMenu;
import interpret.ui.MainView;

/**
 * @author katouyuuya
 *
 */
@SuppressWarnings("serial")
public class InterpretApp extends JFrame {

	public InterpretApp(String string) {
		super(string);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame app = new InterpretApp("interpret");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(960, 600);
		app.setLocationRelativeTo(null);
		
		InterpretMenu menu = new InterpretMenu();
		app.setJMenuBar(menu.getMenuBar());
		
		JSplitPane main = new MainView().getMainPane();		
		app.getContentPane().add(main, BorderLayout.CENTER);
		
		app.setVisible(true);
	}

}
