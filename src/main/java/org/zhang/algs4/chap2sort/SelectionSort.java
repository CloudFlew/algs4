package org.zhang.algs4.chap2sort;

import static org.zhang.algs4.chap2sort.TemplateSort.*;

//import edu.princeton.cs.algs4.In;

/**选择排序
 * @author zhang
 *
 */
public class SelectionSort{
	
	static public void sort(Comparable<?>[] a){
		for (int i = 0; i < a.length-1; i++) {
			int min=i;
			for (int j = i+1; j < a.length; j++) {
				if(less(a[j],a[min]))min=j; 
			}
			exch(a,i,min);
		}
	}
	
	public static void main(String[] args) {

	}
}
