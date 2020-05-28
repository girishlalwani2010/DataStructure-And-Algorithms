package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author girish_lalwani https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums2.length == 0 || nums1.length == 0)
			return new int[0];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], -1);
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(nums2[0]);
		for (int i = 1; i < nums2.length; i++) {
			while (!stack.isEmpty() && nums2[i] > stack.peek()) {
				int element = stack.pop();
				if (map.containsKey(element)) {
					map.put(element, nums2[i]);
				}
			}
			stack.push(nums2[i]);
		}
		int res[] = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}
		return res;
	}

	/**
	 * @param nums1
	 * @param nums2
	 * @return
	 * As Stack is Deprecated
	 */
	public int[] nextGreaterElementUsingList(int[] nums1, int[] nums2) {
		if (nums2.length == 0 || nums1.length == 0)
			return new int[0];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], -1);
		}
		List<Integer> stack = new LinkedList<>();
		stack.add(0, nums2[0]);
		for (int i = 1; i < nums2.length; i++) {
			while (!stack.isEmpty() && nums2[i] > stack.get(0)) {
				int element = stack.remove(0);
				if (map.containsKey(element)) {
					map.put(element, nums2[i]);
				}
			}
			stack.add(0, nums2[i]);
		}
		int res[] = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}
		return res;
	}

}
