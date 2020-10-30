package string;

/**
 * @author girish_lalwani
 *https://practice.geeksforgeeks.org/contest-problem/counting-letters/1/
 */
public class CountingLetters {

	 boolean isVowel(char ch){
	        ch = Character.toLowerCase(ch);
	        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
	            return true;
	        }
	        return false;
	    }

	    void Count_V_W(StringBuilder s, int n, int k) {
	        StringBuilder prevVowels = new StringBuilder();
	        int vowels=0; 
	        int consonants=0;
	        for(int i=0; i<k; i++){
	            char ch = s.charAt(0);
	            if(isVowel(ch)){
	                prevVowels.append(ch);
	                s.deleteCharAt(0);
	                s.append("ma");
	                vowels+=1;
	                consonants+=1;
	            }else{
	                s.deleteCharAt(0);
	                s.append('m');
	                if(ch!='m') {
	                	consonants+=1;	
	                }
	                int prevVowelsLen = prevVowels.length();
	                if(prevVowelsLen>0){
	                    s.append(prevVowels.toString());
	                    vowels+=prevVowelsLen;
	                }
	            }    
	        }
	        
	        System.out.println("String :"+s.toString()+" k:"+k);
	        int i=0;
	        while(n>k){
	            char ch = s.charAt(i++);
	            k++;
	            if(isVowel(ch)){
	               vowels++; 
	            }else{
	               consonants++; 
	            }
	        }
	        
	        //amamamaamaamaa
	        //abbmama, 5 2
	        System.out.println(vowels+" "+consonants);
	    }
    
    public static void main(String[] args) {
    	CountingLetters cl = new CountingLetters();
    	cl.Count_V_W(new StringBuilder("ababb"), 5, 7);
	}
	
}
