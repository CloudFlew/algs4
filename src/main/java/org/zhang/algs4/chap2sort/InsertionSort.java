package org.zhang.algs4.chap2sort;

import static org.zhang.algs4.chap2sort.TemplateSort.*;

import java.lang.reflect.Method;


/**插入排序
 * @author zhang
 *
 */
public class InsertionSort {

	public static void sort(Comparable<?>[] a) {
		for (int i = 1; i < a.length; i++) {
			// show(a);
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
		}
	}
	public static void sort(Comparable<?>[] a,int lo,int hi) {
		for (int i = lo+1; i < hi+1; i++) {
			// show(a);
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
		}
	}

	// 重复运行时，第三次以后用时明显减少1/3，可能是java缓存了Double对象t和m。
	@SuppressWarnings("rawtypes")
	public static void sort3(Comparable<?>[] a) {
		Comparable t;
		for (int i = 1; i < a.length; i++) {
			t = a[i];
			int j = i;
			for (; j > 0 && less(t, a[j - 1]); j--) {
				a[j] = a[j - 1];
			}
			a[j] = t;
		}
		System.out.println(isSorted(a));
	}

	public static void sort5(Comparable<?>[] a) {
		Comparable t;
		Comparable m;
		for (int i = 1; i < a.length; i++) {
			t = a[i];
			for (int j = i; j > 0; j--) {
				m=a[j-1];
				if (less(t, m))
					a[j] = m;
				else {
					a[j] = t;
					break;
				}
			}
		}
	}

	//数组较大时 性能最好
	public static void sort4(Comparable<?>[] a) {
		int N = a.length;
		int min = 0;
		for (int i = 1; i < N; i++) {
			if (less(a[i], a[min]))
				min = i;
		}
		exch(a, 0, min);
		for (int i = 1; i < a.length; i++) {
			Comparable t = a[i];
			int j = i;
			for (; less(t, a[j - 1]); j--) {
				a[j] = a[j - 1];
			}
			a[j] = t;
		}
//		System.out.println(isSorted(a));
	}
	public static void sort6(Comparable<?>[] a) {
		int N = a.length;
		int min = 0;
		for (int i = 1; i < N; i++) {
			if (less(a[i], a[min]))
				min = i;
		}
		exch(a, 0, min);
		for (int i = 1; i < a.length; i++) {
			Comparable t = a[i];
			int j = i;
			for (; less(t, a[j - 1]); j--) {
				a[j] = a[j - 1];
			}
			a[j] = t;
		}
		System.out.println(isSorted(a));
	}

	// 把最小值放到a[0]，作为哨兵，去掉一个内循环判断条件
	public static void sort2(Comparable<?>[] a) {
		int N = a.length;
		int min = 0;
		for (int i = 1; i < N; i++) {
			if (less(a[i], a[min]))
				min = i;
		}
		exch(a, 0, min);
		for (int i = 2; i < N; i++) {
			// show(a);
			for (int j = i; less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
		}
		System.out.println(isSorted(a));
	}

	// 方法参数为基本数据类型数组
	// public static void sort3(double[] a) {
	// int N = a.length;
	// int min = 0;
	// for (int i = 1; i < N; i++) {
	// if (a[i] < a[min])
	// min = i;
	// }
	// double t = a[0];
	// a[0] = a[min];
	// a[min] = t;
	// for (int i = 2; i < N; i++) {
	// // show(a);
	// for (int j = i; a[j]< a[j - 1]; j--) {
	// t = a[j];
	// a[j] = a[j-1];
	// a[j-1] = t;
	// }
	// }
	// }

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("org.zhang.algs4.chap2sort.InsertionSort");
		Method m = c.getDeclaredMethod("sort5", Comparable[].class);
		for (int i = 0; i < 10; i++) {
			Double[] a = SortCompare.getDoubleArray(15);
			Double[] b = a.clone();
			long st = System.currentTimeMillis();
			m.invoke(null, (Object) b);
			long end = System.currentTimeMillis();
			System.out.println((end - st) / 1000.0);
		}
	}
}
