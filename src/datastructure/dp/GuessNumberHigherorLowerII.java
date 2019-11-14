package datastructure.dp;

public class GuessNumberHigherorLowerII {
	
	public static int calculate(int low, int high) {
		System.out.println("calculate(low,high) "+"["+low+","+high+"]");
        if (low >= high)
            return 0;
        int minres = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));
            minres = Math.min(res, minres);
        }

        return minres;
    }
    public static int getMoneyAmount(int n) {
        return calculate(1, n);
    }
    
    public static void main(String[] args) {
		System.out.println(getMoneyAmount(3));
	}
	
}

