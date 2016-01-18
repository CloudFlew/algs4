package org.zhang.algs4.chap2sort;

import java.util.Stack;

/**快速排序,提供了递归和非递归的实现
 * @author zhang
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		Double[] a={0.01,0.02,0.03,0.04,0.05,0.02,0.03,0.04,0.05,0.02,0.01,0.02,0.03,0.04,0.05,0.02,0.03,0.04};
		loopSort(a);
		System.out.println(isSorted(a));
	}

	/**快排的非递归实现
	 * @param a
	 */
	public static void loopSort(Comparable[] a){
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(0);
		stack.push(a.length-1);
		while(true){
			if(stack.isEmpty()) break;
			int hi=stack.pop();
			int lo=stack.pop();
//			if(lo>=hi){
//				InsertionSort.sort(a,lo,hi);
//				continue;
//			}
			int j=partition(a, lo, hi);
			if(j-lo>1){
				stack.push(lo);
				stack.push(j-1);
			}
			if(hi-j>1){
				stack.push(j+1);
				stack.push(hi);
			}
		}
	}
	public static void loopSort2(Comparable[] a){
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(0);
		stack.push(a.length-1);
		while(true){
			if(stack.isEmpty()) break;
			int hi=stack.pop();
			int lo=stack.pop();
			if(lo>=hi){
//				InsertionSort.sort(a,lo,hi);
				continue;
			}
			int j=partition(a, lo, hi);
				stack.push(lo);
				stack.push(j-1);
				stack.push(j+1);
				stack.push(hi);
		}
	}
	
	/**快排的递归实现，sort2/3/4/5是对此实现的优化
	 * @param a
	 */
	public static void sort(Comparable[] a) {
//		StdRandom.shuffle(a);
		
		sort(a, 0, a.length - 1);
//		System.out.println(isSorted(a));
	}

	public static void sort(Comparable[] a, int lo, int hi) {
 		if (lo >= hi)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	/* 设置哨兵，避免边界问题*/
	public static void sort2(Comparable[] a) {
//		StdRandom.shuffle(a);
		int N = a.length;

		// 将最大值放到数组最右边，作为哨兵
//		long st=System.currentTimeMillis();
		int max = 0;
		for (int i = 1; i < N; i++) {
			if (less(a[max], a[i]))
				max = i;
		}
		exch(a, max, N - 1);
//		long end=System.currentTimeMillis();
//		System.out.println("max:"+(end-st)/1000.0);
		
		sort2(a, 0, N - 1);
//		System.out.println(isSorted(a));
	}

	private static void sort2(Comparable[] a, int lo, int hi) {

		if (lo >= hi)
			return;
		int j = partition2(a, lo, hi);
		sort2(a, lo, j);
		sort2(a, j + 1, hi);
	}

	private static int partition2(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v))
				;
			while (less(v, a[--j]))
				;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}


	/*在子数组长度不大于12时，切换为插入排序*/
	public static void sort3(Comparable[] a) {
//		StdRandom.shuffle(a);
		sort3(a, 0, a.length - 1);
//		System.out.println(isSorted(a));
	}

	public static int M = 13;
	

	private static void sort3(Comparable[] a, int lo, int hi) {

		if (hi <= lo + M){
			InsertionSort.sort(a,lo,hi);
			return;
		}
		int j = partition(a, lo, hi);
		sort3(a, lo, j - 1);
		sort3(a, j + 1, hi);
	}
	
	

	/*三取样切分*/
	public static void sort4(Comparable[] a) {
//		StdRandom.shuffle(a);
		sort4(a, 0, a.length - 1);
//		System.out.println(isSorted(a));
	}
	
	private static void sort4(Comparable[] a, int lo, int hi) {
		
		if (hi <= lo + M){
//		if (hi <= lo ){
			InsertionSort.sort(a,lo,hi);
			return;
		}
		int j = partition4(a, lo, hi);
		sort3(a, lo, j - 1);
		sort3(a, j + 1, hi);
	}
	
	private static int partition4(Comparable[] a, int lo, int hi) {
		
		int i = lo;
		if(less(a[lo+1], a[lo])) exch(a, lo+1, lo);
		if(less(a[lo+1],a[lo+2])){
			exch(a, lo, lo+1);
		}else if(less(a[lo],a[lo+2])){
			exch(a, lo, lo+2);
		}
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	/*综合了哨兵，三取样，插入排序*/
	public static void sort5(Comparable[] a){
		int N = a.length;

		int max = 0;
		for (int i = 1; i < N; i++) {
			if (less(a[max], a[i]))
				max = i;
		}
		exch(a, max, N - 1);
		sort5(a, 0, a.length-1);
	}
	private static void sort5(Comparable[] a,int lo,int hi){
		if(lo+M>hi){
			insertionSort(a, lo, hi);
			return;
		}
		int j=partition5(a, lo, hi);
		sort5(a, lo, j);
		sort5(a, j+1, hi);
	}
	private static int partition5(Comparable[] a, int lo, int hi) {
		int i = lo;
		if(less(a[lo+1], a[lo])) exch(a, lo+1, lo);
		if(less(a[lo+1],a[lo+2])){
			exch(a, lo, lo+1);
		}else if(less(a[lo],a[lo+2])){
			exch(a, lo, lo+2);
		}
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v))
				;
			while (less(v, a[--j]))
				;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	//插入排序：外循环从大到小，默认数组最大值在最右侧，从而将其作为哨兵
	private static void insertionSort(Comparable[] a, int lo, int hi) {
		for(int i=hi-2;i>=lo;i--){
			for(int j=i;less(a[j+1],a[j]);j++){
				exch(a, j+1, j);
			}
		}
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static boolean isSorted(Comparable<?>[] a){
		for (int i = 1; i < a.length; i++) {
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
}
