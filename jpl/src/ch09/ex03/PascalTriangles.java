/**
 *
 */
package ch09.ex03;

/**
 * @author mary-mogreen
 *
 */
public class PascalTriangles {
	/**
	 * パスカルの三角形配列を返す
	 * 前回のもの
	 * @param depth
	 * @return
	 */
	public static int[][] createPascalTriangles(int depth) {
		int[][] pascalTriangles = new int[depth][];
		for(int i = 0; i < depth; i++) {
			pascalTriangles[i] = new int[i + 1];
			for(int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i)
					pascalTriangles[i][j] = 1;
				else
					pascalTriangles[i][j] = pascalTriangles[i - 1][j - 1] + pascalTriangles[i - 1][j];
			}
		}
		return pascalTriangles;
	}

	/**
	 * パスカルの三角形を表示するだけのもの（配列使っていない）
	 * @param a
	 */
	public static void p(int a) {
		for (int c = 1; c <= a; c++) {
			for (int n = c, m = 0, k = 0; n > 0; n--, m++)
				System.out.printf("%d ", k == 0 ? k = 1 : (k = k * n / m));
			System.out.println("");
		}
	}

	/**
	 * 【新しい】パスカルの三角形の配列を作成する
	 * 演算子を利用
	 * @param a
	 * @return
	 */
	public static int[][] pa(int a) {
		int[][] pt = new int[a][];
		for (int c = 1; c <= a; c++) {
			pt[c - 1] = new int[c];
			for (int n = c, m = 0, k = 0; n > 0; n--, m++)
				pt[c - 1][m] = k == 0 ? k = 1: (k = k * n / m);
		}
		return pt;
	}

	/**
	 * 二次元配列を表示する
	 * @param pt
	 */
	public static void showPascalTriangles(int[][] pt) {
		for (int[] p: pt) {
			for (int i: p)
				System.out.printf("%d ", i);
			System.out.printf("%n");
		}
	}

	/**
	 * パスカルの三角形を表示する
	 * @param depth
	 */
	public static void showPascalTriangles(int depth) {
		showPascalTriangles(pa(depth));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//pt.showPascalTriangles(-1);
		p(12);

		showPascalTriangles(12);


	}

}
