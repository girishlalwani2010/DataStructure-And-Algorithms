package array;

public class zalando1 {
	
	public static int solution(int[] A, int[] B) {
		long leftSumA[] = new long[A.length];
		long rightSumA[] = new long[A.length];
		
		leftSumA[0] = A[0];
		for(int i=1; i<A.length; i++) {
			leftSumA[i] = leftSumA[i-1]+A[i]; 
		}
		
		for(int i=A.length-1; i>0; i--) {
			rightSumA[i-1] = rightSumA[i]+A[i]; 
		}
		
		long leftSumB[] = new long[B.length];
		long rightSumB[] = new long[B.length];
		
		leftSumB[0] = B[0];
		for(int i=1; i<B.length; i++) {
			leftSumB[i] = leftSumB[i-1]+B[i]; 
		}
		
		for(int i=B.length-1; i>0; i--) {
			rightSumB[i-1] = rightSumB[i]+B[i]; 
		}
		int k=0;
		for(int i=0; i<A.length-1; i++) {
			if(leftSumA[i] == rightSumA[i] && rightSumA[i]==leftSumB[i] && leftSumB[i] == rightSumB[i]) {
				k++;
			}
		}
		return k;
	}
	
	
	public static void main(String[] args) {
		int[] A = {2,-2,-3,3};
		int[] B = {0,0,4,-4};
		System.out.println(solution(A,B));
	}
	
}
