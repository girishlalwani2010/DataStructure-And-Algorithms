package datastructure.array;

public class MaxProductSubArray {
	
	static int maxProductSubarray(int []arr){
		int currentProduct = 1;
		int maxProduct = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			currentProduct = currentProduct*arr[i];
			if(currentProduct>maxProduct) {
				maxProduct = currentProduct;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
	}

}
