/**
 * 
 */
package interpret.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import interpret.actionlistener.CloseTabActionListener;

/**
 * @author katouyuuya
 * JTabbedPaneを拡張して閉じることができるTabbedPaneを実装。
 */
public class ClosableTabbedPane extends JTabbedPane {
	private transient MouseMotionListener hoverHandler;
	
	public ClosableTabbedPane() {
		super(TOP, SCROLL_TAB_LAYOUT);
	}
	
	public ClosableTabbedPane(int tabPlacement) {
		super(tabPlacement, SCROLL_TAB_LAYOUT);
	}
	
	@Override
	public void updateUI() {
		removeMouseMotionListener(hoverHandler);
		super.updateUI();
		
		if (hoverHandler == null) {
			hoverHandler = new MouseMotionAdapter() {
				private int prev = -1;
				@Override
				public void mouseMoved(MouseEvent e) {
					JTabbedPane  src = (JTabbedPane) e.getComponent();
					int focussed = src.indexAtLocation(e.getX(), e.getY());
					if (focussed == prev)
						return;
					for (int i = 0; i < src.getTabCount(); i++) {
						TabPanel tab = (TabPanel) src.getTabComponentAt(i);
						tab.setButtonVisible(i == focussed);
					}
					prev = focussed;
				}
			};
		}
		addMouseMotionListener(hoverHandler);
	}
	@Override
	public void addTab(String title, final Component content) {
		super.addTab(title, content);
		setTabComponentAt(getTabCount() - 1, new TabPanel(this, title, content));
	}
	
	
	
	public class TabPanel extends JPanel {
	    private static final int PREFERRED_TAB_WIDTH = 80;
	    private final JButton button = new JButton(new CloseTabIcon()) {
	        @Override
	        public void updateUI() {
	            super.updateUI();
	            setBorder(BorderFactory.createEmptyBorder());
	            setBorderPainted(false);
	            setFocusPainted(false);
	            setContentAreaFilled(false);
	            setFocusable(false);
	            setVisible(false);
	        }
	    };
	    private final JLabel label = new JLabel() {
	        @Override
	        public Dimension getPreferredSize() {
	            Dimension dim = super.getPreferredSize();
	            int bw = button.isVisible() ? button.getPreferredSize().width : 0;
	            return new Dimension(PREFERRED_TAB_WIDTH - bw, dim.height);
	        }
	    };
	    public TabPanel(final JTabbedPane pane, String title, final Component content) {
	        super(new BorderLayout());
	        setOpaque(false);

	        label.setText(title);
	        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1));

	        button.addActionListener(new CloseTabActionListener(pane, content));
	        add(label);
	        add(button, BorderLayout.EAST);
	    }
	    public void setButtonVisible(boolean flag) {
	        button.setVisible(flag);
	    }
	}

	class CloseTabIcon implements Icon {
	    @Override
	    public void paintIcon(Component c, Graphics g, int x, int y) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.translate(x, y);
	        g2.setPaint(Color.BLACK);
	        g2.drawLine(2, 3, 9, 10);
	        g2.drawLine(2, 4, 8, 10);
	        g2.drawLine(3, 3, 9, 9);
	        g2.drawLine(9, 3, 2, 10);
	        g2.drawLine(9, 4, 3, 10);
	        g2.drawLine(8, 3, 2, 9);
	        g2.dispose();
	    }
	    @Override public int getIconWidth() {
	        return 12;
	    }
	    @Override public int getIconHeight() {
	        return 12;
	    }
	}

}
