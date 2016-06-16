/**
 * 
 */
package interpret.ui;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author katouyuuya
 *
 */
@SuppressWarnings("serial")
public class InterpretMenuBar extends JMenuBar {
	
	private JMenuItem newObject;
	private JMenuItem newArray;
	
	public InterpretMenuBar() {

	    JMenu menu1 = new JMenu("New");

	    add(menu1);

	    newObject = new JMenuItem("Object");
	    
	    newArray = new JMenuItem("Array");
	    
	    menu1.add(newObject);
	    menu1.add(newArray);
	}
	
	public void addNewObjectListener(ActionListener listener) {
		newObject.addActionListener(listener);
	}
	
	public void removeNewObjectListener(ActionListener listener) {
		newObject.removeActionListener(listener);
	}
	
	public void addNewArrayListener(ActionListener listener) {
		newArray.addActionListener(listener);
	}
	
	public void removeNewArrayListener(ActionListener listener) {
		newArray.removeActionListener(listener);
	}
}
