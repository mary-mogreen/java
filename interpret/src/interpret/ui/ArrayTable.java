package interpret.ui;

import java.lang.reflect.Array;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

import interpret.ObjectData;
import interpret.ui.component.InterpretLog;
import interpret.ui.component.ObjectTable;
import interpret.util.TypedValue;

@SuppressWarnings("serial")
public class ArrayTable extends ObjectTable {

	private static final String[] COLUMN_NAMES = { "Index", "Value" };

	private Object array;
	private InterpretLog log;
	private String insName;
	
	public ArrayTable(String insName, InterpretLog log) {
		super();
		this.insName = insName;
		this.log = log;
		setModel(new ArraysTableModel());
		getColumn(COLUMN_NAMES[0]).setCellRenderer(
				(table, value, isSelected, hasFocus, i, j) -> new JLabel(String.valueOf(value)));
		getColumn(COLUMN_NAMES[1]).setCellRenderer(editor);
		getColumn(COLUMN_NAMES[1]).setCellEditor(editor);
		
	}


	public void setArray(Object array) {
		if (!array.getClass().isArray()) {
			throw new IllegalArgumentException("param 'array' is not array object.");
		}
		this.array = array;
		updateUI();
	}

	private class ArraysTableModel extends AbstractTableModel {

		@Override
		public int getRowCount() {
			return Array.getLength(array);
		}

		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public String getColumnName(int i) {
			return COLUMN_NAMES[i];
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
				log.append(insName + "[" + i + "] = " + ((TypedValue) value).getValue() + "\n");
				try {
					System.out.println("value: " + value + ", " + ((TypedValue) value).getValue());
					ObjectData od = ObjectData.getInstance();
					String ins = ((TypedValue) value).getValue().toString();
					System.out.println(od.getObject(((TypedValue) value).getValue().toString()));
					Array.set(array, i, ((TypedValue) value).getValue());
					log.append("" + ((TypedValue) value).getValue());
				} catch (ArrayStoreException e) {
					log.append(">> " + e);
				} finally {
					log.append("\n\n");
					log.show();
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
				return i;
			case 1:
				return new TypedValue(array.getClass().getComponentType(), Array.get(array, i));
			default:
				throw new AssertionError("");
			}
		}
	}
}