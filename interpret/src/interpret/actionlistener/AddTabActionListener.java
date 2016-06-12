/**
 * 
 */
package interpret.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interpret.ui.InstanceView;

/**
 * @author katouyuuya
 * タブを追加するアクションリスナー
 */
public class AddTabActionListener implements ActionListener {
	private final String title;
	private final int type;
	
	public AddTabActionListener(String title, int type) {
		this.title = title;
		this.type = type;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InstanceView insView = InstanceView.getInstance();
		insView.addTab(title, type);
	}
	
}
