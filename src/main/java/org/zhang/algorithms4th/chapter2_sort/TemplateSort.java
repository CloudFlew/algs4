package org.zhang.algorithms4th.chapter2_sort;

/*一个模版类，提供比较，交换元素等静态方法，其他sort类可以静态导入*/
 public class TemplateSort {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected static boolean less(Comparable v,Comparable<?> w){
		return v.compareTo(w)<0;
	}
	
	@SuppressWarnings("rawtypes")
	protected static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	@SuppressWarnings("rawtypes")
	protected static void show(Comparable[] a){
		for (Comparable c : a) {
//			StdOut.print(c+" ");
			System.out.print(c+" ");
		}
		System.out.println("");
	}
	
	protected static boolean isSorted(Comparable<?>[] a){
		for (int i = 1; i < a.length; i++) {
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
}
