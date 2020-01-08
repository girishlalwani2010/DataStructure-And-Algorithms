package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

List<List<Integer>> result = null;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        int sum = 0;
        combinationSum(candidates, target, sum, new ArrayList<>(), 0);
        return result;        
    }
    
    public void combinationSum(int[] candidates, int target, int sum, List<Integer> currList, int start){
        
        if(sum == target){
            result.add(new ArrayList<>(currList)); 
            return;   
        }
        
        for(int i=start; i<candidates.length; i++){
            //choose
            //explore
            //unchoose
            sum = sum+candidates[i];
            if(sum>target){
                return;
            }
            currList.add(candidates[i]);
            combinationSum(candidates, target, sum, currList, i);
            sum = sum-candidates[i];
            currList.remove(currList.size()-1);
            
        }
        
    }
    
}
