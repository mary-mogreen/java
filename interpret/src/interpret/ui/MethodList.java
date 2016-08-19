package interpret.ui;

import java.awt.Color;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MethodList extends JList<Method> {

	private Method[] methods = new Method[0];
	private Method[] filteredMethods = methods;
	private final Set<MethodChangedListener> listeners = new HashSet<>();

	public MethodList() {
		setModel(new AbstractListModel<Method>() {

			@Override
			public int getSize() {
				if (filteredMethods.length == 0) {
					clearSelection();
				}

				return filteredMethods.length;
			}

			@Override
			public Method getElementAt(int i) {
				return filteredMethods[i];
			}
		});

		setCellRenderer((list, value, index, isSelected, hasFocus) -> {
			Method m = filteredMethods[index];
			String str = m.toString().replaceAll("java\\.lang\\.",  "").replaceAll(".+" + m.getName(), " " + m.getName());
			JLabel label = new JLabel(str);
			if (isSelected) {
				label.setForeground(Color.WHITE);
				label.setBackground(Color.GRAY);
				label.setOpaque(true);
			}
			return label;
		});

		addListSelectionListener(e -> {
			for (MethodChangedListener listener : listeners) {
				int i = getSelectedIndex();
				listener.onChange(i == -1 ? null : filteredMethods[i]);
			}
		});
	}

	public void setClass(Class<?> cls) {
		if (cls == null) {
			methods = new Method[0];
		} else {
			methods = cls.getMethods();
		}
		String[] mStrs = new String[methods.length];
		// 今，ソートしようとしているところ。文字列配列を利用してフィルタリングする予定。
		for (int i = 0; i < methods.length; i++) {
			mStrs[i] = methods[i].toString().replaceAll("java\\.lang\\.",  "").replaceAll(".+" + methods[i].getName(), " " + methods[i].getName());
			System.out.println("mStrs[" + i + "]: " + mStrs[i]);
		}
		String[] copy = mStrs.clone();
		Arrays.sort(mStrs);
		for (int i = 0; i < mStrs.length; i++)
			System.out.println("mStrs[" + i + "]: " + mStrs[i]);
		filteredMethods = new Method[methods.length];
		for (int i = 0; i < mStrs.length; i++) {
			for (int j = 0; j < copy.length; j++) {
				if (copy[j].equals(mStrs[i])) {
					filteredMethods[i] = methods[j];
				}
			}
		}
		
		// filteredMethods = methods;
		updateUI();
	}

	public Method getSelectedMethod() {
		int i = getSelectedIndex();
		if (i == -1) {
			return null;
		} else {
			return filteredMethods[i];
		}
	}

	public boolean addListener(MethodChangedListener listener) {
		return listeners.add(listener);
	}

	public boolean removeListener(MethodChangedListener listener) {
		return listeners.remove(listener);
	}

	public interface MethodChangedListener {
		void onChange(Method method);
	}

	public void filter(String text) {
		if (text == null || text.isEmpty()) {
			filteredMethods = methods;
		} else {
			filteredMethods = (Method[]) Arrays.stream(methods).filter(m -> m.getName().contains(text))
					.toArray(i -> new Method[i]);
		}
		clearSelection();
		updateUI();
	}
}
