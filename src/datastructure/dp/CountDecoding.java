package datastructure.dp;

public class CountDecoding {
	static int countDecodingDP(char[] digits , int n)
	{
	    int count[] = new int[n+1]; // A table to store results of subproblems
	    count[0] = 1;
	    count[1] = 1;
	 
	    for (int i = 2; i <= n; i++)
	    {
	       // count[i] = 0;
	 
	        // If the last digit is not 0, then last digit must add to
	        // the number of words
	        if (digits[i-1] > '0')
	            count[i] = count[i-1];
	 
	        // If second last digit is smaller than 2 and last digit is
	        // smaller than 7, then last two digits form a valid character
	        if (digits[i-2] < '2' || (digits[i-2] == '2' && digits[i-1] < '7') )
            {
        		count[i] += count[i-2];
            }
	    }
	    return count[n];
	}
	
	public static void main(String[] args) {
		
		// Try to understand this with below two examples, ACCORDING TO THE NOTES
		
		char[] digits = {'1','2','2','1'};
		System.out.println(countDecodingDP(digits, digits.length));
		
	}
}

