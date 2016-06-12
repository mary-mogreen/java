/**
 * 
 */
package interpret;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		
		MainView mainView = MainView.getInstance();
		mainView.update();
		app.getContentPane().add(mainView.getMainPane(), BorderLayout.CENTER);
		
		app.setVisible(true);
	}
}
