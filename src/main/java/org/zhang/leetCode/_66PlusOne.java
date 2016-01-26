package org.zhang.leetCode;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 *
 */
public class _66PlusOne {

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i] += 1;
				break;
			}
		}
		if (digits[0] == 0) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] i = { 9, 9, 9, 9, 9 };
		System.out.println(Arrays.toString(plusOne(i)));
	}
}
