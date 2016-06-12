/**
 * 
 */
package interpret.changeListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import interpret.ui.MainView;

/**
 * @author katouyuuya
 *
 */
public class UpdateChangeListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		MainView mainView = MainView.getInstance();
		mainView.update();
		System.out.println("Change Event!!!");
		
	}
	
}
