/**
 *
 */
package patapatawatch;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Point;
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
public class AppFrame extends Frame implements ActionListener {
	ClockCanvas canvas;
	private MenuItem exitMenu;
	private int pressedX;
	private int pressedY;
	private PropertiesDialog dialog;
	private MenuBar menubar;
	private MenuItem menuitem;
	WatchProperties props = WatchProperties.getInstance();

	public AppFrame(ClockCanvas canvas) {
		super(null, null);
		this.canvas = canvas;
		
		// MenuBar
		menubar = new MenuBar();
    	Menu menu = new Menu("設定");
    	MenuItem menuitem = new MenuItem("プロパティ");
    	menuitem.addActionListener(e -> {
  			dialog = new PropertiesDialog(this);
  			dialog.setVisible(true);
    	});
    	menu.add(menuitem);
    	menubar.add(menu);
    	setMenuBar(menubar);

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
        	props.setDimension(getSize());
    		props.setLocation(getLocation());
    		props.update();
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
		WatchProperties props = WatchProperties.getInstance();
		props.setDimension(e.getWindow().getSize());
		props.setLocation(e.getWindow().getLocation());
		props.update();
        System.exit(0);
    }
}
