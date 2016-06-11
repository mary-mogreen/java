/**
 * 
 */
package interpret.ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

/**
 * @author katouyuuya
 *
 */
public class MainView {
	private JSplitPane main;
	
	public MainView() {
		
		EmptyBorder border = new EmptyBorder(0, 0, 0, 0);
		
		main = new JSplitPane();
		
		// left 1
		JPanel ivp = new JPanel(); // Instance View
		ivp.setBackground(Color.WHITE);
		JLabel ivl = new JLabel("Instance Viewer");
		ivp.add(ivl);
		
		// right 1
		JSplitPane operate = new JSplitPane(); // 操作部
		
		// left 1-1
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		// top
		JTabbedPane instanceView = new InstanceView().getInstanceView(); // Object & Array Viewer
		instanceView.setBackground(Color.MAGENTA);
		
		// bottom
		JPanel fvp = new JPanel(); // Object & Array Viewer
		fvp.setBackground(Color.CYAN);
		JLabel fvl = new JLabel("Field Viewer");
		fvp.add(fvl);
		
		// right 1-2
		JPanel mvp = new JPanel(); // Method Viewer
		mvp.setBackground(Color.YELLOW);
		JLabel mvl = new JLabel("Method Viewr");
		mvp.add(mvl);
		
		split.setTopComponent(instanceView);
		split.setBottomComponent(fvp);
		operate.setLeftComponent(split);
		operate.setRightComponent(mvp);
		
		main.setLeftComponent(ivp);
		main.setRightComponent(operate);
		
		split.setBorder(border);
		operate.setBorder(border);
		
	}
	
	public JSplitPane getMainPane() {
		return main;
	}
}
