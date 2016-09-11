/**
 *
 */
package jpatapatawatch;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author p000526463
 *
 */
public class JFlip {

	private int flipOriginX;
	private int flipOriginY;
	private int width;
	private int height;

	private double[] xPoint = new double[4];
	private double[] yPoint = new double[4];
	private double[] zPoint = {0.0, 0.0, 0.0, 0.0};

	private int now = 0;
	private double theta = 0.0;

	public JFlip(int flipOriginX, int flipOriginY, int width, int height) {
		this.flipOriginX = flipOriginX;
		this.flipOriginY = flipOriginY;
		this.width = width;
		this.height = height;

		xPoint[0] = -width / 2;
		yPoint[0] = -height;

		xPoint[1] = -xPoint[0];
		yPoint[1] = yPoint[0];

		xPoint[2] = xPoint[1];
		yPoint[2] = 0.0;

		xPoint[3] = xPoint[0];
		yPoint[3] = yPoint[2];
	}
	public void resize(int flipOriginX, int flipOriginY, int width, int height) {
		this.flipOriginX = flipOriginX;
		this.flipOriginY = flipOriginY;
		this.width = width;
		this.height = height;

		xPoint[0] = -width / 2;
		yPoint[0] = -height;

		xPoint[1] = -xPoint[0];
		yPoint[1] = yPoint[0];

		xPoint[2] = xPoint[1];
		yPoint[2] = 0.0;

		xPoint[3] = xPoint[0];
		yPoint[3] = yPoint[2];
	}

	public Graphics updateFlip(Graphics g, int next) {
		JWatchProperties props = JWatchProperties.getInstance();
		Font f = props.getFontFamily().deriveFont((float)props.getFontSize());
		Graphics2D g2 = (Graphics2D)g;
		g.translate(flipOriginX, flipOriginY);

		if (now != next)
			theta = (theta + 6) % 180;

		double rad = Math.toRadians(theta%180);
		// 後ろ側
		g2.setColor(props.getFlipColor());
		g2.setClip((int)xPoint[0], (int)yPoint[0], width, height);
		g2.fill3DRect((int)xPoint[0], (int)yPoint[0], width, height, false);

		// 後ろ側の文字
		g2.setClip((int)xPoint[0], (int)yPoint[0], width, height);
		g2.setColor(props.getColor()); // atode
		g2.setFont(f); // atode
		g2.drawString(String.valueOf(next), (int)xPoint[0], 5 + height/2);

		//元に戻す
		//g2.setClip(-flipOriginX, flipOriginY, 370, 300);

		g2.setClip((int)xPoint[3], (int)yPoint[3], width, height); // 下の領域のクリップ
		// 下側
		g2.setColor(props.getFlipColor());
		g2.fill3DRect((int)xPoint[3], (int)yPoint[3], width, height, false);

		// 下側の文字列表示
		g2.setClip((int)xPoint[3], (int)yPoint[3], width, height); // 下の領域のクリップ
		g2.setColor(props.getColor());
		g2.setFont(f);
		if (theta%180 >= 54 && theta%180 <= 115) {
			g2.drawString(String.valueOf(now), (int)xPoint[3], 5 + height / 2);
		} else {
			g2.drawString(String.valueOf(next), (int)xPoint[3], 5 + height / 2);
		}

		//元に戻す
		//g2.setClip(-flipOriginX, flipOriginY, 370, 300);
		g2.setClip((int)xPoint[0], (int)yPoint[0], width, height * 2);
		// 上側
		g2.setColor(props.getFlipColor());

		int[] xp = new int[4];
		int[] yp = new int[4];
		for (int i = 0; i < 4; i++) {
			if (i < 2) {
				double y = yPoint[i] * Math.cos(rad) - zPoint[i] * Math.sin(rad);
				int sign = i == 0 ? -1: +1;
				xp[i] = sign * (int)(0.5 * (3*width - Math.abs(y)));
				yp[i] = (int)y;
			} else {
				xp[i] = (int)xPoint[i];
				yp[i] = (int)yPoint[i];
			}
		}
		g2.fillPolygon(xp, yp, 4); // パタパタ動く矩形

		// 上側の文字列
		g2.setColor(props.getColor());

		g2.setFont(f);
		if (theta%180 < 54) {
			g2.setClip((int)xPoint[0], (int)yPoint[0], width, height); // 上の領域のクリップ
			g2.drawString(String.valueOf(next), (int)xPoint[0], 5 + height / 2);
		} else if (theta%180 > 115) {
			g2.setClip((int)xPoint[3], (int)yPoint[3], width, height); // 下の領域のクリップ
			g2.drawString(String.valueOf(next), (int)xPoint[0], 5 + height / 2);
		}

		//元に戻す
		//g2.setClip(-flipOriginX, flipOriginY, 370, 300);

		g2.setClip((int)xPoint[0], (int)yPoint[0], width, height * 2);
		if (theta == 0)
			this.now = next;

		g.translate(-flipOriginX, -flipOriginY);
		return g2;
	}
}
