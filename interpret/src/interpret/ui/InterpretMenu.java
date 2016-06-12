/**
 * 
 */
package interpret.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interpret.actionlistener.AddTabActionListener;

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
	    menuitem1.addActionListener(new AddTabActionListener("new ClassObject", InstanceView.OBJECT_GENERATOR));
	    JMenuItem menuitem2 = new JMenuItem("Array");
	    menuitem2.addActionListener(new AddTabActionListener("new Array", InstanceView.ARRAY_GENERATOR));

	    menu1.add(menuitem1);
	    menu1.add(menuitem2);

	}
	
	public JMenuBar getMenuBar() {
		return menubar;
	}
}
