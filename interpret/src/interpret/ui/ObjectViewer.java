package interpret.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import interpret.ui.component.InterpretLog;

@SuppressWarnings("serial")
public class ObjectViewer extends JPanel {
	private final String insName;
	private final Object object;

	private final JPanel methodPanel = new JPanel();
	private final JPanel methodInnerPanel = new JPanel();
	
	private final JScrollPane methodListScrollPane = new JScrollPane();
	private final MethodList methodList = new MethodList();
	private final JScrollPane paramTableScrollPane = new JScrollPane();
	private final ParamTable paramTable;
	
	private final JPanel objectPanel = new JPanel();
	private final JLabel objectLabel = new JLabel();

	private final JPanel fieldPanel = new JPanel();
	private final JScrollPane fieldsTableScrollPane = new JScrollPane();
	private final FieldTable fieldTable;

	private final JPanel buttonPanel = new JPanel();
	private final JSplitPane mainSplitPane = new JSplitPane();
	
	private final InvokeView invokeView;
	private final JPanel centerPanel = new JPanel();
	
	private final InterpretLog log = new InterpretLog();

	public ObjectViewer(String insName, Object object) {
		this(insName, object, new LinkedHashMap<String, Object>());
	}
	
	public ObjectViewer(String insName, Object object, Map<String, Object> createdObjects) {
		this.insName = insName;
		this.object = object;
		methodList.setClass(object.getClass());
		fieldTable = new FieldTable(insName, log);
		fieldTable.setObject(object);
		invokeView = new InvokeView(insName, object, log);
		paramTable = new ParamTable(invokeView);
		setupLayout();
		setupListener();
	}
	

	private void setupListener() {
		methodList.addListener(m -> {
			// 先にinvokeViewにメソッドを追加しておく
			invokeView.setMethod(m);
			paramTable.setClass(m == null ? (Class<?>[]) null : m.getParameterTypes());
		});
	}

	private void setupLayout() {
		setSize(700, 600);

		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, mainSplitPane);
		add(BorderLayout.SOUTH, buttonPanel);
		add(BorderLayout.NORTH, objectPanel);

		mainSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainSplitPane.setDividerLocation(300);
		mainSplitPane.setTopComponent(centerPanel);
		mainSplitPane.setBottomComponent(fieldPanel);

		centerPanel.setLayout(new GridLayout(1, 2));
		centerPanel.add(methodPanel);
		centerPanel.add(invokeView);
		methodPanel.setLayout(new BorderLayout());
		methodPanel.add(BorderLayout.NORTH, new JLabel("Method(s)"));
		methodPanel.add(BorderLayout.CENTER, methodInnerPanel);
		methodInnerPanel.setLayout(new GridLayout(2, 1));
		methodInnerPanel.add(methodListScrollPane);
		methodListScrollPane.setViewportView(methodList);
		JPanel paramPanel = new JPanel();
		paramPanel.setLayout(new BorderLayout());
		paramPanel.add(BorderLayout.NORTH, new JLabel("Method Param(s)"));
		paramPanel.add(BorderLayout.CENTER, paramTableScrollPane);
		methodInnerPanel.add(paramPanel);
		paramTableScrollPane.setViewportView(paramTable);

		fieldPanel.setLayout(new BorderLayout());
		fieldPanel.add(BorderLayout.NORTH, new JLabel("Field(s)"));
		fieldPanel.add(BorderLayout.CENTER, fieldsTableScrollPane);
		fieldsTableScrollPane.setViewportView(fieldTable);

		objectPanel.setLayout(new BorderLayout());
		objectPanel.add(BorderLayout.NORTH, new JLabel("object info."));
		objectLabel.setText(object.getClass().getSimpleName() + " " + insName + " = new " + object.getClass().getSimpleName() + "();");
		objectPanel.add(BorderLayout.CENTER, objectLabel);

	}
}
