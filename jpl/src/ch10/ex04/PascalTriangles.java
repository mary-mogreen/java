/**
 *
 */
package ch10.ex04;

/**
 * @author mary-mogreen
 *
 */
public class PascalTriangles {
	int[][] pascalTriangles;


	public void createPascalTriangles(int depth) {
		pascalTriangles = new int[depth][];
		int i = 0;
		while (i < depth) {
			pascalTriangles[i] = new int[i + 1];
			int j = 0;
			while (j < i + 1) {
				if (j == 0 || j == i)
					pascalTriangles[i][j] = 1;
				else
					pascalTriangles[i][j] = pascalTriangles[i - 1][j - 1] + pascalTriangles[i - 1][j];
				j++;
			}
			i++;
		}
	}

	public void showPascalTriangles() {
		int i = 0;
		while (i < pascalTriangles.length) {
			int j = 0;
			while (j < pascalTriangles[i].length) {
				System.out.printf("%d ", pascalTriangles[i][j]);
				j++;
			}
			i++;
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

		Integer a = new Integer(100);
		Integer b = new Integer(100);
		Integer c = Integer.valueOf(100);
		Integer d = Integer.valueOf(100);
		Integer e = 100;
		System.out.println("a == b => " + (a == b));
		System.out.println("c == d => " + (c == d));
		System.out.println("a == d => " + (a == d));
		System.out.println("b == d => " + (b == d));
		System.out.println("c == a => " + (c == a));
		System.out.println("c == b => " + (c == b));
		System.out.println("e == d => " + (e == d));
		System.out.println("e == c => " + (e == c));
		System.out.println("e == a => " + (e == a));
		System.out.println("e == b => " + (e == b));
	}

}
