package interpret.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import interpret.AppData;
import interpret.ObjectData;
import interpret.ui.ParamObjectCreator;
import interpret.util.TypedValue;

@SuppressWarnings("serial")
public class ObjectCellEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private Class<?> type;
	private JComponent editor;
	private Object selectedValue;
	

	@Override
	public Component getTableCellRendererComponent(JTable table, Object typedValueObj, boolean isSelected,
			boolean hasFocus, int row, int column) {
		TypedValue typedValue = (TypedValue) typedValueObj;
		final Class<?> type = typedValue.getType();
		final Object value = typedValue.getValue();

		if (isNumberClass(type)) {
			return new JLabel(String.valueOf(value));
		} else if (type == char.class) {
			return new JLabel(String.valueOf(value));
		} else if (type == boolean.class) {
			JCheckBox jCheckBox = new JCheckBox("true?");
			jCheckBox.setSelected((Boolean) value);
			return jCheckBox;
		} else if (type.isEnum()) {
			return new JLabel(String.valueOf(value));
		} else if (type == String.class) {
			return new JLabel(String.valueOf(value));
		} else {
			// return new JTextField(String.valueOf(value));
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.add(BorderLayout.CENTER, new JLabel(String.valueOf(value)));
			panel.add(BorderLayout.EAST, new JButton());
			return panel;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Component getTableCellEditorComponent(JTable table, Object typedValueObj, boolean isSelected, int row,
			int column) {
		TypedValue typedValue = (TypedValue) typedValueObj;
		this.type = typedValue.getType();
		final Object value = typedValue.getValue();

		if (isNumberClass(type)) {
			editor = new NumberSpinner((Class<? extends Number>) type, (Number) value);
		} else if (type == char.class || type == String.class) {
			editor = new JTextField(value == null ? "" : String.valueOf(value));
		} else if (type == boolean.class) {
			JCheckBox jCheckBox = new JCheckBox();
			jCheckBox.setSelected((Boolean) value);
			jCheckBox.setBackground(Color.white);
			jCheckBox.addItemListener(e -> stopCellEditing());
			editor = jCheckBox;
		} else if (type.isEnum()) {
			EnumComboBox jEnumComboBox = new EnumComboBox((Class<? extends Enum<?>>) type, (Enum<?>) value);
			jEnumComboBox.addPopupMenuListener(new PopupMenuListener() {
				@Override
				public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
				}

				@Override
				public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
					stopCellEditing();
				}

				@Override
				public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
					stopCellEditing();
				}
			});
			editor = jEnumComboBox;
		} else {
			// JTextField tf = new JTextField(value == null ? "" : String.valueOf(value));
			// editor = tf;
			JPanel clsPanel = new JPanel();
			
			String[] strs = ObjectData.getInstance().getSKeys(this.type);
			JComboBox<String> cmb = new JComboBox<String>(strs);
			JTextField insNameField = new JTextField(value == null ? "null" : String.valueOf(value));
			JButton paramCreateBtn = new JButton("add");
			clsPanel.setLayout(new BorderLayout());
			clsPanel.add(BorderLayout.CENTER, cmb);
			clsPanel.add(BorderLayout.EAST, paramCreateBtn);
			String insName = insNameField.getText();
			
			paramCreateBtn.addActionListener(e -> {
				String btnTxt = paramCreateBtn.getText();
				AppData ad = AppData.getInstance();
				ClosableTabbedPane tab = (ClosableTabbedPane)ad.getObject(AppData.TABPANE);
				tab.addTab("new " + this.type.getSimpleName(), new ParamObjectCreator(this.type.getName(), cmb));
				tab.setSelectedIndex(tab.getComponentCount() - 2);
			});
			editor = clsPanel;
		}
		return editor;
	}

	@Override
	public Object getCellEditorValue() {
		Object value;
		if (isNumberClass(type)) {
			value = ((NumberSpinner) editor).getPrimitiveValue();
		} else if (type == char.class) {
			value = ((JTextField) editor).getText().charAt(0);
		} else if (type == boolean.class) {
			value = ((JCheckBox) editor).isSelected();
		} else if (type.isEnum()) {
			value = ((EnumComboBox) editor).getSelectedItem();
		} else if (type.isArray()) {
			value = this.selectedValue;
		} else if(type == String.class) {
			value = ((JTextField) editor).getText();
		} else {
			ObjectData od = ObjectData.getInstance();
			System.out.println(editor.getComponentCount() + " , " + editor.getComponent(0).getClass().getTypeName());
			// value = od.getObject((String)((JTextField) editor.getComponent(0)).getText());
			value = od.getObject(((JComboBox) editor.getComponent(0)).getSelectedItem().toString());
			// value = null;
		}

		return new TypedValue(type, value);
	}

	private boolean isNumberClass(Class<?> type) {
		return type == byte.class || type == short.class || type == int.class || type == long.class
				|| type == float.class || type == double.class;
	}
}
