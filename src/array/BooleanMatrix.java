package array;

/**
 * @author girish_lalwani
 *
 *         Given a boolean matrix mat[M][N] of size M X N, modify it such that
 *         if a matrix cell mat[i][j] is 1 (or true) then make all the cells of
 *         ith row and jth column as 1.
 */
public class BooleanMatrix {

	public static int[][] modifyMatrix(int mat[][]) {

		boolean is_zero_col_contains_one = false;
		boolean is_zero_row_contains_one = false;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i == 0 && mat[i][j] == 1 && !is_zero_col_contains_one) {
					is_zero_col_contains_one = true;
				}
				if (j == 0 && mat[i][j] == 1 && !is_zero_row_contains_one) {
					is_zero_row_contains_one = true;
				}
				if (mat[i][j] == 1) {
					mat[0][j] = 1;
					mat[i][0] = 1;
				}
			}
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (mat[0][j] == 1 || mat[i][0] == 1) {
					mat[i][j] = 1;
				}
			}
		}

		if (is_zero_col_contains_one == true) {
			for (int i = 0; i < mat[0].length; i++) {
				mat[0][i] = 1;
			}
		}

		if (is_zero_row_contains_one == true) {
			for (int i = 0; i < mat.length; i++) {
				mat[i][0] = 1;
			}
		}

		return mat;
	}

	public static void printMatrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
	}

	// Driver function to test the above function
	public static void main(String args[]) {

		int mat[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

		System.out.println("Input Matrix :");
		printMatrix(mat);

		mat = modifyMatrix(mat);

		System.out.println("Matrix After Modification :");
		printMatrix(mat);

	}

}
