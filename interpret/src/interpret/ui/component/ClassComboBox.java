package interpret.ui.component;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ClassComboBox extends JComboBox<Class<?>> {

	private final Class<?>[] classConstants;

	private Class<?> selectedItem;

	public ClassComboBox(Class<? extends Class<?>> type, Class<?> initialValue) {
		classConstants = type.getClasses();

		selectedItem = initialValue;

		setModel(new ClassListModel());
	}

	private class ClassListModel extends AbstractListModel<Class<?>>implements ComboBoxModel<Class<?>> {
		@Override
		public int getSize() {
			return classConstants.length;
		}

		@Override
		public Class<?> getElementAt(int i) {
			if (i >= classConstants.length) {
				return null;
			} else {
				return classConstants[i];
			}
		}

		@Override
		public void setSelectedItem(Object value) {
			selectedItem = (Class<?>) value;
		}

		@Override
		public Object getSelectedItem() {
			return selectedItem;
		}
	}
}
