/**
 * 
 */
package interpret.ui;

import java.awt.BorderLayout;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interpret.ui.component.InterpretLog;
import interpret.util.Reflection;

/**
 * @author katouyuuya
 *
 */
@SuppressWarnings("serial")
public class InvokeView extends JPanel {
	
	private final String insName;
	private Method method;
	private Object[] params;
	
	private final JPanel invokeView;
	private final JLabel invokeLabel = new JLabel("Invoke");
	private final JTextField commandField = new JTextField();
	private final JButton invokeButton = new JButton("invoke");
	private StringBuilder buffer;
	// private StringBuilder log = new StringBuilder();
	
	public InvokeView(String insName, Object object, InterpretLog log) {
		this.insName = insName;
		JPanel commandPanel = new JPanel();
		
		
		invokeView = new JPanel();
		invokeView.setLayout(new BorderLayout());
		invokeView.add(BorderLayout.NORTH, invokeLabel);
		invokeView.add(BorderLayout.CENTER, commandPanel);
		commandPanel.setLayout(new BorderLayout());
		commandPanel.add(BorderLayout.NORTH, commandField);
		commandPanel.add(BorderLayout.CENTER, invokeButton);
		
		commandField.setMaximumSize(commandField.getPreferredSize());
		commandField.setEditable(false);
		invokeButton.setMaximumSize(invokeButton.getPreferredSize());
		
		invokeButton.addActionListener(e -> {
			if (method != null) {
				log.append(buffer.toString() + "\n"); 
				try {
					Object returnValue = Reflection.invoke(object, method, params);
					if (returnValue == null) {
						log.append("> void.\n\n");
					} else {
						log.append("> " + String.valueOf(returnValue) + "\n\n");
					}
				} catch (Throwable t) {
					log.append(">> " + t.toString() + "\n\n");
				} finally {
					log.show();
				}
			}
		});
		
		initBuffer();
		commandField.setText(buffer.toString());
		
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, invokeView);
		add(BorderLayout.CENTER, log);
		
	}
	
	public InvokeView() {
		this("insName", new Object(), new InterpretLog());
	}

	public void initBuffer() {
		buffer = new StringBuilder();
		buffer.append(insName + ".");
	}
	
	public void setMethod(Method method) {
		this.method = method;
		params = new Object[method.getParameterTypes().length];
		buffer = new StringBuilder(insName + ".");
		buffer.append(method.getName() + " ");
		commandField.setText(buffer.toString());
	}
	
	public void setText(){}

	public void setParam(int idx, Object param) {
		params[idx] = param;
		// 指摘：invokeの文字列は間違いを消せるように。正しい引数を表示するように変更する。
		initBuffer();
		buffer.append(this.method.getName() + " ");
		for (Object prm: params) {
			buffer.append(prm == null ? "null " : prm.toString()  + " ");
		}
		// buffer.append(param == null ? "null " : param.toString()  + " ");
		commandField.setText(buffer.toString());
	}
}
