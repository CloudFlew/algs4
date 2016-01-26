package org.zhang.leetCode;

/**
 * LeetCode 62 A robot is located at the top-left corner of a m x n grid (marked
 * 'Start' in the diagram below).The robot can only move either down or right at
 * any point in time. The robotis trying to reach the bottom-right corner of the
 * grid (marked 'Finish' in the diagram below). How many possible unique paths
 * are there? Note: m and n will be at most 100.
 * https://leetcode.com/problems/unique-paths/
 * 
 * @author zhang
 *
 */
public class _62UniquePaths {
	static int[][] matrix = new int[100][100];

	static {
		matrix[0][0] = 1;
		for (int i = 1; i < 10; i++) {
			matrix[i][0] = 1;
			matrix[0][i] = 1;
		}
		for (int m = 1; m < 10; m++) {
			for (int n = 1; n < 10; n++) {
				matrix[m][n] = matrix[m][n - 1] + matrix[m - 1][n];
				System.out.print(matrix[m][n] + ", \t");
			}
			System.out.println("");
		}

	}

	// 自下而上把算出来的值存入二维数组中(100X100),然后直接取用
	public int uniquePaths(int m, int n) {
		return matrix[m - 1][n - 1];
	}

	// ------------------方法2------------------------------------------------
	// 递归的方法---最慢
	public int uniquePaths2(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		else
			return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	// ----------------方法3------------------------------------------------
	// 其实就是求二项式系数---最快
	public int uniquePaths3(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		if (m == 2 || n == 2)
			return m >= n ? m : n;
		if (m >= n)
			return (int) (f((long) m + n - 2, m - 1) / f((long) n - 1, 1));
		else
			return (int) (f((long) m + n - 2, n - 1) / f((long) m - 1, 1));
	}

	public static long f(long a, int b) {
		for (long i = a - 1L; i > b; i--)
			a *= (long) i;
		return a;
	}

	public static void main(String[] args) {
		// System.out.println(new UniquePaths62().uniquePaths(4,4)+" "+new
		// UniquePaths62().uniquePaths3(4,4));
		// System.out.println(f(13L,2));
		System.out.println(10 % 3);
	}
}
