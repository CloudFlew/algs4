package org.zhang.algs4.chap2sort;

import java.util.*;

/**LeetCode算法题:一个数组中每个数字都出现两次，只有一个出现一次，请找出它来。
 * 第一种方法利用递归,类似二分查找,算法复杂度O(N).第二种是网上找到,用的异或,速度略快一点.
 * @author cloud
 *
 */
public class SingleNumber {

	public int singleNumber2(int[] nums) {
		int x=0;
		for(int a:nums){
			x^=a;
		}
		return x;
	}

	
	Random random;
	int bingo;
//	static int count;//元素总的比较次数---O(n)
//	static int count2;//总的交换次数---O(n)
	
	public int singleNumber(int[] nums) {
		random = new Random();
		find(nums, 0, nums.length - 1);
//		System.out.println("count:"+count+"count2:"+count2);
//		count=0;
//		count2=0;
		return bingo; 
	}

	private void find(int[] a, int lo, int hi) {
		if (hi == lo) {
			bingo = a[hi];
			return;
		}
		
		int rd = lo + random.nextInt(hi - lo + 1);
		int mid = a[rd];
		int i = lo - 1;
		int j = hi + 1;
		while (true) {
			while (mid > a[++i])
//				count2++;
			while (a[--j] >= mid)
//				count2++;
				if (j == lo)
					break;
			if (i >= j)
				break;
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
//			count++;
		}
		if (j < i) {
			if (((j - lo) & 1) == 0)
				find(a, lo, j);
			else
				find(a, j + 1, hi);

		} else {
			find(a, lo, hi);
		}
	}

	public static void main(String[] args) {
		Random rd = new Random();
		HashSet<Integer> h = new HashSet<>();
		while (true) {
			h.add(rd.nextInt());
			if (h.size() == 10000000)
				break;
		}
		List<Integer> l = new ArrayList<>();
		l.addAll(h);
		l.addAll(h);
		int[] a = new int[19999999];
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
		SingleNumber s = new SingleNumber();
		for (int i = 0; i < 5; i++) {
			int[] b=a.clone();
			int[] c=a.clone();
			long st = System.currentTimeMillis();
			int rs = s.singleNumber(b);
			
			long end = System.currentTimeMillis();
			long st2 = System.currentTimeMillis();
			int rs2 = s.singleNumber2(c);
			
			long end2 = System.currentTimeMillis();
			double time = (end - st) / 1000.0;
			double time2 = (end2 - st2) / 1000.0;
			 System.out.println("expect" + l.get(19999999) + " return:" + rs + rs2 +
			 " time:" + time +" time2: "+time2);
		}
	}
}
