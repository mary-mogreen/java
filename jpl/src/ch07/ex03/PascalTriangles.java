/**
 *
 */
package ch07.ex03;

/**
 * @author mary-mogreen
 *
 */
public class PascalTriangles {
	int[][] pascalTriangles;

	public void createPascalTriangles(int depth) {
		pascalTriangles = new int[depth][];
		for(int i = 0; i < depth; i++) {
			pascalTriangles[i] = new int[i + 1];
			for(int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i)
					pascalTriangles[i][j] = 1;
				else
					pascalTriangles[i][j] = pascalTriangles[i - 1][j - 1] + pascalTriangles[i - 1][j];
			}
		}
	}

	public void showPascalTriangles() {
		for (int[] p: pascalTriangles) {
			for (int i: p)
				System.out.printf("%d ", i);
			System.out.printf("%n");
		}
	}

	public void showPascalTriangles(int depth) {
		createPascalTriangles(depth);
		showPascalTriangles();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PascalTriangles pt = new PascalTriangles();
		pt.createPascalTriangles(12);
		pt.showPascalTriangles();

		pt.showPascalTriangles(12);

		pt.showPascalTriangles(20);

		//pt.showPascalTriangles(-1);
	}

}
