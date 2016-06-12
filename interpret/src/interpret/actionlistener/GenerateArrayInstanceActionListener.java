/**
 * 
 */
package interpret.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interpret.data.InstanceData;
import interpret.ui.ArrayGenerator;
import interpret.ui.InstanceView;
import interpret.ui.ObjectGenerator;

/**
 * @author katouyuuya
 *
 */
public class GenerateArrayInstanceActionListener implements ActionListener {

	private final ArrayGenerator ag;
	private String insName;
	private String clsName;
	private int size;
	
	public GenerateArrayInstanceActionListener(ArrayGenerator ag) {
		this.ag = ag;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		insName = ag.getInsName();
		clsName = ag.getClsName();
		size = ag.getArrSize();
		if (!insName.isEmpty() && !clsName.isEmpty()) {
			InstanceView iv = InstanceView.getInstance();
			iv.addArrayTab(insName, clsName, size);
			InstanceData id = InstanceData.getInstance();
			id.put(insName, "Array");
		}			
	}

}
