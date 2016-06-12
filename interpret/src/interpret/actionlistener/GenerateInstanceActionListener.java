/**
 * 
 */
package interpret.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interpret.data.InstanceData;
import interpret.ui.InstanceView;
import interpret.ui.ObjectGenerator;

/**
 * @author katouyuuya
 *
 */
public class GenerateInstanceActionListener implements ActionListener {

	private final ObjectGenerator og;
	private String insName;
	private String clsName;
	
	public GenerateInstanceActionListener(ObjectGenerator og) {
		this.og = og;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		insName = og.getInsName();
		clsName = og.getClsName();
		if (!insName.isEmpty() && !clsName.isEmpty()) {
			InstanceView iv = InstanceView.getInstance();
			iv.addInstanceTab(insName, clsName);
			InstanceData id = InstanceData.getInstance();
			id.put(insName, "Object");
		}			
	}

}
