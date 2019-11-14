package algo.randomnumbers;

import java.util.Random;

/**
 * @author girish_lalwani
 *
 *https://www.youtube.com/watch?v=KAZM4tsH8aI
 *https://leetcode.com/problems/random-pick-with-weight/
 */
public class RandomPickWithWeight {
    
    int[] weightedArray; 
    Random random;
    public RandomPickWithWeight(int[] w) {
        int totalWeight = 0;
        for(int i=0; i<w.length; i++){
            totalWeight = totalWeight + w[i];
        }
        weightedArray = new int[totalWeight];
        int j=0;
        for(int i=0; i<w.length; i++){
            int iThWeight = w[i];
            while(iThWeight>0){
              weightedArray[j++] = i; 
                iThWeight--;
            }
        }
        random = new Random();
    }
    
    public int pickIndex() {
        int randomNumber = random.nextInt(weightedArray.length);
        return weightedArray[randomNumber];
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */