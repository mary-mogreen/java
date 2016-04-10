/**
 *
 */
package src;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

/**
 * @author mary-mogreen
 *
 */


public class Watch2 extends Frame implements Runnable, ActionListener{
	static int hour;
	static int minute;
	static int second;
	int width = 300;
	int height = 360;

	Image back;
	Graphics buffer;
	Dialog dialog;
	Properties props;

    public static void main(String args[]) {
    	Watch2 watch = new Watch2("Watch 1-2");
    	Thread th = new Thread(watch);

        watch.setSize(watch.width, watch.height);
        watch.setVisible(true);

        watch.back = watch.createImage(watch.width, watch.height);
        watch.buffer = watch.back.getGraphics();

        th.start();
    }

    public Watch2(String title) {
    	super(title);
    	props = new Properties();
    	MenuBar menubar = new MenuBar();
    	Menu menu = new Menu("Window");
    	MenuItem menuitem = new MenuItem("プロパティ");
    	menuitem.addActionListener(this);
    	menu.add(menuitem);
    	menubar.add(menu);
    	setMenuBar(menubar);


    	addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			System.exit(0);
    		}
    	});
    }

    public void run(){
        while(true){
              hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
              minute = Calendar.getInstance().get(Calendar.MINUTE);
              second = Calendar.getInstance().get(Calendar.SECOND);
              repaint();

              try{
                  Thread.sleep(1000);  //スリープ１秒
              }catch(InterruptedException e){
              }
        }
    }

    public void update(Graphics g) {
    	paint(g);
    }

    public void paint(Graphics g)
    {
    	Dimension size = getSize();
    	// 円
    	buffer.setColor(Color.BLACK);
    	int cWidth = 250;
    	int cHeight = 250;
    	buffer.drawOval((size.width - cWidth) / 2, (size.height - cHeight) / 2 + 10, cWidth, cHeight);

    	// 矩形
    	buffer.setColor(props.getColor());
    	int dWidth = 160;
    	int dHeight = 32;
        buffer.fillRect((size.width - dWidth) / 2, (size.height - dHeight) / 2 + 10, dWidth, dHeight);

        // 時間の文字列
        String time = String.format("%02d", hour) + ":"
					+ String.format("%02d", minute) + ":"
					+ String.format("%02d", second);
        int fontSize = 32; //px
        Font font = new Font(Font.MONOSPACED, Font.BOLD, fontSize);
        buffer.setFont(font);
        buffer.setColor(Color.LIGHT_GRAY);
        buffer.drawString(time, (size.width - fontSize * 5) / 2 + 5, size.height / 2 + 20);

        g.drawImage(back, 0, 0, this);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		//Dialog dialog = null;
		String action = e.getActionCommand();
		if (action.equals("プロパティ")) {
			dialog = new PropertyDialog(this, props);
		}
	}
}