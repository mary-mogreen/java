package gui.clock;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import gui.clock.ui.Flip;



@SuppressWarnings("serial")
public class ClockCanvas extends JPanel implements Runnable {


	private static final int REFRESH_INTERVAL = 20;
    // private static final int BUFFER_SIZE = 2; // Double buffering
    // private BufferStrategy bufferStrategy;
    private Flip hour1, hour2, minute1, minute2, second1, second2;
    private int flipWidth;
    private int flipHeight;
    private int offsetX = 12;
    private int offsetY = 36; // 36
    private WatchProperties props = WatchProperties.getInstance();
    private Dimension dimension = new Dimension(props.getWidth(), props.getHeight());
    AppFrame frame;
	private int flipOriginX;
	private int flipOriginY;

	public ClockCanvas() {
		setForeground(new Color(0, 255, 0));
        setBackground(new Color(50, 50, 50));
        this.frame = new AppFrame(this);
        // createBufferStrategy(BUFFER_SIZE);
        // bufferStrategy = getBufferStrategy();
        flipWidth = 70;
        //offsetX = (dimension.width - flipWidth * 6) / 7;
        flipHeight = 70;
        hour1 = new Flip(offsetX + flipWidth / 2, dimension.height, flipWidth, flipHeight);
        hour2 = new Flip((2*offsetX + flipWidth /2 * 3), dimension.height / 2, flipWidth, flipHeight);
        minute1 = new Flip((int)(3*offsetX + 2.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        minute2 = new Flip((int)(4*offsetX + 3.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        second1 = new Flip((int)(5*offsetX + 4.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        second2 = new Flip((int)(6*offsetX + 5.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        JLabel hColon = new JLabel(":");
        hColon.setLocation((2*offsetX + flipWidth /2 * 3) + (offsetX + flipWidth) / 2, dimension.height);
        JLabel mColon = new JLabel(":");
        mColon.setLocation((int)(4*offsetX + 3.5 * flipWidth) + (offsetX + flipWidth) / 2, dimension.height);
        new Thread(this).start();
	}

	private void resize() {
		int width = flipWidth * 6 + offsetX * 7;
		int height = flipWidth * 2 + offsetY * 4;

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
		frame.setSize(dimension);
        // if (!bufferStrategy.contentsLost()) {
        graphics.clearRect(0, 0, dimension.width, dimension.height);
        ((Graphics2D) graphics).setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Color bg = props.getBgColor();
        bg = new Color(bg.getRed(), bg.getGreen(), bg.getBlue(), 100);
        graphics.setColor(bg);
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
		flipOriginY = dimension.height /2 - 26 ;
		int add = offsetX + flipWidth;
		hour1.resize(flipOriginX, flipOriginY, (int)(flipWidth), (int)(flipWidth));
		flipOriginX += add;
		hour2.resize(flipOriginX, flipOriginY, flipWidth, flipWidth);
//		flipOriginX += flipWidth;
//		g.setColor(Color.BLACK);
//		g.setFont(props.getFontFamily().deriveFont(props.getFontStyle(), props.getFontSize()));
//		g.drawString(":", flipOriginX, flipOriginY);
        flipOriginX += add;
		minute1.resize(flipOriginX, flipOriginY, flipWidth, flipWidth);
		flipOriginX += add;
		minute2.resize(flipOriginX, flipOriginY, flipWidth, flipWidth);
		flipOriginX += add;
		second1.resize(flipOriginX, flipOriginY, flipWidth, flipWidth);
		flipOriginX += add;
		second2.resize(flipOriginX, flipOriginY, flipWidth, flipWidth);
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
