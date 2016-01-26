package org.zhang.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.lang.Integer;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 *
 */
public class _1TwoSum {

	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
		Map<Integer, Integer> container = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int dif = target - nums[i];
			if (!container.containsKey(dif)) {
				container.put(nums[i], i);
			} else {
				result[0] = container.get(dif) + 1;
				result[1] = i + 1;
				break;
			}
		}
		return result;
    }

	public static void main(String[] args) {
		int[] array = { 2, 23, 1, 7, 12, 45, 65, 3, 87 };
		System.out.println(Arrays.toString(twoSum(array, 9)));
	}
}
