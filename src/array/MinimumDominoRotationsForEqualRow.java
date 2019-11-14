package array;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumDominoRotationsForEqualRow {
	
	public static int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] A = {1,1,4,4,1,4};
		int[] B = {4,4,1,1,4,1};
		System.out.println(minDominoRotations(A,B));
	}

}
