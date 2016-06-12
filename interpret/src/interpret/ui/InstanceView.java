/**
 * 
 */
package interpret.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import interpret.changeListener.UpdateChangeListener;
import interpret.ui.component.ClosableTabbedPane;

/**
 * @author katouyuuya
 *
 */
public class InstanceView {
	private static InstanceView instanceView;
	private JTabbedPane view;
	
	public static final int OBJECT_GENERATOR = 0;
	public static final int ARRAY_GENERATOR = 1;
	public static final int OBJECT_INSTANCE = 2;
	public static final int ARRAY_INSTANCE = 3;
	
	private InstanceView() {
		view = new ClosableTabbedPane();
		view.addTab("new ClassObject", new ObjectGenerator().getPanel());
		view.addTab("new Array", new ArrayGenerator().getPanel());
		view.addChangeListener(new UpdateChangeListener());
	}
	
	public static InstanceView getInstance() {
		if (instanceView == null) {
			instanceView = new InstanceView();
		}
		return instanceView;
	}
	
	public JTabbedPane getView() {
		return view;
	}
	
	/**
	 * タブタイトルを選択されたタイプのタブで生成する。
	 * @param title
	 * @param type
	 */
	public void addTab(String title, int type) {
		if (type == OBJECT_GENERATOR)
			addObjectGenerator(title);
		else if (type == ARRAY_GENERATOR)
			addArrayGenerator(title);
	}
	
	/**
	 * オブジェクト生成の為のタブを追加する。
	 * もしすでに存在する場合は，表示するだけ。
	 * @param title
	 */
	public void addObjectGenerator(String title) {
		int idx = view.indexOfTab(title);
		if (idx == -1)
			view.addTab(title, new ObjectGenerator().getPanel());
		else
			view.setSelectedIndex(idx);
	}
	
	/**
	 * 配列生成の為のタブを追加する。
	 * もしすでに存在する場合は，表示するだけ。
	 * @param title
	 */
	public void addArrayGenerator(String title) {
		int idx = view.indexOfTab(title);
		if (idx == -1)
			view.addTab(title, new ArrayGenerator().getPanel());
		else
			view.setSelectedIndex(idx);
	}
	
	/**
	 * インスタンスのタブを追加する。
	 * すでに存在する場合は，表示するだけ。
	 * @param insName
	 * @param clsName
	 */
	public void addInstanceTab(String insName, String clsName) {
		int idx = view.indexOfTab(insName);
		if (idx == -1)
			view.addTab(insName, new ObjectView(insName, clsName).getPanel());
		else
			view.setSelectedIndex(idx);
	}
	
	public void addArrayTab(String insName, String clsName, int arrSize) {
		int idx = view.indexOfTab(insName);
		if (idx == -1)
			view.addTab(insName, new ArrayView(insName, clsName, arrSize).getPanel());
		else
			view.setSelectedIndex(idx);
	}
	

}
