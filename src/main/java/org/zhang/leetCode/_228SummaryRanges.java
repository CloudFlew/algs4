package org.zhang.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class _228SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		String mid = "->";
		String result = null;
		boolean flag = false;
		List<String> list = new ArrayList<>();
		for (int i = 0; i < nums.length - 1; i++) {
			// System.out.println(nums[i+1]+" "+nums[i]);
			if (nums[i + 1] == nums[i] + 1) {
				if (!flag) {
					result = String.valueOf(nums[i]) + mid;
					// System.out.println(result);
				}
				flag = true;
			} else {
				if (flag) {
					result = result + String.valueOf(nums[i]);
					list.add(result);
					flag = false;
				} else {
					list.add(String.valueOf(nums[i]));
				}
			}
		}
		if (!flag) {
			list.add(String.valueOf(nums[nums.length - 1]));
		} else {
			list.add(result + String.valueOf(nums.length - 1));
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 4, 5, 7, 8, 9, 11, 14, 15, 16, 22 };
		System.out.println(summaryRanges(nums));
	}
}
