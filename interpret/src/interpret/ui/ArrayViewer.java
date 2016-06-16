package interpret.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import interpret.ui.component.InterpretLog;

@SuppressWarnings("serial")
public class ArrayViewer extends JPanel {
	private final String insName;
	private final Object array;
	private int size;

	private final JPanel methodPanel = new JPanel();
	private final JPanel methodInnerPanel = new JPanel();
	
	private final JScrollPane methodListScrollPane = new JScrollPane();
	private final MethodList methodList = new MethodList();
	private final JScrollPane paramTableScrollPane = new JScrollPane();
	private final ParamTable paramTable;
	
	private final JPanel objectPanel = new JPanel();
	private final JLabel objectLabel = new JLabel();

	private final JPanel elementPanel = new JPanel();
	private final JScrollPane elementTableScrollPane = new JScrollPane();
	private final ArrayTable arrayTable;
	
	private final JPanel buttonPanel = new JPanel();
	private final JSplitPane mainSplitPane = new JSplitPane();
	
	private final InvokeView invokeView;
	private final JPanel centerPanel = new JPanel();
	
	private final InterpretLog log = new InterpretLog();

	
	public ArrayViewer(String insName, Object array, int size) {
		this.insName = insName;
		this.array = array;
		this.size = size;
		methodList.setClass(array.getClass());
		arrayTable = new ArrayTable(insName, log);
		arrayTable.setArray(array);
		// fieldTable = new FieldTable(createdObjects, insName, log);
		// fieldTable.setObject(object);
		invokeView = new InvokeView(insName, array, log);
		paramTable = new ParamTable(invokeView);
		setupLayout();
		setupListener();
	}
	

	private void setupListener() {
		methodList.addListener(m -> {
			paramTable.setClass(m == null ? (Class<?>[]) null : m.getParameterTypes());
			invokeView.setMethod(m);
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
		mainSplitPane.setBottomComponent(elementPanel);

		centerPanel.setLayout(new GridLayout(1, 2));
		centerPanel.add(methodPanel);
		centerPanel.add(invokeView);
		methodPanel.setLayout(new BorderLayout());
		methodPanel.add(BorderLayout.NORTH, new JLabel("Method(s)"));
		methodPanel.add(BorderLayout.CENTER, methodInnerPanel);
		// methodPanel.add(BorderLayout.SOUTH, invokeButton);
		methodInnerPanel.setLayout(new GridLayout(2, 1));
		methodInnerPanel.add(methodListScrollPane);
		methodListScrollPane.setViewportView(methodList);
		JPanel paramPanel = new JPanel();
		paramPanel.setLayout(new BorderLayout());
		paramPanel.add(BorderLayout.NORTH, new JLabel("Method Param(s)"));
		paramPanel.add(BorderLayout.CENTER, paramTableScrollPane);
		methodInnerPanel.add(paramPanel);
		paramTableScrollPane.setViewportView(paramTable);

		elementPanel.setLayout(new BorderLayout());
		elementPanel.add(BorderLayout.NORTH, new JLabel("Array Element(s)"));
		elementPanel.add(BorderLayout.CENTER, elementTableScrollPane);
		elementTableScrollPane.setViewportView(arrayTable);

		objectPanel.setLayout(new BorderLayout());
		objectPanel.add(BorderLayout.NORTH, new JLabel("object info."));
		String name = array.getClass().getSimpleName();
		objectLabel.setText(name + " " + insName + " = new " + name.substring(0, name.length() - 1) + size + "];");
		objectPanel.add(BorderLayout.CENTER, objectLabel);

	}
}
