package dfs;

import java.util.ArrayList;
import java.util.List;

public class Game24 {

	public boolean judgePoint24(int[] nums) {
		List<Double> A = new ArrayList<>();
		for (int v : nums)
			A.add((double) v);
		return solveNew(A);
	}
	
public boolean solve(List<Double> doubleNums){
        
        
		if (doubleNums.size() == 0)
			return false;
        
        if(doubleNums.size()==1){
            return doubleNums.get(0)==24;
        }
        
        for(int i=0; i<doubleNums.size(); i++){
            for(int j=0; j<doubleNums.size(); j++){
                if(i==j){
                    continue;
                }
                // new-set is created all time and will act as shrink list 
                // like this 4*1*8*7 ---> 4*8*7 --> 32*7 --> 224, created just for simplicity 
                // but will require when new set start will change, like for 1,4,8,7. 
                List<Double> newSet = new ArrayList<>();
                //Number Choosen, choose the operator
                for(int k=0; k<4; k++){
                    if (k < 2 && j > i)
						continue;
                    if(k==0) {
                        newSet.add((doubleNums.get(i) + doubleNums.get(j)));   
                    }else if(k==1){
                        newSet.add((doubleNums.get(i) * doubleNums.get(j)));   
                    }else if(k==2){
                        newSet.add((doubleNums.get(i) - doubleNums.get(j)));   
                    }else{
                        if (doubleNums.get(j) != 0){
                            newSet.add((doubleNums.get(i) / doubleNums.get(j)));    
                        }else{
                            continue;
                        }
                           
                    }
                  for (int l = 0; l < doubleNums.size(); l++) {
                        if (l != i && l != j) {
                            newSet.add(doubleNums.get(l));
                        }
                   }
                   if(solve(newSet)){
                       return true;
                   } 
                }
            }
        }
        return false;
    }

	boolean solveNew(List<Double> nums) {

		if (nums.size() == 0)
			return false;
		if (nums.size() == 1)
			return Math.abs(nums.get(0) - 24) < 1e-6;

		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < nums.size(); j++) {
				if (i != j) {
					for (int k = 0; k < 4; k++) {
						if (k < 2 && j > i)
							continue;
						List<Double> shrinkedList = new ArrayList<>();
						if (k == 0) {
							shrinkedList.add(nums.get(i) + nums.get(j));
						} else if (k == 1) {
							shrinkedList.add(nums.get(i) * nums.get(j));

						} else if (k == 2) {
							shrinkedList.add(nums.get(i) - nums.get(j));
						} else {
							if (nums.get(j) != 0) {
								shrinkedList.add(nums.get(i) / nums.get(j));
							} else {
								continue;
							}
						}

						for (int l = 0; l < nums.size(); l++) {
							if (l != i && l != j) {
								shrinkedList.add(nums.get(l));
							}
						}

						if (solveNew(shrinkedList))
							return true;
					}

				}
			}
		}
		return false;
	}

	boolean solveBetter(List<Double> nums) {

		if (nums.size() == 0)
			return false;
		if (nums.size() == 1)
			return Math.abs(nums.get(0) - 24) < 1e-6;

		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < nums.size(); j++) {
				if (i != j) {
					List<Double> shrinkedList = new ArrayList<>();
					for (int l = 0; l < nums.size(); l++) {
						if (l != i && l != j) {
							shrinkedList.add(nums.get(l));
						}
					}
					for (int k = 0; k < 4; k++) {
						if (k < 2 && j > i)
							continue;
						if (k == 0) {
							shrinkedList.add(nums.get(i) + nums.get(j));
						} else if (k == 1) {
							shrinkedList.add(nums.get(i) * nums.get(j));

						} else if (k == 2) {
							shrinkedList.add(nums.get(i) - nums.get(j));
						} else {
							if (nums.get(j) != 0) {
								shrinkedList.add(nums.get(i) / nums.get(j));
							} else {
								continue;
							}
						}

						if (solve(shrinkedList))
							return true;
						//done with this result so remove it not needed as for example , 4*1*8*7 ---> 4*8*7 --> 32*7 --> 224 not needed to store it -- > just try to compute  32 different operator 7
						shrinkedList.remove(shrinkedList.size()-1);
					}

				}
			}
		}
		return false;
	}

	public boolean judgePoint24Best(int[] nums) {
		return func(new double[] { nums[0], nums[1], nums[2], nums[3] });
	}

	private boolean func(double[] a) {
		if (a.length == 1) {
			return Math.abs(a[0] - 24) <= 1e-10;
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				double[] b = new double[a.length - 1];
				for (int k = 0, l = 0; k < a.length; k++) {
					if (k != i && k != j) {
						b[l++] = a[k];
					}
				}
				for (double k : compute(a[i], a[j])) {
					b[a.length - 2] = k;
					if (func(b)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private double[] compute(double a, double b) {
		return new double[] { a + b, a - b, b - a, a * b, a / b, b / a };
	}

	public static void main(String[] args) {
		Game24 game24 = new Game24();
		int[] nums = { 4, 1, 8, 7 };
		System.out.println(game24.judgePoint24(nums));
	}

}
