/**
 *
 */
package src;

import java.awt.BorderLayout;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author mary-mogreen
 *
 */
@SuppressWarnings("serial")
public class AppWindow extends Window implements ActionListener {
	ClockCanvas canvas;
	private MenuItem exitMenu;
	private int pressedX;
	private int pressedY;

	AppWindow(ClockCanvas canvas) {
		super(null, null);
		this.canvas = canvas;

        // Frame configuration
        setLayout(new BorderLayout());
        addWindowListener(new AppCloseAdapter());
        setIgnoreRepaint(true);
        add(canvas, BorderLayout.CENTER);
        setAlwaysOnTop(true);

        // Menu configuration
        WatchPopupMenu wp = new WatchPopupMenu();
        PopupMenu popupMenu = wp.getPopupMenu();

        // exitメニュー
        exitMenu = new MenuItem("Exit", new MenuShortcut('E'));
        exitMenu.addActionListener(this);
        popupMenu.add(exitMenu);

        pack();
        canvas.add(popupMenu);
        canvas.addMouseListener(new AppMouseAdapter(popupMenu));
        canvas.addMouseMotionListener(new AppMouseMotionAdapter());
        setLocationRelativeTo(null);
        setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
        if (source.equals(exitMenu)) {
            System.out.println();
            System.exit(0);
        }
	}

	void resize() {
        pack();
    }

	class AppMouseAdapter extends MouseAdapter {

        PopupMenu popupMenu;

        public AppMouseAdapter(PopupMenu popupMenu) {
            this.popupMenu = popupMenu;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            pressedX = e.getX();
            pressedY = e.getY();
            if (e.isPopupTrigger())
                popupMenu.show(canvas, e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mousePressed(e);
        }
    }

	class AppMouseMotionAdapter extends MouseMotionAdapter {
	    @Override
	    public void mouseDragged(MouseEvent e) {
	    	setLocation(getX() + e.getX() - pressedX, getY() + e.getY()
            - pressedY);
	    }
	}
}

class AppCloseAdapter extends WindowAdapter {
	@Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
