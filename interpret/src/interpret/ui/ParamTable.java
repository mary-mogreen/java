package interpret.ui;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

import interpret.ui.component.ObjectTable;
import interpret.util.TypedValue;

@SuppressWarnings("serial")
public class ParamTable extends ObjectTable {

	private final String[] columnNames = { "Type", "Value" };

	private static final Class<?>[] EMPTY_TYPES = new Class<?>[0];
	private static final Class<?>[] EMPTY_PARAMS = new Class<?>[0];

	private Class<?>[] types = EMPTY_TYPES;
	private Object[] params = EMPTY_PARAMS;
	
	private InvokeView invokeView = null;

	public ParamTable() {
		this(null);
	}
	public ParamTable(InvokeView invokeView) {
		super();
		this.invokeView = invokeView;
		setModel(new ArgumentTableModel());
		getColumn(columnNames[0]).setCellRenderer((table, value, isSelected, hasFocus, i, j) -> {
			return new JLabel(((Class<?>) value).getCanonicalName().replaceAll("java\\.lang\\.", ""));
		});
		getColumn(columnNames[1]).setCellRenderer(editor);
		getColumn(columnNames[1]).setCellEditor(editor);
	}

	public void setClass(Class<?>... types) {
		if (types == null) {
			this.types = EMPTY_TYPES;
			params = EMPTY_PARAMS;
		} else {
			this.types = types;
			params = new Object[types.length];
		}

		for (int i = 0; i < this.types.length; i++) {
			if (types[i] == byte.class || types[i] == Byte.class) {
				params[i] = (byte) 0;
			} else if (types[i] == short.class) {
				params[i] = (short) 0;
			} else if (types[i] == int.class) {
				params[i] = 0;
			} else if (types[i] == long.class) {
				params[i] = 0L;
			} else if (types[i] == float.class) {
				params[i] = (float) 0;
			} else if (types[i] == double.class) {
				params[i] = (double) 0;
			} else if (types[i] == char.class) {
				params[i] = ' ';
			} else if (types[i] == boolean.class) {
				params[i] = false;
			} else {
				params[i] = null;
			}
			// 初期値生成時にinvokeViewにも反映させるように修正。
			if(invokeView != null) {
				invokeView.setParam(i, params[i]);
			}
		}
		updateUI();
	}

	public Object[] getValues() {
		return params;
	}
	

	private class ArgumentTableModel extends AbstractTableModel {

		@Override
		public int getRowCount() {
			return types.length;
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public String getColumnName(int i) {
			return columnNames[i];
		}

		@Override
		public boolean isCellEditable(int i, int j) {
			switch (j) {
			case 0:
				return false;
			case 1:
				return true;
			default:
				throw new AssertionError("");
			}
		}

		@Override
		public void setValueAt(Object value, int i, int j) {
			switch (j) {
			case 0:
				break;
			case 1:
				params[i] = ((TypedValue) value).getValue();
				if (invokeView != null) {
					invokeView.setParam(i, params[i]);
				}
				break;
			default:
				throw new AssertionError("");
			}
		}

		@Override
		public Object getValueAt(int i, int j) {
			switch (j) {
			case 0:
				return types[i];
			case 1:
				return new TypedValue(types[i], params[i]);
			default:
				throw new AssertionError("");
			}
		}
	}
}
