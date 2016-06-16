package interpret.ui.component;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class ObjectTable extends JTable {

	protected final ObjectCellEditor editor;

	public ObjectTable() {
		editor = new ObjectCellEditor();
	}
}
