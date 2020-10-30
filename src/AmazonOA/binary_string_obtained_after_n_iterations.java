package AmazonOA;

import java.io.*;

class binary_string_obtained_after_n_iterations {
// Function to find 
// the i-th character 
	static void KthCharacter(int m, int n, int k) {
		// distance between two
		// consecutive elements
		// after N iterations
		int distance = (int) Math.pow(2, n);
		int Block_number = k / distance;
		int remaining = k % distance;

		int s[] = new int[32];
		int x = 0;

		// binary representation of M
		for (; m > 0; x++) {
			s[x] = m % 2;
			m = m / 2;
		}

		// kth digit will be
		// derived from root
		// for sure
		int root = s[Block_number];	

		if (remaining == 0) {
			System.out.println(root);
			return;
		}

		// Check whether there is
		// need to flip root or not
		Boolean flip = true;
		while (remaining > 1) {
			if ((remaining & 1) > 0) {
				flip = !flip;
			}
			remaining = remaining >> 1;
		}

		if (flip) {
			System.out.println((root == 1) ? 0 : 1);
		} else {
			System.out.println(root);
		}
	}

// Driver Code 
	public static void main(String[] args) {
		int m = 5, k = 3, n = 3;
		KthCharacter(m, n, k);
	}
}