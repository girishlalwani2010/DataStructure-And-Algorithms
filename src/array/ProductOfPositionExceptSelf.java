package array;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductOfPositionExceptSelf {
	
	  
	  static int[] arrayOfArrayProducts(int[] arr) {
	    
	    if(arr.length==0){
	      return new int[0];
	    }
	    // your code goes here
	    int[] leftProduct = new int[arr.length];
	    int[] rightProduct = new int[arr.length];
	    
	    Arrays.fill(leftProduct,1);
	    
	    int n = arr.length;
	    
	    for(int i=1; i<arr.length; i++){
	      leftProduct[i] = arr[i-1]*leftProduct[i-1];
	      rightProduct[n-i-1] = arr[n-i]*rightProduct[n-i];
	    }
	    
	    int[] output = new int[arr.length];
	    
	    for(int i=0; i<arr.length; i++){
	      output[i] = leftProduct[i]*rightProduct[i];
	    }
	    
	    return output;
	    
	  }
	  
	  static int[] arrayOfArrayProductsSpaceOptimized(int[] arr) {
		    
		    if(arr.length==0 || arr.length==1){
		      return new int[0];
		    }
		    // your code goes here
		    int[] leftProduct = new int[arr.length];
		    
		    Arrays.fill(leftProduct,1);
		    
		    int n = arr.length;
		    
		    for(int i=1; i<arr.length; i++){
		      leftProduct[i] = arr[i-1]*leftProduct[i-1];
		    }
		    
		    int[] output = new int[arr.length];
		    int rightProduct = 1;
		    
		    for(int i=n-1; i>=0; i--){
		      output[i] = leftProduct[i]*rightProduct;
		      rightProduct = arr[i]*rightProduct;
		    }
		    
		    return output;
		    
		  }


	  public static void main(String[] args) {
	    int[] arr = {2,7,3,4};
	    int[] output = arrayOfArrayProductsSpaceOptimized(arr);
	    System.out.println(Arrays.stream(output).boxed().collect(Collectors.toList()));
	  }

	}

