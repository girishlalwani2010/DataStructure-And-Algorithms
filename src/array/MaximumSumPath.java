package array;

public class MaximumSumPath {
	
	static int maxPathSum(int arr1[], int arr2[]){
		int sum1=0,sum2=0, i=0 , j=0, result=0;
		while(i<arr1.length && j<arr2.length){
			
			if(arr1[i]<arr2[j]){
				sum1 = sum1 + arr2[i++];
			}
			
			else if(arr2[j]<arr1[i]){
				sum2= sum2 + arr1[j++];
			}
			
			else{
				result = result + Math.max(sum1, sum2);
				
				sum1=0;
				sum2=0;
				
				while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) 
	                {
	                    result = result + arr1[i++];
	                    j++;
	                }
				 
			}
			
		}
		
		result = result + Math.max(sum1, sum2);
		
		return result;
	}
	
	

	public static void main(String[] args) {
		
		int arr1[] = {2,3,7,10};
		int arr2[] = {1,5,7,8};
		
		System.out.println(maxPathSum(arr1,arr2));
	}
	
	
}
