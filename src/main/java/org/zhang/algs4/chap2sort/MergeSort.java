package org.zhang.algs4.chap2sort;

/**归并排序
 * @author zhang
 *
 */
public class MergeSort {
	
	static Comparable[] b;
	
	public static void sort(Comparable[] a){
		b=new Comparable[a.length];
		sort(a,0,a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo>=hi) return;
		int mid=(lo+hi)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,hi);
	}

	private static void merge(Comparable[] a, int lo, int hi) {
		int mid=(lo+hi)/2;
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<hi+1;k++){
			b[k]=a[k];
		}
		for(int k=lo;k<hi+1;k++){
			if(i>mid) 				 a[k]=a[j++];
			else if(j>hi)			 a[k]=a[i++];
			else if(less(a[i],a[j])) a[k]=a[i++];
			else					 a[k]=a[j++];
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w)<0;
	}
}
