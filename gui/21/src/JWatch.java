/**
 *
 */
package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author mary-mogreen
 *
 */


public class JWatch extends JFrame implements Runnable{
	static int hour;
	static int minute;
	static int second;

    public static void main(String args[]) {
    	JWatch watch = new JWatch("Watch 2-1");
    	Thread th = new Thread(watch);

        watch.setSize(300, 300);
        watch.setVisible(true);

        th.start();
    }

    public JWatch(String title) {
    	super(title);
    	JPanel panel = new JPanel() {
    		protected void paintComponent(Graphics g) {
    			super.paintComponent(g);
    			Dimension size = getSize();
    	    	g.setColor(Color.WHITE);
    	    	g.fillRect(0, 0, size.width, size.height);
    	    	
    	    	// 円
    	    	g.setColor(Color.BLACK);
    	    	int cWidth = 250;
    	    	int cHeight = 250;
    	    	g.drawOval((size.width - cWidth) / 2, (size.height - cHeight) / 2 + 10, cWidth, cHeight);

    	    	// 矩形
    	    	g.setColor(Color.LIGHT_GRAY);
    	    	int dWidth = 160;
    	    	int dHeight = 32;
    	        g.fillRect((size.width - dWidth) / 2, (size.height - dHeight) / 2 + 10, dWidth, dHeight);

    	        // 時間の文字列
    	        String time = String.format("%02d", hour) + ":"
    						+ String.format("%02d", minute) + ":"
    						+ String.format("%02d", second);
    	        int fontSize = 32; //px
    	        Font font = new Font(Font.MONOSPACED, Font.BOLD, fontSize);
    	        g.setFont(font);
    	        g.setColor(Color.DARK_GRAY);
    	        g.drawString(time, (size.width - fontSize * 5) / 2 + 5, size.height / 2 + 20);
    		}
    	};
    	getContentPane().add(panel);
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
}