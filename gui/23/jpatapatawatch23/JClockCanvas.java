package jpatapatawatch23;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import jpatapatawatch23.JAppWindow;
import jpatapatawatch23.JFlip;
import jpatapatawatch23.JWatchProperties;


@SuppressWarnings("serial")
public class JClockCanvas extends JPanel implements Runnable {


	private static final int REFRESH_INTERVAL = 1;
    // private static final int BUFFER_SIZE = 2; // Double buffering
    // private BufferStrategy bufferStrategy;
    private JFlip hour1, hour2, minute1, minute2, second1, second2;
    private int flipWidth;
    private int flipHeight;
    private int offsetX = 12;
    private int offsetY = 36; // 36
    private JWatchProperties props = JWatchProperties.getInstance();
    private Dimension dimension = new Dimension(props.getWidth(), props.getHeight());
    JAppWindow window;
	private int flipOriginX;
	private int flipOriginY;

	public JClockCanvas() {
		setForeground(new Color(0, 255, 0));
        setBackground(new Color(50, 50, 50));
 
        this.window = new JAppWindow(this);
        // createBufferStrategy(BUFFER_SIZE);
        // bufferStrategy = getBufferStrategy();
        flipWidth = 70;
        //offsetX = (dimension.width - flipWidth * 6) / 7;
        flipHeight = 70;
        hour1 = new JFlip(offsetX + flipWidth / 2, dimension.height, flipWidth, flipHeight);
        hour2 = new JFlip((2*offsetX + flipWidth /2 * 3), dimension.height / 2, flipWidth, flipHeight);
        minute1 = new JFlip((int)(3*offsetX + 2.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        minute2 = new JFlip((int)(4*offsetX + 3.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        second1 = new JFlip((int)(5*offsetX + 4.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        second2 = new JFlip((int)(6*offsetX + 5.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        JLabel hColon = new JLabel(":");
        hColon.setLocation((2*offsetX + flipWidth /2 * 3) + (offsetX + flipWidth) / 2, dimension.height);
        JLabel mColon = new JLabel(":");
        mColon.setLocation((int)(4*offsetX + 3.5 * flipWidth) + (offsetX + flipWidth) / 2, dimension.height);
        new Thread(this).start();
	}

	private void resize() {
		int width = flipWidth * 6 + offsetX * 7;
		int height = flipWidth * 2 + offsetY * 2;

		dimension.setSize(width, height);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
	// private void draw() {
        // Graphics graphics = getGraphics();
        		// bufferStrategy.getDrawGraphics();
        int w = getMaxWidth((Graphics2D)graphics);
		flipWidth = (int) (w);
        resize();
		window.setSize(dimension);
        // if (!bufferStrategy.contentsLost()) {
        graphics.clearRect(0, 0, dimension.width, dimension.height);
        ((Graphics2D) graphics).setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setColor(props.getBgColor());
        graphics.fillRect(0, 0, dimension.width, dimension.height);
        graphics = updateFlip(graphics);
   //      bufferStrategy.show();
        graphics.dispose();
    // }
        // frame.setBackground(props.getBgColor());
    }

	private Graphics updateFlip(Graphics g) {
		// ((Graphics2D) g).setBackground(props.getBgColor());
		Calendar next = Calendar.getInstance();
		flipOriginX = offsetX + flipWidth / 2;
		flipOriginY = dimension.height /2 ;
		hour1.resize(flipOriginX, flipOriginY, (int)(flipWidth), (int)(flipWidth));
		hour2.resize((2*offsetX + flipWidth /2 * 3), flipOriginY, flipWidth, flipWidth);
        minute1.resize((int)(3*offsetX + 2.5 * flipWidth), flipOriginY, flipWidth, flipWidth);
        minute2.resize((int)(4*offsetX + 3.5 * flipWidth), flipOriginY, flipWidth, flipWidth);
        second1.resize((int)(5*offsetX + 4.5 * flipWidth), flipOriginY, flipWidth, flipWidth);
        second2.resize((int)(6*offsetX + 5.5 * flipWidth), flipOriginY, flipWidth, flipWidth);
		g = hour1.updateFlip(g, next.get(Calendar.HOUR_OF_DAY)/10);
		g = hour2.updateFlip(g, next.get(Calendar.HOUR_OF_DAY)%10);
		g = minute1.updateFlip(g, next.get(Calendar.MINUTE)/10);
		g = minute2.updateFlip(g, next.get(Calendar.MINUTE)%10);
		g = second1.updateFlip(g, next.get(Calendar.SECOND)/10);
		g = second2.updateFlip(g, next.get(Calendar.SECOND)%10);
		
		return g;
	}

	private int getMaxWidth(Graphics2D g2) {
		Font f = props.getFontFamily().deriveFont((float)props.getFontSize());
		FontRenderContext frc = g2.getFontRenderContext();
		int w = 0;
		Rectangle2D r;
		for (int i = 0; i < 10; i++) {
			r = f.getStringBounds(Integer.toString(i), frc);
			if (r.getWidth() > w)
				w = (int) r.getWidth();
		}
		return w;
	}


	@Override
	public Dimension getPreferredSize() {
	        return dimension;
	}

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
 

	@Override
	public void run() {
		while (true) {
            repaint();
            // draw();
            try {
                Thread.sleep(REFRESH_INTERVAL); // Update in 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}


}
