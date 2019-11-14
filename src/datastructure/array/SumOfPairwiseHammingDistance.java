package datastructure.array;

import java.util.Arrays;
import java.util.List;

public class SumOfPairwiseHammingDistance {
	
	public int hammingDistance(final List<Integer> A) {
		long  hammingDistance = 0;
		for(int i=0; i<32; i++) {
			int count=0;
			for(Integer integer:A) {
				int base = 1 << i;
				if((integer & base) == base) {
					count++;
				}
			}
			hammingDistance = (hammingDistance + 2*count*(A.size() - count))%1000000007;
		}
		return (int)hammingDistance;
    }
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,3,5);
		SumOfPairwiseHammingDistance sumOfPairwiseHammingDistance = new SumOfPairwiseHammingDistance();
		System.out.println(sumOfPairwiseHammingDistance.hammingDistance(list));
				
	}

}
