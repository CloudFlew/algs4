package org.zhang.Other;

/**
 *  斐波那契数列的非递归实现
 *
 */
public class Fab {

	static int count=0;
	
	/* 自上而下,非递归的求解斐波那契数列,需要维护一个额外的数组,大小为 N+1
	 * 求解 fib(n) ,递归调用 f(n,a) 的次数为 n+1.所以,运行速度与 fib2 几乎一样
	 *  */
	public static int fib(int n) {
		int[] a = new int[n + 1];
		return f(n, a);
	}

	/* 自下而上,非递归地求解斐波那契数列,只需要维护三个 int 变量. */
	public static int fib2(int n) {
		int first = 0;
		int second = 1;
		int temp;
		if (n == 0)
			return first;
		if (n == 1)
			return second;
		for (int i = 0; i < n - 1; i++) {
			temp = second;
			second += first;
			first = temp;
		}
		return second;
	}

	private static int f(int n, int[] a) {
		count++;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (a[n] > 0) {
			return a[n];
		} else if (a[n - 2] > 0 && a[n - 1] > 0) {
			a[n] = a[n - 2] + a[n - 1];
			return a[n];
		} else {
			a[n - 2] = f(n - 2, a);
			a[n - 1] = f(n - 1, a);
			a[n] = a[n - 2] + a[n - 1];
			return a[n];
		}
	}

	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		for (int i = 0; i < 10; i++)
			System.out.println(fib(46));
		long en = System.currentTimeMillis();
		System.out.println("fib 用时: "+(en-st)/1000.0);
		
		long st2 = System.currentTimeMillis();
		for (int i = 0; i < 100; i++)
			fib2(46);
		long en2 = System.currentTimeMillis();
		System.out.println("fib2 用时: "+(en2 - st2) / 1000.0);

	}
}
