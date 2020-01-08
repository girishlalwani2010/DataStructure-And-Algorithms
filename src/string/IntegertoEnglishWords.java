package string;

public class IntegertoEnglishWords {

	private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		return helper(num).trim();
	}
	
	public String helper(int num) {
		if(num<20) {
			return LESS_THAN_20[num];
		}else if(num<100) {
			return (TENS[num/10] +" "+LESS_THAN_20[num%10]).trim();
		}else if(num<1000) {
			return (helper(num/100) + " Hundred " + helper(num%100)).trim();
		}else if(num<1000000) {
			return (helper(num/1000) + " Thousand " + helper(num%1000)).trim();
		}else if(num<1000000000) {
			return (helper(num/1000000) + " Million " + helper(num%1000000)).trim();
		}else {
			return (helper(num/1000000000) + " Billion " + helper(num%1000000000)).trim();
		}
		
	}

}
