/**
 *
 */
package ch01.ex08;

/**
 * @author yuuya katoh
 *
 */
public class Point {
	public double x, y;

	/**
	 * 座標をゼロにクリアーする
	 */
	public void clear() {
		x = 0.0;
		y = 0.0;
	}

	/**
	 * 他の座標とのユークリッド距離を計算し、倍精度の浮動小数点として結果を返す
	 * @param Point
	 * @return {double} diff
	 */
	public double distance(Point that) {
		double xdiff = x - that.x;
		double ydiff = y - that.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}

	/**
	 * 指定された座標へ移動する
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 渡されたオブジェクトの座標を自分の座標に設定する
	 */
	public void set(Point that) {
		this.x = that.x;
		this.y = that.y;
	}


}
