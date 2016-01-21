package org.zhang.algorithms4th.chapter2_sort;

import static org.zhang.algorithms4th.chapter2_sort.TemplateSort.*;
/**希尔排序
 * @author zhang
 *
 */
public class ShellSort {
	private static final int[] SQUENCE;
	
	static {//计算出递增序列h，到第28位1073643521
		SQUENCE=new int[28];
		for (int i = 0 ; i < 14; i++) {
			
			int a=9*pow(4, i)-9*pow(2,i)+1;
//			System.out.println(a);
			SQUENCE[i*2]=a;
			int b=pow(4, i+2)-3*pow(2, i+2)+1;
//			System.out.println(b);
			SQUENCE[i*2+1]=b;
		}
	}
	
	/**一个乘方函数:  a的b次方，b>0
	 * @param a 底数
	 * @param b 指数
	 * @return a的b次方
	 */
	private static int pow(int a,int b){
		int product=1;
		for (int i = 0; i < b; i++) {
			product*=a;
		}
		return product;
	}
	//按照3幂次递增的h
	public static void sort2(Comparable<?>[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = h * 3 + 1;// h=1,4,13,40,121,364,1093...
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			h = h / 3;
		}
	}
	
	//通过给定的h序列排序
	public static void sort(Comparable<?>[] a){
		int N=a.length;
		int S=SQUENCE.length;
		for (int i=S-1;i>=0;i--) {
 			int h=SQUENCE[i];
			if(h<N/3){
				for(int j=h;j<N;j++){
					for(int k=j;k>=h&&less(a[k], a[k-h]);k-=h)
						exch(a, k, k-h);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
