package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author girish_lalwanim
 *
 *https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *https://www.youtube.com/watch?v=GCm7m5671Ps
 *See PermutationII code
 */
public class Permutations {
	
	/*
	  Permutations - LeetCode: https://leetcode.com/problems/permutations
	  This code passes all Leetcode test cases as of Sept. 3th 2019
	  Runtime: 1 ms, faster than 97.78% of Java online submissions for Permutations.
	  
	  The items in the array are guaranteed unique. If this were permutations involving
	  something like a string w/ non-unique characters we'd need to maintain a "working list"
	  of items still available to "be inserted" into the "slot" we are working on in the output.
	  
	  So for example:
	  
	  "slots"
	  
	  We want to place into a string to fulfill our conceptual "slots":
	  
	  "_ _ _ _"
	  
	  So to start:
	  
	  "_ _ _ _"
	   ^
	   
	   We choose from the set { "s", "l", "o", "t", "s" } for this first slot. We will literally
	   write a for loop to try each of these possible characters. Choose, explore (recurse), unchoose.
	   
	   Say we insert an "s":
	   
	  "s _ _ _"
	     ^
	   Now the set of items we will loop over to try in this "slot" is { "l", "o", "t", "s" }
	   
	   And so on, this is the core understanding of how our decision space changes after each decision/call
	   and is an intuition that can scale to all other recursive approaches.
	   
	   Recursion Tree
	   		 f(A__)
	   	   f(AB_)
	     f(ABC)
	   f(ABC)
	  f(Terminator)
	   
	*/

	public List<List<Integer>> permute(int[] originalArray) {
	  List<List<Integer>> allPermutations = new ArrayList<>();
	  generateAllPermutations(new ArrayList<>(), originalArray, allPermutations);
	  return allPermutations;
	}

	private void generateAllPermutations(
	  List<Integer> runningChoices,
	  int[] originalArray,
	  List<List<Integer>> allPermutations
	) {
	  if (runningChoices.size() == originalArray.length) {
	    allPermutations.add(new ArrayList<>(runningChoices));
	    return;
	  }

	  /*
	    Every stack frame of this function call represents the expression of trying (almost) all items in every "slot" in the array.
	    The recursion stops when we are choosing on 1 past the final "slot".
	  */
	  for (int i = 0; i < originalArray.length; i++) {
	    int choice = originalArray[i];

	    // Skip if element already exists in 'runningChoices'
	    if (runningChoices.contains(choice)) {
	      continue;
	    }

	    // 1.) Choose - Add the item to the 'runningChoices'
	    runningChoices.add(choice);

	    // 2.) Explore - Recurse on the choice
	    generateAllPermutations(runningChoices, originalArray, allPermutations);

	    // 3.) Unchoose - We have returned from the recursion, remove the choice we made.
	    // The next iteration will try another item in the "slot" we are working on.
	    runningChoices.remove(runningChoices.size() - 1);
	  }
	}
	
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3};
		Permutations permutations = new Permutations();
		permutations.permute(numbers);
	}

}
