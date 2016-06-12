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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import interpret.data.InstanceData;

/**
 * @author katouyuuya
 *
 */
public class MainView {
	private static MainView instance;
	
	private JSplitPane main;
	private JPanel instanceListView;
	private JTabbedPane instanceView;
	private JPanel fieldView;
	private JPanel methodView;
	private JPanel arrayElementView;
	private JPanel fieldAndArrElmView;
	
	public static MainView getInstance() {
		if (instance == null)
			instance = new MainView();
		return instance;
	}
	
	
	private MainView() {
		
		EmptyBorder border = new EmptyBorder(0, 0, 0, 0);
		
		main = new JSplitPane();
		
		// left 1
		instanceListView = new JPanel(); // Instance List View
		instanceListView.setBackground(Color.WHITE);
		JLabel ivl = new JLabel("Instance Viewer");
		instanceListView.add(ivl);
		
		// right 1
		JSplitPane operate = new JSplitPane(); // 操作部
		
		// left 1-1
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		// top
		instanceView = InstanceView.getInstance().getView(); // Object & Array Viewer
		instanceView.setBackground(Color.MAGENTA);
		
		// bottom
		fieldAndArrElmView = new JPanel(); // Field & Array Elements Viewer
		fieldAndArrElmView.setBackground(Color.CYAN);
		fieldView = new FieldView().getPanel();
		fieldAndArrElmView.add(fieldView);
		
		// right 1-2
		methodView = new JPanel(); // Method Viewer
		methodView.setBackground(Color.YELLOW);
		JLabel mvl = new JLabel("Method Viewr");
		methodView.add(mvl);
		
		split.setTopComponent(instanceView);
		split.setBottomComponent(fieldAndArrElmView);
		operate.setLeftComponent(split);
		operate.setRightComponent(methodView);
		
		main.setLeftComponent(instanceListView);
		main.setRightComponent(operate);
		
		split.setBorder(border);
		operate.setBorder(border);	
	}
	
	public void update() {
		System.out.println("");
		InstanceData id = InstanceData.getInstance();
		int currentIdx = instanceView.getSelectedIndex();
		System.out.println("currentIdx: " + currentIdx );
		if (currentIdx != -1) {
			String insName = instanceView.getTitleAt(currentIdx);
			System.out.println("insName: " + insName);
			Object obj = id.get(insName);
			System.out.println("obj: " + (obj==null ? "null" : obj.toString()));
			fieldAndArrElmView.removeAll();
			if ("Object".equals((String)obj)) {
				fieldView = new FieldView().getPanel();
				fieldAndArrElmView.add(fieldView);
			} else if ("Array".equals(((String)obj))) {
				arrayElementView = new ArrayElementView().getPanel();
				fieldAndArrElmView.add(arrayElementView);
			} else {
				fieldAndArrElmView.repaint();;
				System.out.println("消したはずなんですけど・・・・。");
			}
		}
	}
	
	public JSplitPane getMainPane() {
		return main;
	}
}
