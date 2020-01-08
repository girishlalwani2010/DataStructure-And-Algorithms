package binarysearch;

public class FindFirstandLastPositionofElementinSortedArray {
	
	
	 public static  int[] searchRange(int[] a, int target) {
	        int[] position = {-1, -1};
	        if(a.length == 0){
	            return new int[]{-1,-1};
	        }
	        int low = 0;
	        int high = a.length-1;
	        while(low<=high){
	            int mid = low+(high-low)/2;
	            if(a[mid] == target && (mid ==0 || a[mid]>a[mid-1])){
	                position[0] = mid;
	                break;
	            }
	            if(a[mid]>=target){
	                high = mid-1;
	            }else{
	                low = mid+1;
	            }
	        }
	        
	        low = 0;
	        high = a.length;
	        while(low<=high){
	            int mid = low+(high-low)/2;
	            if(a[mid] == target && (mid == a.length-1 || a[mid]<a[mid+1])){
	                position[1] = mid;
	                break;
	            }
	            if(a[mid]>target){
	                high = mid-1;
	            }else{
	                low = mid+1;
	            }
	        }
	        
	        return position;
	    }
	 
	 public static void main(String[] args) {
		 int []a = {2,2};
		 int target = 3;
		System.out.println(searchRange(a, target));
	}

}
