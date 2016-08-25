/**
 * 
 */
package interpret.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import interpret.ObjectData;
import interpret.listener.ChangeTitleListener;
import interpret.ui.component.ClassNameField;
import interpret.util.Reflection;

/**
 * @author katouyuuya
 *
 */
@SuppressWarnings("serial")
public class ParamObjectCreator extends JPanel implements Creator {
	private final Set<ChangeTitleListener> listeners = new HashSet<ChangeTitleListener>();
	// インスタンス名，クラス名入力
	private JPanel initView;
	private final JLabel insNameLabel = new JLabel("instance name: ");
	private JTextField insNameField;
	private final JLabel clsNameLabel = new JLabel("class name: ");
	private ClassNameField clsNameField;
	private final JButton toConstructorBtn = new JButton("next");
	// コンストラクタ選択
	private JPanel constructorView;
	private final JScrollPane constructorListPane = new JScrollPane();
	private final JPanel constructorListPanel = new JPanel();
	private final ConstructorList constructorList = new ConstructorList();
	private final JButton toParamBtn = new JButton("next");
	// コンストラクタのパラメータ入力
	private final JPanel constructorParamView;
	private final JScrollPane constructorParamTablePane = new JScrollPane();
	private final JPanel constructorParamTablePanel = new JPanel();
	private final ParamTable constructorParamTable = new ParamTable();
	private final JButton createBtn = new JButton("create");
	// オブジェクトを表示する
	private ObjectViewer objectViewer;
	private JLabel insName = new JLabel();
	private JLabel clsName = new JLabel();
	
	JPanel cardPanel;
	CardLayout layout;
	JPanel btnPanel;
	
	private JComboBox<String> cmb;
	
	
	public ParamObjectCreator(String clsName, JComboBox<String> cmb) {
		this(cmb);
		System.out.println("clsName: " + clsName);
		clsNameField.setText(clsName);
		clsNameField.setEditable(false);
	}
	
	private ParamObjectCreator(JComboBox<String> cmb) {
		setName("new Object");
		this.cmb = cmb;
		
		layout = new CardLayout();
		
		cardPanel = new JPanel();
		cardPanel.setLayout(layout);
		
		initView = new JPanel();
		initView.setLayout(new BorderLayout());
		insNameField = new JTextField(20);
		clsNameField = new ClassNameField(20);
		clsNameField.addClassChangedListener(cls -> {
			constructorList.setClass(cls);
			toConstructorBtn.setEnabled(false);
		});
		
		insNameField.setMaximumSize(insNameField.getPreferredSize());
		clsNameField.setMaximumSize(clsNameField.getPreferredSize());

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
		
		innerInitPanel.add(insNamePanel);
		innerInitPanel.add(clsNamePanel);

		
		toConstructorBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ins = insNameField.getText();
				ObjectData od = ObjectData.getInstance();
				// 名前にnullを使えないことを追加。
		    	if (od.get(ins) || "null".equals(ins)) {
		    		ins = "";
		    	}
				Class<?> cls = clsNameField.getClassObject();
				if (!ins.isEmpty() && cls != null && !cls.isInterface()) {
					insName.setText(ins);
					clsName.setText(cls.getName());
					constructorList.setClass(cls);
					layout.show(cardPanel, "constructor");
				} else {
					return;
				}
						
			}	    	
	    });
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new BorderLayout());
		btnPanel.add(BorderLayout.EAST, toConstructorBtn);
		initView.add(BorderLayout.CENTER, innerInitPanel);
		initView.add(BorderLayout.SOUTH, btnPanel);
		
		
		// コンストラクタのリストを表示
		constructorView = new JPanel();
		constructorView.setLayout(new BorderLayout());
		constructorView.add(BorderLayout.CENTER, constructorListPanel);
		createBtn.setEnabled(false);
		constructorListPanel.setLayout(new BorderLayout());
		constructorListPanel.add(BorderLayout.NORTH, new JLabel("Constructor(s)"));
		constructorListPanel.add(BorderLayout.CENTER, constructorListPane);
		constructorListPane.setViewportView(constructorList);
		constructorList.addConstructorChangedListener(constructor -> {
			constructorParamTable.setClass(constructor == null ? null : constructor.getParameterTypes());
			createBtn.setEnabled(constructor != null);
		});
		
	    toParamBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (constructorList.getConstructors().length == 0) {
					layout.show(cardPanel, "parameter");
				} else if(constructorList.getSelectedConstructor() == null) {
					return;
				} else {
					layout.show(cardPanel, "parameter");
				}
			}
	    });
	    
	    btnPanel = new JPanel();
		btnPanel.setLayout(new BorderLayout());
		btnPanel.add(BorderLayout.EAST, toParamBtn);
		constructorView.add(BorderLayout.SOUTH, btnPanel);
	    
		// コンストラクタのパラメータリストを表示する
		constructorParamView = new JPanel();
		constructorParamView.setLayout(new BorderLayout());
		constructorParamView.add(BorderLayout.CENTER, constructorParamTablePanel);
		constructorParamTablePanel.setLayout(new BorderLayout());
		constructorParamTablePanel.add(BorderLayout.NORTH, new JLabel("Constructor Param(s)"));
		constructorParamTablePanel.add(BorderLayout.CENTER, constructorParamTablePane);
		constructorParamTablePane.setViewportView(constructorParamTable);
		
		
	    createBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Constructor<?> constructor = constructorList.getSelectedConstructor();
					Object[] arguments = constructorParamTable.getValues();
					Object object = Reflection.construct(constructor, arguments);
					objectViewer = new ObjectViewer(insName.getText(), object);
					for (ChangeTitleListener listener: listeners) listener.onChange(insName.getText());
					ObjectData.getInstance().put(insName.getText(), object);
					if (cmb != null)
						cmb.addItem(insName.getText());
					cardPanel.add(objectViewer, "object");
					layout.show(cardPanel, "object");
				} catch (Throwable t) {
					JOptionPane.showMessageDialog(ParamObjectCreator.this, t.toString());
				}
				
			}
	    });
	    btnPanel = new JPanel();
		btnPanel.setLayout(new BorderLayout());
		btnPanel.add(BorderLayout.EAST, createBtn);
	    constructorParamView.add(BorderLayout.SOUTH, btnPanel);
		
		cardPanel.add(initView, "init");
		cardPanel.add(constructorView, "constructor");
		cardPanel.add(constructorParamView, "parameter");
		
		
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
