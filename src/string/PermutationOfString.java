package string;

import java.util.Arrays;

class PermutationOfString {
	public static void main (String[] args) {
		String str = "ABCD";
		permutation(str);
	}
	
	private static void printAllPermutations(String str) {
        if (str == null) return;
        printAllPermutations(str.toCharArray(), 0);
    }

    private static void printAllPermutations(char[] arr, int i) {
        if (i < arr.length) {
            for (int k = i; k < arr.length; ++k) {
                swap(arr, i, k);
                System.out.println("Input to Recursion :" +new String(arr)+ " i:"+i+" k:"+k);
                printAllPermutations(arr, i+1);
                System.out.println("Output to Recursion :" +new String(arr)+ " i:"+i+" k:"+k);
                swap(arr, i, k);
            }
        } else {
            print(arr);
            System.out.println();
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(char[] arr) {
        for (char ch : arr) {
            System.out.print(ch);
        }
    }
    
    private static void permutation(String prefix, String str) {
    	int n = str.length();
    	if(n==0) {
    		System.out.println(prefix);
    	}else {
    		for(int i=0; i<n; i++) {
    			permutation(prefix+str.charAt(i), str.substring(0, i)+str.substring(i+1));
    		}
    	}
    }
    
    public static void permutation(String str) { 
        permutation("", str); 
    }

}