/**
 * 
 */
package interpret.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author katouyuuya
 *
 */
public class InterpretMenu {
	private JMenuBar menubar;
	
	public InterpretMenu() {
		menubar = new JMenuBar();

	    JMenu menu1 = new JMenu("New");
	    JMenu menu2 = new JMenu("Layout");

	    menubar.add(menu1);
	    menubar.add(menu2);

	    JMenuItem menuitem1 = new JMenuItem("Object");
	    JMenuItem menuitem2 = new JMenuItem("Array");

	    menu1.add(menuitem1);
	    menu1.add(menuitem2);

	}
	
	public JMenuBar getMenuBar() {
		return menubar;
	}
}
