package bits;

public class BitUtil {
	
	public static long reverseBits(long x) {
		for (int i = 0; i < 16; i++) {
			x = swapBits(x, i, 32 - i - 1);
		}
	 
		return x;
	}
	 
	public static long swapBits(long x, int i, int j) {
		long a = (x >> i) & 1;
		long b = (x >> j) & 1;
	 
		if ((a ^ b) != 0) {
			return x ^= (1 << i) | (1 << j);
		}
	 
		return x;
	}
	 
	/* Driver function to test above function */
	public static void main(String[] args) {
		long x = 2147483648L; 
	    System.out.println(reverseBits(x));
	}
	
}
