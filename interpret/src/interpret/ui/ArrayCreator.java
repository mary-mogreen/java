/**
 * 
 */
package interpret.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interpret.ObjectData;
import interpret.listener.ChangeTitleListener;
import interpret.ui.component.ClassNameField;
import interpret.ui.component.NumberSpinner;

/**
 * @author katouyuuya
 *
 */
@SuppressWarnings("serial")
public class ArrayCreator extends JPanel implements Creator {
	private final Set<ChangeTitleListener> listeners = new HashSet<ChangeTitleListener>();
	// インスタンス名，クラス名入力
	private JPanel initView;
	private final JLabel insNameLabel = new JLabel("instance name: ");
	private JTextField insNameField;
	private final JLabel clsNameLabel = new JLabel("class name: ");
	private ClassNameField clsNameField;
	private final JLabel szLabel = new JLabel("size: ");
	private NumberSpinner szField;
	private final JButton createBtn = new JButton("create");
	// オブジェクトを表示する
	private ArrayViewer arrayViewer;
	private JLabel insName = new JLabel();
	private JLabel clsName = new JLabel();
	
	JPanel cardPanel;
	CardLayout layout;
	JPanel btnPanel;
	
	public ArrayCreator(String insName, String clsName) {
		this();
		insNameField.setText(insName);
		clsNameField.setText(clsName);
	}
	
	public ArrayCreator() {
		layout = new CardLayout();
		
		cardPanel = new JPanel();
		cardPanel.setLayout(layout);
		
		initView = new JPanel();
//		initView.setLayout(new GridLayout(2, 2));
		initView.setLayout(new BorderLayout());
		insNameField = new JTextField(20);
		clsNameField = new ClassNameField(20);
		szField = new NumberSpinner(int.class, 0);
		
		insNameField.setMaximumSize(insNameField.getPreferredSize());
		clsNameField.setMaximumSize(clsNameField.getPreferredSize());
		szField.setMaximumSize(szField.getPreferredSize());

		JPanel innerInitPanel = new JPanel();
		innerInitPanel.setLayout(new BoxLayout(innerInitPanel, BoxLayout.Y_AXIS));
		innerInitPanel.setAlignmentY(0.5f);
		
		JPanel insNamePanel = new JPanel();
		insNamePanel.setLayout(new BoxLayout(insNamePanel, BoxLayout.X_AXIS));
		insNamePanel.add(insNameLabel);
		insNamePanel.add(insNameField);
		JPanel clsNamePanel = new JPanel();
		clsNamePanel.setLayout(new BoxLayout(clsNamePanel, BoxLayout.X_AXIS));
		clsNamePanel.add(clsNameLabel);
		clsNamePanel.add(clsNameField);
		JPanel szPanel = new JPanel();
		szPanel.setLayout(new BoxLayout(szPanel, BoxLayout.X_AXIS));
		szPanel.add(szLabel);
		szPanel.add(szField);
		
		innerInitPanel.add(insNamePanel);
		innerInitPanel.add(clsNamePanel);
		innerInitPanel.add(szPanel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new BorderLayout());
		btnPanel.add(BorderLayout.EAST, createBtn);
		initView.add(BorderLayout.CENTER, innerInitPanel);
		initView.add(BorderLayout.SOUTH, btnPanel);
	    
	    createBtn.addActionListener(e -> {
	    	String ins = insNameField.getText();
	    	ObjectData od = ObjectData.getInstance();
	    	if (od.get(ins)) {
	    		ins = "";
	    	}
			Class<?> clas = clsNameField.getClassObject();
			if (!ins.isEmpty() && clas != null) {
				insName.setText(ins);
				clsName.setText(clas.getName());
			} else {
				return;
			}
			clsNameField.updateClass();
			try {
				Class<?> cls = clsNameField.getClassObject();
				if (cls == null) {
					
					JOptionPane.showMessageDialog(ArrayCreator.this, "Class not found.");
					return;
				}
				int length = Integer.parseInt(szField.getValue().toString());
				Object array = Array.newInstance(cls, length);
				od.put(insNameField.getText(), array);
				arrayViewer = new ArrayViewer(insNameField.getText(), array, (int)szField.getValue());
				for (ChangeTitleListener listener: listeners) listener.onChange(insName.getText());
				cardPanel.add(arrayViewer, "array");
				layout.show(cardPanel, "array");
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(ArrayCreator.this, "Invalid array length.");
			}
		});
		
		// Array Viewer
	    
		cardPanel.add(initView, "init");
		
		setLayout(new GridLayout(1, 1));
		add(cardPanel);		
		
	}

	@Override
	public boolean addChangeTitleListener(ChangeTitleListener listener) {
		return listeners.add(listener);
		
	}

	@Override
	public boolean removeChangeTitleListener(ChangeTitleListener listener) {
		return listeners.remove(listener);
	}
}
