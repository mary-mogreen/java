package src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferStrategy;
import java.util.Calendar;

@SuppressWarnings("serial")
public class ClockCanvas extends Canvas implements Runnable {


	private static final int REFRESH_INTERVAL = 1;
    private static final int BUFFER_SIZE = 2; // Double buffering
    private BufferStrategy bufferStrategy;
    private Dimension dimension = new Dimension(504, 300);
    private Flip hour1, hour2, minute1, minute2, second1, second2;
    private int flipWidth;
    private int flipHeight;
    private int offsetX;

	public ClockCanvas() {
		setForeground(new Color(0, 255, 0));
        setBackground(new Color(50, 50, 50));
        new AppWindow(this);
        createBufferStrategy(BUFFER_SIZE);
        bufferStrategy = getBufferStrategy();
        flipWidth = 70;
        offsetX = (dimension.width - flipWidth * 6) / 7;
        flipHeight = 70;
        hour1 = new Flip(offsetX + flipWidth / 2, dimension.height / 2, flipWidth, flipHeight);
        hour2 = new Flip((2*offsetX + flipWidth /2 * 3), dimension.height / 2, flipWidth, flipHeight);
        minute1 = new Flip((int)(3*offsetX + 2.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        minute2 = new Flip((int)(4*offsetX + 3.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        second1 = new Flip((int)(5*offsetX + 4.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        second2 = new Flip((int)(6*offsetX + 5.5 * flipWidth), dimension.height / 2, flipWidth, flipHeight);
        new Thread(this).start();
	}

	private void draw() {
        Graphics graphics = bufferStrategy.getDrawGraphics();
        if (!bufferStrategy.contentsLost()) {
            graphics.clearRect(0, 0, getSize().width, getSize().height);
            ((Graphics2D) graphics).setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            //graphics = updateClock(graphics);
            //graphics = updatePataPata(graphics);
            graphics = updateFlip(graphics);
            bufferStrategy.show();
            graphics.dispose();
        }
    }


	private Font labelFont = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
    private Font clockFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);

	private Graphics updateClock(Graphics graphics) {
	        graphics.setFont(labelFont);
	        //graphics.drawString("現在時刻", MARGIN_LEFT, CLOCK_BASELINE);
	        graphics.setFont(clockFont);
	        graphics.drawString(getTime(), 20, 10 + clockFont.getSize());
	        return graphics;
	}


	double theta = 0.0;
	double p1x = -35.0;
	double p2x = p1x + 70.0;
	double p3x = p2x;
	double p4x = p1x;
	double p1y = -70.0;
	double p2y = p1y;
	double p3y = p2y + 70.0;
	double p4y = p3y;

	double[] xPoint = {p1x, p2x, p3x, p4x};
	double[] yPoint = {p1y, p2y, p3y, p4y};
	double[] zPoint = {0.0, 0.0, 0.0, 0.0};
	int num = 0;
	private Graphics updatePataPata(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g.translate(150, 150);

		theta = theta + 2;
		double rad = Math.toRadians(theta%180);
		if (theta%180 == 54)
			num = (num + 1) % 10;
		// 後ろ側
		g2.setColor(new Color(100,50,200));
//		AffineTransform af = new AffineTransform();
//		af.setToTranslation(40d, 50d);
//		g2.setTransform(af);
		g2.fill3DRect(-35, -70, 70, 70, false);

		// 後ろ側の文字
		g2.setClip(-35, -70, 70, 70);
		Shape s1 = g2.getClip();
		g2.clip(s1);
		g2.setColor(new Color(200, 200, 200));
		g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
		g2.drawString(String.valueOf(num), -35, 40);

		g2.setClip(-150, -150, dimension.width, dimension.height);
		Shape s = g2.getClip();
		//g2.clip(s);

		// 下側
		g2.setColor(new Color(100,50,200));
//		AffineTransform af = new AffineTransform();
//		af.setToTranslation(40d, 50d);
//		g2.setTransform(af);
		g2.fill3DRect(-35, 0, 70, 70, false);

		// 下側の表示

		if (theta%180 >= 54 && theta%180 <= 115) {
			g2.setClip(-35, 0, 70, 70);
			g2.setColor(new Color(200, 200, 200));
			g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
			g2.drawString(String.valueOf(num-1), -35, 40);
		} else {
			g2.setClip(-35, 0, 70, 70);
			g2.setColor(new Color(200, 200, 200));
			g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
			g2.drawString(String.valueOf(num), -35, 40);

		}

		g2.setClip(-150, -150, dimension.width, dimension.height);

		// 上側
		g2.setColor(new Color(100,50,200));
		//AffineTransform af2 = new AffineTransform();
		//af.setToTranslation(40d, 50d);
		//af2.setToTranslation((p1x+p2x)/2,(p1y+p3y)/2);
		//g2.setTransform(af2);
		int[] xp = new int[4];
		int[] yp = new int[4];
		for (int i = 0; i < 4; i++) {
			if (i < 2) {
				double y = yPoint[i] * Math.cos(rad) - zPoint[i] * Math.sin(rad);
				int sign = i == 0 ? -1: +1;
				xp[i] = sign * (int)(40.0 / 580.0 * (580.0 - Math.abs(y)));
				//xPoint[i] = xPoint[i] * Math.cos(rad) - yPoint[i] * Math.sin(rad);
				//yPoint[i] = xPoint[i] * Math.sin(rad) + yPoint[i] * Math.cos(rad);
				yp[i] = (int)y;
				//zPoint[i] = yPoint[i] * Math.sin(rad) + zPoint[i] * Math.cos(rad);
			} else {
				xp[i] = (int)xPoint[i];
				yp[i] = (int)yPoint[i];
			}
		}

		//af2.setToTranslation(150, 150);
		//g2.setTransform(af2);

		g2.fillPolygon(xp, yp, 4);

		// 上側の文字列
		if (theta%180 < 54) {
			g2.setClip(-35, -70, 70, 70);
			g2.setColor(new Color(200, 200, 200));
			g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
			g2.drawString(String.valueOf(num), -35, 40);
		} else if (theta%180 > 115) {
			g2.setClip(-35, 0, 70, 70);
			g2.setColor(new Color(200, 200, 200));
			g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
			g2.drawString(String.valueOf(num), -35, 40);
		}
//
//		g2.setColor(new Color(150,50,150));
//		g2.fill3DRect(150, 185, 70, 70, true);
//
//		g2.setColor(new Color(255, 0, 0));
//		theta = theta + 0.01;
//		g2.rotate(theta, 185, 150);
//		g2.draw3DRect(150, 15, 100, 50, true);
//
//		theta = theta + 0.01;
//		g2.rotate(theta, 185, 150);
//		g2.draw3DRect(170, 40, 100, 50, false);
//
//

		return g2;
	}

	private Graphics updateFlip(Graphics g) {
		Calendar next = Calendar.getInstance();
		g = hour1.updateFlip(g, next.get(Calendar.HOUR_OF_DAY)/10);
		g = hour2.updateFlip(g, next.get(Calendar.HOUR_OF_DAY)%10);
		g = minute1.updateFlip(g, next.get(Calendar.MINUTE)/10);
		g = minute2.updateFlip(g, next.get(Calendar.MINUTE)%10);
		g = second1.updateFlip(g, next.get(Calendar.SECOND)/10);
		g = second2.updateFlip(g, next.get(Calendar.SECOND)%10);
		return g;
	}

	Font getClockFont() {
		return clockFont;
	}

	void setClockFont(Font font) {
        clockFont = font;
        // Simulate preferred size
        Label tempLabel = new Label(getTime());
        tempLabel.setFont(font);
        Frame frame = new Frame();
        frame.add(tempLabel);
        frame.pack();
        dimension = frame.getPreferredSize();
        dimension.height += 1;
        dimension.width += 20 + 15; // add margin
        draw();
    }

	@Override
	    public Dimension getPreferredSize() {
	        return dimension;
	}

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

	private String getTime() {
		Calendar now = Calendar.getInstance();
		int h = now.get(Calendar.HOUR_OF_DAY);
		int m = now.get(Calendar.MINUTE);
		int s = now.get(Calendar.SECOND);
		int ms = now.get(Calendar.MILLISECOND);
		//System.out.printf("%02d:%02d:%02d:%03d", h, m, s, ms);
		return String.format("%02d:%02d:%02d:%03d", h, m, s, ms);
	}


	@Override
	public void run() {
		while (true) {
            // repaint();
            draw();
            try {
                Thread.sleep(REFRESH_INTERVAL); // Update in 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

}
