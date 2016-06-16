package interpret.ui;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

import interpret.ui.component.InterpretLog;
import interpret.ui.component.ObjectTable;
import util.Reflection;
import util.TypedValue;

@SuppressWarnings("serial")
public class FieldTable extends ObjectTable {

	private static final String[] COLUMN_NAMES = { "Modifier", "Type", "Name", "Value" };

	private Object object;
	private Field[] fields = new Field[0];
	private final InterpretLog log;
	private final String insName;

	public FieldTable(String insName, InterpretLog log) {
		super();
		this.insName = insName;
		this.log = log;
		setModel(new ArgumentsTableModel());
		getColumn(COLUMN_NAMES[0]).setCellRenderer(
				(table, value, isSelected, hasFocus, i, j) -> new JLabel(Modifier
						.toString(fields[i].getModifiers())));
		getColumn(COLUMN_NAMES[1]).setCellRenderer(
				(table, value, isSelected, hasFocus, i, j) -> new JLabel(fields[i].getType()
						.getCanonicalName()));
		getColumn(COLUMN_NAMES[2]).setCellRenderer(
				(table, value, isSelected, hasFocus, i, j) -> new JLabel(fields[i].getName()));
		getColumn(COLUMN_NAMES[3]).setCellRenderer(editor);
		getColumn(COLUMN_NAMES[3]).setCellEditor(editor);
	}

	public void setObject(Object object) {
		this.object = object;
		if (object == null) {
			fields = new Field[0];
		} else {
			fields = object.getClass().getDeclaredFields();
		}
		updateUI();
	}

	private class ArgumentsTableModel extends AbstractTableModel {

		@Override
		public int getRowCount() {
			return fields.length;
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
				return false;
			case 2:
				return false;
			case 3:
				return true;
			default:
				throw new AssertionError("");
			}
		}

		@Override
		public void setValueAt(Object obj, int i, int j) {
			switch (j) {
			case 0:
			case 1:
			case 2:
				break;
			case 3:
				log.append(insName + "." + fields[i].getName() + " = " + ((TypedValue) obj).getValue() + "\n");
				try {
					Reflection.setField(object, fields[i], ((TypedValue) obj).getValue());
					log.append("> "+ ((TypedValue) obj).getValue() + "\n");
				} catch (Throwable e) {
					log.append(">> " + e + "\n\n");
				} finally {
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
				return Modifier.toString(fields[i].getModifiers());
			case 1:
				return fields[i].getType();
			case 2:
				return fields[i].getName();
			case 3:
				try {
					return new TypedValue(fields[i].getType(), Reflection.getField(object,
							fields[i]));
				} catch (Throwable e) {
					e.printStackTrace();
				}
			default:
				throw new AssertionError("");
			}
		}
	}
}
